package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorToObservableSortedList<T> implements Observable.Operator<List<T>, T> {
    private static final Comparator DEFAULT_SORT_FUNCTION = new DefaultComparableFunction();
    public final int initialCapacity;
    public final Comparator<? super T> sortFunction;

    public static final class DefaultComparableFunction implements Comparator<Object> {
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    public OperatorToObservableSortedList(int i11) {
        this.sortFunction = DEFAULT_SORT_FUNCTION;
        this.initialCapacity = i11;
    }

    public Subscriber<? super T> call(final Subscriber<? super List<T>> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        AnonymousClass2 r12 = new Subscriber<T>() {
            public boolean completed;
            public List<T> list;

            {
                this.list = new ArrayList(OperatorToObservableSortedList.this.initialCapacity);
            }

            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    List<T> list2 = this.list;
                    this.list = null;
                    try {
                        Collections.sort(list2, OperatorToObservableSortedList.this.sortFunction);
                        singleDelayedProducer.setValue(list2);
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

    public OperatorToObservableSortedList(final Func2<? super T, ? super T, Integer> func2, int i11) {
        this.initialCapacity = i11;
        this.sortFunction = new Comparator<T>() {
            public int compare(T t11, T t12) {
                return ((Integer) func2.call(t11, t12)).intValue();
            }
        };
    }
}
