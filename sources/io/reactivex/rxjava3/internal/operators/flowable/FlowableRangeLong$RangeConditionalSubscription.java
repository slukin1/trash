package io.reactivex.rxjava3.internal.operators.flowable;

import k00.a;

final class FlowableRangeLong$RangeConditionalSubscription extends FlowableRangeLong$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    public final a<? super Long> downstream;

    public FlowableRangeLong$RangeConditionalSubscription(a<? super Long> aVar, long j11, long j12) {
        super(j11, j12);
        this.downstream = aVar;
    }

    public void fastPath() {
        long j11 = this.end;
        a<? super Long> aVar = this.downstream;
        long j12 = this.index;
        while (j12 != j11) {
            if (!this.cancelled) {
                aVar.tryOnNext(Long.valueOf(j12));
                j12++;
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            aVar.onComplete();
        }
    }

    public void slowPath(long j11) {
        long j12 = this.end;
        long j13 = this.index;
        a<? super Long> aVar = this.downstream;
        do {
            long j14 = 0;
            while (true) {
                if (j14 == j11 || j13 == j12) {
                    if (j13 != j12) {
                        j11 = get();
                        if (j14 == j11) {
                            this.index = j13;
                            j11 = addAndGet(-j14);
                        }
                    } else if (!this.cancelled) {
                        aVar.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    if (aVar.tryOnNext(Long.valueOf(j13))) {
                        j14++;
                    }
                    j13++;
                } else {
                    return;
                }
            }
        } while (j11 != 0);
    }
}
