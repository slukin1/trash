package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

final class FlowableGroupJoin$LeftRightEndSubscriber extends AtomicReference<d> implements e<Object>, b {
    private static final long serialVersionUID = 1883890389173668373L;
    public final int index;
    public final boolean isLeft;
    public final g parent;

    public FlowableGroupJoin$LeftRightEndSubscriber(g gVar, boolean z11, int i11) {
        this.parent = gVar;
        this.isLeft = z11;
        this.index = i11;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        this.parent.innerClose(this.isLeft, this);
    }

    public void onError(Throwable th2) {
        this.parent.innerCloseError(th2);
    }

    public void onNext(Object obj) {
        if (SubscriptionHelper.cancel(this)) {
            this.parent.innerClose(this.isLeft, this);
        }
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
    }
}
