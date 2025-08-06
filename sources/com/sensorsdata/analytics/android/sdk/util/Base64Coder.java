package com.sensorsdata.analytics.android.sdk.util;

import com.sensorsdata.analytics.android.sdk.SALog;
import java.io.UnsupportedEncodingException;
import okio.Utf8;

public class Base64Coder {
    public static final String CHARSET_UTF8 = "UTF-8";
    private static char[] map1 = new char[64];
    private static byte[] map2 = new byte[128];

    static {
        char c11 = 'A';
        int i11 = 0;
        while (c11 <= 'Z') {
            map1[i11] = c11;
            c11 = (char) (c11 + 1);
            i11++;
        }
        char c12 = 'a';
        while (c12 <= 'z') {
            map1[i11] = c12;
            c12 = (char) (c12 + 1);
            i11++;
        }
        char c13 = '0';
        while (c13 <= '9') {
            map1[i11] = c13;
            c13 = (char) (c13 + 1);
            i11++;
        }
        char[] cArr = map1;
        cArr[i11] = '+';
        cArr[i11 + 1] = '/';
        int i12 = 0;
        while (true) {
            byte[] bArr = map2;
            if (i12 >= bArr.length) {
                break;
            }
            bArr[i12] = -1;
            i12++;
        }
        for (int i13 = 0; i13 < 64; i13++) {
            map2[map1[i13]] = (byte) i13;
        }
    }

    public static byte[] decode(String str) {
        return decode(str.toCharArray());
    }

    public static String decodeString(String str) {
        return new String(decode(str));
    }

    public static char[] encode(byte[] bArr) {
        return encode(bArr, bArr.length);
    }

    public static String encodeString(String str) {
        try {
            return new String(encode(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public static byte[] decode(char[] cArr) {
        int i11;
        char c11;
        char c12;
        int i12;
        int length = cArr.length;
        if (length % 4 == 0) {
            while (length > 0 && cArr[length - 1] == '=') {
                length--;
            }
            int i13 = (length * 3) / 4;
            byte[] bArr = new byte[i13];
            int i14 = 0;
            for (int i15 = 0; i15 < length; i15 = i12) {
                int i16 = i15 + 1;
                char c13 = cArr[i15];
                int i17 = i16 + 1;
                char c14 = cArr[i16];
                if (i17 < length) {
                    i11 = i17 + 1;
                    c11 = cArr[i17];
                } else {
                    i11 = i17;
                    c11 = 'A';
                }
                if (i11 < length) {
                    i12 = i11 + 1;
                    c12 = cArr[i11];
                } else {
                    int i18 = i11;
                    c12 = 'A';
                    i12 = i18;
                }
                if (c13 > 127 || c14 > 127 || c11 > 127 || c12 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = map2;
                byte b11 = bArr2[c13];
                byte b12 = bArr2[c14];
                byte b13 = bArr2[c11];
                byte b14 = bArr2[c12];
                if (b11 < 0 || b12 < 0 || b13 < 0 || b14 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i19 = (b11 << 2) | (b12 >>> 4);
                int i21 = ((b12 & 15) << 4) | (b13 >>> 2);
                byte b15 = ((b13 & 3) << 6) | b14;
                int i22 = i14 + 1;
                bArr[i14] = (byte) i19;
                if (i22 < i13) {
                    bArr[i22] = (byte) i21;
                    i22++;
                }
                if (i22 < i13) {
                    bArr[i22] = (byte) b15;
                    i14 = i22 + 1;
                } else {
                    i14 = i22;
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] encode(byte[] bArr, int i11) {
        int i12;
        byte b11;
        byte b12;
        int i13 = ((i11 * 4) + 2) / 3;
        char[] cArr = new char[(((i11 + 2) / 3) * 4)];
        int i14 = 0;
        int i15 = 0;
        while (i14 < i11) {
            int i16 = i14 + 1;
            byte b13 = bArr[i14] & 255;
            if (i16 < i11) {
                i12 = i16 + 1;
                b11 = bArr[i16] & 255;
            } else {
                i12 = i16;
                b11 = 0;
            }
            if (i12 < i11) {
                b12 = bArr[i12] & 255;
                i12++;
            } else {
                b12 = 0;
            }
            int i17 = b13 >>> 2;
            int i18 = ((b13 & 3) << 4) | (b11 >>> 4);
            int i19 = ((b11 & 15) << 2) | (b12 >>> 6);
            byte b14 = b12 & Utf8.REPLACEMENT_BYTE;
            int i21 = i15 + 1;
            char[] cArr2 = map1;
            cArr[i15] = cArr2[i17];
            int i22 = i21 + 1;
            cArr[i21] = cArr2[i18];
            char c11 = '=';
            cArr[i22] = i22 < i13 ? cArr2[i19] : '=';
            int i23 = i22 + 1;
            if (i23 < i13) {
                c11 = cArr2[b14];
            }
            cArr[i23] = c11;
            i15 = i23 + 1;
            i14 = i12;
        }
        return cArr;
    }
}
