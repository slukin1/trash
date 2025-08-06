package org.joda.time.format;

import java.io.IOException;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final double f23230a = Math.log(10.0d);

    public static void a(Appendable appendable, int i11, int i12) throws IOException {
        if (i11 < 0) {
            appendable.append('-');
            if (i11 != Integer.MIN_VALUE) {
                i11 = -i11;
            } else {
                while (i12 > 10) {
                    appendable.append('0');
                    i12--;
                }
                appendable.append("2147483648");
                return;
            }
        }
        if (i11 < 10) {
            while (i12 > 1) {
                appendable.append('0');
                i12--;
            }
            appendable.append((char) (i11 + 48));
        } else if (i11 < 100) {
            while (i12 > 2) {
                appendable.append('0');
                i12--;
            }
            int i13 = ((i11 + 1) * 13421772) >> 27;
            appendable.append((char) (i13 + 48));
            appendable.append((char) (((i11 - (i13 << 3)) - (i13 << 1)) + 48));
        } else {
            int log = i11 < 1000 ? 3 : i11 < 10000 ? 4 : ((int) (Math.log((double) i11) / f23230a)) + 1;
            while (i12 > log) {
                appendable.append('0');
                i12--;
            }
            appendable.append(Integer.toString(i11));
        }
    }

    public static void b(StringBuffer stringBuffer, int i11, int i12) {
        try {
            a(stringBuffer, i11, i12);
        } catch (IOException unused) {
        }
    }

    public static void c(Appendable appendable, int i11) throws IOException {
        if (i11 < 0) {
            appendable.append('-');
            if (i11 != Integer.MIN_VALUE) {
                i11 = -i11;
            } else {
                appendable.append("2147483648");
                return;
            }
        }
        if (i11 < 10) {
            appendable.append((char) (i11 + 48));
        } else if (i11 < 100) {
            int i12 = ((i11 + 1) * 13421772) >> 27;
            appendable.append((char) (i12 + 48));
            appendable.append((char) (((i11 - (i12 << 3)) - (i12 << 1)) + 48));
        } else {
            appendable.append(Integer.toString(i11));
        }
    }

    public static void d(Appendable appendable, long j11) throws IOException {
        int i11 = (int) j11;
        if (((long) i11) == j11) {
            c(appendable, i11);
        } else {
            appendable.append(Long.toString(j11));
        }
    }

    public static void e(StringBuffer stringBuffer, int i11) {
        try {
            c(stringBuffer, i11);
        } catch (IOException unused) {
        }
    }

    public static void f(StringBuffer stringBuffer, long j11) {
        try {
            d(stringBuffer, j11);
        } catch (IOException unused) {
        }
    }

    public static int g(long j11) {
        if (j11 < 0) {
            if (j11 != Long.MIN_VALUE) {
                return g(-j11) + 1;
            }
            return 20;
        } else if (j11 < 10) {
            return 1;
        } else {
            if (j11 < 100) {
                return 2;
            }
            if (j11 < 1000) {
                return 3;
            }
            if (j11 < 10000) {
                return 4;
            }
            return 1 + ((int) (Math.log((double) j11) / f23230a));
        }
    }

    public static String h(String str, int i11) {
        String str2;
        int i12 = i11 + 32;
        if (str.length() <= i12 + 3) {
            str2 = str;
        } else {
            str2 = str.substring(0, i12).concat("...");
        }
        if (i11 <= 0) {
            return "Invalid format: \"" + str2 + '\"';
        } else if (i11 >= str.length()) {
            return "Invalid format: \"" + str2 + "\" is too short";
        } else {
            return "Invalid format: \"" + str2 + "\" is malformed at \"" + str2.substring(i11) + '\"';
        }
    }

    public static int i(CharSequence charSequence, int i11) {
        int charAt = charSequence.charAt(i11) - '0';
        return (((charAt << 3) + (charAt << 1)) + charSequence.charAt(i11 + 1)) - 48;
    }
}
