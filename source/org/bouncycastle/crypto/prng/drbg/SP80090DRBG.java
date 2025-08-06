package org.bouncycastle.crypto.prng.drbg;

public interface SP80090DRBG {
    int generate(byte[] bArr, byte[] bArr2, boolean z11);

    int getBlockSize();

    void reseed(byte[] bArr);
}
