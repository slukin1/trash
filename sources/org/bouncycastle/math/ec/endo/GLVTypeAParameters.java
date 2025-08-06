package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

public class GLVTypeAParameters {

    /* renamed from: i  reason: collision with root package name */
    public final BigInteger f59443i;
    public final BigInteger lambda;
    public final ScalarSplitParameters splitParams;

    public GLVTypeAParameters(BigInteger bigInteger, BigInteger bigInteger2, ScalarSplitParameters scalarSplitParameters) {
        this.f59443i = bigInteger;
        this.lambda = bigInteger2;
        this.splitParams = scalarSplitParameters;
    }

    public BigInteger getI() {
        return this.f59443i;
    }

    public BigInteger getLambda() {
        return this.lambda;
    }

    public ScalarSplitParameters getSplitParams() {
        return this.splitParams;
    }
}
