package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ak implements aj, InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final String[][] f51369a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a  reason: collision with other field name */
    private volatile int f2516a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile long f2517a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f2518a;

    /* renamed from: a  reason: collision with other field name */
    private volatile a f2519a = null;

    /* renamed from: a  reason: collision with other field name */
    private Class f2520a = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f2521a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private Method f2522a = null;

    /* renamed from: b  reason: collision with root package name */
    private Class f51370b = null;

    /* renamed from: b  reason: collision with other field name */
    private Method f2523b = null;

    /* renamed from: c  reason: collision with root package name */
    private Method f51371c = null;

    /* renamed from: d  reason: collision with root package name */
    private Method f51372d = null;

    /* renamed from: e  reason: collision with root package name */
    private Method f51373e = null;

    /* renamed from: f  reason: collision with root package name */
    private Method f51374f = null;

    /* renamed from: g  reason: collision with root package name */
    private Method f51375g = null;

    public class a {

        /* renamed from: a  reason: collision with other field name */
        public Boolean f2524a;

        /* renamed from: a  reason: collision with other field name */
        public String f2525a;

        /* renamed from: b  reason: collision with root package name */
        public String f51377b;

        /* renamed from: c  reason: collision with root package name */
        public String f51378c;

        /* renamed from: d  reason: collision with root package name */
        public String f51379d;

        private a() {
            this.f2524a = null;
            this.f2525a = null;
            this.f51377b = null;
            this.f51378c = null;
            this.f51379d = null;
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.f2525a) || !TextUtils.isEmpty(this.f51377b) || !TextUtils.isEmpty(this.f51378c) || !TextUtils.isEmpty(this.f51379d)) {
                this.f2524a = Boolean.TRUE;
            }
            return this.f2524a != null;
        }
    }

    public ak(Context context) {
        this.f2518a = context.getApplicationContext();
        a(context);
        b(context);
    }

    private void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = -elapsedRealtime;
        Class cls = this.f51370b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                Object newProxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{this.f51370b}, this);
                a(this.f2522a, this.f2520a.newInstance(), context, newProxyInstance);
            } catch (Throwable th2) {
                b("call init sdk error:" + th2);
            }
            this.f2517a = elapsedRealtime;
        }
        elapsedRealtime = j11;
        this.f2517a = elapsedRealtime;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2391a() {
        a("isSupported");
        return this.f2519a != null && Boolean.TRUE.equals(this.f2519a.f2524a);
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f2517a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                Object obj2 = objArr[i11];
                if (obj2 != null && !a(obj2)) {
                    aVar.f51377b = (String) a(this.f51371c, obj2, new Object[0]);
                    aVar.f2524a = (Boolean) a(this.f51374f, obj2, new Object[0]);
                    a(this.f51375g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("has get succ, check duplicate:");
                        if (this.f2519a != null) {
                            z11 = true;
                        }
                        sb2.append(z11);
                        b(sb2.toString());
                        synchronized (ak.class) {
                            if (this.f2519a == null) {
                                this.f2519a = aVar;
                            }
                        }
                    }
                }
                i11++;
            }
        }
        a();
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2390a() {
        a("getOAID");
        if (this.f2519a == null) {
            return null;
        }
        return this.f2519a.f51377b;
    }

    private void a(Context context) {
        Class<?> a11 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i11 = 0;
        while (true) {
            String[][] strArr = f51369a;
            if (i11 >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i11];
            Class<?> a12 = a(context, strArr2[0]);
            Class<?> a13 = a(context, strArr2[1]);
            if (a12 != null && a13 != null) {
                b("found class in index " + i11);
                Class<?> cls3 = a12;
                cls2 = a13;
                cls = cls3;
                break;
            }
            i11++;
            Class<?> cls4 = a12;
            cls2 = a13;
            cls = cls4;
        }
        this.f2520a = a11;
        this.f2522a = a(a11, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.f51370b = cls;
        this.f51371c = a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f51374f = a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.f51375g = a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    private static void b(String str) {
        b.a("mdid:" + str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:30|31|(2:33|34)|35|36) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r11) {
        /*
            r10 = this;
            com.xiaomi.push.ak$a r0 = r10.f2519a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            long r0 = r10.f2517a
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = java.lang.Math.abs(r0)
            long r2 = r2 - r4
            int r4 = r10.f2516a
            r5 = 3000(0xbb8, double:1.482E-320)
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0057
            r7 = 3
            if (r4 >= r7) goto L_0x0057
            java.lang.Object r7 = r10.f2521a
            monitor-enter(r7)
            long r8 = r10.f2517a     // Catch:{ all -> 0x0054 }
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 != 0) goto L_0x0052
            int r8 = r10.f2516a     // Catch:{ all -> 0x0054 }
            if (r8 != r4) goto L_0x0052
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r0.<init>()     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = "retry, current count is "
            r0.append(r1)     // Catch:{ all -> 0x0054 }
            r0.append(r4)     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0054 }
            b((java.lang.String) r0)     // Catch:{ all -> 0x0054 }
            int r0 = r10.f2516a     // Catch:{ all -> 0x0054 }
            int r0 = r0 + 1
            r10.f2516a = r0     // Catch:{ all -> 0x0054 }
            android.content.Context r0 = r10.f2518a     // Catch:{ all -> 0x0054 }
            r10.b((android.content.Context) r0)     // Catch:{ all -> 0x0054 }
            long r0 = r10.f2517a     // Catch:{ all -> 0x0054 }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0054 }
            long r8 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x0054 }
            long r2 = r2 - r8
        L_0x0052:
            monitor-exit(r7)     // Catch:{ all -> 0x0054 }
            goto L_0x0057
        L_0x0054:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0054 }
            throw r11
        L_0x0057:
            com.xiaomi.push.ak$a r4 = r10.f2519a
            if (r4 != 0) goto L_0x0094
            r7 = 0
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x0094
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0094
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0094
            java.lang.Object r0 = r10.f2521a
            monitor-enter(r0)
            com.xiaomi.push.ak$a r1 = r10.f2519a     // Catch:{ all -> 0x0091 }
            if (r1 != 0) goto L_0x008f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f }
            r1.<init>()     // Catch:{ Exception -> 0x008f }
            r1.append(r11)     // Catch:{ Exception -> 0x008f }
            java.lang.String r11 = " wait..."
            r1.append(r11)     // Catch:{ Exception -> 0x008f }
            java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x008f }
            b((java.lang.String) r11)     // Catch:{ Exception -> 0x008f }
            java.lang.Object r11 = r10.f2521a     // Catch:{ Exception -> 0x008f }
            r11.wait(r5)     // Catch:{ Exception -> 0x008f }
        L_0x008f:
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            goto L_0x0094
        L_0x0091:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            throw r11
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ak.a(java.lang.String):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f2521a
            monitor-enter(r0)
            java.lang.Object r1 = r2.f2521a     // Catch:{ Exception -> 0x000b }
            r1.notifyAll()     // Catch:{ Exception -> 0x000b }
            goto L_0x000b
        L_0x0009:
            r1 = move-exception
            goto L_0x000d
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ak.a():void");
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return s.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
