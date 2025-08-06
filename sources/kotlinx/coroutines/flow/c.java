package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.internal.ChannelFlow;

public class c<T> extends ChannelFlow<T> {

    /* renamed from: e  reason: collision with root package name */
    public final p<k<? super T>, kotlin.coroutines.c<? super Unit>, Object> f57217e;

    public c(p<? super k<? super T>, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.f57217e = pVar;
    }

    public static /* synthetic */ <T> Object n(c<T> cVar, k<? super T> kVar, kotlin.coroutines.c<? super Unit> cVar2) {
        Object invoke = cVar.f57217e.invoke(kVar, cVar2);
        return invoke == IntrinsicsKt__IntrinsicsKt.d() ? invoke : Unit.f56620a;
    }

    public Object h(k<? super T> kVar, kotlin.coroutines.c<? super Unit> cVar) {
        return n(this, kVar, cVar);
    }

    public String toString() {
        return "block[" + this.f57217e + "] -> " + super.toString();
    }
}
