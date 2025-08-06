package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class RSAKeyGenerationParameters extends KeyGenerationParameters {
    private int certainty;
    private BigInteger publicExponent;

    public RSAKeyGenerationParameters(BigInteger bigInteger, SecureRandom secureRandom, int i11, int i12) {
        super(secureRandom, i11);
        if (i11 < 12) {
            throw new IllegalArgumentException("key strength too small");
        } else if (bigInteger.testBit(0)) {
            this.publicExponent = bigInteger;
            this.certainty = i12;
        } else {
            throw new IllegalArgumentException("public exponent cannot be even");
        }
    }

    public int getCertainty() {
        return this.certainty;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }
}
