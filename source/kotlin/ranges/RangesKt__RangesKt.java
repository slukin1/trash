package kotlin.ranges;

class RangesKt__RangesKt {
    public static final void a(boolean z11, Number number) {
        if (!z11) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
        }
    }

    public static e<Double> b(double d11, double d12) {
        return new d(d11, d12);
    }
}
