package org.bouncycastle.math.ec.custom.djb;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.encoders.Hex;

public class Curve25519 extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] CURVE25519_AFFINE_ZS;
    private static final int CURVE25519_DEFAULT_COORDS = 4;
    private static final BigInteger C_a;
    private static final BigInteger C_b = new BigInteger(1, Hex.decodeStrict("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864"));

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f59407q = Curve25519FieldElement.Q;
    public Curve25519Point infinity = new Curve25519Point(this, (ECFieldElement) null, (ECFieldElement) null);

    static {
        BigInteger bigInteger = new BigInteger(1, Hex.decodeStrict("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144"));
        C_a = bigInteger;
        CURVE25519_AFFINE_ZS = new ECFieldElement[]{new Curve25519FieldElement(ECConstants.ONE), new Curve25519FieldElement(bigInteger)};
    }

    public Curve25519() {
        super(f59407q);
        this.f59387a = fromBigInteger(C_a);
        this.f59388b = fromBigInteger(C_b);
        this.order = new BigInteger(1, Hex.decodeStrict("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.cofactor = BigInteger.valueOf(8);
        this.coord = 4;
    }

    public ECCurve cloneCurve() {
        return new Curve25519();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final int[] iArr = new int[(i12 * 8 * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            Nat256.copy(((Curve25519FieldElement) eCPoint.getRawXCoord()).f59408x, 0, iArr, i13);
            int i15 = i13 + 8;
            Nat256.copy(((Curve25519FieldElement) eCPoint.getRawYCoord()).f59408x, 0, iArr, i15);
            i13 = i15 + 8;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return Curve25519.this.createRawPoint(new Curve25519FieldElement(iArr), new Curve25519FieldElement(iArr2), Curve25519.CURVE25519_AFFINE_ZS);
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                int[] create = Nat256.create();
                int[] create2 = Nat256.create();
                int i12 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = ((i13 ^ i11) - 1) >> 31;
                    for (int i15 = 0; i15 < 8; i15++) {
                        int i16 = create[i15];
                        int[] iArr = iArr;
                        create[i15] = i16 ^ (iArr[i12 + i15] & i14);
                        create2[i15] = create2[i15] ^ (iArr[(i12 + 8) + i15] & i14);
                    }
                    i12 += 16;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i11) {
                int[] create = Nat256.create();
                int[] create2 = Nat256.create();
                int i12 = i11 * 8 * 2;
                for (int i13 = 0; i13 < 8; i13++) {
                    int[] iArr = iArr;
                    create[i13] = iArr[i12 + i13];
                    create2[i13] = iArr[i12 + 8 + i13];
                }
                return createPoint(create, create2);
            }
        };
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new Curve25519Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new Curve25519Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new Curve25519FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f59407q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f59407q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat256.create();
        Curve25519Field.random(secureRandom, create);
        return new Curve25519FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat256.create();
        Curve25519Field.randomMult(secureRandom, create);
        return new Curve25519FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 4;
    }
}
