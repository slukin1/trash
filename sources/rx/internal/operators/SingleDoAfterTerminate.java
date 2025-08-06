package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

public final class SingleDoAfterTerminate<T> implements Single.OnSubscribe<T> {
    public final Action0 action;
    public final Single<T> source;

    public static final class SingleDoAfterTerminateSubscriber<T> extends SingleSubscriber<T> {
        public final Action0 action;
        public final SingleSubscriber<? super T> actual;

        public SingleDoAfterTerminateSubscriber(SingleSubscriber<? super T> singleSubscriber, Action0 action0) {
            this.actual = singleSubscriber;
            this.action = action0;
        }

        public void doAction() {
            try {
                this.action.call();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaHooks.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            try {
                this.actual.onError(th2);
            } finally {
                doAction();
            }
        }

        public void onSuccess(T t11) {
            try {
                this.actual.onSuccess(t11);
            } finally {
                doAction();
            }
        }
    }

    public SingleDoAfterTerminate(Single<T> single, Action0 action0) {
        this.source = single;
        this.action = action0;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        SingleDoAfterTerminateSubscriber singleDoAfterTerminateSubscriber = new SingleDoAfterTerminateSubscriber(singleSubscriber, this.action);
        singleSubscriber.add(singleDoAfterTerminateSubscriber);
        this.source.subscribe(singleDoAfterTerminateSubscriber);
    }
}
