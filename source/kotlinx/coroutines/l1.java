package kotlinx.coroutines;

import d10.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;

public final class l1 extends JobCancellingNode {

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57371g = AtomicIntegerFieldUpdater.newUpdater(l1.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: f  reason: collision with root package name */
    public final l<Throwable, Unit> f57372f;

    public l1(l<? super Throwable, Unit> lVar) {
        this.f57372f = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        q((Throwable) obj);
        return Unit.f56620a;
    }

    public void q(Throwable th2) {
        if (f57371g.compareAndSet(this, 0, 1)) {
            this.f57372f.invoke(th2);
        }
    }
}
