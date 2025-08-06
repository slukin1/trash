package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.q2;

public final class l<E> implements q2 {

    /* renamed from: b  reason: collision with root package name */
    public final kotlinx.coroutines.l<ChannelResult<? extends E>> f57053b;

    public l(kotlinx.coroutines.l<? super ChannelResult<? extends E>> lVar) {
        this.f57053b = lVar;
    }

    public void b(z<?> zVar, int i11) {
        this.f57053b.b(zVar, i11);
    }
}
