package rx.internal.operators;

import java.util.Objects;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

public final class OperatorDoAfterTerminate<T> implements Observable.Operator<T, T> {
    public final Action0 action;

    public OperatorDoAfterTerminate(Action0 action0) {
        Objects.requireNonNull(action0, "Action can not be null");
        this.action = action0;
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            public void callAction() {
                try {
                    OperatorDoAfterTerminate.this.action.call();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaHooks.onError(th2);
                }
            }

            public void onCompleted() {
                try {
                    subscriber.onCompleted();
                } finally {
                    callAction();
                }
            }

            public void onError(Throwable th2) {
                try {
                    subscriber.onError(th2);
                } finally {
                    callAction();
                }
            }

            public void onNext(T t11) {
                subscriber.onNext(t11);
            }
        };
    }
}
