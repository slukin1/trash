package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.coroutines.c;

public final class h {
    public static final void b(ReceiveChannel<?> receiveChannel, Throwable th2) {
        ChannelsKt__Channels_commonKt.a(receiveChannel, th2);
    }

    public static final <E, C extends m<? super E>> Object s(ReceiveChannel<? extends E> receiveChannel, C c11, c<? super C> cVar) {
        return ChannelsKt__DeprecatedKt.r(receiveChannel, c11, cVar);
    }

    public static final <E, C extends Collection<? super E>> Object t(ReceiveChannel<? extends E> receiveChannel, C c11, c<? super C> cVar) {
        return ChannelsKt__DeprecatedKt.s(receiveChannel, c11, cVar);
    }

    public static final <E> Object u(ReceiveChannel<? extends E> receiveChannel, c<? super List<? extends E>> cVar) {
        return ChannelsKt__Channels_commonKt.d(receiveChannel, cVar);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object v(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m11, c<? super M> cVar) {
        return ChannelsKt__DeprecatedKt.t(receiveChannel, m11, cVar);
    }

    public static final <E> Object w(m<? super E> mVar, E e11) {
        return ChannelsKt__ChannelsKt.a(mVar, e11);
    }
}
