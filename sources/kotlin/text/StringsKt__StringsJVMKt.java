package kotlin.text;

import java.util.Comparator;
import kotlin.collections.IntIterator;
import kotlin.collections.a;
import kotlin.jvm.internal.d0;
import kotlin.ranges.h;

class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static boolean A(String str, int i11, String str2, int i12, int i13, boolean z11) {
        if (!z11) {
            return str.regionMatches(i11, str2, i12, i13);
        }
        return str.regionMatches(z11, i11, str2, i12, i13);
    }

    public static /* synthetic */ boolean B(String str, int i11, String str2, int i12, int i13, boolean z11, int i14, Object obj) {
        if ((i14 & 16) != 0) {
            z11 = false;
        }
        return A(str, i11, str2, i12, i13, z11);
    }

    public static String C(CharSequence charSequence, int i11) {
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i11 + '.').toString());
        } else if (i11 == 0) {
            return "";
        } else {
            if (i11 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb2 = new StringBuilder(charSequence.length() * i11);
                IntIterator d11 = new h(1, i11).iterator();
                while (d11.hasNext()) {
                    d11.a();
                    sb2.append(charSequence);
                }
                return sb2.toString();
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                cArr[i12] = charAt;
            }
            return new String(cArr);
        }
    }

    public static final String D(String str, char c11, char c12, boolean z11) {
        if (!z11) {
            return str.replace(c11, c12);
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (CharsKt__CharKt.e(charAt, c11, z11)) {
                charAt = c12;
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String E(String str, String str2, String str3, boolean z11) {
        int i11 = 0;
        int c02 = StringsKt__StringsKt.c0(str, str2, 0, z11);
        if (c02 < 0) {
            return str;
        }
        int length = str2.length();
        int d11 = RangesKt___RangesKt.d(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb2 = new StringBuilder(length2);
            do {
                sb2.append(str, i11, c02);
                sb2.append(str3);
                i11 = c02 + length;
                if (c02 >= str.length() || (c02 = StringsKt__StringsKt.c0(str, str2, c02 + d11, z11)) <= 0) {
                    sb2.append(str, i11, str.length());
                }
                sb2.append(str, i11, c02);
                sb2.append(str3);
                i11 = c02 + length;
                break;
            } while ((c02 = StringsKt__StringsKt.c0(str, str2, c02 + d11, z11)) <= 0);
            sb2.append(str, i11, str.length());
            return sb2.toString();
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String F(String str, char c11, char c12, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return D(str, c11, c12, z11);
    }

    public static /* synthetic */ String G(String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return E(str, str2, str3, z11);
    }

    public static final String H(String str, String str2, String str3, boolean z11) {
        int g02 = StringsKt__StringsKt.g0(str, str2, 0, z11, 2, (Object) null);
        return g02 < 0 ? str : StringsKt__StringsKt.F0(str, g02, str2.length() + g02, str3).toString();
    }

    public static /* synthetic */ String I(String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return H(str, str2, str3, z11);
    }

    public static boolean J(String str, String str2, int i11, boolean z11) {
        if (!z11) {
            return str.startsWith(str2, i11);
        }
        return A(str, i11, str2, 0, str2.length(), z11);
    }

    public static boolean K(String str, String str2, boolean z11) {
        if (!z11) {
            return str.startsWith(str2);
        }
        return A(str, 0, str2, 0, str2.length(), z11);
    }

    public static /* synthetic */ boolean L(String str, String str2, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return J(str, str2, i11, z11);
    }

    public static /* synthetic */ boolean M(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return K(str, str2, z11);
    }

    public static String q(char[] cArr) {
        return new String(cArr);
    }

    public static String r(char[] cArr, int i11, int i12) {
        a.Companion.a(i11, i12, cArr.length);
        return new String(cArr, i11, i12 - i11);
    }

    public static final boolean s(CharSequence charSequence, CharSequence charSequence2) {
        if (!(charSequence instanceof String) || charSequence2 == null) {
            return StringsKt__StringsKt.T(charSequence, charSequence2);
        }
        return ((String) charSequence).contentEquals(charSequence2);
    }

    public static boolean t(CharSequence charSequence, CharSequence charSequence2, boolean z11) {
        if (z11) {
            return StringsKt__StringsKt.S(charSequence, charSequence2);
        }
        return s(charSequence, charSequence2);
    }

    public static boolean u(String str, String str2, boolean z11) {
        if (!z11) {
            return str.endsWith(str2);
        }
        return A(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean v(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return u(str, str2, z11);
    }

    public static boolean w(String str, String str2, boolean z11) {
        if (str == null) {
            return str2 == null;
        }
        if (!z11) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean x(String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return w(str, str2, z11);
    }

    public static Comparator<String> y(d0 d0Var) {
        return String.CASE_INSENSITIVE_ORDER;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean z(java.lang.CharSequence r4) {
        /*
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0039
            kotlin.ranges.h r0 = kotlin.text.StringsKt__StringsKt.Z(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x001b
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x001b
        L_0x0019:
            r4 = r2
            goto L_0x0037
        L_0x001b:
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0019
            r3 = r0
            kotlin.collections.IntIterator r3 = (kotlin.collections.IntIterator) r3
            int r3 = r3.a()
            char r3 = r4.charAt(r3)
            boolean r3 = kotlin.text.CharsKt__CharJVMKt.c(r3)
            if (r3 != 0) goto L_0x001f
            r4 = r1
        L_0x0037:
            if (r4 == 0) goto L_0x003a
        L_0x0039:
            r1 = r2
        L_0x003a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsJVMKt.z(java.lang.CharSequence):boolean");
    }
}
