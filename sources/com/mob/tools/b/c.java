package com.mob.tools.b;

import android.content.Context;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f27763a = new c();

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f27764b;

    /* renamed from: c  reason: collision with root package name */
    private volatile a f27765c;

    /* renamed from: d  reason: collision with root package name */
    private volatile a f27766d;

    /* renamed from: e  reason: collision with root package name */
    private volatile a f27767e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f27768f = new AtomicBoolean(false);

    public static c a(Context context) {
        if (f27763a.f27764b == null && context != null) {
            f27763a.f27764b = context.getApplicationContext();
        }
        return f27763a;
    }

    public void b() {
        if (this.f27768f.compareAndSet(false, true)) {
            d();
            c();
            e.a(this.f27764b);
        }
    }

    public a c() {
        if (this.f27765c == null) {
            this.f27765c = new i(this.f27764b);
        }
        return this.f27765c;
    }

    public a d() {
        if (this.f27766d == null) {
            this.f27766d = new g(this.f27764b);
        }
        return this.f27766d;
    }

    public a e() {
        if (this.f27767e == null) {
            return c();
        }
        return this.f27767e;
    }

    public CountDownLatch a() {
        b();
        return d.a(this.f27764b).a();
    }

    public boolean a(a aVar) {
        this.f27767e = aVar;
        return true;
    }
}
