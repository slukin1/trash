package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;

final class ObservableRange$RangeDisposable extends BasicIntQueueDisposable<Integer> {
    private static final long serialVersionUID = 396518478098735504L;
    public final k<? super Integer> downstream;
    public final long end;
    public boolean fused;
    public long index;

    public ObservableRange$RangeDisposable(k<? super Integer> kVar, long j11, long j12) {
        this.downstream = kVar;
        this.index = j11;
        this.end = j12;
    }

    public void clear() {
        this.index = this.end;
        lazySet(1);
    }

    public void dispose() {
        set(1);
    }

    public boolean isDisposed() {
        return get() != 0;
    }

    public boolean isEmpty() {
        return this.index == this.end;
    }

    public int requestFusion(int i11) {
        if ((i11 & 1) == 0) {
            return 0;
        }
        this.fused = true;
        return 1;
    }

    public void run() {
        if (!this.fused) {
            k<? super Integer> kVar = this.downstream;
            long j11 = this.end;
            for (long j12 = this.index; j12 != j11 && get() == 0; j12++) {
                kVar.onNext(Integer.valueOf((int) j12));
            }
            if (get() == 0) {
                lazySet(1);
                kVar.onComplete();
            }
        }
    }

    public Integer poll() {
        long j11 = this.index;
        if (j11 != this.end) {
            this.index = 1 + j11;
            return Integer.valueOf((int) j11);
        }
        lazySet(1);
        return null;
    }
}
