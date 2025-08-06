package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class AsymmetricKeyParameter implements CipherParameters {
    public boolean privateKey;

    public AsymmetricKeyParameter(boolean z11) {
        this.privateKey = z11;
    }

    public boolean isPrivate() {
        return this.privateKey;
    }
}
