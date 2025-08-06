package io.reactivex.rxjava3.internal.operators.flowable;

import z20.c;

final class FlowableRangeLong$RangeSubscription extends FlowableRangeLong$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    public final c<? super Long> downstream;

    public FlowableRangeLong$RangeSubscription(c<? super Long> cVar, long j11, long j12) {
        super(j11, j12);
        this.downstream = cVar;
    }

    public void fastPath() {
        long j11 = this.end;
        c<? super Long> cVar = this.downstream;
        long j12 = this.index;
        while (j12 != j11) {
            if (!this.cancelled) {
                cVar.onNext(Long.valueOf(j12));
                j12++;
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            cVar.onComplete();
        }
    }

    public void slowPath(long j11) {
        long j12 = this.end;
        long j13 = this.index;
        c<? super Long> cVar = this.downstream;
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
                        cVar.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    cVar.onNext(Long.valueOf(j13));
                    j14++;
                    j13++;
                } else {
                    return;
                }
            }
        } while (j11 != 0);
    }
}
