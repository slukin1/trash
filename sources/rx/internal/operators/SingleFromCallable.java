package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;

public final class SingleFromCallable<T> implements Single.OnSubscribe<T> {
    public final Callable<? extends T> callable;

    public SingleFromCallable(Callable<? extends T> callable2) {
        this.callable = callable2;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        try {
            singleSubscriber.onSuccess(this.callable.call());
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            singleSubscriber.onError(th2);
        }
    }
}
