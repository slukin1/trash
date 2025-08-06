package cn.sharesdk.framework.utils;

import com.mob.tools.log.NLog;

public class SSDKLog {

    /* renamed from: a  reason: collision with root package name */
    private static SSDKLog f13494a;

    /* renamed from: b  reason: collision with root package name */
    private static NLog f13495b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13496c = -1;

    private SSDKLog() {
        a();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r0 = com.mob.tools.log.NLog.getInstance(cn.sharesdk.framework.ShareSDK.SDK_TAG);
        f13495b = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mob.tools.log.NLog a() {
        /*
            java.lang.String r0 = "SHARESDK"
            int r1 = cn.sharesdk.framework.ShareSDK.SDK_VERSION_CODE     // Catch:{ all -> 0x000d }
            java.lang.String r2 = "cn.sharesdk"
            com.mob.tools.log.NLog r1 = com.mob.tools.log.NLog.getInstance(r0, r1, r2)     // Catch:{ all -> 0x000d }
            f13495b = r1     // Catch:{ all -> 0x000d }
            return r1
        L_0x000d:
            com.mob.tools.log.NLog r0 = com.mob.tools.log.NLog.getInstance(r0)     // Catch:{ all -> 0x0014 }
            f13495b = r0     // Catch:{ all -> 0x0014 }
            return r0
        L_0x0014:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.SSDKLog.a():com.mob.tools.log.NLog");
    }

    private boolean a(NLog nLog) {
        return nLog != null;
    }

    public static SSDKLog b() {
        if (f13494a == null) {
            f13494a = new SSDKLog();
        }
        return f13494a;
    }

    public final int c(Throwable th2) {
        try {
            if (a(f13495b)) {
                return f13495b.log(4, th2);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Throwable th2) {
        try {
            if (a(f13495b)) {
                return f13495b.log(6, th2);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(Throwable th2) {
        try {
            if (a(f13495b)) {
                return f13495b.log(3, th2);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int c(Object obj, Object... objArr) {
        try {
            if (a(f13495b)) {
                return f13495b.log(4, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Object obj, Object... objArr) {
        try {
            if (a(f13495b)) {
                return f13495b.log(6, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int b(Throwable th2) {
        try {
            if (a(f13495b)) {
                return f13495b.log(5, th2);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(Object obj, Object... objArr) {
        try {
            if (a(f13495b)) {
                return f13495b.log(3, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int b(Object obj, Object... objArr) {
        try {
            if (a(f13495b)) {
                return f13495b.log(5, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(Throwable th2, Object obj, Object... objArr) {
        try {
            if (a(f13495b)) {
                return f13495b.log(3, th2, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int b(Throwable th2, Object obj, Object... objArr) {
        try {
            if (a(f13495b)) {
                return f13495b.log(5, th2, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(String str) {
        try {
            if (a(f13495b)) {
                return f13495b.log(5, str, new Object[0]);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int b(String str) {
        try {
            if (a(f13495b)) {
                return f13495b.log(4, str, new Object[0]);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
