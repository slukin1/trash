package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.k;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", f = "Delay.kt", l = {299}, m = "invokeSuspend")
public final class FlowKt__DelayKt$sample$2$1$2 extends SuspendLambda implements p<Unit, c<? super Unit>, Object> {
    public final /* synthetic */ e<Object> $downstream;
    public final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$2(Ref$ObjectRef<Object> ref$ObjectRef, e<Object> eVar, c<? super FlowKt__DelayKt$sample$2$1$2> cVar) {
        super(2, cVar);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = eVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FlowKt__DelayKt$sample$2$1$2(this.$lastValue, this.$downstream, cVar);
    }

    public final Object invoke(Unit unit, c<? super Unit> cVar) {
        return ((FlowKt__DelayKt$sample$2$1$2) create(unit, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
            T t11 = ref$ObjectRef.element;
            if (t11 == null) {
                return Unit.f56620a;
            }
            ref$ObjectRef.element = null;
            e<Object> eVar = this.$downstream;
            if (t11 == kotlinx.coroutines.flow.internal.k.f57265a) {
                t11 = null;
            }
            this.label = 1;
            if (eVar.emit(t11, this) == d11) {
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
