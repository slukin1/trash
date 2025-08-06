package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class ElGamalGenParameterSpec implements AlgorithmParameterSpec {
    private int primeSize;

    public ElGamalGenParameterSpec(int i11) {
        this.primeSize = i11;
    }

    public int getPrimeSize() {
        return this.primeSize;
    }
}
