package io.reactivex.rxjava3.internal.operators.parallel;

import h00.e;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import k00.f;
import z20.c;
import z20.d;

final class ParallelFromPublisher$ParallelDispatcher<T> extends AtomicInteger implements e<T> {
    private static final long serialVersionUID = -4470634016609963609L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final long[] emissions;
    public Throwable error;
    public int index;
    public final int limit;
    public final int prefetch;
    public int produced;
    public f<T> queue;
    public final AtomicLongArray requests;
    public int sourceMode;
    public final AtomicInteger subscriberCount = new AtomicInteger();
    public final c<? super T>[] subscribers;
    public d upstream;

    public final class a implements d {

        /* renamed from: b  reason: collision with root package name */
        public final int f55596b;

        /* renamed from: c  reason: collision with root package name */
        public final int f55597c;

        public a(int i11, int i12) {
            this.f55596b = i11;
            this.f55597c = i12;
        }

        public void cancel() {
            if (ParallelFromPublisher$ParallelDispatcher.this.requests.compareAndSet(this.f55596b + this.f55597c, 0, 1)) {
                ParallelFromPublisher$ParallelDispatcher parallelFromPublisher$ParallelDispatcher = ParallelFromPublisher$ParallelDispatcher.this;
                int i11 = this.f55597c;
                parallelFromPublisher$ParallelDispatcher.cancel(i11 + i11);
            }
        }

        public void request(long j11) {
            long j12;
            if (SubscriptionHelper.validate(j11)) {
                AtomicLongArray atomicLongArray = ParallelFromPublisher$ParallelDispatcher.this.requests;
                do {
                    j12 = atomicLongArray.get(this.f55596b);
                    if (j12 != Long.MAX_VALUE) {
                    } else {
                        return;
                    }
                } while (!atomicLongArray.compareAndSet(this.f55596b, j12, b.c(j12, j11)));
                if (ParallelFromPublisher$ParallelDispatcher.this.subscriberCount.get() == this.f55597c) {
                    ParallelFromPublisher$ParallelDispatcher.this.drain();
                }
            }
        }
    }

    public ParallelFromPublisher$ParallelDispatcher(c<? super T>[] cVarArr, int i11) {
        this.subscribers = cVarArr;
        this.prefetch = i11;
        this.limit = i11 - (i11 >> 2);
        int length = cVarArr.length;
        int i12 = length + length;
        AtomicLongArray atomicLongArray = new AtomicLongArray(i12 + 1);
        this.requests = atomicLongArray;
        atomicLongArray.lazySet(i12, (long) length);
        this.emissions = new long[length];
    }

    public void cancel(int i11) {
        if (this.requests.decrementAndGet(i11) == 0) {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            if (this.sourceMode == 1) {
                drainSync();
            } else {
                drainAsync();
            }
        }
    }

    public void drainAsync() {
        Throwable th2;
        f<T> fVar = this.queue;
        c<? super T>[] cVarArr = this.subscribers;
        AtomicLongArray atomicLongArray = this.requests;
        long[] jArr = this.emissions;
        int length = jArr.length;
        int i11 = this.index;
        int i12 = this.produced;
        int i13 = 1;
        while (true) {
            int i14 = 0;
            int i15 = 0;
            while (!this.cancelled) {
                boolean z11 = this.done;
                if (!z11 || (th2 = this.error) == null) {
                    boolean isEmpty = fVar.isEmpty();
                    if (!z11 || !isEmpty) {
                        if (!isEmpty) {
                            long j11 = atomicLongArray.get(i11);
                            long j12 = jArr[i11];
                            if (j11 == j12 || atomicLongArray.get(length + i11) != 0) {
                                i15++;
                            } else {
                                try {
                                    T poll = fVar.poll();
                                    if (poll != null) {
                                        cVarArr[i11].onNext(poll);
                                        jArr[i11] = j12 + 1;
                                        i12++;
                                        if (i12 == this.limit) {
                                            this.upstream.request((long) i12);
                                            i12 = 0;
                                        }
                                        i15 = 0;
                                    }
                                } catch (Throwable th3) {
                                    Throwable th4 = th3;
                                    io.reactivex.rxjava3.exceptions.a.b(th4);
                                    this.upstream.cancel();
                                    int length2 = cVarArr.length;
                                    while (i14 < length2) {
                                        cVarArr[i14].onError(th4);
                                        i14++;
                                    }
                                    return;
                                }
                            }
                            i11++;
                            if (i11 == length) {
                                i11 = 0;
                                continue;
                            }
                            if (i15 == length) {
                            }
                        }
                        int i16 = get();
                        if (i16 == i13) {
                            this.index = i11;
                            this.produced = i12;
                            i13 = addAndGet(-i13);
                            if (i13 == 0) {
                                return;
                            }
                        } else {
                            i13 = i16;
                        }
                    } else {
                        int length3 = cVarArr.length;
                        while (i14 < length3) {
                            cVarArr[i14].onComplete();
                            i14++;
                        }
                        return;
                    }
                } else {
                    fVar.clear();
                    int length4 = cVarArr.length;
                    while (i14 < length4) {
                        cVarArr[i14].onError(th2);
                        i14++;
                    }
                    return;
                }
            }
            fVar.clear();
            return;
        }
    }

    public void drainSync() {
        f<T> fVar = this.queue;
        c<? super T>[] cVarArr = this.subscribers;
        AtomicLongArray atomicLongArray = this.requests;
        long[] jArr = this.emissions;
        int length = jArr.length;
        int i11 = this.index;
        int i12 = 1;
        while (true) {
            int i13 = 0;
            int i14 = 0;
            while (!this.cancelled) {
                if (fVar.isEmpty()) {
                    int length2 = cVarArr.length;
                    while (i13 < length2) {
                        cVarArr[i13].onComplete();
                        i13++;
                    }
                    return;
                }
                long j11 = atomicLongArray.get(i11);
                long j12 = jArr[i11];
                if (j11 == j12 || atomicLongArray.get(length + i11) != 0) {
                    i14++;
                } else {
                    try {
                        T poll = fVar.poll();
                        if (poll == null) {
                            int length3 = cVarArr.length;
                            while (i13 < length3) {
                                cVarArr[i13].onComplete();
                                i13++;
                            }
                            return;
                        }
                        cVarArr[i11].onNext(poll);
                        jArr[i11] = j12 + 1;
                        i14 = 0;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        io.reactivex.rxjava3.exceptions.a.b(th3);
                        this.upstream.cancel();
                        int length4 = cVarArr.length;
                        while (i13 < length4) {
                            cVarArr[i13].onError(th3);
                            i13++;
                        }
                        return;
                    }
                }
                i11++;
                if (i11 == length) {
                    i11 = 0;
                    continue;
                }
                if (i14 == length) {
                    int i15 = get();
                    if (i15 == i12) {
                        this.index = i11;
                        i12 = addAndGet(-i12);
                        if (i12 == 0) {
                            return;
                        }
                    } else {
                        i12 = i15;
                    }
                }
            }
            fVar.clear();
            return;
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        if (this.sourceMode != 0 || this.queue.offer(t11)) {
            drain();
            return;
        }
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue is full?"));
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    setupSubscribers();
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    setupSubscribers();
                    dVar.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            setupSubscribers();
            dVar.request((long) this.prefetch);
        }
    }

    public void setupSubscribers() {
        c<? super T>[] cVarArr = this.subscribers;
        int length = cVarArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            this.subscriberCount.lazySet(i12);
            cVarArr[i11].onSubscribe(new a(i11, length));
            i11 = i12;
        }
    }
}
