package org.bouncycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;

public class RainbowUtil {
    public static byte[] convertArray(short[] sArr) {
        byte[] bArr = new byte[sArr.length];
        for (int i11 = 0; i11 < sArr.length; i11++) {
            bArr[i11] = (byte) sArr[i11];
        }
        return bArr;
    }

    public static short[] convertArray(byte[] bArr) {
        short[] sArr = new short[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            sArr[i11] = (short) (bArr[i11] & 255);
        }
        return sArr;
    }

    public static byte[][] convertArray(short[][] sArr) {
        int length = sArr.length;
        int[] iArr = new int[2];
        iArr[1] = sArr[0].length;
        iArr[0] = length;
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, iArr);
        for (int i11 = 0; i11 < sArr.length; i11++) {
            for (int i12 = 0; i12 < sArr[0].length; i12++) {
                bArr[i11][i12] = (byte) sArr[i11][i12];
            }
        }
        return bArr;
    }

    public static short[][] convertArray(byte[][] bArr) {
        int length = bArr.length;
        int[] iArr = new int[2];
        iArr[1] = bArr[0].length;
        iArr[0] = length;
        short[][] sArr = (short[][]) Array.newInstance(short.class, iArr);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            for (int i12 = 0; i12 < bArr[0].length; i12++) {
                sArr[i11][i12] = (short) (bArr[i11][i12] & 255);
            }
        }
        return sArr;
    }

    public static byte[][][] convertArray(short[][][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        int[] iArr = new int[3];
        iArr[2] = sArr[0][0].length;
        iArr[1] = length2;
        iArr[0] = length;
        byte[][][] bArr = (byte[][][]) Array.newInstance(byte.class, iArr);
        for (int i11 = 0; i11 < sArr.length; i11++) {
            for (int i12 = 0; i12 < sArr[0].length; i12++) {
                for (int i13 = 0; i13 < sArr[0][0].length; i13++) {
                    bArr[i11][i12][i13] = (byte) sArr[i11][i12][i13];
                }
            }
        }
        return bArr;
    }

    public static short[][][] convertArray(byte[][][] bArr) {
        int length = bArr.length;
        int length2 = bArr[0].length;
        int[] iArr = new int[3];
        iArr[2] = bArr[0][0].length;
        iArr[1] = length2;
        iArr[0] = length;
        short[][][] sArr = (short[][][]) Array.newInstance(short.class, iArr);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            for (int i12 = 0; i12 < bArr[0].length; i12++) {
                for (int i13 = 0; i13 < bArr[0][0].length; i13++) {
                    sArr[i11][i12][i13] = (short) (bArr[i11][i12][i13] & 255);
                }
            }
        }
        return sArr;
    }

    public static int[] convertArraytoInt(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        return iArr;
    }

    public static byte[] convertIntArray(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            bArr[i11] = (byte) iArr[i11];
        }
        return bArr;
    }

    public static boolean equals(short[] sArr, short[] sArr2) {
        if (sArr.length != sArr2.length) {
            return false;
        }
        boolean z11 = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z11 &= sArr[length] == sArr2[length];
        }
        return z11;
    }

    public static boolean equals(short[][] sArr, short[][] sArr2) {
        if (sArr.length != sArr2.length) {
            return false;
        }
        boolean z11 = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z11 &= equals(sArr[length], sArr2[length]);
        }
        return z11;
    }

    public static boolean equals(short[][][] sArr, short[][][] sArr2) {
        if (sArr.length != sArr2.length) {
            return false;
        }
        boolean z11 = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z11 &= equals(sArr[length], sArr2[length]);
        }
        return z11;
    }
}
