package io.reactivex.rxjava3.internal.operators.flowable;

import z20.c;

final class FlowableFromArray$ArraySubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    private static final long serialVersionUID = 2587302975077663557L;
    public final c<? super T> downstream;

    public FlowableFromArray$ArraySubscription(c<? super T> cVar, T[] tArr) {
        super(tArr);
        this.downstream = cVar;
    }

    public void fastPath() {
        T[] tArr = this.array;
        int length = tArr.length;
        c<? super T> cVar = this.downstream;
        int i11 = this.index;
        while (i11 != length) {
            if (!this.cancelled) {
                T t11 = tArr[i11];
                if (t11 == null) {
                    cVar.onError(new NullPointerException("The element at index " + i11 + " is null"));
                    return;
                }
                cVar.onNext(t11);
                i11++;
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            cVar.onComplete();
        }
    }

    public void slowPath(long j11) {
        T[] tArr = this.array;
        int length = tArr.length;
        int i11 = this.index;
        c<? super T> cVar = this.downstream;
        do {
            long j12 = 0;
            while (true) {
                if (j12 == j11 || i11 == length) {
                    if (i11 != length) {
                        j11 = get();
                        if (j12 == j11) {
                            this.index = i11;
                            j11 = addAndGet(-j12);
                        }
                    } else if (!this.cancelled) {
                        cVar.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    T t11 = tArr[i11];
                    if (t11 == null) {
                        cVar.onError(new NullPointerException("The element at index " + i11 + " is null"));
                        return;
                    }
                    cVar.onNext(t11);
                    j12++;
                    i11++;
                } else {
                    return;
                }
            }
        } while (j11 != 0);
    }
}
