package rx.schedulers;

public final class Timestamped<T> {
    private final long timestampMillis;
    private final T value;

    public Timestamped(long j11, T t11) {
        this.value = t11;
        this.timestampMillis = j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Timestamped)) {
            return false;
        }
        Timestamped timestamped = (Timestamped) obj;
        if (this.timestampMillis == timestamped.timestampMillis) {
            T t11 = this.value;
            T t12 = timestamped.value;
            if (t11 == t12) {
                return true;
            }
            if (t11 != null && t11.equals(t12)) {
                return true;
            }
        }
        return false;
    }

    public long getTimestampMillis() {
        return this.timestampMillis;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        long j11 = this.timestampMillis;
        int i11 = (((int) (j11 ^ (j11 >>> 32))) + 31) * 31;
        T t11 = this.value;
        return i11 + (t11 == null ? 0 : t11.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", new Object[]{Long.valueOf(this.timestampMillis), this.value.toString()});
    }
}
