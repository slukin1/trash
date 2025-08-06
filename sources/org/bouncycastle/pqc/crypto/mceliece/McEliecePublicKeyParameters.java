package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* renamed from: g  reason: collision with root package name */
    private GF2Matrix f59587g;

    /* renamed from: n  reason: collision with root package name */
    private int f59588n;

    /* renamed from: t  reason: collision with root package name */
    private int f59589t;

    public McEliecePublicKeyParameters(int i11, int i12, GF2Matrix gF2Matrix) {
        super(false, (McElieceParameters) null);
        this.f59588n = i11;
        this.f59589t = i12;
        this.f59587g = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.f59587g;
    }

    public int getK() {
        return this.f59587g.getNumRows();
    }

    public int getN() {
        return this.f59588n;
    }

    public int getT() {
        return this.f59589t;
    }
}
