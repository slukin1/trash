package org.ejbca.cvc.util;

public final class StringConverter {
    private static final char[] HEXCHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String HEXINDEX = "0123456789abcdef          ABCDEF";

    private StringConverter() {
    }

    public static String byteToHex(byte[] bArr) {
        return byteToHex(bArr, (String) null);
    }

    public static byte[] hexToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = i12 + 1;
            bArr[i11] = (byte) (((HEXINDEX.indexOf(str.charAt(i12)) & 15) << 4) + (HEXINDEX.indexOf(str.charAt(i13)) & 15));
            i11++;
            i12 = i13 + 1;
        }
        return bArr;
    }

    public static String byteToHex(byte[] bArr, String str) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < length; i11++) {
            stringBuffer.append(byteToHex(bArr[i11]));
            if (str != null && i11 + 1 < length) {
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }

    public static String byteToHex(byte b11) {
        byte b12 = b11 & 255;
        char[] cArr = HEXCHAR;
        char c11 = cArr[(b12 >> 4) & 15];
        char c12 = cArr[b12 & 15];
        return Character.toString(c11) + c12;
    }
}
