package org.bouncycastle.pqc.crypto.cmce;

abstract class GF {
    public final int GFBITS;
    public final int GFMASK;

    public GF(int i11) {
        this.GFBITS = i11;
        this.GFMASK = (1 << i11) - 1;
    }

    public short gf_add(short s11, short s12) {
        return (short) (s11 ^ s12);
    }

    public abstract short gf_frac(short s11, short s12);

    public abstract short gf_inv(short s11);

    public short gf_iszero(short s11) {
        return (short) ((s11 - 1) >>> 19);
    }

    public abstract short gf_mul(short s11, short s12);
}
