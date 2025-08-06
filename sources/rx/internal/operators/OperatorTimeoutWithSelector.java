package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.operators.OperatorTimeoutBase;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class OperatorTimeoutWithSelector<T, U, V> extends OperatorTimeoutBase<T> {
    public OperatorTimeoutWithSelector(final Func0<? extends Observable<U>> func0, final Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable) {
        super(new OperatorTimeoutBase.FirstTimeoutStub<T>() {
            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l11, Scheduler.Worker worker) {
                Func0 func0 = Func0.this;
                if (func0 == null) {
                    return Subscriptions.unsubscribed();
                }
                try {
                    return ((Observable) func0.call()).unsafeSubscribe(new Subscriber<U>() {
                        public void onCompleted() {
                            timeoutSubscriber.onTimeout(l11.longValue());
                        }

                        public void onError(Throwable th2) {
                            timeoutSubscriber.onError(th2);
                        }

                        public void onNext(U u11) {
                            timeoutSubscriber.onTimeout(l11.longValue());
                        }
                    });
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) timeoutSubscriber);
                    return Subscriptions.unsubscribed();
                }
            }
        }, new OperatorTimeoutBase.TimeoutStub<T>() {
            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l11, T t11, Scheduler.Worker worker) {
                try {
                    return ((Observable) Func1.this.call(t11)).unsafeSubscribe(new Subscriber<V>() {
                        public void onCompleted() {
                            timeoutSubscriber.onTimeout(l11.longValue());
                        }

                        public void onError(Throwable th2) {
                            timeoutSubscriber.onError(th2);
                        }

                        public void onNext(V v11) {
                            timeoutSubscriber.onTimeout(l11.longValue());
                        }
                    });
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) timeoutSubscriber);
                    return Subscriptions.unsubscribed();
                }
            }
        }, observable, Schedulers.immediate());
    }

    public /* bridge */ /* synthetic */ Subscriber call(Subscriber subscriber) {
        return super.call(subscriber);
    }
}
