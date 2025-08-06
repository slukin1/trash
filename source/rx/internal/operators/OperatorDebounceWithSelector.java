package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithSelector<T, U> implements Observable.Operator<T, T> {
    public final Func1<? super T, ? extends Observable<U>> selector;

    public OperatorDebounceWithSelector(Func1<? super T, ? extends Observable<U>> func1) {
        this.selector = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        return new Subscriber<T>(subscriber) {
            public final Subscriber<?> self = this;
            public final OperatorDebounceWithTime.DebounceState<T> state = new OperatorDebounceWithTime.DebounceState<>();

            public void onCompleted() {
                this.state.emitAndComplete(serializedSubscriber, this);
            }

            public void onError(Throwable th2) {
                serializedSubscriber.onError(th2);
                unsubscribe();
                this.state.clear();
            }

            public void onNext(T t11) {
                try {
                    Observable observable = (Observable) OperatorDebounceWithSelector.this.selector.call(t11);
                    final int next = this.state.next(t11);
                    AnonymousClass1 r12 = new Subscriber<U>() {
                        public void onCompleted() {
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            r02.state.emit(next, serializedSubscriber, r02.self);
                            unsubscribe();
                        }

                        public void onError(Throwable th2) {
                            AnonymousClass1.this.self.onError(th2);
                        }

                        public void onNext(U u11) {
                            onCompleted();
                        }
                    };
                    serialSubscription.set(r12);
                    observable.unsafeSubscribe(r12);
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) this);
                }
            }

            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
    }
}
