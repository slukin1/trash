package com.google.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() {
        public AllocatedBuffer allocateDirectBuffer(int i11) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(i11));
        }

        public AllocatedBuffer allocateHeapBuffer(int i11) {
            return AllocatedBuffer.wrap(new byte[i11]);
        }
    };

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int i11);

    public abstract AllocatedBuffer allocateHeapBuffer(int i11);
}
