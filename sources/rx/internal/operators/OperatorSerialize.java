package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSerialize<T> implements Observable.Operator<T, T> {

    public static final class Holder {
        public static final OperatorSerialize<Object> INSTANCE = new OperatorSerialize<>();
    }

    public static <T> OperatorSerialize<T> instance() {
        return Holder.INSTANCE;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new SerializedSubscriber(new Subscriber<T>(subscriber) {
            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                subscriber.onNext(t11);
            }
        });
    }
}
