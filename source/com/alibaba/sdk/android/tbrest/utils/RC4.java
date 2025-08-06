package com.alibaba.sdk.android.tbrest.utils;

public class RC4 {

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int[] f14751a;

        /* renamed from: b  reason: collision with root package name */
        public int f14752b;

        /* renamed from: c  reason: collision with root package name */
        public int f14753c;

        public b() {
            this.f14751a = new int[256];
        }
    }

    public static byte[] a(byte[] bArr, b bVar) {
        if (bArr == null || bVar == null) {
            return null;
        }
        int i11 = bVar.f14752b;
        int i12 = bVar.f14753c;
        for (int i13 = 0; i13 < bArr.length; i13++) {
            i11 = (i11 + 1) % 256;
            int[] iArr = bVar.f14751a;
            i12 = (iArr[i11] + i12) % 256;
            int i14 = iArr[i11];
            iArr[i11] = iArr[i12];
            iArr[i12] = i14;
            bArr[i13] = (byte) (iArr[(iArr[i11] + iArr[i12]) % 256] ^ bArr[i13]);
        }
        bVar.f14752b = i11;
        bVar.f14753c = i12;
        return bArr;
    }

    public static b b(String str) {
        if (str == null) {
            return null;
        }
        b bVar = new b();
        int i11 = 0;
        for (int i12 = 0; i12 < 256; i12++) {
            bVar.f14751a[i12] = i12;
        }
        bVar.f14752b = 0;
        bVar.f14753c = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 < 256) {
            try {
                char charAt = str.charAt(i13);
                int[] iArr = bVar.f14751a;
                i14 = ((charAt + iArr[i11]) + i14) % 256;
                int i15 = iArr[i11];
                iArr[i11] = iArr[i14];
                iArr[i14] = i15;
                i13 = (i13 + 1) % str.length();
                i11++;
            } catch (Exception unused) {
                return null;
            }
        }
        return bVar;
    }

    public static byte[] c(byte[] bArr) {
        return d(bArr, "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
    }

    public static byte[] d(byte[] bArr, String str) {
        b b11;
        if (bArr == null || str == null || (b11 = b(str)) == null) {
            return null;
        }
        return a(bArr, b11);
    }
}
