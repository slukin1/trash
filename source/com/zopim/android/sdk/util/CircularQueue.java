package com.zopim.android.sdk.util;

import java.util.Collection;

public interface CircularQueue<E> {
    void addAll(Collection<? extends E> collection);

    void clear();

    boolean contains(E e11);

    boolean isEmpty();

    void offer(E e11);

    E poll();

    int size();

    E[] toArray(E[] eArr);
}
