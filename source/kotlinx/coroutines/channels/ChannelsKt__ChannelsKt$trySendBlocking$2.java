package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend")
public final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements p<h0, c<? super ChannelResult<? extends Unit>>, Object> {
    public final /* synthetic */ E $element;
    public final /* synthetic */ m<E> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsKt__ChannelsKt$trySendBlocking$2(m<? super E> mVar, E e11, c<? super ChannelsKt__ChannelsKt$trySendBlocking$2> cVar) {
        super(2, cVar);
        this.$this_trySendBlocking = mVar;
        this.$element = e11;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 channelsKt__ChannelsKt$trySendBlocking$2 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, cVar);
        channelsKt__ChannelsKt$trySendBlocking$2.L$0 = obj;
        return channelsKt__ChannelsKt$trySendBlocking$2;
    }

    public final Object invoke(h0 h0Var, c<? super ChannelResult<Unit>> cVar) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            h0 h0Var = (h0) this.L$0;
            m<E> mVar = this.$this_trySendBlocking;
            E e11 = this.$element;
            Result.a aVar = Result.Companion;
            this.label = 1;
            if (mVar.send(e11, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            try {
                k.b(obj);
            } catch (Throwable th2) {
                Result.a aVar2 = Result.Companion;
                obj2 = Result.m3072constructorimpl(k.a(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m3072constructorimpl(Unit.f56620a);
        if (Result.m3079isSuccessimpl(obj2)) {
            obj3 = ChannelResult.f57037b.c(Unit.f56620a);
        } else {
            obj3 = ChannelResult.f57037b.a(Result.m3075exceptionOrNullimpl(obj2));
        }
        return ChannelResult.b(obj3);
    }
}
