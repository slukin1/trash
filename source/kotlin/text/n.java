package kotlin.text;

public final /* synthetic */ class n {
    public static /* synthetic */ long a(long j11, long j12) {
        if (j12 < 0) {
            return (j11 ^ Long.MIN_VALUE) < (j12 ^ Long.MIN_VALUE) ? 0 : 1;
        }
        if (j11 >= 0) {
            return j11 / j12;
        }
        int i11 = 1;
        long j13 = ((j11 >>> 1) / j12) << 1;
        if (((j11 - (j13 * j12)) ^ Long.MIN_VALUE) < (j12 ^ Long.MIN_VALUE)) {
            i11 = 0;
        }
        return j13 + ((long) i11);
    }
}
