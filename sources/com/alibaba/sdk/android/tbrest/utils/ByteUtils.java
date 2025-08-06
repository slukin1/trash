package com.alibaba.sdk.android.tbrest.utils;

public class ByteUtils {
    public static int a(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            i11 |= (bArr[i12] & 255) << (((bArr.length - i12) - 1) * 8);
        }
        return i11;
    }

    public static int b(byte[] bArr, int i11, int i12) {
        if (bArr == null || i11 < 0 || i12 < 0 || bArr.length < i11 + i12) {
            return 0;
        }
        byte[] bArr2 = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            bArr2[i13] = bArr[i11];
            i11++;
        }
        return a(bArr2);
    }

    public static byte[] c(int i11) {
        return new byte[]{(byte) ((i11 >> 8) & 255), (byte) (i11 & 255)};
    }

    public static byte[] d(int i11) {
        return new byte[]{(byte) ((i11 >> 16) & 255), (byte) ((i11 >> 8) & 255), (byte) (i11 & 255)};
    }

    public static byte[] e(int i11) {
        return new byte[]{(byte) ((i11 >> 24) & 255), (byte) ((i11 >> 16) & 255), (byte) ((i11 >> 8) & 255), (byte) (i11 & 255)};
    }
}
