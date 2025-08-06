package rx.internal.operators;

import rx.Completable;
import rx.CompletableSubscriber;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class CompletableFlatMapSingleToCompletable<T> implements Completable.OnSubscribe {
    public final Func1<? super T, ? extends Completable> mapper;
    public final Single<T> source;

    public static final class SourceSubscriber<T> extends SingleSubscriber<T> implements CompletableSubscriber {
        public final CompletableSubscriber actual;
        public final Func1<? super T, ? extends Completable> mapper;

        public SourceSubscriber(CompletableSubscriber completableSubscriber, Func1<? super T, ? extends Completable> func1) {
            this.actual = completableSubscriber;
            this.mapper = func1;
        }

        public void onCompleted() {
            this.actual.onCompleted();
        }

        public void onError(Throwable th2) {
            this.actual.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            add(subscription);
        }

        public void onSuccess(T t11) {
            try {
                Completable completable = (Completable) this.mapper.call(t11);
                if (completable == null) {
                    onError(new NullPointerException("The mapper returned a null Completable"));
                } else {
                    completable.subscribe((CompletableSubscriber) this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public CompletableFlatMapSingleToCompletable(Single<T> single, Func1<? super T, ? extends Completable> func1) {
        this.source = single;
        this.mapper = func1;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        SourceSubscriber sourceSubscriber = new SourceSubscriber(completableSubscriber, this.mapper);
        completableSubscriber.onSubscribe(sourceSubscriber);
        this.source.subscribe(sourceSubscriber);
    }
}
