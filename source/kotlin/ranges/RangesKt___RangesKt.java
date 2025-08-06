package kotlin.ranges;

import kotlin.ranges.f;

class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static float c(float f11, float f12) {
        return f11 < f12 ? f12 : f11;
    }

    public static int d(int i11, int i12) {
        return i11 < i12 ? i12 : i11;
    }

    public static long e(long j11, long j12) {
        return j11 < j12 ? j12 : j11;
    }

    public static float f(float f11, float f12) {
        return f11 > f12 ? f12 : f11;
    }

    public static int g(int i11, int i12) {
        return i11 > i12 ? i12 : i11;
    }

    public static long h(long j11, long j12) {
        return j11 > j12 ? j12 : j11;
    }

    public static float i(float f11, float f12, float f13) {
        if (f12 > f13) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f13 + " is less than minimum " + f12 + '.');
        } else if (f11 < f12) {
            return f12;
        } else {
            return f11 > f13 ? f13 : f11;
        }
    }

    public static int j(int i11, int i12, int i13) {
        if (i12 > i13) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i13 + " is less than minimum " + i12 + '.');
        } else if (i11 < i12) {
            return i12;
        } else {
            return i11 > i13 ? i13 : i11;
        }
    }

    public static long k(long j11, long j12, long j13) {
        if (j12 > j13) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j13 + " is less than minimum " + j12 + '.');
        } else if (j11 < j12) {
            return j12;
        } else {
            return j11 > j13 ? j13 : j11;
        }
    }

    public static f l(int i11, int i12) {
        return f.f56836e.a(i11, i12, -1);
    }

    public static i m(long j11, int i11) {
        return i.f56846e.a(j11, (long) i11, -1);
    }

    public static f n(f fVar, int i11) {
        RangesKt__RangesKt.a(i11 > 0, Integer.valueOf(i11));
        f.a aVar = f.f56836e;
        int a11 = fVar.a();
        int b11 = fVar.b();
        if (fVar.c() <= 0) {
            i11 = -i11;
        }
        return aVar.a(a11, b11, i11);
    }

    public static h o(int i11, int i12) {
        if (i12 <= Integer.MIN_VALUE) {
            return h.f56844f.a();
        }
        return new h(i11, i12 - 1);
    }
}
