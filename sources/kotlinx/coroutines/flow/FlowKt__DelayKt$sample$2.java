package kotlinx.coroutines.flow;

import d10.q;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.k;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.selects.SelectImplementation;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", l = {423}, m = "invokeSuspend")
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements q<h0, e<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ long $periodMillis;
    public final /* synthetic */ d<Object> $this_sample;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2(long j11, d<Object> dVar, c<? super FlowKt__DelayKt$sample$2> cVar) {
        super(3, cVar);
        this.$periodMillis = j11;
        this.$this_sample = dVar;
    }

    public final Object invoke(h0 h0Var, e<Object> eVar, c<? super Unit> cVar) {
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$periodMillis, this.$this_sample, cVar);
        flowKt__DelayKt$sample$2.L$0 = h0Var;
        flowKt__DelayKt$sample$2.L$1 = eVar;
        return flowKt__DelayKt$sample$2.invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        e eVar;
        ReceiveChannel receiveChannel;
        Ref$ObjectRef ref$ObjectRef;
        ReceiveChannel receiveChannel2;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, (c<? super FlowKt__DelayKt$sample$2$values$1>) null);
            h0 h0Var = (h0) this.L$0;
            ReceiveChannel d12 = ProduceKt.d(h0Var, (CoroutineContext) null, -1, flowKt__DelayKt$sample$2$values$1, 1, (Object) null);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ReceiveChannel E = FlowKt__DelayKt.d(h0Var, this.$periodMillis, 0, 2, (Object) null);
            eVar = (e) this.L$1;
            receiveChannel = d12;
            ref$ObjectRef = ref$ObjectRef2;
            receiveChannel2 = E;
        } else if (i11 == 1) {
            receiveChannel2 = (ReceiveChannel) this.L$3;
            ref$ObjectRef = (Ref$ObjectRef) this.L$2;
            receiveChannel = (ReceiveChannel) this.L$1;
            eVar = (e) this.L$0;
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (ref$ObjectRef.element != kotlinx.coroutines.flow.internal.k.f57267c) {
            SelectImplementation selectImplementation = new SelectImplementation(getContext());
            selectImplementation.c(receiveChannel.r(), new FlowKt__DelayKt$sample$2$1$1(ref$ObjectRef, receiveChannel2, (c<? super FlowKt__DelayKt$sample$2$1$1>) null));
            selectImplementation.c(receiveChannel2.G(), new FlowKt__DelayKt$sample$2$1$2(ref$ObjectRef, eVar, (c<? super FlowKt__DelayKt$sample$2$1$2>) null));
            this.L$0 = eVar;
            this.L$1 = receiveChannel;
            this.L$2 = ref$ObjectRef;
            this.L$3 = receiveChannel2;
            this.label = 1;
            if (selectImplementation.r(this) == d11) {
                return d11;
            }
        }
        return Unit.f56620a;
    }
}
