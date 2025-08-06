package kotlinx.coroutines.rx3;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

@d(c = "kotlinx.coroutines.rx3.RxConvertKt$asCompletable$1", f = "RxConvert.kt", l = {30}, m = "invokeSuspend")
final class RxConvertKt$asCompletable$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ n1 $this_asCompletable;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asCompletable$1(n1 n1Var, c<? super RxConvertKt$asCompletable$1> cVar) {
        super(2, cVar);
        this.$this_asCompletable = n1Var;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RxConvertKt$asCompletable$1(this.$this_asCompletable, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((RxConvertKt$asCompletable$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            n1 n1Var = this.$this_asCompletable;
            this.label = 1;
            if (n1Var.F(this) == d11) {
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
