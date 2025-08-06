package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;
import rx.plugins.RxJavaHooks;

public final class OperatorAny<T> implements Observable.Operator<Boolean, T> {
    public final Func1<? super T, Boolean> predicate;
    public final boolean returnOnEmpty;

    public OperatorAny(Func1<? super T, Boolean> func1, boolean z11) {
        this.predicate = func1;
        this.returnOnEmpty = z11;
    }

    public Subscriber<? super T> call(final Subscriber<? super Boolean> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        AnonymousClass1 r12 = new Subscriber<T>() {
            public boolean done;
            public boolean hasElements;

            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    if (this.hasElements) {
                        singleDelayedProducer.setValue(Boolean.FALSE);
                    } else {
                        singleDelayedProducer.setValue(Boolean.valueOf(OperatorAny.this.returnOnEmpty));
                    }
                }
            }

            public void onError(Throwable th2) {
                if (!this.done) {
                    this.done = true;
                    subscriber.onError(th2);
                    return;
                }
                RxJavaHooks.onError(th2);
            }

            public void onNext(T t11) {
                if (!this.done) {
                    this.hasElements = true;
                    try {
                        if (OperatorAny.this.predicate.call(t11).booleanValue()) {
                            this.done = true;
                            singleDelayedProducer.setValue(Boolean.valueOf(true ^ OperatorAny.this.returnOnEmpty));
                            unsubscribe();
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwOrReport(th2, (Observer<?>) this, (Object) t11);
                    }
                }
            }
        };
        subscriber.add(r12);
        subscriber.setProducer(singleDelayedProducer);
        return r12;
    }
}
