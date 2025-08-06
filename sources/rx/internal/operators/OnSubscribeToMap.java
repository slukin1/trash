package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OnSubscribeToMap<T, K, V> implements Observable.OnSubscribe<Map<K, V>>, Func0<Map<K, V>> {
    public final Func1<? super T, ? extends K> keySelector;
    public final Func0<? extends Map<K, V>> mapFactory;
    public final Observable<T> source;
    public final Func1<? super T, ? extends V> valueSelector;

    public static final class ToMapSubscriber<T, K, V> extends DeferredScalarSubscriberSafe<T, Map<K, V>> {
        public final Func1<? super T, ? extends K> keySelector;
        public final Func1<? super T, ? extends V> valueSelector;

        public ToMapSubscriber(Subscriber<? super Map<K, V>> subscriber, Map<K, V> map, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
            super(subscriber);
            this.value = map;
            this.hasValue = true;
            this.keySelector = func1;
            this.valueSelector = func12;
        }

        public void onNext(T t11) {
            if (!this.done) {
                try {
                    ((Map) this.value).put(this.keySelector.call(t11), this.valueSelector.call(t11));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    unsubscribe();
                    onError(th2);
                }
            }
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OnSubscribeToMap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(observable, func1, func12, (Func0) null);
    }

    public OnSubscribeToMap(Observable<T> observable, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, V>> func0) {
        this.source = observable;
        this.keySelector = func1;
        this.valueSelector = func12;
        if (func0 == null) {
            this.mapFactory = this;
        } else {
            this.mapFactory = func0;
        }
    }

    public Map<K, V> call() {
        return new HashMap();
    }

    public void call(Subscriber<? super Map<K, V>> subscriber) {
        try {
            new ToMapSubscriber(subscriber, (Map) this.mapFactory.call(), this.keySelector, this.valueSelector).subscribeTo(this.source);
        } catch (Throwable th2) {
            Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
        }
    }
}
