package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscAtomicArrayQueue<E> extends AtomicReferenceArrayQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public final AtomicLong consumerIndex = new AtomicLong();
    public final int lookAheadStep;
    public final AtomicLong producerIndex = new AtomicLong();
    public long producerLookAhead;

    public SpscAtomicArrayQueue(int i11) {
        super(i11);
        this.lookAheadStep = Math.min(i11 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private void soConsumerIndex(long j11) {
        this.consumerIndex.lazySet(j11);
    }

    private void soProducerIndex(long j11) {
        this.producerIndex.lazySet(j11);
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public boolean offer(E e11) {
        Objects.requireNonNull(e11, "Null is not a valid element");
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i11 = this.mask;
        long j11 = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j11, i11);
        if (j11 >= this.producerLookAhead) {
            long j12 = ((long) this.lookAheadStep) + j11;
            if (lvElement(atomicReferenceArray, calcElementOffset(j12, i11)) == null) {
                this.producerLookAhead = j12;
            } else if (lvElement(atomicReferenceArray, calcElementOffset) != null) {
                return false;
            }
        }
        soElement(atomicReferenceArray, calcElementOffset, e11);
        soProducerIndex(j11 + 1);
        return true;
    }

    public E peek() {
        return lvElement(calcElementOffset(this.consumerIndex.get()));
    }

    public E poll() {
        long j11 = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j11);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E lvElement = lvElement(atomicReferenceArray, calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soElement(atomicReferenceArray, calcElementOffset, null);
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
