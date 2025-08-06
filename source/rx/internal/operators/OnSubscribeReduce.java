package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeReduce<T> implements Observable.OnSubscribe<T> {
    public final Func2<T, T, T> reducer;
    public final Observable<T> source;

    public static final class ReduceSubscriber<T> extends Subscriber<T> {
        public static final Object EMPTY = new Object();
        public final Subscriber<? super T> actual;
        public boolean done;
        public final Func2<T, T, T> reducer;
        public T value = EMPTY;

        public ReduceSubscriber(Subscriber<? super T> subscriber, Func2<T, T, T> func2) {
            this.actual = subscriber;
            this.reducer = func2;
            request(0);
        }

        public void downstreamRequest(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j11);
            } else if (i11 != 0) {
                request(Long.MAX_VALUE);
            }
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                T t11 = this.value;
                if (t11 != EMPTY) {
                    this.actual.onNext(t11);
                    this.actual.onCompleted();
                    return;
                }
                this.actual.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            if (!this.done) {
                this.done = true;
                this.actual.onError(th2);
                return;
            }
            RxJavaHooks.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.done) {
                T t12 = this.value;
                if (t12 == EMPTY) {
                    this.value = t11;
                    return;
                }
                try {
                    this.value = this.reducer.call(t12, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    unsubscribe();
                    onError(th2);
                }
            }
        }
    }

    public OnSubscribeReduce(Observable<T> observable, Func2<T, T, T> func2) {
        this.source = observable;
        this.reducer = func2;
    }

    public void call(Subscriber<? super T> subscriber) {
        final ReduceSubscriber reduceSubscriber = new ReduceSubscriber(subscriber, this.reducer);
        subscriber.add(reduceSubscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j11) {
                reduceSubscriber.downstreamRequest(j11);
            }
        });
        this.source.unsafeSubscribe(reduceSubscriber);
    }
}
