package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeUntil<T, E> implements Observable.Operator<T, T> {
    private final Observable<? extends E> other;

    public OperatorTakeUntil(Observable<? extends E> observable) {
        this.other = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        final AnonymousClass1 r22 = new Subscriber<T>(false, serializedSubscriber) {
            public void onCompleted() {
                try {
                    serializedSubscriber.onCompleted();
                } finally {
                    serializedSubscriber.unsubscribe();
                }
            }

            public void onError(Throwable th2) {
                try {
                    serializedSubscriber.onError(th2);
                } finally {
                    serializedSubscriber.unsubscribe();
                }
            }

            public void onNext(T t11) {
                serializedSubscriber.onNext(t11);
            }
        };
        AnonymousClass2 r12 = new Subscriber<E>() {
            public void onCompleted() {
                r22.onCompleted();
            }

            public void onError(Throwable th2) {
                r22.onError(th2);
            }

            public void onNext(E e11) {
                onCompleted();
            }

            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
        serializedSubscriber.add(r22);
        serializedSubscriber.add(r12);
        subscriber.add(serializedSubscriber);
        this.other.unsafeSubscribe(r12);
        return r22;
    }
}
