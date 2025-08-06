package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

@GwtIncompatible
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    @LazyInit
    public transient ImmutableSortedMultiset<E> descendingMultiset;

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {
        private final Comparator<? super E> comparator;
        private int[] counts = new int[4];
        @VisibleForTesting
        public E[] elements = new Object[4];
        private boolean forceCopyElements;
        private int length;

        public Builder(Comparator<? super E> comparator2) {
            super(true);
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        private void dedupAndCoalesce(boolean z11) {
            int i11 = this.length;
            if (i11 != 0) {
                E[] copyOf = Arrays.copyOf(this.elements, i11);
                Arrays.sort(copyOf, this.comparator);
                int i12 = 1;
                for (int i13 = 1; i13 < copyOf.length; i13++) {
                    if (this.comparator.compare(copyOf[i12 - 1], copyOf[i13]) < 0) {
                        copyOf[i12] = copyOf[i13];
                        i12++;
                    }
                }
                Arrays.fill(copyOf, i12, this.length, (Object) null);
                if (z11) {
                    int i14 = i12 * 4;
                    int i15 = this.length;
                    if (i14 > i15 * 3) {
                        copyOf = Arrays.copyOf(copyOf, IntMath.saturatedAdd(i15, (i15 / 2) + 1));
                    }
                }
                int[] iArr = new int[copyOf.length];
                for (int i16 = 0; i16 < this.length; i16++) {
                    int binarySearch = Arrays.binarySearch(copyOf, 0, i12, this.elements[i16], this.comparator);
                    int[] iArr2 = this.counts;
                    if (iArr2[i16] >= 0) {
                        iArr[binarySearch] = iArr[binarySearch] + iArr2[i16];
                    } else {
                        iArr[binarySearch] = ~iArr2[i16];
                    }
                }
                this.elements = copyOf;
                this.counts = iArr;
                this.length = i12;
            }
        }

        private void dedupAndCoalesceAndDeleteEmpty() {
            dedupAndCoalesce(false);
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.length;
                if (i11 < i13) {
                    int[] iArr = this.counts;
                    if (iArr[i11] > 0) {
                        E[] eArr = this.elements;
                        eArr[i12] = eArr[i11];
                        iArr[i12] = iArr[i11];
                        i12++;
                    }
                    i11++;
                } else {
                    Arrays.fill(this.elements, i12, i13, (Object) null);
                    Arrays.fill(this.counts, i12, this.length, 0);
                    this.length = i12;
                    return;
                }
            }
        }

        private void maintenance() {
            int i11 = this.length;
            E[] eArr = this.elements;
            if (i11 == eArr.length) {
                dedupAndCoalesce(true);
            } else if (this.forceCopyElements) {
                this.elements = Arrays.copyOf(eArr, eArr.length);
            }
            this.forceCopyElements = false;
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e11, int i11) {
            Preconditions.checkNotNull(e11);
            CollectPreconditions.checkNonnegative(i11, "occurrences");
            if (i11 == 0) {
                return this;
            }
            maintenance();
            E[] eArr = this.elements;
            int i12 = this.length;
            eArr[i12] = e11;
            this.counts[i12] = i11;
            this.length = i12 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> setCount(E e11, int i11) {
            Preconditions.checkNotNull(e11);
            CollectPreconditions.checkNonnegative(i11, "count");
            maintenance();
            E[] eArr = this.elements;
            int i12 = this.length;
            eArr[i12] = e11;
            this.counts[i12] = ~i11;
            this.length = i12 + 1;
            return this;
        }

        public ImmutableSortedMultiset<E> build() {
            dedupAndCoalesceAndDeleteEmpty();
            int i11 = this.length;
            if (i11 == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.comparator);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.comparator, i11, this.elements);
            long[] jArr = new long[(this.length + 1)];
            int i12 = 0;
            while (i12 < this.length) {
                int i13 = i12 + 1;
                jArr[i13] = jArr[i12] + ((long) this.counts[i12]);
                i12 = i13;
            }
            this.forceCopyElements = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.length);
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E e11) {
            return addCopies((Object) e11, 1);
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry entry : ((Multiset) iterable).entrySet()) {
                    addCopies(entry.getElement(), entry.getCount());
                }
            } else {
                for (Object add : iterable) {
                    add((Object) add);
                }
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            for (E add : eArr) {
                add((Object) add);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it2) {
            while (it2.hasNext()) {
                add((Object) it2.next());
            }
            return this;
        }
    }

    public static final class SerializedForm<E> implements Serializable {
        public final Comparator<? super E> comparator;
        public final int[] counts;
        public final E[] elements;

        public SerializedForm(SortedMultiset<E> sortedMultiset) {
            this.comparator = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i11 = 0;
            for (Multiset.Entry next : sortedMultiset.entrySet()) {
                this.elements[i11] = next.getElement();
                this.counts[i11] = next.getCount();
                i11++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            Builder builder = new Builder(this.comparator);
            for (int i11 = 0; i11 < length; i11++) {
                builder.addCopies((Object) this.elements[i11], this.counts[i11]);
            }
            return builder.build();
        }
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        return copyOf(Ordering.natural(), Arrays.asList(eArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), Lists.newArrayList(sortedMultiset.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.Builder builder = new ImmutableList.Builder(collection.size());
        long[] jArr = new long[(collection.size() + 1)];
        int i11 = 0;
        for (Multiset.Entry next : collection) {
            builder.add(next.getElement());
            int i12 = i11 + 1;
            jArr[i12] = jArr[i11] + ((long) next.getCount());
            i11 = i12;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(builder.build(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        return new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType);

    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType);

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e11) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(e11), new long[]{0, 1}, 0, 1);
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    public ImmutableSortedMultiset<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        Preconditions.checkArgument(comparator().compare(e11, e12) <= 0, "Expected lowerBound <= upperBound but %s > %s", (Object) e11, (Object) e12);
        return tailMultiset(e11, boundType).headMultiset(e12, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it2) {
        return copyOf(Ordering.natural(), it2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e11, E e12) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e11, e12}));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it2) {
        Preconditions.checkNotNull(comparator);
        return new Builder(comparator).addAll((Iterator) it2).build();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e11, E e12, E e13) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e11, e12, e13}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e11, E e12, E e13, E e14) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e11, e12, e13, e14}));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new Builder(comparator).addAll((Iterable) iterable).build();
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e11, E e12, E e13, E e14, E e15) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e11, e12, e13, e14, e15}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e11, E e12, E e13, E e14, E e15, E e16, E... eArr) {
        ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(eArr.length + 6);
        Collections.addAll(newArrayListWithCapacity, new Comparable[]{e11, e12, e13, e14, e15, e16});
        Collections.addAll(newArrayListWithCapacity, eArr);
        return copyOf(Ordering.natural(), newArrayListWithCapacity);
    }
}
