package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;

public final class OperatorWithLatestFrom<T, U, R> implements Observable.Operator<R, T> {
    public static final Object EMPTY = new Object();
    public final Observable<? extends U> other;
    public final Func2<? super T, ? super U, ? extends R> resultSelector;

    public OperatorWithLatestFrom(Observable<? extends U> observable, Func2<? super T, ? super U, ? extends R> func2) {
        this.other = observable;
        this.resultSelector = func2;
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        subscriber.add(serializedSubscriber);
        final AtomicReference atomicReference = new AtomicReference(EMPTY);
        final AtomicReference atomicReference2 = atomicReference;
        final SerializedSubscriber serializedSubscriber2 = serializedSubscriber;
        AnonymousClass1 r02 = new Subscriber<T>(serializedSubscriber, true) {
            public void onCompleted() {
                serializedSubscriber2.onCompleted();
                serializedSubscriber2.unsubscribe();
            }

            public void onError(Throwable th2) {
                serializedSubscriber2.onError(th2);
                serializedSubscriber2.unsubscribe();
            }

            public void onNext(T t11) {
                Object obj = atomicReference2.get();
                if (obj != OperatorWithLatestFrom.EMPTY) {
                    try {
                        serializedSubscriber2.onNext(OperatorWithLatestFrom.this.resultSelector.call(t11, obj));
                    } catch (Throwable th2) {
                        Exceptions.throwOrReport(th2, (Observer<?>) this);
                    }
                }
            }
        };
        AnonymousClass2 r03 = new Subscriber<U>() {
            public void onCompleted() {
                if (atomicReference.get() == OperatorWithLatestFrom.EMPTY) {
                    serializedSubscriber.onCompleted();
                    serializedSubscriber.unsubscribe();
                }
            }

            public void onError(Throwable th2) {
                serializedSubscriber.onError(th2);
                serializedSubscriber.unsubscribe();
            }

            public void onNext(U u11) {
                atomicReference.set(u11);
            }
        };
        serializedSubscriber.add(r02);
        serializedSubscriber.add(r03);
        this.other.unsafeSubscribe(r03);
        return r02;
    }
}
