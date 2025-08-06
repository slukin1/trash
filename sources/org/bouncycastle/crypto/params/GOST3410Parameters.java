package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class GOST3410Parameters implements CipherParameters {

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f59284a;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59285p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f59286q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f59285p = bigInteger;
        this.f59286q = bigInteger2;
        this.f59284a = bigInteger3;
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f59284a = bigInteger3;
        this.f59285p = bigInteger;
        this.f59286q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        return gOST3410Parameters.getP().equals(this.f59285p) && gOST3410Parameters.getQ().equals(this.f59286q) && gOST3410Parameters.getA().equals(this.f59284a);
    }

    public BigInteger getA() {
        return this.f59284a;
    }

    public BigInteger getP() {
        return this.f59285p;
    }

    public BigInteger getQ() {
        return this.f59286q;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (this.f59285p.hashCode() ^ this.f59286q.hashCode()) ^ this.f59284a.hashCode();
    }
}
