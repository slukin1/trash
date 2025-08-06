package io.reactivex.rxjava3.internal.operators.maybe;

import h00.e;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

final class MaybeTimeoutPublisher$TimeoutOtherMaybeObserver<T, U> extends AtomicReference<d> implements e<Object> {
    private static final long serialVersionUID = 8663801314800248617L;
    public final MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> parent;

    public MaybeTimeoutPublisher$TimeoutOtherMaybeObserver(MaybeTimeoutPublisher$TimeoutMainMaybeObserver<T, U> maybeTimeoutPublisher$TimeoutMainMaybeObserver) {
        this.parent = maybeTimeoutPublisher$TimeoutMainMaybeObserver;
    }

    public void onComplete() {
        this.parent.otherComplete();
    }

    public void onError(Throwable th2) {
        this.parent.otherError(th2);
    }

    public void onNext(Object obj) {
        ((d) get()).cancel();
        this.parent.otherComplete();
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, Long.MAX_VALUE);
    }
}
