package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;

@GwtIncompatible
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    public static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());
    private static final long[] ZERO_CUMULATIVE_COUNTS = {0};
    private final transient long[] cumulativeCounts;
    @VisibleForTesting
    public final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int i11) {
        long[] jArr = this.cumulativeCounts;
        int i12 = this.offset;
        return (int) (jArr[(i12 + i11) + 1] - jArr[i12 + i11]);
    }

    public int count(Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return getCount(indexOf);
        }
        return 0;
    }

    public Multiset.Entry<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    public Multiset.Entry<E> getEntry(int i11) {
        return Multisets.immutableEntry(this.elementSet.asList().get(i11), getCount(i11));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i12, this.length);
        if (i11 == i12) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        if (i11 == 0 && i12 == this.length) {
            return this;
        }
        return new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i11, i12), this.cumulativeCounts, this.offset + i11, i12 - i11);
    }

    public boolean isPartialView() {
        return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
    }

    public Multiset.Entry<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.length - 1);
    }

    public int size() {
        long[] jArr = this.cumulativeCounts;
        int i11 = this.offset;
        return Ints.saturatedCast(jArr[this.length + i11] - jArr[i11]);
    }

    public ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e11, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    public ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e11, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.length);
    }

    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i11, int i12) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = jArr;
        this.offset = i11;
        this.length = i12;
    }
}
