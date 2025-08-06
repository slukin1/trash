package com.nostra13.universalimageloader.core;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final c f28428a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f28429b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f28430c;

    /* renamed from: d  reason: collision with root package name */
    public Executor f28431d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Integer, String> f28432e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, ReentrantLock> f28433f = new WeakHashMap();

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f28434g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public final AtomicBoolean f28435h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f28436i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    public final Object f28437j = new Object();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LoadAndDisplayImageTask f28438b;

        public a(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            this.f28438b = loadAndDisplayImageTask;
        }

        public void run() {
            File file = d.this.f28428a.f28394o.get(this.f28438b.n());
            boolean z11 = file != null && file.exists();
            d.this.l();
            if (z11) {
                d.this.f28430c.execute(this.f28438b);
            } else {
                d.this.f28429b.execute(this.f28438b);
            }
        }
    }

    public d(c cVar) {
        this.f28428a = cVar;
        this.f28429b = cVar.f28386g;
        this.f28430c = cVar.f28387h;
        this.f28431d = DefaultConfigurationFactory.i();
    }

    public void d(sx.a aVar) {
        this.f28432e.remove(Integer.valueOf(aVar.getId()));
    }

    public final Executor e() {
        c cVar = this.f28428a;
        return DefaultConfigurationFactory.c(cVar.f28390k, cVar.f28391l, cVar.f28392m);
    }

    public void f(Runnable runnable) {
        this.f28431d.execute(runnable);
    }

    public String g(sx.a aVar) {
        return this.f28432e.get(Integer.valueOf(aVar.getId()));
    }

    public ReentrantLock h(String str) {
        ReentrantLock reentrantLock = this.f28433f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f28433f.put(str, reentrantLock2);
        return reentrantLock2;
    }

    public AtomicBoolean i() {
        return this.f28434g;
    }

    public Object j() {
        return this.f28437j;
    }

    public void k(boolean z11) {
        this.f28436i.set(z11);
    }

    public final void l() {
        if (!this.f28428a.f28388i && ((ExecutorService) this.f28429b).isShutdown()) {
            this.f28429b = e();
        }
        if (!this.f28428a.f28389j && ((ExecutorService) this.f28430c).isShutdown()) {
            this.f28430c = e();
        }
    }

    public boolean m() {
        return this.f28435h.get();
    }

    public boolean n() {
        return this.f28436i.get();
    }

    public void o(sx.a aVar, String str) {
        this.f28432e.put(Integer.valueOf(aVar.getId()), str);
    }

    public void p(LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.f28431d.execute(new a(loadAndDisplayImageTask));
    }

    public void q(f fVar) {
        l();
        this.f28430c.execute(fVar);
    }
}
