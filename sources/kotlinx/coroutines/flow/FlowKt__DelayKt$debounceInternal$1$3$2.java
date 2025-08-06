package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.k;
import kotlinx.coroutines.channels.ChannelResult;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {242}, m = "invokeSuspend")
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements p<ChannelResult<? extends Object>, c<? super Unit>, Object> {
    public final /* synthetic */ e<T> $downstream;
    public final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    public /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref$ObjectRef<Object> ref$ObjectRef, e<? super T> eVar, c<? super FlowKt__DelayKt$debounceInternal$1$3$2> cVar) {
        super(2, cVar);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = eVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, cVar);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m3082invokeWpGqRn0(((ChannelResult) obj).l(), (c) obj2);
    }

    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m3082invokeWpGqRn0(Object obj, c<? super Unit> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(ChannelResult.b(obj), cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Ref$ObjectRef<Object> ref$ObjectRef;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            T l11 = ((ChannelResult) this.L$0).l();
            ref$ObjectRef = this.$lastValue;
            boolean z11 = l11 instanceof ChannelResult.Failed;
            if (!z11) {
                ref$ObjectRef.element = l11;
            }
            e<T> eVar = this.$downstream;
            if (z11) {
                Throwable e11 = ChannelResult.e(l11);
                if (e11 == null) {
                    T t11 = ref$ObjectRef.element;
                    if (t11 != null) {
                        if (t11 == kotlinx.coroutines.flow.internal.k.f57265a) {
                            t11 = null;
                        }
                        this.L$0 = l11;
                        this.L$1 = ref$ObjectRef;
                        this.label = 1;
                        if (eVar.emit(t11, this) == d11) {
                            return d11;
                        }
                        ref$ObjectRef2 = ref$ObjectRef;
                    }
                    ref$ObjectRef.element = kotlinx.coroutines.flow.internal.k.f57267c;
                } else {
                    throw e11;
                }
            }
            return Unit.f56620a;
        } else if (i11 == 1) {
            ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.element = kotlinx.coroutines.flow.internal.k.f57267c;
        return Unit.f56620a;
    }
}
