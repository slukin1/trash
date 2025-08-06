package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithSalt implements CipherParameters {
    private CipherParameters parameters;
    private byte[] salt;

    public ParametersWithSalt(CipherParameters cipherParameters, byte[] bArr) {
        this(cipherParameters, bArr, 0, bArr.length);
    }

    public ParametersWithSalt(CipherParameters cipherParameters, byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        this.salt = bArr2;
        this.parameters = cipherParameters;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }

    public byte[] getSalt() {
        return this.salt;
    }
}
