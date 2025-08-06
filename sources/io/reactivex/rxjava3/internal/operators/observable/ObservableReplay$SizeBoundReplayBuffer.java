package io.reactivex.rxjava3.internal.operators.observable;

final class ObservableReplay$SizeBoundReplayBuffer<T> extends ObservableReplay$BoundedReplayBuffer<T> {
    private static final long serialVersionUID = -5898283885385201806L;
    public final int limit;

    public ObservableReplay$SizeBoundReplayBuffer(int i11, boolean z11) {
        super(z11);
        this.limit = i11;
    }

    public void truncate() {
        if (this.size > this.limit) {
            removeFirst();
        }
    }
}
