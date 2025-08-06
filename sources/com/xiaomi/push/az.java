package com.xiaomi.push;

import okio.Utf8;

public class az {

    /* renamed from: a  reason: collision with root package name */
    private static final String f51414a = System.getProperty("line.separator");

    /* renamed from: a  reason: collision with other field name */
    private static byte[] f2549a = new byte[128];

    /* renamed from: a  reason: collision with other field name */
    private static char[] f2550a = new char[64];

    static {
        char c11 = 'A';
        int i11 = 0;
        while (c11 <= 'Z') {
            f2550a[i11] = c11;
            c11 = (char) (c11 + 1);
            i11++;
        }
        char c12 = 'a';
        while (c12 <= 'z') {
            f2550a[i11] = c12;
            c12 = (char) (c12 + 1);
            i11++;
        }
        char c13 = '0';
        while (c13 <= '9') {
            f2550a[i11] = c13;
            c13 = (char) (c13 + 1);
            i11++;
        }
        char[] cArr = f2550a;
        cArr[i11] = '+';
        cArr[i11 + 1] = '/';
        int i12 = 0;
        while (true) {
            byte[] bArr = f2549a;
            if (i12 >= bArr.length) {
                break;
            }
            bArr[i12] = -1;
            i12++;
        }
        for (int i13 = 0; i13 < 64; i13++) {
            f2549a[f2550a[i13]] = (byte) i13;
        }
    }

    public static String a(String str) {
        return new String(a(str.getBytes()));
    }

    public static String b(String str) {
        return new String(a(str));
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static char[] a(byte[] bArr, int i11, int i12) {
        int i13;
        byte b11;
        byte b12;
        int i14 = ((i12 * 4) + 2) / 3;
        char[] cArr = new char[(((i12 + 2) / 3) * 4)];
        int i15 = i12 + i11;
        int i16 = 0;
        while (i11 < i15) {
            int i17 = i11 + 1;
            byte b13 = bArr[i11] & 255;
            if (i17 < i15) {
                i13 = i17 + 1;
                b11 = bArr[i17] & 255;
            } else {
                i13 = i17;
                b11 = 0;
            }
            if (i13 < i15) {
                b12 = bArr[i13] & 255;
                i13++;
            } else {
                b12 = 0;
            }
            int i18 = b13 >>> 2;
            int i19 = ((b13 & 3) << 4) | (b11 >>> 4);
            int i21 = ((b11 & 15) << 2) | (b12 >>> 6);
            byte b14 = b12 & Utf8.REPLACEMENT_BYTE;
            int i22 = i16 + 1;
            char[] cArr2 = f2550a;
            cArr[i16] = cArr2[i18];
            int i23 = i22 + 1;
            cArr[i22] = cArr2[i19];
            char c11 = '=';
            cArr[i23] = i23 < i14 ? cArr2[i21] : '=';
            int i24 = i23 + 1;
            if (i24 < i14) {
                c11 = cArr2[b14];
            }
            cArr[i24] = c11;
            i16 = i24 + 1;
            i11 = i13;
        }
        return cArr;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m2417a(String str) {
        return a(str.toCharArray());
    }

    public static byte[] a(char[] cArr) {
        return a(cArr, 0, cArr.length);
    }

    public static byte[] a(char[] cArr, int i11, int i12) {
        int i13;
        char c11;
        char c12;
        int i14;
        if (i12 % 4 == 0) {
            while (i12 > 0 && cArr[(i11 + i12) - 1] == '=') {
                i12--;
            }
            int i15 = (i12 * 3) / 4;
            byte[] bArr = new byte[i15];
            int i16 = i12 + i11;
            int i17 = 0;
            while (i11 < i16) {
                int i18 = i11 + 1;
                char c13 = cArr[i11];
                int i19 = i18 + 1;
                char c14 = cArr[i18];
                if (i19 < i16) {
                    i13 = i19 + 1;
                    c11 = cArr[i19];
                } else {
                    i13 = i19;
                    c11 = 'A';
                }
                if (i13 < i16) {
                    i14 = i13 + 1;
                    c12 = cArr[i13];
                } else {
                    int i21 = i13;
                    c12 = 'A';
                    i14 = i21;
                }
                if (c13 > 127 || c14 > 127 || c11 > 127 || c12 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = f2549a;
                byte b11 = bArr2[c13];
                byte b12 = bArr2[c14];
                byte b13 = bArr2[c11];
                byte b14 = bArr2[c12];
                if (b11 < 0 || b12 < 0 || b13 < 0 || b14 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i22 = (b11 << 2) | (b12 >>> 4);
                int i23 = ((b12 & 15) << 4) | (b13 >>> 2);
                byte b15 = ((b13 & 3) << 6) | b14;
                int i24 = i17 + 1;
                bArr[i17] = (byte) i22;
                if (i24 < i15) {
                    bArr[i24] = (byte) i23;
                    i24++;
                }
                if (i24 < i15) {
                    bArr[i24] = (byte) b15;
                    i17 = i24 + 1;
                } else {
                    i17 = i24;
                }
                i11 = i14;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }
}
