package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.z;

public final class i<T> extends s0<T> implements c, kotlin.coroutines.c<T> {

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57309i = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: e  reason: collision with root package name */
    public final CoroutineDispatcher f57310e;

    /* renamed from: f  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f57311f;

    /* renamed from: g  reason: collision with root package name */
    public Object f57312g = j.f57318a;

    /* renamed from: h  reason: collision with root package name */
    public final Object f57313h = ThreadContextKt.b(getContext());

    public i(CoroutineDispatcher coroutineDispatcher, kotlin.coroutines.c<? super T> cVar) {
        super(-1);
        this.f57310e = coroutineDispatcher;
        this.f57311f = cVar;
    }

    public void d(Object obj, Throwable th2) {
        if (obj instanceof z) {
            ((z) obj).f57586b.invoke(th2);
        }
    }

    public kotlin.coroutines.c<T> e() {
        return this;
    }

    public c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f57311f;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f57311f.getContext();
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public Object j() {
        Object obj = this.f57312g;
        if (j0.a()) {
            if (!(obj != j.f57318a)) {
                throw new AssertionError();
            }
        }
        this.f57312g = j.f57318a;
        return obj;
    }

    public final void k() {
        do {
        } while (f57309i.get(this) == j.f57319b);
    }

    public final l<T> l() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57309i;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f57309i.set(this, j.f57319b);
                return null;
            } else if (obj instanceof l) {
                if (a.a(f57309i, this, obj, j.f57319b)) {
                    return (l) obj;
                }
            } else if (obj != j.f57319b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void n(CoroutineContext coroutineContext, T t11) {
        this.f57312g = t11;
        this.f57458d = 1;
        this.f57310e.x(coroutineContext, this);
    }

    public final l<?> o() {
        Object obj = f57309i.get(this);
        if (obj instanceof l) {
            return (l) obj;
        }
        return null;
    }

    public final boolean p() {
        return f57309i.get(this) != null;
    }

    public final boolean q(Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57309i;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c0 c0Var = j.f57319b;
            if (x.b(obj, c0Var)) {
                if (a.a(f57309i, this, c0Var, th2)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (a.a(f57309i, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final void r() {
        k();
        l<?> o11 = o();
        if (o11 != null) {
            o11.q();
        }
    }

    public void resumeWith(Object obj) {
        CoroutineContext context;
        Object c11;
        CoroutineContext context2 = this.f57311f.getContext();
        Object d11 = a0.d(obj, (d10.l) null, 1, (Object) null);
        if (this.f57310e.B(context2)) {
            this.f57312g = d11;
            this.f57458d = 0;
            this.f57310e.w(context2, this);
            return;
        }
        boolean a11 = j0.a();
        EventLoop b11 = g2.f57278a.b();
        if (b11.P()) {
            this.f57312g = d11;
            this.f57458d = 0;
            b11.J(this);
            return;
        }
        b11.N(true);
        try {
            context = getContext();
            c11 = ThreadContextKt.c(context, this.f57313h);
            this.f57311f.resumeWith(obj);
            Unit unit = Unit.f56620a;
            ThreadContextKt.a(context, c11);
            do {
            } while (b11.S());
        } catch (Throwable th2) {
            try {
                i(th2, (Throwable) null);
            } catch (Throwable th3) {
                b11.G(true);
                throw th3;
            }
        }
        b11.G(true);
    }

    public final Throwable s(k<?> kVar) {
        c0 c0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57309i;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c0Var = j.f57319b;
            if (obj != c0Var) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (a.a(f57309i, this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!a.a(f57309i, this, c0Var, kVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f57310e + ", " + k0.c(this.f57311f) + ']';
    }
}
