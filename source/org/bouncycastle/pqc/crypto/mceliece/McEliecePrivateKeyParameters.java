package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McEliecePrivateKeyParameters extends McElieceKeyParameters {
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;

    /* renamed from: h  reason: collision with root package name */
    private GF2Matrix f59582h;

    /* renamed from: k  reason: collision with root package name */
    private int f59583k;

    /* renamed from: n  reason: collision with root package name */
    private int f59584n;
    private String oid;

    /* renamed from: p1  reason: collision with root package name */
    private Permutation f59585p1;

    /* renamed from: p2  reason: collision with root package name */
    private Permutation f59586p2;
    private PolynomialGF2mSmallM[] qInv;
    private GF2Matrix sInv;

    public McEliecePrivateKeyParameters(int i11, int i12, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix) {
        super(true, (McElieceParameters) null);
        this.f59583k = i12;
        this.f59584n = i11;
        this.field = gF2mField;
        this.goppaPoly = polynomialGF2mSmallM;
        this.sInv = gF2Matrix;
        this.f59585p1 = permutation;
        this.f59586p2 = permutation2;
        this.f59582h = GoppaCode.createCanonicalCheckMatrix(gF2mField, polynomialGF2mSmallM);
        this.qInv = new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM).getSquareRootMatrix();
    }

    public McEliecePrivateKeyParameters(int i11, int i12, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[][] bArr7) {
        super(true, (McElieceParameters) null);
        this.f59584n = i11;
        this.f59583k = i12;
        GF2mField gF2mField = new GF2mField(bArr);
        this.field = gF2mField;
        this.goppaPoly = new PolynomialGF2mSmallM(gF2mField, bArr2);
        this.sInv = new GF2Matrix(bArr3);
        this.f59585p1 = new Permutation(bArr4);
        this.f59586p2 = new Permutation(bArr5);
        this.f59582h = new GF2Matrix(bArr6);
        this.qInv = new PolynomialGF2mSmallM[bArr7.length];
        for (int i13 = 0; i13 < bArr7.length; i13++) {
            this.qInv[i13] = new PolynomialGF2mSmallM(this.field, bArr7[i13]);
        }
    }

    public GF2mField getField() {
        return this.field;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public GF2Matrix getH() {
        return this.f59582h;
    }

    public int getK() {
        return this.f59583k;
    }

    public int getN() {
        return this.f59584n;
    }

    public Permutation getP1() {
        return this.f59585p1;
    }

    public Permutation getP2() {
        return this.f59586p2;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }

    public GF2Matrix getSInv() {
        return this.sInv;
    }
}
