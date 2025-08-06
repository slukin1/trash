package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;
    public final int capacitySkip;
    public final AtomicLong consumerIndex = new AtomicLong();
    public final int mask;
    public final AtomicLong producerIndex = new AtomicLong();

    public SpscExactAtomicArrayQueue(int i11) {
        super(Pow2.roundToPowerOfTwo(i11));
        int length = length();
        this.mask = length - 1;
        this.capacitySkip = length - i11;
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
        return this.producerIndex == this.consumerIndex;
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(T t11) {
        Objects.requireNonNull(t11);
        long j11 = this.producerIndex.get();
        int i11 = this.mask;
        if (get(((int) (((long) this.capacitySkip) + j11)) & i11) != null) {
            return false;
        }
        this.producerIndex.lazySet(j11 + 1);
        lazySet(i11 & ((int) j11), t11);
        return true;
    }

    public T peek() {
        return get(((int) this.consumerIndex.get()) & this.mask);
    }

    public T poll() {
        long j11 = this.consumerIndex.get();
        int i11 = ((int) j11) & this.mask;
        T t11 = get(i11);
        if (t11 == null) {
            return null;
        }
        this.consumerIndex.lazySet(j11 + 1);
        lazySet(i11, (Object) null);
        return t11;
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
        long j11 = this.consumerIndex.get();
        while (true) {
            long j12 = this.producerIndex.get();
            long j13 = this.consumerIndex.get();
            if (j11 == j13) {
                return (int) (j12 - j13);
            }
            j11 = j13;
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
}
