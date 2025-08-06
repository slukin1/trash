package org.bouncycastle.util.test;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.crypto.prng.EntropySourceProvider;

public class TestRandomEntropySourceProvider implements EntropySourceProvider {
    /* access modifiers changed from: private */
    public final boolean _predictionResistant;
    /* access modifiers changed from: private */
    public final SecureRandom _sr = new SecureRandom();

    public TestRandomEntropySourceProvider(boolean z11) {
        this._predictionResistant = z11;
    }

    public EntropySource get(final int i11) {
        return new EntropySource() {
            public int entropySize() {
                return i11;
            }

            public byte[] getEntropy() {
                byte[] bArr = new byte[((i11 + 7) / 8)];
                TestRandomEntropySourceProvider.this._sr.nextBytes(bArr);
                return bArr;
            }

            public boolean isPredictionResistant() {
                return TestRandomEntropySourceProvider.this._predictionResistant;
            }
        };
    }
}
