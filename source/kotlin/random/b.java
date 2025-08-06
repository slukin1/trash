package kotlin.random;

public final class b {
    public static final String a(Object obj, Object obj2) {
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void b(double d11, double d12) {
        if (!(d12 > d11)) {
            throw new IllegalArgumentException(a(Double.valueOf(d11), Double.valueOf(d12)).toString());
        }
    }

    public static final void c(int i11, int i12) {
        if (!(i12 > i11)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i11), Integer.valueOf(i12)).toString());
        }
    }

    public static final void d(long j11, long j12) {
        if (!(j12 > j11)) {
            throw new IllegalArgumentException(a(Long.valueOf(j11), Long.valueOf(j12)).toString());
        }
    }

    public static final int e(int i11) {
        return 31 - Integer.numberOfLeadingZeros(i11);
    }

    public static final int f(int i11, int i12) {
        return (i11 >>> (32 - i12)) & ((-i12) >> 31);
    }
}
