package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.encoders.Hex;

public class SecP384R1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECP384R1_AFFINE_ZS = {new SecP384R1FieldElement(ECConstants.ONE)};
    private static final int SECP384R1_DEFAULT_COORDS = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f59430q = SecP384R1FieldElement.Q;
    public SecP384R1Point infinity = new SecP384R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecP384R1Curve() {
        super(f59430q);
        this.f59387a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        this.f59388b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    public ECCurve cloneCurve() {
        return new SecP384R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final int[] iArr = new int[(i12 * 12 * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            Nat.copy(12, ((SecP384R1FieldElement) eCPoint.getRawXCoord()).f59431x, 0, iArr, i13);
            int i15 = i13 + 12;
            Nat.copy(12, ((SecP384R1FieldElement) eCPoint.getRawYCoord()).f59431x, 0, iArr, i15);
            i13 = i15 + 12;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SecP384R1Curve.this.createRawPoint(new SecP384R1FieldElement(iArr), new SecP384R1FieldElement(iArr2), SecP384R1Curve.SECP384R1_AFFINE_ZS);
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                int[] create = Nat.create(12);
                int[] create2 = Nat.create(12);
                int i12 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = ((i13 ^ i11) - 1) >> 31;
                    for (int i15 = 0; i15 < 12; i15++) {
                        int i16 = create[i15];
                        int[] iArr = iArr;
                        create[i15] = i16 ^ (iArr[i12 + i15] & i14);
                        create2[i15] = create2[i15] ^ (iArr[(i12 + 12) + i15] & i14);
                    }
                    i12 += 24;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i11) {
                int[] create = Nat.create(12);
                int[] create2 = Nat.create(12);
                int i12 = i11 * 12 * 2;
                for (int i13 = 0; i13 < 12; i13++) {
                    int[] iArr = iArr;
                    create[i13] = iArr[i12 + i13];
                    create2[i13] = iArr[i12 + 12 + i13];
                }
                return createPoint(create, create2);
            }
        };
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP384R1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP384R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP384R1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f59430q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f59430q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat.create(12);
        SecP384R1Field.random(secureRandom, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat.create(12);
        SecP384R1Field.randomMult(secureRandom, create);
        return new SecP384R1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 2;
    }
}
