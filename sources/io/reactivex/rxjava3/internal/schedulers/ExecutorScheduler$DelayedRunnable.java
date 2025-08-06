package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

final class ExecutorScheduler$DelayedRunnable extends AtomicReference<Runnable> implements Runnable, b {
    private static final long serialVersionUID = -4101336210206799084L;
    public final SequentialDisposable direct = new SequentialDisposable();
    public final SequentialDisposable timed = new SequentialDisposable();

    public ExecutorScheduler$DelayedRunnable(Runnable runnable) {
        super(runnable);
    }

    public void dispose() {
        if (getAndSet((Object) null) != null) {
            this.timed.dispose();
            this.direct.dispose();
        }
    }

    public Runnable getWrappedRunnable() {
        Runnable runnable = (Runnable) get();
        return runnable != null ? runnable : Functions.f55443b;
    }

    public boolean isDisposed() {
        return get() == null;
    }

    public void run() {
        Runnable runnable = (Runnable) get();
        if (runnable != null) {
            try {
                runnable.run();
                lazySet((Object) null);
                SequentialDisposable sequentialDisposable = this.timed;
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                sequentialDisposable.lazySet(disposableHelper);
                this.direct.lazySet(disposableHelper);
            } catch (Throwable th2) {
                lazySet((Object) null);
                this.timed.lazySet(DisposableHelper.DISPOSED);
                this.direct.lazySet(DisposableHelper.DISPOSED);
                throw th2;
            }
        }
    }
}
