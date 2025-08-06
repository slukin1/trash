package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKeyParameters extends McElieceCCA2KeyParameters {
    private GF2Matrix matrixG;

    /* renamed from: n  reason: collision with root package name */
    private int f59558n;

    /* renamed from: t  reason: collision with root package name */
    private int f59559t;

    public McElieceCCA2PublicKeyParameters(int i11, int i12, GF2Matrix gF2Matrix, String str) {
        super(false, str);
        this.f59558n = i11;
        this.f59559t = i12;
        this.matrixG = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.matrixG;
    }

    public int getK() {
        return this.matrixG.getNumRows();
    }

    public int getN() {
        return this.f59558n;
    }

    public int getT() {
        return this.f59559t;
    }
}
