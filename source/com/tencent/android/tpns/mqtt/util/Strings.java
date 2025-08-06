package com.tencent.android.tpns.mqtt.util;

public final class Strings {
    private static final int INDEX_NOT_FOUND = -1;

    private Strings() {
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, toCharArray(charSequence2));
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int i11 = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i12 = 0;
        while (true) {
            int indexOf = indexOf(charSequence, charSequence2, i11);
            if (indexOf == -1) {
                return i12;
            }
            i12++;
            i11 = indexOf + charSequence2.length();
        }
    }

    public static boolean equalsAny(CharSequence charSequence, CharSequence[] charSequenceArr) {
        boolean z11 = charSequence == null && charSequenceArr == null;
        if (charSequenceArr != null) {
            for (int i11 = 0; i11 < charSequenceArr.length; i11++) {
                z11 = z11 || charSequenceArr[i11].equals(charSequence);
            }
        }
        return z11;
    }

    private static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i11) {
        return charSequence.toString().indexOf(charSequence2.toString(), i11);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private static char[] toCharArray(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i11 = 0; i11 < length; i11++) {
            cArr[i11] = charSequence.charAt(i11);
        }
        return cArr;
    }

    public static boolean containsAny(CharSequence charSequence, char[] cArr) {
        if (!isEmpty(charSequence) && !isEmpty(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i11 = length - 1;
            int i12 = length2 - 1;
            for (int i13 = 0; i13 < length; i13++) {
                char charAt = charSequence.charAt(i13);
                for (int i14 = 0; i14 < length2; i14++) {
                    if (cArr[i14] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i14 == i12) {
                            return true;
                        }
                        if (i13 < i11 && cArr[i14 + 1] == charSequence.charAt(i13 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean isEmpty(char[] cArr) {
        return cArr == null || cArr.length == 0;
    }
}
