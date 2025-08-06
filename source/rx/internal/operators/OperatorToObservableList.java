package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableList<T> implements Observable.Operator<List<T>, T> {

    public static final class Holder {
        public static final OperatorToObservableList<Object> INSTANCE = new OperatorToObservableList<>();
    }

    public static <T> OperatorToObservableList<T> instance() {
        return Holder.INSTANCE;
    }

    public Subscriber<? super T> call(final Subscriber<? super List<T>> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        AnonymousClass1 r12 = new Subscriber<T>() {
            public boolean completed;
            public List<T> list = new LinkedList();

            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    try {
                        ArrayList arrayList = new ArrayList(this.list);
                        this.list = null;
                        singleDelayedProducer.setValue(arrayList);
                    } catch (Throwable th2) {
                        Exceptions.throwOrReport(th2, (Observer<?>) this);
                    }
                }
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                if (!this.completed) {
                    this.list.add(t11);
                }
            }

            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
        subscriber.add(r12);
        subscriber.setProducer(singleDelayedProducer);
        return r12;
    }
}
