package com.amazonaws.util;

public enum CodecUtils {
    ;

    public static int sanitize(String str, byte[] bArr) {
        int length = bArr.length;
        char[] charArray = str.toCharArray();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char c11 = charArray[i12];
            if (!(c11 == 13 || c11 == 10 || c11 == ' ')) {
                if (c11 <= 127) {
                    bArr[i11] = (byte) c11;
                    i11++;
                } else {
                    throw new IllegalArgumentException("Invalid character found at position " + i12 + " for " + str);
                }
            }
        }
        return i11;
    }

    public static void sanityCheckLastPos(int i11, int i12) {
        if ((i11 & i12) != 0) {
            throw new IllegalArgumentException("Invalid last non-pad character detected");
        }
    }

    public static byte[] toBytesDirect(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        int i11 = 0;
        while (i11 < length) {
            char c11 = charArray[i11];
            if (c11 <= 127) {
                bArr[i11] = (byte) c11;
                i11++;
            } else {
                throw new IllegalArgumentException("Invalid character found at position " + i11 + " for " + str);
            }
        }
        return bArr;
    }

    public static String toStringDirect(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            cArr[i12] = (char) bArr[i11];
            i11++;
            i12++;
        }
        return new String(cArr);
    }
}
