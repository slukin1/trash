package org.bouncycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
import org.bouncycastle.pqc.math.linearalgebra.BigIntUtils;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

final class Conversions {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    private Conversions() {
    }

    public static byte[] decode(int i11, int i12, GF2Vector gF2Vector) {
        if (gF2Vector.getLength() == i11 && gF2Vector.getHammingWeight() == i12) {
            int[] vecArray = gF2Vector.getVecArray();
            BigInteger binomial = IntegerFunctions.binomial(i11, i12);
            BigInteger bigInteger = ZERO;
            int i13 = i11;
            for (int i14 = 0; i14 < i11; i14++) {
                binomial = binomial.multiply(BigInteger.valueOf((long) (i13 - i12))).divide(BigInteger.valueOf((long) i13));
                i13--;
                if ((vecArray[i14 >> 5] & (1 << (i14 & 31))) != 0) {
                    bigInteger = bigInteger.add(binomial);
                    i12--;
                    binomial = i13 == i12 ? ONE : binomial.multiply(BigInteger.valueOf((long) (i12 + 1))).divide(BigInteger.valueOf((long) (i13 - i12)));
                }
            }
            return BigIntUtils.toMinimalByteArray(bigInteger);
        }
        throw new IllegalArgumentException("vector has wrong length or hamming weight");
    }

    public static GF2Vector encode(int i11, int i12, byte[] bArr) {
        if (i11 >= i12) {
            BigInteger binomial = IntegerFunctions.binomial(i11, i12);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(binomial) < 0) {
                GF2Vector gF2Vector = new GF2Vector(i11);
                int i13 = i11;
                for (int i14 = 0; i14 < i11; i14++) {
                    binomial = binomial.multiply(BigInteger.valueOf((long) (i13 - i12))).divide(BigInteger.valueOf((long) i13));
                    i13--;
                    if (binomial.compareTo(bigInteger) <= 0) {
                        gF2Vector.setBit(i14);
                        bigInteger = bigInteger.subtract(binomial);
                        i12--;
                        binomial = i13 == i12 ? ONE : binomial.multiply(BigInteger.valueOf((long) (i12 + 1))).divide(BigInteger.valueOf((long) (i13 - i12)));
                    }
                }
                return gF2Vector;
            }
            throw new IllegalArgumentException("Encoded number too large.");
        }
        throw new IllegalArgumentException("n < t");
    }

    public static byte[] signConversion(int i11, int i12, byte[] bArr) {
        if (i11 >= i12) {
            BigInteger binomial = IntegerFunctions.binomial(i11, i12);
            int bitLength = binomial.bitLength() - 1;
            int i13 = bitLength >> 3;
            int i14 = bitLength & 7;
            int i15 = 8;
            if (i14 == 0) {
                i13--;
                i14 = 8;
            }
            int i16 = i11 >> 3;
            int i17 = i11 & 7;
            if (i17 == 0) {
                i16--;
            } else {
                i15 = i17;
            }
            int i18 = i16 + 1;
            byte[] bArr2 = new byte[i18];
            if (bArr.length < i18) {
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                for (int length = bArr.length; length < i18; length++) {
                    bArr2[length] = 0;
                }
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, i16);
                bArr2[i16] = (byte) (bArr[i16] & ((1 << i15) - 1));
            }
            BigInteger bigInteger = ZERO;
            int i19 = i11;
            for (int i21 = 0; i21 < i11; i21++) {
                binomial = binomial.multiply(new BigInteger(Integer.toString(i19 - i12))).divide(new BigInteger(Integer.toString(i19)));
                i19--;
                if (((byte) (bArr2[i21 >>> 3] & (1 << (i21 & 7)))) != 0) {
                    bigInteger = bigInteger.add(binomial);
                    i12--;
                    binomial = i19 == i12 ? ONE : binomial.multiply(new BigInteger(Integer.toString(i12 + 1))).divide(new BigInteger(Integer.toString(i19 - i12)));
                }
            }
            int i22 = i13 + 1;
            byte[] bArr3 = new byte[i22];
            byte[] byteArray = bigInteger.toByteArray();
            if (byteArray.length < i22) {
                System.arraycopy(byteArray, 0, bArr3, 0, byteArray.length);
                for (int length2 = byteArray.length; length2 < i22; length2++) {
                    bArr3[length2] = 0;
                }
            } else {
                System.arraycopy(byteArray, 0, bArr3, 0, i13);
                bArr3[i13] = (byte) (((1 << i14) - 1) & byteArray[i13]);
            }
            return bArr3;
        }
        throw new IllegalArgumentException("n < t");
    }
}
