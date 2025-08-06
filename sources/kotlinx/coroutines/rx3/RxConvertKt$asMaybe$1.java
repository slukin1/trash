package kotlinx.coroutines.rx3;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n0;

@d(c = "kotlinx.coroutines.rx3.RxConvertKt$asMaybe$1", f = "RxConvert.kt", l = {46}, m = "invokeSuspend")
final class RxConvertKt$asMaybe$1 extends SuspendLambda implements p<h0, c<Object>, Object> {
    public final /* synthetic */ n0<Object> $this_asMaybe;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asMaybe$1(n0<Object> n0Var, c<? super RxConvertKt$asMaybe$1> cVar) {
        super(2, cVar);
        this.$this_asMaybe = n0Var;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RxConvertKt$asMaybe$1(this.$this_asMaybe, cVar);
    }

    public final Object invoke(h0 h0Var, c<Object> cVar) {
        return ((RxConvertKt$asMaybe$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            n0<Object> n0Var = this.$this_asMaybe;
            this.label = 1;
            obj = n0Var.j(this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
