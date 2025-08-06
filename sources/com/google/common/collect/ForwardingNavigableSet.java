package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    @Beta
    public class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet() {
            super(ForwardingNavigableSet.this);
        }
    }

    public E ceiling(E e11) {
        return delegate().ceiling(e11);
    }

    public abstract NavigableSet<E> delegate();

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    public E floor(E e11) {
        return delegate().floor(e11);
    }

    public NavigableSet<E> headSet(E e11, boolean z11) {
        return delegate().headSet(e11, z11);
    }

    public E higher(E e11) {
        return delegate().higher(e11);
    }

    public E lower(E e11) {
        return delegate().lower(e11);
    }

    public E pollFirst() {
        return delegate().pollFirst();
    }

    public E pollLast() {
        return delegate().pollLast();
    }

    public E standardCeiling(E e11) {
        return Iterators.getNext(tailSet(e11, true).iterator(), null);
    }

    public E standardFirst() {
        return iterator().next();
    }

    public E standardFloor(E e11) {
        return Iterators.getNext(headSet(e11, true).descendingIterator(), null);
    }

    public SortedSet<E> standardHeadSet(E e11) {
        return headSet(e11, false);
    }

    public E standardHigher(E e11) {
        return Iterators.getNext(tailSet(e11, false).iterator(), null);
    }

    public E standardLast() {
        return descendingIterator().next();
    }

    public E standardLower(E e11) {
        return Iterators.getNext(headSet(e11, false).descendingIterator(), null);
    }

    public E standardPollFirst() {
        return Iterators.pollNext(iterator());
    }

    public E standardPollLast() {
        return Iterators.pollNext(descendingIterator());
    }

    @Beta
    public NavigableSet<E> standardSubSet(E e11, boolean z11, E e12, boolean z12) {
        return tailSet(e11, z11).headSet(e12, z12);
    }

    public SortedSet<E> standardTailSet(E e11) {
        return tailSet(e11, true);
    }

    public NavigableSet<E> subSet(E e11, boolean z11, E e12, boolean z12) {
        return delegate().subSet(e11, z11, e12, z12);
    }

    public NavigableSet<E> tailSet(E e11, boolean z11) {
        return delegate().tailSet(e11, z11);
    }

    public SortedSet<E> standardSubSet(E e11, E e12) {
        return subSet(e11, true, e12, false);
    }
}
