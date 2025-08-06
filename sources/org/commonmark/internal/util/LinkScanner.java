package org.commonmark.internal.util;

public class LinkScanner {
    public static int a(CharSequence charSequence, int i11) {
        char charAt;
        if (i11 >= charSequence.length()) {
            return -1;
        }
        if (charSequence.charAt(i11) != '<') {
            return b(charSequence, i11);
        }
        while (true) {
            i11++;
            if (i11 >= charSequence.length() || (charAt = charSequence.charAt(i11)) == 10 || charAt == '<') {
                return -1;
            }
            if (charAt == '>') {
                return i11 + 1;
            }
            if (charAt == '\\') {
                int i12 = i11 + 1;
                if (Parsing.g(charSequence, i12)) {
                    i11 = i12;
                }
            }
        }
        return -1;
    }

    public static int b(CharSequence charSequence, int i11) {
        int i12 = 0;
        int i13 = i11;
        while (i13 < charSequence.length()) {
            char charAt = charSequence.charAt(i13);
            if (charAt != 0 && charAt != ' ') {
                if (charAt == '\\') {
                    int i14 = i13 + 1;
                    if (Parsing.g(charSequence, i14)) {
                        i13 = i14;
                    }
                } else if (charAt == '(') {
                    i12++;
                    if (i12 > 32) {
                        return -1;
                    }
                } else if (charAt != ')') {
                    if (Character.isISOControl(charAt)) {
                        if (i13 != i11) {
                            return i13;
                        }
                        return -1;
                    }
                } else if (i12 == 0) {
                    return i13;
                } else {
                    i12--;
                }
                i13++;
            } else if (i13 != i11) {
                return i13;
            } else {
                return -1;
            }
        }
        return charSequence.length();
    }

    public static int c(CharSequence charSequence, int i11) {
        while (i11 < charSequence.length()) {
            switch (charSequence.charAt(i11)) {
                case '[':
                    return -1;
                case '\\':
                    int i12 = i11 + 1;
                    if (!Parsing.g(charSequence, i12)) {
                        break;
                    } else {
                        i11 = i12;
                        break;
                    }
                case ']':
                    return i11;
            }
            i11++;
        }
        return charSequence.length();
    }

    public static int d(CharSequence charSequence, int i11) {
        if (i11 >= charSequence.length()) {
            return -1;
        }
        char charAt = charSequence.charAt(i11);
        char c11 = '\'';
        if (charAt == '\"') {
            c11 = '\"';
        } else if (charAt != '\'') {
            if (charAt != '(') {
                return -1;
            }
            c11 = ')';
        }
        int e11 = e(charSequence, i11 + 1, c11);
        if (e11 != -1 && e11 < charSequence.length() && charSequence.charAt(e11) == c11) {
            return e11 + 1;
        }
        return -1;
    }

    public static int e(CharSequence charSequence, int i11, char c11) {
        while (i11 < charSequence.length()) {
            char charAt = charSequence.charAt(i11);
            if (charAt == '\\') {
                int i12 = i11 + 1;
                if (Parsing.g(charSequence, i12)) {
                    i11 = i12;
                    i11++;
                }
            }
            if (charAt == c11) {
                return i11;
            }
            if (c11 == ')' && charAt == '(') {
                return -1;
            }
            i11++;
        }
        return charSequence.length();
    }
}
