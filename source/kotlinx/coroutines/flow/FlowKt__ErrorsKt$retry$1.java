package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", f = "Errors.kt", l = {}, m = "invokeSuspend")
final class FlowKt__ErrorsKt$retry$1 extends SuspendLambda implements p<Throwable, c<? super Boolean>, Object> {
    public int label;

    public FlowKt__ErrorsKt$retry$1(c<? super FlowKt__ErrorsKt$retry$1> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FlowKt__ErrorsKt$retry$1(cVar);
    }

    public final Object invoke(Throwable th2, c<? super Boolean> cVar) {
        return ((FlowKt__ErrorsKt$retry$1) create(th2, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            return a.a(true);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
