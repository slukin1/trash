package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import z20.b;
import z20.c;
import z20.d;

final class FlowableConcatArray$ConcatArraySubscriber<T> extends SubscriptionArbiter implements e<T> {
    private static final long serialVersionUID = -8158322871608889516L;
    public final boolean delayError;
    public final c<? super T> downstream;
    public List<Throwable> errors;
    public int index;
    public long produced;
    public final b<? extends T>[] sources;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableConcatArray$ConcatArraySubscriber(b<? extends T>[] bVarArr, boolean z11, c<? super T> cVar) {
        super(false);
        this.downstream = cVar;
        this.sources = bVarArr;
        this.delayError = z11;
    }

    public void onComplete() {
        if (this.wip.getAndIncrement() == 0) {
            b<? extends T>[] bVarArr = this.sources;
            int length = bVarArr.length;
            int i11 = this.index;
            while (i11 != length) {
                b<? extends T> bVar = bVarArr[i11];
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                    if (this.delayError) {
                        List list = this.errors;
                        if (list == null) {
                            list = new ArrayList((length - i11) + 1);
                            this.errors = list;
                        }
                        list.add(nullPointerException);
                        i11++;
                    } else {
                        this.downstream.onError(nullPointerException);
                        return;
                    }
                } else {
                    long j11 = this.produced;
                    if (j11 != 0) {
                        this.produced = 0;
                        produced(j11);
                    }
                    bVar.subscribe(this);
                    i11++;
                    this.index = i11;
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
            List<Throwable> list2 = this.errors;
            if (list2 == null) {
                this.downstream.onComplete();
            } else if (list2.size() == 1) {
                this.downstream.onError(list2.get(0));
            } else {
                this.downstream.onError(new CompositeException((Iterable<? extends Throwable>) list2));
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.delayError) {
            List list = this.errors;
            if (list == null) {
                list = new ArrayList((this.sources.length - this.index) + 1);
                this.errors = list;
            }
            list.add(th2);
            onComplete();
            return;
        }
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        this.produced++;
        this.downstream.onNext(t11);
    }

    public void onSubscribe(d dVar) {
        setSubscription(dVar);
    }
}
