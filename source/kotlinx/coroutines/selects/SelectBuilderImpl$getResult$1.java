package kotlinx.coroutines.selects;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.selects.SelectBuilderImpl$getResult$1", f = "SelectOld.kt", l = {43}, m = "invokeSuspend")
final class SelectBuilderImpl$getResult$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ c<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectBuilderImpl$getResult$1(c<Object> cVar, c<? super SelectBuilderImpl$getResult$1> cVar2) {
        super(2, cVar2);
        this.this$0 = cVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SelectBuilderImpl$getResult$1(this.this$0, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((SelectBuilderImpl$getResult$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            c<Object> cVar = this.this$0;
            this.label = 1;
            obj = cVar.r(this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            try {
                k.b(obj);
            } catch (Throwable th2) {
                m.d(this.this$0.f57524h, th2);
                return Unit.f56620a;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.c(this.this$0.f57524h, obj);
        return Unit.f56620a;
    }
}
