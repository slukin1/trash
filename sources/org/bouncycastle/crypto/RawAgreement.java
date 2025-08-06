package org.bouncycastle.crypto;

public interface RawAgreement {
    void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i11);

    int getAgreementSize();

    void init(CipherParameters cipherParameters);
}
