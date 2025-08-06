package rx.internal.util.unsafe;

public final class Pow2 {
    private Pow2() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean isPowerOfTwo(int i11) {
        return (i11 & (i11 + -1)) == 0;
    }

    public static int roundToPowerOfTwo(int i11) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i11 - 1));
    }
}
