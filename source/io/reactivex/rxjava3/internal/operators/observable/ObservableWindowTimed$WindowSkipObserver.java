package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k00.e;

final class ObservableWindowTimed$WindowSkipObserver<T> extends ObservableWindowTimed$AbstractWindowObserver<T> implements Runnable {
    public static final Object WINDOW_CLOSE = new Object();
    public static final Object WINDOW_OPEN = new Object();
    private static final long serialVersionUID = -7852870764194095894L;
    public final long timeskip;
    public final List<UnicastSubject<T>> windows = new LinkedList();
    public final Scheduler.Worker worker;

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final ObservableWindowTimed$WindowSkipObserver<?> f55569b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f55570c;

        public a(ObservableWindowTimed$WindowSkipObserver<?> observableWindowTimed$WindowSkipObserver, boolean z11) {
            this.f55569b = observableWindowTimed$WindowSkipObserver;
            this.f55570c = z11;
        }

        public void run() {
            this.f55569b.boundary(this.f55570c);
        }
    }

    public ObservableWindowTimed$WindowSkipObserver(k<? super Observable<T>> kVar, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker2, int i11) {
        super(kVar, j11, timeUnit, i11);
        this.timeskip = j12;
        this.worker = worker2;
    }

    public void boundary(boolean z11) {
        this.queue.offer(z11 ? WINDOW_OPEN : WINDOW_CLOSE);
        drain();
    }

    public void cleanupResources() {
        this.worker.dispose();
    }

    public void createFirstWindow() {
        if (!this.downstreamCancelled.get()) {
            this.emitted = 1;
            this.windowCount.getAndIncrement();
            UnicastSubject d11 = UnicastSubject.d(this.bufferSize, this);
            this.windows.add(d11);
            o oVar = new o(d11);
            this.downstream.onNext(oVar);
            this.worker.c(new a(this, false), this.timespan, this.unit);
            Scheduler.Worker worker2 = this.worker;
            a aVar = new a(this, true);
            long j11 = this.timeskip;
            worker2.d(aVar, j11, j11, this.unit);
            if (oVar.c()) {
                d11.onComplete();
                this.windows.remove(d11);
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            e<Object> eVar = this.queue;
            k<? super Observable<T>> kVar = this.downstream;
            List<UnicastSubject<T>> list = this.windows;
            int i11 = 1;
            while (true) {
                if (this.upstreamCancelled) {
                    eVar.clear();
                    list.clear();
                } else {
                    boolean z11 = this.done;
                    Object poll = eVar.poll();
                    boolean z12 = poll == null;
                    if (z11 && z12) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            for (UnicastSubject<T> onError : list) {
                                onError.onError(th2);
                            }
                            kVar.onError(th2);
                        } else {
                            for (UnicastSubject<T> onComplete : list) {
                                onComplete.onComplete();
                            }
                            kVar.onComplete();
                        }
                        cleanupResources();
                        this.upstreamCancelled = true;
                    } else if (!z12) {
                        if (poll == WINDOW_OPEN) {
                            if (!this.downstreamCancelled.get()) {
                                this.emitted++;
                                this.windowCount.getAndIncrement();
                                UnicastSubject d11 = UnicastSubject.d(this.bufferSize, this);
                                list.add(d11);
                                o oVar = new o(d11);
                                kVar.onNext(oVar);
                                this.worker.c(new a(this, false), this.timespan, this.unit);
                                if (oVar.c()) {
                                    d11.onComplete();
                                }
                            }
                        } else if (poll != WINDOW_CLOSE) {
                            for (UnicastSubject<T> onNext : list) {
                                onNext.onNext(poll);
                            }
                        } else if (!list.isEmpty()) {
                            list.remove(0).onComplete();
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
