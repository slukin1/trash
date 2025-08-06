package kotlinx.coroutines.flow.internal;

import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", l = {51}, m = "invokeSuspend")
public final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ q<h0, e<? super R>, c<? super Unit>, Object> $block;
    public final /* synthetic */ e<R> $this_unsafeFlow;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowCoroutineKt$scopedFlow$1$1(q<? super h0, ? super e<? super R>, ? super c<? super Unit>, ? extends Object> qVar, e<? super R> eVar, c<? super FlowCoroutineKt$scopedFlow$1$1> cVar) {
        super(2, cVar);
        this.$block = qVar;
        this.$this_unsafeFlow = eVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.$block, this.$this_unsafeFlow, cVar);
        flowCoroutineKt$scopedFlow$1$1.L$0 = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((FlowCoroutineKt$scopedFlow$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            q<h0, e<? super R>, c<? super Unit>, Object> qVar = this.$block;
            e<R> eVar = this.$this_unsafeFlow;
            this.label = 1;
            if (qVar.invoke((h0) this.L$0, eVar, this) == d11) {
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
