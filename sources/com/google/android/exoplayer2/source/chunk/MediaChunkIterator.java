package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.NoSuchElementException;

public interface MediaChunkIterator {
    public static final MediaChunkIterator EMPTY = new MediaChunkIterator() {
        public long getChunkEndTimeUs() {
            throw new NoSuchElementException();
        }

        public long getChunkStartTimeUs() {
            throw new NoSuchElementException();
        }

        public DataSpec getDataSpec() {
            throw new NoSuchElementException();
        }

        public boolean isEnded() {
            return true;
        }

        public boolean next() {
            return false;
        }

        public void reset() {
        }
    };

    long getChunkEndTimeUs();

    long getChunkStartTimeUs();

    DataSpec getDataSpec();

    boolean isEnded();

    boolean next();

    void reset();
}
