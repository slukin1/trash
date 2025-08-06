package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;
import z20.d;

final class FlowableReplay$ReplaySubscriber<T> extends AtomicReference<d> implements e<T>, b {
    public static final FlowableReplay$InnerSubscription[] EMPTY = new FlowableReplay$InnerSubscription[0];
    public static final FlowableReplay$InnerSubscription[] TERMINATED = new FlowableReplay$InnerSubscription[0];
    private static final long serialVersionUID = 7224554242710036740L;
    public final k<T> buffer;
    public final AtomicReference<FlowableReplay$ReplaySubscriber<T>> current;
    public boolean done;
    public final AtomicInteger management = new AtomicInteger();
    public long requestedFromUpstream;
    public final AtomicBoolean shouldConnect = new AtomicBoolean();
    public final AtomicReference<FlowableReplay$InnerSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

    public FlowableReplay$ReplaySubscriber(k<T> kVar, AtomicReference<FlowableReplay$ReplaySubscriber<T>> atomicReference) {
        this.buffer = kVar;
        this.current = atomicReference;
    }

    public boolean add(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription) {
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr2;
        do {
            flowableReplay$InnerSubscriptionArr = (FlowableReplay$InnerSubscription[]) this.subscribers.get();
            if (flowableReplay$InnerSubscriptionArr == TERMINATED) {
                return false;
            }
            int length = flowableReplay$InnerSubscriptionArr.length;
            flowableReplay$InnerSubscriptionArr2 = new FlowableReplay$InnerSubscription[(length + 1)];
            System.arraycopy(flowableReplay$InnerSubscriptionArr, 0, flowableReplay$InnerSubscriptionArr2, 0, length);
            flowableReplay$InnerSubscriptionArr2[length] = flowableReplay$InnerSubscription;
        } while (!this.subscribers.compareAndSet(flowableReplay$InnerSubscriptionArr, flowableReplay$InnerSubscriptionArr2));
        return true;
    }

    public void dispose() {
        this.subscribers.set(TERMINATED);
        this.current.compareAndSet(this, (Object) null);
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return this.subscribers.get() == TERMINATED;
    }

    public void manageRequests() {
        AtomicInteger atomicInteger = this.management;
        if (atomicInteger.getAndIncrement() == 0) {
            int i11 = 1;
            while (!isDisposed()) {
                d dVar = (d) get();
                if (dVar != null) {
                    long j11 = this.requestedFromUpstream;
                    long j12 = j11;
                    for (FlowableReplay$InnerSubscription flowableReplay$InnerSubscription : (FlowableReplay$InnerSubscription[]) this.subscribers.get()) {
                        j12 = Math.max(j12, flowableReplay$InnerSubscription.totalRequested.get());
                    }
                    long j13 = j12 - j11;
                    if (j13 != 0) {
                        this.requestedFromUpstream = j12;
                        dVar.request(j13);
                    }
                }
                i11 = atomicInteger.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.buffer.complete();
            for (FlowableReplay$InnerSubscription replay : (FlowableReplay$InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(replay);
            }
        }
    }

    public void onError(Throwable th2) {
        if (!this.done) {
            this.done = true;
            this.buffer.error(th2);
            for (FlowableReplay$InnerSubscription replay : (FlowableReplay$InnerSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                this.buffer.replay(replay);
            }
            return;
        }
        a.n(th2);
    }

    public void onNext(T t11) {
        if (!this.done) {
            this.buffer.next(t11);
            for (FlowableReplay$InnerSubscription replay : (FlowableReplay$InnerSubscription[]) this.subscribers.get()) {
                this.buffer.replay(replay);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            manageRequests();
            for (FlowableReplay$InnerSubscription replay : (FlowableReplay$InnerSubscription[]) this.subscribers.get()) {
                this.buffer.replay(replay);
            }
        }
    }

    public void remove(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription) {
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr2;
        do {
            flowableReplay$InnerSubscriptionArr = (FlowableReplay$InnerSubscription[]) this.subscribers.get();
            int length = flowableReplay$InnerSubscriptionArr.length;
            if (length != 0) {
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (flowableReplay$InnerSubscriptionArr[i12].equals(flowableReplay$InnerSubscription)) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        flowableReplay$InnerSubscriptionArr2 = EMPTY;
                    } else {
                        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArr3 = new FlowableReplay$InnerSubscription[(length - 1)];
                        System.arraycopy(flowableReplay$InnerSubscriptionArr, 0, flowableReplay$InnerSubscriptionArr3, 0, i11);
                        System.arraycopy(flowableReplay$InnerSubscriptionArr, i11 + 1, flowableReplay$InnerSubscriptionArr3, i11, (length - i11) - 1);
                        flowableReplay$InnerSubscriptionArr2 = flowableReplay$InnerSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(flowableReplay$InnerSubscriptionArr, flowableReplay$InnerSubscriptionArr2));
    }
}
