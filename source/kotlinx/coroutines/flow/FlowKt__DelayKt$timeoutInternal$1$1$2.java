package kotlinx.coroutines.flow;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlin.time.b;
import kotlinx.coroutines.TimeoutCancellationException;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2", f = "Delay.kt", l = {}, m = "invokeSuspend")
public final class FlowKt__DelayKt$timeoutInternal$1$1$2 extends SuspendLambda implements l<c<?>, Object> {
    public final /* synthetic */ long $timeout;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$timeoutInternal$1$1$2(long j11, c<? super FlowKt__DelayKt$timeoutInternal$1$1$2> cVar) {
        super(1, cVar);
        this.$timeout = j11;
    }

    public final c<Unit> create(c<?> cVar) {
        return new FlowKt__DelayKt$timeoutInternal$1$1$2(this.$timeout, cVar);
    }

    public final Object invoke(c<?> cVar) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$2) create(cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k.b(obj);
        throw new TimeoutCancellationException("Timed out waiting for " + b.H(this.$timeout));
    }
}
