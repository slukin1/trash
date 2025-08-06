package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.sumsub.sns.internal.core.common.n0;
import com.xiaomi.channel.commonutils.logger.b;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private static Context f52387a;

    /* renamed from: a  reason: collision with other field name */
    private static String f3265a;

    public static void a(Context context) {
        f52387a = context.getApplicationContext();
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m2925b() {
        try {
            return a((Context) null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e11) {
            b.a((Throwable) e11);
            return false;
        }
    }

    private static String c() {
        String a11 = q.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a11) && !a11.startsWith("ColorOS_")) {
            f3265a = "ColorOS_" + a11;
        }
        return f3265a;
    }

    private static String d() {
        String a11 = q.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a11) && !a11.startsWith("FuntouchOS_")) {
            f3265a = "FuntouchOS_" + a11;
        }
        return f3265a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Context m2921a() {
        return f52387a;
    }

    public static int a() {
        try {
            Class<?> a11 = a((Context) null, "miui.os.Build");
            if (a11.getField("IS_STABLE_VERSION").getBoolean((Object) null)) {
                return 3;
            }
            return a11.getField("IS_DEVELOPMENT_VERSION").getBoolean((Object) null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String b() {
        String a11 = q.a("ro.build.version.emui", "");
        f3265a = a11;
        return a11;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2924a(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            b.a((Throwable) e11);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2923a() {
        return TextUtils.equals((String) ax.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m2922a() {
        synchronized (s.class) {
            String str = f3265a;
            if (str != null) {
                return str;
            }
            String e11 = j.e();
            if (a() <= 0) {
                String b11 = b();
                if (TextUtils.isEmpty(b11)) {
                    b11 = c();
                    if (TextUtils.isEmpty(b11)) {
                        b11 = d();
                        if (TextUtils.isEmpty(b11)) {
                            e11 = String.valueOf(q.a(SystemUtils.PRODUCT_BRAND, n0.f32119g) + "_" + e11);
                        }
                    }
                }
                e11 = b11;
            }
            f3265a = e11;
            return e11;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[SYNTHETIC, Splitter:B:13:0x0024] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> a(android.content.Context r5, java.lang.String r6) {
        /*
            if (r6 == 0) goto L_0x004a
            java.lang.String r0 = r6.trim()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x004a
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0012
            r2 = r0
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            if (r2 == 0) goto L_0x0024
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 < r4) goto L_0x0024
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ all -> 0x0024 }
            java.lang.Class r5 = r5.loadClass(r6)     // Catch:{ all -> 0x0024 }
            return r5
        L_0x0024:
            java.lang.Class r5 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x0029 }
            return r5
        L_0x0029:
            r5 = move-exception
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6[r1] = r2
            java.lang.String r1 = r5.getLocalizedMessage()
            r6[r0] = r1
            java.lang.String r0 = "loadClass fail hasContext= %s, errMsg = %s"
            java.lang.String r6 = java.lang.String.format(r0, r6)
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r6)
            java.lang.ClassNotFoundException r6 = new java.lang.ClassNotFoundException
            java.lang.String r0 = "loadClass fail "
            r6.<init>(r0, r5)
            throw r6
        L_0x004a:
            java.lang.ClassNotFoundException r5 = new java.lang.ClassNotFoundException
            java.lang.String r6 = "class is empty"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.s.a(android.content.Context, java.lang.String):java.lang.Class");
    }
}
