package kotlin;

import kotlin.jvm.internal.x;

public final class v {
    public static final int a(int i11, int i12) {
        return x.c(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j11, long j12) {
        return x.d(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE);
    }

    public static final String c(long j11) {
        return d(j11, 10);
    }

    public static final String d(long j11, int i11) {
        if (j11 >= 0) {
            return Long.toString(j11, CharsKt__CharJVMKt.a(i11));
        }
        long j12 = (long) i11;
        long j13 = ((j11 >>> 1) / j12) << 1;
        long j14 = j11 - (j13 * j12);
        if (j14 >= j12) {
            j14 -= j12;
            j13++;
        }
        return Long.toString(j13, CharsKt__CharJVMKt.a(i11)) + Long.toString(j14, CharsKt__CharJVMKt.a(i11));
    }
}
