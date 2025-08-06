package kotlin.text;

import kotlin.jvm.internal.x;

class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Void l(String str) {
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    public static Integer m(String str) {
        return n(str, 10);
    }

    public static final Integer n(String str, int i11) {
        boolean z11;
        int i12;
        int unused = CharsKt__CharJVMKt.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i13 = 0;
        char charAt = str.charAt(0);
        int c11 = x.c(charAt, 48);
        int i14 = CellBase.GROUP_ID_END_USER;
        int i15 = 1;
        if (c11 >= 0) {
            z11 = false;
            i15 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i14 = Integer.MIN_VALUE;
                z11 = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z11 = false;
            }
        }
        int i16 = -59652323;
        while (i15 < length) {
            int b11 = CharsKt__CharJVMKt.b(str.charAt(i15), i11);
            if (b11 < 0) {
                return null;
            }
            if ((i13 < i16 && (i16 != -59652323 || i13 < (i16 = i14 / i11))) || (i12 = i13 * i11) < i14 + b11) {
                return null;
            }
            i13 = i12 - b11;
            i15++;
        }
        return z11 ? Integer.valueOf(i13) : Integer.valueOf(-i13);
    }

    public static Long o(String str) {
        return p(str, 10);
    }

    public static final Long p(String str, int i11) {
        String str2 = str;
        int i12 = i11;
        int unused = CharsKt__CharJVMKt.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i13 = 0;
        char charAt = str2.charAt(0);
        long j11 = -9223372036854775807L;
        boolean z11 = true;
        if (x.c(charAt, 48) >= 0) {
            z11 = false;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                j11 = Long.MIN_VALUE;
                i13 = 1;
            } else if (charAt != '+') {
                return null;
            } else {
                z11 = false;
                i13 = 1;
            }
        }
        long j12 = -256204778801521550L;
        long j13 = 0;
        long j14 = -256204778801521550L;
        while (i13 < length) {
            int b11 = CharsKt__CharJVMKt.b(str2.charAt(i13), i12);
            if (b11 < 0) {
                return null;
            }
            if (j13 < j14) {
                if (j14 == j12) {
                    j14 = j11 / ((long) i12);
                    if (j13 < j14) {
                    }
                }
                return null;
            }
            long j15 = j13 * ((long) i12);
            long j16 = (long) b11;
            if (j15 < j11 + j16) {
                return null;
            }
            j13 = j15 - j16;
            i13++;
            j12 = -256204778801521550L;
        }
        return z11 ? Long.valueOf(j13) : Long.valueOf(-j13);
    }
}
