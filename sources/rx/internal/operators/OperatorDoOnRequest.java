package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action1;

public class OperatorDoOnRequest<T> implements Observable.Operator<T, T> {
    public final Action1<? super Long> request;

    public static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> child;

        public ParentSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            request(0);
        }

        /* access modifiers changed from: private */
        public void requestMore(long j11) {
            request(j11);
        }

        public void onCompleted() {
            this.child.onCompleted();
        }

        public void onError(Throwable th2) {
            this.child.onError(th2);
        }

        public void onNext(T t11) {
            this.child.onNext(t11);
        }
    }

    public OperatorDoOnRequest(Action1<? super Long> action1) {
        this.request = action1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j11) {
                OperatorDoOnRequest.this.request.call(Long.valueOf(j11));
                parentSubscriber.requestMore(j11);
            }
        });
        subscriber.add(parentSubscriber);
        return parentSubscriber;
    }
}
