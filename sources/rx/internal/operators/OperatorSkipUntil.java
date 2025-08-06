package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSkipUntil<T, U> implements Observable.Operator<T, T> {
    public final Observable<U> other;

    public OperatorSkipUntil(Observable<U> observable) {
        this.other = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        AnonymousClass1 r22 = new Subscriber<U>() {
            public void onCompleted() {
                unsubscribe();
            }

            public void onError(Throwable th2) {
                serializedSubscriber.onError(th2);
                serializedSubscriber.unsubscribe();
            }

            public void onNext(U u11) {
                atomicBoolean.set(true);
                unsubscribe();
            }
        };
        subscriber.add(r22);
        this.other.unsafeSubscribe(r22);
        return new Subscriber<T>(subscriber) {
            public void onCompleted() {
                serializedSubscriber.onCompleted();
                unsubscribe();
            }

            public void onError(Throwable th2) {
                serializedSubscriber.onError(th2);
                unsubscribe();
            }

            public void onNext(T t11) {
                if (atomicBoolean.get()) {
                    serializedSubscriber.onNext(t11);
                } else {
                    request(1);
                }
            }
        };
    }
}
