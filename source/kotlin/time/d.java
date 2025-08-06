package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.ranges.c;
import kotlin.ranges.h;
import kotlin.ranges.k;
import kotlin.time.b;

public final class d {
    public static final long i(long j11, int i11) {
        return b.i((j11 << 1) + ((long) i11));
    }

    public static final long j(long j11) {
        return b.i((j11 << 1) + 1);
    }

    public static final long k(long j11) {
        if (new k(-4611686018426L, 4611686018426L).d(j11)) {
            return l(n(j11));
        }
        return j(RangesKt___RangesKt.k(j11, -4611686018427387903L, 4611686018427387903L));
    }

    public static final long l(long j11) {
        return b.i(j11 << 1);
    }

    public static final long m(long j11) {
        if (new k(-4611686018426999999L, 4611686018426999999L).d(j11)) {
            return l(j11);
        }
        return j(o(j11));
    }

    public static final long n(long j11) {
        return j11 * ((long) 1000000);
    }

    public static final long o(long j11) {
        return j11 / ((long) 1000000);
    }

    public static final long p(String str, boolean z11) {
        long E;
        boolean z12;
        String str2 = str;
        int length = str.length();
        if (length != 0) {
            b.a aVar = b.f56931c;
            long b11 = aVar.b();
            char charAt = str2.charAt(0);
            boolean z13 = true;
            int i11 = (charAt == '+' || charAt == '-') ? 1 : 0;
            boolean z14 = i11 > 0;
            int i12 = 2;
            boolean z15 = z14 && StringsKt__StringsKt.Q0(str2, '-', false, 2, (Object) null);
            if (length > i11) {
                String str3 = "No components";
                if (str2.charAt(i11) == 'P') {
                    int i13 = i11 + 1;
                    if (i13 != length) {
                        boolean z16 = false;
                        DurationUnit durationUnit = null;
                        while (i13 < length) {
                            if (str2.charAt(i13) != 'T') {
                                int i14 = i13;
                                while (i14 < str.length()) {
                                    char charAt2 = str2.charAt(i14);
                                    if (!(new c('0', '9').d(charAt2) || StringsKt__StringsKt.Q("+-.", charAt2, false, i12, (Object) null))) {
                                        break;
                                    }
                                    i14++;
                                }
                                String substring = str2.substring(i13, i14);
                                if (!(substring.length() == 0)) {
                                    int length2 = i13 + substring.length();
                                    if (length2 < 0 || length2 > StringsKt__StringsKt.a0(str)) {
                                        throw new IllegalArgumentException("Missing unit for value " + substring);
                                    }
                                    char charAt3 = str2.charAt(length2);
                                    i13 = length2 + 1;
                                    DurationUnit d11 = DurationUnitKt__DurationUnitKt.d(charAt3, z16);
                                    if (durationUnit == null || durationUnit.compareTo(d11) > 0) {
                                        int f02 = StringsKt__StringsKt.f0(substring, '.', 0, false, 6, (Object) null);
                                        if (d11 != DurationUnit.SECONDS || f02 <= 0) {
                                            z12 = z16;
                                            b11 = b.E(b11, t(q(substring), d11));
                                        } else {
                                            z12 = z16;
                                            b11 = b.E(b.E(b11, t(q(substring.substring(0, f02)), d11)), r(Double.parseDouble(substring.substring(f02)), d11));
                                        }
                                        z16 = z12;
                                        durationUnit = d11;
                                        i12 = 2;
                                        z13 = true;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected order of duration components");
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else if (z16 || (i13 = i13 + 1) == length) {
                                throw new IllegalArgumentException();
                            } else {
                                z16 = z13;
                            }
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (!z11) {
                    String str4 = "Unexpected order of duration components";
                    String str5 = str3;
                    if (StringsKt__StringsJVMKt.A(str, i11, "Infinity", 0, Math.max(length - i11, 8), true)) {
                        b11 = aVar.a();
                    } else {
                        boolean z17 = !z14;
                        if (z14 && str2.charAt(i11) == '(' && StringsKt___StringsKt.n1(str) == ')') {
                            i11++;
                            length--;
                            if (i11 != length) {
                                z17 = true;
                            } else {
                                throw new IllegalArgumentException(str5);
                            }
                        }
                        DurationUnit durationUnit2 = null;
                        boolean z18 = false;
                        while (i11 < length) {
                            if (z18 && z17) {
                                while (i11 < str.length()) {
                                    if (!(str2.charAt(i11) == ' ')) {
                                        break;
                                    }
                                    i11++;
                                }
                            }
                            int i15 = i11;
                            while (true) {
                                if (i15 >= str.length()) {
                                    break;
                                }
                                char charAt4 = str2.charAt(i15);
                                if (!(new c('0', '9').d(charAt4) || charAt4 == '.')) {
                                    break;
                                }
                                i15++;
                            }
                            String substring2 = str2.substring(i11, i15);
                            if (!(substring2.length() == 0)) {
                                int length3 = i11 + substring2.length();
                                int i16 = length3;
                                while (i16 < str.length()) {
                                    if (!new c('a', 'z').d(str2.charAt(i16))) {
                                        break;
                                    }
                                    i16++;
                                }
                                String substring3 = str2.substring(length3, i16);
                                i11 = length3 + substring3.length();
                                DurationUnit e11 = DurationUnitKt__DurationUnitKt.e(substring3);
                                if (durationUnit2 == null || durationUnit2.compareTo(e11) > 0) {
                                    int f03 = StringsKt__StringsKt.f0(substring2, '.', 0, false, 6, (Object) null);
                                    if (f03 > 0) {
                                        E = b.E(b.E(b11, t(Long.parseLong(substring2.substring(0, f03)), e11)), r(Double.parseDouble(substring2.substring(f03)), e11));
                                        if (i11 < length) {
                                            throw new IllegalArgumentException("Fractional component must be last");
                                        }
                                    } else {
                                        E = b.E(b11, t(Long.parseLong(substring2), e11));
                                    }
                                    durationUnit2 = e11;
                                    z18 = true;
                                } else {
                                    throw new IllegalArgumentException(str4);
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException();
                }
                return z15 ? b.I(b11) : b11;
            }
            throw new IllegalArgumentException("No components");
        }
        throw new IllegalArgumentException("The string is empty");
    }

    public static final long q(String str) {
        boolean z11;
        int length = str.length();
        int i11 = (length <= 0 || !StringsKt__StringsKt.Q("+-", str.charAt(0), false, 2, (Object) null)) ? 0 : 1;
        if (length - i11 > 16) {
            h hVar = new h(i11, StringsKt__StringsKt.a0(str));
            if (!(hVar instanceof Collection) || !((Collection) hVar).isEmpty()) {
                Iterator it2 = hVar.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!new c('0', '9').d(str.charAt(((IntIterator) it2).a()))) {
                        z11 = false;
                        break;
                    }
                }
            }
            z11 = true;
            if (z11) {
                return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
        }
        if (StringsKt__StringsJVMKt.M(str, "+", false, 2, (Object) null)) {
            str = StringsKt___StringsKt.l1(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final long r(double d11, DurationUnit durationUnit) {
        double a11 = DurationUnitKt__DurationUnitJvmKt.a(d11, durationUnit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(a11)) {
            long c11 = MathKt__MathJVMKt.c(a11);
            if (new k(-4611686018426999999L, 4611686018426999999L).d(c11)) {
                return l(c11);
            }
            return k(MathKt__MathJVMKt.c(DurationUnitKt__DurationUnitJvmKt.a(d11, durationUnit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long s(int i11, DurationUnit durationUnit) {
        if (durationUnit.compareTo(DurationUnit.SECONDS) <= 0) {
            return l(DurationUnitKt__DurationUnitJvmKt.c((long) i11, durationUnit, DurationUnit.NANOSECONDS));
        }
        return t((long) i11, durationUnit);
    }

    public static final long t(long j11, DurationUnit durationUnit) {
        DurationUnit durationUnit2 = DurationUnit.NANOSECONDS;
        long c11 = DurationUnitKt__DurationUnitJvmKt.c(4611686018426999999L, durationUnit2, durationUnit);
        if (new k(-c11, c11).d(j11)) {
            return l(DurationUnitKt__DurationUnitJvmKt.c(j11, durationUnit, durationUnit2));
        }
        return j(RangesKt___RangesKt.k(DurationUnitKt__DurationUnitJvmKt.b(j11, durationUnit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }
}
