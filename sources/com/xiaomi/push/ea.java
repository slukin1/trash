package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMJobService;

public final class ea {

    /* renamed from: a  reason: collision with root package name */
    private static int f51672a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static a f2762a;

    /* renamed from: a  reason: collision with other field name */
    private static final String f2763a = XMJobService.class.getCanonicalName();

    public interface a {
        void a();

        void a(boolean z11);

        /* renamed from: a  reason: collision with other method in class */
        boolean m2633a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        if (r7.equals(com.xiaomi.push.s.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = "android.permission.BIND_JOB_SERVICE"
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x001b
            com.xiaomi.push.eb r0 = new com.xiaomi.push.eb
            r0.<init>(r9)
            f2762a = r0
            goto L_0x00cf
        L_0x001b:
            android.content.pm.PackageManager r1 = r9.getPackageManager()
            r2 = 0
            java.lang.String r3 = r9.getPackageName()     // Catch:{ Exception -> 0x007c }
            r4 = 4
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r4)     // Catch:{ Exception -> 0x007c }
            android.content.pm.ServiceInfo[] r1 = r1.services     // Catch:{ Exception -> 0x007c }
            r3 = 1
            if (r1 == 0) goto L_0x0095
            int r4 = r1.length     // Catch:{ Exception -> 0x007c }
            r5 = r2
        L_0x0030:
            if (r2 >= r4) goto L_0x007a
            r6 = r1[r2]     // Catch:{ Exception -> 0x0077 }
            java.lang.String r7 = r6.permission     // Catch:{ Exception -> 0x0077 }
            boolean r7 = r0.equals(r7)     // Catch:{ Exception -> 0x0077 }
            if (r7 == 0) goto L_0x0060
            java.lang.String r7 = f2763a     // Catch:{ Exception -> 0x0077 }
            java.lang.String r8 = r6.name     // Catch:{ Exception -> 0x0077 }
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x0077 }
            if (r8 == 0) goto L_0x0048
        L_0x0046:
            r5 = r3
            goto L_0x005d
        L_0x0048:
            java.lang.String r8 = r6.name     // Catch:{ Exception -> 0x005d }
            java.lang.Class r8 = com.xiaomi.push.s.a(r9, r8)     // Catch:{ Exception -> 0x005d }
            java.lang.Class r8 = r8.getSuperclass()     // Catch:{ Exception -> 0x005d }
            java.lang.String r8 = r8.getCanonicalName()     // Catch:{ Exception -> 0x005d }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x005d }
            if (r7 == 0) goto L_0x005d
            goto L_0x0046
        L_0x005d:
            if (r5 != r3) goto L_0x0060
            goto L_0x007a
        L_0x0060:
            java.lang.String r7 = f2763a     // Catch:{ Exception -> 0x0077 }
            java.lang.String r8 = r6.name     // Catch:{ Exception -> 0x0077 }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x0077 }
            if (r7 == 0) goto L_0x0074
            java.lang.String r6 = r6.permission     // Catch:{ Exception -> 0x0077 }
            boolean r6 = r0.equals(r6)     // Catch:{ Exception -> 0x0077 }
            if (r6 == 0) goto L_0x0074
            r2 = r3
            goto L_0x0095
        L_0x0074:
            int r2 = r2 + 1
            goto L_0x0030
        L_0x0077:
            r1 = move-exception
            r2 = r5
            goto L_0x007d
        L_0x007a:
            r2 = r5
            goto L_0x0095
        L_0x007c:
            r1 = move-exception
        L_0x007d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "check service err : "
            r3.append(r4)
            java.lang.String r1 = r1.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)
        L_0x0095:
            if (r2 != 0) goto L_0x00c4
            boolean r1 = com.xiaomi.push.s.a((android.content.Context) r9)
            if (r1 != 0) goto L_0x009e
            goto L_0x00c4
        L_0x009e:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Should export service: "
            r1.append(r2)
            java.lang.String r2 = f2763a
            r1.append(r2)
            java.lang.String r2 = " with permission "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in AndroidManifest.xml file"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        L_0x00c4:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            com.xiaomi.push.eb r0 = new com.xiaomi.push.eb
            r0.<init>(r9)
            f2762a = r0
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ea.a(android.content.Context):void");
    }

    public static synchronized void a(Context context, int i11) {
        synchronized (ea.class) {
            int i12 = f51672a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i11 == 2) {
                    f51672a = 2;
                } else {
                    f51672a = 0;
                }
            }
            int i13 = f51672a;
            if (i12 != i13 && i13 == 2) {
                a();
                f2762a = new ed(context);
            }
        }
    }

    public static synchronized void a(boolean z11) {
        synchronized (ea.class) {
            if (f2762a == null) {
                b.a("timer is not initialized");
                return;
            }
            b.a("[Alarm] register alarm. (" + z11 + ")");
            f2762a.a(z11);
        }
    }

    public static synchronized void a() {
        synchronized (ea.class) {
            if (f2762a != null) {
                b.a("[Alarm] stop alarm.");
                f2762a.a();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized boolean m2632a() {
        synchronized (ea.class) {
            a aVar = f2762a;
            if (aVar == null) {
                return false;
            }
            boolean a11 = aVar.a();
            return a11;
        }
    }
}
