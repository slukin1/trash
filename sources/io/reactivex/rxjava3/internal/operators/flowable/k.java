package io.reactivex.rxjava3.internal.operators.flowable;

public interface k<T> {
    void complete();

    void error(Throwable th2);

    void next(T t11);

    void replay(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription);
}
