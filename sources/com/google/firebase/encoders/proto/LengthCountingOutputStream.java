package com.google.firebase.encoders.proto;

import java.io.OutputStream;

final class LengthCountingOutputStream extends OutputStream {
    private long length = 0;

    public long getLength() {
        return this.length;
    }

    public void write(int i11) {
        this.length++;
    }

    public void write(byte[] bArr) {
        this.length += (long) bArr.length;
    }

    public void write(byte[] bArr, int i11, int i12) {
        int i13;
        if (i11 < 0 || i11 > bArr.length || i12 < 0 || (i13 = i11 + i12) > bArr.length || i13 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.length += (long) i12;
    }
}
