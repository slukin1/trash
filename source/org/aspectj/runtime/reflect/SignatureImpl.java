package org.aspectj.runtime.reflect;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;

public abstract class SignatureImpl implements v10.a {

    /* renamed from: h  reason: collision with root package name */
    public static boolean f58985h = true;

    /* renamed from: i  reason: collision with root package name */
    public static String[] f58986i = new String[0];

    /* renamed from: j  reason: collision with root package name */
    public static Class[] f58987j = new Class[0];

    /* renamed from: a  reason: collision with root package name */
    public int f58988a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f58989b;

    /* renamed from: c  reason: collision with root package name */
    public String f58990c;

    /* renamed from: d  reason: collision with root package name */
    public Class f58991d;

    /* renamed from: e  reason: collision with root package name */
    public a f58992e;

    /* renamed from: f  reason: collision with root package name */
    public String f58993f;

    /* renamed from: g  reason: collision with root package name */
    public ClassLoader f58994g = null;

    public static final class CacheImpl implements a {

        /* renamed from: a  reason: collision with root package name */
        public SoftReference f58995a;

        public CacheImpl() {
            c();
        }

        public void a(int i11, String str) {
            String[] b11 = b();
            if (b11 == null) {
                b11 = c();
            }
            b11[i11] = str;
        }

        public final String[] b() {
            return (String[]) this.f58995a.get();
        }

        public final String[] c() {
            String[] strArr = new String[3];
            this.f58995a = new SoftReference(strArr);
            return strArr;
        }

        public String get(int i11) {
            String[] b11 = b();
            if (b11 == null) {
                return null;
            }
            return b11[i11];
        }
    }

    public interface a {
        void a(int i11, String str);

        String get(int i11);
    }

    public SignatureImpl(int i11, String str, Class cls) {
        this.f58988a = i11;
        this.f58989b = str;
        this.f58991d = cls;
    }

    public abstract String a(h hVar);

    public int b(int i11) {
        return Integer.parseInt(c(i11), 16);
    }

    public String c(int i11) {
        int indexOf = this.f58993f.indexOf(45);
        int i12 = 0;
        while (true) {
            int i13 = i11 - 1;
            if (i11 <= 0) {
                break;
            }
            i12 = indexOf + 1;
            indexOf = this.f58993f.indexOf(45, i12);
            i11 = i13;
        }
        if (indexOf == -1) {
            indexOf = this.f58993f.length();
        }
        return this.f58993f.substring(i12, indexOf);
    }

    public Class d(int i11) {
        return c.a(c(i11), h());
    }

    public Class[] e(int i11) {
        StringTokenizer stringTokenizer = new StringTokenizer(c(i11), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i12 = 0; i12 < countTokens; i12++) {
            clsArr[i12] = c.a(stringTokenizer.nextToken(), h());
        }
        return clsArr;
    }

    public Class f() {
        if (this.f58991d == null) {
            this.f58991d = d(2);
        }
        return this.f58991d;
    }

    public String g() {
        if (this.f58990c == null) {
            this.f58990c = f().getName();
        }
        return this.f58990c;
    }

    public final ClassLoader h() {
        if (this.f58994g == null) {
            this.f58994g = getClass().getClassLoader();
        }
        return this.f58994g;
    }

    public int i() {
        if (this.f58988a == -1) {
            this.f58988a = b(0);
        }
        return this.f58988a;
    }

    public String j() {
        if (this.f58989b == null) {
            this.f58989b = c(1);
        }
        return this.f58989b;
    }

    public void k(ClassLoader classLoader) {
        this.f58994g = classLoader;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String l(org.aspectj.runtime.reflect.h r3) {
        /*
            r2 = this;
            boolean r0 = f58985h
            if (r0 == 0) goto L_0x001b
            org.aspectj.runtime.reflect.SignatureImpl$a r0 = r2.f58992e
            if (r0 != 0) goto L_0x0014
            org.aspectj.runtime.reflect.SignatureImpl$CacheImpl r0 = new org.aspectj.runtime.reflect.SignatureImpl$CacheImpl     // Catch:{ all -> 0x0010 }
            r0.<init>()     // Catch:{ all -> 0x0010 }
            r2.f58992e = r0     // Catch:{ all -> 0x0010 }
            goto L_0x001b
        L_0x0010:
            r0 = 0
            f58985h = r0
            goto L_0x001b
        L_0x0014:
            int r1 = r3.f59032i
            java.lang.String r0 = r0.get(r1)
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = r2.a(r3)
        L_0x0022:
            boolean r1 = f58985h
            if (r1 == 0) goto L_0x002d
            org.aspectj.runtime.reflect.SignatureImpl$a r1 = r2.f58992e
            int r3 = r3.f59032i
            r1.a(r3, r0)
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.aspectj.runtime.reflect.SignatureImpl.l(org.aspectj.runtime.reflect.h):java.lang.String");
    }

    public final String toString() {
        return l(h.f59022k);
    }
}
