package kotlinx.coroutines;

import d10.p;
import kotlin.coroutines.CoroutineContext;

public final class p2 implements CoroutineContext.a, CoroutineContext.b<p2> {

    /* renamed from: b  reason: collision with root package name */
    public static final p2 f57389b = new p2();

    public <R> R fold(R r11, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return CoroutineContext.a.C0663a.a(this, r11, pVar);
    }

    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return CoroutineContext.a.C0663a.b(this, bVar);
    }

    public CoroutineContext.b<?> getKey() {
        return this;
    }

    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0663a.c(this, bVar);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0663a.d(this, coroutineContext);
    }
}
