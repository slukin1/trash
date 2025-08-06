package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

@SuppressAnimalSniffer
public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    private static final long ARRAY_BASE;
    private static final int ELEMENT_SHIFT;
    public final long[] sequenceBuffer;

    static {
        Class<long[]> cls = long[].class;
        Unsafe unsafe = UnsafeAccess.UNSAFE;
        if (8 == unsafe.arrayIndexScale(cls)) {
            int i11 = ConcurrentCircularArrayQueue.SPARSE_SHIFT;
            int i12 = i11 + 3;
            ELEMENT_SHIFT = i12;
            ARRAY_BASE = (long) (unsafe.arrayBaseOffset(cls) + (32 << (i12 - i11)));
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int i11) {
        super(i11);
        int i12 = (int) (this.mask + 1);
        this.sequenceBuffer = new long[((i12 << ConcurrentCircularArrayQueue.SPARSE_SHIFT) + 64)];
        for (long j11 = 0; j11 < ((long) i12); j11++) {
            soSequence(this.sequenceBuffer, calcSequenceOffset(j11), j11);
        }
    }

    public final long calcSequenceOffset(long j11) {
        return ARRAY_BASE + ((j11 & this.mask) << ELEMENT_SHIFT);
    }

    public final long lvSequence(long[] jArr, long j11) {
        return UnsafeAccess.UNSAFE.getLongVolatile(jArr, j11);
    }

    public final void soSequence(long[] jArr, long j11, long j12) {
        UnsafeAccess.UNSAFE.putOrderedLong(jArr, j11, j12);
    }
}
