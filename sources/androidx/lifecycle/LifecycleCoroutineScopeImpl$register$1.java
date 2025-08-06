package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d10.p;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.r1;

@d(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
public final class LifecycleCoroutineScopeImpl$register$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScopeImpl$register$1(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, c<? super LifecycleCoroutineScopeImpl$register$1> cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScopeImpl;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.this$0, cVar);
        lifecycleCoroutineScopeImpl$register$1.L$0 = obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            h0 h0Var = (h0) this.L$0;
            if (this.this$0.a().b().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                this.this$0.a().a(this.this$0);
            } else {
                r1.d(h0Var.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
            }
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
