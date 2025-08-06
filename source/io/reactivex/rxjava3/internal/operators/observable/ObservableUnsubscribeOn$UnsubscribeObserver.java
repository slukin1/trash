package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

final class ObservableUnsubscribeOn$UnsubscribeObserver<T> extends AtomicBoolean implements k<T>, b {
    private static final long serialVersionUID = 1015244841293359600L;
    public final k<? super T> downstream;
    public final Scheduler scheduler;
    public b upstream;

    public final class a implements Runnable {
        public a() {
        }

        public void run() {
            ObservableUnsubscribeOn$UnsubscribeObserver.this.upstream.dispose();
        }
    }

    public ObservableUnsubscribeOn$UnsubscribeObserver(k<? super T> kVar, Scheduler scheduler2) {
        this.downstream = kVar;
        this.scheduler = scheduler2;
    }

    public void dispose() {
        if (compareAndSet(false, true)) {
            this.scheduler.c(new a());
        }
    }

    public boolean isDisposed() {
        return get();
    }

    public void onComplete() {
        if (!get()) {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (get()) {
            o00.a.n(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    public void onNext(T t11) {
        if (!get()) {
            this.downstream.onNext(t11);
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
