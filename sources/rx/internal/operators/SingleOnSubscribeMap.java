package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

public final class SingleOnSubscribeMap<T, R> implements Single.OnSubscribe<R> {
    public final Single<T> source;
    public final Func1<? super T, ? extends R> transformer;

    public static final class MapSubscriber<T, R> extends SingleSubscriber<T> {
        public final SingleSubscriber<? super R> actual;
        public boolean done;
        public final Func1<? super T, ? extends R> mapper;

        public MapSubscriber(SingleSubscriber<? super R> singleSubscriber, Func1<? super T, ? extends R> func1) {
            this.actual = singleSubscriber;
            this.mapper = func1;
        }

        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.done = true;
            this.actual.onError(th2);
        }

        public void onSuccess(T t11) {
            try {
                this.actual.onSuccess(this.mapper.call(t11));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th2, t11));
            }
        }
    }

    public SingleOnSubscribeMap(Single<T> single, Func1<? super T, ? extends R> func1) {
        this.source = single;
        this.transformer = func1;
    }

    public void call(SingleSubscriber<? super R> singleSubscriber) {
        MapSubscriber mapSubscriber = new MapSubscriber(singleSubscriber, this.transformer);
        singleSubscriber.add(mapSubscriber);
        this.source.subscribe(mapSubscriber);
    }
}
