package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorSkipWhile<T> implements Observable.Operator<T, T> {
    public final Func2<? super T, Integer, Boolean> predicate;

    public OperatorSkipWhile(Func2<? super T, Integer, Boolean> func2) {
        this.predicate = func2;
    }

    public static <T> Func2<T, Integer, Boolean> toPredicate2(final Func1<? super T, Boolean> func1) {
        return new Func2<T, Integer, Boolean>() {
            public Boolean call(T t11, Integer num) {
                return (Boolean) func1.call(t11);
            }
        };
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            public int index;
            public boolean skipping = true;

            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                if (!this.skipping) {
                    subscriber.onNext(t11);
                    return;
                }
                try {
                    Func2<? super T, Integer, Boolean> func2 = OperatorSkipWhile.this.predicate;
                    int i11 = this.index;
                    this.index = i11 + 1;
                    if (!func2.call(t11, Integer.valueOf(i11)).booleanValue()) {
                        this.skipping = false;
                        subscriber.onNext(t11);
                        return;
                    }
                    request(1);
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) subscriber, (Object) t11);
                }
            }
        };
    }
}
