package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.encoders.Hex;

public class SecP160R1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECP160R1_AFFINE_ZS = {new SecP160R1FieldElement(ECConstants.ONE)};
    private static final int SECP160R1_DEFAULT_COORDS = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f59414q = SecP160R1FieldElement.Q;
    public SecP160R1Point infinity = new SecP160R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecP160R1Curve() {
        super(f59414q);
        this.f59387a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.f59388b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.order = new BigInteger(1, Hex.decodeStrict("0100000000000000000001F4C8F927AED3CA752257"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    public ECCurve cloneCurve() {
        return new SecP160R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final int[] iArr = new int[(i12 * 5 * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            Nat160.copy(((SecP160R1FieldElement) eCPoint.getRawXCoord()).f59415x, 0, iArr, i13);
            int i15 = i13 + 5;
            Nat160.copy(((SecP160R1FieldElement) eCPoint.getRawYCoord()).f59415x, 0, iArr, i15);
            i13 = i15 + 5;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SecP160R1Curve.this.createRawPoint(new SecP160R1FieldElement(iArr), new SecP160R1FieldElement(iArr2), SecP160R1Curve.SECP160R1_AFFINE_ZS);
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                int[] create = Nat160.create();
                int[] create2 = Nat160.create();
                int i12 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = ((i13 ^ i11) - 1) >> 31;
                    for (int i15 = 0; i15 < 5; i15++) {
                        int i16 = create[i15];
                        int[] iArr = iArr;
                        create[i15] = i16 ^ (iArr[i12 + i15] & i14);
                        create2[i15] = create2[i15] ^ (iArr[(i12 + 5) + i15] & i14);
                    }
                    i12 += 10;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i11) {
                int[] create = Nat160.create();
                int[] create2 = Nat160.create();
                int i12 = i11 * 5 * 2;
                for (int i13 = 0; i13 < 5; i13++) {
                    int[] iArr = iArr;
                    create[i13] = iArr[i12 + i13];
                    create2[i13] = iArr[i12 + 5 + i13];
                }
                return createPoint(create, create2);
            }
        };
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP160R1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP160R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP160R1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f59414q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f59414q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat160.create();
        SecP160R1Field.random(secureRandom, create);
        return new SecP160R1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat160.create();
        SecP160R1Field.randomMult(secureRandom, create);
        return new SecP160R1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 2;
    }
}
