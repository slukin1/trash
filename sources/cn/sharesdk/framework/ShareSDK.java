package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import cn.sharesdk.framework.a.a.e;
import cn.sharesdk.framework.loopshare.LoopSharePasswordListener;
import cn.sharesdk.framework.loopshare.LoopShareResultListener;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.i;
import cn.sharesdk.framework.utils.k;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.commons.ForbThrowable;
import com.mob.commons.dialog.PolicyThrowable;
import java.util.HashMap;
import java.util.List;

public class ShareSDK {
    public static final String SDK_TAG = "SHARESDK";
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME = "3.10.25";
    public static final String SHARESDK_MOBLINK_RESTORE = "sharesdk_moblink_restore";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static j f13241a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f13242b = true;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f13243c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, Object> f13244d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static List<HashMap<String, Object>> f13245e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static int f13246f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f13247g = false;

    static {
        int i11 = 0;
        for (String parseInt : SDK_VERSION_NAME.split("\\.")) {
            i11 = (i11 * 100) + Integer.parseInt(parseInt);
        }
        SDK_VERSION_CODE = i11;
    }

    public static void closeDebug() {
        f13242b = false;
    }

    public static void deleteCache() {
        try {
            l();
            j jVar = f13241a;
            if (jVar != null) {
                jVar.g();
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK deleteCache catch ", new Object[0]);
        }
    }

    public static void deleteCacheAsync() {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.g();
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK deleteCache catch ", new Object[0]);
                }
            }
        });
    }

    public static Activity getAuthActivity() {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK getAuthActivity catch ", new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    public static void getAuthActivityAsync(final ShareSDKCallback<Activity> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK getAuthActivity catch ", new Object[0]);
                }
                Activity activity = null;
                if (ShareSDK.f13241a != null) {
                    activity = ShareSDK.f13241a.a();
                }
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(activity);
                }
            }
        });
    }

    @Deprecated
    public static HashMap<String, Object> getCustomDataFromLoopShare() {
        return null;
    }

    public static String getDevinfo(String str, String str2) {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK getDevinfo catch ", new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.b(str, str2);
        }
        return null;
    }

    public static void getDevinfoAsync(final String str, final String str2, final ShareSDKCallback<String> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK getDevinfo catch ", new Object[0]);
                }
                String b11 = ShareSDK.f13241a != null ? ShareSDK.f13241a.b(str, str2) : "";
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(b11);
                }
            }
        });
    }

    @Deprecated
    public static boolean getEnableAuthTag() {
        return false;
    }

    @Deprecated
    public static void getFirstQrImage(Context context, ReadQrImageListener readQrImageListener) {
    }

    public static void getNetworkDevinfoAsync(final int i11, final String str, final ShareSDKCallback<String> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK getNetworkDevinfo catch ", new Object[0]);
                }
                String a11 = ShareSDK.f13241a != null ? ShareSDK.f13241a.a(i11, str) : "";
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(a11);
                }
            }
        });
    }

    public static Platform getPlatform(String str) {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK ensureInit getPlatform catch", new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.a(str);
        }
        SSDKLog.b().a("ShareSDK use defaultPlatform", new Object[0]);
        return Platform.getDefaultPlatform();
    }

    public static void getPlatformAsync(final String str, final ShareSDKCallback<Platform> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK ensureInit getPlatform catch", new Object[0]);
                }
                Platform defaultPlatform = Platform.getDefaultPlatform();
                if (ShareSDK.f13241a != null) {
                    defaultPlatform = ShareSDK.f13241a.a(str);
                } else {
                    SSDKLog.b().a("ShareSDK use defaultPlatform", new Object[0]);
                }
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(defaultPlatform);
                }
            }
        });
    }

    public static Platform[] getPlatformList() {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK getPlatformList catch ", new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.d();
        }
        return null;
    }

    public static void getPlatformListAsync(final ShareSDKCallback<Platform[]> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    Platform[] platformArr = null;
                    if (ShareSDK.f13241a != null) {
                        platformArr = ShareSDK.f13241a.d();
                    }
                    ShareSDKCallback shareSDKCallback = shareSDKCallback;
                    if (shareSDKCallback != null) {
                        shareSDKCallback.onCallback(platformArr);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK getPlatformList catch ", new Object[0]);
                }
            }
        });
    }

    @Deprecated
    public static Bitmap getQRCodeBitmap(String str, int i11, int i12) throws Throwable {
        return null;
    }

    public static <T extends Service> T getService(Class<T> cls) throws Throwable {
        l();
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.c(cls);
        }
        return null;
    }

    public static <T extends Service> void getServiceAsync(final Class<T> cls, final ShareSDKCallback<T> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDKCallback shareSDKCallback = shareSDKCallback;
                        if (shareSDKCallback != null) {
                            shareSDKCallback.onCallback(ShareSDK.f13241a.c(cls));
                            return;
                        }
                        return;
                    }
                    ShareSDKCallback shareSDKCallback2 = shareSDKCallback;
                    if (shareSDKCallback2 != null) {
                        shareSDKCallback2.onCallback(null);
                    }
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("ShareSDK getServiceAsync" + th2, new Object[0]);
                }
            }
        });
    }

    public static /* synthetic */ int i() {
        int i11 = f13246f;
        f13246f = i11 + 1;
        return i11;
    }

    public static boolean isDebug() {
        return f13242b;
    }

    public static boolean isFBInstagram() {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog b11 = SSDKLog.b();
            b11.a("ShareSDK isFBInstagram catch: " + th2, new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.b();
        }
        return false;
    }

    public static void isFBInstagramAsync(final ShareSDKCallback<Boolean> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                boolean z11 = false;
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("ShareSDK isFBInstagram catch: " + th2, new Object[0]);
                }
                if (ShareSDK.f13241a != null) {
                    z11 = ShareSDK.f13241a.b();
                }
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.valueOf(z11));
                }
            }
        });
    }

    public static void isNetworkDevinfoRequestedAsync(final ShareSDKCallback<Boolean> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                boolean z11 = false;
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK isNetworkDevinfoRequested is catch ", new Object[0]);
                }
                if (ShareSDK.f13241a != null) {
                    z11 = ShareSDK.f13241a.f();
                }
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.valueOf(z11));
                }
            }
        });
    }

    public static boolean isRemoveCookieOnAuthorize() {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog b11 = SSDKLog.b();
            b11.a("ShareSDK isRemoveCookieOnAuthorize catch: " + th2, new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.e();
        }
        return false;
    }

    public static void isRemoveCookieOnAuthorizeAsync(final ShareSDKCallback<Boolean> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                boolean z11 = false;
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("ShareSDK isRemoveCookieOnAuthorize catch: " + th2, new Object[0]);
                }
                if (ShareSDK.f13241a != null) {
                    z11 = ShareSDK.f13241a.e();
                }
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.valueOf(z11));
                }
            }
        });
    }

    private static boolean k() throws Throwable {
        if (!MobSDK.isForb()) {
            if (!f13247g) {
                f13247g = true;
                i.a();
            }
            int isAuth = MobSDK.isAuth();
            if (isAuth == 1 || isAuth == 2) {
                return true;
            }
            throw new PolicyThrowable();
        }
        throw new ForbThrowable();
    }

    /* access modifiers changed from: private */
    public static synchronized void l() throws Throwable {
        synchronized (ShareSDK.class) {
            k();
            if (f13241a == null) {
                j jVar = new j();
                jVar.c();
                f13241a = jVar;
            }
        }
    }

    public static void logApiEvent(final String str, final int i11) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a(str, i11);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK logApiEvent catch ", new Object[0]);
                }
            }
        });
    }

    public static void logDemoEvent(final int i11, final Platform platform) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a(i11, platform);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK logDemoEvent catch ", new Object[0]);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void m() {
        new Thread(new Runnable() {
            public void run() {
                Looper.prepare();
                final AnonymousClass1 r02 = new Handler(Looper.myLooper()) {
                    public void handleMessage(Message message) {
                        super.handleMessage(message);
                        if (message != null && message.what == 3) {
                            try {
                                ShareSDK.l();
                                if (ShareSDK.f13241a == null) {
                                    return;
                                }
                                if (ShareSDK.f13244d == null || ShareSDK.f13244d.size() <= 0) {
                                    ShareSDK.f13241a.a((List<HashMap<String, Object>>) ShareSDK.f13245e);
                                } else {
                                    ShareSDK.f13241a.a(ShareSDK.f13243c, (HashMap<String, Object>) ShareSDK.f13244d);
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    }
                };
                r02.post(new Runnable() {
                    public void run() {
                        int isAuth = MobSDK.isAuth();
                        if (isAuth == 0) {
                            ShareSDK.i();
                            if (ShareSDK.f13246f == 90) {
                                r02.removeCallbacks(this);
                                return;
                            }
                            SSDKLog.b().d("ShareSDK , Privacy Agreement is not agree, Please agree to the privacy agreement first ", new Object[0]);
                            r02.postDelayed(this, 500);
                        } else if (isAuth != 1 && isAuth != 2) {
                            r02.removeCallbacks(this);
                        } else if (!MobSDK.isForb()) {
                            r02.removeCallbacks(this);
                            Message obtain = Message.obtain();
                            obtain.what = 3;
                            r02.sendMessage(obtain);
                        }
                    }
                });
                Looper.loop();
            }
        }).start();
    }

    @Deprecated
    public static void makeVideoWaterMark(String str, String str2, String str3, String str4, WaterMarkListener waterMarkListener) {
    }

    @Deprecated
    public static void mobLinkGetMobID(HashMap<String, Object> hashMap, MoblinkActionListener moblinkActionListener) {
    }

    public static String platformIdToName(int i11) {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog b11 = SSDKLog.b();
            b11.a("ShareSDK platformIdToName catch: " + th2, new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.c(i11);
        }
        return null;
    }

    public static void platformIdToNameAsync(final int i11, final ShareSDKCallback<String> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog b11 = SSDKLog.b();
                    b11.a("ShareSDK platformIdToName catch: " + th2, new Object[0]);
                }
                String c11 = ShareSDK.f13241a != null ? ShareSDK.f13241a.c(i11) : "";
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(c11);
                }
            }
        });
    }

    public static int platformNameToId(String str) {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK platformNameToId catch ", new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.b(str);
        }
        return -1;
    }

    public static void platformNameToIdAsync(final String str, final ShareSDKCallback<Integer> shareSDKCallback) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK platformNameToId catch ", new Object[0]);
                }
                int i11 = -1;
                if (ShareSDK.f13241a != null) {
                    i11 = ShareSDK.f13241a.b(str);
                }
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Integer.valueOf(i11));
                }
            }
        });
    }

    @Deprecated
    public static void prepareLoopShare(LoopShareResultListener loopShareResultListener) {
    }

    @Deprecated
    public static void preparePassWord(HashMap<String, Object> hashMap, String str, LoopSharePasswordListener loopSharePasswordListener) {
    }

    @Deprecated
    public static void readPassWord(boolean z11, LoopSharePasswordListener loopSharePasswordListener) {
    }

    public static void registerPlatformAsync(final Class<? extends CustomPlatform> cls) throws Throwable {
        k.a(new k.a() {
            public void a() throws Throwable {
                ShareSDK.l();
                if (ShareSDK.f13241a != null) {
                    ShareSDK.f13241a.d(cls);
                }
            }
        });
    }

    public static void registerService(final Class<? extends Service> cls) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a((Class<? extends Service>) cls);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK  registerService catch ", new Object[0]);
                }
            }
        });
    }

    public static void removeCookieOnAuthorize(boolean z11) {
        try {
            l();
            j jVar = f13241a;
            if (jVar != null) {
                jVar.b(z11);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK removeCookieOnAuthorize catch ", new Object[0]);
        }
    }

    public static void removeCookieOnAuthorizeAsync(final boolean z11) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.b(z11);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK removeCookieOnAuthorize catch ", new Object[0]);
                }
            }
        });
    }

    public static void setActivity(Activity activity) {
        try {
            l();
            j jVar = f13241a;
            if (jVar != null) {
                jVar.a(activity);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK setActivity is catch ", new Object[0]);
        }
    }

    public static void setActivityAsync(final Activity activity) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a(activity);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK setActivity is catch ", new Object[0]);
                }
            }
        });
    }

    public static void setCloseGppService(final boolean z11) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    e.a().b(z11);
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2);
                }
            }
        });
    }

    public static void setConnTimeout(int i11) {
        try {
            l();
            j jVar = f13241a;
            if (jVar != null) {
                jVar.a(i11);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK setConnTimeout catch", new Object[0]);
        }
    }

    public static void setConnTimeoutAsync(final int i11) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a(i11);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK setConnTimeout catch", new Object[0]);
                }
            }
        });
    }

    @Deprecated
    public static void setEnableAuthTag(boolean z11) {
    }

    public static void setFBInstagram(boolean z11) {
        try {
            l();
            j jVar = f13241a;
            if (jVar != null) {
                jVar.a(z11);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK setFBInstagram catch ", new Object[0]);
        }
    }

    public static void setFBInstagramAsync(final boolean z11) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a(z11);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK setFBInstagram catch ", new Object[0]);
                }
            }
        });
    }

    public static void setPlatformDevInfo(String str, HashMap<String, Object> hashMap) {
        try {
            f13243c = str;
            f13244d = hashMap;
            if (MobSDK.isForb() || MobSDK.isAuth() != 1) {
                m();
                return;
            }
            l();
            j jVar = f13241a;
            if (jVar != null) {
                jVar.a(str, hashMap);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
        }
    }

    public static void setPlatformDevInfoAsync(final String str, final HashMap<String, Object> hashMap) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    String unused = ShareSDK.f13243c = str;
                    HashMap unused2 = ShareSDK.f13244d = hashMap;
                    if (MobSDK.isForb() || MobSDK.isAuth() != 1) {
                        ShareSDK.m();
                        return;
                    }
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a(str, (HashMap<String, Object>) hashMap);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
                }
            }
        });
    }

    public static void setPlatformDevInfos(List<HashMap<String, Object>> list) {
        try {
            f13245e = list;
            if (MobSDK.isForb() || MobSDK.isAuth() != 1) {
                m();
                return;
            }
            l();
            j jVar = f13241a;
            if (jVar != null) {
                jVar.a(f13245e);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
        }
    }

    public static void setPlatformDevInfosAsync(final List<HashMap<String, Object>> list) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    List unused = ShareSDK.f13245e = list;
                    if (MobSDK.isForb() || MobSDK.isAuth() != 1) {
                        ShareSDK.m();
                        return;
                    }
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a((List<HashMap<String, Object>>) ShareSDK.f13245e);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
                }
            }
        });
    }

    public static void setReadTimeout(int i11) {
        try {
            l();
            j jVar = f13241a;
            if (jVar != null) {
                jVar.b(i11);
            }
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK setReadTimeout catch", new Object[0]);
        }
    }

    public static void setReadTimeoutAsync(final int i11) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.b(i11);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK setReadTimeout catch", new Object[0]);
                }
            }
        });
    }

    public static void unregisterPlatform(final Class<? extends CustomPlatform> cls) throws Throwable {
        k.a(new k.a() {
            public void a() throws Throwable {
                ShareSDK.l();
                if (ShareSDK.f13241a != null) {
                    ShareSDK.f13241a.e(cls);
                }
            }
        });
    }

    public static void unregisterService(final Class<? extends Service> cls) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.b((Class<? extends Service>) cls);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK  unregisterService catch ", new Object[0]);
                }
            }
        });
    }

    public static boolean b() {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK isNetworkDevinfoRequested is catch ", new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.f();
        }
        return false;
    }

    public static void a() {
        k.a(new k.a() {
            public void a() {
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog.b().d(th2);
                }
            }
        });
    }

    public static void a(final String str, final String str2) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a(str, str2);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK copyDevinfo ", new Object[0]);
                }
            }
        });
    }

    public static void a(final int i11, final int i12) {
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                    if (ShareSDK.f13241a != null) {
                        ShareSDK.f13241a.a(i11, i12);
                    }
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK copyNetworkDevinfo catch ", new Object[0]);
                }
            }
        });
    }

    public static String a(int i11, String str) {
        try {
            l();
        } catch (Throwable th2) {
            SSDKLog.b().a(th2, "ShareSDK getNetworkDevinfo catch ", new Object[0]);
        }
        j jVar = f13241a;
        if (jVar != null) {
            return jVar.a(i11, str);
        }
        return null;
    }

    public static void a(final ShareSDKCallback<Boolean> shareSDKCallback) throws Throwable {
        k.a(new k.a() {
            public void a() throws Throwable {
                ShareSDK.l();
                if (ShareSDK.f13241a != null) {
                    ShareSDK.f13241a.a((ShareSDKCallback<Boolean>) shareSDKCallback);
                    return;
                }
                ShareSDKCallback shareSDKCallback = shareSDKCallback;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(Boolean.FALSE);
                }
            }
        });
    }

    public static void a(String str, boolean z11, int i11, String str2, ShareSDKCallback<String> shareSDKCallback) {
        final String str3 = str;
        final boolean z12 = z11;
        final int i12 = i11;
        final String str4 = str2;
        final ShareSDKCallback<String> shareSDKCallback2 = shareSDKCallback;
        k.a(new k.a() {
            public void a() throws Throwable {
                try {
                    ShareSDK.l();
                } catch (Throwable th2) {
                    SSDKLog.b().a(th2, "ShareSDK getShortLink catch ", new Object[0]);
                }
                if (ShareSDK.f13241a != null) {
                    ShareSDK.f13241a.a(str3, z12, i12, str4, shareSDKCallback2);
                    return;
                }
                ShareSDKCallback shareSDKCallback = shareSDKCallback2;
                if (shareSDKCallback != null) {
                    shareSDKCallback.onCallback(str3);
                }
            }
        });
    }

    @Deprecated
    public static String a(String str) {
        Log.e(OnekeyShare.SHARESDK_TAG, "This method is deprecated , please use uploadImageToFileServer(String imagePath,ShareSDKCallback<String> callback)");
        return null;
    }

    @Deprecated
    public static String a(Bitmap bitmap) {
        Log.e(OnekeyShare.SHARESDK_TAG, "This method is deprecated , please use uploadImageToFileServer(String imagePath,ShareSDKCallback<String> callback)");
        return null;
    }
}
