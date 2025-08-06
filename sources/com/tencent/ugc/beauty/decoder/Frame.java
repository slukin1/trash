package com.tencent.ugc.beauty.decoder;

import java.nio.ByteBuffer;

public class Frame {
    public ByteBuffer buffer;
    public int bufferIndex;
    public int flags;
    public int offset;
    public long presentationTimeUs;
    public int size;
}
