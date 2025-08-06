package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat320;
import org.bouncycastle.util.encoders.Hex;

public class SecT283R1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT283R1_AFFINE_ZS = {new SecT283FieldElement(ECConstants.ONE)};
    private static final int SECT283R1_DEFAULT_COORDS = 6;
    public SecT283R1Point infinity = new SecT283R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT283R1Curve() {
        super(283, 5, 7, 12);
        this.f59387a = fromBigInteger(BigInteger.valueOf(1));
        this.f59388b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("027B680AC8B8596DA5A4AF8A19A0303FCA97FD7645309FA2A581485AF6263E313B79A2F5")));
        this.order = new BigInteger(1, Hex.decodeStrict("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEF90399660FC938A90165B042A7CEFADB307"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    public ECCurve cloneCurve() {
        return new SecT283R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final long[] jArr = new long[(i12 * 5 * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            Nat320.copy64(((SecT283FieldElement) eCPoint.getRawXCoord()).f59440x, 0, jArr, i13);
            int i15 = i13 + 5;
            Nat320.copy64(((SecT283FieldElement) eCPoint.getRawYCoord()).f59440x, 0, jArr, i15);
            i13 = i15 + 5;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT283R1Curve.this.createRawPoint(new SecT283FieldElement(jArr), new SecT283FieldElement(jArr2), SecT283R1Curve.SECT283R1_AFFINE_ZS);
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                long[] create64 = Nat320.create64();
                long[] create642 = Nat320.create64();
                int i12 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    long j11 = (long) (((i13 ^ i11) - 1) >> 31);
                    for (int i14 = 0; i14 < 5; i14++) {
                        long j12 = create64[i14];
                        long[] jArr = jArr;
                        create64[i14] = j12 ^ (jArr[i12 + i14] & j11);
                        create642[i14] = create642[i14] ^ (jArr[(i12 + 5) + i14] & j11);
                    }
                    i12 += 10;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i11) {
                long[] create64 = Nat320.create64();
                long[] create642 = Nat320.create64();
                int i12 = i11 * 5 * 2;
                for (int i13 = 0; i13 < 5; i13++) {
                    long[] jArr = jArr;
                    create64[i13] = jArr[i12 + i13];
                    create642[i13] = jArr[i12 + 5 + i13];
                }
                return createPoint(create64, create642);
            }
        };
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT283R1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT283R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT283FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return 283;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 5;
    }

    public int getK2() {
        return 7;
    }

    public int getK3() {
        return 12;
    }

    public int getM() {
        return 283;
    }

    public boolean isKoblitz() {
        return false;
    }

    public boolean isTrinomial() {
        return false;
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 6;
    }
}
