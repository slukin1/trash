package com.amazonaws.util;

class Base32Codec extends AbstractBase32Codec {

    public static class LazyHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f15543a = b();

        public static byte[] b() {
            byte[] bArr = new byte[123];
            for (int i11 = 0; i11 <= 122; i11++) {
                if (i11 >= 65 && i11 <= 90) {
                    bArr[i11] = (byte) (i11 - 65);
                } else if (i11 >= 50 && i11 <= 55) {
                    bArr[i11] = (byte) (i11 - 24);
                } else if (i11 < 97 || i11 > 122) {
                    bArr[i11] = -1;
                } else {
                    bArr[i11] = (byte) (i11 - 97);
                }
            }
            return bArr;
        }
    }

    public Base32Codec() {
        super(k());
    }

    public static byte[] k() {
        return CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
    }

    public int j(byte b11) {
        byte b12 = LazyHolder.f15543a[b11];
        if (b12 > -1) {
            return b12;
        }
        throw new IllegalArgumentException("Invalid base 32 character: '" + ((char) b11) + "'");
    }
}
