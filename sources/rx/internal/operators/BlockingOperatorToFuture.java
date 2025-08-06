package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public final class BlockingOperatorToFuture {
    private BlockingOperatorToFuture() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Future<T> toFuture(Observable<? extends T> observable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final Subscription subscribe = observable.single().subscribe(new Subscriber<T>() {
            public void onCompleted() {
                countDownLatch.countDown();
            }

            public void onError(Throwable th2) {
                atomicReference2.compareAndSet((Object) null, th2);
                countDownLatch.countDown();
            }

            public void onNext(T t11) {
                atomicReference.set(t11);
            }
        });
        return new Future<T>() {
            private volatile boolean cancelled;

            private T getValue() throws ExecutionException {
                Throwable th2 = (Throwable) atomicReference2.get();
                if (th2 != null) {
                    throw new ExecutionException("Observable onError", th2);
                } else if (!this.cancelled) {
                    return atomicReference.get();
                } else {
                    throw new CancellationException("Subscription unsubscribed");
                }
            }

            public boolean cancel(boolean z11) {
                if (countDownLatch.getCount() <= 0) {
                    return false;
                }
                this.cancelled = true;
                subscribe.unsubscribe();
                countDownLatch.countDown();
                return true;
            }

            public T get() throws InterruptedException, ExecutionException {
                countDownLatch.await();
                return getValue();
            }

            public boolean isCancelled() {
                return this.cancelled;
            }

            public boolean isDone() {
                return countDownLatch.getCount() == 0;
            }

            public T get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                if (countDownLatch.await(j11, timeUnit)) {
                    return getValue();
                }
                throw new TimeoutException("Timed out after " + timeUnit.toMillis(j11) + "ms waiting for underlying Observable.");
            }
        };
    }
}
