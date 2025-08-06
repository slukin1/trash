package a10;

public final class b {
    public static final int a(int i11, int i12, int i13) {
        return e(e(i11, i13) - e(i12, i13), i13);
    }

    public static final long b(long j11, long j12, long j13) {
        return f(f(j11, j13) - f(j12, j13), j13);
    }

    public static final int c(int i11, int i12, int i13) {
        if (i13 > 0) {
            if (i11 >= i12) {
                return i12;
            }
            return i12 - a(i12, i11, i13);
        } else if (i13 < 0) {
            return i11 <= i12 ? i12 : i12 + a(i11, i12, -i13);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    public static final long d(long j11, long j12, long j13) {
        int i11 = (j13 > 0 ? 1 : (j13 == 0 ? 0 : -1));
        if (i11 > 0) {
            if (j11 >= j12) {
                return j12;
            }
            return j12 - b(j12, j11, j13);
        } else if (i11 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (j11 <= j12) {
            return j12;
        } else {
            return j12 + b(j11, j12, -j13);
        }
    }

    public static final int e(int i11, int i12) {
        int i13 = i11 % i12;
        return i13 >= 0 ? i13 : i13 + i12;
    }

    public static final long f(long j11, long j12) {
        long j13 = j11 % j12;
        return j13 >= 0 ? j13 : j13 + j12;
    }
}
