package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;

public class NonMemoableDigest implements ExtendedDigest {
    private ExtendedDigest baseDigest;

    public NonMemoableDigest(ExtendedDigest extendedDigest) {
        if (extendedDigest != null) {
            this.baseDigest = extendedDigest;
            return;
        }
        throw new IllegalArgumentException("baseDigest must not be null");
    }

    public int doFinal(byte[] bArr, int i11) {
        return this.baseDigest.doFinal(bArr, i11);
    }

    public String getAlgorithmName() {
        return this.baseDigest.getAlgorithmName();
    }

    public int getByteLength() {
        return this.baseDigest.getByteLength();
    }

    public int getDigestSize() {
        return this.baseDigest.getDigestSize();
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
