package com.amazonaws.util;

import okio.Utf8;

class Base64Codec {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f15544a = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    public static class LazyHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f15545a = b();

        public static byte[] b() {
            byte[] bArr = new byte[123];
            for (int i11 = 0; i11 <= 122; i11++) {
                if (i11 >= 65 && i11 <= 90) {
                    bArr[i11] = (byte) (i11 - 65);
                } else if (i11 >= 48 && i11 <= 57) {
                    bArr[i11] = (byte) (i11 + 4);
                } else if (i11 == 43) {
                    bArr[i11] = (byte) (i11 + 19);
                } else if (i11 == 47) {
                    bArr[i11] = (byte) (i11 + 16);
                } else if (i11 < 97 || i11 > 122) {
                    bArr[i11] = -1;
                } else {
                    bArr[i11] = (byte) (i11 - 71);
                }
            }
            return bArr;
        }
    }

    public byte[] a(byte[] bArr, int i11) {
        int i12;
        if (i11 % 4 == 0) {
            int i13 = i11 - 1;
            int i14 = 0;
            while (true) {
                i12 = 2;
                if (i14 < 2 && i13 > -1 && bArr[i13] == 61) {
                    i13--;
                    i14++;
                }
            }
            if (i14 == 0) {
                i12 = 3;
            } else if (i14 != 1) {
                if (i14 == 2) {
                    i12 = 1;
                } else {
                    throw new Error("Impossible");
                }
            }
            int i15 = ((i11 / 4) * 3) - (3 - i12);
            byte[] bArr2 = new byte[i15];
            int i16 = 0;
            int i17 = 0;
            while (i17 < i15 - (i12 % 3)) {
                c(bArr, i16, bArr2, i17);
                i16 += 4;
                i17 += 3;
            }
            if (i12 < 3) {
                b(i12, bArr, i16, bArr2, i17);
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input is expected to be encoded in multiple of 4 bytes but found: " + i11);
    }

    public void b(int i11, byte[] bArr, int i12, byte[] bArr2, int i13) {
        int i14 = i13 + 1;
        int i15 = i12 + 1;
        int i16 = i15 + 1;
        int h11 = h(bArr[i15]);
        bArr2[i13] = (byte) ((h(bArr[i12]) << 2) | ((h11 >>> 4) & 3));
        if (i11 == 1) {
            CodecUtils.sanityCheckLastPos(h11, 15);
            return;
        }
        int i17 = i14 + 1;
        int i18 = i16 + 1;
        int h12 = h(bArr[i16]);
        bArr2[i14] = (byte) ((15 & (h12 >>> 2)) | ((h11 & 15) << 4));
        if (i11 == 2) {
            CodecUtils.sanityCheckLastPos(h12, 3);
        } else {
            bArr2[i17] = (byte) (((h12 & 3) << 6) | h(bArr[i18]));
        }
    }

    public void c(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        int i14 = i11 + 1;
        int i15 = i14 + 1;
        int h11 = h(bArr[i14]);
        bArr2[i12] = (byte) ((h(bArr[i11]) << 2) | ((h11 >>> 4) & 3));
        int i16 = i15 + 1;
        int h12 = h(bArr[i15]);
        bArr2[i13] = (byte) (((h11 & 15) << 4) | ((h12 >>> 2) & 15));
        bArr2[i13 + 1] = (byte) (h(bArr[i16]) | ((h12 & 3) << 6));
    }

    public byte[] d(byte[] bArr) {
        int length = bArr.length / 3;
        int length2 = bArr.length % 3;
        int i11 = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[(length * 4)];
            int i12 = 0;
            while (i11 < bArr.length) {
                g(bArr, i11, bArr2, i12);
                i11 += 3;
                i12 += 4;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[((length + 1) * 4)];
        int i13 = 0;
        while (i11 < bArr.length - length2) {
            g(bArr, i11, bArr3, i13);
            i11 += 3;
            i13 += 4;
        }
        if (length2 == 1) {
            e(bArr, i11, bArr3, i13);
        } else if (length2 == 2) {
            f(bArr, i11, bArr3, i13);
        }
        return bArr3;
    }

    public void e(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        byte[] bArr3 = this.f15544a;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 2) & 63];
        int i14 = i13 + 1;
        bArr2[i13] = bArr3[(b11 & 3) << 4];
        bArr2[i14] = 61;
        bArr2[i14 + 1] = 61;
    }

    public void f(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        byte[] bArr3 = this.f15544a;
        int i14 = i11 + 1;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 2) & 63];
        int i15 = i13 + 1;
        byte b12 = bArr[i14];
        bArr2[i13] = bArr3[((b11 & 3) << 4) | ((b12 >>> 4) & 15)];
        bArr2[i15] = bArr3[(b12 & 15) << 2];
        bArr2[i15 + 1] = 61;
    }

    public void g(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i12 + 1;
        byte[] bArr3 = this.f15544a;
        int i14 = i11 + 1;
        byte b11 = bArr[i11];
        bArr2[i12] = bArr3[(b11 >>> 2) & 63];
        int i15 = i13 + 1;
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        bArr2[i13] = bArr3[((b11 & 3) << 4) | ((b12 >>> 4) & 15)];
        byte b13 = bArr[i16];
        bArr2[i15] = bArr3[((b12 & 15) << 2) | ((b13 >>> 6) & 3)];
        bArr2[i15 + 1] = bArr3[b13 & Utf8.REPLACEMENT_BYTE];
    }

    public int h(byte b11) {
        byte b12 = LazyHolder.f15545a[b11];
        if (b12 > -1) {
            return b12;
        }
        throw new IllegalArgumentException("Invalid base 64 character: '" + ((char) b11) + "'");
    }
}
