package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OperatorElementAt<T> implements Observable.Operator<T, T> {
    public final T defaultValue;
    public final boolean hasDefault;
    public final int index;

    public static class InnerProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 1;
        public final Producer actual;

        public InnerProducer(Producer producer) {
            this.actual = producer;
        }

        public void request(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            } else if (i11 > 0 && compareAndSet(false, true)) {
                this.actual.request(Long.MAX_VALUE);
            }
        }
    }

    public OperatorElementAt(int i11) {
        this(i11, (Object) null, false);
    }

    public OperatorElementAt(int i11, T t11) {
        this(i11, t11, true);
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        AnonymousClass1 r02 = new Subscriber<T>() {
            private int currentIndex;

            public void onCompleted() {
                int i11 = this.currentIndex;
                OperatorElementAt operatorElementAt = OperatorElementAt.this;
                if (i11 > operatorElementAt.index) {
                    return;
                }
                if (operatorElementAt.hasDefault) {
                    subscriber.onNext(operatorElementAt.defaultValue);
                    subscriber.onCompleted();
                    return;
                }
                Subscriber subscriber = subscriber;
                subscriber.onError(new IndexOutOfBoundsException(OperatorElementAt.this.index + " is out of bounds"));
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                int i11 = this.currentIndex;
                this.currentIndex = i11 + 1;
                if (i11 == OperatorElementAt.this.index) {
                    subscriber.onNext(t11);
                    subscriber.onCompleted();
                    unsubscribe();
                }
            }

            public void setProducer(Producer producer) {
                subscriber.setProducer(new InnerProducer(producer));
            }
        };
        subscriber.add(r02);
        return r02;
    }

    private OperatorElementAt(int i11, T t11, boolean z11) {
        if (i11 >= 0) {
            this.index = i11;
            this.defaultValue = t11;
            this.hasDefault = z11;
            return;
        }
        throw new IndexOutOfBoundsException(i11 + " is out of bounds");
    }
}
