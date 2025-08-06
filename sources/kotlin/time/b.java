package kotlin.time;

import e7.s;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.ranges.k;

public final class b implements Comparable<b> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56931c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final long f56932d = i(0);

    /* renamed from: e  reason: collision with root package name */
    public static final long f56933e = d.j(4611686018427387903L);

    /* renamed from: f  reason: collision with root package name */
    public static final long f56934f = d.j(-4611686018427387903L);

    /* renamed from: b  reason: collision with root package name */
    public final long f56935b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final long a() {
            return b.f56933e;
        }

        public final long b() {
            return b.f56932d;
        }

        public final long c(String str) {
            try {
                return d.p(str, true);
            } catch (IllegalArgumentException e11) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + str + "'.", e11);
            }
        }
    }

    public /* synthetic */ b(long j11) {
        this.f56935b = j11;
    }

    public static final boolean A(long j11) {
        return j11 == f56933e || j11 == f56934f;
    }

    public static final boolean B(long j11) {
        return j11 < 0;
    }

    public static final boolean C(long j11) {
        return j11 > 0;
    }

    public static final long D(long j11, long j12) {
        return E(j11, I(j12));
    }

    public static final long E(long j11, long j12) {
        if (A(j11)) {
            if (x(j12) || (j12 ^ j11) >= 0) {
                return j11;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (A(j12)) {
            return j12;
        } else {
            if ((((int) j11) & 1) == (((int) j12) & 1)) {
                long v11 = v(j11) + v(j12);
                if (z(j11)) {
                    return d.m(v11);
                }
                return d.k(v11);
            } else if (y(j11)) {
                return c(j11, v(j11), v(j12));
            } else {
                return c(j11, v(j12), v(j11));
            }
        }
    }

    public static final String F(long j11) {
        StringBuilder sb2 = new StringBuilder();
        if (B(j11)) {
            sb2.append('-');
        }
        sb2.append("PT");
        long k11 = k(j11);
        long n11 = n(k11);
        int r11 = r(k11);
        int t11 = t(k11);
        int s11 = s(k11);
        if (A(j11)) {
            n11 = 9999999999999L;
        }
        boolean z11 = true;
        boolean z12 = n11 != 0;
        boolean z13 = (t11 == 0 && s11 == 0) ? false : true;
        if (r11 == 0 && (!z13 || !z12)) {
            z11 = false;
        }
        if (z12) {
            sb2.append(n11);
            sb2.append('H');
        }
        if (z11) {
            sb2.append(r11);
            sb2.append('M');
        }
        if (z13 || (!z12 && !z11)) {
            e(j11, sb2, t11, s11, 9, "S", true);
        }
        return sb2.toString();
    }

    public static final long G(long j11, DurationUnit durationUnit) {
        if (j11 == f56933e) {
            return Long.MAX_VALUE;
        }
        if (j11 == f56934f) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.b(v(j11), u(j11), durationUnit);
    }

    public static String H(long j11) {
        if (j11 == 0) {
            return "0s";
        }
        if (j11 == f56933e) {
            return "Infinity";
        }
        if (j11 == f56934f) {
            return "-Infinity";
        }
        boolean B = B(j11);
        StringBuilder sb2 = new StringBuilder();
        if (B) {
            sb2.append('-');
        }
        long k11 = k(j11);
        long m11 = m(k11);
        int l11 = l(k11);
        int r11 = r(k11);
        int t11 = t(k11);
        int s11 = s(k11);
        int i11 = 0;
        boolean z11 = m11 != 0;
        boolean z12 = l11 != 0;
        boolean z13 = r11 != 0;
        boolean z14 = (t11 == 0 && s11 == 0) ? false : true;
        if (z11) {
            sb2.append(m11);
            sb2.append('d');
            i11 = 1;
        }
        if (z12 || (z11 && (z13 || z14))) {
            int i12 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(l11);
            sb2.append('h');
            i11 = i12;
        }
        if (z13 || (z14 && (z12 || z11))) {
            int i13 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(r11);
            sb2.append('m');
            i11 = i13;
        }
        if (z14) {
            int i14 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            if (t11 != 0 || z11 || z12 || z13) {
                e(j11, sb2, t11, s11, 9, s.f70071a, false);
            } else if (s11 >= 1000000) {
                e(j11, sb2, s11 / 1000000, s11 % 1000000, 6, "ms", false);
            } else if (s11 >= 1000) {
                e(j11, sb2, s11 / 1000, s11 % 1000, 3, "us", false);
            } else {
                sb2.append(s11);
                sb2.append("ns");
            }
            i11 = i14;
        }
        if (B && i11 > 1) {
            sb2.insert(1, '(').append(')');
        }
        return sb2.toString();
    }

    public static final long I(long j11) {
        return d.i(-v(j11), ((int) j11) & 1);
    }

    public static final long c(long j11, long j12, long j13) {
        long g11 = d.o(j13);
        long j14 = j12 + g11;
        if (!new k(-4611686018426L, 4611686018426L).d(j14)) {
            return d.j(RangesKt___RangesKt.k(j14, -4611686018427387903L, 4611686018427387903L));
        }
        return d.l(d.n(j14) + (j13 - d.n(g11)));
    }

    public static final void e(long j11, StringBuilder sb2, int i11, int i12, int i13, String str, boolean z11) {
        sb2.append(i11);
        if (i12 != 0) {
            sb2.append('.');
            String u02 = StringsKt__StringsKt.u0(String.valueOf(i12), i13, '0');
            int i14 = -1;
            int length = u02.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i15 = length - 1;
                    if (u02.charAt(length) != '0') {
                        i14 = length;
                        break;
                    } else if (i15 < 0) {
                        break;
                    } else {
                        length = i15;
                    }
                }
            }
            int i16 = i14 + 1;
            if (z11 || i16 >= 3) {
                sb2.append(u02, 0, ((i16 + 2) / 3) * 3);
            } else {
                sb2.append(u02, 0, i16);
            }
        }
        sb2.append(str);
    }

    public static final /* synthetic */ b f(long j11) {
        return new b(j11);
    }

    public static int h(long j11, long j12) {
        long j13 = j11 ^ j12;
        if (j13 < 0 || (((int) j13) & 1) == 0) {
            return x.d(j11, j12);
        }
        int i11 = (((int) j11) & 1) - (((int) j12) & 1);
        return B(j11) ? -i11 : i11;
    }

    public static long i(long j11) {
        if (c.a()) {
            if (z(j11)) {
                if (!new k(-4611686018426999999L, 4611686018426999999L).d(v(j11))) {
                    throw new AssertionError(v(j11) + " ns is out of nanoseconds range");
                }
            } else if (!new k(-4611686018427387903L, 4611686018427387903L).d(v(j11))) {
                throw new AssertionError(v(j11) + " ms is out of milliseconds range");
            } else if (new k(-4611686018426L, 4611686018426L).d(v(j11))) {
                throw new AssertionError(v(j11) + " ms is denormalized");
            }
        }
        return j11;
    }

    public static boolean j(long j11, Object obj) {
        return (obj instanceof b) && j11 == ((b) obj).J();
    }

    public static final long k(long j11) {
        return B(j11) ? I(j11) : j11;
    }

    public static final int l(long j11) {
        if (A(j11)) {
            return 0;
        }
        return (int) (n(j11) % ((long) 24));
    }

    public static final long m(long j11) {
        return G(j11, DurationUnit.DAYS);
    }

    public static final long n(long j11) {
        return G(j11, DurationUnit.HOURS);
    }

    public static final long o(long j11) {
        return (!y(j11) || !x(j11)) ? G(j11, DurationUnit.MILLISECONDS) : v(j11);
    }

    public static final long p(long j11) {
        return G(j11, DurationUnit.MINUTES);
    }

    public static final long q(long j11) {
        return G(j11, DurationUnit.SECONDS);
    }

    public static final int r(long j11) {
        if (A(j11)) {
            return 0;
        }
        return (int) (p(j11) % ((long) 60));
    }

    public static final int s(long j11) {
        long j12;
        if (A(j11)) {
            return 0;
        }
        if (y(j11)) {
            j12 = d.n(v(j11) % ((long) 1000));
        } else {
            j12 = v(j11) % ((long) 1000000000);
        }
        return (int) j12;
    }

    public static final int t(long j11) {
        if (A(j11)) {
            return 0;
        }
        return (int) (q(j11) % ((long) 60));
    }

    public static final DurationUnit u(long j11) {
        return z(j11) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    public static final long v(long j11) {
        return j11 >> 1;
    }

    public static int w(long j11) {
        return com.fluttercandies.photo_manager.core.entity.a.a(j11);
    }

    public static final boolean x(long j11) {
        return !A(j11);
    }

    public static final boolean y(long j11) {
        return (((int) j11) & 1) == 1;
    }

    public static final boolean z(long j11) {
        return (((int) j11) & 1) == 0;
    }

    public final /* synthetic */ long J() {
        return this.f56935b;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return g(((b) obj).J());
    }

    public boolean equals(Object obj) {
        return j(this.f56935b, obj);
    }

    public int g(long j11) {
        return h(this.f56935b, j11);
    }

    public int hashCode() {
        return w(this.f56935b);
    }

    public String toString() {
        return H(this.f56935b);
    }
}
