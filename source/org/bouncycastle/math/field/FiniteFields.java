package org.bouncycastle.math.field;

import java.math.BigInteger;
import org.bouncycastle.util.BigIntegers;

public abstract class FiniteFields {
    public static final FiniteField GF_2 = new PrimeField(BigInteger.valueOf(2));
    public static final FiniteField GF_3 = new PrimeField(BigInteger.valueOf(3));

    public static PolynomialExtensionField getBinaryExtensionField(int[] iArr) {
        if (iArr[0] == 0) {
            int i11 = 1;
            while (i11 < iArr.length) {
                if (iArr[i11] > iArr[i11 - 1]) {
                    i11++;
                } else {
                    throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
                }
            }
            return new GenericPolynomialExtensionField(GF_2, new GF2Polynomial(iArr));
        }
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }

    public static FiniteField getPrimeField(BigInteger bigInteger) {
        int bitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            int intValueExact = BigIntegers.intValueExact(bigInteger);
            if (intValueExact == 2) {
                return GF_2;
            }
            if (intValueExact == 3) {
                return GF_3;
            }
        }
        return new PrimeField(bigInteger);
    }
}
