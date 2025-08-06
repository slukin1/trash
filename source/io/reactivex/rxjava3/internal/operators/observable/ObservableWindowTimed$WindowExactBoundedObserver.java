package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;
import k00.e;

final class ObservableWindowTimed$WindowExactBoundedObserver<T> extends ObservableWindowTimed$AbstractWindowObserver<T> implements Runnable {
    private static final long serialVersionUID = -6130475889925953722L;
    public long count;
    public final long maxSize;
    public final boolean restartTimerOnMaxSize;
    public final Scheduler scheduler;
    public final SequentialDisposable timer;
    public UnicastSubject<T> window;
    public final Scheduler.Worker worker;

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final ObservableWindowTimed$WindowExactBoundedObserver<?> f55566b;

        /* renamed from: c  reason: collision with root package name */
        public final long f55567c;

        public a(ObservableWindowTimed$WindowExactBoundedObserver<?> observableWindowTimed$WindowExactBoundedObserver, long j11) {
            this.f55566b = observableWindowTimed$WindowExactBoundedObserver;
            this.f55567c = j11;
        }

        public void run() {
            this.f55566b.boundary(this);
        }
    }

    public ObservableWindowTimed$WindowExactBoundedObserver(k<? super Observable<T>> kVar, long j11, TimeUnit timeUnit, Scheduler scheduler2, int i11, long j12, boolean z11) {
        super(kVar, j11, timeUnit, i11);
        this.scheduler = scheduler2;
        this.maxSize = j12;
        this.restartTimerOnMaxSize = z11;
        if (z11) {
            this.worker = scheduler2.a();
        } else {
            this.worker = null;
        }
        this.timer = new SequentialDisposable();
    }

    public void boundary(a aVar) {
        this.queue.offer(aVar);
        drain();
    }

    public void cleanupResources() {
        this.timer.dispose();
        Scheduler.Worker worker2 = this.worker;
        if (worker2 != null) {
            worker2.dispose();
        }
    }

    public void createFirstWindow() {
        if (!this.downstreamCancelled.get()) {
            this.emitted = 1;
            this.windowCount.getAndIncrement();
            UnicastSubject<T> d11 = UnicastSubject.d(this.bufferSize, this);
            this.window = d11;
            o oVar = new o(d11);
            this.downstream.onNext(oVar);
            a aVar = new a(this, 1);
            if (this.restartTimerOnMaxSize) {
                SequentialDisposable sequentialDisposable = this.timer;
                Scheduler.Worker worker2 = this.worker;
                long j11 = this.timespan;
                sequentialDisposable.replace(worker2.d(aVar, j11, j11, this.unit));
            } else {
                SequentialDisposable sequentialDisposable2 = this.timer;
                Scheduler scheduler2 = this.scheduler;
                long j12 = this.timespan;
                sequentialDisposable2.replace(scheduler2.e(aVar, j12, j12, this.unit));
            }
            if (oVar.c()) {
                this.window.onComplete();
            }
        }
    }

    public UnicastSubject<T> createNewWindow(UnicastSubject<T> unicastSubject) {
        if (unicastSubject != null) {
            unicastSubject.onComplete();
            unicastSubject = null;
        }
        if (this.downstreamCancelled.get()) {
            cleanupResources();
        } else {
            long j11 = this.emitted + 1;
            this.emitted = j11;
            this.windowCount.getAndIncrement();
            unicastSubject = UnicastSubject.d(this.bufferSize, this);
            this.window = unicastSubject;
            o oVar = new o(unicastSubject);
            this.downstream.onNext(oVar);
            if (this.restartTimerOnMaxSize) {
                SequentialDisposable sequentialDisposable = this.timer;
                Scheduler.Worker worker2 = this.worker;
                a aVar = new a(this, j11);
                long j12 = this.timespan;
                sequentialDisposable.update(worker2.d(aVar, j12, j12, this.unit));
            }
            if (oVar.c()) {
                unicastSubject.onComplete();
            }
        }
        return unicastSubject;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            e<Object> eVar = this.queue;
            k<? super Observable<T>> kVar = this.downstream;
            UnicastSubject<T> unicastSubject = this.window;
            int i11 = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    eVar.clear();
                    this.window = null;
                    unicastSubject = null;
                } else {
                    boolean z11 = this.done;
                    Object poll = eVar.poll();
                    boolean z12 = poll == null;
                    if (z11 && z12) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            if (unicastSubject != null) {
                                unicastSubject.onError(th2);
                            }
                            kVar.onError(th2);
                        } else {
                            if (unicastSubject != null) {
                                unicastSubject.onComplete();
                            }
                            kVar.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z12) {
                        if (poll instanceof a) {
                            if (((a) poll).f55567c == this.emitted || !this.restartTimerOnMaxSize) {
                                this.count = 0;
                                unicastSubject = createNewWindow(unicastSubject);
                            }
                        } else if (unicastSubject != null) {
                            unicastSubject.onNext(poll);
                            long j11 = this.count + 1;
                            if (j11 == this.maxSize) {
                                this.count = 0;
                                unicastSubject = createNewWindow(unicastSubject);
                            } else {
                                this.count = j11;
                            }
                        }
                    }
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }
    }

    public void run() {
        windowDone();
    }
}
