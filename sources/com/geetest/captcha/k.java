package com.geetest.captcha;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f65232a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < bArr.length; i11++) {
            char[] cArr = f65232a;
            sb2.append(cArr[(bArr[i11] >> 4) & 15]);
            sb2.append(cArr[bArr[i11] & 15]);
        }
        return sb2.toString();
    }

    public static byte[] a(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            int digit = Character.digit(charArray[i12 + 1], 16) | (Character.digit(charArray[i12], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i11] = (byte) digit;
        }
        return bArr;
    }
}
