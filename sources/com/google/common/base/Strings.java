package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible
public final class Strings {
    private Strings() {
    }

    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i11 = 0;
        while (i11 < min && charSequence.charAt(i11) == charSequence2.charAt(i11)) {
            i11++;
        }
        int i12 = i11 - 1;
        if (validSurrogatePairAt(charSequence, i12) || validSurrogatePairAt(charSequence2, i12)) {
            i11--;
        }
        return charSequence.subSequence(0, i11).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i11 = 0;
        while (i11 < min && charSequence.charAt((charSequence.length() - i11) - 1) == charSequence2.charAt((charSequence2.length() - i11) - 1)) {
            i11++;
        }
        if (validSurrogatePairAt(charSequence, (charSequence.length() - i11) - 1) || validSurrogatePairAt(charSequence2, (charSequence2.length() - i11) - 1)) {
            i11--;
        }
        return charSequence.subSequence(charSequence.length() - i11, charSequence.length()).toString();
    }

    public static String emptyToNull(String str) {
        return Platform.emptyToNull(str);
    }

    public static boolean isNullOrEmpty(String str) {
        return Platform.stringIsNullOrEmpty(str);
    }

    public static String lenientFormat(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i11 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i12 = 0; i12 < objArr.length; i12++) {
                objArr[i12] = lenientToString(objArr[i12]);
            }
        }
        StringBuilder sb2 = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i13 = 0;
        while (i11 < objArr.length && (indexOf = valueOf.indexOf("%s", i13)) != -1) {
            sb2.append(valueOf, i13, indexOf);
            sb2.append(objArr[i11]);
            i13 = indexOf + 2;
            i11++;
        }
        sb2.append(valueOf, i13, valueOf.length());
        if (i11 < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i11]);
            for (int i14 = i11 + 1; i14 < objArr.length; i14++) {
                sb2.append(", ");
                sb2.append(objArr[i14]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    private static String lenientToString(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e11) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, e11);
            return "<" + str + " threw " + e11.getClass().getName() + ">";
        }
    }

    public static String nullToEmpty(String str) {
        return Platform.nullToEmpty(str);
    }

    public static String padEnd(String str, int i11, char c11) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i11) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(i11);
        sb2.append(str);
        for (int length = str.length(); length < i11; length++) {
            sb2.append(c11);
        }
        return sb2.toString();
    }

    public static String padStart(String str, int i11, char c11) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i11) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(i11);
        for (int length = str.length(); length < i11; length++) {
            sb2.append(c11);
        }
        sb2.append(str);
        return sb2.toString();
    }

    public static String repeat(String str, int i11) {
        Preconditions.checkNotNull(str);
        boolean z11 = true;
        if (i11 <= 1) {
            if (i11 < 0) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "invalid count: %s", i11);
            return i11 == 0 ? "" : str;
        }
        int length = str.length();
        long j11 = ((long) length) * ((long) i11);
        int i12 = (int) j11;
        if (((long) i12) == j11) {
            char[] cArr = new char[i12];
            str.getChars(0, length, cArr, 0);
            while (true) {
                int i13 = i12 - length;
                if (length < i13) {
                    System.arraycopy(cArr, 0, cArr, length, length);
                    length <<= 1;
                } else {
                    System.arraycopy(cArr, 0, cArr, length, i13);
                    return new String(cArr);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j11);
        }
    }

    @VisibleForTesting
    public static boolean validSurrogatePairAt(CharSequence charSequence, int i11) {
        if (i11 < 0 || i11 > charSequence.length() - 2 || !Character.isHighSurrogate(charSequence.charAt(i11)) || !Character.isLowSurrogate(charSequence.charAt(i11 + 1))) {
            return false;
        }
        return true;
    }
}
