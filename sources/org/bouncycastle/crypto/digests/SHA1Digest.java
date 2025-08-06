package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 20;
    private static final int Y1 = 1518500249;
    private static final int Y2 = 1859775393;
    private static final int Y3 = -1894007588;
    private static final int Y4 = -899497514;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int[] X = new int[80];
    private int xOff;

    public SHA1Digest() {
        reset();
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super((GeneralDigest) sHA1Digest);
        copyIn(sHA1Digest);
    }

    public SHA1Digest(byte[] bArr) {
        super(bArr);
        this.H1 = Pack.bigEndianToInt(bArr, 16);
        this.H2 = Pack.bigEndianToInt(bArr, 20);
        this.H3 = Pack.bigEndianToInt(bArr, 24);
        this.H4 = Pack.bigEndianToInt(bArr, 28);
        this.H5 = Pack.bigEndianToInt(bArr, 32);
        this.xOff = Pack.bigEndianToInt(bArr, 36);
        for (int i11 = 0; i11 != this.xOff; i11++) {
            this.X[i11] = Pack.bigEndianToInt(bArr, (i11 * 4) + 40);
        }
    }

    private void copyIn(SHA1Digest sHA1Digest) {
        this.H1 = sHA1Digest.H1;
        this.H2 = sHA1Digest.H2;
        this.H3 = sHA1Digest.H3;
        this.H4 = sHA1Digest.H4;
        this.H5 = sHA1Digest.H5;
        int[] iArr = sHA1Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA1Digest.xOff;
    }

    private int f(int i11, int i12, int i13) {
        return ((~i11) & i13) | (i12 & i11);
    }

    private int g(int i11, int i12, int i13) {
        return (i11 & i13) | (i11 & i12) | (i12 & i13);
    }

    private int h(int i11, int i12, int i13) {
        return (i11 ^ i12) ^ i13;
    }

    public Memoable copy() {
        return new SHA1Digest(this);
    }

    public int doFinal(byte[] bArr, int i11) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i11);
        Pack.intToBigEndian(this.H2, bArr, i11 + 4);
        Pack.intToBigEndian(this.H3, bArr, i11 + 8);
        Pack.intToBigEndian(this.H4, bArr, i11 + 12);
        Pack.intToBigEndian(this.H5, bArr, i11 + 16);
        reset();
        return 20;
    }

    public String getAlgorithmName() {
        return McElieceCCA2KeyGenParameterSpec.SHA1;
    }

    public int getDigestSize() {
        return 20;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.xOff * 4) + 40)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.H1, bArr, 16);
        Pack.intToBigEndian(this.H2, bArr, 20);
        Pack.intToBigEndian(this.H3, bArr, 24);
        Pack.intToBigEndian(this.H4, bArr, 28);
        Pack.intToBigEndian(this.H5, bArr, 32);
        Pack.intToBigEndian(this.xOff, bArr, 36);
        for (int i11 = 0; i11 != this.xOff; i11++) {
            Pack.intToBigEndian(this.X[i11], bArr, (i11 * 4) + 40);
        }
        return bArr;
    }

    public void processBlock() {
        for (int i11 = 16; i11 < 80; i11++) {
            int[] iArr = this.X;
            int i12 = ((iArr[i11 - 3] ^ iArr[i11 - 8]) ^ iArr[i11 - 14]) ^ iArr[i11 - 16];
            iArr[i11] = (i12 >>> 31) | (i12 << 1);
        }
        int i13 = this.H1;
        int i14 = this.H2;
        int i15 = this.H3;
        int i16 = this.H4;
        int i17 = this.H5;
        int i18 = 0;
        int i19 = 0;
        while (i18 < 4) {
            int i21 = i19 + 1;
            int f11 = i17 + ((i13 << 5) | (i13 >>> 27)) + f(i14, i15, i16) + this.X[i19] + Y1;
            int i22 = (i14 >>> 2) | (i14 << 30);
            int i23 = i21 + 1;
            int f12 = i16 + ((f11 << 5) | (f11 >>> 27)) + f(i13, i22, i15) + this.X[i21] + Y1;
            int i24 = (i13 >>> 2) | (i13 << 30);
            int i25 = i23 + 1;
            int f13 = i15 + ((f12 << 5) | (f12 >>> 27)) + f(f11, i24, i22) + this.X[i23] + Y1;
            i17 = (f11 >>> 2) | (f11 << 30);
            int i26 = i25 + 1;
            i14 = i22 + ((f13 << 5) | (f13 >>> 27)) + f(f12, i17, i24) + this.X[i25] + Y1;
            i16 = (f12 >>> 2) | (f12 << 30);
            i13 = i24 + ((i14 << 5) | (i14 >>> 27)) + f(f13, i16, i17) + this.X[i26] + Y1;
            i15 = (f13 >>> 2) | (f13 << 30);
            i18++;
            i19 = i26 + 1;
        }
        int i27 = 0;
        while (i27 < 4) {
            int i28 = i19 + 1;
            int h11 = i17 + ((i13 << 5) | (i13 >>> 27)) + h(i14, i15, i16) + this.X[i19] + Y2;
            int i29 = (i14 >>> 2) | (i14 << 30);
            int i30 = i28 + 1;
            int h12 = i16 + ((h11 << 5) | (h11 >>> 27)) + h(i13, i29, i15) + this.X[i28] + Y2;
            int i31 = (i13 >>> 2) | (i13 << 30);
            int i32 = i30 + 1;
            int h13 = i15 + ((h12 << 5) | (h12 >>> 27)) + h(h11, i31, i29) + this.X[i30] + Y2;
            i17 = (h11 >>> 2) | (h11 << 30);
            int i33 = i32 + 1;
            i14 = i29 + ((h13 << 5) | (h13 >>> 27)) + h(h12, i17, i31) + this.X[i32] + Y2;
            i16 = (h12 >>> 2) | (h12 << 30);
            i13 = i31 + ((i14 << 5) | (i14 >>> 27)) + h(h13, i16, i17) + this.X[i33] + Y2;
            i15 = (h13 >>> 2) | (h13 << 30);
            i27++;
            i19 = i33 + 1;
        }
        int i34 = 0;
        while (i34 < 4) {
            int i35 = i19 + 1;
            int g11 = i17 + ((i13 << 5) | (i13 >>> 27)) + g(i14, i15, i16) + this.X[i19] + Y3;
            int i36 = (i14 >>> 2) | (i14 << 30);
            int i37 = i35 + 1;
            int g12 = i16 + ((g11 << 5) | (g11 >>> 27)) + g(i13, i36, i15) + this.X[i35] + Y3;
            int i38 = (i13 >>> 2) | (i13 << 30);
            int i39 = i37 + 1;
            int g13 = i15 + ((g12 << 5) | (g12 >>> 27)) + g(g11, i38, i36) + this.X[i37] + Y3;
            i17 = (g11 >>> 2) | (g11 << 30);
            int i40 = i39 + 1;
            i14 = i36 + ((g13 << 5) | (g13 >>> 27)) + g(g12, i17, i38) + this.X[i39] + Y3;
            i16 = (g12 >>> 2) | (g12 << 30);
            i13 = i38 + ((i14 << 5) | (i14 >>> 27)) + g(g13, i16, i17) + this.X[i40] + Y3;
            i15 = (g13 >>> 2) | (g13 << 30);
            i34++;
            i19 = i40 + 1;
        }
        int i41 = 0;
        while (i41 <= 3) {
            int i42 = i19 + 1;
            int h14 = i17 + ((i13 << 5) | (i13 >>> 27)) + h(i14, i15, i16) + this.X[i19] + Y4;
            int i43 = (i14 >>> 2) | (i14 << 30);
            int i44 = i42 + 1;
            int h15 = i16 + ((h14 << 5) | (h14 >>> 27)) + h(i13, i43, i15) + this.X[i42] + Y4;
            int i45 = (i13 >>> 2) | (i13 << 30);
            int i46 = i44 + 1;
            int h16 = i15 + ((h15 << 5) | (h15 >>> 27)) + h(h14, i45, i43) + this.X[i44] + Y4;
            i17 = (h14 >>> 2) | (h14 << 30);
            int i47 = i46 + 1;
            i14 = i43 + ((h16 << 5) | (h16 >>> 27)) + h(h15, i17, i45) + this.X[i46] + Y4;
            i16 = (h15 >>> 2) | (h15 << 30);
            i13 = i45 + ((i14 << 5) | (i14 >>> 27)) + h(h16, i16, i17) + this.X[i47] + Y4;
            i15 = (h16 >>> 2) | (h16 << 30);
            i41++;
            i19 = i47 + 1;
        }
        this.H1 += i13;
        this.H2 += i14;
        this.H3 += i15;
        this.H4 += i16;
        this.H5 += i17;
        this.xOff = 0;
        for (int i48 = 0; i48 < 16; i48++) {
            this.X[i48] = 0;
        }
    }

    public void processLength(long j11) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j11 >>> 32);
        iArr[15] = (int) j11;
    }

    public void processWord(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        int i14 = (bArr[i13 + 1] & 255) | (bArr[i11] << Ascii.CAN) | ((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8);
        int[] iArr = this.X;
        int i15 = this.xOff;
        iArr[i15] = i14;
        int i16 = i15 + 1;
        this.xOff = i16;
        if (i16 == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.H5 = -1009589776;
        this.xOff = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.X;
            if (i11 != iArr.length) {
                iArr[i11] = 0;
                i11++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.copyIn(sHA1Digest);
        copyIn(sHA1Digest);
    }
}
