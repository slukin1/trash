package com.huobi.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class e0<E> implements Queue<E> {

    /* renamed from: b  reason: collision with root package name */
    public int f83740b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<E> f83741c = new LinkedList();

    public e0(int i11) {
        this.f83740b = i11;
    }

    public boolean add(E e11) {
        return this.f83741c.add(e11);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return this.f83741c.addAll(collection);
    }

    public void clear() {
        this.f83741c.clear();
    }

    public boolean contains(Object obj) {
        return this.f83741c.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f83741c.containsAll(collection);
    }

    public E element() {
        return this.f83741c.element();
    }

    public boolean isEmpty() {
        return this.f83741c.size() == 0;
    }

    public Iterator<E> iterator() {
        return this.f83741c.iterator();
    }

    public boolean offer(E e11) {
        if (this.f83741c.size() >= this.f83740b) {
            this.f83741c.poll();
        }
        return this.f83741c.offer(e11);
    }

    public E peek() {
        return this.f83741c.peek();
    }

    public E poll() {
        return this.f83741c.poll();
    }

    public E remove() {
        return this.f83741c.remove();
    }

    public boolean removeAll(Collection<?> collection) {
        return this.f83741c.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.f83741c.retainAll(collection);
    }

    public int size() {
        return this.f83741c.size();
    }

    public Object[] toArray() {
        return this.f83741c.toArray();
    }

    public String toString() {
        return this.f83741c.toString();
    }

    public boolean remove(Object obj) {
        return this.f83741c.remove(obj);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f83741c.toArray(tArr);
    }
}
