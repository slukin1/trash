package rx.internal.util.unsafe;

import java.util.Iterator;
import java.util.Objects;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

@SuppressAnimalSniffer
public class SpscUnboundedArrayQueue<E> extends SpscUnboundedArrayQueueConsumerField<E> implements QueueProgressIndicators {
    private static final long C_INDEX_OFFSET;
    private static final Object HAS_NEXT = new Object();
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final long P_INDEX_OFFSET;
    private static final long REF_ARRAY_BASE;
    private static final int REF_ELEMENT_SHIFT;

    static {
        Class<Object[]> cls = Object[].class;
        Unsafe unsafe = UnsafeAccess.UNSAFE;
        int arrayIndexScale = unsafe.arrayIndexScale(cls);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        REF_ARRAY_BASE = (long) unsafe.arrayBaseOffset(cls);
        try {
            P_INDEX_OFFSET = unsafe.objectFieldOffset(SpscUnboundedArrayQueueProducerFields.class.getDeclaredField("producerIndex"));
            try {
                C_INDEX_OFFSET = unsafe.objectFieldOffset(SpscUnboundedArrayQueueConsumerField.class.getDeclaredField("consumerIndex"));
            } catch (NoSuchFieldException e11) {
                InternalError internalError = new InternalError();
                internalError.initCause(e11);
                throw internalError;
            }
        } catch (NoSuchFieldException e12) {
            InternalError internalError2 = new InternalError();
            internalError2.initCause(e12);
            throw internalError2;
        }
    }

    public SpscUnboundedArrayQueue(int i11) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i11);
        long j11 = (long) (roundToPowerOfTwo - 1);
        E[] eArr = new Object[(roundToPowerOfTwo + 1)];
        this.producerBuffer = eArr;
        this.producerMask = j11;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = eArr;
        this.consumerMask = j11;
        this.producerLookAhead = j11 - 1;
        soProducerIndex(0);
    }

    private void adjustLookAheadStep(int i11) {
        this.producerLookAheadStep = Math.min(i11 / 4, MAX_LOOK_AHEAD_STEP);
    }

    private static long calcDirectOffset(long j11) {
        return REF_ARRAY_BASE + (j11 << REF_ELEMENT_SHIFT);
    }

    private static long calcWrappedOffset(long j11, long j12) {
        return calcDirectOffset(j11 & j12);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }

    private static <E> Object lvElement(E[] eArr, long j11) {
        return UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j11);
    }

    private E[] lvNext(E[] eArr) {
        return (Object[]) lvElement(eArr, calcDirectOffset((long) (eArr.length - 1)));
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    private E newBufferPeek(E[] eArr, long j11, long j12) {
        this.consumerBuffer = eArr;
        return lvElement(eArr, calcWrappedOffset(j11, j12));
    }

    private E newBufferPoll(E[] eArr, long j11, long j12) {
        this.consumerBuffer = eArr;
        long calcWrappedOffset = calcWrappedOffset(j11, j12);
        E lvElement = lvElement(eArr, calcWrappedOffset);
        if (lvElement == null) {
            return null;
        }
        soElement(eArr, calcWrappedOffset, (Object) null);
        soConsumerIndex(j11 + 1);
        return lvElement;
    }

    private void resize(E[] eArr, long j11, long j12, E e11, long j13) {
        E[] eArr2 = new Object[eArr.length];
        this.producerBuffer = eArr2;
        this.producerLookAhead = (j13 + j11) - 1;
        soElement(eArr2, j12, e11);
        soNext(eArr, eArr2);
        soElement(eArr, j12, HAS_NEXT);
        soProducerIndex(j11 + 1);
    }

    private void soConsumerIndex(long j11) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j11);
    }

    private static void soElement(Object[] objArr, long j11, Object obj) {
        UnsafeAccess.UNSAFE.putOrderedObject(objArr, j11, obj);
    }

    private void soNext(E[] eArr, E[] eArr2) {
        soElement(eArr, calcDirectOffset((long) (eArr.length - 1)), eArr2);
    }

    private void soProducerIndex(long j11) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j11);
    }

    private boolean writeToQueue(E[] eArr, E e11, long j11, long j12) {
        soElement(eArr, j12, e11);
        soProducerIndex(j11 + 1);
        return true;
    }

    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final boolean offer(E e11) {
        Objects.requireNonNull(e11, "Null is not a valid element");
        E[] eArr = this.producerBuffer;
        long j11 = this.producerIndex;
        long j12 = this.producerMask;
        long calcWrappedOffset = calcWrappedOffset(j11, j12);
        if (j11 < this.producerLookAhead) {
            return writeToQueue(eArr, e11, j11, calcWrappedOffset);
        }
        long j13 = ((long) this.producerLookAheadStep) + j11;
        if (lvElement(eArr, calcWrappedOffset(j13, j12)) == null) {
            this.producerLookAhead = j13 - 1;
            return writeToQueue(eArr, e11, j11, calcWrappedOffset);
        } else if (lvElement(eArr, calcWrappedOffset(1 + j11, j12)) != null) {
            return writeToQueue(eArr, e11, j11, calcWrappedOffset);
        } else {
            resize(eArr, j11, calcWrappedOffset, e11, j12);
            return true;
        }
    }

    public final E peek() {
        E[] eArr = this.consumerBuffer;
        long j11 = this.consumerIndex;
        long j12 = this.consumerMask;
        E lvElement = lvElement(eArr, calcWrappedOffset(j11, j12));
        if (lvElement != HAS_NEXT) {
            return lvElement;
        }
        return newBufferPeek(lvNext(eArr), j11, j12);
    }

    public final E poll() {
        E[] eArr = this.consumerBuffer;
        long j11 = this.consumerIndex;
        long j12 = this.consumerMask;
        long calcWrappedOffset = calcWrappedOffset(j11, j12);
        E lvElement = lvElement(eArr, calcWrappedOffset);
        boolean z11 = lvElement == HAS_NEXT;
        if (lvElement != null && !z11) {
            soElement(eArr, calcWrappedOffset, (Object) null);
            soConsumerIndex(j11 + 1);
            return lvElement;
        } else if (!z11) {
            return null;
        } else {
            return newBufferPoll(lvNext(eArr), j11, j12);
        }
    }

    public final int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }
}
