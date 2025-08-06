package org.bouncycastle.pqc.crypto.gmss.util;

import com.google.common.base.Ascii;

public class GMSSUtil {
    public int bytesToIntLittleEndian(byte[] bArr) {
        return ((bArr[3] & 255) << Ascii.CAN) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public int bytesToIntLittleEndian(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b11 = (bArr[i11] & 255) | ((bArr[i12] & 255) << 8);
        return ((bArr[i13 + 1] & 255) << Ascii.CAN) | b11 | ((bArr[i13] & 255) << 16);
    }

    public byte[] concatenateArray(byte[][] bArr) {
        byte[] bArr2 = new byte[(bArr.length * bArr[0].length)];
        int i11 = 0;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            System.arraycopy(bArr[i12], 0, bArr2, i11, bArr[i12].length);
            i11 += bArr[i12].length;
        }
        return bArr2;
    }

    public int getLog(int i11) {
        int i12 = 1;
        int i13 = 2;
        while (i13 < i11) {
            i13 <<= 1;
            i12++;
        }
        return i12;
    }

    public byte[] intToBytesLittleEndian(int i11) {
        return new byte[]{(byte) (i11 & 255), (byte) ((i11 >> 8) & 255), (byte) ((i11 >> 16) & 255), (byte) ((i11 >> 24) & 255)};
    }

    public void printArray(String str, byte[] bArr) {
        System.out.println(str);
        int i11 = 0;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            System.out.println(i11 + "; " + bArr[i12]);
            i11++;
        }
    }

    public void printArray(String str, byte[][] bArr) {
        System.out.println(str);
        int i11 = 0;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            for (int i13 = 0; i13 < bArr[0].length; i13++) {
                System.out.println(i11 + "; " + bArr[i12][i13]);
                i11++;
            }
        }
    }

    public boolean testPowerOfTwo(int i11) {
        int i12 = 1;
        while (i12 < i11) {
            i12 <<= 1;
        }
        return i11 == i12;
    }
}
