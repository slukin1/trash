package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

public class GF2mField {
    private int degree = 0;
    private int polynomial;

    public GF2mField(int i11) {
        if (i11 >= 32) {
            throw new IllegalArgumentException(" Error: the degree of field is too large ");
        } else if (i11 >= 1) {
            this.degree = i11;
            this.polynomial = PolynomialRingGF2.getIrreduciblePolynomial(i11);
        } else {
            throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
        }
    }

    public GF2mField(int i11, int i12) {
        if (i11 != PolynomialRingGF2.degree(i12)) {
            throw new IllegalArgumentException(" Error: the degree is not correct");
        } else if (PolynomialRingGF2.isIrreducible(i12)) {
            this.degree = i11;
            this.polynomial = i12;
        } else {
            throw new IllegalArgumentException(" Error: given polynomial is reducible");
        }
    }

    public GF2mField(GF2mField gF2mField) {
        this.degree = gF2mField.degree;
        this.polynomial = gF2mField.polynomial;
    }

    public GF2mField(byte[] bArr) {
        if (bArr.length == 4) {
            int OS2IP = LittleEndianConversions.OS2IP(bArr);
            this.polynomial = OS2IP;
            if (PolynomialRingGF2.isIrreducible(OS2IP)) {
                this.degree = PolynomialRingGF2.degree(this.polynomial);
                return;
            }
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    private static String polyToString(int i11) {
        if (i11 == 0) {
            return "0";
        }
        String str = ((byte) (i11 & 1)) == 1 ? "1" : "";
        int i12 = i11 >>> 1;
        int i13 = 1;
        while (i12 != 0) {
            if (((byte) (i12 & 1)) == 1) {
                str = str + "+x^" + i13;
            }
            i12 >>>= 1;
            i13++;
        }
        return str;
    }

    public int add(int i11, int i12) {
        return i11 ^ i12;
    }

    public String elementToStr(int i11) {
        String str;
        StringBuilder sb2;
        String str2 = "";
        for (int i12 = 0; i12 < this.degree; i12++) {
            if ((((byte) i11) & 1) == 0) {
                sb2 = new StringBuilder();
                str = "0";
            } else {
                sb2 = new StringBuilder();
                str = "1";
            }
            sb2.append(str);
            sb2.append(str2);
            str2 = sb2.toString();
            i11 >>>= 1;
        }
        return str2;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof GF2mField)) {
            GF2mField gF2mField = (GF2mField) obj;
            return this.degree == gF2mField.degree && this.polynomial == gF2mField.polynomial;
        }
    }

    public int exp(int i11, int i12) {
        if (i12 == 0) {
            return 1;
        }
        if (i11 == 0) {
            return 0;
        }
        if (i11 == 1) {
            return 1;
        }
        if (i12 < 0) {
            i11 = inverse(i11);
            i12 = -i12;
        }
        int i13 = 1;
        while (i12 != 0) {
            if ((i12 & 1) == 1) {
                i13 = mult(i13, i11);
            }
            i11 = mult(i11, i11);
            i12 >>>= 1;
        }
        return i13;
    }

    public int getDegree() {
        return this.degree;
    }

    public byte[] getEncoded() {
        return LittleEndianConversions.I2OSP(this.polynomial);
    }

    public int getPolynomial() {
        return this.polynomial;
    }

    public int getRandomElement(SecureRandom secureRandom) {
        return RandUtils.nextInt(secureRandom, 1 << this.degree);
    }

    public int getRandomNonZeroElement() {
        return getRandomNonZeroElement(CryptoServicesRegistrar.getSecureRandom());
    }

    public int getRandomNonZeroElement(SecureRandom secureRandom) {
        int nextInt = RandUtils.nextInt(secureRandom, 1 << this.degree);
        int i11 = 0;
        while (nextInt == 0 && i11 < 1048576) {
            nextInt = RandUtils.nextInt(secureRandom, 1 << this.degree);
            i11++;
        }
        if (i11 == 1048576) {
            return 1;
        }
        return nextInt;
    }

    public int hashCode() {
        return this.polynomial;
    }

    public int inverse(int i11) {
        return exp(i11, (1 << this.degree) - 2);
    }

    public boolean isElementOfThisField(int i11) {
        int i12 = this.degree;
        return i12 == 31 ? i11 >= 0 : i11 >= 0 && i11 < (1 << i12);
    }

    public int mult(int i11, int i12) {
        return PolynomialRingGF2.modMultiply(i11, i12, this.polynomial);
    }

    public int sqRoot(int i11) {
        for (int i12 = 1; i12 < this.degree; i12++) {
            i11 = mult(i11, i11);
        }
        return i11;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.degree + ") = GF(2)[X]/<" + polyToString(this.polynomial) + "> ";
    }
}
