package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

class WotsPlus {
    private final SPHINCSPlusEngine engine;

    /* renamed from: w  reason: collision with root package name */
    private final int f59613w;

    public WotsPlus(SPHINCSPlusEngine sPHINCSPlusEngine) {
        this.engine = sPHINCSPlusEngine;
        this.f59613w = sPHINCSPlusEngine.WOTS_W;
    }

    public int[] base_w(byte[] bArr, int i11, int i12) {
        int[] iArr = new int[i12];
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        byte b11 = 0;
        for (int i16 = 0; i16 < i12; i16++) {
            if (i13 == 0) {
                b11 = bArr[i14];
                i14++;
                i13 += 8;
            }
            i13 -= this.engine.WOTS_LOGW;
            iArr[i15] = (b11 >>> i13) & (i11 - 1);
            i15++;
        }
        return iArr;
    }

    public byte[] chain(byte[] bArr, int i11, int i12, byte[] bArr2, ADRS adrs) {
        if (i12 == 0) {
            return Arrays.clone(bArr);
        }
        int i13 = i11 + i12;
        if (i13 > this.f59613w - 1) {
            return null;
        }
        byte[] chain = chain(bArr, i11, i12 - 1, bArr2, adrs);
        adrs.setHashAddress(i13 - 1);
        return this.engine.F(bArr2, adrs, chain);
    }

    public byte[] pkFromSig(byte[] bArr, byte[] bArr2, byte[] bArr3, ADRS adrs) {
        SPHINCSPlusEngine sPHINCSPlusEngine;
        ADRS adrs2 = adrs;
        ADRS adrs3 = new ADRS(adrs2);
        int[] base_w = base_w(bArr2, this.f59613w, this.engine.WOTS_LEN1);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            sPHINCSPlusEngine = this.engine;
            if (i11 >= sPHINCSPlusEngine.WOTS_LEN1) {
                break;
            }
            i12 += (this.f59613w - 1) - base_w[i11];
            i11++;
        }
        int i13 = sPHINCSPlusEngine.WOTS_LEN2;
        int i14 = sPHINCSPlusEngine.WOTS_LOGW;
        int[] concatenate = Arrays.concatenate(base_w, base_w(Arrays.copyOfRange(Pack.intToBigEndian(i12 << (8 - ((i13 * i14) % 8))), 4 - (((i13 * i14) + 7) / 8), 4), this.f59613w, this.engine.WOTS_LEN2));
        SPHINCSPlusEngine sPHINCSPlusEngine2 = this.engine;
        byte[] bArr4 = new byte[sPHINCSPlusEngine2.N];
        byte[][] bArr5 = new byte[sPHINCSPlusEngine2.WOTS_LEN][];
        for (int i15 = 0; i15 < this.engine.WOTS_LEN; i15++) {
            adrs2.setChainAddress(i15);
            int i16 = this.engine.N;
            System.arraycopy(bArr, i15 * i16, bArr4, 0, i16);
            bArr5[i15] = chain(bArr4, concatenate[i15], (this.f59613w - 1) - concatenate[i15], bArr3, adrs);
        }
        adrs3.setType(1);
        adrs3.setKeyPairAddress(adrs.getKeyPairAddress());
        return this.engine.T_l(bArr3, adrs3, Arrays.concatenate(bArr5));
    }

    public byte[] pkGen(byte[] bArr, byte[] bArr2, ADRS adrs) {
        ADRS adrs2 = new ADRS(adrs);
        byte[][] bArr3 = new byte[this.engine.WOTS_LEN][];
        for (int i11 = 0; i11 < this.engine.WOTS_LEN; i11++) {
            ADRS adrs3 = new ADRS(adrs);
            adrs3.setChainAddress(i11);
            adrs3.setHashAddress(0);
            bArr3[i11] = chain(this.engine.PRF(bArr2, bArr, adrs3), 0, this.f59613w - 1, bArr2, adrs3);
        }
        adrs2.setType(1);
        adrs2.setKeyPairAddress(adrs.getKeyPairAddress());
        return this.engine.T_l(bArr2, adrs2, Arrays.concatenate(bArr3));
    }

    public byte[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3, ADRS adrs) {
        SPHINCSPlusEngine sPHINCSPlusEngine;
        ADRS adrs2 = new ADRS(adrs);
        int[] base_w = base_w(bArr, this.f59613w, this.engine.WOTS_LEN1);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            sPHINCSPlusEngine = this.engine;
            if (i11 >= sPHINCSPlusEngine.WOTS_LEN1) {
                break;
            }
            i12 += (this.f59613w - 1) - base_w[i11];
            i11++;
        }
        int i13 = sPHINCSPlusEngine.WOTS_LOGW;
        if (i13 % 8 != 0) {
            i12 <<= 8 - ((sPHINCSPlusEngine.WOTS_LEN2 * i13) % 8);
        }
        byte[] intToBigEndian = Pack.intToBigEndian(i12);
        int[] concatenate = Arrays.concatenate(base_w, base_w(Arrays.copyOfRange(intToBigEndian, ((sPHINCSPlusEngine.WOTS_LEN2 * i13) + 7) / 8, intToBigEndian.length), this.f59613w, this.engine.WOTS_LEN2));
        byte[][] bArr4 = new byte[this.engine.WOTS_LEN][];
        for (int i14 = 0; i14 < this.engine.WOTS_LEN; i14++) {
            adrs2.setChainAddress(i14);
            adrs2.setHashAddress(0);
            bArr4[i14] = chain(this.engine.PRF(bArr3, bArr2, adrs2), 0, concatenate[i14], bArr3, adrs2);
        }
        return Arrays.concatenate(bArr4);
    }
}
