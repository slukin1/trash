package io.reactivex.rxjava3.internal.operators.flowable;

import h00.a;
import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class FlowableMergeWithCompletable$MergeWithSubscriber<T> extends AtomicInteger implements e<T>, d {
    private static final long serialVersionUID = -4592979584110982903L;
    public final c<? super T> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public volatile boolean mainDone;
    public final AtomicReference<d> mainSubscription = new AtomicReference<>();
    public volatile boolean otherDone;
    public final OtherObserver otherObserver = new OtherObserver(this);
    public final AtomicLong requested = new AtomicLong();

    public static final class OtherObserver extends AtomicReference<b> implements a {
        private static final long serialVersionUID = -2935427570954647017L;
        public final FlowableMergeWithCompletable$MergeWithSubscriber<?> parent;

        public OtherObserver(FlowableMergeWithCompletable$MergeWithSubscriber<?> flowableMergeWithCompletable$MergeWithSubscriber) {
            this.parent = flowableMergeWithCompletable$MergeWithSubscriber;
        }

        public void onComplete() {
            this.parent.otherComplete();
        }

        public void onError(Throwable th2) {
            this.parent.otherError(th2);
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public FlowableMergeWithCompletable$MergeWithSubscriber(c<? super T> cVar) {
        this.downstream = cVar;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
        this.errors.tryTerminateAndReport();
    }

    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone) {
            io.reactivex.rxjava3.internal.util.e.b(this.downstream, this, this.errors);
        }
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this.otherObserver);
        io.reactivex.rxjava3.internal.util.e.d(this.downstream, th2, this, this.errors);
    }

    public void onNext(T t11) {
        io.reactivex.rxjava3.internal.util.e.f(this.downstream, t11, this, this.errors);
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, dVar);
    }

    public void otherComplete() {
        this.otherDone = true;
        if (this.mainDone) {
            io.reactivex.rxjava3.internal.util.e.b(this.downstream, this, this.errors);
        }
    }

    public void otherError(Throwable th2) {
        SubscriptionHelper.cancel(this.mainSubscription);
        io.reactivex.rxjava3.internal.util.e.d(this.downstream, th2, this, this.errors);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, j11);
    }
}
