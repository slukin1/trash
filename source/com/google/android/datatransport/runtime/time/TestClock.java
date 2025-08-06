package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

public class TestClock implements Clock {
    private final AtomicLong timestamp;

    public TestClock(long j11) {
        this.timestamp = new AtomicLong(j11);
    }

    public void advance(long j11) {
        if (j11 >= 0) {
            this.timestamp.addAndGet(j11);
            return;
        }
        throw new IllegalArgumentException("cannot advance time backwards.");
    }

    public long getTime() {
        return this.timestamp.get();
    }

    public void tick() {
        advance(1);
    }
}
