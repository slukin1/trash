package rx.schedulers;

public class TimeInterval<T> {
    private final long intervalInMilliseconds;
    private final T value;

    public TimeInterval(long j11, T t11) {
        this.value = t11;
        this.intervalInMilliseconds = j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TimeInterval timeInterval = (TimeInterval) obj;
        if (this.intervalInMilliseconds != timeInterval.intervalInMilliseconds) {
            return false;
        }
        T t11 = this.value;
        if (t11 == null) {
            if (timeInterval.value != null) {
                return false;
            }
        } else if (!t11.equals(timeInterval.value)) {
            return false;
        }
        return true;
    }

    public long getIntervalInMilliseconds() {
        return this.intervalInMilliseconds;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        long j11 = this.intervalInMilliseconds;
        int i11 = (((int) (j11 ^ (j11 >>> 32))) + 31) * 31;
        T t11 = this.value;
        return i11 + (t11 == null ? 0 : t11.hashCode());
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.intervalInMilliseconds + ", value=" + this.value + "]";
    }
}
