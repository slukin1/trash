package rx.internal.operators;

import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public abstract class DeferredScalarSubscriberSafe<T, R> extends DeferredScalarSubscriber<T, R> {
    public boolean done;

    public DeferredScalarSubscriberSafe(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            super.onCompleted();
        }
    }

    public void onError(Throwable th2) {
        if (!this.done) {
            this.done = true;
            super.onError(th2);
            return;
        }
        RxJavaHooks.onError(th2);
    }
}
