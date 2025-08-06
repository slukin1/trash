package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;
import z20.d;

public final class FlowableWindowTimed<T> extends a<T, Flowable<T>> {

    public static abstract class AbstractWindowSubscriber<T> extends AtomicInteger implements e<T>, d {
        private static final long serialVersionUID = 5724293814035355511L;
        public final int bufferSize;
        public volatile boolean done;
        public final c<? super Flowable<T>> downstream;
        public final AtomicBoolean downstreamCancelled;
        public long emitted;
        public Throwable error;
        public final k00.e<Object> queue = new MpscLinkedQueue();
        public final AtomicLong requested;
        public final long timespan;
        public final TimeUnit unit;
        public d upstream;
        public volatile boolean upstreamCancelled;
        public final AtomicInteger windowCount;

        public AbstractWindowSubscriber(c<? super Flowable<T>> cVar, long j11, TimeUnit timeUnit, int i11) {
            this.downstream = cVar;
            this.timespan = j11;
            this.unit = timeUnit;
            this.bufferSize = i11;
            this.requested = new AtomicLong();
            this.downstreamCancelled = new AtomicBoolean();
            this.windowCount = new AtomicInteger(1);
        }

        public final void cancel() {
            if (this.downstreamCancelled.compareAndSet(false, true)) {
                windowDone();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void cleanupResources();

        /* access modifiers changed from: package-private */
        public abstract void createFirstWindow();

        /* access modifiers changed from: package-private */
        public abstract void drain();

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            drain();
        }

        public final void onNext(T t11) {
            this.queue.offer(t11);
            drain();
        }

        public final void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                createFirstWindow();
            }
        }

        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                b.a(this.requested, j11);
            }
        }

        /* access modifiers changed from: package-private */
        public final void windowDone() {
            if (this.windowCount.decrementAndGet() == 0) {
                cleanupResources();
                this.upstream.cancel();
                this.upstreamCancelled = true;
                drain();
            }
        }
    }

    public static final class WindowExactBoundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;
        public long count;
        public final long maxSize;
        public final boolean restartTimerOnMaxSize;
        public final Scheduler scheduler;
        public final SequentialDisposable timer;
        public UnicastProcessor<T> window;
        public final Scheduler.Worker worker;

        public static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final WindowExactBoundedSubscriber<?> f55506b;

            /* renamed from: c  reason: collision with root package name */
            public final long f55507c;

            public a(WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber, long j11) {
                this.f55506b = windowExactBoundedSubscriber;
                this.f55507c = j11;
            }

            public void run() {
                this.f55506b.boundary(this);
            }
        }

        public WindowExactBoundedSubscriber(c<? super Flowable<T>> cVar, long j11, TimeUnit timeUnit, Scheduler scheduler2, int i11, long j12, boolean z11) {
            super(cVar, j11, timeUnit, i11);
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
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() != 0) {
                this.emitted = 1;
                this.windowCount.getAndIncrement();
                this.window = UnicastProcessor.o(this.bufferSize, this);
                s sVar = new s(this.window);
                this.downstream.onNext(sVar);
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
                if (sVar.m()) {
                    this.window.onComplete();
                }
                this.upstream.request(Long.MAX_VALUE);
                return;
            }
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.m(this.emitted)));
            cleanupResources();
            this.upstreamCancelled = true;
        }

        public UnicastProcessor<T> createNewWindow(UnicastProcessor<T> unicastProcessor) {
            if (unicastProcessor != null) {
                unicastProcessor.onComplete();
                unicastProcessor = null;
            }
            if (this.downstreamCancelled.get()) {
                cleanupResources();
            } else {
                long j11 = this.emitted;
                if (this.requested.get() == j11) {
                    this.upstream.cancel();
                    cleanupResources();
                    this.upstreamCancelled = true;
                    this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.m(j11)));
                } else {
                    long j12 = j11 + 1;
                    this.emitted = j12;
                    this.windowCount.getAndIncrement();
                    unicastProcessor = UnicastProcessor.o(this.bufferSize, this);
                    this.window = unicastProcessor;
                    s sVar = new s(unicastProcessor);
                    this.downstream.onNext(sVar);
                    if (this.restartTimerOnMaxSize) {
                        SequentialDisposable sequentialDisposable = this.timer;
                        Scheduler.Worker worker2 = this.worker;
                        a aVar = new a(this, j12);
                        long j13 = this.timespan;
                        sequentialDisposable.update(worker2.d(aVar, j13, j13, this.unit));
                    }
                    if (sVar.m()) {
                        unicastProcessor.onComplete();
                    }
                }
            }
            return unicastProcessor;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                k00.e<Object> eVar = this.queue;
                c<? super Flowable<T>> cVar = this.downstream;
                UnicastProcessor<T> unicastProcessor = this.window;
                int i11 = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        eVar.clear();
                        this.window = null;
                        unicastProcessor = null;
                    } else {
                        boolean z11 = this.done;
                        Object poll = eVar.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onError(th2);
                                }
                                cVar.onError(th2);
                            } else {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                }
                                cVar.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z12) {
                            if (poll instanceof a) {
                                if (((a) poll).f55507c == this.emitted || !this.restartTimerOnMaxSize) {
                                    this.count = 0;
                                    unicastProcessor = createNewWindow(unicastProcessor);
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
                                long j11 = this.count + 1;
                                if (j11 == this.maxSize) {
                                    this.count = 0;
                                    unicastProcessor = createNewWindow(unicastProcessor);
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

    public static final class WindowExactUnboundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        public static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 1155822639622580836L;
        public final Scheduler scheduler;
        public final SequentialDisposable timer = new SequentialDisposable();
        public UnicastProcessor<T> window;
        public final Runnable windowRunnable = new a();

        public final class a implements Runnable {
            public a() {
            }

            public void run() {
                WindowExactUnboundedSubscriber.this.windowDone();
            }
        }

        public WindowExactUnboundedSubscriber(c<? super Flowable<T>> cVar, long j11, TimeUnit timeUnit, Scheduler scheduler2, int i11) {
            super(cVar, j11, timeUnit, i11);
            this.scheduler = scheduler2;
        }

        public void cleanupResources() {
            this.timer.dispose();
        }

        public void createFirstWindow() {
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() != 0) {
                this.windowCount.getAndIncrement();
                this.window = UnicastProcessor.o(this.bufferSize, this.windowRunnable);
                this.emitted = 1;
                s sVar = new s(this.window);
                this.downstream.onNext(sVar);
                SequentialDisposable sequentialDisposable = this.timer;
                Scheduler scheduler2 = this.scheduler;
                long j11 = this.timespan;
                sequentialDisposable.replace(scheduler2.e(this, j11, j11, this.unit));
                if (sVar.m()) {
                    this.window.onComplete();
                }
                this.upstream.request(Long.MAX_VALUE);
                return;
            }
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.m(this.emitted)));
            cleanupResources();
            this.upstreamCancelled = true;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                k00.e<Object> eVar = this.queue;
                c<? super Flowable<T>> cVar = this.downstream;
                UnicastProcessor<T> unicastProcessor = this.window;
                int i11 = 1;
                while (true) {
                    if (this.upstreamCancelled) {
                        eVar.clear();
                        this.window = null;
                        unicastProcessor = null;
                    } else {
                        boolean z11 = this.done;
                        Object poll = eVar.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onError(th2);
                                }
                                cVar.onError(th2);
                            } else {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                }
                                cVar.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z12) {
                            if (poll == NEXT_WINDOW) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                    this.window = null;
                                    unicastProcessor = null;
                                }
                                if (this.downstreamCancelled.get()) {
                                    this.timer.dispose();
                                } else {
                                    long j11 = this.requested.get();
                                    long j12 = this.emitted;
                                    if (j11 == j12) {
                                        this.upstream.cancel();
                                        cleanupResources();
                                        this.upstreamCancelled = true;
                                        cVar.onError(new MissingBackpressureException(FlowableWindowTimed.m(this.emitted)));
                                    } else {
                                        this.emitted = j12 + 1;
                                        this.windowCount.getAndIncrement();
                                        unicastProcessor = UnicastProcessor.o(this.bufferSize, this.windowRunnable);
                                        this.window = unicastProcessor;
                                        s sVar = new s(unicastProcessor);
                                        cVar.onNext(sVar);
                                        if (sVar.m()) {
                                            unicastProcessor.onComplete();
                                        }
                                    }
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
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

    public static final class WindowSkipSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        public static final Object WINDOW_CLOSE = new Object();
        public static final Object WINDOW_OPEN = new Object();
        private static final long serialVersionUID = -7852870764194095894L;
        public final long timeskip;
        public final List<UnicastProcessor<T>> windows = new LinkedList();
        public final Scheduler.Worker worker;

        public static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final WindowSkipSubscriber<?> f55509b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f55510c;

            public a(WindowSkipSubscriber<?> windowSkipSubscriber, boolean z11) {
                this.f55509b = windowSkipSubscriber;
                this.f55510c = z11;
            }

            public void run() {
                this.f55509b.boundary(this.f55510c);
            }
        }

        public WindowSkipSubscriber(c<? super Flowable<T>> cVar, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker2, int i11) {
            super(cVar, j11, timeUnit, i11);
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
            if (this.downstreamCancelled.get()) {
                return;
            }
            if (this.requested.get() != 0) {
                this.emitted = 1;
                this.windowCount.getAndIncrement();
                UnicastProcessor o11 = UnicastProcessor.o(this.bufferSize, this);
                this.windows.add(o11);
                s sVar = new s(o11);
                this.downstream.onNext(sVar);
                this.worker.c(new a(this, false), this.timespan, this.unit);
                Scheduler.Worker worker2 = this.worker;
                a aVar = new a(this, true);
                long j11 = this.timeskip;
                worker2.d(aVar, j11, j11, this.unit);
                if (sVar.m()) {
                    o11.onComplete();
                    this.windows.remove(o11);
                }
                this.upstream.request(Long.MAX_VALUE);
                return;
            }
            this.upstream.cancel();
            this.downstream.onError(new MissingBackpressureException(FlowableWindowTimed.m(this.emitted)));
            cleanupResources();
            this.upstreamCancelled = true;
        }

        public void drain() {
            if (getAndIncrement() == 0) {
                k00.e<Object> eVar = this.queue;
                c<? super Flowable<T>> cVar = this.downstream;
                List<UnicastProcessor<T>> list = this.windows;
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
                                for (UnicastProcessor<T> onError : list) {
                                    onError.onError(th2);
                                }
                                cVar.onError(th2);
                            } else {
                                for (UnicastProcessor<T> onComplete : list) {
                                    onComplete.onComplete();
                                }
                                cVar.onComplete();
                            }
                            cleanupResources();
                            this.upstreamCancelled = true;
                        } else if (!z12) {
                            if (poll == WINDOW_OPEN) {
                                if (!this.downstreamCancelled.get()) {
                                    long j11 = this.emitted;
                                    if (this.requested.get() != j11) {
                                        this.emitted = j11 + 1;
                                        this.windowCount.getAndIncrement();
                                        UnicastProcessor o11 = UnicastProcessor.o(this.bufferSize, this);
                                        list.add(o11);
                                        s sVar = new s(o11);
                                        cVar.onNext(sVar);
                                        this.worker.c(new a(this, false), this.timespan, this.unit);
                                        if (sVar.m()) {
                                            o11.onComplete();
                                        }
                                    } else {
                                        this.upstream.cancel();
                                        MissingBackpressureException missingBackpressureException = new MissingBackpressureException(FlowableWindowTimed.m(j11));
                                        for (UnicastProcessor<T> onError2 : list) {
                                            onError2.onError(missingBackpressureException);
                                        }
                                        cVar.onError(missingBackpressureException);
                                        cleanupResources();
                                        this.upstreamCancelled = true;
                                    }
                                }
                            } else if (poll != WINDOW_CLOSE) {
                                for (UnicastProcessor<T> onNext : list) {
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

    public static String m(long j11) {
        return "Unable to emit the next window (#" + j11 + ") due to lack of requests. Please make sure the downstream is ready to consume windows.";
    }
}
