package kotlin.time;

class DurationUnitKt__DurationUnitJvmKt {
    public static final double a(double d11, DurationUnit durationUnit, DurationUnit durationUnit2) {
        long convert = durationUnit2.getTimeUnit$kotlin_stdlib().convert(1, durationUnit.getTimeUnit$kotlin_stdlib());
        if (convert > 0) {
            return d11 * ((double) convert);
        }
        return d11 / ((double) durationUnit.getTimeUnit$kotlin_stdlib().convert(1, durationUnit2.getTimeUnit$kotlin_stdlib()));
    }

    public static final long b(long j11, DurationUnit durationUnit, DurationUnit durationUnit2) {
        return durationUnit2.getTimeUnit$kotlin_stdlib().convert(j11, durationUnit.getTimeUnit$kotlin_stdlib());
    }

    public static final long c(long j11, DurationUnit durationUnit, DurationUnit durationUnit2) {
        return durationUnit2.getTimeUnit$kotlin_stdlib().convert(j11, durationUnit.getTimeUnit$kotlin_stdlib());
    }
}
