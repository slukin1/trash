package com.tencent.android.tpns.mqtt.internal.wire;

public class MultiByteInteger {
    private int length;
    private long value;

    public MultiByteInteger(long j11) {
        this(j11, -1);
    }

    public int getEncodedLength() {
        return this.length;
    }

    public long getValue() {
        return this.value;
    }

    public MultiByteInteger(long j11, int i11) {
        this.value = j11;
        this.length = i11;
    }
}
