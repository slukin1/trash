package org.bouncycastle.crypto;

public interface AsymmetricBlockCipher {
    int getInputBlockSize();

    int getOutputBlockSize();

    void init(boolean z11, CipherParameters cipherParameters);

    byte[] processBlock(byte[] bArr, int i11, int i12) throws InvalidCipherTextException;
}
