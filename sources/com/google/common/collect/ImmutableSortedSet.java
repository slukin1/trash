package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, SortedIterable<E> {
    public final transient Comparator<? super E> comparator;
    @GwtIncompatible
    @LazyInit
    public transient ImmutableSortedSet<E> descendingSet;

    public static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Comparator<? super E> comparator;
        public final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator2, Object[] objArr) {
            this.comparator = comparator2;
            this.elements = objArr;
        }

        public Object readResolve() {
            return new Builder(this.comparator).add(this.elements).build();
        }
    }

    public ImmutableSortedSet(Comparator<? super E> comparator2) {
        this.comparator = comparator2;
    }

    public static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator2, int i11, E... eArr) {
        if (i11 == 0) {
            return emptySet(comparator2);
        }
        ObjectArrays.checkElementsNotNull(eArr, i11);
        Arrays.sort(eArr, 0, i11, comparator2);
        int i12 = 1;
        for (int i13 = 1; i13 < i11; i13++) {
            E e11 = eArr[i13];
            if (comparator2.compare(e11, eArr[i12 - 1]) != 0) {
                eArr[i12] = e11;
                i12++;
            }
        }
        Arrays.fill(eArr, i12, i11, (Object) null);
        if (i12 < eArr.length / 2) {
            eArr = Arrays.copyOf(eArr, i12);
        }
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i12), comparator2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> copyOf(E[] eArr) {
        return construct(Ordering.natural(), eArr.length, (Object[]) eArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator2 = SortedIterables.comparator(sortedSet);
        ImmutableList<E> copyOf = ImmutableList.copyOf(sortedSet);
        if (copyOf.isEmpty()) {
            return emptySet(comparator2);
        }
        return new RegularImmutableSortedSet(copyOf, comparator2);
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator2) {
        if (Ordering.natural().equals(comparator2)) {
            return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
        }
        return new RegularImmutableSortedSet<>(ImmutableList.of(), comparator2);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator2) {
        return new Builder<>(comparator2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Collections.reverseOrder());
    }

    @GwtIncompatible
    public E ceiling(E e11) {
        return Iterables.getFirst(tailSet(e11, true), null);
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @GwtIncompatible
    public abstract ImmutableSortedSet<E> createDescendingSet();

    @GwtIncompatible
    public abstract UnmodifiableIterator<E> descendingIterator();

    public E first() {
        return iterator().next();
    }

    @GwtIncompatible
    public E floor(E e11) {
        return Iterators.getNext(headSet(e11, true).descendingIterator(), null);
    }

    public abstract ImmutableSortedSet<E> headSetImpl(E e11, boolean z11);

    @GwtIncompatible
    public E higher(E e11) {
        return Iterables.getFirst(tailSet(e11, false), null);
    }

    public abstract int indexOf(Object obj);

    public abstract UnmodifiableIterator<E> iterator();

    public E last() {
        return descendingIterator().next();
    }

    @GwtIncompatible
    public E lower(E e11) {
        return Iterators.getNext(headSet(e11, false).descendingIterator(), null);
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableSortedSet<E> subSetImpl(E e11, boolean z11, E e12, boolean z12);

    public abstract ImmutableSortedSet<E> tailSetImpl(E e11, boolean z11);

    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    public static final class Builder<E> extends ImmutableSet.Builder<E> {
        private final Comparator<? super E> comparator;

        public Builder(Comparator<? super E> comparator2) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        public ImmutableSortedSet<E> build() {
            ImmutableSortedSet<E> construct = ImmutableSortedSet.construct(this.comparator, this.size, this.contents);
            this.size = construct.size();
            this.forceCopy = true;
            return construct;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            super.addAll((Iterable) iterable);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E e11) {
            super.add((Object) e11);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it2) {
            super.addAll((Iterator) it2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e11) {
        return new RegularImmutableSortedSet(ImmutableList.of(e11), Ordering.natural());
    }

    public static int unsafeCompare(Comparator<?> comparator2, Object obj, Object obj2) {
        return comparator2.compare(obj, obj2);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
        this.descendingSet = createDescendingSet;
        createDescendingSet.descendingSet = this;
        return createDescendingSet;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e11, E e12) {
        return construct(Ordering.natural(), 2, e11, e12);
    }

    public ImmutableSortedSet<E> headSet(E e11) {
        return headSet(e11, false);
    }

    public ImmutableSortedSet<E> subSet(E e11, E e12) {
        return subSet(e11, true, e12, false);
    }

    public ImmutableSortedSet<E> tailSet(E e11) {
        return tailSet(e11, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf(Ordering.natural(), collection);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e11, E e12, E e13) {
        return construct(Ordering.natural(), 3, e11, e12, e13);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> headSet(E e11, boolean z11) {
        return headSetImpl(Preconditions.checkNotNull(e11), z11);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> subSet(E e11, boolean z11, E e12, boolean z12) {
        Preconditions.checkNotNull(e11);
        Preconditions.checkNotNull(e12);
        Preconditions.checkArgument(this.comparator.compare(e11, e12) <= 0);
        return subSetImpl(e11, z11, e12, z12);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> tailSet(E e11, boolean z11) {
        return tailSetImpl(Preconditions.checkNotNull(e11), z11);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e11, E e12, E e13, E e14) {
        return construct(Ordering.natural(), 4, e11, e12, e13, e14);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it2) {
        return copyOf(Ordering.natural(), it2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e11, E e12, E e13, E e14, E e15) {
        return construct(Ordering.natural(), 5, e11, e12, e13, e14, e15);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        int length = eArr.length + 6;
        Comparable[] comparableArr = new Comparable[length];
        comparableArr[0] = e11;
        comparableArr[1] = e12;
        comparableArr[2] = e13;
        comparableArr[3] = e14;
        comparableArr[4] = e15;
        comparableArr[5] = e16;
        System.arraycopy(eArr, 0, comparableArr, 6, eArr.length);
        return construct(Ordering.natural(), length, comparableArr);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator2, Iterator<? extends E> it2) {
        return new Builder(comparator2).addAll((Iterator) it2).build();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator2, Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(comparator2);
        if (SortedIterables.hasSameComparator(comparator2, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] array = Iterables.toArray(iterable);
        return construct(comparator2, array.length, array);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator2, Collection<? extends E> collection) {
        return copyOf(comparator2, collection);
    }
}
