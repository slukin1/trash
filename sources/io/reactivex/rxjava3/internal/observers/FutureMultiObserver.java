package io.reactivex.rxjava3.internal.observers;

import h00.a;
import h00.f;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureMultiObserver<T> extends CountDownLatch implements f<T>, m<T>, a, Future<T>, b {

    /* renamed from: b  reason: collision with root package name */
    public T f55466b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f55467c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<b> f55468d = new AtomicReference<>();

    public FutureMultiObserver() {
        super(1);
    }

    public boolean cancel(boolean z11) {
        b bVar;
        DisposableHelper disposableHelper;
        do {
            bVar = this.f55468d.get();
            if (bVar == this || bVar == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!this.f55468d.compareAndSet(bVar, disposableHelper));
        if (bVar != null) {
            bVar.dispose();
        }
        countDown();
        return true;
    }

    public void dispose() {
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            c.a();
            await();
        }
        if (!isCancelled()) {
            Throwable th2 = this.f55467c;
            if (th2 == null) {
                return this.f55466b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f55468d.get());
    }

    public boolean isDisposed() {
        return isDone();
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        b bVar = this.f55468d.get();
        if (bVar != DisposableHelper.DISPOSED) {
            this.f55468d.compareAndSet(bVar, this);
            countDown();
        }
    }

    public void onError(Throwable th2) {
        b bVar;
        do {
            bVar = this.f55468d.get();
            if (bVar == DisposableHelper.DISPOSED) {
                o00.a.n(th2);
                return;
            }
            this.f55467c = th2;
        } while (!this.f55468d.compareAndSet(bVar, this));
        countDown();
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.f55468d, bVar);
    }

    public void onSuccess(T t11) {
        b bVar = this.f55468d.get();
        if (bVar != DisposableHelper.DISPOSED) {
            this.f55466b = t11;
            this.f55468d.compareAndSet(bVar, this);
            countDown();
        }
    }

    public T get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            c.a();
            if (!await(j11, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.f(j11, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f55467c;
            if (th2 == null) {
                return this.f55466b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
