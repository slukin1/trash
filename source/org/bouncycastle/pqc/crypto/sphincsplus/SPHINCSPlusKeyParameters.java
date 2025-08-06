package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class SPHINCSPlusKeyParameters extends AsymmetricKeyParameter {
    public final SPHINCSPlusParameters parameters;

    public SPHINCSPlusKeyParameters(boolean z11, SPHINCSPlusParameters sPHINCSPlusParameters) {
        super(z11);
        this.parameters = sPHINCSPlusParameters;
    }

    public SPHINCSPlusParameters getParameters() {
        return this.parameters;
    }
}
