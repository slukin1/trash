package rx.internal.util.unsafe;

import java.util.Objects;
import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
public final class SpscArrayQueue<E> extends SpscArrayQueueL3Pad<E> {
    public SpscArrayQueue(int i11) {
        super(i11);
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, SpscArrayQueueConsumerField.C_INDEX_OFFSET);
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, SpscArrayQueueProducerFields.P_INDEX_OFFSET);
    }

    private void soConsumerIndex(long j11) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, SpscArrayQueueConsumerField.C_INDEX_OFFSET, j11);
    }

    private void soProducerIndex(long j11) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, SpscArrayQueueProducerFields.P_INDEX_OFFSET, j11);
    }

    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    public boolean offer(E e11) {
        Objects.requireNonNull(e11, "null elements not allowed");
        E[] eArr = this.buffer;
        long j11 = this.producerIndex;
        long calcElementOffset = calcElementOffset(j11);
        if (lvElement(eArr, calcElementOffset) != null) {
            return false;
        }
        soElement(eArr, calcElementOffset, e11);
        soProducerIndex(j11 + 1);
        return true;
    }

    public E peek() {
        return lvElement(calcElementOffset(this.consumerIndex));
    }

    public E poll() {
        long j11 = this.consumerIndex;
        long calcElementOffset = calcElementOffset(j11);
        E[] eArr = this.buffer;
        E lvElement = lvElement(eArr, calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soElement(eArr, calcElementOffset, null);
        soConsumerIndex(j11 + 1);
        return lvElement;
    }

    public int size() {
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
