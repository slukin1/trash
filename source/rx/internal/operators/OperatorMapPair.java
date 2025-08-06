package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.plugins.RxJavaHooks;

public final class OperatorMapPair<T, U, R> implements Observable.Operator<Observable<? extends R>, T> {
    public final Func1<? super T, ? extends Observable<? extends U>> collectionSelector;
    public final Func2<? super T, ? super U, ? extends R> resultSelector;

    public static final class MapPairSubscriber<T, U, R> extends Subscriber<T> {
        public final Subscriber<? super Observable<? extends R>> actual;
        public final Func1<? super T, ? extends Observable<? extends U>> collectionSelector;
        public boolean done;
        public final Func2<? super T, ? super U, ? extends R> resultSelector;

        public MapPairSubscriber(Subscriber<? super Observable<? extends R>> subscriber, Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
            this.actual = subscriber;
            this.collectionSelector = func1;
            this.resultSelector = func2;
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
                this.actual.onNext(((Observable) this.collectionSelector.call(t11)).map(new OuterInnerMapper(t11, this.resultSelector)));
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

    public static final class OuterInnerMapper<T, U, R> implements Func1<U, R> {
        public final T outer;
        public final Func2<? super T, ? super U, ? extends R> resultSelector;

        public OuterInnerMapper(T t11, Func2<? super T, ? super U, ? extends R> func2) {
            this.outer = t11;
            this.resultSelector = func2;
        }

        public R call(U u11) {
            return this.resultSelector.call(this.outer, u11);
        }
    }

    public OperatorMapPair(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        this.collectionSelector = func1;
        this.resultSelector = func2;
    }

    public static <T, U> Func1<T, Observable<U>> convertSelector(final Func1<? super T, ? extends Iterable<? extends U>> func1) {
        return new Func1<T, Observable<U>>() {
            public Observable<U> call(T t11) {
                return Observable.from((Iterable) func1.call(t11));
            }
        };
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<? extends R>> subscriber) {
        MapPairSubscriber mapPairSubscriber = new MapPairSubscriber(subscriber, this.collectionSelector, this.resultSelector);
        subscriber.add(mapPairSubscriber);
        return mapPairSubscriber;
    }
}
