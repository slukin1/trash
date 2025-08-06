package com.bumptech.glide.load.engine;

import androidx.core.util.e;
import f4.h;
import g4.a;
import g4.c;

public final class q<Z> implements r<Z>, a.f {

    /* renamed from: f  reason: collision with root package name */
    public static final e<q<?>> f63909f = g4.a.d(20, new a());

    /* renamed from: b  reason: collision with root package name */
    public final c f63910b = c.a();

    /* renamed from: c  reason: collision with root package name */
    public r<Z> f63911c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63912d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63913e;

    public class a implements a.d<q<?>> {
        /* renamed from: a */
        public q<?> create() {
            return new q<>();
        }
    }

    public static <Z> q<Z> c(r<Z> rVar) {
        q<Z> qVar = (q) h.d(f63909f.acquire());
        qVar.b(rVar);
        return qVar;
    }

    public Class<Z> a() {
        return this.f63911c.a();
    }

    public final void b(r<Z> rVar) {
        this.f63913e = false;
        this.f63912d = true;
        this.f63911c = rVar;
    }

    public final void d() {
        this.f63911c = null;
        f63909f.release(this);
    }

    public c e() {
        return this.f63910b;
    }

    public synchronized void f() {
        this.f63910b.c();
        if (this.f63912d) {
            this.f63912d = false;
            if (this.f63913e) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public Z get() {
        return this.f63911c.get();
    }

    public int getSize() {
        return this.f63911c.getSize();
    }

    public synchronized void recycle() {
        this.f63910b.c();
        this.f63913e = true;
        if (!this.f63912d) {
            this.f63911c.recycle();
            d();
        }
    }
}
