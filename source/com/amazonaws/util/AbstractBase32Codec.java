package com.amazonaws.util;

import com.google.common.base.Ascii;

abstract class AbstractBase32Codec {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f15539a;

    public AbstractBase32Codec(byte[] bArr) {
        this.f15539a = bArr;
    }

    public final byte[] a(byte[] bArr, int i11) {
        int i12;
        if (i11 % 8 == 0) {
            int i13 = i11 - 1;
            int i14 = 0;
            while (i14 < 6 && i13 > -1 && bArr[i13] == 61) {
                i13--;
                i14++;
            }
            int i15 = 4;
            if (i14 != 0) {
                if (i14 != 1) {
                    if (i14 == 3) {
                        i12 = 3;
                    } else if (i14 == 4) {
                        i15 = 2;
                    } else if (i14 == 6) {
                        i12 = 1;
                    } else {
                        throw new IllegalArgumentException("Invalid number of paddings " + i14);
                    }
                }
                i12 = i15;
            } else {
                i12 = 5;
            }
            int i16 = ((i11 / 8) * 5) - (5 - i12);
            byte[] bArr2 = new byte[i16];
            int i17 = 0;
            int i18 = 0;
            while (i18 < i16 - (i12 % 5)) {
                c(bArr, i17, bArr2, i18);
                i17 += 8;
                i18 += 5;
            }
            if (i12 < 5) {
                b(i12, bArr, i17, bArr2, i18);
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input is expected to be encoded in multiple of 8 bytes but found: " + i11);
    }

    public final void b(int i11, byte[] bArr, int i12, byte[] bArr2, int i13) {
        int i14 = i13 + 1;
        int i15 = i12 + 1;
        int i16 = i15 + 1;
        int j11 = j(bArr[i15]);
        bArr2[i13] = (byte) ((j(bArr[i12]) << 3) | ((j11 >>> 2) & 7));
        if (i11 == 1) {
            CodecUtils.sanityCheckLastPos(j11, 3);
            return;
        }
        int i17 = i14 + 1;
        int i18 = i16 + 1;
        int j12 = ((j11 & 3) << 6) | (j(bArr[i16]) << 1);
        int i19 = i18 + 1;
        int j13 = j(bArr[i18]);
        bArr2[i14] = (byte) (j12 | ((j13 >>> 4) & 1));
        if (i11 == 2) {
            CodecUtils.sanityCheckLastPos(j13, 15);
            return;
        }
        int i21 = i17 + 1;
        int i22 = i19 + 1;
        int j14 = j(bArr[i19]);
        bArr2[i17] = (byte) ((15 & (j14 >>> 1)) | ((j13 & 15) << 4));
        if (i11 == 3) {
            CodecUtils.sanityCheckLastPos(j14, 1);
            return;
        }
        int j15 = j(bArr[i22 + 1]);
        bArr2[i21] = (byte) (((j14 & 1) << 7) | (j(bArr[i22]) << 2) | ((j15 >>> 3) & 3));
        CodecUtils.sanityCheckLastPos(j15, 7);
    }

    public final void c(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        int i14 = i11 + 1;
        int i15 = i14 + 1;
        int j11 = j(bArr[i14]);
        bArr2[i12] = (byte) ((j(bArr[i11]) << 3) | ((j11 >>> 2) & 7));
        int i16 = i13 + 1;
        int i17 = i15 + 1;
        int j12 = ((j11 & 3) << 6) | (j(bArr[i15]) << 1);
        int i18 = i17 + 1;
        int j13 = j(bArr[i17]);
        bArr2[i13] = (byte) (j12 | ((j13 >>> 4) & 1));
        int i19 = i16 + 1;
        int i21 = i18 + 1;
        int j14 = j(bArr[i18]);
        bArr2[i16] = (byte) (((j13 & 15) << 4) | ((j14 >>> 1) & 15));
        int i22 = i21 + 1;
        int j15 = ((j14 & 1) << 7) | (j(bArr[i21]) << 2);
        int i23 = i22 + 1;
        int j16 = j(bArr[i22]);
        bArr2[i19] = (byte) (j15 | ((j16 >>> 3) & 3));
        bArr2[i19 + 1] = (byte) (j(bArr[i23]) | ((j16 & 7) << 5));
    }

    public final byte[] d(byte[] bArr) {
        int length = bArr.length / 5;
        int length2 = bArr.length % 5;
        int i11 = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[(length * 8)];
            int i12 = 0;
            while (i11 < bArr.length) {
                i(bArr, i11, bArr2, i12);
                i11 += 5;
                i12 += 8;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[((length + 1) * 8)];
        int i13 = 0;
        while (i11 < bArr.length - length2) {
            i(bArr, i11, bArr3, i13);
            i11 += 5;
            i13 += 8;
        }
        if (length2 == 1) {
            e(bArr, i11, bArr3, i13);
        } else if (length2 == 2) {
            f(bArr, i11, bArr3, i13);
        } else if (length2 == 3) {
            g(bArr, i11, bArr3, i13);
        } else if (length2 == 4) {
            h(bArr, i11, bArr3, i13);
        }
        return bArr3;
    }

    public final void e(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        byte[] bArr3 = this.f15539a;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        int i14 = i13 + 1;
        bArr2[i13] = bArr3[(b11 & 7) << 2];
        int i15 = 0;
        while (i15 < 6) {
            bArr2[i14] = 61;
            i15++;
            i14++;
        }
    }

    public final void f(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        byte[] bArr3 = this.f15539a;
        int i14 = i11 + 1;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        int i15 = i13 + 1;
        byte b12 = bArr[i14];
        bArr2[i13] = bArr3[((b11 & 7) << 2) | ((b12 >>> 6) & 3)];
        int i16 = i15 + 1;
        bArr2[i15] = bArr3[(b12 >>> 1) & 31];
        int i17 = i16 + 1;
        bArr2[i16] = bArr3[(b12 & 1) << 4];
        int i18 = 0;
        while (i18 < 4) {
            bArr2[i17] = 61;
            i18++;
            i17++;
        }
    }

    public final void g(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        byte[] bArr3 = this.f15539a;
        int i14 = i11 + 1;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        int i15 = i13 + 1;
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        bArr2[i13] = bArr3[((b11 & 7) << 2) | ((b12 >>> 6) & 3)];
        int i17 = i15 + 1;
        bArr2[i15] = bArr3[(b12 >>> 1) & 31];
        int i18 = i17 + 1;
        byte b13 = bArr[i16];
        bArr2[i17] = bArr3[((b12 & 1) << 4) | ((b13 >>> 4) & 15)];
        int i19 = i18 + 1;
        bArr2[i18] = bArr3[(b13 & 15) << 1];
        int i21 = 0;
        while (i21 < 3) {
            bArr2[i19] = 61;
            i21++;
            i19++;
        }
    }

    public final void h(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        byte[] bArr3 = this.f15539a;
        int i14 = i11 + 1;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        int i15 = i13 + 1;
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        bArr2[i13] = bArr3[((b11 & 7) << 2) | ((b12 >>> 6) & 3)];
        int i17 = i15 + 1;
        bArr2[i15] = bArr3[(b12 >>> 1) & 31];
        int i18 = i17 + 1;
        int i19 = i16 + 1;
        byte b13 = bArr[i16];
        bArr2[i17] = bArr3[((b12 & 1) << 4) | ((b13 >>> 4) & 15)];
        int i21 = i18 + 1;
        byte b14 = bArr[i19];
        bArr2[i18] = bArr3[((b13 & 15) << 1) | ((b14 >>> 7) & 1)];
        int i22 = i21 + 1;
        bArr2[i21] = bArr3[(b14 >>> 2) & 31];
        bArr2[i22] = bArr3[(b14 & 3) << 3];
        bArr2[i22 + 1] = 61;
    }

    public final void i(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        byte[] bArr3 = this.f15539a;
        int i14 = i11 + 1;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        int i15 = i13 + 1;
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        bArr2[i13] = bArr3[((b11 & 7) << 2) | ((b12 >>> 6) & 3)];
        int i17 = i15 + 1;
        bArr2[i15] = bArr3[(b12 >>> 1) & 31];
        int i18 = i17 + 1;
        int i19 = i16 + 1;
        byte b13 = bArr[i16];
        bArr2[i17] = bArr3[((b12 & 1) << 4) | ((b13 >>> 4) & 15)];
        int i21 = i18 + 1;
        int i22 = i19 + 1;
        byte b14 = bArr[i19];
        bArr2[i18] = bArr3[((b13 & 15) << 1) | ((b14 >>> 7) & 1)];
        int i23 = i21 + 1;
        bArr2[i21] = bArr3[(b14 >>> 2) & 31];
        byte b15 = bArr[i22];
        bArr2[i23] = bArr3[((b14 & 3) << 3) | ((b15 >>> 5) & 7)];
        bArr2[i23 + 1] = bArr3[b15 & Ascii.US];
    }

    public abstract int j(byte b11);
}
