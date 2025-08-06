package kotlinx.coroutines;

import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", l = {}, m = "invokeSuspend")
public final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements p<h0, c<? super T>, Object> {
    public final /* synthetic */ a<T> $block;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InterruptibleKt$runInterruptible$2(a<? extends T> aVar, c<? super InterruptibleKt$runInterruptible$2> cVar) {
        super(2, cVar);
        this.$block = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(this.$block, cVar);
        interruptibleKt$runInterruptible$2.L$0 = obj;
        return interruptibleKt$runInterruptible$2;
    }

    public final Object invoke(h0 h0Var, c<? super T> cVar) {
        return ((InterruptibleKt$runInterruptible$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            return InterruptibleKt.d(((h0) this.L$0).getCoroutineContext(), this.$block);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
