package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

public final class h1<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d<T> f57224a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57225b;

    /* renamed from: c  reason: collision with root package name */
    public final BufferOverflow f57226c;

    /* renamed from: d  reason: collision with root package name */
    public final CoroutineContext f57227d;

    public h1(d<? extends T> dVar, int i11, BufferOverflow bufferOverflow, CoroutineContext coroutineContext) {
        this.f57224a = dVar;
        this.f57225b = i11;
        this.f57226c = bufferOverflow;
        this.f57227d = coroutineContext;
    }
}
