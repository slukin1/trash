package rx.internal.operators;

import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class OperatorTakeUntilPredicate<T> implements Observable.Operator<T, T> {
    public final Func1<? super T, Boolean> stopPredicate;

    public final class ParentSubscriber extends Subscriber<T> {
        private final Subscriber<? super T> child;
        private boolean done;

        public ParentSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        public void downstreamRequest(long j11) {
            request(j11);
        }

        public void onCompleted() {
            if (!this.done) {
                this.child.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (!this.done) {
                this.child.onError(th2);
            }
        }

        public void onNext(T t11) {
            this.child.onNext(t11);
            try {
                if (OperatorTakeUntilPredicate.this.stopPredicate.call(t11).booleanValue()) {
                    this.done = true;
                    this.child.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th2) {
                this.done = true;
                Exceptions.throwOrReport(th2, (Observer<?>) this.child, (Object) t11);
                unsubscribe();
            }
        }
    }

    public OperatorTakeUntilPredicate(Func1<? super T, Boolean> func1) {
        this.stopPredicate = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.add(parentSubscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j11) {
                parentSubscriber.downstreamRequest(j11);
            }
        });
        return parentSubscriber;
    }
}
