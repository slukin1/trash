package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", l = {50}, m = "invokeSuspend")
final class FlowKt__CollectKt$launchIn$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ d<Object> $this_launchIn;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__CollectKt$launchIn$1(d<Object> dVar, c<? super FlowKt__CollectKt$launchIn$1> cVar) {
        super(2, cVar);
        this.$this_launchIn = dVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FlowKt__CollectKt$launchIn$1(this.$this_launchIn, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((FlowKt__CollectKt$launchIn$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            d<Object> dVar = this.$this_launchIn;
            this.label = 1;
            if (f.h(dVar, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
