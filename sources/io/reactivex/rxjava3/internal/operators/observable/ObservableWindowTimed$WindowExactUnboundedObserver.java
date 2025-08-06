package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;
import k00.e;

final class ObservableWindowTimed$WindowExactUnboundedObserver<T> extends ObservableWindowTimed$AbstractWindowObserver<T> implements Runnable {
    public static final Object NEXT_WINDOW = new Object();
    private static final long serialVersionUID = 1155822639622580836L;
    public final Scheduler scheduler;
    public final SequentialDisposable timer = new SequentialDisposable();
    public UnicastSubject<T> window;
    public final Runnable windowRunnable = new a();

    public final class a implements Runnable {
        public a() {
        }

        public void run() {
            ObservableWindowTimed$WindowExactUnboundedObserver.this.windowDone();
        }
    }

    public ObservableWindowTimed$WindowExactUnboundedObserver(k<? super Observable<T>> kVar, long j11, TimeUnit timeUnit, Scheduler scheduler2, int i11) {
        super(kVar, j11, timeUnit, i11);
        this.scheduler = scheduler2;
    }

    public void cleanupResources() {
        this.timer.dispose();
    }

    public void createFirstWindow() {
        if (!this.downstreamCancelled.get()) {
            this.windowCount.getAndIncrement();
            UnicastSubject<T> d11 = UnicastSubject.d(this.bufferSize, this.windowRunnable);
            this.window = d11;
            this.emitted = 1;
            o oVar = new o(d11);
            this.downstream.onNext(oVar);
            SequentialDisposable sequentialDisposable = this.timer;
            Scheduler scheduler2 = this.scheduler;
            long j11 = this.timespan;
            sequentialDisposable.replace(scheduler2.e(this, j11, j11, this.unit));
            if (oVar.c()) {
                this.window.onComplete();
            }
        }
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
                        if (poll == NEXT_WINDOW) {
                            if (unicastSubject != null) {
                                unicastSubject.onComplete();
                                this.window = null;
                                unicastSubject = null;
                            }
                            if (this.downstreamCancelled.get()) {
                                this.timer.dispose();
                            } else {
                                this.emitted++;
                                this.windowCount.getAndIncrement();
                                unicastSubject = UnicastSubject.d(this.bufferSize, this.windowRunnable);
                                this.window = unicastSubject;
                                o oVar = new o(unicastSubject);
                                kVar.onNext(oVar);
                                if (oVar.c()) {
                                    unicastSubject.onComplete();
                                }
                            }
                        } else if (unicastSubject != null) {
                            unicastSubject.onNext(poll);
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
        this.queue.offer(NEXT_WINDOW);
        drain();
    }
}
