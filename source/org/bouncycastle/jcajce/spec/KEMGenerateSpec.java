package org.bouncycastle.jcajce.spec;

import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;

public class KEMGenerateSpec implements AlgorithmParameterSpec {
    private final String keyAlgorithmName;
    private final PublicKey publicKey;

    public KEMGenerateSpec(PublicKey publicKey2, String str) {
        this.publicKey = publicKey2;
        this.keyAlgorithmName = str;
    }

    public String getKeyAlgorithmName() {
        return this.keyAlgorithmName;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }
}
