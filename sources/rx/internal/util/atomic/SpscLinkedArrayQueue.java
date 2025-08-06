package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

public final class SpscLinkedArrayQueue<T> implements Queue<T> {
    private static final Object HAS_NEXT = new Object();
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public AtomicReferenceArray<Object> consumerBuffer;
    public final AtomicLong consumerIndex = new AtomicLong();
    public int consumerMask;
    public AtomicReferenceArray<Object> producerBuffer;
    public final AtomicLong producerIndex = new AtomicLong();
    public long producerLookAhead;
    public int producerLookAheadStep;
    public int producerMask;

    public SpscLinkedArrayQueue(int i11) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i11);
        int i12 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i12;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i12;
        this.producerLookAhead = (long) (i12 - 1);
    }

    private void adjustLookAheadStep(int i11) {
        this.producerLookAheadStep = Math.min(i11 / 4, MAX_LOOK_AHEAD_STEP);
    }

    private static int calcDirectOffset(int i11) {
        return i11;
    }

    private static int calcWrappedOffset(long j11, int i11) {
        return calcDirectOffset(((int) j11) & i11);
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i11) {
        return atomicReferenceArray.get(i11);
    }

    private AtomicReferenceArray<Object> lvNext(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1));
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11) {
        this.consumerBuffer = atomicReferenceArray;
        return lvElement(atomicReferenceArray, calcWrappedOffset(j11, i11));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11) {
        this.consumerBuffer = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j11, i11);
        T lvElement = lvElement(atomicReferenceArray, calcWrappedOffset);
        if (lvElement == null) {
            return null;
        }
        soElement(atomicReferenceArray, calcWrappedOffset, (Object) null);
        soConsumerIndex(j11 + 1);
        return lvElement;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11, T t11, long j12) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        this.producerLookAhead = (j12 + j11) - 1;
        soElement(atomicReferenceArray2, i11, t11);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i11, HAS_NEXT);
        soProducerIndex(j11 + 1);
    }

    private void soConsumerIndex(long j11) {
        this.consumerIndex.lazySet(j11);
    }

    private static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i11, Object obj) {
        atomicReferenceArray.lazySet(i11, obj);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void soProducerIndex(long j11) {
        this.producerIndex.lazySet(j11);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t11, long j11, int i11) {
        soElement(atomicReferenceArray, i11, t11);
        soProducerIndex(j11 + 1);
        return true;
    }

    public boolean add(T t11) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public T element() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(T t11) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lpProducerIndex = lpProducerIndex();
        int i11 = this.producerMask;
        int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i11);
        if (lpProducerIndex < this.producerLookAhead) {
            return writeToQueue(atomicReferenceArray, t11, lpProducerIndex, calcWrappedOffset);
        }
        long j11 = ((long) this.producerLookAheadStep) + lpProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j11, i11)) == null) {
            this.producerLookAhead = j11 - 1;
            return writeToQueue(atomicReferenceArray, t11, lpProducerIndex, calcWrappedOffset);
        } else if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i11)) == null) {
            return writeToQueue(atomicReferenceArray, t11, lpProducerIndex, calcWrappedOffset);
        } else {
            resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t11, (long) i11);
            return true;
        }
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i11 = this.consumerMask;
        T lvElement = lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i11));
        return lvElement == HAS_NEXT ? newBufferPeek(lvNext(atomicReferenceArray), lpConsumerIndex, i11) : lvElement;
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i11 = this.consumerMask;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i11);
        T lvElement = lvElement(atomicReferenceArray, calcWrappedOffset);
        boolean z11 = lvElement == HAS_NEXT;
        if (lvElement != null && !z11) {
            soElement(atomicReferenceArray, calcWrappedOffset, (Object) null);
            soConsumerIndex(lpConsumerIndex + 1);
            return lvElement;
        } else if (z11) {
            return newBufferPoll(lvNext(atomicReferenceArray), lpConsumerIndex, i11);
        } else {
            return null;
        }
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
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

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public T remove() {
        throw new UnsupportedOperationException();
    }

    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public boolean offer(T t11, T t12) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lvProducerIndex = lvProducerIndex();
        int i11 = this.producerMask;
        long j11 = 2 + lvProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j11, i11)) == null) {
            int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i11);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t12);
            soElement(atomicReferenceArray, calcWrappedOffset, t11);
            soProducerIndex(j11);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i11);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t12);
        soElement(atomicReferenceArray2, calcWrappedOffset2, t11);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        soProducerIndex(j11);
        return true;
    }
}
