package com.amazonaws.util;

class Base16Codec {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f15541a = CodecUtils.toBytesDirect("0123456789ABCDEF");

    public static class LazyHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f15542a = b();

        public static byte[] b() {
            byte[] bArr = new byte[103];
            for (int i11 = 0; i11 <= 102; i11++) {
                if (i11 >= 48 && i11 <= 57) {
                    bArr[i11] = (byte) (i11 - 48);
                } else if (i11 >= 65 && i11 <= 70) {
                    bArr[i11] = (byte) (i11 - 55);
                } else if (i11 < 97 || i11 > 102) {
                    bArr[i11] = -1;
                } else {
                    bArr[i11] = (byte) (i11 - 87);
                }
            }
            return bArr;
        }
    }

    public byte[] a(byte[] bArr, int i11) {
        if (i11 % 2 == 0) {
            int i12 = i11 / 2;
            byte[] bArr2 = new byte[i12];
            int i13 = 0;
            int i14 = 0;
            while (i13 < i12) {
                int i15 = i14 + 1;
                bArr2[i13] = (byte) ((c(bArr[i14]) << 4) | c(bArr[i15]));
                i13++;
                i14 = i15 + 1;
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input is expected to be encoded in multiple of 2 bytes but found: " + i11);
    }

    public byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length * 2)];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            byte[] bArr3 = this.f15541a;
            bArr2[i11] = bArr3[(b11 >>> 4) & 15];
            i11 = i12 + 1;
            bArr2[i12] = bArr3[b11 & 15];
        }
        return bArr2;
    }

    public int c(byte b11) {
        byte b12 = LazyHolder.f15542a[b11];
        if (b12 > -1) {
            return b12;
        }
        throw new IllegalArgumentException("Invalid base 16 character: '" + ((char) b11) + "'");
    }
}
