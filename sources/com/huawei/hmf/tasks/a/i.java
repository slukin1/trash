package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.Task;
import eg.a;
import eg.b;
import eg.c;
import eg.d;
import eg.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class i<TResult> extends Task<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f37644a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f37645b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f37646c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f37647d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f37648e;

    /* renamed from: f  reason: collision with root package name */
    public List<a<TResult>> f37649f = new ArrayList();

    public final Task<TResult> a(b<TResult> bVar) {
        return m(e.b(), bVar);
    }

    public final Task<TResult> b(c cVar) {
        return n(e.b(), cVar);
    }

    public final Task<TResult> c(d<TResult> dVar) {
        return o(e.b(), dVar);
    }

    public final Exception d() {
        Exception exc;
        synchronized (this.f37644a) {
            exc = this.f37648e;
        }
        return exc;
    }

    public final TResult e() {
        TResult tresult;
        synchronized (this.f37644a) {
            if (this.f37648e == null) {
                tresult = this.f37647d;
            } else {
                throw new RuntimeException(this.f37648e);
            }
        }
        return tresult;
    }

    public final boolean f() {
        return this.f37646c;
    }

    public final boolean g() {
        boolean z11;
        synchronized (this.f37644a) {
            z11 = this.f37645b;
        }
        return z11;
    }

    public final boolean h() {
        boolean z11;
        synchronized (this.f37644a) {
            z11 = this.f37645b && !f() && this.f37648e == null;
        }
        return z11;
    }

    public final Task<TResult> i(a<TResult> aVar) {
        boolean g11;
        synchronized (this.f37644a) {
            g11 = g();
            if (!g11) {
                this.f37649f.add(aVar);
            }
        }
        if (g11) {
            aVar.onComplete(this);
        }
        return this;
    }

    public final void j(Exception exc) {
        synchronized (this.f37644a) {
            if (!this.f37645b) {
                this.f37645b = true;
                this.f37648e = exc;
                this.f37644a.notifyAll();
                p();
            }
        }
    }

    public final void k(TResult tresult) {
        synchronized (this.f37644a) {
            if (!this.f37645b) {
                this.f37645b = true;
                this.f37647d = tresult;
                this.f37644a.notifyAll();
                p();
            }
        }
    }

    public final boolean l() {
        synchronized (this.f37644a) {
            if (this.f37645b) {
                return false;
            }
            this.f37645b = true;
            this.f37646c = true;
            this.f37644a.notifyAll();
            p();
            return true;
        }
    }

    public final Task<TResult> m(Executor executor, b<TResult> bVar) {
        return i(new fg.a(executor, bVar));
    }

    public final Task<TResult> n(Executor executor, c cVar) {
        return i(new fg.b(executor, cVar));
    }

    public final Task<TResult> o(Executor executor, d<TResult> dVar) {
        return i(new fg.c(executor, dVar));
    }

    public final void p() {
        synchronized (this.f37644a) {
            for (a onComplete : this.f37649f) {
                try {
                    onComplete.onComplete(this);
                } catch (RuntimeException e11) {
                    throw e11;
                } catch (Exception e12) {
                    throw new RuntimeException(e12);
                }
            }
            this.f37649f = null;
        }
    }
}
