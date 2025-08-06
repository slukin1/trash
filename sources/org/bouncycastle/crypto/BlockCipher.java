package org.bouncycastle.crypto;

public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException;

    int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException;

    void reset();
}
