package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import k00.f;
import o00.a;
import z20.c;
import z20.d;

public final class FlowableObserveOn<T> extends a<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f55485d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f55486e;

    /* renamed from: f  reason: collision with root package name */
    public final int f55487f;

    public static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements e<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public boolean outputFused;
        public final int prefetch;
        public long produced;
        public f<T> queue;
        public final AtomicLong requested = new AtomicLong();
        public int sourceMode;
        public d upstream;
        public final Scheduler.Worker worker;

        public BaseObserveOnSubscriber(Scheduler.Worker worker2, boolean z11, int i11) {
            this.worker = worker2;
            this.delayError = z11;
            this.prefetch = i11;
            this.limit = i11 - (i11 >> 2);
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                this.worker.dispose();
                if (!this.outputFused && getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public final boolean checkTerminated(boolean z11, boolean z12, c<?> cVar) {
            if (this.cancelled) {
                clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!this.delayError) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.cancelled = true;
                        clear();
                        cVar.onError(th2);
                        this.worker.dispose();
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        this.cancelled = true;
                        cVar.onComplete();
                        this.worker.dispose();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    this.cancelled = true;
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        cVar.onError(th3);
                    } else {
                        cVar.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                }
            }
        }

        public final void clear() {
            this.queue.clear();
        }

        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                trySchedule();
            }
        }

        public final void onError(Throwable th2) {
            if (this.done) {
                a.n(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            trySchedule();
        }

        public final void onNext(T t11) {
            if (!this.done) {
                if (this.sourceMode == 2) {
                    trySchedule();
                    return;
                }
                if (!this.queue.offer(t11)) {
                    this.upstream.cancel();
                    this.error = new MissingBackpressureException("Queue is full?!");
                    this.done = true;
                }
                trySchedule();
            }
        }

        public abstract /* synthetic */ void onSubscribe(d dVar);

        public abstract /* synthetic */ T poll() throws Throwable;

        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                b.a(this.requested, j11);
                trySchedule();
            }
        }

        public final int requestFusion(int i11) {
            if ((i11 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public final void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        public abstract void runAsync();

        public abstract void runBackfused();

        public abstract void runSync();

        public final void trySchedule() {
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }
    }

    public static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        public long consumed;
        public final k00.a<? super T> downstream;

        public ObserveOnConditionalSubscriber(k00.a<? super T> aVar, Scheduler.Worker worker, boolean z11, int i11) {
            super(worker, z11, i11);
            this.downstream = aVar;
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof k00.d) {
                    k00.d dVar2 = (k00.d) dVar;
                    int requestFusion = dVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = dVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = dVar2;
                        this.downstream.onSubscribe(this);
                        dVar.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                dVar.request((long) this.prefetch);
            }
        }

        public T poll() throws Throwable {
            T poll = this.queue.poll();
            if (!(poll == null || this.sourceMode == 1)) {
                long j11 = this.consumed + 1;
                if (j11 == ((long) this.limit)) {
                    this.consumed = 0;
                    this.upstream.request(j11);
                } else {
                    this.consumed = j11;
                }
            }
            return poll;
        }

        public void runAsync() {
            int i11;
            k00.a<? super T> aVar = this.downstream;
            f<T> fVar = this.queue;
            long j11 = this.produced;
            long j12 = this.consumed;
            int i12 = 1;
            do {
                long j13 = this.requested.get();
                while (true) {
                    i11 = (j11 > j13 ? 1 : (j11 == j13 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z11 = this.done;
                    try {
                        T poll = fVar.poll();
                        boolean z12 = poll == null;
                        if (!checkTerminated(z11, z12, aVar)) {
                            if (z12) {
                                break;
                            }
                            if (aVar.tryOnNext(poll)) {
                                j11++;
                            }
                            j12++;
                            if (j12 == ((long) this.limit)) {
                                this.upstream.request(j12);
                                j12 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.rxjava3.exceptions.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        fVar.clear();
                        aVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (i11 != 0 || !checkTerminated(this.done, fVar.isEmpty(), aVar)) {
                    this.produced = j11;
                    this.consumed = j12;
                    i12 = addAndGet(-i12);
                } else {
                    return;
                }
            } while (i12 != 0);
        }

        public void runBackfused() {
            int i11 = 1;
            while (!this.cancelled) {
                boolean z11 = this.done;
                this.downstream.onNext(null);
                if (z11) {
                    this.cancelled = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }

        public void runSync() {
            k00.a<? super T> aVar = this.downstream;
            f<T> fVar = this.queue;
            long j11 = this.produced;
            int i11 = 1;
            do {
                long j12 = this.requested.get();
                while (j11 != j12) {
                    try {
                        T poll = fVar.poll();
                        if (!this.cancelled) {
                            if (poll == null) {
                                this.cancelled = true;
                                aVar.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (aVar.tryOnNext(poll)) {
                                j11++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.rxjava3.exceptions.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        aVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (fVar.isEmpty()) {
                        this.cancelled = true;
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    this.produced = j11;
                    i11 = addAndGet(-i11);
                } else {
                    return;
                }
            } while (i11 != 0);
        }
    }

    public static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        public final c<? super T> downstream;

        public ObserveOnSubscriber(c<? super T> cVar, Scheduler.Worker worker, boolean z11, int i11) {
            super(worker, z11, i11);
            this.downstream = cVar;
        }

        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                if (dVar instanceof k00.d) {
                    k00.d dVar2 = (k00.d) dVar;
                    int requestFusion = dVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = dVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = dVar2;
                        this.downstream.onSubscribe(this);
                        dVar.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                dVar.request((long) this.prefetch);
            }
        }

        public T poll() throws Throwable {
            T poll = this.queue.poll();
            if (!(poll == null || this.sourceMode == 1)) {
                long j11 = this.produced + 1;
                if (j11 == ((long) this.limit)) {
                    this.produced = 0;
                    this.upstream.request(j11);
                } else {
                    this.produced = j11;
                }
            }
            return poll;
        }

        public void runAsync() {
            int i11;
            c<? super T> cVar = this.downstream;
            f<T> fVar = this.queue;
            long j11 = this.produced;
            int i12 = 1;
            while (true) {
                long j12 = this.requested.get();
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z11 = this.done;
                    try {
                        T poll = fVar.poll();
                        boolean z12 = poll == null;
                        if (!checkTerminated(z11, z12, cVar)) {
                            if (z12) {
                                break;
                            }
                            cVar.onNext(poll);
                            j11++;
                            if (j11 == ((long) this.limit)) {
                                if (j12 != Long.MAX_VALUE) {
                                    j12 = this.requested.addAndGet(-j11);
                                }
                                this.upstream.request(j11);
                                j11 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.rxjava3.exceptions.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        fVar.clear();
                        cVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (i11 != 0 || !checkTerminated(this.done, fVar.isEmpty(), cVar)) {
                    int i13 = get();
                    if (i12 == i13) {
                        this.produced = j11;
                        i12 = addAndGet(-i12);
                        if (i12 == 0) {
                            return;
                        }
                    } else {
                        i12 = i13;
                    }
                } else {
                    return;
                }
            }
        }

        public void runBackfused() {
            int i11 = 1;
            while (!this.cancelled) {
                boolean z11 = this.done;
                this.downstream.onNext(null);
                if (z11) {
                    this.cancelled = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }

        public void runSync() {
            c<? super T> cVar = this.downstream;
            f<T> fVar = this.queue;
            long j11 = this.produced;
            int i11 = 1;
            do {
                long j12 = this.requested.get();
                while (j11 != j12) {
                    try {
                        T poll = fVar.poll();
                        if (!this.cancelled) {
                            if (poll == null) {
                                this.cancelled = true;
                                cVar.onComplete();
                                this.worker.dispose();
                                return;
                            }
                            cVar.onNext(poll);
                            j11++;
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.rxjava3.exceptions.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        cVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (fVar.isEmpty()) {
                        this.cancelled = true;
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    this.produced = j11;
                    i11 = addAndGet(-i11);
                } else {
                    return;
                }
            } while (i11 != 0);
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z11, int i11) {
        super(flowable);
        this.f55485d = scheduler;
        this.f55486e = z11;
        this.f55487f = i11;
    }

    public void j(c<? super T> cVar) {
        Scheduler.Worker a11 = this.f55485d.a();
        if (cVar instanceof k00.a) {
            this.f55511c.i(new ObserveOnConditionalSubscriber((k00.a) cVar, a11, this.f55486e, this.f55487f));
        } else {
            this.f55511c.i(new ObserveOnSubscriber(cVar, a11, this.f55486e, this.f55487f));
        }
    }
}
