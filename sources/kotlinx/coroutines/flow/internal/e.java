package kotlinx.coroutines.flow.internal;

import d10.p;
import kotlin.coroutines.CoroutineContext;

public final class e implements CoroutineContext {

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f57260b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f57261c;

    public e(Throwable th2, CoroutineContext coroutineContext) {
        this.f57260b = th2;
        this.f57261c = coroutineContext;
    }

    public <R> R fold(R r11, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return this.f57261c.fold(r11, pVar);
    }

    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return this.f57261c.get(bVar);
    }

    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return this.f57261c.minusKey(bVar);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.f57261c.plus(coroutineContext);
    }
}
