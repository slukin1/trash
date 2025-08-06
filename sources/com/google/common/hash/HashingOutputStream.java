package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
public final class HashingOutputStream extends FilterOutputStream {
    private final Hasher hasher;

    public HashingOutputStream(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
        this.hasher = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    public void close() throws IOException {
        this.out.close();
    }

    public HashCode hash() {
        return this.hasher.hash();
    }

    public void write(int i11) throws IOException {
        this.hasher.putByte((byte) i11);
        this.out.write(i11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.hasher.putBytes(bArr, i11, i12);
        this.out.write(bArr, i11, i12);
    }
}
