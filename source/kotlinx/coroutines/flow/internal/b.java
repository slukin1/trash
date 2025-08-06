package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.internal.ThreadContextKt;

public final class b {
    public static final <T> ChannelFlow<T> b(d<? extends T> dVar) {
        ChannelFlow<T> channelFlow = dVar instanceof ChannelFlow ? (ChannelFlow) dVar : null;
        return channelFlow == null ? new d(dVar, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (r) null) : channelFlow;
    }

    /* JADX INFO: finally extract failed */
    public static final <T, V> Object c(CoroutineContext coroutineContext, V v11, Object obj, p<? super V, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        Object c11 = ThreadContextKt.c(coroutineContext, obj);
        try {
            Object invoke = ((p) TypeIntrinsics.e(pVar, 2)).invoke(v11, new n(cVar, coroutineContext));
            ThreadContextKt.a(coroutineContext, c11);
            if (invoke == IntrinsicsKt__IntrinsicsKt.d()) {
                f.c(cVar);
            }
            return invoke;
        } catch (Throwable th2) {
            ThreadContextKt.a(coroutineContext, c11);
            throw th2;
        }
    }

    public static /* synthetic */ Object d(CoroutineContext coroutineContext, Object obj, Object obj2, p pVar, c cVar, int i11, Object obj3) {
        if ((i11 & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return c(coroutineContext, obj, obj2, pVar, cVar);
    }

    public static final <T> e<T> e(e<? super T> eVar, CoroutineContext coroutineContext) {
        return eVar instanceof m ? true : eVar instanceof j ? eVar : new UndispatchedContextCollector(eVar, coroutineContext);
    }
}
