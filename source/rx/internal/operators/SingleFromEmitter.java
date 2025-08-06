package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Single;
import rx.SingleEmitter;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
import rx.plugins.RxJavaHooks;

public final class SingleFromEmitter<T> implements Single.OnSubscribe<T> {
    public final Action1<SingleEmitter<T>> producer;

    public static final class SingleEmitterImpl<T> extends AtomicBoolean implements SingleEmitter<T>, Subscription {
        private static final long serialVersionUID = 8082834163465882809L;
        public final SingleSubscriber<? super T> actual;
        public final SequentialSubscription resource = new SequentialSubscription();

        public SingleEmitterImpl(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
        }

        public boolean isUnsubscribed() {
            return get();
        }

        public void onError(Throwable th2) {
            if (th2 == null) {
                th2 = new NullPointerException();
            }
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onError(th2);
                } finally {
                    this.resource.unsubscribe();
                }
            } else {
                RxJavaHooks.onError(th2);
            }
        }

        public void onSuccess(T t11) {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onSuccess(t11);
                } finally {
                    this.resource.unsubscribe();
                }
            }
        }

        public void setCancellation(Cancellable cancellable) {
            setSubscription(new CancellableSubscription(cancellable));
        }

        public void setSubscription(Subscription subscription) {
            this.resource.update(subscription);
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.resource.unsubscribe();
            }
        }
    }

    public SingleFromEmitter(Action1<SingleEmitter<T>> action1) {
        this.producer = action1;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        SingleEmitterImpl singleEmitterImpl = new SingleEmitterImpl(singleSubscriber);
        singleSubscriber.add(singleEmitterImpl);
        try {
            this.producer.call(singleEmitterImpl);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            singleEmitterImpl.onError(th2);
        }
    }
}
