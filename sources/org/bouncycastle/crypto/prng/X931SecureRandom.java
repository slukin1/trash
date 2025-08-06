package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

public class X931SecureRandom extends SecureRandom {
    private final X931RNG drbg;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    public X931SecureRandom(SecureRandom secureRandom, X931RNG x931rng, boolean z11) {
        this.randomSource = secureRandom;
        this.drbg = x931rng;
        this.predictionResistant = z11;
    }

    public byte[] generateSeed(int i11) {
        return EntropyUtil.generateSeed(this.drbg.getEntropySource(), i11);
    }

    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.drbg.generate(bArr, this.predictionResistant) < 0) {
                this.drbg.reseed();
                this.drbg.generate(bArr, this.predictionResistant);
            }
        }
    }

    public void setSeed(long j11) {
        synchronized (this) {
            SecureRandom secureRandom = this.randomSource;
            if (secureRandom != null) {
                secureRandom.setSeed(j11);
            }
        }
    }

    public void setSeed(byte[] bArr) {
        synchronized (this) {
            SecureRandom secureRandom = this.randomSource;
            if (secureRandom != null) {
                secureRandom.setSeed(bArr);
            }
        }
    }
}
