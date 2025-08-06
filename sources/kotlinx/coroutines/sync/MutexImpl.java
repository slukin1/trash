package kotlinx.coroutines.sync;

import com.tencent.qcloud.tuicore.TUIConstants;
import d10.l;
import d10.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.selects.k;
import kotlinx.coroutines.x0;

public class MutexImpl extends SemaphoreImpl implements a {

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57541i = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, TUIConstants.TUIChat.OWNER);

    /* renamed from: h  reason: collision with root package name */
    public final q<k<?>, Object, Object, l<Throwable, Unit>> f57542h;
    private volatile Object owner;

    public final class CancellableContinuationWithOwner implements kotlinx.coroutines.k<Unit>, q2 {

        /* renamed from: b  reason: collision with root package name */
        public final kotlinx.coroutines.l<Unit> f57543b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f57544c;

        public CancellableContinuationWithOwner(kotlinx.coroutines.l<? super Unit> lVar, Object obj) {
            this.f57543b = lVar;
            this.f57544c = obj;
        }

        public Object B(Throwable th2) {
            return this.f57543b.B(th2);
        }

        public boolean a() {
            return this.f57543b.a();
        }

        public void b(z<?> zVar, int i11) {
            this.f57543b.b(zVar, i11);
        }

        public void c(CoroutineDispatcher coroutineDispatcher, Throwable th2) {
            this.f57543b.c(coroutineDispatcher, th2);
        }

        /* renamed from: d */
        public void h(Unit unit, l<? super Throwable, Unit> lVar) {
            MutexImpl mutexImpl = MutexImpl.this;
            if (j0.a()) {
                if (!(MutexImpl.f57541i.get(mutexImpl) == MutexKt.f57549a)) {
                    throw new AssertionError();
                }
            }
            MutexImpl.f57541i.set(MutexImpl.this, this.f57544c);
            this.f57543b.h(unit, new MutexImpl$CancellableContinuationWithOwner$resume$2(MutexImpl.this, this));
        }

        /* renamed from: e */
        public void I(CoroutineDispatcher coroutineDispatcher, Unit unit) {
            this.f57543b.I(coroutineDispatcher, unit);
        }

        /* renamed from: f */
        public Object D(Unit unit, Object obj, l<? super Throwable, Unit> lVar) {
            MutexImpl mutexImpl = MutexImpl.this;
            boolean z11 = true;
            if (j0.a()) {
                if (!(MutexImpl.f57541i.get(mutexImpl) == MutexKt.f57549a)) {
                    throw new AssertionError();
                }
            }
            Object D = this.f57543b.D(unit, obj, new MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(MutexImpl.this, this));
            if (D != null) {
                MutexImpl mutexImpl2 = MutexImpl.this;
                if (j0.a()) {
                    if (MutexImpl.f57541i.get(mutexImpl2) != MutexKt.f57549a) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new AssertionError();
                    }
                }
                MutexImpl.f57541i.set(MutexImpl.this, this.f57544c);
            }
            return D;
        }

        public CoroutineContext getContext() {
            return this.f57543b.getContext();
        }

        public boolean isActive() {
            return this.f57543b.isActive();
        }

        public boolean m(Throwable th2) {
            return this.f57543b.m(th2);
        }

        public void resumeWith(Object obj) {
            this.f57543b.resumeWith(obj);
        }

        public void w(Object obj) {
            this.f57543b.w(obj);
        }

        public void x(l<? super Throwable, Unit> lVar) {
            this.f57543b.x(lVar);
        }
    }

    public final class a<Q> implements kotlinx.coroutines.selects.l<Q> {

        /* renamed from: b  reason: collision with root package name */
        public final kotlinx.coroutines.selects.l<Q> f57546b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f57547c;

        public a(kotlinx.coroutines.selects.l<Q> lVar, Object obj) {
            this.f57546b = lVar;
            this.f57547c = obj;
        }

        public void b(z<?> zVar, int i11) {
            this.f57546b.b(zVar, i11);
        }

        public void d(Object obj) {
            MutexImpl mutexImpl = MutexImpl.this;
            if (j0.a()) {
                if (!(MutexImpl.f57541i.get(mutexImpl) == MutexKt.f57549a)) {
                    throw new AssertionError();
                }
            }
            MutexImpl.f57541i.set(MutexImpl.this, this.f57547c);
            this.f57546b.d(obj);
        }

        public void e(x0 x0Var) {
            this.f57546b.e(x0Var);
        }

        public boolean f(Object obj, Object obj2) {
            MutexImpl mutexImpl = MutexImpl.this;
            if (j0.a()) {
                if (!(MutexImpl.f57541i.get(mutexImpl) == MutexKt.f57549a)) {
                    throw new AssertionError();
                }
            }
            boolean f11 = this.f57546b.f(obj, obj2);
            MutexImpl mutexImpl2 = MutexImpl.this;
            if (f11) {
                MutexImpl.f57541i.set(mutexImpl2, this.f57547c);
            }
            return f11;
        }

        public CoroutineContext getContext() {
            return this.f57546b.getContext();
        }
    }

    public MutexImpl(boolean z11) {
        super(1, z11 ? 1 : 0);
        c0 c0Var;
        if (z11) {
            c0Var = null;
        } else {
            c0Var = MutexKt.f57549a;
        }
        this.owner = c0Var;
        this.f57542h = new MutexImpl$onSelectCancellationUnlockConstructor$1(this);
    }

    public static /* synthetic */ Object u(MutexImpl mutexImpl, Object obj, c<? super Unit> cVar) {
        if (mutexImpl.a(obj)) {
            return Unit.f56620a;
        }
        Object v11 = mutexImpl.v(obj, cVar);
        return v11 == IntrinsicsKt__IntrinsicsKt.d() ? v11 : Unit.f56620a;
    }

    public boolean a(Object obj) {
        int y11 = y(obj);
        if (y11 == 0) {
            return true;
        }
        if (y11 == 1) {
            return false;
        }
        if (y11 != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public boolean b() {
        return m() == 0;
    }

    public Object d(Object obj, c<? super Unit> cVar) {
        return u(this, obj, cVar);
    }

    public void e(Object obj) {
        while (b()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57541i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != MutexKt.f57549a) {
                if (!(obj2 == obj || obj == null)) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj2, MutexKt.f57549a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public boolean s(Object obj) {
        return t(obj) == 1;
    }

    public final int t(Object obj) {
        while (b()) {
            Object obj2 = f57541i.get(this);
            if (obj2 != MutexKt.f57549a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    public String toString() {
        return "Mutex@" + k0.b(this) + "[isLocked=" + b() + ",owner=" + f57541i.get(this) + ']';
    }

    public final Object v(Object obj, c<? super Unit> cVar) {
        kotlinx.coroutines.l b11 = n.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
        try {
            g(new CancellableContinuationWithOwner(b11, obj));
            Object v11 = b11.v();
            if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                f.c(cVar);
            }
            if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                return v11;
            }
            return Unit.f56620a;
        } catch (Throwable th2) {
            b11.L();
            throw th2;
        }
    }

    public Object w(Object obj, Object obj2) {
        if (!x.b(obj2, MutexKt.f57550b)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public void x(k<?> kVar, Object obj) {
        if (obj == null || !s(obj)) {
            n(new a((kotlinx.coroutines.selects.l) kVar, obj), obj);
        } else {
            kVar.d(MutexKt.f57550b);
        }
    }

    public final int y(Object obj) {
        int t11;
        do {
            boolean z11 = true;
            if (o()) {
                if (j0.a()) {
                    if (f57541i.get(this) != MutexKt.f57549a) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new AssertionError();
                    }
                }
                f57541i.set(this, obj);
                return 0;
            } else if (obj == null) {
                return 1;
            } else {
                t11 = t(obj);
                if (t11 == 1) {
                    return 2;
                }
            }
        } while (t11 != 2);
        return 1;
    }
}
