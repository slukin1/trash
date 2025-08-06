package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;

public final class x<T> {
    private volatile AtomicReferenceArray<T> array;

    public x(int i11) {
        this.array = new AtomicReferenceArray<>(i11);
    }

    public final int a() {
        return this.array.length();
    }

    public final T b(int i11) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i11 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i11);
        }
        return null;
    }

    public final void c(int i11, T t11) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i11 < length) {
            atomicReferenceArray.set(i11, t11);
            return;
        }
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(RangesKt___RangesKt.d(i11 + 1, length * 2));
        for (int i12 = 0; i12 < length; i12++) {
            atomicReferenceArray2.set(i12, atomicReferenceArray.get(i12));
        }
        atomicReferenceArray2.set(i11, t11);
        this.array = atomicReferenceArray2;
    }
}
