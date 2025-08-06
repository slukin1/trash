package io.reactivex.rxjava3.internal.operators.observable;

import h00.c;
import h00.i;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import j00.f;
import java.util.concurrent.atomic.AtomicInteger;

final class ObservableCreate$SerializedEmitter<T> extends AtomicInteger implements i<T> {
    private static final long serialVersionUID = 4883307006032401862L;
    public volatile boolean done;
    public final i<T> emitter;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final a<T> queue = new a<>(16);

    public ObservableCreate$SerializedEmitter(i<T> iVar) {
        this.emitter = iVar;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        i<T> iVar = this.emitter;
        a<T> aVar = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        int i11 = 1;
        while (!iVar.isDisposed()) {
            if (atomicThrowable.get() != null) {
                aVar.clear();
                atomicThrowable.tryTerminateConsumer((c<?>) iVar);
                return;
            }
            boolean z11 = this.done;
            T poll = aVar.poll();
            boolean z12 = poll == null;
            if (z11 && z12) {
                iVar.onComplete();
                return;
            } else if (z12) {
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                iVar.onNext(poll);
            }
        }
        aVar.clear();
    }

    public boolean isDisposed() {
        return this.emitter.isDisposed();
    }

    public void onComplete() {
        if (!this.done && !this.emitter.isDisposed()) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (!tryOnError(th2)) {
            o00.a.n(th2);
        }
    }

    public void onNext(T t11) {
        if (!this.done && !this.emitter.isDisposed()) {
            if (t11 == null) {
                onError(ExceptionHelper.b("onNext called with a null value."));
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                a<T> aVar = this.queue;
                synchronized (aVar) {
                    aVar.offer(t11);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.emitter.onNext(t11);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public i<T> serialize() {
        return this;
    }

    public void setCancellable(f fVar) {
        this.emitter.setCancellable(fVar);
    }

    public void setDisposable(b bVar) {
        this.emitter.setDisposable(bVar);
    }

    public String toString() {
        return this.emitter.toString();
    }

    public boolean tryOnError(Throwable th2) {
        if (!this.done && !this.emitter.isDisposed()) {
            if (th2 == null) {
                th2 = ExceptionHelper.b("onError called with a null Throwable.");
            }
            if (this.errors.tryAddThrowable(th2)) {
                this.done = true;
                drain();
                return true;
            }
        }
        return false;
    }
}
