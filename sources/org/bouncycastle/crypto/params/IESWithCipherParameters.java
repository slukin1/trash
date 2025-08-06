package org.bouncycastle.crypto.params;

public class IESWithCipherParameters extends IESParameters {
    private int cipherKeySize;

    public IESWithCipherParameters(byte[] bArr, byte[] bArr2, int i11, int i12) {
        super(bArr, bArr2, i11);
        this.cipherKeySize = i12;
    }

    public int getCipherKeySize() {
        return this.cipherKeySize;
    }
}
