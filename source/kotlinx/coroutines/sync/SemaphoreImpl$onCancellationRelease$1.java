package kotlinx.coroutines.sync;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class SemaphoreImpl$onCancellationRelease$1 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ SemaphoreImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SemaphoreImpl$onCancellationRelease$1(SemaphoreImpl semaphoreImpl) {
        super(1);
        this.this$0 = semaphoreImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        this.this$0.release();
    }
}
