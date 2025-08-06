package com.google.zxing.oned;

public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = {'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = {'/', ':', '+', '.'};
    private static final char DEFAULT_GUARD;
    private static final char[] START_END_CHARS;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        START_END_CHARS = cArr;
        DEFAULT_GUARD = cArr[0];
    }

    public boolean[] encode(String str) {
        int i11;
        if (str.length() < 2) {
            StringBuilder sb2 = new StringBuilder();
            char c11 = DEFAULT_GUARD;
            sb2.append(c11);
            sb2.append(str);
            sb2.append(c11);
            str = sb2.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = START_END_CHARS;
            boolean arrayContains = CodaBarReader.arrayContains(cArr, upperCase);
            boolean arrayContains2 = CodaBarReader.arrayContains(cArr, upperCase2);
            char[] cArr2 = ALT_START_END_CHARS;
            boolean arrayContains3 = CodaBarReader.arrayContains(cArr2, upperCase);
            boolean arrayContains4 = CodaBarReader.arrayContains(cArr2, upperCase2);
            if (arrayContains) {
                if (!arrayContains2) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (arrayContains3) {
                if (!arrayContains4) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (arrayContains2 || arrayContains4) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            } else {
                StringBuilder sb3 = new StringBuilder();
                char c12 = DEFAULT_GUARD;
                sb3.append(c12);
                sb3.append(str);
                sb3.append(c12);
                str = sb3.toString();
            }
        }
        int i12 = 20;
        for (int i13 = 1; i13 < str.length() - 1; i13++) {
            if (Character.isDigit(str.charAt(i13)) || str.charAt(i13) == '-' || str.charAt(i13) == '$') {
                i12 += 9;
            } else if (CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i13))) {
                i12 += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i13) + '\'');
            }
        }
        boolean[] zArr = new boolean[(i12 + (str.length() - 1))];
        int i14 = 0;
        for (int i15 = 0; i15 < str.length(); i15++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i15));
            if (i15 == 0 || i15 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i16 = 0;
            while (true) {
                char[] cArr3 = CodaBarReader.ALPHABET;
                if (i16 >= cArr3.length) {
                    i11 = 0;
                    break;
                } else if (upperCase3 == cArr3[i16]) {
                    i11 = CodaBarReader.CHARACTER_ENCODINGS[i16];
                    break;
                } else {
                    i16++;
                }
            }
            int i17 = 0;
            int i18 = 0;
            boolean z11 = true;
            while (i17 < 7) {
                zArr[i14] = z11;
                i14++;
                if (((i11 >> (6 - i17)) & 1) == 0 || i18 == 1) {
                    z11 = !z11;
                    i17++;
                    i18 = 0;
                } else {
                    i18++;
                }
            }
            if (i15 < str.length() - 1) {
                zArr[i14] = false;
                i14++;
            }
        }
        return zArr;
    }
}
