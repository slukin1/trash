package io.reactivex.rxjava3.internal.observers;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.c;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

public final class FutureObserver<T> extends CountDownLatch implements k<T>, Future<T>, b {

    /* renamed from: b  reason: collision with root package name */
    public T f55469b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f55470c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<b> f55471d = new AtomicReference<>();

    public FutureObserver() {
        super(1);
    }

    public boolean cancel(boolean z11) {
        b bVar;
        DisposableHelper disposableHelper;
        do {
            bVar = this.f55471d.get();
            if (bVar == this || bVar == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!this.f55471d.compareAndSet(bVar, disposableHelper));
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
            Throwable th2 = this.f55470c;
            if (th2 == null) {
                return this.f55469b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f55471d.get());
    }

    public boolean isDisposed() {
        return isDone();
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        if (this.f55469b == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        b bVar = this.f55471d.get();
        if (bVar != this && bVar != DisposableHelper.DISPOSED && this.f55471d.compareAndSet(bVar, this)) {
            countDown();
        }
    }

    public void onError(Throwable th2) {
        b bVar;
        if (this.f55470c != null || (bVar = this.f55471d.get()) == this || bVar == DisposableHelper.DISPOSED || !this.f55471d.compareAndSet(bVar, this)) {
            a.n(th2);
            return;
        }
        this.f55470c = th2;
        countDown();
    }

    public void onNext(T t11) {
        if (this.f55469b != null) {
            this.f55471d.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f55469b = t11;
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this.f55471d, bVar);
    }

    public T get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            c.a();
            if (!await(j11, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.f(j11, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f55470c;
            if (th2 == null) {
                return this.f55469b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
