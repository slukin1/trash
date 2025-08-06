package androidx.lifecycle;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {177}, m = "invokeSuspend")
final class BlockRunner$maybeRun$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ b<Object> this$0;

    public BlockRunner$maybeRun$1(b<Object> bVar, c<? super BlockRunner$maybeRun$1> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        BlockRunner$maybeRun$1 blockRunner$maybeRun$1 = new BlockRunner$maybeRun$1(this.this$0, cVar);
        blockRunner$maybeRun$1.L$0 = obj;
        return blockRunner$maybeRun$1;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((BlockRunner$maybeRun$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(b.b(this.this$0), ((h0) this.L$0).getCoroutineContext());
            p a11 = b.a(this.this$0);
            this.label = 1;
            if (a11.invoke(liveDataScopeImpl, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        b.c(this.this$0).invoke();
        return Unit.f56620a;
    }
}
