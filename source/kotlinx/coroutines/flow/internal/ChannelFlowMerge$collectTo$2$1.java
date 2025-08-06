package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.sync.b;

@d(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", l = {69}, m = "invokeSuspend")
final class ChannelFlowMerge$collectTo$2$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ m<Object> $collector;
    public final /* synthetic */ kotlinx.coroutines.flow.d<Object> $inner;
    public final /* synthetic */ b $semaphore;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.d<Object> dVar, m<Object> mVar, b bVar, c<? super ChannelFlowMerge$collectTo$2$1> cVar) {
        super(2, cVar);
        this.$inner = dVar;
        this.$collector = mVar;
        this.$semaphore = bVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ChannelFlowMerge$collectTo$2$1(this.$inner, this.$collector, this.$semaphore, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((ChannelFlowMerge$collectTo$2$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            kotlinx.coroutines.flow.d<Object> dVar = this.$inner;
            m<Object> mVar = this.$collector;
            this.label = 1;
            if (dVar.collect(mVar, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            try {
                k.b(obj);
            } catch (Throwable th2) {
                this.$semaphore.release();
                throw th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$semaphore.release();
        return Unit.f56620a;
    }
}
