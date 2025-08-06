package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.k;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.x0;

public final class i extends CoroutineDispatcher implements p0 {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f57457c;

    public i(Scheduler scheduler) {
        this.f57457c = scheduler;
    }

    public static final void I(b bVar) {
        bVar.dispose();
    }

    public static final void J(k kVar, i iVar) {
        kVar.I(iVar, Unit.f56620a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((i) obj).f57457c == this.f57457c;
    }

    public int hashCode() {
        return System.identityHashCode(this.f57457c);
    }

    public void t(long j11, k<? super Unit> kVar) {
        RxAwaitKt.h(kVar, this.f57457c.d(new g(kVar, this), j11, TimeUnit.MILLISECONDS));
    }

    public String toString() {
        return this.f57457c.toString();
    }

    public x0 u(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        return new h(this.f57457c.d(runnable, j11, TimeUnit.MILLISECONDS));
    }

    public void w(CoroutineContext coroutineContext, Runnable runnable) {
        this.f57457c.c(runnable);
    }
}
