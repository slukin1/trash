package org.bouncycastle.crypto;

public interface Signer {
    byte[] generateSignature() throws CryptoException, DataLengthException;

    void init(boolean z11, CipherParameters cipherParameters);

    void reset();

    void update(byte b11);

    void update(byte[] bArr, int i11, int i12);

    boolean verifySignature(byte[] bArr);
}
