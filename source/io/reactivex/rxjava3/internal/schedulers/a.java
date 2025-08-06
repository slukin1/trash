package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

public final class a implements Callable<Void>, b {

    /* renamed from: g  reason: collision with root package name */
    public static final FutureTask<Void> f55668g = new FutureTask<>(Functions.f55443b, (Object) null);

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f55669b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Future<?>> f55670c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Future<?>> f55671d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f55672e;

    /* renamed from: f  reason: collision with root package name */
    public Thread f55673f;

    public a(Runnable runnable, ExecutorService executorService) {
        this.f55669b = runnable;
        this.f55672e = executorService;
    }

    /* renamed from: a */
    public Void call() {
        this.f55673f = Thread.currentThread();
        try {
            this.f55669b.run();
            c(this.f55672e.submit(this));
            this.f55673f = null;
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            this.f55673f = null;
            o00.a.n(th2);
        }
        return null;
    }

    public void b(Future<?> future) {
        Future future2;
        do {
            future2 = this.f55671d.get();
            if (future2 == f55668g) {
                future.cancel(this.f55673f != Thread.currentThread());
                return;
            }
        } while (!this.f55671d.compareAndSet(future2, future));
    }

    public void c(Future<?> future) {
        Future future2;
        do {
            future2 = this.f55670c.get();
            if (future2 == f55668g) {
                future.cancel(this.f55673f != Thread.currentThread());
                return;
            }
        } while (!this.f55670c.compareAndSet(future2, future));
    }

    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f55671d;
        Future future = f55668g;
        Future andSet = atomicReference.getAndSet(future);
        boolean z11 = true;
        if (!(andSet == null || andSet == future)) {
            andSet.cancel(this.f55673f != Thread.currentThread());
        }
        Future andSet2 = this.f55670c.getAndSet(future);
        if (andSet2 != null && andSet2 != future) {
            if (this.f55673f == Thread.currentThread()) {
                z11 = false;
            }
            andSet2.cancel(z11);
        }
    }

    public boolean isDisposed() {
        return this.f55671d.get() == f55668g;
    }
}
