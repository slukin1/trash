package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

public class GLVTypeBParameters {
    public final BigInteger beta;
    public final BigInteger lambda;
    public final ScalarSplitParameters splitParams;

    public GLVTypeBParameters(BigInteger bigInteger, BigInteger bigInteger2, ScalarSplitParameters scalarSplitParameters) {
        this.beta = bigInteger;
        this.lambda = bigInteger2;
        this.splitParams = scalarSplitParameters;
    }

    public BigInteger getBeta() {
        return this.beta;
    }

    public BigInteger getLambda() {
        return this.lambda;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }
}
