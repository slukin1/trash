package com.facebook.stetho.inspector.network;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class CountingOutputStream extends FilterOutputStream {
    private long mCount;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public long getCount() {
        return this.mCount;
    }

    public void write(int i11) throws IOException {
        this.out.write(i11);
        this.mCount++;
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.out.write(bArr, i11, i12);
        this.mCount += (long) i12;
    }
}
