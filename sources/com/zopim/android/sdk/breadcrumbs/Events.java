package com.zopim.android.sdk.breadcrumbs;

import com.zopim.android.sdk.util.CircularQueue;

public class Events {
    private static final CircularQueue<Event> QUEUE = new ConcurrentBoundedQueue(10);

    public static CircularQueue<Event> getQueue() {
        return QUEUE;
    }
}
