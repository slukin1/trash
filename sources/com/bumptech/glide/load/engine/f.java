package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.model.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n3.b;
import n3.g;

public final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    public final List<d.a<?>> f63806a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f63807b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public com.bumptech.glide.b f63808c;

    /* renamed from: d  reason: collision with root package name */
    public Object f63809d;

    /* renamed from: e  reason: collision with root package name */
    public int f63810e;

    /* renamed from: f  reason: collision with root package name */
    public int f63811f;

    /* renamed from: g  reason: collision with root package name */
    public Class<?> f63812g;

    /* renamed from: h  reason: collision with root package name */
    public DecodeJob.e f63813h;

    /* renamed from: i  reason: collision with root package name */
    public Options f63814i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Class<?>, g<?>> f63815j;

    /* renamed from: k  reason: collision with root package name */
    public Class<Transcode> f63816k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f63817l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f63818m;

    /* renamed from: n  reason: collision with root package name */
    public b f63819n;

    /* renamed from: o  reason: collision with root package name */
    public Priority f63820o;

    /* renamed from: p  reason: collision with root package name */
    public DiskCacheStrategy f63821p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f63822q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f63823r;

    public void a() {
        this.f63808c = null;
        this.f63809d = null;
        this.f63819n = null;
        this.f63812g = null;
        this.f63816k = null;
        this.f63814i = null;
        this.f63820o = null;
        this.f63815j = null;
        this.f63821p = null;
        this.f63806a.clear();
        this.f63817l = false;
        this.f63807b.clear();
        this.f63818m = false;
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.b b() {
        return this.f63808c.b();
    }

    public List<b> c() {
        if (!this.f63818m) {
            this.f63818m = true;
            this.f63807b.clear();
            List<d.a<?>> g11 = g();
            int size = g11.size();
            for (int i11 = 0; i11 < size; i11++) {
                d.a aVar = g11.get(i11);
                if (!this.f63807b.contains(aVar.f63993a)) {
                    this.f63807b.add(aVar.f63993a);
                }
                for (int i12 = 0; i12 < aVar.f63994b.size(); i12++) {
                    if (!this.f63807b.contains(aVar.f63994b.get(i12))) {
                        this.f63807b.add(aVar.f63994b.get(i12));
                    }
                }
            }
        }
        return this.f63807b;
    }

    public a d() {
        return this.f63813h.a();
    }

    public DiskCacheStrategy e() {
        return this.f63821p;
    }

    public int f() {
        return this.f63811f;
    }

    public List<d.a<?>> g() {
        if (!this.f63817l) {
            this.f63817l = true;
            this.f63806a.clear();
            List i11 = this.f63808c.h().i(this.f63809d);
            int size = i11.size();
            for (int i12 = 0; i12 < size; i12++) {
                d.a a11 = ((d) i11.get(i12)).a(this.f63809d, this.f63810e, this.f63811f, this.f63814i);
                if (a11 != null) {
                    this.f63806a.add(a11);
                }
            }
        }
        return this.f63806a;
    }

    public <Data> p<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f63808c.h().h(cls, this.f63812g, this.f63816k);
    }

    public Class<?> i() {
        return this.f63809d.getClass();
    }

    public List<d<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f63808c.h().i(file);
    }

    public Options k() {
        return this.f63814i;
    }

    public Priority l() {
        return this.f63820o;
    }

    public List<Class<?>> m() {
        return this.f63808c.h().j(this.f63809d.getClass(), this.f63812g, this.f63816k);
    }

    public <Z> n3.f<Z> n(r<Z> rVar) {
        return this.f63808c.h().k(rVar);
    }

    public b o() {
        return this.f63819n;
    }

    public <X> n3.a<X> p(X x11) throws Registry.NoSourceEncoderAvailableException {
        return this.f63808c.h().m(x11);
    }

    public Class<?> q() {
        return this.f63816k;
    }

    public <Z> g<Z> r(Class<Z> cls) {
        g<Z> gVar = this.f63815j.get(cls);
        if (gVar == null) {
            Iterator<Map.Entry<Class<?>, g<?>>> it2 = this.f63815j.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    gVar = (g) next.getValue();
                    break;
                }
            }
        }
        if (gVar != null) {
            return gVar;
        }
        if (!this.f63815j.isEmpty() || !this.f63822q) {
            return u3.b.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public int s() {
        return this.f63810e;
    }

    public boolean t(Class<?> cls) {
        return h(cls) != null;
    }

    public <R> void u(com.bumptech.glide.b bVar, Object obj, b bVar2, int i11, int i12, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, g<?>> map, boolean z11, boolean z12, DecodeJob.e eVar) {
        this.f63808c = bVar;
        this.f63809d = obj;
        this.f63819n = bVar2;
        this.f63810e = i11;
        this.f63811f = i12;
        this.f63821p = diskCacheStrategy;
        this.f63812g = cls;
        this.f63813h = eVar;
        this.f63816k = cls2;
        this.f63820o = priority;
        this.f63814i = options;
        this.f63815j = map;
        this.f63822q = z11;
        this.f63823r = z12;
    }

    public boolean v(r<?> rVar) {
        return this.f63808c.h().n(rVar);
    }

    public boolean w() {
        return this.f63823r;
    }

    public boolean x(b bVar) {
        List<d.a<?>> g11 = g();
        int size = g11.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (g11.get(i11).f63993a.equals(bVar)) {
                return true;
            }
        }
        return false;
    }
}
