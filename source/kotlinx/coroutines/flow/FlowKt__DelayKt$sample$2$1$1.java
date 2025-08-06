package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.k;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", l = {}, m = "invokeSuspend")
public final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements p<ChannelResult<? extends Object>, c<? super Unit>, Object> {
    public final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    public final /* synthetic */ ReceiveChannel<Unit> $ticker;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(Ref$ObjectRef<Object> ref$ObjectRef, ReceiveChannel<Unit> receiveChannel, c<? super FlowKt__DelayKt$sample$2$1$1> cVar) {
        super(2, cVar);
        this.$lastValue = ref$ObjectRef;
        this.$ticker = receiveChannel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, cVar);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m3083invokeWpGqRn0(((ChannelResult) obj).l(), (c) obj2);
    }

    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m3083invokeWpGqRn0(Object obj, c<? super Unit> cVar) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(ChannelResult.b(obj), cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            T l11 = ((ChannelResult) this.L$0).l();
            Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
            boolean z11 = l11 instanceof ChannelResult.Failed;
            if (!z11) {
                ref$ObjectRef.element = l11;
            }
            ReceiveChannel<Unit> receiveChannel = this.$ticker;
            if (z11) {
                Throwable e11 = ChannelResult.e(l11);
                if (e11 == null) {
                    receiveChannel.b(new ChildCancelledException());
                    ref$ObjectRef.element = kotlinx.coroutines.flow.internal.k.f57267c;
                } else {
                    throw e11;
                }
            }
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
