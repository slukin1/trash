package io.reactivex.rxjava3.internal.operators.flowable;

public interface g {
    void innerClose(boolean z11, FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber);

    void innerCloseError(Throwable th2);

    void innerComplete(FlowableGroupJoin$LeftRightSubscriber flowableGroupJoin$LeftRightSubscriber);

    void innerError(Throwable th2);

    void innerValue(boolean z11, Object obj);
}
