package cn.sharesdk.framework.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.ShareSDKCallback;
import cn.sharesdk.framework.a.b.b;
import cn.sharesdk.framework.a.b.c;
import cn.sharesdk.framework.a.b.e;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.f;
import com.mob.MobSDK;
import com.mob.commons.CSCenter;
import com.mob.commons.SHARESDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.util.Calendar;

public class d extends f {

    /* renamed from: b  reason: collision with root package name */
    private static d f13384b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f13385c = a.a();

    /* renamed from: d  reason: collision with root package name */
    private Handler f13386d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13387e;

    /* renamed from: f  reason: collision with root package name */
    private long f13388f;

    /* renamed from: g  reason: collision with root package name */
    private File f13389g;

    /* renamed from: h  reason: collision with root package name */
    private FileLocker f13390h = new FileLocker();

    private d() {
        File file = new File(MobSDK.getContext().getFilesDir(), ".statistics");
        this.f13389g = file;
        if (!file.exists()) {
            try {
                this.f13389g.createNewFile();
            } catch (Exception e11) {
                SSDKLog.b().a((Throwable) e11);
            }
        }
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f13384b == null) {
                f13384b = new d();
            }
            dVar = f13384b;
        }
        return dVar;
    }

    public void b(c cVar) {
        try {
            if (MobSDK.isMob() && this.f13387e) {
                a(cVar, new ShareSDKCallback<c>() {
                    /* renamed from: a */
                    public void onCallback(c cVar) {
                        if (cVar.g()) {
                            Message message = new Message();
                            message.what = 3;
                            message.obj = cVar;
                            try {
                                d.this.f13521a.sendMessage(message);
                            } catch (Throwable th2) {
                                SSDKLog.b().a(th2);
                            }
                        } else {
                            SSDKLog b11 = SSDKLog.b();
                            b11.a("Drop event: " + cVar.toString(), new Object[0]);
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            SSDKLog b11 = SSDKLog.b();
            b11.a("logStart " + th2, new Object[0]);
        }
    }

    public void c(Message message) {
        if (this.f13387e) {
            e eVar = new e();
            eVar.f13353a = System.currentTimeMillis() - this.f13388f;
            a((c) eVar);
            this.f13387e = false;
            try {
                this.f13386d.sendEmptyMessage(1);
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
            f13384b = null;
            this.f13521a.getLooper().quit();
        }
    }

    public void a(Handler handler) {
        this.f13386d = handler;
    }

    public void a(Message message) {
        if (!this.f13387e) {
            this.f13387e = true;
            try {
                this.f13390h.setLockFile(this.f13389g.getAbsolutePath());
                if (this.f13390h.lock(false)) {
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                d.this.f13385c.a(DeviceAuthorizer.authorize(new SHARESDK()));
                            } catch (Exception e11) {
                                SSDKLog.b().a((Throwable) e11);
                            }
                        }
                    }).start();
                    this.f13385c.a((ShareSDKCallback<Boolean>) new ShareSDKCallback<Boolean>() {
                        /* renamed from: a */
                        public void onCallback(Boolean bool) {
                            if (bool != null && bool.booleanValue()) {
                                d.this.f13385c.a(d.this.f13521a);
                            }
                        }
                    });
                }
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        }
    }

    public void b(Message message) {
        int i11 = message.what;
        if (i11 == 2) {
            try {
                DH.requester(MobSDK.getContext()).getNetworkType().request(new DH.DHResponder() {
                    public void onResponse(DH.DHResponse dHResponse) {
                        String networkType = dHResponse.getNetworkType();
                        if (!"none".equals(networkType) && !TextUtils.isEmpty(networkType)) {
                            d.this.f13385c.b();
                        }
                    }
                });
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        } else if (i11 == 3) {
            Object obj = message.obj;
            if (obj != null) {
                c((c) obj);
                this.f13521a.removeMessages(2);
                this.f13521a.sendEmptyMessageDelayed(2, 2000);
            }
        } else if (i11 == 4) {
            long longValue = cn.sharesdk.framework.a.a.e.a().h().longValue();
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(longValue);
            int i12 = instance.get(1);
            int i13 = instance.get(2);
            int i14 = instance.get(5);
            instance.setTimeInMillis(System.currentTimeMillis());
            int i15 = instance.get(1);
            int i16 = instance.get(2);
            int i17 = instance.get(5);
            if (i12 != i15 || i13 != i16 || i14 != i17) {
                this.f13385c.a(this.f13521a);
            }
        }
    }

    private void c(c cVar) {
        try {
            boolean b11 = b();
            if (((cVar instanceof cn.sharesdk.framework.a.b.f) || (cVar instanceof b)) && !b11) {
                SSDKLog.b().b("SH AU LOG FALSE");
                return;
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            SSDKLog.b().a(cVar.toString(), new Object[0]);
            return;
        }
        this.f13385c.a(cVar);
        cVar.h();
    }

    public void a(final c cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() {
                public void run() {
                    d.this.b(cVar);
                }
            }.start();
        } else {
            b(cVar);
        }
    }

    private void a(final c cVar, final ShareSDKCallback<c> shareSDKCallback) {
        DH.requester(MobSDK.getContext()).getDeviceData().getDetailNetworkTypeForStatic().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    cVar.f13339f = DeviceAuthorizer.authorize(new SHARESDK());
                    cVar.f13340g = DH.SyncMtd.getPackageName();
                    cVar.f13341h = DH.SyncMtd.getAppVersion();
                    cVar.f13342i = String.valueOf(ShareSDK.SDK_VERSION_CODE);
                    cVar.f13343j = DH.SyncMtd.getPlatformCode();
                    cVar.f13344k = dHResponse.getDetailNetworkTypeForStatic();
                    if (TextUtils.isEmpty(MobSDK.getAppkey())) {
                        SSDKLog.b().b("ShareSDKCore", "Your appKey of ShareSDK is null , this will cause its data won't be count!");
                    } else if (!"cn.sharesdk.demo".equals(cVar.f13340g) && ("api20".equals(MobSDK.getAppkey()) || "androidv1101".equals(MobSDK.getAppkey()))) {
                        SSDKLog.b().b("ShareSDKCore", "Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
                    }
                    cVar.f13345l = dHResponse.getDeviceData();
                    shareSDKCallback.onCallback(cVar);
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            }
        });
    }

    private boolean b() {
        try {
            boolean isSocietyPlatformDataEnable = CSCenter.getInstance().isSocietyPlatformDataEnable();
            SSDKLog b11 = SSDKLog.b();
            b11.a("platformDataEnable:" + isSocietyPlatformDataEnable, new Object[0]);
            return isSocietyPlatformDataEnable;
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
            return true;
        }
    }
}
