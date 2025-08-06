package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

class DigestUpdatingOutputStream extends OutputStream {
    private MessageDigest digest;

    public DigestUpdatingOutputStream(MessageDigest messageDigest) {
        this.digest = messageDigest;
    }

    public void write(int i11) throws IOException {
        this.digest.update((byte) i11);
    }

    public void write(byte[] bArr) throws IOException {
        this.digest.update(bArr);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.digest.update(bArr, i11, i12);
    }
}
