package io.reactivex.rxjava3.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    public final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList<>();
    }

    public boolean add(T t11) {
        boolean add = this.list.add(t11);
        lazySet(this.list.size());
        return add;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(collection);
        lazySet(this.list.size());
        return addAll;
    }

    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.list.equals(((VolatileSizeArrayList) obj).list);
        }
        return this.list.equals(obj);
    }

    public T get(int i11) {
        return this.list.get(i11);
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public boolean isEmpty() {
        return get() == 0;
    }

    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    public boolean remove(Object obj) {
        boolean remove = this.list.remove(obj);
        lazySet(this.list.size());
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.list.removeAll(collection);
        lazySet(this.list.size());
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.list.retainAll(collection);
        lazySet(this.list.size());
        return retainAll;
    }

    public T set(int i11, T t11) {
        return this.list.set(i11, t11);
    }

    public int size() {
        return get();
    }

    public List<T> subList(int i11, int i12) {
        return this.list.subList(i11, i12);
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public String toString() {
        return this.list.toString();
    }

    public ListIterator<T> listIterator(int i11) {
        return this.list.listIterator(i11);
    }

    public <E> E[] toArray(E[] eArr) {
        return this.list.toArray(eArr);
    }

    public VolatileSizeArrayList(int i11) {
        this.list = new ArrayList<>(i11);
    }

    public void add(int i11, T t11) {
        this.list.add(i11, t11);
        lazySet(this.list.size());
    }

    public boolean addAll(int i11, Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(i11, collection);
        lazySet(this.list.size());
        return addAll;
    }

    public T remove(int i11) {
        T remove = this.list.remove(i11);
        lazySet(this.list.size());
        return remove;
    }
}
