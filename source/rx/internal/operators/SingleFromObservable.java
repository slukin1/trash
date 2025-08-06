package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public final class SingleFromObservable<T> implements Single.OnSubscribe<T> {
    public final Observable.OnSubscribe<T> source;

    public static final class WrapSingleIntoSubscriber<T> extends Subscriber<T> {
        public static final int STATE_DONE = 2;
        public static final int STATE_EMPTY = 0;
        public static final int STATE_HAS_VALUE = 1;
        public final SingleSubscriber<? super T> actual;
        public int state;
        public T value;

        public WrapSingleIntoSubscriber(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
        }

        public void onCompleted() {
            int i11 = this.state;
            if (i11 == 0) {
                this.actual.onError(new NoSuchElementException());
            } else if (i11 == 1) {
                this.state = 2;
                T t11 = this.value;
                this.value = null;
                this.actual.onSuccess(t11);
            }
        }

        public void onError(Throwable th2) {
            if (this.state == 2) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.value = null;
            this.actual.onError(th2);
        }

        public void onNext(T t11) {
            int i11 = this.state;
            if (i11 == 0) {
                this.state = 1;
                this.value = t11;
            } else if (i11 == 1) {
                this.state = 2;
                this.actual.onError(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public SingleFromObservable(Observable.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        WrapSingleIntoSubscriber wrapSingleIntoSubscriber = new WrapSingleIntoSubscriber(singleSubscriber);
        singleSubscriber.add(wrapSingleIntoSubscriber);
        this.source.call(wrapSingleIntoSubscriber);
    }
}
