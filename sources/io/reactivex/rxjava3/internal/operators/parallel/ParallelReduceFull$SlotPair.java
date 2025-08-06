package io.reactivex.rxjava3.internal.operators.parallel;

import java.util.concurrent.atomic.AtomicInteger;

final class ParallelReduceFull$SlotPair<T> extends AtomicInteger {
    private static final long serialVersionUID = 473971317683868662L;
    public T first;
    public final AtomicInteger releaseIndex = new AtomicInteger();
    public T second;

    public boolean releaseSlot() {
        return this.releaseIndex.incrementAndGet() == 2;
    }

    public int tryAcquireSlot() {
        int i11;
        do {
            i11 = get();
            if (i11 >= 2) {
                return -1;
            }
        } while (!compareAndSet(i11, i11 + 1));
        return i11;
    }
}
