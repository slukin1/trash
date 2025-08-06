package io.reactivex.rxjava3.internal.operators.single;

import h00.m;
import h00.o;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

final class SingleTimeout$TimeoutMainObserver<T> extends AtomicReference<b> implements m<T>, Runnable, b {
    private static final long serialVersionUID = 37497744973048446L;
    public final m<? super T> downstream;
    public final TimeoutFallbackObserver<T> fallback;
    public o<? extends T> other;
    public final AtomicReference<b> task = new AtomicReference<>();
    public final long timeout;
    public final TimeUnit unit;

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<b> implements m<T> {
        private static final long serialVersionUID = 2071387740092105509L;
        public final m<? super T> downstream;

        public TimeoutFallbackObserver(m<? super T> mVar) {
            this.downstream = mVar;
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        public void onSuccess(T t11) {
            this.downstream.onSuccess(t11);
        }
    }

    public SingleTimeout$TimeoutMainObserver(m<? super T> mVar, o<? extends T> oVar, long j11, TimeUnit timeUnit) {
        this.downstream = mVar;
        this.other = oVar;
        this.timeout = j11;
        this.unit = timeUnit;
        if (oVar != null) {
            this.fallback = new TimeoutFallbackObserver<>(mVar);
        } else {
            this.fallback = null;
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.task);
        TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
        if (timeoutFallbackObserver != null) {
            DisposableHelper.dispose(timeoutFallbackObserver);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) get());
    }

    public void onError(Throwable th2) {
        b bVar = (b) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper || !compareAndSet(bVar, disposableHelper)) {
            a.n(th2);
            return;
        }
        DisposableHelper.dispose(this.task);
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void onSuccess(T t11) {
        b bVar = (b) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper && compareAndSet(bVar, disposableHelper)) {
            DisposableHelper.dispose(this.task);
            this.downstream.onSuccess(t11);
        }
    }

    public void run() {
        b bVar = (b) get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper && compareAndSet(bVar, disposableHelper)) {
            if (bVar != null) {
                bVar.dispose();
            }
            o<? extends T> oVar = this.other;
            if (oVar == null) {
                this.downstream.onError(new TimeoutException(ExceptionHelper.f(this.timeout, this.unit)));
                return;
            }
            this.other = null;
            oVar.a(this.fallback);
        }
    }
}
