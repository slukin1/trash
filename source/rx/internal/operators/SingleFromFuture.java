package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.subscriptions.Subscriptions;

public final class SingleFromFuture<T> implements Single.OnSubscribe<T> {
    public final Future<? extends T> future;
    public final long timeout;
    public final TimeUnit unit;

    public SingleFromFuture(Future<? extends T> future2, long j11, TimeUnit timeUnit) {
        this.future = future2;
        this.timeout = j11;
        this.unit = timeUnit;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Object obj;
        Future<? extends T> future2 = this.future;
        singleSubscriber.add(Subscriptions.from((Future<?>) future2));
        try {
            long j11 = this.timeout;
            if (j11 == 0) {
                obj = future2.get();
            } else {
                obj = future2.get(j11, this.unit);
            }
            singleSubscriber.onSuccess(obj);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            singleSubscriber.onError(th2);
        }
    }
}
