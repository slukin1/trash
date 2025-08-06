package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import j00.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<T, B, V> extends AtomicInteger implements e<T>, d, Runnable {
    private static final long serialVersionUID = 8646217640096099753L;
    public final int bufferSize;
    public final h<? super B, ? extends z20.b<V>> closingIndicator;
    public final c<? super Flowable<T>> downstream;
    public final AtomicBoolean downstreamCancelled;
    public long emitted;
    public final AtomicThrowable error;
    public final z20.b<B> open;
    public volatile boolean openDone;
    public final k00.e<Object> queue = new MpscLinkedQueue();
    public final AtomicLong requested;
    public final CompositeDisposable resources;
    public final WindowStartSubscriber<B> startSubscriber;
    public d upstream;
    public volatile boolean upstreamCanceled;
    public volatile boolean upstreamDone;
    public final AtomicLong windowCount;
    public final List<UnicastProcessor<T>> windows;

    public static final class WindowStartSubscriber<B> extends AtomicReference<d> implements e<B> {
        private static final long serialVersionUID = -3326496781427702834L;
        public final FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<?, B, ?> parent;

        public WindowStartSubscriber(FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<?, B, ?> flowableWindowBoundarySelector$WindowBoundaryMainSubscriber) {
            this.parent = flowableWindowBoundarySelector$WindowBoundaryMainSubscriber;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.parent.openComplete();
        }

        public void onError(Throwable th2) {
            this.parent.openError(th2);
        }

        public void onNext(B b11) {
            this.parent.open(b11);
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public static final class a<T, V> extends Flowable<T> implements e<V>, io.reactivex.rxjava3.disposables.b {

        /* renamed from: c  reason: collision with root package name */
        public final FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<T, ?, V> f55501c;

        /* renamed from: d  reason: collision with root package name */
        public final UnicastProcessor<T> f55502d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<d> f55503e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicBoolean f55504f = new AtomicBoolean();

        public a(FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber<T, ?, V> flowableWindowBoundarySelector$WindowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
            this.f55501c = flowableWindowBoundarySelector$WindowBoundaryMainSubscriber;
            this.f55502d = unicastProcessor;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this.f55503e);
        }

        public boolean isDisposed() {
            return this.f55503e.get() == SubscriptionHelper.CANCELLED;
        }

        public void j(c<? super T> cVar) {
            this.f55502d.subscribe(cVar);
            this.f55504f.set(true);
        }

        public boolean m() {
            return !this.f55504f.get() && this.f55504f.compareAndSet(false, true);
        }

        public void onComplete() {
            this.f55501c.close(this);
        }

        public void onError(Throwable th2) {
            if (isDisposed()) {
                o00.a.n(th2);
            } else {
                this.f55501c.closeError(th2);
            }
        }

        public void onNext(V v11) {
            if (SubscriptionHelper.cancel(this.f55503e)) {
                this.f55501c.close(this);
            }
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this.f55503e, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }
    }

    public static final class b<B> {

        /* renamed from: a  reason: collision with root package name */
        public final B f55505a;

        public b(B b11) {
            this.f55505a = b11;
        }
    }

    public FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber(c<? super Flowable<T>> cVar, z20.b<B> bVar, h<? super B, ? extends z20.b<V>> hVar, int i11) {
        this.downstream = cVar;
        this.open = bVar;
        this.closingIndicator = hVar;
        this.bufferSize = i11;
        this.resources = new CompositeDisposable();
        this.windows = new ArrayList();
        this.windowCount = new AtomicLong(1);
        this.downstreamCancelled = new AtomicBoolean();
        this.error = new AtomicThrowable();
        this.startSubscriber = new WindowStartSubscriber<>(this);
        this.requested = new AtomicLong();
    }

    public void cancel() {
        if (!this.downstreamCancelled.compareAndSet(false, true)) {
            return;
        }
        if (this.windowCount.decrementAndGet() == 0) {
            this.upstream.cancel();
            this.startSubscriber.cancel();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
            return;
        }
        this.startSubscriber.cancel();
    }

    public void close(a<T, V> aVar) {
        this.queue.offer(aVar);
        drain();
    }

    public void closeError(Throwable th2) {
        this.upstream.cancel();
        this.startSubscriber.cancel();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            c<? super Flowable<T>> cVar = this.downstream;
            k00.e<Object> eVar = this.queue;
            List<UnicastProcessor<T>> list = this.windows;
            int i11 = 1;
            while (true) {
                if (this.upstreamCanceled) {
                    eVar.clear();
                    list.clear();
                } else {
                    boolean z11 = this.upstreamDone;
                    Object poll = eVar.poll();
                    boolean z12 = poll == null;
                    if (z11 && (z12 || this.error.get() != null)) {
                        terminateDownstream(cVar);
                        this.upstreamCanceled = true;
                    } else if (!z12) {
                        if (poll instanceof b) {
                            if (!this.downstreamCancelled.get()) {
                                long j11 = this.emitted;
                                if (this.requested.get() != j11) {
                                    this.emitted = j11 + 1;
                                    try {
                                        Object apply = this.closingIndicator.apply(((b) poll).f55505a);
                                        Objects.requireNonNull(apply, "The closingIndicator returned a null Publisher");
                                        z20.b bVar = (z20.b) apply;
                                        this.windowCount.getAndIncrement();
                                        UnicastProcessor o11 = UnicastProcessor.o(this.bufferSize, this);
                                        a aVar = new a(this, o11);
                                        cVar.onNext(aVar);
                                        if (aVar.m()) {
                                            o11.onComplete();
                                        } else {
                                            list.add(o11);
                                            this.resources.a(aVar);
                                            bVar.subscribe(aVar);
                                        }
                                    } catch (Throwable th2) {
                                        io.reactivex.rxjava3.exceptions.a.b(th2);
                                        this.upstream.cancel();
                                        this.startSubscriber.cancel();
                                        this.resources.dispose();
                                        io.reactivex.rxjava3.exceptions.a.b(th2);
                                        this.error.tryAddThrowableOrReport(th2);
                                        this.upstreamDone = true;
                                    }
                                } else {
                                    this.upstream.cancel();
                                    this.startSubscriber.cancel();
                                    this.resources.dispose();
                                    this.error.tryAddThrowableOrReport(new MissingBackpressureException(FlowableWindowTimed.m(j11)));
                                    this.upstreamDone = true;
                                }
                            }
                        } else if (poll instanceof a) {
                            UnicastProcessor<T> unicastProcessor = ((a) poll).f55502d;
                            list.remove(unicastProcessor);
                            this.resources.b((io.reactivex.rxjava3.disposables.b) poll);
                            unicastProcessor.onComplete();
                        } else {
                            for (UnicastProcessor<T> onNext : list) {
                                onNext.onNext(poll);
                            }
                        }
                    } else if (this.openDone && list.size() == 0) {
                        this.upstream.cancel();
                        this.startSubscriber.cancel();
                        this.resources.dispose();
                        terminateDownstream(cVar);
                        this.upstreamCanceled = true;
                    }
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }
    }

    public void onComplete() {
        this.startSubscriber.cancel();
        this.resources.dispose();
        this.upstreamDone = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.startSubscriber.cancel();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    public void onNext(T t11) {
        this.queue.offer(t11);
        drain();
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            this.open.subscribe(this.startSubscriber);
            dVar.request(Long.MAX_VALUE);
        }
    }

    public void open(B b11) {
        this.queue.offer(new b(b11));
        drain();
    }

    public void openComplete() {
        this.openDone = true;
        drain();
    }

    public void openError(Throwable th2) {
        this.upstream.cancel();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
        }
    }

    public void run() {
        if (this.windowCount.decrementAndGet() == 0) {
            this.upstream.cancel();
            this.startSubscriber.cancel();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
        }
    }

    public void terminateDownstream(c<?> cVar) {
        Throwable terminate = this.error.terminate();
        if (terminate == null) {
            for (UnicastProcessor<T> onComplete : this.windows) {
                onComplete.onComplete();
            }
            cVar.onComplete();
        } else if (terminate != ExceptionHelper.f55703a) {
            for (UnicastProcessor<T> onError : this.windows) {
                onError.onError(terminate);
            }
            cVar.onError(terminate);
        }
    }
}
