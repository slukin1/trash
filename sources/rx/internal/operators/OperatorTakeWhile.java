package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorTakeWhile<T> implements Observable.Operator<T, T> {
    public final Func2<? super T, ? super Integer, Boolean> predicate;

    public OperatorTakeWhile(final Func1<? super T, Boolean> func1) {
        this(new Func2<T, Integer, Boolean>() {
            public Boolean call(T t11, Integer num) {
                return (Boolean) Func1.this.call(t11);
            }
        });
    }

    public OperatorTakeWhile(Func2<? super T, ? super Integer, Boolean> func2) {
        this.predicate = func2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        AnonymousClass2 r02 = new Subscriber<T>(false, subscriber) {
            private int counter;
            private boolean done;

            public void onCompleted() {
                if (!this.done) {
                    subscriber.onCompleted();
                }
            }

            public void onError(Throwable th2) {
                if (!this.done) {
                    subscriber.onError(th2);
                }
            }

            public void onNext(T t11) {
                try {
                    Func2<? super T, ? super Integer, Boolean> func2 = OperatorTakeWhile.this.predicate;
                    int i11 = this.counter;
                    this.counter = i11 + 1;
                    if (func2.call(t11, Integer.valueOf(i11)).booleanValue()) {
                        subscriber.onNext(t11);
                        return;
                    }
                    this.done = true;
                    subscriber.onCompleted();
                    unsubscribe();
                } catch (Throwable th2) {
                    this.done = true;
                    Exceptions.throwOrReport(th2, (Observer<?>) subscriber, (Object) t11);
                    unsubscribe();
                }
            }
        };
        subscriber.add(r02);
        return r02;
    }
}
