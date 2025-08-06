package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WTauNafMultiplier;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.encoders.Hex;

public class SecT233K1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT233K1_AFFINE_ZS = {new SecT233FieldElement(ECConstants.ONE)};
    private static final int SECT233K1_DEFAULT_COORDS = 6;
    public SecT233K1Point infinity = new SecT233K1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT233K1Curve() {
        super(233, 74, 0, 0);
        this.f59387a = fromBigInteger(BigInteger.valueOf(0));
        this.f59388b = fromBigInteger(BigInteger.valueOf(1));
        this.order = new BigInteger(1, Hex.decodeStrict("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF"));
        this.cofactor = BigInteger.valueOf(4);
        this.coord = 6;
    }

    public ECCurve cloneCurve() {
        return new SecT233K1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final long[] jArr = new long[(i12 * 4 * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            Nat256.copy64(((SecT233FieldElement) eCPoint.getRawXCoord()).f59438x, 0, jArr, i13);
            int i15 = i13 + 4;
            Nat256.copy64(((SecT233FieldElement) eCPoint.getRawYCoord()).f59438x, 0, jArr, i15);
            i13 = i15 + 4;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT233K1Curve.this.createRawPoint(new SecT233FieldElement(jArr), new SecT233FieldElement(jArr2), SecT233K1Curve.SECT233K1_AFFINE_ZS);
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                long[] create64 = Nat256.create64();
                long[] create642 = Nat256.create64();
                int i12 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    long j11 = (long) (((i13 ^ i11) - 1) >> 31);
                    for (int i14 = 0; i14 < 4; i14++) {
                        long j12 = create64[i14];
                        long[] jArr = jArr;
                        create64[i14] = j12 ^ (jArr[i12 + i14] & j11);
                        create642[i14] = create642[i14] ^ (jArr[(i12 + 4) + i14] & j11);
                    }
                    i12 += 8;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i11) {
                long[] create64 = Nat256.create64();
                long[] create642 = Nat256.create64();
                int i12 = i11 * 4 * 2;
                for (int i13 = 0; i13 < 4; i13++) {
                    long[] jArr = jArr;
                    create64[i13] = jArr[i12 + i13];
                    create642[i13] = jArr[i12 + 4 + i13];
                }
                return createPoint(create64, create642);
            }
        };
    }

    public ECMultiplier createDefaultMultiplier() {
        return new WTauNafMultiplier();
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT233K1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT233K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT233FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return 233;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 74;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 233;
    }

    public boolean isKoblitz() {
        return true;
    }

    public boolean isTrinomial() {
        return true;
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 6;
    }
}
