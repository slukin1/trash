package org.bouncycastle.crypto.params;

import java.util.Objects;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

public class SM2KeyExchangePrivateParameters implements CipherParameters {
    private final ECPrivateKeyParameters ephemeralPrivateKey;
    private final ECPoint ephemeralPublicPoint;
    private final boolean initiator;
    private final ECPrivateKeyParameters staticPrivateKey;
    private final ECPoint staticPublicPoint;

    public SM2KeyExchangePrivateParameters(boolean z11, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2) {
        Objects.requireNonNull(eCPrivateKeyParameters, "staticPrivateKey cannot be null");
        Objects.requireNonNull(eCPrivateKeyParameters2, "ephemeralPrivateKey cannot be null");
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        if (parameters.equals(eCPrivateKeyParameters2.getParameters())) {
            FixedPointCombMultiplier fixedPointCombMultiplier = new FixedPointCombMultiplier();
            this.initiator = z11;
            this.staticPrivateKey = eCPrivateKeyParameters;
            this.staticPublicPoint = fixedPointCombMultiplier.multiply(parameters.getG(), eCPrivateKeyParameters.getD()).normalize();
            this.ephemeralPrivateKey = eCPrivateKeyParameters2;
            this.ephemeralPublicPoint = fixedPointCombMultiplier.multiply(parameters.getG(), eCPrivateKeyParameters2.getD()).normalize();
            return;
        }
        throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
    }

    public ECPrivateKeyParameters getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public ECPoint getEphemeralPublicPoint() {
        return this.ephemeralPublicPoint;
    }

    public ECPrivateKeyParameters getStaticPrivateKey() {
        return this.staticPrivateKey;
    }

    public ECPoint getStaticPublicPoint() {
        return this.staticPublicPoint;
    }

    public boolean isInitiator() {
        return this.initiator;
    }
}
