package fx;

import android.util.Log;
import com.nineoldandroids.animation.FloatEvaluator;
import com.nineoldandroids.animation.IntEvaluator;
import com.nineoldandroids.animation.Keyframe;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import gx.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class b implements Cloneable {

    /* renamed from: l  reason: collision with root package name */
    public static final c f28994l = new IntEvaluator();

    /* renamed from: m  reason: collision with root package name */
    public static final c f28995m = new FloatEvaluator();

    /* renamed from: n  reason: collision with root package name */
    public static Class[] f28996n;

    /* renamed from: o  reason: collision with root package name */
    public static Class[] f28997o;

    /* renamed from: p  reason: collision with root package name */
    public static Class[] f28998p;

    /* renamed from: q  reason: collision with root package name */
    public static final HashMap<Class, HashMap<String, Method>> f28999q = new HashMap<>();

    /* renamed from: r  reason: collision with root package name */
    public static final HashMap<Class, HashMap<String, Method>> f29000r = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public String f29001b;

    /* renamed from: c  reason: collision with root package name */
    public c f29002c;

    /* renamed from: d  reason: collision with root package name */
    public Method f29003d;

    /* renamed from: e  reason: collision with root package name */
    public Method f29004e;

    /* renamed from: f  reason: collision with root package name */
    public Class f29005f;

    /* renamed from: g  reason: collision with root package name */
    public com.nineoldandroids.animation.b f29006g;

    /* renamed from: h  reason: collision with root package name */
    public final ReentrantReadWriteLock f29007h;

    /* renamed from: i  reason: collision with root package name */
    public final Object[] f29008i;

    /* renamed from: j  reason: collision with root package name */
    public c f29009j;

    /* renamed from: k  reason: collision with root package name */
    public Object f29010k;

    static {
        Class<Integer> cls = Integer.class;
        Class<Double> cls2 = Double.class;
        Class<Float> cls3 = Float.class;
        Class cls4 = Float.TYPE;
        Class cls5 = Double.TYPE;
        Class cls6 = Integer.TYPE;
        f28996n = new Class[]{cls4, cls3, cls5, cls6, cls2, cls};
        f28997o = new Class[]{cls6, cls, cls4, cls5, cls3, cls2};
        f28998p = new Class[]{cls5, cls2, cls4, cls6, cls3, cls};
    }

    public static String e(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        String substring = str2.substring(1);
        return str + upperCase + substring;
    }

    public static b i(c<?, Integer> cVar, int... iArr) {
        return new C0251b((c) cVar, iArr);
    }

    public static b j(String str, int... iArr) {
        return new C0251b(str, iArr);
    }

    public void b(float f11) {
        this.f29010k = this.f29006g.b(f11);
    }

    /* renamed from: c */
    public b clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f29001b = this.f29001b;
            bVar.f29002c = this.f29002c;
            bVar.f29006g = this.f29006g.a();
            bVar.f29009j = this.f29009j;
            return bVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Object d() {
        return this.f29010k;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.reflect.Method f(java.lang.Class r9, java.lang.String r10, java.lang.Class r11) {
        /*
            r8 = this;
            java.lang.String r0 = r8.f29001b
            java.lang.String r10 = e(r10, r0)
            java.lang.String r0 = "PropertyValuesHolder"
            r1 = 0
            r2 = 1
            if (r11 != 0) goto L_0x003b
            java.lang.reflect.Method r9 = r9.getMethod(r10, r1)     // Catch:{ NoSuchMethodException -> 0x0012 }
            goto L_0x00a8
        L_0x0012:
            r11 = move-exception
            java.lang.reflect.Method r1 = r9.getDeclaredMethod(r10, r1)     // Catch:{ NoSuchMethodException -> 0x001c }
            r1.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x001c }
            goto L_0x00a7
        L_0x001c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Couldn't find no-arg method for property "
            r9.append(r10)
            java.lang.String r10 = r8.f29001b
            r9.append(r10)
            java.lang.String r10 = ": "
            r9.append(r10)
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r0, r9)
            goto L_0x00a7
        L_0x003b:
            java.lang.Class[] r11 = new java.lang.Class[r2]
            java.lang.Class r3 = r8.f29005f
            java.lang.Class<java.lang.Float> r4 = java.lang.Float.class
            boolean r3 = r3.equals(r4)
            r4 = 0
            if (r3 == 0) goto L_0x004b
            java.lang.Class[] r3 = f28996n
            goto L_0x006b
        L_0x004b:
            java.lang.Class r3 = r8.f29005f
            java.lang.Class<java.lang.Integer> r5 = java.lang.Integer.class
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0058
            java.lang.Class[] r3 = f28997o
            goto L_0x006b
        L_0x0058:
            java.lang.Class r3 = r8.f29005f
            java.lang.Class<java.lang.Double> r5 = java.lang.Double.class
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0065
            java.lang.Class[] r3 = f28998p
            goto L_0x006b
        L_0x0065:
            java.lang.Class[] r3 = new java.lang.Class[r2]
            java.lang.Class r5 = r8.f29005f
            r3[r4] = r5
        L_0x006b:
            int r5 = r3.length
            r6 = r4
        L_0x006d:
            if (r6 >= r5) goto L_0x0087
            r7 = r3[r6]
            r11[r4] = r7
            java.lang.reflect.Method r1 = r9.getMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x007a }
            r8.f29005f = r7     // Catch:{ NoSuchMethodException -> 0x007a }
            return r1
        L_0x007a:
            java.lang.reflect.Method r1 = r9.getDeclaredMethod(r10, r11)     // Catch:{ NoSuchMethodException -> 0x0084 }
            r1.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x0084 }
            r8.f29005f = r7     // Catch:{ NoSuchMethodException -> 0x0084 }
            return r1
        L_0x0084:
            int r6 = r6 + 1
            goto L_0x006d
        L_0x0087:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Couldn't find setter/getter for property "
            r9.append(r10)
            java.lang.String r10 = r8.f29001b
            r9.append(r10)
            java.lang.String r10 = " with value type "
            r9.append(r10)
            java.lang.Class r10 = r8.f29005f
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r0, r9)
        L_0x00a7:
            r9 = r1
        L_0x00a8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fx.b.f(java.lang.Class, java.lang.String, java.lang.Class):java.lang.reflect.Method");
    }

    public String g() {
        return this.f29001b;
    }

    public void h() {
        if (this.f29009j == null) {
            Class<Float> cls = this.f29005f;
            this.f29009j = cls == Integer.class ? f28994l : cls == Float.class ? f28995m : null;
        }
        c cVar = this.f29009j;
        if (cVar != null) {
            this.f29006g.d(cVar);
        }
    }

    public void k(Object obj) {
        c cVar = this.f29002c;
        if (cVar != null) {
            cVar.c(obj, d());
        }
        if (this.f29003d != null) {
            try {
                this.f29008i[0] = d();
                this.f29003d.invoke(obj, this.f29008i);
            } catch (InvocationTargetException e11) {
                Log.e("PropertyValuesHolder", e11.toString());
            } catch (IllegalAccessException e12) {
                Log.e("PropertyValuesHolder", e12.toString());
            }
        }
    }

    public void l(int... iArr) {
        this.f29005f = Integer.TYPE;
        this.f29006g = com.nineoldandroids.animation.b.c(iArr);
    }

    public void m(c cVar) {
        this.f29002c = cVar;
    }

    public final void n(Class cls) {
        this.f29004e = q(cls, f29000r, "get", (Class) null);
    }

    public void o(Class cls) {
        this.f29003d = q(cls, f28999q, "set", this.f29005f);
    }

    public void p(Object obj) {
        c cVar = this.f29002c;
        if (cVar != null) {
            try {
                cVar.a(obj);
                Iterator<Keyframe> it2 = this.f29006g.f28284e.iterator();
                while (it2.hasNext()) {
                    Keyframe next = it2.next();
                    if (!next.f()) {
                        next.j(this.f29002c.a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f29002c.b() + ") on target object " + obj + ". Trying reflection instead");
                this.f29002c = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f29003d == null) {
            o(cls);
        }
        Iterator<Keyframe> it3 = this.f29006g.f28284e.iterator();
        while (it3.hasNext()) {
            Keyframe next2 = it3.next();
            if (!next2.f()) {
                if (this.f29004e == null) {
                    n(cls);
                }
                try {
                    next2.j(this.f29004e.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e11) {
                    Log.e("PropertyValuesHolder", e11.toString());
                } catch (IllegalAccessException e12) {
                    Log.e("PropertyValuesHolder", e12.toString());
                }
            }
        }
    }

    public final Method q(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.f29007h.writeLock().lock();
            HashMap hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? (Method) hashMap2.get(this.f29001b) : null;
            if (method == null) {
                method = f(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f29001b, method);
            }
            return method;
        } finally {
            this.f29007h.writeLock().unlock();
        }
    }

    public String toString() {
        return this.f29001b + l.f34627b + this.f29006g.toString();
    }

    /* renamed from: fx.b$b  reason: collision with other inner class name */
    public static class C0251b extends b {

        /* renamed from: s  reason: collision with root package name */
        public gx.b f29011s;

        /* renamed from: t  reason: collision with root package name */
        public com.nineoldandroids.animation.a f29012t;

        /* renamed from: u  reason: collision with root package name */
        public int f29013u;

        public C0251b(String str, int... iArr) {
            super(str);
            l(iArr);
        }

        public void b(float f11) {
            this.f29013u = this.f29012t.f(f11);
        }

        public Object d() {
            return Integer.valueOf(this.f29013u);
        }

        public void k(Object obj) {
            gx.b bVar = this.f29011s;
            if (bVar != null) {
                bVar.e(obj, this.f29013u);
                return;
            }
            c cVar = this.f29002c;
            if (cVar != null) {
                cVar.c(obj, Integer.valueOf(this.f29013u));
            } else if (this.f29003d != null) {
                try {
                    this.f29008i[0] = Integer.valueOf(this.f29013u);
                    this.f29003d.invoke(obj, this.f29008i);
                } catch (InvocationTargetException e11) {
                    Log.e("PropertyValuesHolder", e11.toString());
                } catch (IllegalAccessException e12) {
                    Log.e("PropertyValuesHolder", e12.toString());
                }
            }
        }

        public void l(int... iArr) {
            b.super.l(iArr);
            this.f29012t = (com.nineoldandroids.animation.a) this.f29006g;
        }

        public void o(Class cls) {
            if (this.f29002c == null) {
                b.super.o(cls);
            }
        }

        /* renamed from: r */
        public C0251b clone() {
            C0251b bVar = (C0251b) b.super.clone();
            bVar.f29012t = (com.nineoldandroids.animation.a) bVar.f29006g;
            return bVar;
        }

        public C0251b(c cVar, int... iArr) {
            super(cVar);
            l(iArr);
            if (cVar instanceof gx.b) {
                this.f29011s = (gx.b) this.f29002c;
            }
        }
    }

    public b(String str) {
        this.f29003d = null;
        this.f29004e = null;
        this.f29006g = null;
        this.f29007h = new ReentrantReadWriteLock();
        this.f29008i = new Object[1];
        this.f29001b = str;
    }

    public b(c cVar) {
        this.f29003d = null;
        this.f29004e = null;
        this.f29006g = null;
        this.f29007h = new ReentrantReadWriteLock();
        this.f29008i = new Object[1];
        this.f29002c = cVar;
        if (cVar != null) {
            this.f29001b = cVar.b();
        }
    }
}
