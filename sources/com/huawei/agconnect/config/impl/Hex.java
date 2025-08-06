package com.huawei.agconnect.config.impl;

public class Hex {
    private static final char[] HEX_CODE = "0123456789ABCDEF".toCharArray();

    private static byte[] decodeHex(char[] cArr) {
        if ((cArr.length & 1) == 0) {
            byte[] bArr = new byte[(cArr.length >> 1)];
            int i11 = 0;
            int i12 = 0;
            while (i11 < cArr.length) {
                int digit = Character.digit(cArr[i11], 16);
                if (digit != -1) {
                    int i13 = i11 + 1;
                    int digit2 = Character.digit(cArr[i13], 16);
                    if (digit2 != -1) {
                        i11 = i13 + 1;
                        bArr[i12] = (byte) (((digit << 4) | digit2) & 255);
                        i12++;
                    } else {
                        throw new IllegalArgumentException("Illegal hexadecimal character at index " + i13);
                    }
                } else {
                    throw new IllegalArgumentException("Illegal hexadecimal character at index " + i11);
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Odd number of characters.");
    }

    public static byte[] decodeHexString(String str) {
        return decodeHex(str.toCharArray());
    }

    public static String encodeHexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            char[] cArr = HEX_CODE;
            sb2.append(cArr[(b11 >> 4) & 15]);
            sb2.append(cArr[b11 & 15]);
        }
        return sb2.toString();
    }
}
