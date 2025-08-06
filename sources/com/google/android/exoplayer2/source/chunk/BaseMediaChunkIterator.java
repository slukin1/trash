package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

public abstract class BaseMediaChunkIterator implements MediaChunkIterator {
    private long currentIndex;
    private final long fromIndex;
    private final long toIndex;

    public BaseMediaChunkIterator(long j11, long j12) {
        this.fromIndex = j11;
        this.toIndex = j12;
        reset();
    }

    public final void checkInBounds() {
        long j11 = this.currentIndex;
        if (j11 < this.fromIndex || j11 > this.toIndex) {
            throw new NoSuchElementException();
        }
    }

    public final long getCurrentIndex() {
        return this.currentIndex;
    }

    public boolean isEnded() {
        return this.currentIndex > this.toIndex;
    }

    public boolean next() {
        this.currentIndex++;
        return !isEnded();
    }

    public void reset() {
        this.currentIndex = this.fromIndex - 1;
    }
}
