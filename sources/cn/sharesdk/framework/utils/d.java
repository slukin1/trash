package cn.sharesdk.framework.utils;

public class d extends l {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f13517a = {'+'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f13518b = "0123456789ABCDEF".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private final boolean f13519c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean[] f13520d;

    public d(String str, boolean z11) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        } else if (z11 && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        } else if (!str.contains("%")) {
            this.f13519c = z11;
            this.f13520d = a(str);
        } else {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
    }

    private static boolean[] a(String str) {
        char[] charArray = str.toCharArray();
        int i11 = 122;
        for (char max : charArray) {
            i11 = Math.max(max, i11);
        }
        boolean[] zArr = new boolean[(i11 + 1)];
        for (int i12 = 48; i12 <= 57; i12++) {
            zArr[i12] = true;
        }
        for (int i13 = 65; i13 <= 90; i13++) {
            zArr[i13] = true;
        }
        for (int i14 = 97; i14 <= 122; i14++) {
            zArr[i14] = true;
        }
        for (char c11 : charArray) {
            zArr[c11] = true;
        }
        return zArr;
    }

    public String escape(String str) {
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            boolean[] zArr = this.f13520d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return a(str, i11);
            }
        }
        return str;
    }

    public int a(CharSequence charSequence, int i11, int i12) {
        while (i11 < i12) {
            char charAt = charSequence.charAt(i11);
            boolean[] zArr = this.f13520d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i11++;
        }
        return i11;
    }

    public char[] a(int i11) {
        boolean[] zArr = this.f13520d;
        if (i11 < zArr.length && zArr[i11]) {
            return null;
        }
        if (i11 == 32 && this.f13519c) {
            return f13517a;
        }
        if (i11 <= 127) {
            char[] cArr = new char[3];
            cArr[0] = '%';
            char[] cArr2 = f13518b;
            cArr[2] = cArr2[i11 & 15];
            cArr[1] = cArr2[i11 >>> 4];
            return cArr;
        } else if (i11 <= 2047) {
            char[] cArr3 = new char[6];
            cArr3[0] = '%';
            cArr3[3] = '%';
            char[] cArr4 = f13518b;
            cArr3[5] = cArr4[i11 & 15];
            int i12 = i11 >>> 4;
            cArr3[4] = cArr4[(i12 & 3) | 8];
            int i13 = i12 >>> 2;
            cArr3[2] = cArr4[i13 & 15];
            cArr3[1] = cArr4[(i13 >>> 4) | 12];
            return cArr3;
        } else if (i11 <= 65535) {
            char[] cArr5 = new char[9];
            cArr5[0] = '%';
            cArr5[1] = 'E';
            cArr5[3] = '%';
            cArr5[6] = '%';
            char[] cArr6 = f13518b;
            cArr5[8] = cArr6[i11 & 15];
            int i14 = i11 >>> 4;
            cArr5[7] = cArr6[(i14 & 3) | 8];
            int i15 = i14 >>> 2;
            cArr5[5] = cArr6[i15 & 15];
            int i16 = i15 >>> 4;
            cArr5[4] = cArr6[(i16 & 3) | 8];
            cArr5[2] = cArr6[i16 >>> 2];
            return cArr5;
        } else if (i11 <= 1114111) {
            char[] cArr7 = new char[12];
            cArr7[0] = '%';
            cArr7[1] = 'F';
            cArr7[3] = '%';
            cArr7[6] = '%';
            cArr7[9] = '%';
            char[] cArr8 = f13518b;
            cArr7[11] = cArr8[i11 & 15];
            int i17 = i11 >>> 4;
            cArr7[10] = cArr8[(i17 & 3) | 8];
            int i18 = i17 >>> 2;
            cArr7[8] = cArr8[i18 & 15];
            int i19 = i18 >>> 4;
            cArr7[7] = cArr8[(i19 & 3) | 8];
            int i21 = i19 >>> 2;
            cArr7[5] = cArr8[i21 & 15];
            int i22 = i21 >>> 4;
            cArr7[4] = cArr8[(i22 & 3) | 8];
            cArr7[2] = cArr8[(i22 >>> 2) & 7];
            return cArr7;
        } else {
            throw new IllegalArgumentException("Invalid unicode character value " + i11);
        }
    }
}
