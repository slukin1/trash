package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class SHA224Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 28;
    public static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int H8;
    private int[] X = new int[64];
    private int xOff;

    public SHA224Digest() {
        reset();
    }

    public SHA224Digest(SHA224Digest sHA224Digest) {
        super((GeneralDigest) sHA224Digest);
        doCopy(sHA224Digest);
    }

    public SHA224Digest(byte[] bArr) {
        super(bArr);
        this.H1 = Pack.bigEndianToInt(bArr, 16);
        this.H2 = Pack.bigEndianToInt(bArr, 20);
        this.H3 = Pack.bigEndianToInt(bArr, 24);
        this.H4 = Pack.bigEndianToInt(bArr, 28);
        this.H5 = Pack.bigEndianToInt(bArr, 32);
        this.H6 = Pack.bigEndianToInt(bArr, 36);
        this.H7 = Pack.bigEndianToInt(bArr, 40);
        this.H8 = Pack.bigEndianToInt(bArr, 44);
        this.xOff = Pack.bigEndianToInt(bArr, 48);
        for (int i11 = 0; i11 != this.xOff; i11++) {
            this.X[i11] = Pack.bigEndianToInt(bArr, (i11 * 4) + 52);
        }
    }

    private int Ch(int i11, int i12, int i13) {
        return ((~i11) & i13) ^ (i12 & i11);
    }

    private int Maj(int i11, int i12, int i13) {
        return ((i11 & i13) ^ (i11 & i12)) ^ (i12 & i13);
    }

    private int Sum0(int i11) {
        return ((i11 << 10) | (i11 >>> 22)) ^ (((i11 >>> 2) | (i11 << 30)) ^ ((i11 >>> 13) | (i11 << 19)));
    }

    private int Sum1(int i11) {
        return ((i11 << 7) | (i11 >>> 25)) ^ (((i11 >>> 6) | (i11 << 26)) ^ ((i11 >>> 11) | (i11 << 21)));
    }

    private int Theta0(int i11) {
        return (i11 >>> 3) ^ (((i11 >>> 7) | (i11 << 25)) ^ ((i11 >>> 18) | (i11 << 14)));
    }

    private int Theta1(int i11) {
        return (i11 >>> 10) ^ (((i11 >>> 17) | (i11 << 15)) ^ ((i11 >>> 19) | (i11 << 13)));
    }

    private void doCopy(SHA224Digest sHA224Digest) {
        super.copyIn(sHA224Digest);
        this.H1 = sHA224Digest.H1;
        this.H2 = sHA224Digest.H2;
        this.H3 = sHA224Digest.H3;
        this.H4 = sHA224Digest.H4;
        this.H5 = sHA224Digest.H5;
        this.H6 = sHA224Digest.H6;
        this.H7 = sHA224Digest.H7;
        this.H8 = sHA224Digest.H8;
        int[] iArr = sHA224Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA224Digest.xOff;
    }

    public Memoable copy() {
        return new SHA224Digest(this);
    }

    public int doFinal(byte[] bArr, int i11) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i11);
        Pack.intToBigEndian(this.H2, bArr, i11 + 4);
        Pack.intToBigEndian(this.H3, bArr, i11 + 8);
        Pack.intToBigEndian(this.H4, bArr, i11 + 12);
        Pack.intToBigEndian(this.H5, bArr, i11 + 16);
        Pack.intToBigEndian(this.H6, bArr, i11 + 20);
        Pack.intToBigEndian(this.H7, bArr, i11 + 24);
        reset();
        return 28;
    }

    public String getAlgorithmName() {
        return McElieceCCA2KeyGenParameterSpec.SHA224;
    }

    public int getDigestSize() {
        return 28;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[((this.xOff * 4) + 52)];
        super.populateState(bArr);
        Pack.intToBigEndian(this.H1, bArr, 16);
        Pack.intToBigEndian(this.H2, bArr, 20);
        Pack.intToBigEndian(this.H3, bArr, 24);
        Pack.intToBigEndian(this.H4, bArr, 28);
        Pack.intToBigEndian(this.H5, bArr, 32);
        Pack.intToBigEndian(this.H6, bArr, 36);
        Pack.intToBigEndian(this.H7, bArr, 40);
        Pack.intToBigEndian(this.H8, bArr, 44);
        Pack.intToBigEndian(this.xOff, bArr, 48);
        for (int i11 = 0; i11 != this.xOff; i11++) {
            Pack.intToBigEndian(this.X[i11], bArr, (i11 * 4) + 52);
        }
        return bArr;
    }

    public void processBlock() {
        for (int i11 = 16; i11 <= 63; i11++) {
            int[] iArr = this.X;
            int Theta1 = Theta1(iArr[i11 - 2]);
            int[] iArr2 = this.X;
            iArr[i11] = Theta1 + iArr2[i11 - 7] + Theta0(iArr2[i11 - 15]) + this.X[i11 - 16];
        }
        int i12 = this.H1;
        int i13 = this.H2;
        int i14 = this.H3;
        int i15 = this.H4;
        int i16 = this.H5;
        int i17 = this.H6;
        int i18 = this.H7;
        int i19 = this.H8;
        int i21 = 0;
        for (int i22 = 0; i22 < 8; i22++) {
            int Sum1 = Sum1(i16) + Ch(i16, i17, i18);
            int[] iArr3 = K;
            int i23 = i19 + Sum1 + iArr3[i21] + this.X[i21];
            int i24 = i15 + i23;
            int Sum0 = i23 + Sum0(i12) + Maj(i12, i13, i14);
            int i25 = i21 + 1;
            int Sum12 = i18 + Sum1(i24) + Ch(i24, i16, i17) + iArr3[i25] + this.X[i25];
            int i26 = i14 + Sum12;
            int Sum02 = Sum12 + Sum0(Sum0) + Maj(Sum0, i12, i13);
            int i27 = i25 + 1;
            int Sum13 = i17 + Sum1(i26) + Ch(i26, i24, i16) + iArr3[i27] + this.X[i27];
            int i28 = i13 + Sum13;
            int Sum03 = Sum13 + Sum0(Sum02) + Maj(Sum02, Sum0, i12);
            int i29 = i27 + 1;
            int Sum14 = i16 + Sum1(i28) + Ch(i28, i26, i24) + iArr3[i29] + this.X[i29];
            int i30 = i12 + Sum14;
            int Sum04 = Sum14 + Sum0(Sum03) + Maj(Sum03, Sum02, Sum0);
            int i31 = i29 + 1;
            int Sum15 = i24 + Sum1(i30) + Ch(i30, i28, i26) + iArr3[i31] + this.X[i31];
            i19 = Sum0 + Sum15;
            i15 = Sum15 + Sum0(Sum04) + Maj(Sum04, Sum03, Sum02);
            int i32 = i31 + 1;
            int Sum16 = i26 + Sum1(i19) + Ch(i19, i30, i28) + iArr3[i32] + this.X[i32];
            i18 = Sum02 + Sum16;
            i14 = Sum16 + Sum0(i15) + Maj(i15, Sum04, Sum03);
            int i33 = i32 + 1;
            int Sum17 = i28 + Sum1(i18) + Ch(i18, i19, i30) + iArr3[i33] + this.X[i33];
            i17 = Sum03 + Sum17;
            i13 = Sum17 + Sum0(i14) + Maj(i14, i15, Sum04);
            int i34 = i33 + 1;
            int Sum18 = i30 + Sum1(i17) + Ch(i17, i18, i19) + iArr3[i34] + this.X[i34];
            i16 = Sum04 + Sum18;
            i12 = Sum18 + Sum0(i13) + Maj(i13, i14, i15);
            i21 = i34 + 1;
        }
        this.H1 += i12;
        this.H2 += i13;
        this.H3 += i14;
        this.H4 += i15;
        this.H5 += i16;
        this.H6 += i17;
        this.H7 += i18;
        this.H8 += i19;
        this.xOff = 0;
        for (int i35 = 0; i35 < 16; i35++) {
            this.X[i35] = 0;
        }
    }

    public void processLength(long j11) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j11 >>> 32);
        iArr[15] = (int) (j11 & -1);
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
        this.H1 = -1056596264;
        this.H2 = 914150663;
        this.H3 = 812702999;
        this.H4 = -150054599;
        this.H5 = -4191439;
        this.H6 = 1750603025;
        this.H7 = 1694076839;
        this.H8 = -1090891868;
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
        doCopy((SHA224Digest) memoable);
    }
}
