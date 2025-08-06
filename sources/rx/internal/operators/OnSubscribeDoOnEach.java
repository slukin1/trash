package rx.internal.operators;

import java.util.Arrays;
import java.util.Collection;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaHooks;

public class OnSubscribeDoOnEach<T> implements Observable.OnSubscribe<T> {
    private final Observer<? super T> doOnEachObserver;
    private final Observable<T> source;

    public static final class DoOnEachSubscriber<T> extends Subscriber<T> {
        private final Observer<? super T> doOnEachObserver;
        private boolean done;
        private final Subscriber<? super T> subscriber;

        public DoOnEachSubscriber(Subscriber<? super T> subscriber2, Observer<? super T> observer) {
            super(subscriber2);
            this.subscriber = subscriber2;
            this.doOnEachObserver = observer;
        }

        public void onCompleted() {
            if (!this.done) {
                try {
                    this.doOnEachObserver.onCompleted();
                    this.done = true;
                    this.subscriber.onCompleted();
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) this);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.done = true;
            try {
                this.doOnEachObserver.onError(th2);
                this.subscriber.onError(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.subscriber.onError(new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th2, th3})));
            }
        }

        public void onNext(T t11) {
            if (!this.done) {
                try {
                    this.doOnEachObserver.onNext(t11);
                    this.subscriber.onNext(t11);
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) this, (Object) t11);
                }
            }
        }
    }

    public OnSubscribeDoOnEach(Observable<T> observable, Observer<? super T> observer) {
        this.source = observable;
        this.doOnEachObserver = observer;
    }

    public void call(Subscriber<? super T> subscriber) {
        this.source.unsafeSubscribe(new DoOnEachSubscriber(subscriber, this.doOnEachObserver));
    }
}
