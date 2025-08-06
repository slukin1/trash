package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

public class BasicEntropySourceProvider implements EntropySourceProvider {
    /* access modifiers changed from: private */
    public final boolean _predictionResistant;
    /* access modifiers changed from: private */
    public final SecureRandom _sr;

    public BasicEntropySourceProvider(SecureRandom secureRandom, boolean z11) {
        this._sr = secureRandom;
        this._predictionResistant = z11;
    }

    public EntropySource get(final int i11) {
        return new EntropySource() {
            public int entropySize() {
                return i11;
            }

            public byte[] getEntropy() {
                if (!(BasicEntropySourceProvider.this._sr instanceof SP800SecureRandom) && !(BasicEntropySourceProvider.this._sr instanceof X931SecureRandom)) {
                    return BasicEntropySourceProvider.this._sr.generateSeed((i11 + 7) / 8);
                }
                byte[] bArr = new byte[((i11 + 7) / 8)];
                BasicEntropySourceProvider.this._sr.nextBytes(bArr);
                return bArr;
            }

            public boolean isPredictionResistant() {
                return BasicEntropySourceProvider.this._predictionResistant;
            }
        };
    }
}
