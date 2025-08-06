package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

final class FlowableReplay$Node extends AtomicReference<FlowableReplay$Node> {
    private static final long serialVersionUID = 245354315435971818L;
    public final long index;
    public final Object value;

    public FlowableReplay$Node(Object obj, long j11) {
        this.value = obj;
        this.index = j11;
    }
}
