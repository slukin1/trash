package androidx.lifecycle;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
public final class EmittedSource$dispose$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ EmittedSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmittedSource$dispose$1(EmittedSource emittedSource, c<? super EmittedSource$dispose$1> cVar) {
        super(2, cVar);
        this.this$0 = emittedSource;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new EmittedSource$dispose$1(this.this$0, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((EmittedSource$dispose$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            this.this$0.c();
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
