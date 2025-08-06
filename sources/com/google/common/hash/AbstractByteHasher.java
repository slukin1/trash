package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@CanIgnoreReturnValue
abstract class AbstractByteHasher extends AbstractHasher {
    private final ByteBuffer scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    public abstract void update(byte b11);

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public Hasher putByte(byte b11) {
        update(b11);
        return this;
    }

    public Hasher putChar(char c11) {
        this.scratch.putChar(c11);
        return update(2);
    }

    public Hasher putInt(int i11) {
        this.scratch.putInt(i11);
        return update(4);
    }

    public Hasher putLong(long j11) {
        this.scratch.putLong(j11);
        return update(8);
    }

    public Hasher putShort(short s11) {
        this.scratch.putShort(s11);
        return update(2);
    }

    public void update(byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            update(bArr[i13]);
        }
    }

    public void update(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            update(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
            update(byteBuffer.get());
        }
    }

    public Hasher putBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        update(bArr);
        return this;
    }

    public Hasher putBytes(byte[] bArr, int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
        update(bArr, i11, i12);
        return this;
    }

    private Hasher update(int i11) {
        try {
            update(this.scratch.array(), 0, i11);
            return this;
        } finally {
            this.scratch.clear();
        }
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        update(byteBuffer);
        return this;
    }
}
