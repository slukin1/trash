package io.reactivex.rxjava3.internal.subscribers;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
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
import z20.d;

public final class FutureSubscriber<T> extends CountDownLatch implements e<T>, Future<T>, d {

    /* renamed from: b  reason: collision with root package name */
    public T f55698b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f55699c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<d> f55700d = new AtomicReference<>();

    public FutureSubscriber() {
        super(1);
    }

    public void cancel() {
    }

    public boolean cancel(boolean z11) {
        d dVar;
        SubscriptionHelper subscriptionHelper;
        do {
            dVar = this.f55700d.get();
            if (dVar == this || dVar == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!this.f55700d.compareAndSet(dVar, subscriptionHelper));
        if (dVar != null) {
            dVar.cancel();
        }
        countDown();
        return true;
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            c.a();
            await();
        }
        if (!isCancelled()) {
            Throwable th2 = this.f55699c;
            if (th2 == null) {
                return this.f55698b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return this.f55700d.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        if (this.f55698b == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        d dVar = this.f55700d.get();
        if (dVar != this && dVar != SubscriptionHelper.CANCELLED && this.f55700d.compareAndSet(dVar, this)) {
            countDown();
        }
    }

    public void onError(Throwable th2) {
        d dVar;
        if (this.f55699c != null || (dVar = this.f55700d.get()) == this || dVar == SubscriptionHelper.CANCELLED || !this.f55700d.compareAndSet(dVar, this)) {
            a.n(th2);
            return;
        }
        this.f55699c = th2;
        countDown();
    }

    public void onNext(T t11) {
        if (this.f55698b != null) {
            this.f55700d.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f55698b = t11;
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this.f55700d, dVar, Long.MAX_VALUE);
    }

    public void request(long j11) {
    }

    public T get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            c.a();
            if (!await(j11, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.f(j11, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f55699c;
            if (th2 == null) {
                return this.f55698b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
