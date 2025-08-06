package io.reactivex.rxjava3.internal.operators.flowable;

import i00.a;
import z20.c;

public final class f<K, T> extends a<K, T> {

    /* renamed from: d  reason: collision with root package name */
    public final FlowableGroupBy$State<T, K> f55516d;

    public f(K k11, FlowableGroupBy$State<T, K> flowableGroupBy$State) {
        super(k11);
        this.f55516d = flowableGroupBy$State;
    }

    public static <T, K> f<K, T> m(K k11, int i11, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, boolean z11) {
        return new f<>(k11, new FlowableGroupBy$State(i11, flowableGroupBy$GroupBySubscriber, k11, z11));
    }

    public void j(c<? super T> cVar) {
        this.f55516d.subscribe(cVar);
    }

    public void onComplete() {
        this.f55516d.onComplete();
    }

    public void onError(Throwable th2) {
        this.f55516d.onError(th2);
    }

    public void onNext(T t11) {
        this.f55516d.onNext(t11);
    }
}
