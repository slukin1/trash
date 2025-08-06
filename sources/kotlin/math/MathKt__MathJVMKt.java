package kotlin.math;

class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static int a(double d11) {
        if (Double.isNaN(d11)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d11 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        } else {
            if (d11 < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d11);
        }
    }

    public static int b(float f11) {
        if (!Float.isNaN(f11)) {
            return Math.round(f11);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static long c(double d11) {
        if (!Double.isNaN(d11)) {
            return Math.round(d11);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}
