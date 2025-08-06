package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class KEMParameterSpec implements AlgorithmParameterSpec {
    private final String keyAlgorithmName;
    private final int keySizeInBits;

    public KEMParameterSpec(String str) {
        this(str, -1);
    }

    public KEMParameterSpec(String str, int i11) {
        this.keyAlgorithmName = str;
        this.keySizeInBits = i11;
    }

    public String getKeyAlgorithmName() {
        return this.keyAlgorithmName;
    }

    public int getKeySizeInBits() {
        return this.keySizeInBits;
    }
}
