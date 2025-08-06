package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import z20.d;

final class FlowableToList$ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements e<T>, d {
    private static final long serialVersionUID = -8134157938864266736L;
    public d upstream;

    /* JADX WARNING: type inference failed for: r2v0, types: [T, U] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlowableToList$ToListSubscriber(z20.c<? super U> r1, U r2) {
        /*
            r0 = this;
            r0.<init>(r1)
            r0.value = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableToList$ToListSubscriber.<init>(z20.c, java.util.Collection):void");
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        complete(this.value);
    }

    public void onError(Throwable th2) {
        this.value = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        Collection collection = (Collection) this.value;
        if (collection != null) {
            collection.add(t11);
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
