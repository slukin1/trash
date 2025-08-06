package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.e;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableRepeatWhen$RepeatWhenObserver<T> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = 802743776666017014L;
    public volatile boolean active;
    public final k<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public final ObservableRepeatWhen$RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
    public final Subject<Object> signaller;
    public final j<T> source;
    public final AtomicReference<b> upstream = new AtomicReference<>();
    public final AtomicInteger wip = new AtomicInteger();

    public final class InnerRepeatObserver extends AtomicReference<b> implements k<Object> {
        private static final long serialVersionUID = 3254781284376480842L;

        public InnerRepeatObserver() {
        }

        public void onComplete() {
            ObservableRepeatWhen$RepeatWhenObserver.this.innerComplete();
        }

        public void onError(Throwable th2) {
            ObservableRepeatWhen$RepeatWhenObserver.this.innerError(th2);
        }

        public void onNext(Object obj) {
            ObservableRepeatWhen$RepeatWhenObserver.this.innerNext();
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableRepeatWhen$RepeatWhenObserver(k<? super T> kVar, Subject<Object> subject, j<T> jVar) {
        this.downstream = kVar;
        this.signaller = subject;
        this.source = jVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.inner);
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        e.a(this.downstream, this, this.error);
    }

    public void innerError(Throwable th2) {
        DisposableHelper.dispose(this.upstream);
        e.c(this.downstream, th2, this, this.error);
    }

    public void innerNext() {
        subscribeNext();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    public void onComplete() {
        DisposableHelper.replace(this.upstream, (b) null);
        this.active = false;
        this.signaller.onNext(0);
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.inner);
        e.c(this.downstream, th2, this, this.error);
    }

    public void onNext(T t11) {
        e.e(this.downstream, t11, this, this.error);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.upstream, bVar);
    }

    public void subscribeNext() {
        if (this.wip.getAndIncrement() == 0) {
            while (!isDisposed()) {
                if (!this.active) {
                    this.active = true;
                    this.source.subscribe(this);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }
}
