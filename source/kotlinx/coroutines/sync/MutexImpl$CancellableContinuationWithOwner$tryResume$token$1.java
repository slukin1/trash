package kotlinx.coroutines.sync;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.sync.MutexImpl;

public final class MutexImpl$CancellableContinuationWithOwner$tryResume$token$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ MutexImpl this$0;
    public final /* synthetic */ MutexImpl.CancellableContinuationWithOwner this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        super(1);
        this.this$0 = mutexImpl;
        this.this$1 = cancellableContinuationWithOwner;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        MutexImpl mutexImpl = this.this$0;
        MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner = this.this$1;
        if (j0.a()) {
            Object obj = MutexImpl.f57541i.get(mutexImpl);
            if (!(obj == MutexKt.f57549a || obj == cancellableContinuationWithOwner.f57544c)) {
                throw new AssertionError();
            }
        }
        MutexImpl.f57541i.set(this.this$0, this.this$1.f57544c);
        this.this$0.e(this.this$1.f57544c);
    }
}
