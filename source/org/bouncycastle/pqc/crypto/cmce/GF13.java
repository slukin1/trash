package org.bouncycastle.pqc.crypto.cmce;

class GF13 extends GF {
    public GF13(int i11) {
        super(i11);
    }

    private short gf_sq2mul(short s11, short s12) {
        long[] jArr = {2301339409586323456L, 4494803534348288L, 8778913153024L, 17146314752L, 33423360, 122880};
        long j11 = (long) s11;
        long j12 = (long) s12;
        long j13 = (j12 << 18) * (64 & j11);
        long j14 = j11 ^ (j11 << 21);
        long j15 = ((j12 * (j14 & 8589934624L)) << 15) ^ (((((j13 ^ ((268435457 & j14) * j12)) ^ (((536870914 & j14) * j12) << 3)) ^ (((1073741828 & j14) * j12) << 6)) ^ (((2147483656L & j14) * j12) << 9)) ^ (((4294967312L & j14) * j12) << 12));
        for (int i11 = 0; i11 < 6; i11++) {
            long j16 = jArr[i11] & j15;
            j15 ^= (j16 >> 13) ^ (((j16 >> 9) ^ (j16 >> 10)) ^ (j16 >> 12));
        }
        return (short) ((int) (j15 & ((long) this.GFMASK)));
    }

    private short gf_sqmul(short s11, short s12) {
        long[] jArr = {137170518016L, 267911168, 516096};
        long j11 = (long) s11;
        long j12 = (long) s12;
        long j13 = (j12 << 6) * (64 & j11);
        long j14 = j11 ^ (j11 << 7);
        long j15 = ((j12 * (j14 & 524320)) << 5) ^ (((((j13 ^ ((16385 & j14) * j12)) ^ (((32770 & j14) * j12) << 1)) ^ (((65540 & j14) * j12) << 2)) ^ (((131080 & j14) * j12) << 3)) ^ (((262160 & j14) * j12) << 4));
        for (int i11 = 0; i11 < 3; i11++) {
            long j16 = jArr[i11] & j15;
            j15 ^= (j16 >> 13) ^ (((j16 >> 9) ^ (j16 >> 10)) ^ (j16 >> 12));
        }
        return (short) ((int) (j15 & ((long) this.GFMASK)));
    }

    public short gf_frac(short s11, short s12) {
        short gf_sqmul = gf_sqmul(s11, s11);
        short gf_sq2mul = gf_sq2mul(gf_sqmul, gf_sqmul);
        return gf_sqmul(gf_sq2mul(gf_sq2(gf_sq2mul(gf_sq2(gf_sq2mul), gf_sq2mul)), gf_sq2mul), s12);
    }

    public short gf_inv(short s11) {
        return gf_frac(s11, 1);
    }

    public short gf_mul(short s11, short s12) {
        long j11 = (long) s11;
        long j12 = (long) s12;
        long j13 = (1 & j12) * j11;
        for (int i11 = 1; i11 < this.GFBITS; i11++) {
            j13 ^= (((long) (1 << i11)) & j12) * j11;
        }
        long j14 = 33488896 & j13;
        long j15 = ((j14 >> 13) ^ (((j14 >> 9) ^ (j14 >> 10)) ^ (j14 >> 12))) ^ j13;
        long j16 = 57344 & j15;
        return (short) ((int) ((j15 ^ ((((j16 >> 10) ^ (j16 >> 9)) ^ (j16 >> 12)) ^ (j16 >> 13))) & ((long) this.GFMASK)));
    }

    public short gf_sq2(short s11) {
        long[] jArr = {1229782938247303441L, 217020518514230019L, 4222189076152335L, 1095216660735L};
        long[] jArr2 = {561850441793536L, 1097364144128L, 2143289344, 4186112};
        long j11 = (long) s11;
        long j12 = (j11 | (j11 << 24)) & jArr[3];
        long j13 = (j12 | (j12 << 12)) & jArr[2];
        long j14 = (j13 | (j13 << 6)) & jArr[1];
        long j15 = (j14 | (j14 << 3)) & jArr[0];
        for (int i11 = 0; i11 < 4; i11++) {
            long j16 = jArr2[i11] & j15;
            j15 ^= (j16 >> 13) ^ (((j16 >> 9) ^ (j16 >> 10)) ^ (j16 >> 12));
        }
        return (short) ((int) (((long) this.GFMASK) & j15));
    }
}
