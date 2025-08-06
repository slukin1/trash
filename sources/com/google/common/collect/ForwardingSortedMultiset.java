package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

@GwtCompatible(emulated = true)
@Beta
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    public abstract class StandardDescendingMultiset extends DescendingMultiset<E> {
        public StandardDescendingMultiset() {
        }

        public SortedMultiset<E> forwardMultiset() {
            return ForwardingSortedMultiset.this;
        }
    }

    public class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
        public StandardElementSet() {
            super(ForwardingSortedMultiset.this);
        }
    }

    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    public abstract SortedMultiset<E> delegate();

    public SortedMultiset<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    public Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    public SortedMultiset<E> headMultiset(E e11, BoundType boundType) {
        return delegate().headMultiset(e11, boundType);
    }

    public Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    public Multiset.Entry<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    public Multiset.Entry<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    public Multiset.Entry<E> standardFirstEntry() {
        Iterator it2 = entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it2.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    public Multiset.Entry<E> standardLastEntry() {
        Iterator it2 = descendingMultiset().entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it2.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    public Multiset.Entry<E> standardPollFirstEntry() {
        Iterator it2 = entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it2.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        it2.remove();
        return immutableEntry;
    }

    public Multiset.Entry<E> standardPollLastEntry() {
        Iterator it2 = descendingMultiset().entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it2.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        it2.remove();
        return immutableEntry;
    }

    public SortedMultiset<E> standardSubMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        return tailMultiset(e11, boundType).headMultiset(e12, boundType2);
    }

    public SortedMultiset<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        return delegate().subMultiset(e11, boundType, e12, boundType2);
    }

    public SortedMultiset<E> tailMultiset(E e11, BoundType boundType) {
        return delegate().tailMultiset(e11, boundType);
    }

    public NavigableSet<E> elementSet() {
        return delegate().elementSet();
    }
}
