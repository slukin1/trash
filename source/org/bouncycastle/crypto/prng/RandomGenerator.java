package org.bouncycastle.crypto.prng;

public interface RandomGenerator {
    void addSeedMaterial(long j11);

    void addSeedMaterial(byte[] bArr);

    void nextBytes(byte[] bArr);

    void nextBytes(byte[] bArr, int i11, int i12);
}
