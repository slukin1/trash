package com.huochat.community.network.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CycleLinkedList<E> {
    private Iterator<? extends E> iterator;
    private final ConcurrentLinkedQueue<E> linkedList = new ConcurrentLinkedQueue<>();

    public void add(E e11) {
        this.linkedList.add(e11);
    }

    public void addAll(Collection<? extends E> collection) {
        this.linkedList.addAll(collection);
    }

    public List<E> getList() {
        return new ArrayList(this.linkedList);
    }

    public E next() {
        Iterator<? extends E> it2 = this.iterator;
        if (it2 == null || !it2.hasNext()) {
            this.iterator = this.linkedList.iterator();
        }
        Iterator<? extends E> it3 = this.iterator;
        if (it3 != null) {
            return it3.next();
        }
        return null;
    }
}
