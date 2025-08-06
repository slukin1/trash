package com.tencent.mmkv;

public final class NativeBuffer {
    public long pointer;
    public int size;

    public NativeBuffer(long j11, int i11) {
        this.pointer = j11;
        this.size = i11;
    }
}
