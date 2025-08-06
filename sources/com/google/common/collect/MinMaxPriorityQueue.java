package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
@Beta
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int EVEN_POWERS_OF_TWO = 1431655765;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private final MinMaxPriorityQueue<E>.Heap maxHeap;
    @VisibleForTesting
    public final int maximumSize;
    private final MinMaxPriorityQueue<E>.Heap minHeap;
    /* access modifiers changed from: private */
    public int modCount;
    /* access modifiers changed from: private */
    public Object[] queue;
    /* access modifiers changed from: private */
    public int size;

    @Beta
    public static final class Builder<B> {
        private static final int UNSET_EXPECTED_SIZE = -1;
        private final Comparator<B> comparator;
        private int expectedSize;
        /* access modifiers changed from: private */
        public int maximumSize;

        /* access modifiers changed from: private */
        public <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i11) {
            Preconditions.checkArgument(i11 >= 0);
            this.expectedSize = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i11) {
            Preconditions.checkArgument(i11 > 0);
            this.maximumSize = i11;
            return this;
        }

        private Builder(Comparator<B> comparator2) {
            this.expectedSize = -1;
            this.maximumSize = Integer.MAX_VALUE;
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable));
            for (Object offer : iterable) {
                minMaxPriorityQueue.offer(offer);
            }
            return minMaxPriorityQueue;
        }
    }

    public class Heap {
        public final Ordering<E> ordering;
        @Weak
        public MinMaxPriorityQueue<E>.Heap otherHeap;

        public Heap(Ordering<E> ordering2) {
            this.ordering = ordering2;
        }

        private int getGrandparentIndex(int i11) {
            return getParentIndex(getParentIndex(i11));
        }

        private int getLeftChildIndex(int i11) {
            return (i11 * 2) + 1;
        }

        private int getParentIndex(int i11) {
            return (i11 - 1) / 2;
        }

        private int getRightChildIndex(int i11) {
            return (i11 * 2) + 2;
        }

        /* access modifiers changed from: private */
        public boolean verifyIndex(int i11) {
            if (getLeftChildIndex(i11) < MinMaxPriorityQueue.this.size && compareElements(i11, getLeftChildIndex(i11)) > 0) {
                return false;
            }
            if (getRightChildIndex(i11) < MinMaxPriorityQueue.this.size && compareElements(i11, getRightChildIndex(i11)) > 0) {
                return false;
            }
            if (i11 > 0 && compareElements(i11, getParentIndex(i11)) > 0) {
                return false;
            }
            if (i11 <= 2 || compareElements(getGrandparentIndex(i11), i11) <= 0) {
                return true;
            }
            return false;
        }

        public void bubbleUp(int i11, E e11) {
            Heap heap;
            int crossOverUp = crossOverUp(i11, e11);
            if (crossOverUp == i11) {
                crossOverUp = i11;
                heap = this;
            } else {
                heap = this.otherHeap;
            }
            heap.bubbleUpAlternatingLevels(crossOverUp, e11);
        }

        @CanIgnoreReturnValue
        public int bubbleUpAlternatingLevels(int i11, E e11) {
            while (i11 > 2) {
                int grandparentIndex = getGrandparentIndex(i11);
                Object elementData = MinMaxPriorityQueue.this.elementData(grandparentIndex);
                if (this.ordering.compare(elementData, e11) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.queue[i11] = elementData;
                i11 = grandparentIndex;
            }
            MinMaxPriorityQueue.this.queue[i11] = e11;
            return i11;
        }

        public int compareElements(int i11, int i12) {
            return this.ordering.compare(MinMaxPriorityQueue.this.elementData(i11), MinMaxPriorityQueue.this.elementData(i12));
        }

        public int crossOver(int i11, E e11) {
            int findMinChild = findMinChild(i11);
            if (findMinChild <= 0 || this.ordering.compare(MinMaxPriorityQueue.this.elementData(findMinChild), e11) >= 0) {
                return crossOverUp(i11, e11);
            }
            MinMaxPriorityQueue.this.queue[i11] = MinMaxPriorityQueue.this.elementData(findMinChild);
            MinMaxPriorityQueue.this.queue[findMinChild] = e11;
            return findMinChild;
        }

        public int crossOverUp(int i11, E e11) {
            int rightChildIndex;
            if (i11 == 0) {
                MinMaxPriorityQueue.this.queue[0] = e11;
                return 0;
            }
            int parentIndex = getParentIndex(i11);
            Object elementData = MinMaxPriorityQueue.this.elementData(parentIndex);
            if (!(parentIndex == 0 || (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) == parentIndex || getLeftChildIndex(rightChildIndex) < MinMaxPriorityQueue.this.size)) {
                Object elementData2 = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData2, elementData) < 0) {
                    parentIndex = rightChildIndex;
                    elementData = elementData2;
                }
            }
            if (this.ordering.compare(elementData, e11) < 0) {
                MinMaxPriorityQueue.this.queue[i11] = elementData;
                MinMaxPriorityQueue.this.queue[parentIndex] = e11;
                return parentIndex;
            }
            MinMaxPriorityQueue.this.queue[i11] = e11;
            return i11;
        }

        public int fillHoleAt(int i11) {
            while (true) {
                int findMinGrandChild = findMinGrandChild(i11);
                if (findMinGrandChild <= 0) {
                    return i11;
                }
                MinMaxPriorityQueue.this.queue[i11] = MinMaxPriorityQueue.this.elementData(findMinGrandChild);
                i11 = findMinGrandChild;
            }
        }

        public int findMin(int i11, int i12) {
            if (i11 >= MinMaxPriorityQueue.this.size) {
                return -1;
            }
            Preconditions.checkState(i11 > 0);
            int min = Math.min(i11, MinMaxPriorityQueue.this.size - i12) + i12;
            for (int i13 = i11 + 1; i13 < min; i13++) {
                if (compareElements(i13, i11) < 0) {
                    i11 = i13;
                }
            }
            return i11;
        }

        public int findMinChild(int i11) {
            return findMin(getLeftChildIndex(i11), 2);
        }

        public int findMinGrandChild(int i11) {
            int leftChildIndex = getLeftChildIndex(i11);
            if (leftChildIndex < 0) {
                return -1;
            }
            return findMin(getLeftChildIndex(leftChildIndex), 4);
        }

        public int swapWithConceptuallyLastElement(E e11) {
            int rightChildIndex;
            int parentIndex = getParentIndex(MinMaxPriorityQueue.this.size);
            if (!(parentIndex == 0 || (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) == parentIndex || getLeftChildIndex(rightChildIndex) < MinMaxPriorityQueue.this.size)) {
                Object elementData = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData, e11) < 0) {
                    MinMaxPriorityQueue.this.queue[rightChildIndex] = e11;
                    MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = elementData;
                    return rightChildIndex;
                }
            }
            return MinMaxPriorityQueue.this.size;
        }

        public MoveDesc<E> tryCrossOverAndBubbleUp(int i11, int i12, E e11) {
            Object obj;
            int crossOver = crossOver(i12, e11);
            if (crossOver == i12) {
                return null;
            }
            if (crossOver < i11) {
                obj = MinMaxPriorityQueue.this.elementData(i11);
            } else {
                obj = MinMaxPriorityQueue.this.elementData(getParentIndex(i11));
            }
            if (this.otherHeap.bubbleUpAlternatingLevels(crossOver, e11) < i11) {
                return new MoveDesc<>(e11, obj);
            }
            return null;
        }
    }

    public static class MoveDesc<E> {
        public final E replaced;
        public final E toTrickle;

        public MoveDesc(E e11, E e12) {
            this.toTrickle = e11;
            this.replaced = e12;
        }
    }

    public class QueueIterator implements Iterator<E> {
        private boolean canRemove;
        private int cursor;
        private int expectedModCount;
        private Queue<E> forgetMeNot;
        private E lastFromForgetMeNot;
        private int nextCursor;
        private List<E> skipMe;

        private QueueIterator() {
            this.cursor = -1;
            this.nextCursor = -1;
            this.expectedModCount = MinMaxPriorityQueue.this.modCount;
        }

        private void checkModCount() {
            if (MinMaxPriorityQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean foundAndRemovedExactReference(Iterable<E> iterable, E e11) {
            Iterator<E> it2 = iterable.iterator();
            while (it2.hasNext()) {
                if (it2.next() == e11) {
                    it2.remove();
                    return true;
                }
            }
            return false;
        }

        private void nextNotInSkipMe(int i11) {
            if (this.nextCursor < i11) {
                if (this.skipMe != null) {
                    while (i11 < MinMaxPriorityQueue.this.size() && foundAndRemovedExactReference(this.skipMe, MinMaxPriorityQueue.this.elementData(i11))) {
                        i11++;
                    }
                }
                this.nextCursor = i11;
            }
        }

        private boolean removeExact(Object obj) {
            for (int i11 = 0; i11 < MinMaxPriorityQueue.this.size; i11++) {
                if (MinMaxPriorityQueue.this.queue[i11] == obj) {
                    MinMaxPriorityQueue.this.removeAt(i11);
                    return true;
                }
            }
            return false;
        }

        public boolean hasNext() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                return true;
            }
            Queue<E> queue = this.forgetMeNot;
            if (queue == null || queue.isEmpty()) {
                return false;
            }
            return true;
        }

        public E next() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                int i11 = this.nextCursor;
                this.cursor = i11;
                this.canRemove = true;
                return MinMaxPriorityQueue.this.elementData(i11);
            }
            if (this.forgetMeNot != null) {
                this.cursor = MinMaxPriorityQueue.this.size();
                E poll = this.forgetMeNot.poll();
                this.lastFromForgetMeNot = poll;
                if (poll != null) {
                    this.canRemove = true;
                    return poll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            checkModCount();
            this.canRemove = false;
            this.expectedModCount++;
            if (this.cursor < MinMaxPriorityQueue.this.size()) {
                MoveDesc removeAt = MinMaxPriorityQueue.this.removeAt(this.cursor);
                if (removeAt != null) {
                    if (this.forgetMeNot == null) {
                        this.forgetMeNot = new ArrayDeque();
                        this.skipMe = new ArrayList(3);
                    }
                    if (!foundAndRemovedExactReference(this.skipMe, removeAt.toTrickle)) {
                        this.forgetMeNot.add(removeAt.toTrickle);
                    }
                    if (!foundAndRemovedExactReference(this.forgetMeNot, removeAt.replaced)) {
                        this.skipMe.add(removeAt.replaced);
                    }
                }
                this.cursor--;
                this.nextCursor--;
                return;
            }
            Preconditions.checkState(removeExact(this.lastFromForgetMeNot));
            this.lastFromForgetMeNot = null;
        }
    }

    private int calculateNewCapacity() {
        int i11;
        int length = this.queue.length;
        if (length < 64) {
            i11 = (length + 1) * 2;
        } else {
            i11 = IntMath.checkedMultiply(length / 2, 3);
        }
        return capAtMaximumSize(i11, this.maximumSize);
    }

    private static int capAtMaximumSize(int i11, int i12) {
        return Math.min(i11 - 1, i12) + 1;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    public static Builder<Comparable> expectedSize(int i11) {
        return new Builder(Ordering.natural()).expectedSize(i11);
    }

    private MoveDesc<E> fillHole(int i11, E e11) {
        MinMaxPriorityQueue<E>.Heap heapForIndex = heapForIndex(i11);
        int fillHoleAt = heapForIndex.fillHoleAt(i11);
        int bubbleUpAlternatingLevels = heapForIndex.bubbleUpAlternatingLevels(fillHoleAt, e11);
        if (bubbleUpAlternatingLevels == fillHoleAt) {
            return heapForIndex.tryCrossOverAndBubbleUp(i11, fillHoleAt, e11);
        }
        if (bubbleUpAlternatingLevels < i11) {
            return new MoveDesc<>(e11, elementData(i11));
        }
        return null;
    }

    private int getMaxElementIndex() {
        int i11 = this.size;
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2 || this.maxHeap.compareElements(1, 2) <= 0) {
            return 1;
        }
        return 2;
    }

    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            Object[] objArr = new Object[calculateNewCapacity()];
            Object[] objArr2 = this.queue;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.queue = objArr;
        }
    }

    private MinMaxPriorityQueue<E>.Heap heapForIndex(int i11) {
        return isEvenLevel(i11) ? this.minHeap : this.maxHeap;
    }

    @VisibleForTesting
    public static int initialQueueSize(int i11, int i12, Iterable<?> iterable) {
        if (i11 == -1) {
            i11 = 11;
        }
        if (iterable instanceof Collection) {
            i11 = Math.max(i11, ((Collection) iterable).size());
        }
        return capAtMaximumSize(i11, i12);
    }

    @VisibleForTesting
    public static boolean isEvenLevel(int i11) {
        int i12 = ~(~(i11 + 1));
        Preconditions.checkState(i12 > 0, "negative index");
        return (EVEN_POWERS_OF_TWO & i12) > (i12 & ODD_POWERS_OF_TWO);
    }

    public static Builder<Comparable> maximumSize(int i11) {
        return new Builder(Ordering.natural()).maximumSize(i11);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    private E removeAndGet(int i11) {
        E elementData = elementData(i11);
        removeAt(i11);
        return elementData;
    }

    @CanIgnoreReturnValue
    public boolean add(E e11) {
        offer(e11);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        boolean z11 = false;
        for (Object offer : collection) {
            offer(offer);
            z11 = true;
        }
        return z11;
    }

    @VisibleForTesting
    public int capacity() {
        return this.queue.length;
    }

    public void clear() {
        for (int i11 = 0; i11 < this.size; i11++) {
            this.queue[i11] = null;
        }
        this.size = 0;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.ordering;
    }

    public E elementData(int i11) {
        return this.queue[i11];
    }

    @VisibleForTesting
    public boolean isIntact() {
        for (int i11 = 1; i11 < this.size; i11++) {
            if (!heapForIndex(i11).verifyIndex(i11)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    @CanIgnoreReturnValue
    public boolean offer(E e11) {
        Preconditions.checkNotNull(e11);
        this.modCount++;
        int i11 = this.size;
        this.size = i11 + 1;
        growIfNeeded();
        heapForIndex(i11).bubbleUp(i11, e11);
        if (this.size <= this.maximumSize || pollLast() != e11) {
            return true;
        }
        return false;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elementData(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return elementData(getMaxElementIndex());
    }

    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(0);
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(getMaxElementIndex());
    }

    @CanIgnoreReturnValue
    @VisibleForTesting
    public MoveDesc<E> removeAt(int i11) {
        Preconditions.checkPositionIndex(i11, this.size);
        this.modCount++;
        int i12 = this.size - 1;
        this.size = i12;
        if (i12 == i11) {
            this.queue[i12] = null;
            return null;
        }
        Object elementData = elementData(i12);
        int swapWithConceptuallyLastElement = heapForIndex(this.size).swapWithConceptuallyLastElement(elementData);
        if (swapWithConceptuallyLastElement == i11) {
            this.queue[this.size] = null;
            return null;
        }
        Object elementData2 = elementData(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> fillHole = fillHole(i11, elementData2);
        if (swapWithConceptuallyLastElement >= i11) {
            return fillHole;
        }
        if (fillHole == null) {
            return new MoveDesc<>(elementData, elementData2);
        }
        return new MoveDesc<>(elementData, fillHole.replaced);
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (!isEmpty()) {
            return removeAndGet(getMaxElementIndex());
        }
        throw new NoSuchElementException();
    }

    public int size() {
        return this.size;
    }

    public Object[] toArray() {
        int i11 = this.size;
        Object[] objArr = new Object[i11];
        System.arraycopy(this.queue, 0, objArr, 0, i11);
        return objArr;
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int i11) {
        Ordering access$200 = builder.ordering();
        MinMaxPriorityQueue<E>.Heap heap = new Heap(access$200);
        this.minHeap = heap;
        MinMaxPriorityQueue<E>.Heap heap2 = new Heap(access$200.reverse());
        this.maxHeap = heap2;
        heap.otherHeap = heap2;
        heap2.otherHeap = heap;
        this.maximumSize = builder.maximumSize;
        this.queue = new Object[i11];
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }
}
