package kotlinx.coroutines;

import kotlinx.coroutines.internal.c0;

public final class c1 {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f56992a = new c0("REMOVED_TASK");

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f56993b = new c0("CLOSED_EMPTY");

    public static final long c(long j11) {
        return j11 / 1000000;
    }

    public static final long d(long j11) {
        if (j11 <= 0) {
            return 0;
        }
        if (j11 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j11;
    }
}
