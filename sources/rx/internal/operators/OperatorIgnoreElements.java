package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

public class OperatorIgnoreElements<T> implements Observable.Operator<T, T> {

    public static final class Holder {
        public static final OperatorIgnoreElements<?> INSTANCE = new OperatorIgnoreElements<>();
    }

    public static <T> OperatorIgnoreElements<T> instance() {
        return Holder.INSTANCE;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        AnonymousClass1 r02 = new Subscriber<T>() {
            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
            }
        };
        subscriber.add(r02);
        return r02;
    }
}
