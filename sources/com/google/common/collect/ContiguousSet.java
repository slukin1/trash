package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import java.lang.Comparable;
import java.util.NoSuchElementException;

@GwtCompatible(emulated = true)
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    public final DiscreteDomain<C> domain;

    public ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @Beta
    public static ContiguousSet<Integer> closed(int i11, int i12) {
        return create(Range.closed(Integer.valueOf(i11), Integer.valueOf(i12)), DiscreteDomain.integers());
    }

    @Beta
    public static ContiguousSet<Integer> closedOpen(int i11, int i12) {
        return create(Range.closedOpen(Integer.valueOf(i11), Integer.valueOf(i12)), DiscreteDomain.integers());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(discreteDomain);
        try {
            Range<C> intersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(discreteDomain.minValue())) : range;
            if (!range.hasUpperBound()) {
                intersection = intersection.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            return intersection.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0 ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(intersection, discreteDomain);
        } catch (NoSuchElementException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @GwtIncompatible
    public ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    public abstract ContiguousSet<C> headSetImpl(C c11, boolean z11);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    public abstract ContiguousSet<C> subSetImpl(C c11, boolean z11, C c12, boolean z12);

    public abstract ContiguousSet<C> tailSetImpl(C c11, boolean z11);

    public String toString() {
        return range().toString();
    }

    @Beta
    public static ContiguousSet<Long> closed(long j11, long j12) {
        return create(Range.closed(Long.valueOf(j11), Long.valueOf(j12)), DiscreteDomain.longs());
    }

    @Beta
    public static ContiguousSet<Long> closedOpen(long j11, long j12) {
        return create(Range.closedOpen(Long.valueOf(j11), Long.valueOf(j12)), DiscreteDomain.longs());
    }

    public ContiguousSet<C> headSet(C c11) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(c11), false);
    }

    public ContiguousSet<C> subSet(C c11, C c12) {
        Preconditions.checkNotNull(c11);
        Preconditions.checkNotNull(c12);
        Preconditions.checkArgument(comparator().compare(c11, c12) <= 0);
        return subSetImpl(c11, true, c12, false);
    }

    public ContiguousSet<C> tailSet(C c11) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(c11), true);
    }

    @GwtIncompatible
    public ContiguousSet<C> headSet(C c11, boolean z11) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(c11), z11);
    }

    @GwtIncompatible
    public ContiguousSet<C> tailSet(C c11, boolean z11) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(c11), z11);
    }

    @GwtIncompatible
    public ContiguousSet<C> subSet(C c11, boolean z11, C c12, boolean z12) {
        Preconditions.checkNotNull(c11);
        Preconditions.checkNotNull(c12);
        Preconditions.checkArgument(comparator().compare(c11, c12) <= 0);
        return subSetImpl(c11, z11, c12, z12);
    }
}
