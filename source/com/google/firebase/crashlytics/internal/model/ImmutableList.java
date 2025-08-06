package com.google.firebase.crashlytics.internal.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ImmutableList<E> implements List<E>, RandomAccess {
    private final List<E> immutableList;

    private ImmutableList(List<E> list) {
        this.immutableList = Collections.unmodifiableList(list);
    }

    public static <E> ImmutableList<E> from(E... eArr) {
        return new ImmutableList<>(Arrays.asList(eArr));
    }

    public boolean add(E e11) {
        return this.immutableList.add(e11);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return this.immutableList.addAll(collection);
    }

    public void clear() {
        this.immutableList.clear();
    }

    public boolean contains(Object obj) {
        return this.immutableList.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.immutableList.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.immutableList.equals(obj);
    }

    public E get(int i11) {
        return this.immutableList.get(i11);
    }

    public int hashCode() {
        return this.immutableList.hashCode();
    }

    public int indexOf(Object obj) {
        return this.immutableList.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.immutableList.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.immutableList.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.immutableList.lastIndexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return this.immutableList.listIterator();
    }

    public boolean remove(Object obj) {
        return this.immutableList.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.immutableList.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.immutableList.retainAll(collection);
    }

    public E set(int i11, E e11) {
        return this.immutableList.set(i11, e11);
    }

    public int size() {
        return this.immutableList.size();
    }

    public List<E> subList(int i11, int i12) {
        return this.immutableList.subList(i11, i12);
    }

    public Object[] toArray() {
        return this.immutableList.toArray();
    }

    public static <E> ImmutableList<E> from(List<E> list) {
        return new ImmutableList<>(list);
    }

    public void add(int i11, E e11) {
        this.immutableList.add(i11, e11);
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        return this.immutableList.addAll(i11, collection);
    }

    public ListIterator<E> listIterator(int i11) {
        return this.immutableList.listIterator(i11);
    }

    public E remove(int i11) {
        return this.immutableList.remove(i11);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.immutableList.toArray(tArr);
    }
}
