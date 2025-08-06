package io.reactivex.rxjava3.internal.operators.observable;

import h00.j;
import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import j00.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k00.e;

final class ObservableWindowBoundarySelector$WindowBoundaryMainObserver<T, B, V> extends AtomicInteger implements k<T>, io.reactivex.rxjava3.disposables.b, Runnable {
    private static final long serialVersionUID = 8646217640096099753L;
    public final int bufferSize;
    public final h<? super B, ? extends j<V>> closingIndicator;
    public final k<? super Observable<T>> downstream;
    public final AtomicBoolean downstreamDisposed;
    public long emitted;
    public final AtomicThrowable error;
    public final j<B> open;
    public volatile boolean openDone;
    public final e<Object> queue = new MpscLinkedQueue();
    public final AtomicLong requested;
    public final CompositeDisposable resources;
    public final WindowStartObserver<B> startObserver;
    public io.reactivex.rxjava3.disposables.b upstream;
    public volatile boolean upstreamCanceled;
    public volatile boolean upstreamDone;
    public final AtomicLong windowCount;
    public final List<UnicastSubject<T>> windows;

    public static final class WindowStartObserver<B> extends AtomicReference<io.reactivex.rxjava3.disposables.b> implements k<B> {
        private static final long serialVersionUID = -3326496781427702834L;
        public final ObservableWindowBoundarySelector$WindowBoundaryMainObserver<?, B, ?> parent;

        public WindowStartObserver(ObservableWindowBoundarySelector$WindowBoundaryMainObserver<?, B, ?> observableWindowBoundarySelector$WindowBoundaryMainObserver) {
            this.parent = observableWindowBoundarySelector$WindowBoundaryMainObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
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

        public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public static final class a<T, V> extends Observable<T> implements k<V>, io.reactivex.rxjava3.disposables.b {

        /* renamed from: b  reason: collision with root package name */
        public final ObservableWindowBoundarySelector$WindowBoundaryMainObserver<T, ?, V> f55561b;

        /* renamed from: c  reason: collision with root package name */
        public final UnicastSubject<T> f55562c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<io.reactivex.rxjava3.disposables.b> f55563d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f55564e = new AtomicBoolean();

        public a(ObservableWindowBoundarySelector$WindowBoundaryMainObserver<T, ?, V> observableWindowBoundarySelector$WindowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
            this.f55561b = observableWindowBoundarySelector$WindowBoundaryMainObserver;
            this.f55562c = unicastSubject;
        }

        public void b(k<? super T> kVar) {
            this.f55562c.subscribe(kVar);
            this.f55564e.set(true);
        }

        public boolean c() {
            return !this.f55564e.get() && this.f55564e.compareAndSet(false, true);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f55563d);
        }

        public boolean isDisposed() {
            return this.f55563d.get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f55561b.close(this);
        }

        public void onError(Throwable th2) {
            if (isDisposed()) {
                o00.a.n(th2);
            } else {
                this.f55561b.closeError(th2);
            }
        }

        public void onNext(V v11) {
            if (DisposableHelper.dispose(this.f55563d)) {
                this.f55561b.close(this);
            }
        }

        public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
            DisposableHelper.setOnce(this.f55563d, bVar);
        }
    }

    public static final class b<B> {

        /* renamed from: a  reason: collision with root package name */
        public final B f55565a;

        public b(B b11) {
            this.f55565a = b11;
        }
    }

    public ObservableWindowBoundarySelector$WindowBoundaryMainObserver(k<? super Observable<T>> kVar, j<B> jVar, h<? super B, ? extends j<V>> hVar, int i11) {
        this.downstream = kVar;
        this.open = jVar;
        this.closingIndicator = hVar;
        this.bufferSize = i11;
        this.resources = new CompositeDisposable();
        this.windows = new ArrayList();
        this.windowCount = new AtomicLong(1);
        this.downstreamDisposed = new AtomicBoolean();
        this.error = new AtomicThrowable();
        this.startObserver = new WindowStartObserver<>(this);
        this.requested = new AtomicLong();
    }

    public void close(a<T, V> aVar) {
        this.queue.offer(aVar);
        drain();
    }

    public void closeError(Throwable th2) {
        this.upstream.dispose();
        this.startObserver.dispose();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    public void dispose() {
        if (!this.downstreamDisposed.compareAndSet(false, true)) {
            return;
        }
        if (this.windowCount.decrementAndGet() == 0) {
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
            return;
        }
        this.startObserver.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            k<? super Observable<T>> kVar = this.downstream;
            e<Object> eVar = this.queue;
            List<UnicastSubject<T>> list = this.windows;
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
                        terminateDownstream(kVar);
                        this.upstreamCanceled = true;
                    } else if (!z12) {
                        if (poll instanceof b) {
                            if (!this.downstreamDisposed.get()) {
                                try {
                                    Object apply = this.closingIndicator.apply(((b) poll).f55565a);
                                    Objects.requireNonNull(apply, "The closingIndicator returned a null ObservableSource");
                                    j jVar = (j) apply;
                                    this.windowCount.getAndIncrement();
                                    UnicastSubject d11 = UnicastSubject.d(this.bufferSize, this);
                                    a aVar = new a(this, d11);
                                    kVar.onNext(aVar);
                                    if (aVar.c()) {
                                        d11.onComplete();
                                    } else {
                                        list.add(d11);
                                        this.resources.a(aVar);
                                        jVar.subscribe(aVar);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.rxjava3.exceptions.a.b(th2);
                                    this.upstream.dispose();
                                    this.startObserver.dispose();
                                    this.resources.dispose();
                                    io.reactivex.rxjava3.exceptions.a.b(th2);
                                    this.error.tryAddThrowableOrReport(th2);
                                    this.upstreamDone = true;
                                }
                            }
                        } else if (poll instanceof a) {
                            UnicastSubject<T> unicastSubject = ((a) poll).f55562c;
                            list.remove(unicastSubject);
                            this.resources.b((io.reactivex.rxjava3.disposables.b) poll);
                            unicastSubject.onComplete();
                        } else {
                            for (UnicastSubject<T> onNext : list) {
                                onNext.onNext(poll);
                            }
                        }
                    } else if (this.openDone && list.size() == 0) {
                        this.upstream.dispose();
                        this.startObserver.dispose();
                        this.resources.dispose();
                        terminateDownstream(kVar);
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

    public boolean isDisposed() {
        return this.downstreamDisposed.get();
    }

    public void onComplete() {
        this.startObserver.dispose();
        this.resources.dispose();
        this.upstreamDone = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.startObserver.dispose();
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

    public void onSubscribe(io.reactivex.rxjava3.disposables.b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
            this.open.subscribe(this.startObserver);
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
        this.upstream.dispose();
        this.resources.dispose();
        if (this.error.tryAddThrowableOrReport(th2)) {
            this.upstreamDone = true;
            drain();
        }
    }

    public void run() {
        if (this.windowCount.decrementAndGet() == 0) {
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            this.error.tryTerminateAndReport();
            this.upstreamCanceled = true;
            drain();
        }
    }

    public void terminateDownstream(k<?> kVar) {
        Throwable terminate = this.error.terminate();
        if (terminate == null) {
            for (UnicastSubject<T> onComplete : this.windows) {
                onComplete.onComplete();
            }
            kVar.onComplete();
        } else if (terminate != ExceptionHelper.f55703a) {
            for (UnicastSubject<T> onError : this.windows) {
                onError.onError(terminate);
            }
            kVar.onError(terminate);
        }
    }
}
