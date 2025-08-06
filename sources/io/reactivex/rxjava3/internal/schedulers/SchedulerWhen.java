package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SchedulerWhen extends Scheduler implements io.reactivex.rxjava3.disposables.b {

    /* renamed from: c  reason: collision with root package name */
    public static final io.reactivex.rxjava3.disposables.b f55657c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final io.reactivex.rxjava3.disposables.b f55658d = io.reactivex.rxjava3.disposables.a.a();

    public static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Runnable runnable, long j11, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j11;
            this.unit = timeUnit;
        }

        public io.reactivex.rxjava3.disposables.b callActual(Scheduler.Worker worker, h00.a aVar) {
            return worker.c(new a(this.action, aVar), this.delayTime, this.unit);
        }
    }

    public static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        public ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        public io.reactivex.rxjava3.disposables.b callActual(Scheduler.Worker worker, h00.a aVar) {
            return worker.b(new a(this.action, aVar));
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.rxjava3.disposables.b> implements io.reactivex.rxjava3.disposables.b {
        public ScheduledAction() {
            super(SchedulerWhen.f55657c);
        }

        public void call(Scheduler.Worker worker, h00.a aVar) {
            io.reactivex.rxjava3.disposables.b bVar;
            io.reactivex.rxjava3.disposables.b bVar2 = (io.reactivex.rxjava3.disposables.b) get();
            if (bVar2 != SchedulerWhen.f55658d && bVar2 == (bVar = SchedulerWhen.f55657c)) {
                io.reactivex.rxjava3.disposables.b callActual = callActual(worker, aVar);
                if (!compareAndSet(bVar, callActual)) {
                    callActual.dispose();
                }
            }
        }

        public abstract io.reactivex.rxjava3.disposables.b callActual(Scheduler.Worker worker, h00.a aVar);

        public void dispose() {
            ((io.reactivex.rxjava3.disposables.b) getAndSet(SchedulerWhen.f55658d)).dispose();
        }

        public boolean isDisposed() {
            return ((io.reactivex.rxjava3.disposables.b) get()).isDisposed();
        }
    }

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final h00.a f55659b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f55660c;

        public a(Runnable runnable, h00.a aVar) {
            this.f55660c = runnable;
            this.f55659b = aVar;
        }

        public void run() {
            try {
                this.f55660c.run();
            } finally {
                this.f55659b.onComplete();
            }
        }
    }

    public static final class b implements io.reactivex.rxjava3.disposables.b {
        public void dispose() {
        }

        public boolean isDisposed() {
            return false;
        }
    }
}
