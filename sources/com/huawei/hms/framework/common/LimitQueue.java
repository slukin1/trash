package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LimitQueue<E> extends ConcurrentLinkedQueue<E> {
    private static final String TAG = "LimitQueue";
    private static final long serialVersionUID = -4636313759149307798L;
    private boolean deduplication;
    private int limit;

    public LimitQueue(int i11) {
        this.deduplication = false;
        this.limit = i11;
    }

    public boolean add(E e11) {
        if (this.deduplication) {
            super.remove(e11);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.add(e11);
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() > this.limit) {
            return false;
        }
        if (this.deduplication) {
            super.removeAll(collection);
        }
        for (int size = (collection.size() + super.size()) - this.limit; size > 0; size--) {
            super.poll();
        }
        return super.addAll(collection);
    }

    public void clear() {
        super.clear();
    }

    public E get(int i11) {
        Iterator it2 = iterator();
        E e11 = null;
        for (int i12 = 0; i12 <= i11 && it2.hasNext(); i12++) {
            e11 = it2.next();
        }
        return e11;
    }

    public int getLimit() {
        return this.limit;
    }

    public boolean offer(E e11) {
        if (this.deduplication) {
            super.remove(e11);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.offer(e11);
    }

    public E peekLast() {
        Iterator it2 = iterator();
        E e11 = null;
        while (it2.hasNext()) {
            e11 = it2.next();
        }
        return e11;
    }

    public E poll() {
        return super.poll();
    }

    public E remove() {
        try {
            return super.remove();
        } catch (NoSuchElementException unused) {
            Logger.w(TAG, "remove failed, limitQueue is empty");
            return null;
        }
    }

    public LimitQueue(int i11, boolean z11) {
        this.deduplication = false;
        this.limit = i11;
        this.deduplication = z11;
    }

    public LimitQueue(Collection<? extends E> collection, boolean z11) {
        this(collection.size(), z11);
        addAll(collection);
    }
}
