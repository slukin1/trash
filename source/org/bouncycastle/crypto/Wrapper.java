package org.bouncycastle.crypto;

public interface Wrapper {
    String getAlgorithmName();

    void init(boolean z11, CipherParameters cipherParameters);

    byte[] unwrap(byte[] bArr, int i11, int i12) throws InvalidCipherTextException;

    byte[] wrap(byte[] bArr, int i11, int i12);
}
