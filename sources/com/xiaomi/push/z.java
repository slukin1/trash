package com.xiaomi.push;

import com.google.common.base.Ascii;

public class z {
    public static int a(byte[] bArr) {
        if (bArr.length == 4) {
            return (bArr[3] & 255) | 0 | ((bArr[0] & 255) << Ascii.CAN) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        }
        throw new IllegalArgumentException("the length of bytes must be 4");
    }

    public static byte[] a(int i11) {
        return new byte[]{(byte) (i11 >> 24), (byte) (i11 >> 16), (byte) (i11 >> 8), (byte) i11};
    }
}
