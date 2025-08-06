package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class ParallelSortedJoin$SortedJoinSubscription<T> extends AtomicInteger implements d {
    private static final long serialVersionUID = 3481980673745556697L;
    public volatile boolean cancelled;
    public final Comparator<? super T> comparator;
    public final c<? super T> downstream;
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final int[] indexes;
    public final List<T>[] lists;
    public final AtomicInteger remaining = new AtomicInteger();
    public final AtomicLong requested = new AtomicLong();
    public final ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] subscribers;

    public ParallelSortedJoin$SortedJoinSubscription(c<? super T> cVar, int i11, Comparator<? super T> comparator2) {
        this.downstream = cVar;
        this.comparator = comparator2;
        ParallelSortedJoin$SortedJoinInnerSubscriber<T>[] parallelSortedJoin$SortedJoinInnerSubscriberArr = new ParallelSortedJoin$SortedJoinInnerSubscriber[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            parallelSortedJoin$SortedJoinInnerSubscriberArr[i12] = new ParallelSortedJoin$SortedJoinInnerSubscriber<>(this, i12);
        }
        this.subscribers = parallelSortedJoin$SortedJoinInnerSubscriberArr;
        this.lists = new List[i11];
        this.indexes = new int[i11];
        this.remaining.lazySet(i11);
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.lists, (Object) null);
            }
        }
    }

    public void cancelAll() {
        for (ParallelSortedJoin$SortedJoinInnerSubscriber<T> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public void drain() {
        boolean z11;
        if (getAndIncrement() == 0) {
            c<? super T> cVar = this.downstream;
            List<T>[] listArr = this.lists;
            int[] iArr = this.indexes;
            int length = iArr.length;
            int i11 = 1;
            do {
                long j11 = this.requested.get();
                long j12 = 0;
                while (j12 != j11) {
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th2 = this.error.get();
                    if (th2 != null) {
                        cancelAll();
                        Arrays.fill(listArr, (Object) null);
                        cVar.onError(th2);
                        return;
                    }
                    int i12 = -1;
                    T t11 = null;
                    for (int i13 = 0; i13 < length; i13++) {
                        List<T> list = listArr[i13];
                        int i14 = iArr[i13];
                        if (list.size() != i14) {
                            if (t11 == null) {
                                t11 = list.get(i14);
                            } else {
                                T t12 = list.get(i14);
                                try {
                                    if (this.comparator.compare(t11, t12) > 0) {
                                        t11 = t12;
                                    }
                                } catch (Throwable th3) {
                                    a.b(th3);
                                    cancelAll();
                                    Arrays.fill(listArr, (Object) null);
                                    if (!this.error.compareAndSet((Object) null, th3)) {
                                        o00.a.n(th3);
                                    }
                                    cVar.onError(this.error.get());
                                    return;
                                }
                            }
                            i12 = i13;
                        }
                    }
                    if (t11 == null) {
                        Arrays.fill(listArr, (Object) null);
                        cVar.onComplete();
                        return;
                    }
                    cVar.onNext(t11);
                    iArr[i12] = iArr[i12] + 1;
                    j12++;
                }
                if (this.cancelled) {
                    Arrays.fill(listArr, (Object) null);
                    return;
                }
                Throwable th4 = this.error.get();
                if (th4 != null) {
                    cancelAll();
                    Arrays.fill(listArr, (Object) null);
                    cVar.onError(th4);
                    return;
                }
                int i15 = 0;
                while (true) {
                    if (i15 >= length) {
                        z11 = true;
                        break;
                    } else if (iArr[i15] != listArr[i15].size()) {
                        z11 = false;
                        break;
                    } else {
                        i15++;
                    }
                }
                if (z11) {
                    Arrays.fill(listArr, (Object) null);
                    cVar.onComplete();
                    return;
                }
                if (j12 != 0) {
                    b.e(this.requested, j12);
                }
                i11 = addAndGet(-i11);
            } while (i11 != 0);
        }
    }

    public void innerError(Throwable th2) {
        if (this.error.compareAndSet((Object) null, th2)) {
            drain();
        } else if (th2 != this.error.get()) {
            o00.a.n(th2);
        }
    }

    public void innerNext(List<T> list, int i11) {
        this.lists[i11] = list;
        if (this.remaining.decrementAndGet() == 0) {
            drain();
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            if (this.remaining.get() == 0) {
                drain();
            }
        }
    }
}
