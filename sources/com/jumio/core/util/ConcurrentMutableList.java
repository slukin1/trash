package com.jumio.core.util;

import e10.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.internal.q;

public final class ConcurrentMutableList<T> implements List<T>, Serializable, d {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f39502a = new ArrayList();

    public boolean add(T t11) {
        boolean add;
        synchronized (this.f39502a) {
            add = this.f39502a.add(t11);
        }
        return add;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll;
        synchronized (this.f39502a) {
            addAll = this.f39502a.addAll(collection);
        }
        return addAll;
    }

    public void clear() {
        synchronized (this.f39502a) {
            this.f39502a.clear();
            Unit unit = Unit.f56620a;
        }
    }

    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.f39502a) {
            contains = this.f39502a.contains(obj);
        }
        return contains;
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        boolean containsAll;
        synchronized (this.f39502a) {
            containsAll = this.f39502a.containsAll(collection);
        }
        return containsAll;
    }

    public T get(int i11) {
        T t11;
        synchronized (this.f39502a) {
            t11 = this.f39502a.get(i11);
        }
        return t11;
    }

    public int getSize() {
        int size;
        synchronized (this.f39502a) {
            size = this.f39502a.size();
        }
        return size;
    }

    public int indexOf(Object obj) {
        int indexOf;
        synchronized (this.f39502a) {
            indexOf = this.f39502a.indexOf(obj);
        }
        return indexOf;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f39502a) {
            isEmpty = this.f39502a.isEmpty();
        }
        return isEmpty;
    }

    public Iterator<T> iterator() {
        Iterator<T> it2;
        synchronized (this.f39502a) {
            it2 = this.f39502a.iterator();
        }
        return it2;
    }

    public int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.f39502a) {
            lastIndexOf = this.f39502a.lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    public ListIterator<T> listIterator() {
        ListIterator<T> listIterator;
        synchronized (this.f39502a) {
            listIterator = this.f39502a.listIterator();
        }
        return listIterator;
    }

    public final /* bridge */ T remove(int i11) {
        return removeAt(i11);
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        boolean removeAll;
        synchronized (this.f39502a) {
            removeAll = this.f39502a.removeAll(collection);
        }
        return removeAll;
    }

    public T removeAt(int i11) {
        T remove;
        synchronized (this.f39502a) {
            remove = this.f39502a.remove(i11);
        }
        return remove;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        boolean retainAll;
        synchronized (this.f39502a) {
            retainAll = this.f39502a.retainAll(collection);
        }
        return retainAll;
    }

    public T set(int i11, T t11) {
        T t12;
        synchronized (this.f39502a) {
            t12 = this.f39502a.set(i11, t11);
        }
        return t12;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public List<T> subList(int i11, int i12) {
        List<T> subList;
        synchronized (this.f39502a) {
            subList = this.f39502a.subList(i11, i12);
        }
        return subList;
    }

    public Object[] toArray() {
        return q.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return q.b(this, tArr);
    }

    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.f39502a) {
            remove = this.f39502a.remove(obj);
        }
        return remove;
    }

    public void add(int i11, T t11) {
        synchronized (this.f39502a) {
            this.f39502a.add(i11, t11);
            Unit unit = Unit.f56620a;
        }
    }

    public boolean addAll(int i11, Collection<? extends T> collection) {
        boolean addAll;
        synchronized (this.f39502a) {
            addAll = this.f39502a.addAll(i11, collection);
        }
        return addAll;
    }

    public ListIterator<T> listIterator(int i11) {
        ListIterator<T> listIterator;
        synchronized (this.f39502a) {
            listIterator = this.f39502a.listIterator(i11);
        }
        return listIterator;
    }
}
