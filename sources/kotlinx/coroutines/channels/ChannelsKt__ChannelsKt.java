package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.h;

public final /* synthetic */ class ChannelsKt__ChannelsKt {
    public static final <E> Object a(m<? super E> mVar, E e11) {
        Object q11 = mVar.q(e11);
        if (q11 instanceof ChannelResult.Failed) {
            return ((ChannelResult) h.b((CoroutineContext) null, new ChannelsKt__ChannelsKt$trySendBlocking$2(mVar, e11, (c<? super ChannelsKt__ChannelsKt$trySendBlocking$2>) null), 1, (Object) null)).l();
        }
        Unit unit = (Unit) q11;
        return ChannelResult.f57037b.c(Unit.f56620a);
    }
}
