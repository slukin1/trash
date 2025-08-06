package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class SingleOnErrorReturn<T> implements Single.OnSubscribe<T> {
    public final Func1<Throwable, ? extends T> resumeFunction;
    public final Single.OnSubscribe<T> source;

    public static final class OnErrorReturnsSingleSubscriber<T> extends SingleSubscriber<T> {
        public final SingleSubscriber<? super T> actual;
        public final Func1<Throwable, ? extends T> resumeFunction;

        public OnErrorReturnsSingleSubscriber(SingleSubscriber<? super T> singleSubscriber, Func1<Throwable, ? extends T> func1) {
            this.actual = singleSubscriber;
            this.resumeFunction = func1;
        }

        public void onError(Throwable th2) {
            try {
                this.actual.onSuccess(this.resumeFunction.call(th2));
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.actual.onError(th3);
            }
        }

        public void onSuccess(T t11) {
            this.actual.onSuccess(t11);
        }
    }

    public SingleOnErrorReturn(Single.OnSubscribe<T> onSubscribe, Func1<Throwable, ? extends T> func1) {
        this.source = onSubscribe;
        this.resumeFunction = func1;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        OnErrorReturnsSingleSubscriber onErrorReturnsSingleSubscriber = new OnErrorReturnsSingleSubscriber(singleSubscriber, this.resumeFunction);
        singleSubscriber.add(onErrorReturnsSingleSubscriber);
        this.source.call(onErrorReturnsSingleSubscriber);
    }
}
