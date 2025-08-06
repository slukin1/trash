package org.bouncycastle.pqc.math.linearalgebra;

public final class CharUtils {
    private CharUtils() {
    }

    public static char[] clone(char[] cArr) {
        char[] cArr2 = new char[cArr.length];
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        return cArr2;
    }

    public static boolean equals(char[] cArr, char[] cArr2) {
        if (cArr.length != cArr2.length) {
            return false;
        }
        boolean z11 = true;
        for (int length = cArr.length - 1; length >= 0; length--) {
            z11 &= cArr[length] == cArr2[length];
        }
        return z11;
    }

    public static byte[] toByteArray(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        for (int length = cArr.length - 1; length >= 0; length--) {
            bArr[length] = (byte) cArr[length];
        }
        return bArr;
    }

    public static byte[] toByteArrayForPBE(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < cArr.length; i11++) {
            bArr[i11] = (byte) cArr[i11];
        }
        int i12 = length * 2;
        byte[] bArr2 = new byte[(i12 + 2)];
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = i13 * 2;
            bArr2[i14] = 0;
            bArr2[i14 + 1] = bArr[i13];
        }
        bArr2[i12] = 0;
        bArr2[i12 + 1] = 0;
        return bArr2;
    }
}
