package io.reactivex.rxjava3.internal.operators.flowable;

import h00.d;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import j00.f;
import java.util.concurrent.atomic.AtomicLong;
import o00.a;
import z20.c;

abstract class FlowableCreate$BaseEmitter<T> extends AtomicLong implements d<T>, z20.d {
    private static final long serialVersionUID = 7326289992464377023L;
    public final c<? super T> downstream;
    public final SequentialDisposable serial = new SequentialDisposable();

    public FlowableCreate$BaseEmitter(c<? super T> cVar) {
        this.downstream = cVar;
    }

    public final void cancel() {
        this.serial.dispose();
        onUnsubscribed();
    }

    public void completeDownstream() {
        if (!isCancelled()) {
            try {
                this.downstream.onComplete();
            } finally {
                this.serial.dispose();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean errorDownstream(Throwable th2) {
        if (isCancelled()) {
            return false;
        }
        try {
            this.downstream.onError(th2);
            this.serial.dispose();
            return true;
        } catch (Throwable th3) {
            this.serial.dispose();
            throw th3;
        }
    }

    public final boolean isCancelled() {
        return this.serial.isDisposed();
    }

    public void onComplete() {
        completeDownstream();
    }

    public final void onError(Throwable th2) {
        if (th2 == null) {
            th2 = ExceptionHelper.b("onError called with a null Throwable.");
        }
        if (!signalError(th2)) {
            a.n(th2);
        }
    }

    public abstract /* synthetic */ void onNext(T t11);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public final void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this, j11);
            onRequested();
        }
    }

    public final long requested() {
        return get();
    }

    public final d<T> serialize() {
        return new FlowableCreate$SerializedEmitter(this);
    }

    public final void setCancellable(f fVar) {
        setDisposable(new CancellableDisposable(fVar));
    }

    public final void setDisposable(io.reactivex.rxjava3.disposables.b bVar) {
        this.serial.update(bVar);
    }

    public boolean signalError(Throwable th2) {
        return errorDownstream(th2);
    }

    public String toString() {
        return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
    }

    public final boolean tryOnError(Throwable th2) {
        if (th2 == null) {
            th2 = ExceptionHelper.b("tryOnError called with a null Throwable.");
        }
        return signalError(th2);
    }
}
