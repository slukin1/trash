package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

public class MGFParameters implements DerivationParameters {
    public byte[] seed;

    public MGFParameters(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public MGFParameters(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        this.seed = bArr2;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
    }

    public byte[] getSeed() {
        return this.seed;
    }
}
