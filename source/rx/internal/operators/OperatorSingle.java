package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;
import rx.internal.producers.SingleProducer;
import rx.plugins.RxJavaHooks;

public final class OperatorSingle<T> implements Observable.Operator<T, T> {
    private final T defaultValue;
    private final boolean hasDefaultValue;

    public static final class Holder {
        public static final OperatorSingle<?> INSTANCE = new OperatorSingle<>();
    }

    public static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> child;
        private final T defaultValue;
        private final boolean hasDefaultValue;
        private boolean hasTooManyElements;
        private boolean isNonEmpty;
        private T value;

        public ParentSubscriber(Subscriber<? super T> subscriber, boolean z11, T t11) {
            this.child = subscriber;
            this.hasDefaultValue = z11;
            this.defaultValue = t11;
            request(2);
        }

        public void onCompleted() {
            if (this.hasTooManyElements) {
                return;
            }
            if (this.isNonEmpty) {
                this.child.setProducer(new SingleProducer(this.child, this.value));
            } else if (this.hasDefaultValue) {
                this.child.setProducer(new SingleProducer(this.child, this.defaultValue));
            } else {
                this.child.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        public void onError(Throwable th2) {
            if (this.hasTooManyElements) {
                RxJavaHooks.onError(th2);
            } else {
                this.child.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (this.hasTooManyElements) {
                return;
            }
            if (this.isNonEmpty) {
                this.hasTooManyElements = true;
                this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
                return;
            }
            this.value = t11;
            this.isNonEmpty = true;
        }
    }

    public OperatorSingle() {
        this(false, (Object) null);
    }

    public static <T> OperatorSingle<T> instance() {
        return Holder.INSTANCE;
    }

    public OperatorSingle(T t11) {
        this(true, t11);
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber, this.hasDefaultValue, this.defaultValue);
        subscriber.add(parentSubscriber);
        return parentSubscriber;
    }

    private OperatorSingle(boolean z11, T t11) {
        this.hasDefaultValue = z11;
        this.defaultValue = t11;
    }
}
