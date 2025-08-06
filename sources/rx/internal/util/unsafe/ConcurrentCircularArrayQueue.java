package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

@SuppressAnimalSniffer
public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> {
    public static final int BUFFER_PAD = 32;
    private static final long REF_ARRAY_BASE;
    private static final int REF_ELEMENT_SHIFT;
    public static final int SPARSE_SHIFT;
    public final E[] buffer;
    public final long mask;

    static {
        Class<Object[]> cls = Object[].class;
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        SPARSE_SHIFT = intValue;
        Unsafe unsafe = UnsafeAccess.UNSAFE;
        int arrayIndexScale = unsafe.arrayIndexScale(cls);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = intValue + 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = intValue + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        REF_ARRAY_BASE = (long) (unsafe.arrayBaseOffset(cls) + (32 << (REF_ELEMENT_SHIFT - intValue)));
    }

    public ConcurrentCircularArrayQueue(int i11) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i11);
        this.mask = (long) (roundToPowerOfTwo - 1);
        this.buffer = new Object[((roundToPowerOfTwo << SPARSE_SHIFT) + 64)];
    }

    public final long calcElementOffset(long j11) {
        return calcElementOffset(j11, this.mask);
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

    public final E lpElement(long j11) {
        return lpElement(this.buffer, j11);
    }

    public final E lvElement(long j11) {
        return lvElement(this.buffer, j11);
    }

    public final void soElement(long j11, E e11) {
        soElement(this.buffer, j11, e11);
    }

    public final void spElement(long j11, E e11) {
        spElement(this.buffer, j11, e11);
    }

    public final long calcElementOffset(long j11, long j12) {
        return REF_ARRAY_BASE + ((j11 & j12) << REF_ELEMENT_SHIFT);
    }

    public final E lpElement(E[] eArr, long j11) {
        return UnsafeAccess.UNSAFE.getObject(eArr, j11);
    }

    public final E lvElement(E[] eArr, long j11) {
        return UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j11);
    }

    public final void soElement(E[] eArr, long j11, E e11) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j11, e11);
    }

    public final void spElement(E[] eArr, long j11, E e11) {
        UnsafeAccess.UNSAFE.putObject(eArr, j11, e11);
    }
}
