package com.bumptech.glide;

import a4.e;
import a4.h;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import c4.g;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.manager.a;
import com.bumptech.glide.request.RequestOptions;
import f4.i;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class d implements ComponentCallbacks2, e {

    /* renamed from: n  reason: collision with root package name */
    public static final RequestOptions f63619n = ((RequestOptions) RequestOptions.s0(Bitmap.class).S());

    /* renamed from: o  reason: collision with root package name */
    public static final RequestOptions f63620o = ((RequestOptions) RequestOptions.s0(y3.c.class).S());

    /* renamed from: p  reason: collision with root package name */
    public static final RequestOptions f63621p = ((RequestOptions) ((RequestOptions) RequestOptions.t0(DiskCacheStrategy.f63711c).c0(Priority.LOW)).k0(true));

    /* renamed from: b  reason: collision with root package name */
    public final a f63622b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f63623c;

    /* renamed from: d  reason: collision with root package name */
    public final a4.d f63624d;

    /* renamed from: e  reason: collision with root package name */
    public final RequestTracker f63625e;

    /* renamed from: f  reason: collision with root package name */
    public final h f63626f;

    /* renamed from: g  reason: collision with root package name */
    public final TargetTracker f63627g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f63628h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f63629i;

    /* renamed from: j  reason: collision with root package name */
    public final com.bumptech.glide.manager.a f63630j;

    /* renamed from: k  reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bumptech.glide.request.e<Object>> f63631k;

    /* renamed from: l  reason: collision with root package name */
    public RequestOptions f63632l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f63633m;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d dVar = d.this;
            dVar.f63624d.b(dVar);
        }
    }

    public static class b extends c4.b<View, Object> {
        public b(View view) {
            super(view);
        }

        public void d(Drawable drawable) {
        }

        public void onLoadFailed(Drawable drawable) {
        }

        public void onResourceReady(Object obj, com.bumptech.glide.request.transition.a<? super Object> aVar) {
        }
    }

    public class c implements a.C0706a {

        /* renamed from: a  reason: collision with root package name */
        public final RequestTracker f63635a;

        public c(RequestTracker requestTracker) {
            this.f63635a = requestTracker;
        }

        public void a(boolean z11) {
            if (z11) {
                synchronized (d.this) {
                    this.f63635a.e();
                }
            }
        }
    }

    public d(a aVar, a4.d dVar, h hVar, Context context) {
        this(aVar, dVar, hVar, new RequestTracker(), aVar.h(), context);
    }

    public <ResourceType> c<ResourceType> a(Class<ResourceType> cls) {
        return new c<>(this.f63622b, this, cls, this.f63623c);
    }

    public c<Bitmap> b() {
        return a(Bitmap.class).b(f63619n);
    }

    public c<Drawable> c() {
        return a(Drawable.class);
    }

    public c<File> d() {
        return a(File.class).b(RequestOptions.v0(true));
    }

    public c<y3.c> e() {
        return a(y3.c.class).b(f63620o);
    }

    public void f(View view) {
        g(new b(view));
    }

    public void g(g<?> gVar) {
        if (gVar != null) {
            z(gVar);
        }
    }

    public c<File> h() {
        return a(File.class).b(f63621p);
    }

    public List<com.bumptech.glide.request.e<Object>> i() {
        return this.f63631k;
    }

    public synchronized RequestOptions j() {
        return this.f63632l;
    }

    public <T> TransitionOptions<?, T> k(Class<T> cls) {
        return this.f63622b.j().e(cls);
    }

    public c<Drawable> l(Bitmap bitmap) {
        return c().H0(bitmap);
    }

    public c<Drawable> m(Uri uri) {
        return c().I0(uri);
    }

    public c<Drawable> n(File file) {
        return c().J0(file);
    }

    public c<Drawable> o(Integer num) {
        return c().K0(num);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public synchronized void onDestroy() {
        this.f63627g.onDestroy();
        for (g<?> g11 : this.f63627g.b()) {
            g(g11);
        }
        this.f63627g.a();
        this.f63625e.b();
        this.f63624d.a(this);
        this.f63624d.a(this.f63630j);
        this.f63629i.removeCallbacks(this.f63628h);
        this.f63622b.t(this);
    }

    public void onLowMemory() {
    }

    public synchronized void onStart() {
        u();
        this.f63627g.onStart();
    }

    public synchronized void onStop() {
        t();
        this.f63627g.onStop();
    }

    public void onTrimMemory(int i11) {
        if (i11 == 60 && this.f63633m) {
            s();
        }
    }

    public c<Drawable> p(Object obj) {
        return c().L0(obj);
    }

    public c<Drawable> q(String str) {
        return c().M0(str);
    }

    public synchronized void r() {
        this.f63625e.c();
    }

    public synchronized void s() {
        r();
        for (d r11 : this.f63626f.a()) {
            r11.r();
        }
    }

    public synchronized void t() {
        this.f63625e.d();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f63625e + ", treeNode=" + this.f63626f + "}";
    }

    public synchronized void u() {
        this.f63625e.f();
    }

    public synchronized d v(RequestOptions requestOptions) {
        w(requestOptions);
        return this;
    }

    public synchronized void w(RequestOptions requestOptions) {
        this.f63632l = (RequestOptions) ((RequestOptions) requestOptions.clone()).c();
    }

    public synchronized void x(g<?> gVar, com.bumptech.glide.request.c cVar) {
        this.f63627g.c(gVar);
        this.f63625e.g(cVar);
    }

    public synchronized boolean y(g<?> gVar) {
        com.bumptech.glide.request.c request = gVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f63625e.a(request)) {
            return false;
        }
        this.f63627g.d(gVar);
        gVar.setRequest((com.bumptech.glide.request.c) null);
        return true;
    }

    public final void z(g<?> gVar) {
        boolean y11 = y(gVar);
        com.bumptech.glide.request.c request = gVar.getRequest();
        if (!y11 && !this.f63622b.q(gVar) && request != null) {
            gVar.setRequest((com.bumptech.glide.request.c) null);
            request.clear();
        }
    }

    public d(a aVar, a4.d dVar, h hVar, RequestTracker requestTracker, com.bumptech.glide.manager.b bVar, Context context) {
        this.f63627g = new TargetTracker();
        a aVar2 = new a();
        this.f63628h = aVar2;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f63629i = handler;
        this.f63622b = aVar;
        this.f63624d = dVar;
        this.f63626f = hVar;
        this.f63625e = requestTracker;
        this.f63623c = context;
        com.bumptech.glide.manager.a a11 = bVar.a(context.getApplicationContext(), new c(requestTracker));
        this.f63630j = a11;
        if (i.q()) {
            handler.post(aVar2);
        } else {
            dVar.b(this);
        }
        dVar.b(a11);
        this.f63631k = new CopyOnWriteArrayList<>(aVar.j().c());
        w(aVar.j().d());
        aVar.p(this);
    }
}
