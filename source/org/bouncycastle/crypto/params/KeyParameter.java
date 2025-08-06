package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class KeyParameter implements CipherParameters {
    private byte[] key;

    public KeyParameter(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public KeyParameter(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        this.key = bArr2;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
    }

    public byte[] getKey() {
        return this.key;
    }
}
