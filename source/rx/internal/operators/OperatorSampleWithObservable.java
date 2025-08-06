package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

public final class OperatorSampleWithObservable<T, U> implements Observable.Operator<T, T> {
    public static final Object EMPTY_TOKEN = new Object();
    public final Observable<U> sampler;

    public OperatorSampleWithObservable(Observable<U> observable) {
        this.sampler = observable;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final AtomicReference atomicReference = new AtomicReference(EMPTY_TOKEN);
        final AtomicReference atomicReference2 = new AtomicReference();
        final AnonymousClass1 r32 = new Subscriber<U>() {
            public void onCompleted() {
                onNext((Object) null);
                serializedSubscriber.onCompleted();
                ((Subscription) atomicReference2.get()).unsubscribe();
            }

            public void onError(Throwable th2) {
                serializedSubscriber.onError(th2);
                ((Subscription) atomicReference2.get()).unsubscribe();
            }

            public void onNext(U u11) {
                AtomicReference atomicReference = atomicReference;
                Object obj = OperatorSampleWithObservable.EMPTY_TOKEN;
                Object andSet = atomicReference.getAndSet(obj);
                if (andSet != obj) {
                    serializedSubscriber.onNext(andSet);
                }
            }
        };
        AnonymousClass2 r42 = new Subscriber<T>() {
            public void onCompleted() {
                r32.onNext(null);
                serializedSubscriber.onCompleted();
                r32.unsubscribe();
            }

            public void onError(Throwable th2) {
                serializedSubscriber.onError(th2);
                r32.unsubscribe();
            }

            public void onNext(T t11) {
                atomicReference.set(t11);
            }
        };
        atomicReference2.lazySet(r42);
        subscriber.add(r42);
        subscriber.add(r32);
        this.sampler.unsafeSubscribe(r32);
        return r42;
    }
}
