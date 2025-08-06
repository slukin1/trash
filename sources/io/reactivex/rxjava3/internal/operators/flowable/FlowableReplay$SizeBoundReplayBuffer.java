package io.reactivex.rxjava3.internal.operators.flowable;

final class FlowableReplay$SizeBoundReplayBuffer<T> extends FlowableReplay$BoundedReplayBuffer<T> {
    private static final long serialVersionUID = -5898283885385201806L;
    public final int limit;

    public FlowableReplay$SizeBoundReplayBuffer(int i11, boolean z11) {
        super(z11);
        this.limit = i11;
    }

    public void truncate() {
        if (this.size > this.limit) {
            removeFirst();
        }
    }
}
