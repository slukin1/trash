package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class DSAParameters implements CipherParameters {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f59270g;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59271p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f59272q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f59270g = bigInteger3;
        this.f59271p = bigInteger;
        this.f59272q = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f59270g = bigInteger3;
        this.f59271p = bigInteger;
        this.f59272q = bigInteger2;
        this.validation = dSAValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        return dSAParameters.getP().equals(this.f59271p) && dSAParameters.getQ().equals(this.f59272q) && dSAParameters.getG().equals(this.f59270g);
    }

    public BigInteger getG() {
        return this.f59270g;
    }

    public BigInteger getP() {
        return this.f59271p;
    }

    public BigInteger getQ() {
        return this.f59272q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}
