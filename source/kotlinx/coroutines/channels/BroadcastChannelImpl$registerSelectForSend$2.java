package kotlinx.coroutines.channels;

import d10.p;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import kotlinx.coroutines.selects.k;

@d(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", l = {291}, m = "invokeSuspend")
public final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ k<?> $select;
    public int label;
    public final /* synthetic */ BroadcastChannelImpl<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastChannelImpl$registerSelectForSend$2(BroadcastChannelImpl<E> broadcastChannelImpl, Object obj, k<?> kVar, c<? super BroadcastChannelImpl$registerSelectForSend$2> cVar) {
        super(2, cVar);
        this.this$0 = broadcastChannelImpl;
        this.$element = obj;
        this.$select = kVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new BroadcastChannelImpl$registerSelectForSend$2(this.this$0, this.$element, this.$select, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z11;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        boolean z12 = false;
        if (i11 == 0) {
            kotlin.k.b(obj);
            BroadcastChannelImpl<E> broadcastChannelImpl = this.this$0;
            Object obj2 = this.$element;
            this.label = 1;
            if (broadcastChannelImpl.send(obj2, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            try {
                kotlin.k.b(obj);
            } catch (Throwable th2) {
                if (!this.this$0.u() || (!(th2 instanceof ClosedSendChannelException) && this.this$0.Y() != th2)) {
                    throw th2;
                }
                z11 = false;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z11 = true;
        ReentrantLock g12 = this.this$0.f56995o;
        BroadcastChannelImpl<E> broadcastChannelImpl2 = this.this$0;
        k<?> kVar = this.$select;
        g12.lock();
        try {
            if (j0.a()) {
                if (broadcastChannelImpl2.f56998r.get(kVar) == null) {
                    z12 = true;
                }
                if (!z12) {
                    throw new AssertionError();
                }
            }
            broadcastChannelImpl2.f56998r.put(kVar, z11 ? Unit.f56620a : BufferedChannelKt.z());
            SelectImplementation selectImplementation = (SelectImplementation) kVar;
            Unit unit = Unit.f56620a;
            if (((SelectImplementation) kVar).C(broadcastChannelImpl2, unit) != TrySelectDetailedResult.REREGISTER) {
                broadcastChannelImpl2.f56998r.remove(kVar);
            }
            return unit;
        } finally {
            g12.unlock();
        }
    }
}
