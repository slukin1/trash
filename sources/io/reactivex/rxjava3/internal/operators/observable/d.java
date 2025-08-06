package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import n00.a;

public final class d<K, T> extends a<K, T> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableGroupBy$State<T, K> f55571c;

    public d(K k11, ObservableGroupBy$State<T, K> observableGroupBy$State) {
        super(k11);
        this.f55571c = observableGroupBy$State;
    }

    public static <T, K> d<K, T> c(K k11, int i11, ObservableGroupBy$GroupByObserver<?, K, T> observableGroupBy$GroupByObserver, boolean z11) {
        return new d<>(k11, new ObservableGroupBy$State(i11, observableGroupBy$GroupByObserver, k11, z11));
    }

    public void b(k<? super T> kVar) {
        this.f55571c.subscribe(kVar);
    }

    public void onComplete() {
        this.f55571c.onComplete();
    }

    public void onError(Throwable th2) {
        this.f55571c.onError(th2);
    }

    public void onNext(T t11) {
        this.f55571c.onNext(t11);
    }
}
