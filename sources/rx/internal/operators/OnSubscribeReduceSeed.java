package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

public final class OnSubscribeReduceSeed<T, R> implements Observable.OnSubscribe<R> {
    public final R initialValue;
    public final Func2<R, ? super T, R> reducer;
    public final Observable<T> source;

    public static final class ReduceSeedSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        public final Func2<R, ? super T, R> reducer;

        public ReduceSeedSubscriber(Subscriber<? super R> subscriber, R r11, Func2<R, ? super T, R> func2) {
            super(subscriber);
            this.value = r11;
            this.hasValue = true;
            this.reducer = func2;
        }

        public void onNext(T t11) {
            try {
                this.value = this.reducer.call(this.value, t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                unsubscribe();
                this.actual.onError(th2);
            }
        }
    }

    public OnSubscribeReduceSeed(Observable<T> observable, R r11, Func2<R, ? super T, R> func2) {
        this.source = observable;
        this.initialValue = r11;
        this.reducer = func2;
    }

    public void call(Subscriber<? super R> subscriber) {
        new ReduceSeedSubscriber(subscriber, this.initialValue, this.reducer).subscribeTo(this.source);
    }
}
