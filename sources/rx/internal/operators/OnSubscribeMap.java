package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeMap<T, R> implements Observable.OnSubscribe<R> {
    public final Observable<T> source;
    public final Func1<? super T, ? extends R> transformer;

    public static final class MapSubscriber<T, R> extends Subscriber<T> {
        public final Subscriber<? super R> actual;
        public boolean done;
        public final Func1<? super T, ? extends R> mapper;

        public MapSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
            this.actual = subscriber;
            this.mapper = func1;
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
                this.actual.onNext(this.mapper.call(t11));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th2, t11));
            }
        }

        public void setProducer(Producer producer) {
            this.actual.setProducer(producer);
        }
    }

    public OnSubscribeMap(Observable<T> observable, Func1<? super T, ? extends R> func1) {
        this.source = observable;
        this.transformer = func1;
    }

    public void call(Subscriber<? super R> subscriber) {
        MapSubscriber mapSubscriber = new MapSubscriber(subscriber, this.transformer);
        subscriber.add(mapSubscriber);
        this.source.unsafeSubscribe(mapSubscriber);
    }
}
