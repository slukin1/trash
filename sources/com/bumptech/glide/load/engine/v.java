package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.model.d;
import java.util.Collections;
import java.util.List;
import n3.b;
import o3.d;

public class v implements e, e.a {

    /* renamed from: b  reason: collision with root package name */
    public final f<?> f63935b;

    /* renamed from: c  reason: collision with root package name */
    public final e.a f63936c;

    /* renamed from: d  reason: collision with root package name */
    public int f63937d;

    /* renamed from: e  reason: collision with root package name */
    public b f63938e;

    /* renamed from: f  reason: collision with root package name */
    public Object f63939f;

    /* renamed from: g  reason: collision with root package name */
    public volatile d.a<?> f63940g;

    /* renamed from: h  reason: collision with root package name */
    public c f63941h;

    public class a implements d.a<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a f63942b;

        public a(d.a aVar) {
            this.f63942b = aVar;
        }

        public void d(Object obj) {
            if (v.this.g(this.f63942b)) {
                v.this.h(this.f63942b, obj);
            }
        }

        public void e(Exception exc) {
            if (v.this.g(this.f63942b)) {
                v.this.i(this.f63942b, exc);
            }
        }
    }

    public v(f<?> fVar, e.a aVar) {
        this.f63935b = fVar;
        this.f63936c = aVar;
    }

    public boolean a() {
        Object obj = this.f63939f;
        if (obj != null) {
            this.f63939f = null;
            d(obj);
        }
        b bVar = this.f63938e;
        if (bVar != null && bVar.a()) {
            return true;
        }
        this.f63938e = null;
        this.f63940g = null;
        boolean z11 = false;
        while (!z11 && e()) {
            List<d.a<?>> g11 = this.f63935b.g();
            int i11 = this.f63937d;
            this.f63937d = i11 + 1;
            this.f63940g = g11.get(i11);
            if (this.f63940g != null && (this.f63935b.e().c(this.f63940g.f63995c.c()) || this.f63935b.t(this.f63940g.f63995c.a()))) {
                j(this.f63940g);
                z11 = true;
            }
        }
        return z11;
    }

    public void b(b bVar, Object obj, o3.d<?> dVar, DataSource dataSource, b bVar2) {
        this.f63936c.b(bVar, obj, dVar, this.f63940g.f63995c.c(), bVar);
    }

    public void c(b bVar, Exception exc, o3.d<?> dVar, DataSource dataSource) {
        this.f63936c.c(bVar, exc, dVar, this.f63940g.f63995c.c());
    }

    public void cancel() {
        d.a<?> aVar = this.f63940g;
        if (aVar != null) {
            aVar.f63995c.cancel();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void d(Object obj) {
        long b11 = f4.e.b();
        try {
            n3.a<X> p11 = this.f63935b.p(obj);
            d dVar = new d(p11, obj, this.f63935b.k());
            this.f63941h = new c(this.f63940g.f63993a, this.f63935b.o());
            this.f63935b.d().b(this.f63941h, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f63941h + ", data: " + obj + ", encoder: " + p11 + ", duration: " + f4.e.a(b11));
            }
            this.f63940g.f63995c.b();
            this.f63938e = new b(Collections.singletonList(this.f63940g.f63993a), this.f63935b, this);
        } catch (Throwable th2) {
            this.f63940g.f63995c.b();
            throw th2;
        }
    }

    public final boolean e() {
        return this.f63937d < this.f63935b.g().size();
    }

    public void f() {
        throw new UnsupportedOperationException();
    }

    public boolean g(d.a<?> aVar) {
        d.a<?> aVar2 = this.f63940g;
        return aVar2 != null && aVar2 == aVar;
    }

    public void h(d.a<?> aVar, Object obj) {
        DiskCacheStrategy e11 = this.f63935b.e();
        if (obj == null || !e11.c(aVar.f63995c.c())) {
            e.a aVar2 = this.f63936c;
            b bVar = aVar.f63993a;
            o3.d<Data> dVar = aVar.f63995c;
            aVar2.b(bVar, obj, dVar, dVar.c(), this.f63941h);
            return;
        }
        this.f63939f = obj;
        this.f63936c.f();
    }

    public void i(d.a<?> aVar, Exception exc) {
        e.a aVar2 = this.f63936c;
        c cVar = this.f63941h;
        o3.d<Data> dVar = aVar.f63995c;
        aVar2.c(cVar, exc, dVar, dVar.c());
    }

    public final void j(d.a<?> aVar) {
        this.f63940g.f63995c.f(this.f63935b.l(), new a(aVar));
    }
}
