package org.bouncycastle.crypto.params;

import java.util.Objects;

public class ECKeyParameters extends AsymmetricKeyParameter {
    private final ECDomainParameters parameters;

    public ECKeyParameters(boolean z11, ECDomainParameters eCDomainParameters) {
        super(z11);
        Objects.requireNonNull(eCDomainParameters, "'parameters' cannot be null");
        this.parameters = eCDomainParameters;
    }

    public ECDomainParameters getParameters() {
        return this.parameters;
    }
}
