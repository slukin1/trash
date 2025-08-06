package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.plugins.RxJavaPlugins;

final class ResultOnSubscribe<T> implements Observable.OnSubscribe<Result<T>> {
    private final Observable.OnSubscribe<Response<T>> upstream;

    public static class ResultSubscriber<R> extends Subscriber<Response<R>> {
        private final Subscriber<? super Result<R>> subscriber;

        public ResultSubscriber(Subscriber<? super Result<R>> subscriber2) {
            super(subscriber2);
            this.subscriber = subscriber2;
        }

        public void onCompleted() {
            this.subscriber.onCompleted();
        }

        public void onError(Throwable th2) {
            try {
                this.subscriber.onNext(Result.error(th2));
                this.subscriber.onCompleted();
            } catch (Throwable th3) {
                try {
                    this.subscriber.onError(th3);
                } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e11) {
                    RxJavaPlugins.getInstance().getErrorHandler().handleError(e11);
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    RxJavaPlugins.getInstance().getErrorHandler().handleError(new CompositeException(th3, th4));
                }
            }
        }

        public void onNext(Response<R> response) {
            this.subscriber.onNext(Result.response(response));
        }
    }

    public ResultOnSubscribe(Observable.OnSubscribe<Response<T>> onSubscribe) {
        this.upstream = onSubscribe;
    }

    public void call(Subscriber<? super Result<T>> subscriber) {
        this.upstream.call(new ResultSubscriber(subscriber));
    }
}
