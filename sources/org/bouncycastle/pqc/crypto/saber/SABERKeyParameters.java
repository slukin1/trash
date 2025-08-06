package org.bouncycastle.pqc.crypto.saber;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class SABERKeyParameters extends AsymmetricKeyParameter {
    private SABERParameters params;

    public SABERKeyParameters(boolean z11, SABERParameters sABERParameters) {
        super(z11);
        this.params = sABERParameters;
    }

    public SABERParameters getParameters() {
        return this.params;
    }
}
