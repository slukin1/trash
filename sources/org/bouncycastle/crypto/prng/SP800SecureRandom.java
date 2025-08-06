package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;

public class SP800SecureRandom extends SecureRandom {
    private SP80090DRBG drbg;
    private final DRBGProvider drbgProvider;
    private final EntropySource entropySource;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    public SP800SecureRandom(SecureRandom secureRandom, EntropySource entropySource2, DRBGProvider dRBGProvider, boolean z11) {
        this.randomSource = secureRandom;
        this.entropySource = entropySource2;
        this.drbgProvider = dRBGProvider;
        this.predictionResistant = z11;
    }

    public byte[] generateSeed(int i11) {
        return EntropyUtil.generateSeed(this.entropySource, i11);
    }

    public String getAlgorithm() {
        return this.drbgProvider.getAlgorithm();
    }

    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.drbg == null) {
                this.drbg = this.drbgProvider.get(this.entropySource);
            }
            if (this.drbg.generate(bArr, (byte[]) null, this.predictionResistant) < 0) {
                this.drbg.reseed((byte[]) null);
                this.drbg.generate(bArr, (byte[]) null, this.predictionResistant);
            }
        }
    }

    public void reseed(byte[] bArr) {
        synchronized (this) {
            if (this.drbg == null) {
                this.drbg = this.drbgProvider.get(this.entropySource);
            }
            this.drbg.reseed(bArr);
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
