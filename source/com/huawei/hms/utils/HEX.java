package com.huawei.hms.utils;

public final class HEX {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f38574a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f38575b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private HEX() {
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        if (bArr == null) {
            return new char[0];
        }
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

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, false);
    }

    public static String encodeHexString(byte[] bArr, boolean z11) {
        return new String(encodeHex(bArr, z11));
    }

    public static char[] encodeHex(byte[] bArr, boolean z11) {
        return a(bArr, z11 ? f38575b : f38574a);
    }
}
