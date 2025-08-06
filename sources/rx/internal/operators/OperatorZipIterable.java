package rx.internal.operators;

import java.util.Iterator;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.Subscribers;

public final class OperatorZipIterable<T1, T2, R> implements Observable.Operator<R, T1> {
    public final Iterable<? extends T2> iterable;
    public final Func2<? super T1, ? super T2, ? extends R> zipFunction;

    public OperatorZipIterable(Iterable<? extends T2> iterable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        this.iterable = iterable2;
        this.zipFunction = func2;
    }

    public Subscriber<? super T1> call(final Subscriber<? super R> subscriber) {
        final Iterator<? extends T2> it2 = this.iterable.iterator();
        try {
            if (it2.hasNext()) {
                return new Subscriber<T1>(subscriber) {
                    public boolean done;

                    public void onCompleted() {
                        if (!this.done) {
                            this.done = true;
                            subscriber.onCompleted();
                        }
                    }

                    public void onError(Throwable th2) {
                        if (this.done) {
                            Exceptions.throwIfFatal(th2);
                            return;
                        }
                        this.done = true;
                        subscriber.onError(th2);
                    }

                    public void onNext(T1 t12) {
                        if (!this.done) {
                            try {
                                subscriber.onNext(OperatorZipIterable.this.zipFunction.call(t12, it2.next()));
                                if (!it2.hasNext()) {
                                    onCompleted();
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwOrReport(th2, (Observer<?>) this);
                            }
                        }
                    }
                };
            }
            subscriber.onCompleted();
            return Subscribers.empty();
        } catch (Throwable th2) {
            Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
            return Subscribers.empty();
        }
    }
}
