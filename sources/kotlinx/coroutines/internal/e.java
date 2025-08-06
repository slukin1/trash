package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.j0;

public abstract class e<N extends e<N>> {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57304b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57305c;
    private volatile Object _next;
    private volatile Object _prev;

    static {
        Class<Object> cls = Object.class;
        Class<e> cls2 = e.class;
        f57304b = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        f57305c = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
    }

    public e(N n11) {
        this._prev = n11;
    }

    public final void b() {
        f57305c.lazySet(this, (Object) null);
    }

    public final N c() {
        N g11 = g();
        while (g11 != null && g11.h()) {
            g11 = (e) f57305c.get(g11);
        }
        return g11;
    }

    public final N d() {
        N e11;
        if (!j0.a() || (!i())) {
            N e12 = e();
            while (e12.h() && (e11 = e12.e()) != null) {
                e12 = e11;
            }
            return e12;
        }
        throw new AssertionError();
    }

    public final N e() {
        N a11 = f();
        if (a11 == d.f57303a) {
            return null;
        }
        return (e) a11;
    }

    public final Object f() {
        return f57304b.get(this);
    }

    public final N g() {
        return (e) f57305c.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return a.a(f57304b, this, (Object) null, d.f57303a);
    }

    public final void k() {
        Object obj;
        if (j0.a()) {
            if (!(h() || i())) {
                throw new AssertionError();
            }
        }
        if (!i()) {
            while (true) {
                e c11 = c();
                e d11 = d();
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57305c;
                do {
                    obj = atomicReferenceFieldUpdater.get(d11);
                } while (!a.a(atomicReferenceFieldUpdater, d11, obj, ((e) obj) == null ? null : c11));
                if (c11 != null) {
                    f57304b.set(c11, d11);
                }
                if ((!d11.h() || d11.i()) && (c11 == null || !c11.h())) {
                    return;
                }
            }
        }
    }

    public final boolean l(N n11) {
        return a.a(f57304b, this, (Object) null, n11);
    }
}
