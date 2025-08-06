package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> {
    public final AtomicReferenceArray<E> buffer;
    public final int mask;

    public AtomicReferenceArrayQueue(int i11) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i11);
        this.mask = roundToPowerOfTwo - 1;
        this.buffer = new AtomicReferenceArray<>(roundToPowerOfTwo);
    }

    public final int calcElementOffset(long j11) {
        return ((int) j11) & this.mask;
    }

    public final int calcElementOffset(long j11, int i11) {
        return ((int) j11) & i11;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final E lpElement(AtomicReferenceArray<E> atomicReferenceArray, int i11) {
        return atomicReferenceArray.get(i11);
    }

    public final E lvElement(AtomicReferenceArray<E> atomicReferenceArray, int i11) {
        return atomicReferenceArray.get(i11);
    }

    public final void soElement(AtomicReferenceArray<E> atomicReferenceArray, int i11, E e11) {
        atomicReferenceArray.lazySet(i11, e11);
    }

    public final void spElement(AtomicReferenceArray<E> atomicReferenceArray, int i11, E e11) {
        atomicReferenceArray.lazySet(i11, e11);
    }

    public final void svElement(AtomicReferenceArray<E> atomicReferenceArray, int i11, E e11) {
        atomicReferenceArray.set(i11, e11);
    }

    public final E lpElement(int i11) {
        return this.buffer.get(i11);
    }

    public final E lvElement(int i11) {
        return lvElement(this.buffer, i11);
    }

    public final void soElement(int i11, E e11) {
        this.buffer.lazySet(i11, e11);
    }

    public final void spElement(int i11, E e11) {
        this.buffer.lazySet(i11, e11);
    }
}
