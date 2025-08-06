package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import f4.h;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements b {

    /* renamed from: a  reason: collision with root package name */
    public final f<a, Object> f63738a;

    /* renamed from: b  reason: collision with root package name */
    public final b f63739b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f63740c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Class<?>, a<?>> f63741d;

    /* renamed from: e  reason: collision with root package name */
    public final int f63742e;

    /* renamed from: f  reason: collision with root package name */
    public int f63743f;

    public static final class a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final b f63744a;

        /* renamed from: b  reason: collision with root package name */
        public int f63745b;

        /* renamed from: c  reason: collision with root package name */
        public Class<?> f63746c;

        public a(b bVar) {
            this.f63744a = bVar;
        }

        public void a() {
            this.f63744a.c(this);
        }

        public void b(int i11, Class<?> cls) {
            this.f63745b = i11;
            this.f63746c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f63745b == aVar.f63745b && this.f63746c == aVar.f63746c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11 = this.f63745b * 31;
            Class<?> cls = this.f63746c;
            return i11 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f63745b + "array=" + this.f63746c + '}';
        }
    }

    public static final class b extends d<a> {
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        public a e(int i11, Class<?> cls) {
            a aVar = (a) b();
            aVar.b(i11, cls);
            return aVar;
        }
    }

    public LruArrayPool() {
        this.f63738a = new f<>();
        this.f63739b = new b();
        this.f63740c = new HashMap();
        this.f63741d = new HashMap();
        this.f63742e = 4194304;
    }

    public synchronized void a(int i11) {
        if (i11 >= 40) {
            try {
                b();
            } catch (Throwable th2) {
                throw th2;
            }
        } else if (i11 >= 20 || i11 == 15) {
            g(this.f63742e / 2);
        }
    }

    public synchronized void b() {
        g(0);
    }

    public synchronized <T> T c(int i11, Class<T> cls) {
        a aVar;
        Integer ceilingKey = l(cls).ceilingKey(Integer.valueOf(i11));
        if (o(i11, ceilingKey)) {
            aVar = this.f63739b.e(ceilingKey.intValue(), cls);
        } else {
            aVar = this.f63739b.e(i11, cls);
        }
        return k(aVar, cls);
    }

    public synchronized <T> T d(int i11, Class<T> cls) {
        return k(this.f63739b.e(i11, cls), cls);
    }

    public final void e(int i11, Class<?> cls) {
        NavigableMap<Integer, Integer> l11 = l(cls);
        Integer num = (Integer) l11.get(Integer.valueOf(i11));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i11 + ", this: " + this);
        } else if (num.intValue() == 1) {
            l11.remove(Integer.valueOf(i11));
        } else {
            l11.put(Integer.valueOf(i11), Integer.valueOf(num.intValue() - 1));
        }
    }

    public final void f() {
        g(this.f63742e);
    }

    public final void g(int i11) {
        while (this.f63743f > i11) {
            Object f11 = this.f63738a.f();
            h.d(f11);
            a h11 = h(f11);
            this.f63743f -= h11.a(f11) * h11.b();
            e(h11.a(f11), f11.getClass());
            if (Log.isLoggable(h11.getTag(), 2)) {
                Log.v(h11.getTag(), "evicted: " + h11.a(f11));
            }
        }
    }

    public final <T> a<T> h(T t11) {
        return i(t11.getClass());
    }

    public final <T> a<T> i(Class<T> cls) {
        a<T> aVar = this.f63741d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                aVar = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f63741d.put(cls, aVar);
        }
        return aVar;
    }

    public final <T> T j(a aVar) {
        return this.f63738a.a(aVar);
    }

    public final <T> T k(a aVar, Class<T> cls) {
        a<T> i11 = i(cls);
        T j11 = j(aVar);
        if (j11 != null) {
            this.f63743f -= i11.a(j11) * i11.b();
            e(i11.a(j11), cls);
        }
        if (j11 != null) {
            return j11;
        }
        if (Log.isLoggable(i11.getTag(), 2)) {
            Log.v(i11.getTag(), "Allocated " + aVar.f63745b + " bytes");
        }
        return i11.newArray(aVar.f63745b);
    }

    public final NavigableMap<Integer, Integer> l(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f63740c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f63740c.put(cls, treeMap);
        return treeMap;
    }

    public final boolean m() {
        int i11 = this.f63743f;
        return i11 == 0 || this.f63742e / i11 >= 2;
    }

    public final boolean n(int i11) {
        return i11 <= this.f63742e / 2;
    }

    public final boolean o(int i11, Integer num) {
        return num != null && (m() || num.intValue() <= i11 * 8);
    }

    public synchronized <T> void put(T t11) {
        Class<?> cls = t11.getClass();
        a<?> i11 = i(cls);
        int a11 = i11.a(t11);
        int b11 = i11.b() * a11;
        if (n(b11)) {
            a e11 = this.f63739b.e(a11, cls);
            this.f63738a.d(e11, t11);
            NavigableMap<Integer, Integer> l11 = l(cls);
            Integer num = (Integer) l11.get(Integer.valueOf(e11.f63745b));
            Integer valueOf = Integer.valueOf(e11.f63745b);
            int i12 = 1;
            if (num != null) {
                i12 = 1 + num.intValue();
            }
            l11.put(valueOf, Integer.valueOf(i12));
            this.f63743f += b11;
            f();
        }
    }

    public LruArrayPool(int i11) {
        this.f63738a = new f<>();
        this.f63739b = new b();
        this.f63740c = new HashMap();
        this.f63741d = new HashMap();
        this.f63742e = i11;
    }
}
