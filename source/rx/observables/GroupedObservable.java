package rx.observables;

import rx.Observable;
import rx.Subscriber;

public class GroupedObservable<K, T> extends Observable<T> {
    private final K key;

    public GroupedObservable(K k11, Observable.OnSubscribe<T> onSubscribe) {
        super(onSubscribe);
        this.key = k11;
    }

    public static <K, T> GroupedObservable<K, T> create(K k11, Observable.OnSubscribe<T> onSubscribe) {
        return new GroupedObservable<>(k11, onSubscribe);
    }

    public static <K, T> GroupedObservable<K, T> from(K k11, final Observable<T> observable) {
        return new GroupedObservable<>(k11, new Observable.OnSubscribe<T>() {
            public void call(Subscriber<? super T> subscriber) {
                observable.unsafeSubscribe(subscriber);
            }
        });
    }

    public K getKey() {
        return this.key;
    }
}
