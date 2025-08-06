package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;

public class ShortenedDigest implements ExtendedDigest {
    private ExtendedDigest baseDigest;
    private int length;

    public ShortenedDigest(ExtendedDigest extendedDigest, int i11) {
        if (extendedDigest == null) {
            throw new IllegalArgumentException("baseDigest must not be null");
        } else if (i11 <= extendedDigest.getDigestSize()) {
            this.baseDigest = extendedDigest;
            this.length = i11;
        } else {
            throw new IllegalArgumentException("baseDigest output not large enough to support length");
        }
    }

    public int doFinal(byte[] bArr, int i11) {
        byte[] bArr2 = new byte[this.baseDigest.getDigestSize()];
        this.baseDigest.doFinal(bArr2, 0);
        System.arraycopy(bArr2, 0, bArr, i11, this.length);
        return this.length;
    }

    public String getAlgorithmName() {
        return this.baseDigest.getAlgorithmName() + "(" + (this.length * 8) + ")";
    }

    public int getByteLength() {
        return this.baseDigest.getByteLength();
    }

    public int getDigestSize() {
        return this.length;
    }

    public void reset() {
        this.baseDigest.reset();
    }

    public void update(byte b11) {
        this.baseDigest.update(b11);
    }

    public void update(byte[] bArr, int i11, int i12) {
        this.baseDigest.update(bArr, i11, i12);
    }
}
