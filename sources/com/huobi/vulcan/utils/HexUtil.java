package com.huobi.vulcan.utils;

public class HexUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f20609a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f20610b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = i11 + 1;
            cArr2[i11] = cArr[(bArr[i12] & 240) >>> 4];
            i11 = i13 + 1;
            cArr2[i13] = cArr[bArr[i12] & 15];
        }
        return cArr2;
    }

    public static String b(byte[] bArr) {
        return c(bArr, true);
    }

    public static String c(byte[] bArr, boolean z11) {
        return d(bArr, z11 ? f20609a : f20610b);
    }

    public static String d(byte[] bArr, char[] cArr) {
        return new String(a(bArr, cArr));
    }
}
