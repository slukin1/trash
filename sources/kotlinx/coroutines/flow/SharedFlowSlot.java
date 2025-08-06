package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.j0;

public final class SharedFlowSlot extends AbstractSharedFlowSlot<SharedFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    public long f57201a = -1;

    /* renamed from: b  reason: collision with root package name */
    public c<? super Unit> f57202b;

    /* renamed from: c */
    public boolean a(SharedFlowImpl<?> sharedFlowImpl) {
        if (this.f57201a >= 0) {
            return false;
        }
        this.f57201a = sharedFlowImpl.X();
        return true;
    }

    /* renamed from: d */
    public c<Unit>[] b(SharedFlowImpl<?> sharedFlowImpl) {
        if (j0.a()) {
            if (!(this.f57201a >= 0)) {
                throw new AssertionError();
            }
        }
        long j11 = this.f57201a;
        this.f57201a = -1;
        this.f57202b = null;
        return sharedFlowImpl.W(j11);
    }
}
