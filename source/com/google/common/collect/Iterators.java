package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

@GwtCompatible(emulated = true)
public final class Iterators {

    public static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
        public static final UnmodifiableListIterator<Object> EMPTY = new ArrayItr(new Object[0], 0, 0, 0);
        private final T[] array;
        private final int offset;

        public ArrayItr(T[] tArr, int i11, int i12, int i13) {
            super(i12, i13);
            this.array = tArr;
            this.offset = i11;
        }

        public T get(int i11) {
            return this.array[this.offset + i11];
        }
    }

    public static class ConcatenatedIterator<T> implements Iterator<T> {
        private Iterator<? extends T> iterator = Iterators.emptyIterator();
        private Deque<Iterator<? extends Iterator<? extends T>>> metaIterators;
        private Iterator<? extends T> toRemove;
        private Iterator<? extends Iterator<? extends T>> topMetaIterator;

        public ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> it2) {
            this.topMetaIterator = (Iterator) Preconditions.checkNotNull(it2);
        }

        private Iterator<? extends Iterator<? extends T>> getTopMetaIterator() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it2 = this.topMetaIterator;
                if (it2 != null && it2.hasNext()) {
                    return this.topMetaIterator;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.metaIterators;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.topMetaIterator = this.metaIterators.removeFirst();
            }
        }

        public boolean hasNext() {
            while (!((Iterator) Preconditions.checkNotNull(this.iterator)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> topMetaIterator2 = getTopMetaIterator();
                this.topMetaIterator = topMetaIterator2;
                if (topMetaIterator2 == null) {
                    return false;
                }
                Iterator<? extends T> it2 = (Iterator) topMetaIterator2.next();
                this.iterator = it2;
                if (it2 instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) it2;
                    this.iterator = concatenatedIterator.iterator;
                    if (this.metaIterators == null) {
                        this.metaIterators = new ArrayDeque();
                    }
                    this.metaIterators.addFirst(this.topMetaIterator);
                    if (concatenatedIterator.metaIterators != null) {
                        while (!concatenatedIterator.metaIterators.isEmpty()) {
                            this.metaIterators.addFirst(concatenatedIterator.metaIterators.removeLast());
                        }
                    }
                    this.topMetaIterator = concatenatedIterator.topMetaIterator;
                }
            }
            return true;
        }

        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it2 = this.iterator;
                this.toRemove = it2;
                return it2.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.toRemove != null);
            this.toRemove.remove();
            this.toRemove = null;
        }
    }

    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.checkRemove(false);
        }
    }

    public static class MergingIterator<T> extends UnmodifiableIterator<T> {
        public final Queue<PeekingIterator<T>> queue;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            this.queue = new PriorityQueue(2, new Comparator<PeekingIterator<T>>() {
                public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
                    return comparator.compare(peekingIterator.peek(), peekingIterator2.peek());
                }
            });
            for (Iterator it2 : iterable) {
                if (it2.hasNext()) {
                    this.queue.add(Iterators.peekingIterator(it2));
                }
            }
        }

        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        public T next() {
            PeekingIterator remove = this.queue.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.queue.add(remove);
            }
            return next;
        }
    }

    public static class PeekingImpl<E> implements PeekingIterator<E> {
        private boolean hasPeeked;
        private final Iterator<? extends E> iterator;
        private E peekedElement;

        public PeekingImpl(Iterator<? extends E> it2) {
            this.iterator = (Iterator) Preconditions.checkNotNull(it2);
        }

        public boolean hasNext() {
            return this.hasPeeked || this.iterator.hasNext();
        }

        public E next() {
            if (!this.hasPeeked) {
                return this.iterator.next();
            }
            E e11 = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;
            return e11;
        }

        public E peek() {
            if (!this.hasPeeked) {
                this.peekedElement = this.iterator.next();
                this.hasPeeked = true;
            }
            return this.peekedElement;
        }

        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }
    }

    private Iterators() {
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> it2) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it2);
        boolean z11 = false;
        while (it2.hasNext()) {
            z11 |= collection.add(it2.next());
        }
        return z11;
    }

    @CanIgnoreReturnValue
    public static int advance(Iterator<?> it2, int i11) {
        Preconditions.checkNotNull(it2);
        int i12 = 0;
        Preconditions.checkArgument(i11 >= 0, "numberToAdvance must be nonnegative");
        while (i12 < i11 && it2.hasNext()) {
            it2.next();
            i12++;
        }
        return i12;
    }

    public static <T> boolean all(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (it2.hasNext()) {
            if (!predicate.apply(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(Iterator<T> it2, Predicate<? super T> predicate) {
        return indexOf(it2, predicate) != -1;
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> it2) {
        Preconditions.checkNotNull(it2);
        return new Enumeration<T>() {
            public boolean hasMoreElements() {
                return it2.hasNext();
            }

            public T nextElement() {
                return it2.next();
            }
        };
    }

    public static <T> ListIterator<T> cast(Iterator<T> it2) {
        return (ListIterator) it2;
    }

    public static void checkNonnegative(int i11) {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("position (" + i11 + ") must not be negative");
        }
    }

    public static void clear(Iterator<?> it2) {
        Preconditions.checkNotNull(it2);
        while (it2.hasNext()) {
            it2.next();
            it2.remove();
        }
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it2, Iterator<? extends T> it3) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        return concat(consumingForArray(it2, it3));
    }

    public static <T> Iterator<T> concatNoDefensiveCopy(Iterator<? extends T>... itArr) {
        for (Iterator checkNotNull : (Iterator[]) Preconditions.checkNotNull(itArr)) {
            Preconditions.checkNotNull(checkNotNull);
        }
        return concat(consumingForArray(itArr));
    }

    private static <T> Iterator<T> consumingForArray(final T... tArr) {
        return new UnmodifiableIterator<T>() {
            public int index = 0;

            public boolean hasNext() {
                return this.index < tArr.length;
            }

            public T next() {
                if (hasNext()) {
                    T[] tArr = tArr;
                    int i11 = this.index;
                    T t11 = tArr[i11];
                    tArr[i11] = null;
                    this.index = i11 + 1;
                    return t11;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static <T> Iterator<T> consumingIterator(final Iterator<T> it2) {
        Preconditions.checkNotNull(it2);
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return it2.hasNext();
            }

            public T next() {
                T next = it2.next();
                it2.remove();
                return next;
            }

            public String toString() {
                return "Iterators.consumingIterator(...)";
            }
        };
    }

    public static boolean contains(Iterator<?> it2, Object obj) {
        if (obj == null) {
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it2.hasNext()) {
            if (obj.equals(it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterator<T>() {
            public Iterator<T> iterator = Iterators.emptyModifiableIterator();

            public boolean hasNext() {
                return this.iterator.hasNext() || iterable.iterator().hasNext();
            }

            public T next() {
                if (!this.iterator.hasNext()) {
                    Iterator<T> it2 = iterable.iterator();
                    this.iterator = it2;
                    if (!it2.hasNext()) {
                        throw new NoSuchElementException();
                    }
                }
                return this.iterator.next();
            }

            public void remove() {
                this.iterator.remove();
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean elementsEqual(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.google.common.base.Objects.equal(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.elementsEqual(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return emptyListIterator();
    }

    public static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return ArrayItr.EMPTY;
    }

    public static <T> Iterator<T> emptyModifiableIterator() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> filter(final Iterator<T> it2, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(predicate);
        return new AbstractIterator<T>() {
            public T computeNext() {
                while (it2.hasNext()) {
                    T next = it2.next();
                    if (predicate.apply(next)) {
                        return next;
                    }
                }
                return endOfData();
            }
        };
    }

    public static <T> T find(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... tArr) {
        return forArray(tArr, 0, tArr.length, 0);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            public T next() {
                return enumeration.nextElement();
            }
        };
    }

    public static int frequency(Iterator<?> it2, Object obj) {
        int i11 = 0;
        while (contains(it2, obj)) {
            i11++;
        }
        return i11;
    }

    public static <T> T get(Iterator<T> it2, int i11) {
        checkNonnegative(i11);
        int advance = advance(it2, i11);
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new IndexOutOfBoundsException("position (" + i11 + ") must be less than the number of elements that remained (" + advance + ")");
    }

    public static <T> T getLast(Iterator<T> it2) {
        T next;
        do {
            next = it2.next();
        } while (it2.hasNext());
        return next;
    }

    public static <T> T getNext(Iterator<? extends T> it2, T t11) {
        return it2.hasNext() ? it2.next() : t11;
    }

    public static <T> T getOnlyElement(Iterator<T> it2) {
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected one element but was: <");
        sb2.append(next);
        for (int i11 = 0; i11 < 4 && it2.hasNext(); i11++) {
            sb2.append(", ");
            sb2.append(it2.next());
        }
        if (it2.hasNext()) {
            sb2.append(", ...");
        }
        sb2.append('>');
        throw new IllegalArgumentException(sb2.toString());
    }

    public static <T> int indexOf(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i11 = 0;
        while (it2.hasNext()) {
            if (predicate.apply(it2.next())) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static <T> Iterator<T> limit(final Iterator<T> it2, final int i11) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkArgument(i11 >= 0, "limit is negative");
        return new Iterator<T>() {
            private int count;

            public boolean hasNext() {
                return this.count < i11 && it2.hasNext();
            }

            public T next() {
                if (hasNext()) {
                    this.count++;
                    return it2.next();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                it2.remove();
            }
        };
    }

    @Beta
    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new MergingIterator(iterable, comparator);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> it2, int i11) {
        return partitionImpl(it2, i11, true);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> it2, int i11) {
        return partitionImpl(it2, i11, false);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(final Iterator<T> it2, final int i11, final boolean z11) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkArgument(i11 > 0);
        return new UnmodifiableIterator<List<T>>() {
            public boolean hasNext() {
                return it2.hasNext();
            }

            public List<T> next() {
                if (hasNext()) {
                    Object[] objArr = new Object[i11];
                    int i11 = 0;
                    while (i11 < i11 && it2.hasNext()) {
                        objArr[i11] = it2.next();
                        i11++;
                    }
                    for (int i12 = i11; i12 < i11; i12++) {
                        objArr[i12] = null;
                    }
                    List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
                    return (z11 || i11 == i11) ? unmodifiableList : unmodifiableList.subList(0, i11);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> it2) {
        if (it2 instanceof PeekingImpl) {
            return (PeekingImpl) it2;
        }
        return new PeekingImpl(it2);
    }

    public static <T> T pollNext(Iterator<T> it2) {
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        it2.remove();
        return next;
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterator<?> it2, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z11 = false;
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                z11 = true;
            }
        }
        return z11;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean z11 = false;
        while (it2.hasNext()) {
            if (predicate.apply(it2.next())) {
                it2.remove();
                z11 = true;
            }
        }
        return z11;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterator<?> it2, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z11 = false;
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                it2.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(final T t11) {
        return new UnmodifiableIterator<T>() {
            public boolean done;

            public boolean hasNext() {
                return !this.done;
            }

            public T next() {
                if (!this.done) {
                    this.done = true;
                    return t11;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static int size(Iterator<?> it2) {
        long j11 = 0;
        while (it2.hasNext()) {
            it2.next();
            j11++;
        }
        return Ints.saturatedCast(j11);
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterator<? extends T> it2, Class<T> cls) {
        return Iterables.toArray(Lists.newArrayList(it2), cls);
    }

    public static String toString(Iterator<?> it2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z11 = true;
        while (it2.hasNext()) {
            if (!z11) {
                sb2.append(", ");
            }
            z11 = false;
            sb2.append(it2.next());
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static <F, T> Iterator<T> transform(Iterator<F> it2, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new TransformedIterator<F, T>(it2) {
            public T transform(F f11) {
                return function.apply(f11);
            }
        };
    }

    public static <T> Optional<T> tryFind(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return Optional.of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<? extends T> it2) {
        Preconditions.checkNotNull(it2);
        if (it2 instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) it2;
        }
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return it2.hasNext();
            }

            public T next() {
                return it2.next();
            }
        };
    }

    public static <T> UnmodifiableListIterator<T> forArray(T[] tArr, int i11, int i12, int i13) {
        Preconditions.checkArgument(i12 >= 0);
        Preconditions.checkPositionIndexes(i11, i11 + i12, tArr.length);
        Preconditions.checkPositionIndex(i13, i12);
        if (i12 == 0) {
            return emptyListIterator();
        }
        return new ArrayItr(tArr, i11, i12, i13);
    }

    @SafeVarargs
    public static <T> Iterator<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList((E[]) tArr));
    }

    public static <T> T getLast(Iterator<? extends T> it2, T t11) {
        return it2.hasNext() ? getLast(it2) : t11;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        Preconditions.checkNotNull(it4);
        return concat(consumingForArray(it2, it3, it4));
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> it2, Class<T> cls) {
        return filter(it2, Predicates.instanceOf(cls));
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> peekingIterator) {
        return (PeekingIterator) Preconditions.checkNotNull(peekingIterator);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> unmodifiableIterator) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(unmodifiableIterator);
    }

    public static <T> T get(Iterator<? extends T> it2, int i11, T t11) {
        checkNonnegative(i11);
        advance(it2, i11);
        return getNext(it2, t11);
    }

    public static <T> T find(Iterator<? extends T> it2, Predicate<? super T> predicate, T t11) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t11;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4, Iterator<? extends T> it5) {
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        Preconditions.checkNotNull(it4);
        Preconditions.checkNotNull(it5);
        return concat(consumingForArray(it2, it3, it4, it5));
    }

    public static <T> T getOnlyElement(Iterator<? extends T> it2, T t11) {
        return it2.hasNext() ? getOnlyElement(it2) : t11;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... itArr) {
        return concatNoDefensiveCopy((Iterator[]) Arrays.copyOf(itArr, itArr.length));
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> it2) {
        return new ConcatenatedIterator(it2);
    }
}
