package io.reactivex.rxjava3.internal.operators.maybe;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

final class MaybeMergeArray$MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements c<T> {
    private static final long serialVersionUID = -7969063454040569579L;
    public int consumerIndex;
    public final AtomicInteger producerIndex = new AtomicInteger();

    public MaybeMergeArray$MpscFillOnceSimpleQueue(int i11) {
        super(i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray$MpscFillOnceSimpleQueue.clear():void");
    }

    public int consumerIndex() {
        return this.consumerIndex;
    }

    public void drop() {
        int i11 = this.consumerIndex;
        lazySet(i11, (Object) null);
        this.consumerIndex = i11 + 1;
    }

    public boolean isEmpty() {
        return this.consumerIndex == producerIndex();
    }

    public boolean offer(T t11) {
        Objects.requireNonNull(t11, "value is null");
        int andIncrement = this.producerIndex.getAndIncrement();
        if (andIncrement >= length()) {
            return false;
        }
        lazySet(andIncrement, t11);
        return true;
    }

    public T peek() {
        int i11 = this.consumerIndex;
        if (i11 == length()) {
            return null;
        }
        return get(i11);
    }

    public T poll() {
        int i11 = this.consumerIndex;
        if (i11 == length()) {
            return null;
        }
        AtomicInteger atomicInteger = this.producerIndex;
        do {
            T t11 = get(i11);
            if (t11 != null) {
                this.consumerIndex = i11 + 1;
                lazySet(i11, (Object) null);
                return t11;
            }
        } while (atomicInteger.get() != i11);
        return null;
    }

    public int producerIndex() {
        return this.producerIndex.get();
    }

    public boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException();
    }
}
