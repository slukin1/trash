package kotlinx.coroutines.internal;

public final /* synthetic */ class f0 {
    public static final int a(String str, int i11, int i12, int i13) {
        return (int) d0.c(str, (long) i11, (long) i12, (long) i13);
    }

    public static final long b(String str, long j11, long j12, long j13) {
        String d11 = d0.d(str);
        if (d11 == null) {
            return j11;
        }
        Long o11 = StringsKt__StringNumberConversionsKt.o(d11);
        if (o11 != null) {
            long longValue = o11.longValue();
            boolean z11 = false;
            if (j12 <= longValue && longValue <= j13) {
                z11 = true;
            }
            if (z11) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j12 + ".." + j13 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d11 + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String d11 = d0.d(str);
        return d11 == null ? str2 : d11;
    }

    public static final boolean d(String str, boolean z11) {
        String d11 = d0.d(str);
        return d11 != null ? Boolean.parseBoolean(d11) : z11;
    }

    public static /* synthetic */ int e(String str, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i12 = 1;
        }
        if ((i14 & 8) != 0) {
            i13 = Integer.MAX_VALUE;
        }
        return d0.b(str, i11, i12, i13);
    }

    public static /* synthetic */ long f(String str, long j11, long j12, long j13, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j12 = 1;
        }
        long j14 = j12;
        if ((i11 & 8) != 0) {
            j13 = Long.MAX_VALUE;
        }
        return d0.c(str, j11, j14, j13);
    }
}
