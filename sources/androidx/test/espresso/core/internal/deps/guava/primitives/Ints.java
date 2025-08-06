package androidx.test.espresso.core.internal.deps.guava.primitives;

public final class Ints {
    public static int a(long j11) {
        if (j11 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j11 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j11;
    }
}
