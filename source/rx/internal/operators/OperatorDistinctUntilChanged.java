package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.util.UtilityFunctions;

public final class OperatorDistinctUntilChanged<T, U> implements Observable.Operator<T, T>, Func2<U, U, Boolean> {
    public final Func2<? super U, ? super U, Boolean> comparator;
    public final Func1<? super T, ? extends U> keySelector;

    public static final class Holder {
        public static final OperatorDistinctUntilChanged<?, ?> INSTANCE = new OperatorDistinctUntilChanged<>(UtilityFunctions.identity());
    }

    public OperatorDistinctUntilChanged(Func1<? super T, ? extends U> func1) {
        this.keySelector = func1;
        this.comparator = this;
    }

    public static <T> OperatorDistinctUntilChanged<T, T> instance() {
        return Holder.INSTANCE;
    }

    public Boolean call(U u11, U u12) {
        return Boolean.valueOf(u11 == u12 || (u11 != null && u11.equals(u12)));
    }

    public OperatorDistinctUntilChanged(Func2<? super U, ? super U, Boolean> func2) {
        this.keySelector = UtilityFunctions.identity();
        this.comparator = func2;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            public boolean hasPrevious;
            public U previousKey;

            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                try {
                    U call = OperatorDistinctUntilChanged.this.keySelector.call(t11);
                    U u11 = this.previousKey;
                    this.previousKey = call;
                    if (this.hasPrevious) {
                        try {
                            if (!OperatorDistinctUntilChanged.this.comparator.call(u11, call).booleanValue()) {
                                subscriber.onNext(t11);
                            } else {
                                request(1);
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, (Observer<?>) subscriber, (Object) call);
                        }
                    } else {
                        this.hasPrevious = true;
                        subscriber.onNext(t11);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwOrReport(th3, (Observer<?>) subscriber, (Object) t11);
                }
            }
        };
    }
}
