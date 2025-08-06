package org.bouncycastle.jcajce.spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;

public class DHDomainParameterSpec extends DHParameterSpec {

    /* renamed from: j  reason: collision with root package name */
    private final BigInteger f59348j;

    /* renamed from: m  reason: collision with root package name */
    private final int f59349m;

    /* renamed from: q  reason: collision with root package name */
    private final BigInteger f59350q;
    private DHValidationParameters validationParameters;

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, (BigInteger) null, 0);
    }

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i11) {
        this(bigInteger, bigInteger2, bigInteger3, (BigInteger) null, i11);
    }

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i11) {
        this(bigInteger, bigInteger2, bigInteger3, bigInteger4, 0, i11);
    }

    public DHDomainParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i11, int i12) {
        super(bigInteger, bigInteger3, i12);
        this.f59350q = bigInteger2;
        this.f59348j = bigInteger4;
        this.f59349m = i11;
    }

    public DHDomainParameterSpec(DHParameters dHParameters) {
        this(dHParameters.getP(), dHParameters.getQ(), dHParameters.getG(), dHParameters.getJ(), dHParameters.getM(), dHParameters.getL());
        this.validationParameters = dHParameters.getValidationParameters();
    }

    public DHParameters getDomainParameters() {
        return new DHParameters(getP(), getG(), this.f59350q, this.f59349m, getL(), this.f59348j, this.validationParameters);
    }

    public BigInteger getJ() {
        return this.f59348j;
    }

    public int getM() {
        return this.f59349m;
    }

    public BigInteger getQ() {
        return this.f59350q;
    }
}
