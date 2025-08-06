package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.n1;

public class l<T> extends s0<T> implements k<T>, c, q2 {

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57364g = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decisionAndIndex");

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57365h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57366i;
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: e  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f57367e;

    /* renamed from: f  reason: collision with root package name */
    public final CoroutineContext f57368f;

    static {
        Class<Object> cls = Object.class;
        f57365h = AtomicReferenceFieldUpdater.newUpdater(l.class, cls, "_state");
        f57366i = AtomicReferenceFieldUpdater.newUpdater(l.class, cls, "_parentHandle");
    }

    public l(kotlin.coroutines.c<? super T> cVar, int i11) {
        super(i11);
        this.f57367e = cVar;
        if (j0.a()) {
            if (!(i11 != -1)) {
                throw new AssertionError();
            }
        }
        this.f57368f = cVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = c.f56991b;
    }

    public static /* synthetic */ void O(l lVar, Object obj, int i11, d10.l lVar2, int i12, Object obj2) {
        if (obj2 == null) {
            if ((i12 & 4) != 0) {
                lVar2 = null;
            }
            lVar.N(obj, i11, lVar2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    public void A() {
        x0 C = C();
        if (C != null && a()) {
            C.dispose();
            f57366i.set(this, w1.f57576b);
        }
    }

    public Object B(Throwable th2) {
        return R(new y(th2, false, 2, (r) null), (Object) null, (d10.l<? super Throwable, Unit>) null);
    }

    public final x0 C() {
        n1 n1Var = (n1) getContext().get(n1.f57382r0);
        if (n1Var == null) {
            return null;
        }
        x0 d11 = n1.a.d(n1Var, true, false, new p(this), 2, (Object) null);
        a.a(f57366i, this, (Object) null, d11);
        return d11;
    }

    public Object D(T t11, Object obj, d10.l<? super Throwable, Unit> lVar) {
        return R(t11, obj, lVar);
    }

    public final void E(Object obj) {
        Object obj2 = obj;
        if (j0.a()) {
            if (!((obj2 instanceof CancelHandler) || (obj2 instanceof z))) {
                throw new AssertionError();
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57365h;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof c)) {
                if (obj3 instanceof CancelHandler ? true : obj3 instanceof z) {
                    H(obj2, obj3);
                } else {
                    boolean z11 = obj3 instanceof y;
                    if (z11) {
                        y yVar = (y) obj3;
                        if (!yVar.b()) {
                            H(obj2, obj3);
                        }
                        if (obj3 instanceof o) {
                            Throwable th2 = null;
                            if (!z11) {
                                yVar = null;
                            }
                            if (yVar != null) {
                                th2 = yVar.f57583a;
                            }
                            if (obj2 instanceof CancelHandler) {
                                l((CancelHandler) obj2, th2);
                                return;
                            } else {
                                o((z) obj2, th2);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (obj3 instanceof x) {
                        x xVar = (x) obj3;
                        if (xVar.f57578b != null) {
                            H(obj2, obj3);
                        }
                        if (!(obj2 instanceof z)) {
                            CancelHandler cancelHandler = (CancelHandler) obj2;
                            if (xVar.c()) {
                                l(cancelHandler, xVar.f57581e);
                                return;
                            } else {
                                if (a.a(f57365h, this, obj3, x.b(xVar, (Object) null, cancelHandler, (d10.l) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } else if (!(obj2 instanceof z)) {
                        if (a.a(f57365h, this, obj3, new x(obj3, (CancelHandler) obj2, (d10.l) null, (Object) null, (Throwable) null, 28, (r) null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else if (a.a(f57365h, this, obj3, obj2)) {
                return;
            }
        }
    }

    public final boolean F() {
        return t0.c(this.f57458d) && ((i) this.f57367e).p();
    }

    public final CancelHandler G(d10.l<? super Throwable, Unit> lVar) {
        return lVar instanceof CancelHandler ? (CancelHandler) lVar : new k1(lVar);
    }

    public final void H(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public void I(CoroutineDispatcher coroutineDispatcher, T t11) {
        kotlin.coroutines.c<T> cVar = this.f57367e;
        CoroutineDispatcher coroutineDispatcher2 = null;
        i iVar = cVar instanceof i ? (i) cVar : null;
        if (iVar != null) {
            coroutineDispatcher2 = iVar.f57310e;
        }
        O(this, t11, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.f57458d, (d10.l) null, 4, (Object) null);
    }

    public String J() {
        return "CancellableContinuation";
    }

    public final void K(Throwable th2) {
        if (!p(th2)) {
            m(th2);
            r();
        }
    }

    public final void L() {
        Throwable s11;
        kotlin.coroutines.c<T> cVar = this.f57367e;
        i iVar = cVar instanceof i ? (i) cVar : null;
        if (iVar != null && (s11 = iVar.s(this)) != null) {
            q();
            m(s11);
        }
    }

    public final boolean M() {
        if (j0.a()) {
            if (!(this.f57458d == 2)) {
                throw new AssertionError();
            }
        }
        if (j0.a()) {
            if (!(u() != w1.f57576b)) {
                throw new AssertionError();
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57365h;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (j0.a() && !(!(obj instanceof x1))) {
            throw new AssertionError();
        } else if (!(obj instanceof x) || ((x) obj).f57580d == null) {
            f57364g.set(this, 536870911);
            atomicReferenceFieldUpdater.set(this, c.f56991b);
            return true;
        } else {
            q();
            return false;
        }
    }

    public final void N(Object obj, int i11, d10.l<? super Throwable, Unit> lVar) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57365h;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof x1) {
            } else {
                if (obj2 instanceof o) {
                    o oVar = (o) obj2;
                    if (oVar.c()) {
                        if (lVar != null) {
                            n(lVar, oVar.f57583a);
                            return;
                        }
                        return;
                    }
                }
                k(obj);
                throw new KotlinNothingValueException();
            }
        } while (!a.a(f57365h, this, obj2, P((x1) obj2, obj, i11, lVar, (Object) null)));
        r();
        s(i11);
    }

    public final Object P(x1 x1Var, Object obj, int i11, d10.l<? super Throwable, Unit> lVar, Object obj2) {
        if (obj instanceof y) {
            boolean z11 = true;
            if (j0.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (!j0.a()) {
                return obj;
            }
            if (lVar != null) {
                z11 = false;
            }
            if (z11) {
                return obj;
            }
            throw new AssertionError();
        } else if (!t0.b(i11) && obj2 == null) {
            return obj;
        } else {
            if (lVar == null && !(x1Var instanceof CancelHandler) && obj2 == null) {
                return obj;
            }
            return new x(obj, x1Var instanceof CancelHandler ? (CancelHandler) x1Var : null, lVar, obj2, (Throwable) null, 16, (r) null);
        }
    }

    public final boolean Q() {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57364g;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = i11 >> 29;
            if (i12 != 0) {
                if (i12 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f57364g.compareAndSet(this, i11, 1073741824 + (536870911 & i11)));
        return true;
    }

    public final c0 R(Object obj, Object obj2, d10.l<? super Throwable, Unit> lVar) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57365h;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof x1) {
            } else if (!(obj3 instanceof x) || obj2 == null) {
                return null;
            } else {
                x xVar = (x) obj3;
                if (xVar.f57580d != obj2) {
                    return null;
                }
                if (!j0.a() || x.b(xVar.f57577a, obj)) {
                    return m.f57377a;
                }
                throw new AssertionError();
            }
        } while (!a.a(f57365h, this, obj3, P((x1) obj3, obj, this.f57458d, lVar, obj2)));
        r();
        return m.f57377a;
    }

    public final boolean S() {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57364g;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = i11 >> 29;
            if (i12 != 0) {
                if (i12 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f57364g.compareAndSet(this, i11, 536870912 + (536870911 & i11)));
        return true;
    }

    public boolean a() {
        return !(y() instanceof x1);
    }

    public void b(z<?> zVar, int i11) {
        int i12;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57364g;
        do {
            i12 = atomicIntegerFieldUpdater.get(this);
            if (!((i12 & 536870911) == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i12, ((i12 >> 29) << 29) + i11));
        E(zVar);
    }

    public void c(CoroutineDispatcher coroutineDispatcher, Throwable th2) {
        kotlin.coroutines.c<T> cVar = this.f57367e;
        CoroutineDispatcher coroutineDispatcher2 = null;
        i iVar = cVar instanceof i ? (i) cVar : null;
        y yVar = new y(th2, false, 2, (r) null);
        if (iVar != null) {
            coroutineDispatcher2 = iVar.f57310e;
        }
        O(this, yVar, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.f57458d, (d10.l) null, 4, (Object) null);
    }

    public void d(Object obj, Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57365h;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof x1) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof y)) {
                if (obj2 instanceof x) {
                    x xVar = (x) obj2;
                    if (!xVar.c()) {
                        Throwable th3 = th2;
                        if (a.a(f57365h, this, obj2, x.b(xVar, (Object) null, (CancelHandler) null, (d10.l) null, (Object) null, th2, 15, (Object) null))) {
                            xVar.d(this, th3);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else {
                    Throwable th4 = th2;
                    if (a.a(f57365h, this, obj2, new x(obj2, (CancelHandler) null, (d10.l) null, (Object) null, th2, 14, (r) null))) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public final kotlin.coroutines.c<T> e() {
        return this.f57367e;
    }

    public Throwable f(Object obj) {
        Throwable f11 = super.f(obj);
        if (f11 == null) {
            return null;
        }
        kotlin.coroutines.c<T> cVar = this.f57367e;
        return (!j0.d() || !(cVar instanceof c)) ? f11 : b0.i(f11, (c) cVar);
    }

    public <T> T g(Object obj) {
        return obj instanceof x ? ((x) obj).f57577a : obj;
    }

    public c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f57367e;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f57368f;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void h(T t11, d10.l<? super Throwable, Unit> lVar) {
        N(t11, this.f57458d, lVar);
    }

    public boolean isActive() {
        return y() instanceof x1;
    }

    public Object j() {
        return y();
    }

    public final Void k(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void l(CancelHandler cancelHandler, Throwable th2) {
        try {
            cancelHandler.g(th2);
        } catch (Throwable th3) {
            CoroutineContext context = getContext();
            e0.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public boolean m(Throwable th2) {
        Object obj;
        boolean z11;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57365h;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            z11 = false;
            if (!(obj instanceof x1)) {
                return false;
            }
            if ((obj instanceof CancelHandler) || (obj instanceof z)) {
                z11 = true;
            }
        } while (!a.a(f57365h, this, obj, new o(this, th2, z11)));
        x1 x1Var = (x1) obj;
        if (x1Var instanceof CancelHandler) {
            l((CancelHandler) obj, th2);
        } else if (x1Var instanceof z) {
            o((z) obj, th2);
        }
        r();
        s(this.f57458d);
        return true;
    }

    public final void n(d10.l<? super Throwable, Unit> lVar, Throwable th2) {
        try {
            lVar.invoke(th2);
        } catch (Throwable th3) {
            CoroutineContext context = getContext();
            e0.a(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th3));
        }
    }

    public final void o(z<?> zVar, Throwable th2) {
        int i11 = f57364g.get(this) & 536870911;
        if (i11 != 536870911) {
            try {
                zVar.o(i11, th2, getContext());
            } catch (Throwable th3) {
                CoroutineContext context = getContext();
                e0.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
    }

    public final boolean p(Throwable th2) {
        if (!F()) {
            return false;
        }
        return ((i) this.f57367e).q(th2);
    }

    public final void q() {
        x0 u11 = u();
        if (u11 != null) {
            u11.dispose();
            f57366i.set(this, w1.f57576b);
        }
    }

    public final void r() {
        if (!F()) {
            q();
        }
    }

    public void resumeWith(Object obj) {
        O(this, a0.c(obj, this), this.f57458d, (d10.l) null, 4, (Object) null);
    }

    public final void s(int i11) {
        if (!Q()) {
            t0.a(this, i11);
        }
    }

    public Throwable t(n1 n1Var) {
        return n1Var.A();
    }

    public String toString() {
        return J() + '(' + k0.c(this.f57367e) + "){" + z() + "}@" + k0.b(this);
    }

    public final x0 u() {
        return (x0) f57366i.get(this);
    }

    public final Object v() {
        n1 n1Var;
        boolean F = F();
        if (S()) {
            if (u() == null) {
                C();
            }
            if (F) {
                L();
            }
            return IntrinsicsKt__IntrinsicsKt.d();
        }
        if (F) {
            L();
        }
        Object y11 = y();
        if (y11 instanceof y) {
            Throwable th2 = ((y) y11).f57583a;
            if (j0.d()) {
                th2 = b0.i(th2, this);
            }
            throw th2;
        } else if (!t0.b(this.f57458d) || (n1Var = (n1) getContext().get(n1.f57382r0)) == null || n1Var.isActive()) {
            return g(y11);
        } else {
            Throwable A = n1Var.A();
            d(y11, A);
            if (j0.d()) {
                A = b0.i(A, this);
            }
            throw A;
        }
    }

    public void w(Object obj) {
        if (j0.a()) {
            if (!(obj == m.f57377a)) {
                throw new AssertionError();
            }
        }
        s(this.f57458d);
    }

    public void x(d10.l<? super Throwable, Unit> lVar) {
        E(G(lVar));
    }

    public final Object y() {
        return f57365h.get(this);
    }

    public final String z() {
        Object y11 = y();
        if (y11 instanceof x1) {
            return "Active";
        }
        return y11 instanceof o ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
    }
}
