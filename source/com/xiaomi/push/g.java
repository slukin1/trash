package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.finance.bean.VirtualAddressInfo;
import java.util.Map;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static a f51883a;

    public interface a {
        Map<String, String> a(Context context, String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m2716a(Context context, String str);

        boolean b(Context context, String str);
    }

    public enum b {
        f51884a(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: a  reason: collision with other field name */
        private final int f2888a;

        private b(int i11) {
            this.f2888a = i11;
        }

        public int a() {
            return this.f2888a;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m2711a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m2715b(Context context, String str) {
        a aVar = f51883a;
        return aVar != null && aVar.b(context, str);
    }

    public static boolean c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        r0 = r0.applicationInfo;
     */
    /* renamed from: b  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m2714b(android.content.Context r1, java.lang.String r2) {
        /*
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0018 }
            r0 = 0
            android.content.pm.PackageInfo r0 = r1.getPackageInfo(r2, r0)     // Catch:{ NameNotFoundException -> 0x0018 }
            if (r0 == 0) goto L_0x0018
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ NameNotFoundException -> 0x0018 }
            if (r0 == 0) goto L_0x0018
            java.lang.CharSequence r1 = r1.getApplicationLabel(r0)     // Catch:{ NameNotFoundException -> 0x0018 }
            java.lang.String r1 = r1.toString()     // Catch:{ NameNotFoundException -> 0x0018 }
            r2 = r1
        L_0x0018:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.g.m2714b(android.content.Context, java.lang.String):java.lang.String");
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    @TargetApi(19)
    public static b a(Context context, String str, boolean z11) {
        ApplicationInfo applicationInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            return b.f51884a;
        }
        try {
            if (str.equals(context.getPackageName())) {
                applicationInfo = context.getApplicationInfo();
            } else {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            }
            b a11 = a(context, applicationInfo);
            b bVar = b.f51884a;
            if (a11 != bVar) {
                return a11;
            }
            Integer num = (Integer) ax.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                return bVar;
            }
            Integer num2 = (Integer) ax.a((Object) (AppOpsManager) context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
            int i11 = (Integer) ax.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i12 = (Integer) ax.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", new Object[]{num2, i11, i12}));
            if (i11 == null) {
                i11 = 0;
            }
            if (i12 == null) {
                i12 = 1;
            }
            if (num2 != null) {
                return z11 ? !num2.equals(i12) ? b.ALLOWED : b.NOT_ALLOWED : num2.equals(i11) ? b.ALLOWED : b.NOT_ALLOWED;
            }
            return b.f51884a;
        } catch (Throwable th2) {
            com.xiaomi.channel.commonutils.logger.b.a("get app op error " + th2);
        }
    }

    public static int b(Context context, String str) {
        ApplicationInfo a11 = a(context, str);
        if (a11 == null) {
            return 0;
        }
        int i11 = a11.icon;
        return i11 == 0 ? a11.logo : i11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.xiaomi.push.g.b a(android.content.Context r5, android.content.pm.ApplicationInfo r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r6 == 0) goto L_0x0081
            r1 = 24
            if (r0 >= r1) goto L_0x000a
            goto L_0x0081
        L_0x000a:
            r1 = 0
            java.lang.String r2 = r6.packageName     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = r5.getPackageName()     // Catch:{ Exception -> 0x0069 }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "notification"
            if (r2 == 0) goto L_0x0028
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch:{ Exception -> 0x0069 }
            android.app.NotificationManager r5 = (android.app.NotificationManager) r5     // Catch:{ Exception -> 0x0069 }
            boolean r5 = r5.areNotificationsEnabled()     // Catch:{ Exception -> 0x0069 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x0069 }
            goto L_0x005b
        L_0x0028:
            r2 = 29
            r4 = 0
            if (r0 < r2) goto L_0x003a
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r0 = "getService"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r5 = com.xiaomi.push.ax.a((java.lang.Object) r5, (java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0069 }
            goto L_0x0040
        L_0x003a:
            java.lang.String r0 = "security"
            java.lang.Object r5 = r5.getSystemService(r0)     // Catch:{ Exception -> 0x0069 }
        L_0x0040:
            if (r5 == 0) goto L_0x005b
            java.lang.String r0 = "areNotificationsEnabledForPackage"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0069 }
            java.lang.String r2 = r6.packageName     // Catch:{ Exception -> 0x0069 }
            r1[r4] = r2     // Catch:{ Exception -> 0x0069 }
            r2 = 1
            int r6 = r6.uid     // Catch:{ Exception -> 0x0069 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0069 }
            r1[r2] = r6     // Catch:{ Exception -> 0x0069 }
            java.lang.Object r5 = com.xiaomi.push.ax.b((java.lang.Object) r5, (java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x0069 }
            r1 = r5
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0069 }
        L_0x005b:
            if (r1 == 0) goto L_0x007e
            boolean r5 = r1.booleanValue()     // Catch:{ Exception -> 0x0069 }
            if (r5 == 0) goto L_0x0066
            com.xiaomi.push.g$b r5 = com.xiaomi.push.g.b.ALLOWED     // Catch:{ Exception -> 0x0069 }
            goto L_0x0068
        L_0x0066:
            com.xiaomi.push.g$b r5 = com.xiaomi.push.g.b.NOT_ALLOWED     // Catch:{ Exception -> 0x0069 }
        L_0x0068:
            return r5
        L_0x0069:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "are notifications enabled error "
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r5)
        L_0x007e:
            com.xiaomi.push.g$b r5 = com.xiaomi.push.g.b.f51884a
            return r5
        L_0x0081:
            com.xiaomi.push.g$b r5 = com.xiaomi.push.g.b.f51884a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.g.a(android.content.Context, android.content.pm.ApplicationInfo):com.xiaomi.push.g$b");
    }

    public static void a(Context context, ApplicationInfo applicationInfo, boolean z11) {
        Object obj;
        int i11 = Build.VERSION.SDK_INT;
        if (b.ALLOWED != a(context, applicationInfo)) {
            if (i11 >= 29) {
                try {
                    obj = ax.a(context.getSystemService(RemoteMessageConst.NOTIFICATION), "getService", new Object[0]);
                } catch (Exception e11) {
                    com.xiaomi.channel.commonutils.logger.b.a("set notifications enabled error " + e11);
                    return;
                }
            } else {
                obj = context.getSystemService(VirtualAddressInfo.LEVEL_SECURITY);
            }
            if (obj != null) {
                ax.b(obj, "setNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid), Boolean.valueOf(z11));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2713a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!j.a()) {
            return context.getPackageName().equals(str);
        }
        a aVar = f51883a;
        if (aVar == null || aVar.a(context, str) == null) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context) {
        String a11 = a();
        if (TextUtils.isEmpty(a11) || context == null) {
            return false;
        }
        return a11.equals(context.getPackageName());
    }

    public static String a() {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            str = (String) ax.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        }
        return !TextUtils.isEmpty(str) ? str : "";
    }

    /* renamed from: a  reason: collision with other method in class */
    private static ApplicationInfo m2709a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m2710a(Context context, String str) {
        ApplicationInfo a11 = a(context, str);
        Drawable drawable = null;
        if (a11 != null) {
            try {
                drawable = a11.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = a11.loadLogo(context.getPackageManager());
                }
            } catch (Exception e11) {
                com.xiaomi.channel.commonutils.logger.b.a("get app icon drawable failed, " + e11);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Map<String, String> m2712a(Context context, String str) {
        a aVar = f51883a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(context, str);
    }
}
