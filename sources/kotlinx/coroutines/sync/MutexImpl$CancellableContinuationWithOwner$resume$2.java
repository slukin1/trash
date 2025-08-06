package kotlinx.coroutines.sync;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl;

public final class MutexImpl$CancellableContinuationWithOwner$resume$2 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ MutexImpl this$0;
    public final /* synthetic */ MutexImpl.CancellableContinuationWithOwner this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutexImpl$CancellableContinuationWithOwner$resume$2(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        super(1);
        this.this$0 = mutexImpl;
        this.this$1 = cancellableContinuationWithOwner;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.this$0.e(this.this$1.f57544c);
    }
}
