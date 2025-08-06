package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible
@Beta
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    public static int codePointAt(CharSequence charSequence, int i11, int i12) {
        Preconditions.checkNotNull(charSequence);
        if (i11 < i12) {
            int i13 = i11 + 1;
            char charAt = charSequence.charAt(i11);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected low surrogate character '");
                sb2.append(charAt);
                sb2.append("' with value ");
                sb2.append(charAt);
                sb2.append(" at index ");
                sb2.append(i13 - 1);
                sb2.append(" in '");
                sb2.append(charSequence);
                sb2.append("'");
                throw new IllegalArgumentException(sb2.toString());
            } else if (i13 == i12) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i13);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + charAt2 + " at index " + i13 + " in '" + charSequence + "'");
            }
        } else {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
    }

    private static char[] growBuffer(char[] cArr, int i11, int i12) {
        if (i12 >= 0) {
            char[] cArr2 = new char[i12];
            if (i11 > 0) {
                System.arraycopy(cArr, 0, cArr2, 0, i11);
            }
            return cArr2;
        }
        throw new AssertionError("Cannot increase internal buffer any further");
    }

    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        int nextEscapeIndex = nextEscapeIndex(str, 0, length);
        return nextEscapeIndex == length ? str : escapeSlow(str, nextEscapeIndex);
    }

    public abstract char[] escape(int i11);

    public final String escapeSlow(String str, int i11) {
        int length = str.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int codePointAt = codePointAt(str, i11, length);
            if (codePointAt >= 0) {
                char[] escape = escape(codePointAt);
                int i14 = (Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1) + i11;
                if (escape != null) {
                    int i15 = i11 - i12;
                    int i16 = i13 + i15;
                    int length2 = escape.length + i16;
                    if (charBufferFromThreadLocal.length < length2) {
                        charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i13, length2 + (length - i11) + 32);
                    }
                    if (i15 > 0) {
                        str.getChars(i12, i11, charBufferFromThreadLocal, i13);
                        i13 = i16;
                    }
                    if (escape.length > 0) {
                        System.arraycopy(escape, 0, charBufferFromThreadLocal, i13, escape.length);
                        i13 += escape.length;
                    }
                    i12 = i14;
                }
                i11 = nextEscapeIndex(str, i14, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i17 = length - i12;
        if (i17 > 0) {
            int i18 = i17 + i13;
            if (charBufferFromThreadLocal.length < i18) {
                charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i13, i18);
            }
            str.getChars(i12, length, charBufferFromThreadLocal, i13);
            i13 = i18;
        }
        return new String(charBufferFromThreadLocal, 0, i13);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i11, int i12) {
        while (i11 < i12) {
            int codePointAt = codePointAt(charSequence, i11, i12);
            if (codePointAt < 0 || escape(codePointAt) != null) {
                break;
            }
            i11 += Character.isSupplementaryCodePoint(codePointAt) ? 2 : 1;
        }
        return i11;
    }
}
