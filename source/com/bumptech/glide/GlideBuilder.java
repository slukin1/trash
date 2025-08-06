package com.bumptech.glide;

import a4.g;
import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.a;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.f;
import com.bumptech.glide.load.engine.cache.g;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import q3.b;

public final class GlideBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, TransitionOptions<?, ?>> f63563a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    public h f63564b;

    /* renamed from: c  reason: collision with root package name */
    public e f63565c;

    /* renamed from: d  reason: collision with root package name */
    public b f63566d;

    /* renamed from: e  reason: collision with root package name */
    public g f63567e;

    /* renamed from: f  reason: collision with root package name */
    public r3.a f63568f;

    /* renamed from: g  reason: collision with root package name */
    public r3.a f63569g;

    /* renamed from: h  reason: collision with root package name */
    public a.C0702a f63570h;

    /* renamed from: i  reason: collision with root package name */
    public q3.b f63571i;

    /* renamed from: j  reason: collision with root package name */
    public com.bumptech.glide.manager.b f63572j;

    /* renamed from: k  reason: collision with root package name */
    public int f63573k = 4;

    /* renamed from: l  reason: collision with root package name */
    public a.C0697a f63574l = new a();

    /* renamed from: m  reason: collision with root package name */
    public g.b f63575m;

    /* renamed from: n  reason: collision with root package name */
    public r3.a f63576n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f63577o;

    /* renamed from: p  reason: collision with root package name */
    public List<com.bumptech.glide.request.e<Object>> f63578p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f63579q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f63580r;

    public class a implements a.C0697a {
        public a() {
        }

        public RequestOptions build() {
            return new RequestOptions();
        }
    }

    public a a(Context context) {
        Context context2 = context;
        if (this.f63568f == null) {
            this.f63568f = r3.a.g();
        }
        if (this.f63569g == null) {
            this.f63569g = r3.a.e();
        }
        if (this.f63576n == null) {
            this.f63576n = r3.a.c();
        }
        if (this.f63571i == null) {
            this.f63571i = new b.a(context2).a();
        }
        if (this.f63572j == null) {
            this.f63572j = new DefaultConnectivityMonitorFactory();
        }
        if (this.f63565c == null) {
            int b11 = this.f63571i.b();
            if (b11 > 0) {
                this.f63565c = new com.bumptech.glide.load.engine.bitmap_recycle.g((long) b11);
            } else {
                this.f63565c = new BitmapPoolAdapter();
            }
        }
        if (this.f63566d == null) {
            this.f63566d = new LruArrayPool(this.f63571i.a());
        }
        if (this.f63567e == null) {
            this.f63567e = new f((long) this.f63571i.d());
        }
        if (this.f63570h == null) {
            this.f63570h = new com.bumptech.glide.load.engine.cache.e(context2);
        }
        if (this.f63564b == null) {
            this.f63564b = new h(this.f63567e, this.f63570h, this.f63569g, this.f63568f, r3.a.h(), this.f63576n, this.f63577o);
        }
        List<com.bumptech.glide.request.e<Object>> list = this.f63578p;
        if (list == null) {
            this.f63578p = Collections.emptyList();
        } else {
            this.f63578p = Collections.unmodifiableList(list);
        }
        return new a(context, this.f63564b, this.f63567e, this.f63565c, this.f63566d, new a4.g(this.f63575m), this.f63572j, this.f63573k, this.f63574l, this.f63563a, this.f63578p, this.f63579q, this.f63580r);
    }

    public GlideBuilder b(e eVar) {
        this.f63565c = eVar;
        return this;
    }

    public GlideBuilder c(a.C0702a aVar) {
        this.f63570h = aVar;
        return this;
    }

    public GlideBuilder d(com.bumptech.glide.load.engine.cache.g gVar) {
        this.f63567e = gVar;
        return this;
    }

    public void e(g.b bVar) {
        this.f63575m = bVar;
    }
}
