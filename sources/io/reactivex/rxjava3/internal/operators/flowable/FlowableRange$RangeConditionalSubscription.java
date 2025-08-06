package io.reactivex.rxjava3.internal.operators.flowable;

import k00.a;

final class FlowableRange$RangeConditionalSubscription extends FlowableRange$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    public final a<? super Integer> downstream;

    public FlowableRange$RangeConditionalSubscription(a<? super Integer> aVar, int i11, int i12) {
        super(i11, i12);
        this.downstream = aVar;
    }

    public void fastPath() {
        int i11 = this.end;
        a<? super Integer> aVar = this.downstream;
        int i12 = this.index;
        while (i12 != i11) {
            if (!this.cancelled) {
                aVar.tryOnNext(Integer.valueOf(i12));
                i12++;
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            aVar.onComplete();
        }
    }

    public void slowPath(long j11) {
        int i11 = this.end;
        int i12 = this.index;
        a<? super Integer> aVar = this.downstream;
        do {
            long j12 = 0;
            while (true) {
                if (j12 == j11 || i12 == i11) {
                    if (i12 != i11) {
                        j11 = get();
                        if (j12 == j11) {
                            this.index = i12;
                            j11 = addAndGet(-j12);
                        }
                    } else if (!this.cancelled) {
                        aVar.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    if (aVar.tryOnNext(Integer.valueOf(i12))) {
                        j12++;
                    }
                    i12++;
                } else {
                    return;
                }
            }
        } while (j11 != 0);
    }
}
