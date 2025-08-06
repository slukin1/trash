package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;

public final class SingleDoOnEvent<T> implements Single.OnSubscribe<T> {
    public final Action1<Throwable> onError;
    public final Action1<? super T> onSuccess;
    public final Single<T> source;

    public static final class SingleDoOnEventSubscriber<T> extends SingleSubscriber<T> {
        public final SingleSubscriber<? super T> actual;
        public final Action1<Throwable> onError;
        public final Action1<? super T> onSuccess;

        public SingleDoOnEventSubscriber(SingleSubscriber<? super T> singleSubscriber, Action1<? super T> action1, Action1<Throwable> action12) {
            this.actual = singleSubscriber;
            this.onSuccess = action1;
            this.onError = action12;
        }

        public void onError(Throwable th2) {
            try {
                this.onError.call(th2);
                this.actual.onError(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.actual.onError(new CompositeException(th2, th3));
            }
        }

        public void onSuccess(T t11) {
            try {
                this.onSuccess.call(t11);
                this.actual.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwOrReport(th2, (SingleSubscriber<?>) this, (Object) t11);
            }
        }
    }

    public SingleDoOnEvent(Single<T> single, Action1<? super T> action1, Action1<Throwable> action12) {
        this.source = single;
        this.onSuccess = action1;
        this.onError = action12;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        SingleDoOnEventSubscriber singleDoOnEventSubscriber = new SingleDoOnEventSubscriber(singleSubscriber, this.onSuccess, this.onError);
        singleSubscriber.add(singleDoOnEventSubscriber);
        this.source.subscribe(singleDoOnEventSubscriber);
    }
}
