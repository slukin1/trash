package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible
final class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> forward;

    public DescendingImmutableSortedSet(ImmutableSortedSet<E> immutableSortedSet) {
        super(Ordering.from(immutableSortedSet.comparator()).reverse());
        this.forward = immutableSortedSet;
    }

    public E ceiling(E e11) {
        return this.forward.floor(e11);
    }

    public boolean contains(Object obj) {
        return this.forward.contains(obj);
    }

    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> createDescendingSet() {
        throw new AssertionError("should never be called");
    }

    public E floor(E e11) {
        return this.forward.ceiling(e11);
    }

    public ImmutableSortedSet<E> headSetImpl(E e11, boolean z11) {
        return this.forward.tailSet(e11, z11).descendingSet();
    }

    public E higher(E e11) {
        return this.forward.lower(e11);
    }

    public int indexOf(Object obj) {
        int indexOf = this.forward.indexOf(obj);
        if (indexOf == -1) {
            return indexOf;
        }
        return (size() - 1) - indexOf;
    }

    public boolean isPartialView() {
        return this.forward.isPartialView();
    }

    public E lower(E e11) {
        return this.forward.higher(e11);
    }

    public int size() {
        return this.forward.size();
    }

    public ImmutableSortedSet<E> subSetImpl(E e11, boolean z11, E e12, boolean z12) {
        return this.forward.subSet(e12, z12, e11, z11).descendingSet();
    }

    public ImmutableSortedSet<E> tailSetImpl(E e11, boolean z11) {
        return this.forward.headSet(e11, z11).descendingSet();
    }

    @GwtIncompatible("NavigableSet")
    public UnmodifiableIterator<E> descendingIterator() {
        return this.forward.iterator();
    }

    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> descendingSet() {
        return this.forward;
    }

    public UnmodifiableIterator<E> iterator() {
        return this.forward.descendingIterator();
    }
}
