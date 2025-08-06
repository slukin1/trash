package io.reactivex.rxjava3.internal.operators.observable;

public interface e {
    void innerClose(boolean z11, ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver);

    void innerCloseError(Throwable th2);

    void innerComplete(ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver);

    void innerError(Throwable th2);

    void innerValue(boolean z11, Object obj);
}
