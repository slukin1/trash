package org.bouncycastle.pqc.math.linearalgebra;

public final class ByteUtils {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private ByteUtils() {
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] concatenate(byte[][] bArr) {
        int length = bArr[0].length;
        byte[] bArr2 = new byte[(bArr.length * length)];
        int i11 = 0;
        for (byte[] arraycopy : bArr) {
            System.arraycopy(arraycopy, 0, bArr2, i11, length);
            i11 += length;
        }
        return bArr2;
    }

    public static int deepHashCode(byte[] bArr) {
        int i11 = 1;
        for (byte b11 : bArr) {
            i11 = (i11 * 31) + b11;
        }
        return i11;
    }

    public static int deepHashCode(byte[][] bArr) {
        int i11 = 1;
        for (byte[] deepHashCode : bArr) {
            i11 = (i11 * 31) + deepHashCode(deepHashCode);
        }
        return i11;
    }

    public static int deepHashCode(byte[][][] bArr) {
        int i11 = 1;
        for (byte[][] deepHashCode : bArr) {
            i11 = (i11 * 31) + deepHashCode(deepHashCode);
        }
        return i11;
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2 == null;
        }
        if (bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        boolean z11 = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            z11 &= bArr[length] == bArr2[length];
        }
        return z11;
    }

    public static boolean equals(byte[][] bArr, byte[][] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        boolean z11 = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            z11 &= equals(bArr[length], bArr2[length]);
        }
        return z11;
    }

    public static boolean equals(byte[][][] bArr, byte[][][] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        boolean z11 = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length].length != bArr2[length].length) {
                return false;
            }
            for (int length2 = bArr[length].length - 1; length2 >= 0; length2--) {
                z11 &= equals(bArr[length][length2], bArr2[length][length2]);
            }
        }
        return z11;
    }

    public static byte[] fromHexString(String str) {
        char[] charArray = str.toUpperCase().toCharArray();
        int i11 = 0;
        for (int i12 = 0; i12 < charArray.length; i12++) {
            if ((charArray[i12] >= '0' && charArray[i12] <= '9') || (charArray[i12] >= 'A' && charArray[i12] <= 'F')) {
                i11++;
            }
        }
        byte[] bArr = new byte[((i11 + 1) >> 1)];
        int i13 = i11 & 1;
        for (int i14 = 0; i14 < charArray.length; i14++) {
            if (charArray[i14] < '0' || charArray[i14] > '9') {
                if (charArray[i14] >= 'A' && charArray[i14] <= 'F') {
                    int i15 = i13 >> 1;
                    bArr[i15] = (byte) (bArr[i15] << 4);
                    bArr[i15] = (byte) (bArr[i15] | ((charArray[i14] - 'A') + 10));
                }
            } else {
                int i16 = i13 >> 1;
                bArr[i16] = (byte) (bArr[i16] << 4);
                bArr[i16] = (byte) (bArr[i16] | (charArray[i14] - '0'));
            }
            i13++;
        }
        return bArr;
    }

    public static byte[][] split(byte[] bArr, int i11) throws ArrayIndexOutOfBoundsException {
        if (i11 <= bArr.length) {
            byte[][] bArr2 = {new byte[i11], new byte[(bArr.length - i11)]};
            System.arraycopy(bArr, 0, bArr2[0], 0, i11);
            System.arraycopy(bArr, i11, bArr2[1], 0, bArr.length - i11);
            return bArr2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static byte[] subArray(byte[] bArr, int i11) {
        return subArray(bArr, i11, bArr.length);
    }

    public static byte[] subArray(byte[] bArr, int i11, int i12) {
        int i13 = i12 - i11;
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, i11, bArr2, 0, i13);
        return bArr2;
    }

    public static String toBinaryString(byte[] bArr) {
        String str = "";
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            for (int i12 = 0; i12 < 8; i12++) {
                str = str + ((b11 >>> i12) & 1);
            }
            if (i11 != bArr.length - 1) {
                str = str + " ";
            }
        }
        return str;
    }

    public static char[] toCharArray(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            cArr[i11] = (char) bArr[i11];
        }
        return cArr;
    }

    public static String toHexString(byte[] bArr) {
        String str = "";
        for (int i11 = 0; i11 < bArr.length; i11++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            char[] cArr = HEX_CHARS;
            sb2.append(cArr[(bArr[i11] >>> 4) & 15]);
            str = sb2.toString() + cArr[bArr[i11] & 15];
        }
        return str;
    }

    public static String toHexString(byte[] bArr, String str, String str2) {
        String str3 = new String(str);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            char[] cArr = HEX_CHARS;
            sb2.append(cArr[(bArr[i11] >>> 4) & 15]);
            str3 = sb2.toString() + cArr[bArr[i11] & 15];
            if (i11 < bArr.length - 1) {
                str3 = str3 + str2;
            }
        }
        return str3;
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr3[length] = (byte) (bArr[length] ^ bArr2[length]);
        }
        return bArr3;
    }
}
