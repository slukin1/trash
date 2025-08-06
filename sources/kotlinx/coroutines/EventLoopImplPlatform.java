package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlinx.coroutines.EventLoopImplBase;

public abstract class EventLoopImplPlatform extends EventLoop {
    public abstract Thread U();

    public void V(long j11, EventLoopImplBase.c cVar) {
        l0.f57369i.f0(j11, cVar);
    }

    public final void W() {
        Unit unit;
        Thread U = U();
        if (Thread.currentThread() != U) {
            AbstractTimeSource a11 = b.a();
            if (a11 != null) {
                a11.f(U);
                unit = Unit.f56620a;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(U);
            }
        }
    }
}
