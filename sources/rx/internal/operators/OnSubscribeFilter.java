package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeFilter<T> implements Observable.OnSubscribe<T> {
    public final Func1<? super T, Boolean> predicate;
    public final Observable<T> source;

    public static final class FilterSubscriber<T> extends Subscriber<T> {
        public final Subscriber<? super T> actual;
        public boolean done;
        public final Func1<? super T, Boolean> predicate;

        public FilterSubscriber(Subscriber<? super T> subscriber, Func1<? super T, Boolean> func1) {
            this.actual = subscriber;
            this.predicate = func1;
            request(0);
        }

        public void onCompleted() {
            if (!this.done) {
                this.actual.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.done = true;
            this.actual.onError(th2);
        }

        public void onNext(T t11) {
            try {
                if (this.predicate.call(t11).booleanValue()) {
                    this.actual.onNext(t11);
                } else {
                    request(1);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th2, t11));
            }
        }

        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.actual.setProducer(producer);
        }
    }

    public OnSubscribeFilter(Observable<T> observable, Func1<? super T, Boolean> func1) {
        this.source = observable;
        this.predicate = func1;
    }

    public void call(Subscriber<? super T> subscriber) {
        FilterSubscriber filterSubscriber = new FilterSubscriber(subscriber, this.predicate);
        subscriber.add(filterSubscriber);
        this.source.unsafeSubscribe(filterSubscriber);
    }
}
