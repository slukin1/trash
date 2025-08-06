package com.mob.mcl.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.mob.MobSDK;
import com.mob.commons.v;
import com.mob.commons.z;
import com.mob.mcl.b.a;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.UIHandler;
import com.mob.tools.utils.e;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f27438a;

    /* renamed from: b  reason: collision with root package name */
    private Context f27439b = MobSDK.getContext();

    /* renamed from: c  reason: collision with root package name */
    private int f27440c = -1;

    /* renamed from: d  reason: collision with root package name */
    private ScheduledExecutorService f27441d;

    /* renamed from: e  reason: collision with root package name */
    private ScheduledFuture f27442e;

    private b() {
        v.a(d(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f27441d = Executors.newSingleThreadScheduledExecutor();
    }

    private BroadcastReceiver d() {
        return new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                try {
                    z.f27384c.execute(new Runnable() {
                        public void run() {
                            try {
                                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                                    DH.requester(context).getDetailNetworkTypeForStatic().request(new DH.DHResponder() {
                                        public void onResponse(DH.DHResponse dHResponse) {
                                            int i11;
                                            String detailNetworkTypeForStatic = dHResponse.getDetailNetworkTypeForStatic();
                                            com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
                                            a11.b("TP HB receive network: " + detailNetworkTypeForStatic);
                                            if ("wifi".equalsIgnoreCase(detailNetworkTypeForStatic)) {
                                                i11 = 1;
                                            } else if ("5G".equalsIgnoreCase(detailNetworkTypeForStatic)) {
                                                i11 = 5;
                                            } else if ("4G".equalsIgnoreCase(detailNetworkTypeForStatic)) {
                                                i11 = 4;
                                            } else if ("3G".equalsIgnoreCase(detailNetworkTypeForStatic)) {
                                                i11 = 3;
                                            } else {
                                                i11 = "2G".equalsIgnoreCase(detailNetworkTypeForStatic) ? 2 : 0;
                                            }
                                            b.this.a(i11);
                                        }
                                    });
                                }
                            } catch (Throwable th2) {
                                com.mob.mcl.d.b.a().a(th2);
                            }
                        }
                    });
                } catch (Throwable th2) {
                    com.mob.mcl.d.b.a().a(th2);
                }
            }
        };
    }

    public void b() {
        try {
            c();
            this.f27442e = this.f27441d.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    try {
                        if (!h.b().c() || !h.b().a(2000, 0)) {
                            b.this.a((e<Void>) new e<Void>() {
                                public void a(Void voidR) {
                                }
                            });
                        } else {
                            com.mob.mcl.d.b.a().b("TP HB tcp send ping success");
                        }
                    } catch (Throwable unused) {
                    }
                }
            }, 0, (long) h.b().f27471e, TimeUnit.SECONDS);
        } catch (Throwable th2) {
            com.mob.mcl.d.b.a().a("TP HB timer error", th2);
        }
    }

    public boolean c() {
        try {
            ScheduledFuture scheduledFuture = this.f27442e;
            if (scheduledFuture == null) {
                return false;
            }
            boolean cancel = scheduledFuture.cancel(true);
            com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
            a11.b("TP HB cancel: " + cancel);
            return cancel;
        } catch (Throwable th2) {
            com.mob.mcl.d.b.a().a(th2);
            return false;
        }
    }

    public static b a() {
        if (f27438a == null) {
            synchronized (b.class) {
                if (f27438a == null) {
                    f27438a = new b();
                }
            }
        }
        return f27438a;
    }

    /* access modifiers changed from: private */
    public void a(int i11) {
        com.mob.mcl.d.b a11 = com.mob.mcl.d.b.a();
        a11.b("TP HB onNetworkChanged: " + i11 + ", last: " + this.f27440c);
        if (this.f27440c == -1) {
            this.f27440c = i11;
            return;
        }
        this.f27440c = i11;
        if (i11 == 0) {
            return;
        }
        if (h.b().c()) {
            com.mob.mcl.d.b.a().b("TP HB tcp status: true");
        } else {
            UIHandler.sendEmptyMessageDelayed(0, 200, new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    a.f27412a.execute(new Runnable() {
                        public void run() {
                            try {
                                if (!h.b().c()) {
                                    if (!h.b().d()) {
                                        h.b().f();
                                    }
                                    com.mob.mcl.d.b.a().b("TP HB reg tcp");
                                    h.b().a((e<Boolean>) new e<Boolean>() {
                                        public void a(Boolean bool) {
                                        }
                                    });
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final e<Void> eVar) {
        if (!h.b().d()) {
            h.b().f();
        }
        h.b().a((e<Boolean>) new e<Boolean>() {
            public void a(Boolean bool) {
                e eVar = eVar;
                if (eVar != null) {
                    eVar.a(null);
                }
            }
        });
    }
}
