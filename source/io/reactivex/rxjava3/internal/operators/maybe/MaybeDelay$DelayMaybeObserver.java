package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

final class MaybeDelay$DelayMaybeObserver<T> extends AtomicReference<b> implements f<T>, b, Runnable {
    private static final long serialVersionUID = 5566860102500855068L;
    public final long delay;
    public final boolean delayError;
    public final f<? super T> downstream;
    public Throwable error;
    public final Scheduler scheduler;
    public final TimeUnit unit;
    public T value;

    public MaybeDelay$DelayMaybeObserver(f<? super T> fVar, long j11, TimeUnit timeUnit, Scheduler scheduler2, boolean z11) {
        this.downstream = fVar;
        this.delay = j11;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onComplete() {
        schedule(this.delay);
    }

    public void onError(Throwable th2) {
        this.error = th2;
        schedule(this.delayError ? this.delay : 0);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.value = t11;
        schedule(this.delay);
    }

    public void run() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.downstream.onError(th2);
            return;
        }
        T t11 = this.value;
        if (t11 != null) {
            this.downstream.onSuccess(t11);
        } else {
            this.downstream.onComplete();
        }
    }

    public void schedule(long j11) {
        DisposableHelper.replace(this, this.scheduler.d(this, j11, this.unit));
    }
}
