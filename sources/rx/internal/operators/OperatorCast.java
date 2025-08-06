package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.plugins.RxJavaHooks;

public class OperatorCast<T, R> implements Observable.Operator<R, T> {
    public final Class<R> castClass;

    public static final class CastSubscriber<T, R> extends Subscriber<T> {
        public final Subscriber<? super R> actual;
        public final Class<R> castClass;
        public boolean done;

        public CastSubscriber(Subscriber<? super R> subscriber, Class<R> cls) {
            this.actual = subscriber;
            this.castClass = cls;
        }

        public void onCompleted() {
            if (!this.done) {
                this.actual.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.done = true;
            this.actual.onError(th2);
        }

        public void onNext(T t11) {
            try {
                this.actual.onNext(this.castClass.cast(t11));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th2, t11));
            }
        }

        public void setProducer(Producer producer) {
            this.actual.setProducer(producer);
        }
    }

    public OperatorCast(Class<R> cls) {
        this.castClass = cls;
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        CastSubscriber castSubscriber = new CastSubscriber(subscriber, this.castClass);
        subscriber.add(castSubscriber);
        return castSubscriber;
    }
}
