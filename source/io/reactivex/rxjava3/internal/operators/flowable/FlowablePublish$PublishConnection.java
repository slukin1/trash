package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import k00.f;
import z20.d;

final class FlowablePublish$PublishConnection<T> extends AtomicInteger implements e<T>, b {
    public static final FlowablePublish$InnerSubscription[] EMPTY = new FlowablePublish$InnerSubscription[0];
    public static final FlowablePublish$InnerSubscription[] TERMINATED = new FlowablePublish$InnerSubscription[0];
    private static final long serialVersionUID = -1672047311619175801L;
    public final int bufferSize;
    public final AtomicBoolean connect = new AtomicBoolean();
    public int consumed;
    public final AtomicReference<FlowablePublish$PublishConnection<T>> current;
    public volatile boolean done;
    public Throwable error;
    public volatile f<T> queue;
    public int sourceMode;
    public final AtomicReference<FlowablePublish$InnerSubscription<T>[]> subscribers;
    public final AtomicReference<d> upstream = new AtomicReference<>();

    public FlowablePublish$PublishConnection(AtomicReference<FlowablePublish$PublishConnection<T>> atomicReference, int i11) {
        this.current = atomicReference;
        this.bufferSize = i11;
        this.subscribers = new AtomicReference<>(EMPTY);
    }

    public boolean add(FlowablePublish$InnerSubscription<T> flowablePublish$InnerSubscription) {
        FlowablePublish$InnerSubscription[] flowablePublish$InnerSubscriptionArr;
        FlowablePublish$InnerSubscription[] flowablePublish$InnerSubscriptionArr2;
        do {
            flowablePublish$InnerSubscriptionArr = (FlowablePublish$InnerSubscription[]) this.subscribers.get();
            if (flowablePublish$InnerSubscriptionArr == TERMINATED) {
                return false;
            }
            int length = flowablePublish$InnerSubscriptionArr.length;
            flowablePublish$InnerSubscriptionArr2 = new FlowablePublish$InnerSubscription[(length + 1)];
            System.arraycopy(flowablePublish$InnerSubscriptionArr, 0, flowablePublish$InnerSubscriptionArr2, 0, length);
            flowablePublish$InnerSubscriptionArr2[length] = flowablePublish$InnerSubscription;
        } while (!this.subscribers.compareAndSet(flowablePublish$InnerSubscriptionArr, flowablePublish$InnerSubscriptionArr2));
        return true;
    }

    public boolean checkTerminated(boolean z11, boolean z12) {
        if (!z11 || !z12) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            signalError(th2);
            return true;
        }
        for (FlowablePublish$InnerSubscription flowablePublish$InnerSubscription : (FlowablePublish$InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
            if (!flowablePublish$InnerSubscription.isCancelled()) {
                flowablePublish$InnerSubscription.downstream.onComplete();
            }
        }
        return true;
    }

    public void dispose() {
        this.subscribers.getAndSet(TERMINATED);
        this.current.compareAndSet(this, (Object) null);
        SubscriptionHelper.cancel(this.upstream);
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            f<T> fVar = this.queue;
            int i11 = this.consumed;
            int i12 = this.bufferSize;
            int i13 = i12 - (i12 >> 2);
            boolean z11 = this.sourceMode != 1;
            int i14 = 1;
            int i15 = i11;
            f<T> fVar2 = fVar;
            int i16 = i15;
            while (true) {
                if (fVar2 != null) {
                    long j11 = Long.MAX_VALUE;
                    FlowablePublish$InnerSubscription<T>[] flowablePublish$InnerSubscriptionArr = (FlowablePublish$InnerSubscription[]) this.subscribers.get();
                    boolean z12 = false;
                    for (FlowablePublish$InnerSubscription<T> flowablePublish$InnerSubscription : flowablePublish$InnerSubscriptionArr) {
                        long j12 = flowablePublish$InnerSubscription.get();
                        if (j12 != Long.MIN_VALUE) {
                            j11 = Math.min(j12 - flowablePublish$InnerSubscription.emitted, j11);
                            z12 = true;
                        }
                    }
                    long j13 = 0;
                    if (!z12) {
                        j11 = 0;
                    }
                    while (true) {
                        if (j11 == j13) {
                            break;
                        }
                        boolean z13 = this.done;
                        try {
                            T poll = fVar2.poll();
                            boolean z14 = poll == null;
                            if (!checkTerminated(z13, z14)) {
                                if (z14) {
                                    break;
                                }
                                for (FlowablePublish$InnerSubscription<T> flowablePublish$InnerSubscription2 : flowablePublish$InnerSubscriptionArr) {
                                    if (!flowablePublish$InnerSubscription2.isCancelled()) {
                                        flowablePublish$InnerSubscription2.downstream.onNext(poll);
                                        flowablePublish$InnerSubscription2.emitted++;
                                    }
                                }
                                if (z11 && (i16 = i16 + 1) == i13) {
                                    this.upstream.get().request((long) i13);
                                    i16 = 0;
                                }
                                j11--;
                                if (flowablePublish$InnerSubscriptionArr != this.subscribers.get()) {
                                    break;
                                }
                                j13 = 0;
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            a.b(th3);
                            this.upstream.get().cancel();
                            fVar2.clear();
                            this.done = true;
                            signalError(th3);
                            return;
                        }
                    }
                    if (checkTerminated(this.done, fVar2.isEmpty())) {
                        return;
                    }
                }
                this.consumed = i16;
                i14 = addAndGet(-i14);
                if (i14 != 0) {
                    if (fVar2 == null) {
                        fVar2 = this.queue;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.subscribers.get() == TERMINATED;
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.done) {
            o00.a.n(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t11) {
        if (this.sourceMode != 0 || this.queue.offer(t11)) {
            drain();
        } else {
            onError(new MissingBackpressureException("Prefetch queue is full?!"));
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this.upstream, dVar)) {
            if (dVar instanceof k00.d) {
                k00.d dVar2 = (k00.d) dVar;
                int requestFusion = dVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    this.done = true;
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = dVar2;
                    dVar.request((long) this.bufferSize);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.bufferSize);
            dVar.request((long) this.bufferSize);
        }
    }

    public void remove(FlowablePublish$InnerSubscription<T> flowablePublish$InnerSubscription) {
        FlowablePublish$InnerSubscription<T>[] flowablePublish$InnerSubscriptionArr;
        FlowablePublish$InnerSubscription[] flowablePublish$InnerSubscriptionArr2;
        do {
            flowablePublish$InnerSubscriptionArr = (FlowablePublish$InnerSubscription[]) this.subscribers.get();
            int length = flowablePublish$InnerSubscriptionArr.length;
            if (length != 0) {
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (flowablePublish$InnerSubscriptionArr[i12] == flowablePublish$InnerSubscription) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        flowablePublish$InnerSubscriptionArr2 = EMPTY;
                    } else {
                        FlowablePublish$InnerSubscription[] flowablePublish$InnerSubscriptionArr3 = new FlowablePublish$InnerSubscription[(length - 1)];
                        System.arraycopy(flowablePublish$InnerSubscriptionArr, 0, flowablePublish$InnerSubscriptionArr3, 0, i11);
                        System.arraycopy(flowablePublish$InnerSubscriptionArr, i11 + 1, flowablePublish$InnerSubscriptionArr3, i11, (length - i11) - 1);
                        flowablePublish$InnerSubscriptionArr2 = flowablePublish$InnerSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(flowablePublish$InnerSubscriptionArr, flowablePublish$InnerSubscriptionArr2));
    }

    public void signalError(Throwable th2) {
        for (FlowablePublish$InnerSubscription flowablePublish$InnerSubscription : (FlowablePublish$InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
            if (!flowablePublish$InnerSubscription.isCancelled()) {
                flowablePublish$InnerSubscription.downstream.onError(th2);
            }
        }
    }
}
