package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimpleOutputBuffer extends OutputBuffer {
    public ByteBuffer data;
    private final OutputBuffer.Owner<SimpleOutputBuffer> owner;

    public SimpleOutputBuffer(OutputBuffer.Owner<SimpleOutputBuffer> owner2) {
        this.owner = owner2;
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public ByteBuffer init(long j11, int i11) {
        this.timeUs = j11;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.data = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        }
        this.data.position(0);
        this.data.limit(i11);
        return this.data;
    }

    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
