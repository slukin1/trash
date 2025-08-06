package com.jumio.core.extraction.util;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class ByteBufferOutputStream extends ByteArrayOutputStream {
    public final ByteBuffer toDirectByteBuffer() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.count);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.put(this.buf, 0, this.count);
        allocateDirect.flip();
        return allocateDirect;
    }
}
