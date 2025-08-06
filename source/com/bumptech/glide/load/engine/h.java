package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.e;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.g;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.request.f;
import g4.a;
import java.util.Map;
import java.util.concurrent.Executor;

public class h implements j, g.a, m.a {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f63829i = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    public final o f63830a;

    /* renamed from: b  reason: collision with root package name */
    public final l f63831b;

    /* renamed from: c  reason: collision with root package name */
    public final g f63832c;

    /* renamed from: d  reason: collision with root package name */
    public final b f63833d;

    /* renamed from: e  reason: collision with root package name */
    public final u f63834e;

    /* renamed from: f  reason: collision with root package name */
    public final c f63835f;

    /* renamed from: g  reason: collision with root package name */
    public final a f63836g;

    /* renamed from: h  reason: collision with root package name */
    public final a f63837h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final DecodeJob.e f63838a;

        /* renamed from: b  reason: collision with root package name */
        public final e<DecodeJob<?>> f63839b = g4.a.d(150, new C0703a());

        /* renamed from: c  reason: collision with root package name */
        public int f63840c;

        /* renamed from: com.bumptech.glide.load.engine.h$a$a  reason: collision with other inner class name */
        public class C0703a implements a.d<DecodeJob<?>> {
            public C0703a() {
            }

            /* renamed from: a */
            public DecodeJob<?> create() {
                a aVar = a.this;
                return new DecodeJob<>(aVar.f63838a, aVar.f63839b);
            }
        }

        public a(DecodeJob.e eVar) {
            this.f63838a = eVar;
        }

        public <R> DecodeJob<R> a(com.bumptech.glide.b bVar, Object obj, k kVar, n3.b bVar2, int i11, int i12, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, n3.g<?>> map, boolean z11, boolean z12, boolean z13, Options options, DecodeJob.b<R> bVar3) {
            DecodeJob decodeJob = (DecodeJob) f4.h.d(this.f63839b.acquire());
            int i13 = this.f63840c;
            int i14 = i13;
            this.f63840c = i13 + 1;
            return decodeJob.o(bVar, obj, kVar, bVar2, i11, i12, cls, cls2, priority, diskCacheStrategy, map, z11, z12, z13, options, bVar3, i14);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final r3.a f63842a;

        /* renamed from: b  reason: collision with root package name */
        public final r3.a f63843b;

        /* renamed from: c  reason: collision with root package name */
        public final r3.a f63844c;

        /* renamed from: d  reason: collision with root package name */
        public final r3.a f63845d;

        /* renamed from: e  reason: collision with root package name */
        public final j f63846e;

        /* renamed from: f  reason: collision with root package name */
        public final m.a f63847f;

        /* renamed from: g  reason: collision with root package name */
        public final e<i<?>> f63848g = g4.a.d(150, new a());

        public class a implements a.d<i<?>> {
            public a() {
            }

            /* renamed from: a */
            public i<?> create() {
                b bVar = b.this;
                return new i(bVar.f63842a, bVar.f63843b, bVar.f63844c, bVar.f63845d, bVar.f63846e, bVar.f63847f, bVar.f63848g);
            }
        }

        public b(r3.a aVar, r3.a aVar2, r3.a aVar3, r3.a aVar4, j jVar, m.a aVar5) {
            this.f63842a = aVar;
            this.f63843b = aVar2;
            this.f63844c = aVar3;
            this.f63845d = aVar4;
            this.f63846e = jVar;
            this.f63847f = aVar5;
        }

        public <R> i<R> a(n3.b bVar, boolean z11, boolean z12, boolean z13, boolean z14) {
            return ((i) f4.h.d(this.f63848g.acquire())).l(bVar, z11, z12, z13, z14);
        }
    }

    public static class c implements DecodeJob.e {

        /* renamed from: a  reason: collision with root package name */
        public final a.C0702a f63850a;

        /* renamed from: b  reason: collision with root package name */
        public volatile com.bumptech.glide.load.engine.cache.a f63851b;

        public c(a.C0702a aVar) {
            this.f63850a = aVar;
        }

        public com.bumptech.glide.load.engine.cache.a a() {
            if (this.f63851b == null) {
                synchronized (this) {
                    if (this.f63851b == null) {
                        this.f63851b = this.f63850a.build();
                    }
                    if (this.f63851b == null) {
                        this.f63851b = new DiskCacheAdapter();
                    }
                }
            }
            return this.f63851b;
        }
    }

    public class d {

        /* renamed from: a  reason: collision with root package name */
        public final i<?> f63852a;

        /* renamed from: b  reason: collision with root package name */
        public final f f63853b;

        public d(f fVar, i<?> iVar) {
            this.f63853b = fVar;
            this.f63852a = iVar;
        }

        public void a() {
            synchronized (h.this) {
                this.f63852a.r(this.f63853b);
            }
        }
    }

    public h(g gVar, a.C0702a aVar, r3.a aVar2, r3.a aVar3, r3.a aVar4, r3.a aVar5, boolean z11) {
        this(gVar, aVar, aVar2, aVar3, aVar4, aVar5, (o) null, (l) null, (a) null, (b) null, (a) null, (u) null, z11);
    }

    public static void k(String str, long j11, n3.b bVar) {
        Log.v("Engine", str + " in " + f4.e.a(j11) + "ms, key: " + bVar);
    }

    public void a(n3.b bVar, m<?> mVar) {
        this.f63837h.d(bVar);
        if (mVar.d()) {
            this.f63832c.c(bVar, mVar);
        } else {
            this.f63834e.a(mVar, false);
        }
    }

    public synchronized void b(i<?> iVar, n3.b bVar) {
        this.f63830a.d(bVar, iVar);
    }

    public void c(r<?> rVar) {
        this.f63834e.a(rVar, true);
    }

    public synchronized void d(i<?> iVar, n3.b bVar, m<?> mVar) {
        if (mVar != null) {
            if (mVar.d()) {
                this.f63837h.a(bVar, mVar);
            }
        }
        this.f63830a.d(bVar, iVar);
    }

    public void e() {
        this.f63835f.a().clear();
    }

    public final m<?> f(n3.b bVar) {
        r<?> d11 = this.f63832c.d(bVar);
        if (d11 == null) {
            return null;
        }
        if (d11 instanceof m) {
            return (m) d11;
        }
        return new m<>(d11, true, true, bVar, this);
    }

    public <R> d g(com.bumptech.glide.b bVar, Object obj, n3.b bVar2, int i11, int i12, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, n3.g<?>> map, boolean z11, boolean z12, Options options, boolean z13, boolean z14, boolean z15, boolean z16, f fVar, Executor executor) {
        long b11 = f63829i ? f4.e.b() : 0;
        k a11 = this.f63831b.a(obj, bVar2, i11, i12, map, cls, cls2, options);
        synchronized (this) {
            m<?> j11 = j(a11, z13, b11);
            if (j11 == null) {
                d m11 = m(bVar, obj, bVar2, i11, i12, cls, cls2, priority, diskCacheStrategy, map, z11, z12, options, z13, z14, z15, z16, fVar, executor, a11, b11);
                return m11;
            }
            fVar.c(j11, DataSource.MEMORY_CACHE);
            return null;
        }
    }

    public final m<?> h(n3.b bVar) {
        m<?> e11 = this.f63837h.e(bVar);
        if (e11 != null) {
            e11.b();
        }
        return e11;
    }

    public final m<?> i(n3.b bVar) {
        m<?> f11 = f(bVar);
        if (f11 != null) {
            f11.b();
            this.f63837h.a(bVar, f11);
        }
        return f11;
    }

    public final m<?> j(k kVar, boolean z11, long j11) {
        if (!z11) {
            return null;
        }
        m<?> h11 = h(kVar);
        if (h11 != null) {
            if (f63829i) {
                k("Loaded resource from active resources", j11, kVar);
            }
            return h11;
        }
        m<?> i11 = i(kVar);
        if (i11 == null) {
            return null;
        }
        if (f63829i) {
            k("Loaded resource from cache", j11, kVar);
        }
        return i11;
    }

    public void l(r<?> rVar) {
        if (rVar instanceof m) {
            ((m) rVar).e();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public final <R> d m(com.bumptech.glide.b bVar, Object obj, n3.b bVar2, int i11, int i12, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, n3.g<?>> map, boolean z11, boolean z12, Options options, boolean z13, boolean z14, boolean z15, boolean z16, f fVar, Executor executor, k kVar, long j11) {
        f fVar2 = fVar;
        Executor executor2 = executor;
        k kVar2 = kVar;
        long j12 = j11;
        i<?> a11 = this.f63830a.a(kVar2, z16);
        if (a11 != null) {
            a11.a(fVar2, executor2);
            if (f63829i) {
                k("Added to existing load", j12, kVar2);
            }
            return new d(fVar2, a11);
        }
        i a12 = this.f63833d.a(kVar, z13, z14, z15, z16);
        i iVar = a12;
        k kVar3 = kVar2;
        DecodeJob<R> a13 = this.f63836g.a(bVar, obj, kVar, bVar2, i11, i12, cls, cls2, priority, diskCacheStrategy, map, z11, z12, z16, options, a12);
        this.f63830a.c(kVar3, iVar);
        i iVar2 = iVar;
        k kVar4 = kVar3;
        f fVar3 = fVar;
        iVar2.a(fVar3, executor);
        iVar2.s(a13);
        if (f63829i) {
            k("Started new load", j11, kVar4);
        }
        return new d(fVar3, iVar2);
    }

    public h(g gVar, a.C0702a aVar, r3.a aVar2, r3.a aVar3, r3.a aVar4, r3.a aVar5, o oVar, l lVar, a aVar6, b bVar, a aVar7, u uVar, boolean z11) {
        this.f63832c = gVar;
        a.C0702a aVar8 = aVar;
        c cVar = new c(aVar);
        this.f63835f = cVar;
        a aVar9 = aVar6 == null ? new a(z11) : aVar6;
        this.f63837h = aVar9;
        aVar9.f(this);
        this.f63831b = lVar == null ? new l() : lVar;
        this.f63830a = oVar == null ? new o() : oVar;
        this.f63833d = bVar == null ? new b(aVar2, aVar3, aVar4, aVar5, this, this) : bVar;
        this.f63836g = aVar7 == null ? new a(cVar) : aVar7;
        this.f63834e = uVar == null ? new u() : uVar;
        gVar.e(this);
    }
}
