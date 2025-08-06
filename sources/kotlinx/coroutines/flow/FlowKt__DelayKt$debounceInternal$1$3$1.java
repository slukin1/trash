package kotlinx.coroutines.flow;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.k;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", l = {232}, m = "invokeSuspend")
public final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements l<c<? super Unit>, Object> {
    public final /* synthetic */ e<T> $downstream;
    public final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$1(e<? super T> eVar, Ref$ObjectRef<Object> ref$ObjectRef, c<? super FlowKt__DelayKt$debounceInternal$1$3$1> cVar) {
        super(1, cVar);
        this.$downstream = eVar;
        this.$lastValue = ref$ObjectRef;
    }

    public final c<Unit> create(c<?> cVar) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.$downstream, this.$lastValue, cVar);
    }

    public final Object invoke(c<? super Unit> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) create(cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            e<T> eVar = this.$downstream;
            T t11 = kotlinx.coroutines.flow.internal.k.f57265a;
            T t12 = this.$lastValue.element;
            if (t12 == t11) {
                t12 = null;
            }
            this.label = 1;
            if (eVar.emit(t12, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$lastValue.element = null;
        return Unit.f56620a;
    }
}
