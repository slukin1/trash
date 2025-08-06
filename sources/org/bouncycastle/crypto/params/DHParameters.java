package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Properties;

public class DHParameters implements CipherParameters {
    private static final int DEFAULT_MINIMUM_LENGTH = 160;

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f59260g;

    /* renamed from: j  reason: collision with root package name */
    private BigInteger f59261j;

    /* renamed from: l  reason: collision with root package name */
    private int f59262l;

    /* renamed from: m  reason: collision with root package name */
    private int f59263m;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59264p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f59265q;
    private DHValidationParameters validation;

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, (BigInteger) null, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i11) {
        this(bigInteger, bigInteger2, bigInteger3, getDefaultMParam(i11), i11, (BigInteger) null, (DHValidationParameters) null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i11, int i12) {
        this(bigInteger, bigInteger2, bigInteger3, i11, i12, (BigInteger) null, (DHValidationParameters) null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i11, int i12, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (i12 != 0) {
            if (i12 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            } else if (i12 < i11) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i11 <= bigInteger.bitLength() || Properties.isOverrideSet("org.bouncycastle.dh.allow_unsafe_p_value")) {
            this.f59260g = bigInteger2;
            this.f59264p = bigInteger;
            this.f59265q = bigInteger3;
            this.f59263m = i11;
            this.f59262l = i12;
            this.f59261j = bigInteger4;
            this.validation = dHValidationParameters;
            return;
        }
        throw new IllegalArgumentException("unsafe p value so small specific l required");
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, dHValidationParameters);
    }

    private static int getDefaultMParam(int i11) {
        if (i11 == 0) {
            return 160;
        }
        if (i11 < 160) {
            return i11;
        }
        return 160;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters) obj;
        if (getQ() != null) {
            if (!getQ().equals(dHParameters.getQ())) {
                return false;
            }
        } else if (dHParameters.getQ() != null) {
            return false;
        }
        return dHParameters.getP().equals(this.f59264p) && dHParameters.getG().equals(this.f59260g);
    }

    public BigInteger getG() {
        return this.f59260g;
    }

    public BigInteger getJ() {
        return this.f59261j;
    }

    public int getL() {
        return this.f59262l;
    }

    public int getM() {
        return this.f59263m;
    }

    public BigInteger getP() {
        return this.f59264p;
    }

    public BigInteger getQ() {
        return this.f59265q;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) ^ (getQ() != null ? getQ().hashCode() : 0);
    }
}
