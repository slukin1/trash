package androidx.lifecycle;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", f = "Lifecycle.kt", l = {400}, m = "invokeSuspend")
public final class LifecycleCoroutineScope$launchWhenResumed$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ p<h0, c<? super Unit>, Object> $block;
    public int label;
    public final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScope$launchWhenResumed$1(LifecycleCoroutineScope lifecycleCoroutineScope, p<? super h0, ? super c<? super Unit>, ? extends Object> pVar, c<? super LifecycleCoroutineScope$launchWhenResumed$1> cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new LifecycleCoroutineScope$launchWhenResumed$1(this.this$0, this.$block, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((LifecycleCoroutineScope$launchWhenResumed$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            Lifecycle a11 = this.this$0.a();
            p<h0, c<? super Unit>, Object> pVar = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.b(a11, pVar, this) == d11) {
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
