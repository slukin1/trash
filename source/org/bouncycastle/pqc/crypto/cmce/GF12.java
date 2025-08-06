package org.bouncycastle.pqc.crypto.cmce;

class GF12 extends GF {
    public GF12(int i11) {
        super(i11);
    }

    public short gf_frac(short s11, short s12) {
        return gf_mul(gf_inv(s11), s12);
    }

    public short gf_inv(short s11) {
        short gf_mul = gf_mul(gf_sq(s11), s11);
        short gf_mul2 = gf_mul(gf_sq(gf_sq(gf_mul)), gf_mul);
        return gf_sq(gf_mul(gf_sq(gf_mul(gf_sq(gf_sq(gf_mul(gf_sq(gf_sq(gf_sq(gf_sq(gf_mul2)))), gf_mul2))), gf_mul)), s11));
    }

    public short gf_mul(short s11, short s12) {
        int i11 = (s12 & 1) * s11;
        int i12 = 1;
        while (true) {
            int i13 = this.GFBITS;
            if (i12 < i13) {
                i11 ^= ((1 << i12) & s12) * s11;
                i12++;
            } else {
                int i14 = 8372224 & i11;
                int i15 = (i14 >> 12) ^ ((i14 >> 9) ^ i11);
                int i16 = i15 & 12288;
                return (short) (((i15 ^ (i16 >> 9)) ^ (i16 >> 12)) & ((1 << i13) - 1));
            }
        }
    }

    public short gf_sq(short s11) {
        int[] iArr = {1431655765, 858993459, 252645135, 16711935};
        short s12 = (s11 | (s11 << 8)) & iArr[3];
        short s13 = (s12 | (s12 << 4)) & iArr[2];
        short s14 = (s13 | (s13 << 2)) & iArr[1];
        short s15 = (s14 | (s14 << 1)) & iArr[0];
        short s16 = 8372224 & s15;
        short s17 = (s15 ^ (s16 >> 9)) ^ (s16 >> 12);
        short s18 = s17 & 12288;
        return (short) (((s17 ^ (s18 >> 9)) ^ (s18 >> 12)) & ((1 << this.GFBITS) - 1));
    }
}
