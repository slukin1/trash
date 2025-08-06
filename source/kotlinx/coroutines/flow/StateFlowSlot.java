package kotlinx.coroutines.flow;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.l;

final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57209a = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: d */
    public boolean a(StateFlowImpl<?> stateFlowImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57209a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, k1.f57271a);
        return true;
    }

    public final Object e(c<? super Unit> cVar) {
        boolean z11 = true;
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        if (!j0.a() || (!(f57209a.get(this) instanceof l))) {
            if (!a.a(f57209a, this, k1.f57271a, lVar)) {
                if (j0.a()) {
                    if (f57209a.get(this) != k1.f57272b) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new AssertionError();
                    }
                }
                Result.a aVar = Result.Companion;
                lVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
            }
            Object v11 = lVar.v();
            if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                f.c(cVar);
            }
            if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                return v11;
            }
            return Unit.f56620a;
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    public c<Unit>[] b(StateFlowImpl<?> stateFlowImpl) {
        f57209a.set(this, (Object) null);
        return kotlinx.coroutines.flow.internal.a.f57259a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57209a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null && obj != k1.f57272b) {
                if (obj == k1.f57271a) {
                    if (a.a(f57209a, this, obj, k1.f57272b)) {
                        return;
                    }
                } else if (a.a(f57209a, this, obj, k1.f57271a)) {
                    Result.a aVar = Result.Companion;
                    ((l) obj).resumeWith(Result.m3072constructorimpl(Unit.f56620a));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = f57209a.getAndSet(this, k1.f57271a);
        if (j0.a() && !(!(andSet instanceof l))) {
            throw new AssertionError();
        } else if (andSet == k1.f57272b) {
            return true;
        } else {
            return false;
        }
    }
}
