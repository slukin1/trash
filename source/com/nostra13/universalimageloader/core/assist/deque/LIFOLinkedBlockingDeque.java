package com.nostra13.universalimageloader.core.assist.deque;

public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    public boolean offer(T t11) {
        return super.offerFirst(t11);
    }

    public T remove() {
        return super.removeFirst();
    }
}
