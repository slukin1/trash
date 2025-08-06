package com.zopim.android.sdk.breadcrumbs;

import com.zendesk.logger.Logger;
import com.zopim.android.sdk.util.CircularQueue;
import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class ConcurrentBoundedQueue<E> implements CircularQueue<E> {
    private static final String LOG_TAG = "ConcurrentBoundedQueue";
    private final int mCapacity;
    private final Queue<E> mQueue;

    public ConcurrentBoundedQueue(int i11) {
        if (i11 <= 0) {
            Logger.g(LOG_TAG, "Capacity must be greater then zero. Will set capacity to max int value", new Object[0]);
            this.mQueue = new LinkedList();
            this.mCapacity = Integer.MAX_VALUE;
            return;
        }
        this.mQueue = new LinkedList();
        this.mCapacity = i11;
    }

    public synchronized void addAll(Collection<? extends E> collection) {
        if (collection == null) {
            Logger.l(LOG_TAG, "Collection must not be null when trying to add to the queue", new Object[0]);
            return;
        }
        if (this.mCapacity < collection.size()) {
            try {
                collection = new LinkedList(collection).subList(collection.size() - this.mCapacity, collection.size());
            } catch (IndexOutOfBoundsException unused) {
                Logger.l(LOG_TAG, "Failed to add a collection to the queue. Unexpected error while attempting to add a collection into a bounded queue.", new Object[0]);
                return;
            }
        }
        while (this.mCapacity - this.mQueue.size() < collection.size()) {
            try {
                this.mQueue.remove();
            } catch (NoSuchElementException unused2) {
                Logger.l(LOG_TAG, "Queue has been cleared but there is still not enough free capacity to add all elements of the collection.", new Object[0]);
            }
        }
        try {
            this.mQueue.addAll(collection);
            return;
        } catch (Exception unused3) {
            Logger.l(LOG_TAG, "Failed to add all elements in to the queue", new Object[0]);
            return;
        }
    }

    public synchronized void clear() {
        this.mQueue.clear();
    }

    public boolean contains(E e11) {
        try {
            return this.mQueue.contains(e11);
        } catch (Exception e12) {
            Logger.k(LOG_TAG, "Failed to find the element in the queue.", e12, new Object[0]);
            return false;
        }
    }

    public boolean isEmpty() {
        return this.mQueue.isEmpty();
    }

    public synchronized void offer(E e11) {
        if (e11 != null) {
            while (this.mQueue.size() > this.mCapacity) {
                try {
                    this.mQueue.remove();
                } catch (NoSuchElementException unused) {
                    Logger.l(LOG_TAG, "Unexpected exception. Could not maintain capacity of the queue.", new Object[0]);
                }
            }
            try {
                this.mQueue.offer(e11);
            } catch (Exception unused2) {
                Logger.l(LOG_TAG, "Failed to offer element to the queue", new Object[0]);
            }
        }
    }

    public synchronized E poll() {
        return this.mQueue.poll();
    }

    public int size() {
        return this.mQueue.size();
    }

    public E[] toArray(E[] eArr) {
        return this.mQueue.toArray(eArr);
    }
}
