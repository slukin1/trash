package junit.runner;

import java.io.File;
import java.util.Properties;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import x00.f;

public abstract class BaseTestRunner implements f {

    /* renamed from: b  reason: collision with root package name */
    public static Properties f56536b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f56537c = e("maxmessage", 500);

    /* renamed from: a  reason: collision with root package name */
    public boolean f56538a = true;

    public static int e(String str, int i11) {
        String f11 = f(str);
        if (f11 == null) {
            return i11;
        }
        try {
            return Integer.parseInt(f11);
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public static String f(String str) {
        return g().getProperty(str);
    }

    public static Properties g() {
        if (f56536b == null) {
            Properties properties = new Properties();
            f56536b = properties;
            properties.put("loading", "true");
            f56536b.put("filterstack", "true");
            i();
        }
        return f56536b;
    }

    public static File h() {
        return new File(System.getProperty("user.home"), "junit.properties");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b A[SYNTHETIC, Splitter:B:13:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031 A[SYNTHETIC, Splitter:B:19:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void i() {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002f, all -> 0x0025 }
            java.io.File r2 = h()     // Catch:{ IOException -> 0x002f, all -> 0x0025 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x002f, all -> 0x0025 }
            java.util.Properties r0 = new java.util.Properties     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            java.util.Properties r2 = g()     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            j(r0)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            java.util.Properties r0 = g()     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r0.load(r1)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r1.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0034
        L_0x0021:
            r0 = move-exception
            goto L_0x0029
        L_0x0023:
            r0 = r1
            goto L_0x002f
        L_0x0025:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            throw r0
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: junit.runner.BaseTestRunner.i():void");
    }

    public static void j(Properties properties) {
        f56536b = properties;
    }

    public synchronized void a(Test test, Throwable th2) {
        l(1, test, th2);
    }

    public synchronized void b(Test test, AssertionFailedError assertionFailedError) {
        l(2, test, assertionFailedError);
    }

    public synchronized void c(Test test) {
        k(test.toString());
    }

    public synchronized void d(Test test) {
        m(test.toString());
    }

    public abstract void k(String str);

    public abstract void l(int i11, Test test, Throwable th2);

    public abstract void m(String str);
}
