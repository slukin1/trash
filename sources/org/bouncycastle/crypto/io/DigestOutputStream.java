package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Digest;

public class DigestOutputStream extends OutputStream {
    public Digest digest;

    public DigestOutputStream(Digest digest2) {
        this.digest = digest2;
    }

    public byte[] getDigest() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    public void write(int i11) throws IOException {
        this.digest.update((byte) i11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.digest.update(bArr, i11, i12);
    }
}
