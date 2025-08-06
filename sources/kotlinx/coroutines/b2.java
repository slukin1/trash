package kotlinx.coroutines;

import kotlin.Unit;

public final class b2 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineDispatcher f56989b;

    /* renamed from: c  reason: collision with root package name */
    public final k<Unit> f56990c;

    public b2(CoroutineDispatcher coroutineDispatcher, k<? super Unit> kVar) {
        this.f56989b = coroutineDispatcher;
        this.f56990c = kVar;
    }

    public void run() {
        this.f56990c.I(this.f56989b, Unit.f56620a);
    }
}
