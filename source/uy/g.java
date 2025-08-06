package uy;

public class g {

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int[] f40600a;

        /* renamed from: b  reason: collision with root package name */
        public int f40601b;

        /* renamed from: c  reason: collision with root package name */
        public int f40602c;

        public b() {
            this.f40600a = new int[256];
        }
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        b bVar = new b();
        int i11 = 0;
        for (int i12 = 0; i12 < 256; i12++) {
            bVar.f40600a[i12] = i12;
        }
        bVar.f40601b = 0;
        bVar.f40602c = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 < 256) {
            try {
                char charAt = str.charAt(i13);
                int[] iArr = bVar.f40600a;
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

    public static byte[] b(byte[] bArr, b bVar) {
        if (bArr == null || bVar == null) {
            return null;
        }
        int i11 = bVar.f40601b;
        int i12 = bVar.f40602c;
        for (int i13 = 0; i13 < bArr.length; i13++) {
            i11 = (i11 + 1) % 256;
            int[] iArr = bVar.f40600a;
            i12 = (iArr[i11] + i12) % 256;
            int i14 = iArr[i11];
            iArr[i11] = iArr[i12];
            iArr[i12] = i14;
            bArr[i13] = (byte) (iArr[(iArr[i11] + iArr[i12]) % 256] ^ bArr[i13]);
        }
        bVar.f40601b = i11;
        bVar.f40602c = i12;
        return bArr;
    }

    public static byte[] c(byte[] bArr) {
        b a11;
        if (bArr == null || (a11 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return b(bArr, a11);
    }
}
