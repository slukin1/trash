package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;

@d(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {203}, m = "invokeSuspend")
public final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements p<h0, c<? super T>, Object> {
    public final /* synthetic */ p<h0, c<? super T>, Object> $block;
    public final /* synthetic */ Lifecycle.State $minState;
    public final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, p<? super h0, ? super c<? super T>, ? extends Object> pVar, c<? super PausingDispatcherKt$whenStateAtLeast$2> cVar) {
        super(2, cVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, cVar);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    public final Object invoke(h0 h0Var, c<? super T> cVar) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        q qVar;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            n1 n1Var = (n1) ((h0) this.L$0).getCoroutineContext().get(n1.f57382r0);
            if (n1Var != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                q qVar2 = new q(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.f9930c, n1Var);
                try {
                    p<h0, c<? super T>, Object> pVar = this.$block;
                    this.L$0 = qVar2;
                    this.label = 1;
                    obj = g.g(pausingDispatcher, pVar, this);
                    if (obj == d11) {
                        return d11;
                    }
                    qVar = qVar2;
                } catch (Throwable th2) {
                    th = th2;
                    qVar = qVar2;
                    qVar.b();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i11 == 1) {
            qVar = (q) this.L$0;
            try {
                k.b(obj);
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        qVar.b();
        return obj;
    }
}
