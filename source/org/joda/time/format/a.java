package org.joda.time.format;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f23196a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReferenceArray<b> f23197b = new AtomicReferenceArray<>(25);

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        r4 = r0.putIfAbsent(r4, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.joda.time.format.b a(java.lang.String r4) {
        /*
            if (r4 == 0) goto L_0x0030
            int r0 = r4.length()
            if (r0 == 0) goto L_0x0030
            java.util.concurrent.ConcurrentHashMap<java.lang.String, org.joda.time.format.b> r0 = f23196a
            java.lang.Object r1 = r0.get(r4)
            org.joda.time.format.b r1 = (org.joda.time.format.b) r1
            if (r1 != 0) goto L_0x002f
            org.joda.time.format.DateTimeFormatterBuilder r1 = new org.joda.time.format.DateTimeFormatterBuilder
            r1.<init>()
            d(r1, r4)
            org.joda.time.format.b r1 = r1.e0()
            int r2 = r0.size()
            r3 = 500(0x1f4, float:7.0E-43)
            if (r2 >= r3) goto L_0x002f
            java.lang.Object r4 = r0.putIfAbsent(r4, r1)
            org.joda.time.format.b r4 = (org.joda.time.format.b) r4
            if (r4 == 0) goto L_0x002f
            r1 = r4
        L_0x002f:
            return r1
        L_0x0030:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Invalid pattern specification"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.a.a(java.lang.String):org.joda.time.format.b");
    }

    public static b b(String str) {
        return a(str);
    }

    public static boolean c(String str) {
        int length = str.length();
        if (length > 0) {
            switch (str.charAt(0)) {
                case 'C':
                case 'D':
                case 'F':
                case 'H':
                case 'K':
                case 'S':
                case 'W':
                case 'Y':
                case 'c':
                case 'd':
                case 'e':
                case 'h':
                case 'k':
                case 'm':
                case 's':
                case 'w':
                case 'x':
                case 'y':
                    break;
                case 'M':
                    if (length <= 2) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public static void d(DateTimeFormatterBuilder dateTimeFormatterBuilder, String str) {
        boolean z11;
        int length = str.length();
        int[] iArr = new int[1];
        int i11 = 0;
        while (i11 < length) {
            iArr[0] = i11;
            String e11 = e(str, iArr);
            int i12 = iArr[0];
            int length2 = e11.length();
            if (length2 != 0) {
                char charAt = e11.charAt(0);
                if (charAt == '\'') {
                    String substring = e11.substring(1);
                    if (substring.length() == 1) {
                        dateTimeFormatterBuilder.x(substring.charAt(0));
                    } else {
                        dateTimeFormatterBuilder.y(new String(substring));
                    }
                } else if (charAt == 'K') {
                    dateTimeFormatterBuilder.w(length2);
                } else if (charAt != 'M') {
                    if (charAt == 'S') {
                        dateTimeFormatterBuilder.t(length2, length2);
                    } else if (charAt == 'a') {
                        dateTimeFormatterBuilder.u();
                    } else if (charAt == 'h') {
                        dateTimeFormatterBuilder.h(length2);
                    } else if (charAt == 'k') {
                        dateTimeFormatterBuilder.g(length2);
                    } else if (charAt == 'm') {
                        dateTimeFormatterBuilder.A(length2);
                    } else if (charAt == 's') {
                        dateTimeFormatterBuilder.F(length2);
                    } else if (charAt == 'G') {
                        dateTimeFormatterBuilder.o();
                    } else if (charAt != 'H') {
                        if (charAt != 'Y') {
                            if (charAt != 'Z') {
                                if (charAt == 'd') {
                                    dateTimeFormatterBuilder.i(length2);
                                } else if (charAt != 'e') {
                                    switch (charAt) {
                                        case 'C':
                                            dateTimeFormatterBuilder.f(length2, length2);
                                            continue;
                                        case 'D':
                                            dateTimeFormatterBuilder.m(length2);
                                            continue;
                                        case 'E':
                                            if (length2 < 4) {
                                                dateTimeFormatterBuilder.k();
                                                break;
                                            } else {
                                                dateTimeFormatterBuilder.l();
                                                continue;
                                            }
                                        default:
                                            switch (charAt) {
                                                case 'w':
                                                    dateTimeFormatterBuilder.R(length2);
                                                    continue;
                                                case 'x':
                                                case 'y':
                                                    break;
                                                case 'z':
                                                    if (length2 < 4) {
                                                        dateTimeFormatterBuilder.N((Map<String, DateTimeZone>) null);
                                                        break;
                                                    } else {
                                                        dateTimeFormatterBuilder.K();
                                                        continue;
                                                        continue;
                                                    }
                                                default:
                                                    throw new IllegalArgumentException("Illegal pattern component: " + e11);
                                            }
                                    }
                                } else {
                                    dateTimeFormatterBuilder.j(length2);
                                }
                            } else if (length2 == 1) {
                                dateTimeFormatterBuilder.L((String) null, "Z", false, 2, 2);
                            } else if (length2 == 2) {
                                dateTimeFormatterBuilder.L((String) null, "Z", true, 2, 2);
                            } else {
                                dateTimeFormatterBuilder.J();
                            }
                        }
                        if (length2 == 2) {
                            if (i12 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                z11 = !c(e(str, iArr));
                                iArr[0] = iArr[0] - 1;
                            } else {
                                z11 = true;
                            }
                            if (charAt != 'x') {
                                dateTimeFormatterBuilder.P(new DateTime().getYear() - 30, z11);
                            } else {
                                dateTimeFormatterBuilder.O(new DateTime().getWeekyear() - 30, z11);
                            }
                        } else {
                            int i13 = 9;
                            if (i12 + 1 < length) {
                                iArr[0] = iArr[0] + 1;
                                if (c(e(str, iArr))) {
                                    i13 = length2;
                                }
                                iArr[0] = iArr[0] - 1;
                            }
                            if (charAt == 'Y') {
                                dateTimeFormatterBuilder.U(length2, i13);
                            } else if (charAt == 'x') {
                                dateTimeFormatterBuilder.S(length2, i13);
                            } else if (charAt == 'y') {
                                dateTimeFormatterBuilder.T(length2, i13);
                            }
                        }
                    } else {
                        dateTimeFormatterBuilder.v(length2);
                    }
                } else if (length2 < 3) {
                    dateTimeFormatterBuilder.B(length2);
                } else if (length2 >= 4) {
                    dateTimeFormatterBuilder.D();
                } else {
                    dateTimeFormatterBuilder.C();
                }
                i11 = i12 + 1;
            } else {
                return;
            }
        }
    }

    public static String e(String str, int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i11);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb2.append(charAt);
            while (true) {
                int i12 = i11 + 1;
                if (i12 >= length || str.charAt(i12) != charAt) {
                    break;
                }
                sb2.append(charAt);
                i11 = i12;
            }
        } else {
            sb2.append('\'');
            boolean z11 = false;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                char charAt2 = str.charAt(i11);
                if (charAt2 == '\'') {
                    int i13 = i11 + 1;
                    if (i13 >= length || str.charAt(i13) != '\'') {
                        z11 = !z11;
                    } else {
                        sb2.append(charAt2);
                        i11 = i13;
                    }
                } else if (z11 || ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < 'a' || charAt2 > 'z'))) {
                    sb2.append(charAt2);
                }
                i11++;
            }
            i11--;
        }
        iArr[0] = i11;
        return sb2.toString();
    }
}
