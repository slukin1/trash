package com.mob.commons;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.utils.ResHelper;
import java.io.File;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27288a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f27289b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f27290c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f27291d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f27292e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f27293f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f27294g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f27295h;

    /* renamed from: i  reason: collision with root package name */
    public static final Object f27296i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static final Object f27297j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private static final String f27298k;

    static {
        String a11 = m.a("011a>bibdbdWjeFbi@a*cfdgBj");
        f27298k = a11;
        f27288a = a11 + ".mrlock";
        f27289b = a11 + m.a("007Jbjba2fe$biWa!cf");
        f27290c = a11 + m.a("0118bjchOe7biddJbe>dcbi8a;cf");
        f27291d = a11 + m.a("008TbjbacabfUe%biUa1cf");
        f27292e = a11 + m.a("008XbjbadgbfQeVbi:a7cf");
        f27293f = a11 + ".cl_lock";
        f27294g = a11 + ".gcf_lock";
        f27295h = a11 + ".mp_lock";
    }

    public static synchronized File a(String str) {
        File dataCacheFile;
        synchronized (p.class) {
            dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContext(), str, true);
        }
        return dataCacheFile;
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = f27290c;
            if (str.endsWith(str2)) {
                return str2;
            }
            String str3 = f27289b;
            if (str.endsWith(str3)) {
                return str3;
            }
            String str4 = f27291d;
            if (str.endsWith(str4)) {
                return str4;
            }
            String str5 = f27292e;
            if (str.endsWith(str5)) {
                return str5;
            }
            String str6 = f27293f;
            if (str.endsWith(str6)) {
                return str6;
            }
            String str7 = f27294g;
            if (str.endsWith(str7)) {
                return str7;
            }
        }
        return str;
    }

    public static boolean a(File file, o oVar) {
        return a(file, true, oVar);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1.release();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r2, boolean r3, com.mob.commons.o r4) {
        /*
            java.io.File r0 = r2.getParentFile()     // Catch:{ all -> 0x0046 }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0011
            java.io.File r0 = r2.getParentFile()     // Catch:{ all -> 0x0046 }
            r0.mkdirs()     // Catch:{ all -> 0x0046 }
        L_0x0011:
            boolean r0 = r2.exists()     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x001a
            r2.createNewFile()     // Catch:{ all -> 0x0046 }
        L_0x001a:
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = b(r2)     // Catch:{ all -> 0x0046 }
            monitor-enter(r0)     // Catch:{ all -> 0x0046 }
            com.mob.tools.utils.FileLocker r1 = new com.mob.tools.utils.FileLocker     // Catch:{ all -> 0x0043 }
            r1.<init>()     // Catch:{ all -> 0x0043 }
            r1.setLockFile(r2)     // Catch:{ all -> 0x0043 }
            boolean r2 = r1.lock(r3)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0040
            boolean r2 = r4.a(r1)     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x003e
            r1.release()     // Catch:{ all -> 0x003b }
            goto L_0x003e
        L_0x003b:
            r1.release()     // Catch:{ all -> 0x0043 }
        L_0x003e:
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            goto L_0x004e
        L_0x0040:
            r2 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            return r2
        L_0x0043:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r2     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r2 = move-exception
            com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()
            r3.w((java.lang.Throwable) r2)
        L_0x004e:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.p.a(java.io.File, boolean, com.mob.commons.o):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r6.release();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r7, boolean r8, long r9, long r11, com.mob.commons.o r13) {
        /*
            com.mob.tools.utils.FileLocker r6 = new com.mob.tools.utils.FileLocker
            r6.<init>()
            r6.setLockFile(r7)     // Catch:{ all -> 0x0022 }
            r0 = r6
            r1 = r8
            r2 = r9
            r4 = r11
            boolean r7 = r0.lock(r1, r2, r4)     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0020
            boolean r7 = r13.a(r6)     // Catch:{ all -> 0x001c }
            if (r7 != 0) goto L_0x002d
            r6.release()     // Catch:{ all -> 0x001c }
            goto L_0x002d
        L_0x001c:
            r6.release()     // Catch:{ all -> 0x0022 }
            goto L_0x002d
        L_0x0020:
            r7 = 0
            return r7
        L_0x0022:
            r7 = move-exception
            com.mob.tools.log.NLog r8 = com.mob.tools.MobLog.getInstance()
            r8.w((java.lang.Throwable) r7)
            r6.release()
        L_0x002d:
            r7 = 1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.p.a(java.lang.String, boolean, long, long, com.mob.commons.o):boolean");
    }
}
