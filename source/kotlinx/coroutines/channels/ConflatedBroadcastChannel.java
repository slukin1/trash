package kotlinx.coroutines.channels;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;

public final class ConflatedBroadcastChannel<E> implements b<E> {

    /* renamed from: b  reason: collision with root package name */
    public final BroadcastChannelImpl<E> f57041b;

    public ConflatedBroadcastChannel(BroadcastChannelImpl<E> broadcastChannelImpl) {
        this.f57041b = broadcastChannelImpl;
    }

    public void H(l<? super Throwable, Unit> lVar) {
        this.f57041b.H(lVar);
    }

    public boolean K(Throwable th2) {
        return this.f57041b.K(th2);
    }

    public ReceiveChannel<E> i() {
        return this.f57041b.i();
    }

    public Object q(E e11) {
        return this.f57041b.q(e11);
    }

    public Object send(E e11, c<? super Unit> cVar) {
        return this.f57041b.send(e11, cVar);
    }

    public ConflatedBroadcastChannel() {
        this(new BroadcastChannelImpl(-1));
    }
}
