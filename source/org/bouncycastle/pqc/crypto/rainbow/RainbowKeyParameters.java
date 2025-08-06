package org.bouncycastle.pqc.crypto.rainbow;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class RainbowKeyParameters extends AsymmetricKeyParameter {
    private int docLength;

    public RainbowKeyParameters(boolean z11, int i11) {
        super(z11);
        this.docLength = i11;
    }

    public int getDocLength() {
        return this.docLength;
    }
}
