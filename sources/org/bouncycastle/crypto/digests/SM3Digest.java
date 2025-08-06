package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SM3Digest extends GeneralDigest {
    private static final int BLOCK_SIZE = 16;
    private static final int DIGEST_LENGTH = 32;
    private static final int[] T = new int[64];
    private int[] V = new int[8];
    private int[] W = new int[68];
    private int[] inwords = new int[16];
    private int xOff;

    static {
        int i11;
        int i12 = 0;
        while (true) {
            if (i12 >= 16) {
                break;
            }
            T[i12] = (2043430169 >>> (32 - i12)) | (2043430169 << i12);
            i12++;
        }
        for (i11 = 16; i11 < 64; i11++) {
            int i13 = i11 % 32;
            T[i11] = (2055708042 >>> (32 - i13)) | (2055708042 << i13);
        }
    }

    public SM3Digest() {
        reset();
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super((GeneralDigest) sM3Digest);
        copyIn(sM3Digest);
    }

    private int FF0(int i11, int i12, int i13) {
        return (i11 ^ i12) ^ i13;
    }

    private int FF1(int i11, int i12, int i13) {
        return (i11 & i13) | (i11 & i12) | (i12 & i13);
    }

    private int GG0(int i11, int i12, int i13) {
        return (i11 ^ i12) ^ i13;
    }

    private int GG1(int i11, int i12, int i13) {
        return ((~i11) & i13) | (i12 & i11);
    }

    private int P0(int i11) {
        return (i11 ^ ((i11 << 9) | (i11 >>> 23))) ^ ((i11 << 17) | (i11 >>> 15));
    }

    private int P1(int i11) {
        return (i11 ^ ((i11 << 15) | (i11 >>> 17))) ^ ((i11 << 23) | (i11 >>> 9));
    }

    private void copyIn(SM3Digest sM3Digest) {
        int[] iArr = sM3Digest.V;
        int[] iArr2 = this.V;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = sM3Digest.inwords;
        int[] iArr4 = this.inwords;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.xOff = sM3Digest.xOff;
    }

    public Memoable copy() {
        return new SM3Digest(this);
    }

    public int doFinal(byte[] bArr, int i11) {
        finish();
        Pack.intToBigEndian(this.V, bArr, i11);
        reset();
        return 32;
    }

    public String getAlgorithmName() {
        return "SM3";
    }

    public int getDigestSize() {
        return 32;
    }

    public void processBlock() {
        int i11;
        int i12 = 0;
        while (true) {
            if (i12 >= 16) {
                break;
            }
            this.W[i12] = this.inwords[i12];
            i12++;
        }
        for (int i13 = 16; i13 < 68; i13++) {
            int[] iArr = this.W;
            int i14 = iArr[i13 - 3];
            int i15 = iArr[i13 - 13];
            iArr[i13] = (P1(((i14 >>> 17) | (i14 << 15)) ^ (iArr[i13 - 16] ^ iArr[i13 - 9])) ^ ((i15 >>> 25) | (i15 << 7))) ^ this.W[i13 - 6];
        }
        int[] iArr2 = this.V;
        int i16 = iArr2[0];
        int i17 = iArr2[1];
        int i18 = iArr2[2];
        int i19 = iArr2[3];
        int i21 = iArr2[4];
        int i22 = iArr2[5];
        int i23 = iArr2[6];
        int i24 = iArr2[7];
        int i25 = 0;
        int i26 = i23;
        for (i11 = 16; i25 < i11; i11 = 16) {
            int i27 = (i16 << 12) | (i16 >>> 20);
            int i28 = i27 + i21 + T[i25];
            int i29 = (i28 << 7) | (i28 >>> 25);
            int[] iArr3 = this.W;
            int i30 = iArr3[i25];
            int i31 = (i17 << 9) | (i17 >>> 23);
            int i32 = (i22 << 19) | (i22 >>> 13);
            i25++;
            i22 = i21;
            i21 = P0(GG0(i21, i22, i26) + i24 + i29 + i30);
            i19 = i18;
            i18 = i31;
            i24 = i26;
            i26 = i32;
            i17 = i16;
            i16 = FF0(i16, i17, i18) + i19 + (i29 ^ i27) + (i30 ^ iArr3[i25 + 4]);
        }
        int i33 = i24;
        int i34 = i21;
        int i35 = i26;
        int i36 = i19;
        int i37 = i18;
        int i38 = i17;
        int i39 = i16;
        int i40 = 16;
        while (i40 < 64) {
            int i41 = (i39 << 12) | (i39 >>> 20);
            int i42 = i41 + i34 + T[i40];
            int i43 = (i42 << 7) | (i42 >>> 25);
            int[] iArr4 = this.W;
            int i44 = iArr4[i40];
            int i45 = (i22 << 19) | (i22 >>> 13);
            i40++;
            i22 = i34;
            i34 = P0(GG1(i34, i22, i35) + i33 + i43 + i44);
            i36 = i37;
            i37 = (i38 >>> 23) | (i38 << 9);
            i38 = i39;
            i39 = FF1(i39, i38, i37) + i36 + (i43 ^ i41) + (i44 ^ iArr4[i40 + 4]);
            int i46 = i45;
            i33 = i35;
            i35 = i46;
        }
        int[] iArr5 = this.V;
        iArr5[0] = i39 ^ iArr5[0];
        iArr5[1] = iArr5[1] ^ i38;
        iArr5[2] = iArr5[2] ^ i37;
        iArr5[3] = iArr5[3] ^ i36;
        iArr5[4] = iArr5[4] ^ i34;
        iArr5[5] = iArr5[5] ^ i22;
        iArr5[6] = i35 ^ iArr5[6];
        iArr5[7] = iArr5[7] ^ i33;
        this.xOff = 0;
    }

    public void processLength(long j11) {
        int i11 = this.xOff;
        if (i11 > 14) {
            this.inwords[i11] = 0;
            this.xOff = i11 + 1;
            processBlock();
        }
        while (true) {
            int i12 = this.xOff;
            if (i12 < 14) {
                this.inwords[i12] = 0;
                this.xOff = i12 + 1;
            } else {
                int[] iArr = this.inwords;
                int i13 = i12 + 1;
                this.xOff = i13;
                iArr[i12] = (int) (j11 >>> 32);
                this.xOff = i13 + 1;
                iArr[i13] = (int) j11;
                return;
            }
        }
    }

    public void processWord(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = (bArr[i13 + 1] & 255) | ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8);
        int[] iArr = this.inwords;
        int i15 = this.xOff;
        iArr[i15] = i14;
        int i16 = i15 + 1;
        this.xOff = i16;
        if (i16 >= 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        int[] iArr = this.V;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.xOff = 0;
    }

    public void reset(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        super.copyIn(sM3Digest);
        copyIn(sM3Digest);
    }
}
