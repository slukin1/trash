package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

@GwtCompatible
@Beta
public final class PercentEscaper extends UnicodeEscaper {
    private static final char[] PLUS_SIGN = {'+'};
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    public PercentEscaper(String str, boolean z11) {
        Preconditions.checkNotNull(str);
        if (!str.matches(".*[0-9A-Za-z].*")) {
            String str2 = str + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            if (!z11 || !str2.contains(" ")) {
                this.plusForSpace = z11;
                this.safeOctets = createSafeOctets(str2);
                return;
            }
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] createSafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int i11 = -1;
        for (char max : charArray) {
            i11 = Math.max(max, i11);
        }
        boolean[] zArr = new boolean[(i11 + 1)];
        for (char c11 : charArray) {
            zArr[c11] = true;
        }
        return zArr;
    }

    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return escapeSlow(str, i11);
            }
        }
        return str;
    }

    public int nextEscapeIndex(CharSequence charSequence, int i11, int i12) {
        Preconditions.checkNotNull(charSequence);
        while (i11 < i12) {
            char charAt = charSequence.charAt(i11);
            boolean[] zArr = this.safeOctets;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i11++;
        }
        return i11;
    }

    public char[] escape(int i11) {
        boolean[] zArr = this.safeOctets;
        if (i11 < zArr.length && zArr[i11]) {
            return null;
        }
        if (i11 == 32 && this.plusForSpace) {
            return PLUS_SIGN;
        }
        if (i11 <= 127) {
            char[] cArr = new char[3];
            cArr[0] = '%';
            char[] cArr2 = UPPER_HEX_DIGITS;
            cArr[2] = cArr2[i11 & 15];
            cArr[1] = cArr2[i11 >>> 4];
            return cArr;
        } else if (i11 <= 2047) {
            char[] cArr3 = new char[6];
            cArr3[0] = '%';
            cArr3[3] = '%';
            char[] cArr4 = UPPER_HEX_DIGITS;
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
            char[] cArr6 = UPPER_HEX_DIGITS;
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
            char[] cArr8 = UPPER_HEX_DIGITS;
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
