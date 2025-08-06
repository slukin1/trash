package com.google.android.exoplayer2.decoder;

public abstract class OutputBuffer extends Buffer {
    public int skippedOutputBufferCount;
    public long timeUs;

    public interface Owner<S extends OutputBuffer> {
        void releaseOutputBuffer(S s11);
    }

    public abstract void release();
}
