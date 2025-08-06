package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Single;
import rx.SingleSubscriber;
import rx.plugins.RxJavaHooks;

public final class SingleTakeUntilSingle<T, U> implements Single.OnSubscribe<T> {
    public final Single<? extends U> other;
    public final Single.OnSubscribe<T> source;

    public static final class TakeUntilSourceSubscriber<T, U> extends SingleSubscriber<T> {
        public final SingleSubscriber<? super T> actual;
        public final AtomicBoolean once = new AtomicBoolean();
        public final SingleSubscriber<U> other;

        public final class OtherSubscriber extends SingleSubscriber<U> {
            public OtherSubscriber() {
            }

            public void onError(Throwable th2) {
                TakeUntilSourceSubscriber.this.onError(th2);
            }

            public void onSuccess(U u11) {
                onError(new CancellationException("Single::takeUntil(Single) - Stream was canceled before emitting a terminal event."));
            }
        }

        public TakeUntilSourceSubscriber(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
            OtherSubscriber otherSubscriber = new OtherSubscriber();
            this.other = otherSubscriber;
            add(otherSubscriber);
        }

        public void onError(Throwable th2) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onError(th2);
                return;
            }
            RxJavaHooks.onError(th2);
        }

        public void onSuccess(T t11) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onSuccess(t11);
            }
        }
    }

    public SingleTakeUntilSingle(Single.OnSubscribe<T> onSubscribe, Single<? extends U> single) {
        this.source = onSubscribe;
        this.other = single;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        TakeUntilSourceSubscriber takeUntilSourceSubscriber = new TakeUntilSourceSubscriber(singleSubscriber);
        singleSubscriber.add(takeUntilSourceSubscriber);
        this.other.subscribe(takeUntilSourceSubscriber.other);
        this.source.call(takeUntilSourceSubscriber);
    }
}
