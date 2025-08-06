package com.bumptech.glide.load.model;

import androidx.core.util.e;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.d;
import f4.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class f {

    /* renamed from: e  reason: collision with root package name */
    public static final c f64005e = new c();

    /* renamed from: f  reason: collision with root package name */
    public static final d<Object, Object> f64006f = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<b<?, ?>> f64007a;

    /* renamed from: b  reason: collision with root package name */
    public final c f64008b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<b<?, ?>> f64009c;

    /* renamed from: d  reason: collision with root package name */
    public final e<List<Throwable>> f64010d;

    public static class a implements d<Object, Object> {
        public d.a<Object> a(Object obj, int i11, int i12, Options options) {
            return null;
        }

        public boolean b(Object obj) {
            return false;
        }
    }

    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<Model> f64011a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<Data> f64012b;

        /* renamed from: c  reason: collision with root package name */
        public final s3.d<? extends Model, ? extends Data> f64013c;

        public b(Class<Model> cls, Class<Data> cls2, s3.d<? extends Model, ? extends Data> dVar) {
            this.f64011a = cls;
            this.f64012b = cls2;
            this.f64013c = dVar;
        }

        public boolean a(Class<?> cls) {
            return this.f64011a.isAssignableFrom(cls);
        }

        public boolean b(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f64012b.isAssignableFrom(cls2);
        }
    }

    public static class c {
        public <Model, Data> e<Model, Data> a(List<d<Model, Data>> list, e<List<Throwable>> eVar) {
            return new e<>(list, eVar);
        }
    }

    public f(e<List<Throwable>> eVar) {
        this(eVar, f64005e);
    }

    public static <Model, Data> d<Model, Data> f() {
        return f64006f;
    }

    public final <Model, Data> void a(Class<Model> cls, Class<Data> cls2, s3.d<? extends Model, ? extends Data> dVar, boolean z11) {
        b bVar = new b(cls, cls2, dVar);
        List<b<?, ?>> list = this.f64007a;
        list.add(z11 ? list.size() : 0, bVar);
    }

    public synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, s3.d<? extends Model, ? extends Data> dVar) {
        a(cls, cls2, dVar, true);
    }

    public final <Model, Data> d<Model, Data> c(b<?, ?> bVar) {
        return (d) h.d(bVar.f64013c.b(this));
    }

    public synchronized <Model, Data> d<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z11 = false;
            for (b next : this.f64007a) {
                if (this.f64009c.contains(next)) {
                    z11 = true;
                } else if (next.b(cls, cls2)) {
                    this.f64009c.add(next);
                    arrayList.add(c(next));
                    this.f64009c.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f64008b.a(arrayList, this.f64010d);
            } else if (arrayList.size() == 1) {
                return (d) arrayList.get(0);
            } else if (z11) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th2) {
            this.f64009c.clear();
            throw th2;
        }
    }

    public synchronized <Model> List<d<Model, ?>> e(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b next : this.f64007a) {
                if (!this.f64009c.contains(next)) {
                    if (next.a(cls)) {
                        this.f64009c.add(next);
                        arrayList.add(c(next));
                        this.f64009c.remove(next);
                    }
                }
            }
        } catch (Throwable th2) {
            this.f64009c.clear();
            throw th2;
        }
        return arrayList;
    }

    public synchronized List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b next : this.f64007a) {
            if (!arrayList.contains(next.f64012b) && next.a(cls)) {
                arrayList.add(next.f64012b);
            }
        }
        return arrayList;
    }

    public final <Model, Data> s3.d<Model, Data> h(b<?, ?> bVar) {
        return bVar.f64013c;
    }

    public synchronized <Model, Data> List<s3.d<? extends Model, ? extends Data>> i(Class<Model> cls, Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it2 = this.f64007a.iterator();
        while (it2.hasNext()) {
            b next = it2.next();
            if (next.b(cls, cls2)) {
                it2.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> List<s3.d<? extends Model, ? extends Data>> j(Class<Model> cls, Class<Data> cls2, s3.d<? extends Model, ? extends Data> dVar) {
        List<s3.d<? extends Model, ? extends Data>> i11;
        i11 = i(cls, cls2);
        b(cls, cls2, dVar);
        return i11;
    }

    public f(e<List<Throwable>> eVar, c cVar) {
        this.f64007a = new ArrayList();
        this.f64009c = new HashSet();
        this.f64010d = eVar;
        this.f64008b = cVar;
    }
}
