package io.reactivex.rxjava3.internal.operators.flowable;

import h00.c;
import h00.d;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import j00.f;
import java.util.concurrent.atomic.AtomicInteger;
import k00.e;

final class FlowableCreate$SerializedEmitter<T> extends AtomicInteger implements d<T> {
    private static final long serialVersionUID = 4883307006032401862L;
    public volatile boolean done;
    public final FlowableCreate$BaseEmitter<T> emitter;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final e<T> queue = new a(16);

    public FlowableCreate$SerializedEmitter(FlowableCreate$BaseEmitter<T> flowableCreate$BaseEmitter) {
        this.emitter = flowableCreate$BaseEmitter;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        FlowableCreate$BaseEmitter<T> flowableCreate$BaseEmitter = this.emitter;
        e<T> eVar = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        int i11 = 1;
        while (!flowableCreate$BaseEmitter.isCancelled()) {
            if (atomicThrowable.get() != null) {
                eVar.clear();
                atomicThrowable.tryTerminateConsumer((c<?>) flowableCreate$BaseEmitter);
                return;
            }
            boolean z11 = this.done;
            T poll = eVar.poll();
            boolean z12 = poll == null;
            if (z11 && z12) {
                flowableCreate$BaseEmitter.onComplete();
                return;
            } else if (z12) {
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                flowableCreate$BaseEmitter.onNext(poll);
            }
        }
        eVar.clear();
    }

    public boolean isCancelled() {
        return this.emitter.isCancelled();
    }

    public void onComplete() {
        if (!this.emitter.isCancelled() && !this.done) {
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
        if (!this.emitter.isCancelled() && !this.done) {
            if (t11 == null) {
                onError(ExceptionHelper.b("onNext called with a null value."));
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                e<T> eVar = this.queue;
                synchronized (eVar) {
                    eVar.offer(t11);
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

    public long requested() {
        return this.emitter.requested();
    }

    public d<T> serialize() {
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
        if (!this.emitter.isCancelled() && !this.done) {
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
