package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

public final class OperatorDistinct<T, U> implements Observable.Operator<T, T> {
    public final Func1<? super T, ? extends U> keySelector;

    public static final class Holder {
        public static final OperatorDistinct<?, ?> INSTANCE = new OperatorDistinct<>(UtilityFunctions.identity());
    }

    public OperatorDistinct(Func1<? super T, ? extends U> func1) {
        this.keySelector = func1;
    }

    public static <T> OperatorDistinct<T, T> instance() {
        return Holder.INSTANCE;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            public Set<U> keyMemory = new HashSet();

            public void onCompleted() {
                this.keyMemory = null;
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                this.keyMemory = null;
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                if (this.keyMemory.add(OperatorDistinct.this.keySelector.call(t11))) {
                    subscriber.onNext(t11);
                } else {
                    request(1);
                }
            }
        };
    }
}
