package org.bouncycastle.crypto;

public interface KeyEncapsulation {
    CipherParameters decrypt(byte[] bArr, int i11, int i12, int i13);

    CipherParameters encrypt(byte[] bArr, int i11, int i12);

    void init(CipherParameters cipherParameters);
}
