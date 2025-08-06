package org.bouncycastle.jcajce.spec;

import java.security.PrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class KEMExtractSpec implements AlgorithmParameterSpec {
    private final byte[] encapsulation;
    private final String keyAlgorithmName;
    private final PrivateKey privateKey;

    public KEMExtractSpec(PrivateKey privateKey2, byte[] bArr, String str) {
        this.privateKey = privateKey2;
        this.encapsulation = Arrays.clone(bArr);
        this.keyAlgorithmName = str;
    }

    public byte[] getEncapsulation() {
        return Arrays.clone(this.encapsulation);
    }

    public String getKeyAlgorithmName() {
        return this.keyAlgorithmName;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }
}
