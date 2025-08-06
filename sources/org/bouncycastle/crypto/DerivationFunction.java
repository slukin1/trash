package org.bouncycastle.crypto;

public interface DerivationFunction {
    int generateBytes(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalArgumentException;

    void init(DerivationParameters derivationParameters);
}
