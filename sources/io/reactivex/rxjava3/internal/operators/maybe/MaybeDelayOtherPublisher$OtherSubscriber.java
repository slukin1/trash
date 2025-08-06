package io.reactivex.rxjava3.internal.operators.maybe;

import h00.e;
import h00.f;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

final class MaybeDelayOtherPublisher$OtherSubscriber<T> extends AtomicReference<d> implements e<Object> {
    private static final long serialVersionUID = -1215060610805418006L;
    public final f<? super T> downstream;
    public Throwable error;
    public T value;

    public MaybeDelayOtherPublisher$OtherSubscriber(f<? super T> fVar) {
        this.downstream = fVar;
    }

    public void onComplete() {
        Throwable th2 = this.error;
        if (th2 != null) {
            this.downstream.onError(th2);
            return;
        }
        T t11 = this.value;
        if (t11 != null) {
            this.downstream.onSuccess(t11);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        Throwable th3 = this.error;
        if (th3 == null) {
            this.downstream.onError(th2);
            return;
        }
        this.downstream.onError(new CompositeException(th3, th2));
    }

    public void onNext(Object obj) {
        d dVar = (d) get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            dVar.cancel();
            onComplete();
        }
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
    }
}
