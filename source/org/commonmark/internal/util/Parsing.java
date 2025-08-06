package org.commonmark.internal.util;

import okio.Utf8;

public class Parsing {

    /* renamed from: a  reason: collision with root package name */
    public static int f59756a = 4;

    public static int a(int i11) {
        return 4 - (i11 % 4);
    }

    public static int b(char c11, CharSequence charSequence, int i11) {
        int length = charSequence.length();
        while (i11 < length) {
            if (charSequence.charAt(i11) == c11) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int c(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt == 10 || charAt == 13) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int d(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt != ' ') {
                switch (charAt) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        return i11;
                }
            }
            i11++;
        }
        return -1;
    }

    public static boolean e(CharSequence charSequence) {
        int length = charSequence.length();
        if (k(' ', charSequence, 0, length) != length) {
            return true;
        }
        return false;
    }

    public static boolean f(CharSequence charSequence) {
        return d(charSequence, 0) == -1;
    }

    public static boolean g(CharSequence charSequence, int i11) {
        if (i11 >= charSequence.length()) {
            return false;
        }
        char charAt = charSequence.charAt(i11);
        switch (charAt) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (charAt) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (charAt) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                                return true;
                            default:
                                switch (charAt) {
                                    case '{':
                                    case '|':
                                    case '}':
                                    case '~':
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static boolean h(CharSequence charSequence, int i11) {
        return Character.isLetter(Character.codePointAt(charSequence, i11));
    }

    public static boolean i(CharSequence charSequence, int i11) {
        if (i11 >= charSequence.length()) {
            return false;
        }
        char charAt = charSequence.charAt(i11);
        return charAt == 9 || charAt == ' ';
    }

    public static CharSequence j(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder sb2 = null;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = charSequence.charAt(i11);
            if (charAt == 0) {
                if (sb2 == null) {
                    sb2 = new StringBuilder(length);
                    sb2.append(charSequence, 0, i11);
                }
                sb2.append(Utf8.REPLACEMENT_CHARACTER);
            } else if (sb2 != null) {
                sb2.append(charAt);
            }
        }
        return sb2 != null ? sb2.toString() : charSequence;
    }

    public static int k(char c11, CharSequence charSequence, int i11, int i12) {
        while (i11 < i12) {
            if (charSequence.charAt(i11) != c11) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static int l(char c11, CharSequence charSequence, int i11, int i12) {
        while (i11 >= i12) {
            if (charSequence.charAt(i11) != c11) {
                return i11;
            }
            i11--;
        }
        return i12 - 1;
    }

    public static int m(CharSequence charSequence, int i11, int i12) {
        while (i11 < i12) {
            char charAt = charSequence.charAt(i11);
            if (charAt != 9 && charAt != ' ') {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static int n(CharSequence charSequence, int i11, int i12) {
        while (i11 >= i12) {
            char charAt = charSequence.charAt(i11);
            if (charAt != 9 && charAt != ' ') {
                return i11;
            }
            i11--;
        }
        return i12 - 1;
    }
}
