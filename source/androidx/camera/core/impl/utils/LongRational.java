package androidx.camera.core.impl.utils;

final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    public LongRational(long j11, long j12) {
        this.mNumerator = j11;
        this.mDenominator = j12;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public double toDouble() {
        return ((double) this.mNumerator) / ((double) this.mDenominator);
    }

    public String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }

    public LongRational(double d11) {
        this((long) (d11 * 10000.0d), 10000);
    }
}
