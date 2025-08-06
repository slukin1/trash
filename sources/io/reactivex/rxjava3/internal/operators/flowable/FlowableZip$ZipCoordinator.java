package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.b;
import j00.h;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import k00.f;
import z20.c;
import z20.d;

final class FlowableZip$ZipCoordinator<T, R> extends AtomicInteger implements d {
    private static final long serialVersionUID = -2434867452883857743L;
    public volatile boolean cancelled;
    public final Object[] current;
    public final boolean delayErrors;
    public final c<? super R> downstream;
    public final AtomicThrowable errors;
    public final AtomicLong requested;
    public final FlowableZip$ZipSubscriber<T, R>[] subscribers;
    public final h<? super Object[], ? extends R> zipper;

    public FlowableZip$ZipCoordinator(c<? super R> cVar, h<? super Object[], ? extends R> hVar, int i11, int i12, boolean z11) {
        this.downstream = cVar;
        this.zipper = hVar;
        this.delayErrors = z11;
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = new FlowableZip$ZipSubscriber[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            flowableZip$ZipSubscriberArr[i13] = new FlowableZip$ZipSubscriber<>(this, i12);
        }
        this.current = new Object[i11];
        this.subscribers = flowableZip$ZipSubscriberArr;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelAll();
        }
    }

    public void cancelAll() {
        for (FlowableZip$ZipSubscriber<T, R> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public void drain() {
        int i11;
        T t11;
        T t12;
        if (getAndIncrement() == 0) {
            c<? super R> cVar = this.downstream;
            FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
            int length = flowableZip$ZipSubscriberArr.length;
            Object[] objArr = this.current;
            int i12 = 1;
            do {
                long j11 = this.requested.get();
                long j12 = 0;
                while (true) {
                    i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    } else if (!this.cancelled) {
                        if (this.delayErrors || this.errors.get() == null) {
                            boolean z11 = false;
                            for (int i13 = 0; i13 < length; i13++) {
                                FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber = flowableZip$ZipSubscriberArr[i13];
                                if (objArr[i13] == null) {
                                    boolean z12 = flowableZip$ZipSubscriber.done;
                                    f<T> fVar = flowableZip$ZipSubscriber.queue;
                                    if (fVar != null) {
                                        try {
                                            t12 = fVar.poll();
                                        } catch (Throwable th2) {
                                            Throwable th3 = th2;
                                            a.b(th3);
                                            this.errors.tryAddThrowableOrReport(th3);
                                            if (!this.delayErrors) {
                                                cancelAll();
                                                this.errors.tryTerminateConsumer((c<?>) cVar);
                                                return;
                                            }
                                            t12 = null;
                                            z12 = true;
                                        }
                                    } else {
                                        t12 = null;
                                    }
                                    boolean z13 = t12 == null;
                                    if (z12 && z13) {
                                        cancelAll();
                                        this.errors.tryTerminateConsumer((c<?>) cVar);
                                        return;
                                    } else if (!z13) {
                                        objArr[i13] = t12;
                                    } else {
                                        z11 = true;
                                    }
                                }
                            }
                            if (z11) {
                                break;
                            }
                            try {
                                Object apply = this.zipper.apply(objArr.clone());
                                Objects.requireNonNull(apply, "The zipper returned a null value");
                                cVar.onNext(apply);
                                j12++;
                                Arrays.fill(objArr, (Object) null);
                            } catch (Throwable th4) {
                                a.b(th4);
                                cancelAll();
                                this.errors.tryAddThrowableOrReport(th4);
                                this.errors.tryTerminateConsumer((c<?>) cVar);
                                return;
                            }
                        } else {
                            cancelAll();
                            this.errors.tryTerminateConsumer((c<?>) cVar);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (i11 == 0) {
                    if (!this.cancelled) {
                        if (this.delayErrors || this.errors.get() == null) {
                            for (int i14 = 0; i14 < length; i14++) {
                                FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber2 = flowableZip$ZipSubscriberArr[i14];
                                if (objArr[i14] == null) {
                                    boolean z14 = flowableZip$ZipSubscriber2.done;
                                    f<T> fVar2 = flowableZip$ZipSubscriber2.queue;
                                    if (fVar2 != null) {
                                        try {
                                            t11 = fVar2.poll();
                                        } catch (Throwable th5) {
                                            Throwable th6 = th5;
                                            a.b(th6);
                                            this.errors.tryAddThrowableOrReport(th6);
                                            if (!this.delayErrors) {
                                                cancelAll();
                                                this.errors.tryTerminateConsumer((c<?>) cVar);
                                                return;
                                            }
                                            t11 = null;
                                            z14 = true;
                                        }
                                    } else {
                                        t11 = null;
                                    }
                                    boolean z15 = t11 == null;
                                    if (z14 && z15) {
                                        cancelAll();
                                        this.errors.tryTerminateConsumer((c<?>) cVar);
                                        return;
                                    } else if (!z15) {
                                        objArr[i14] = t11;
                                    }
                                }
                            }
                        } else {
                            cancelAll();
                            this.errors.tryTerminateConsumer((c<?>) cVar);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j12 != 0) {
                    for (FlowableZip$ZipSubscriber<T, R> request : flowableZip$ZipSubscriberArr) {
                        request.request(j12);
                    }
                    if (j11 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j12);
                    }
                }
                i12 = addAndGet(-i12);
            } while (i12 != 0);
        }
    }

    public void error(FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber, Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            flowableZip$ZipSubscriber.done = true;
            drain();
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            drain();
        }
    }

    public void subscribe(z20.b<? extends T>[] bVarArr, int i11) {
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
        int i12 = 0;
        while (i12 < i11 && !this.cancelled) {
            if (this.delayErrors || this.errors.get() == null) {
                bVarArr[i12].subscribe(flowableZip$ZipSubscriberArr[i12]);
                i12++;
            } else {
                return;
            }
        }
    }
}
