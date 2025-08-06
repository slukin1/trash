package org.joda.time.field;

import org.joda.time.DurationFieldType;

public class PreciseDurationField extends BaseDurationField {
    private static final long serialVersionUID = -8346152187724495365L;
    private final long iUnitMillis;

    public PreciseDurationField(DurationFieldType durationFieldType, long j11) {
        super(durationFieldType);
        this.iUnitMillis = j11;
    }

    public long add(long j11, int i11) {
        return e.e(j11, ((long) i11) * this.iUnitMillis);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreciseDurationField)) {
            return false;
        }
        PreciseDurationField preciseDurationField = (PreciseDurationField) obj;
        if (getType() == preciseDurationField.getType() && this.iUnitMillis == preciseDurationField.iUnitMillis) {
            return true;
        }
        return false;
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return e.k(j11, j12) / this.iUnitMillis;
    }

    public long getMillis(int i11, long j11) {
        return ((long) i11) * this.iUnitMillis;
    }

    public final long getUnitMillis() {
        return this.iUnitMillis;
    }

    public long getValueAsLong(long j11, long j12) {
        return j11 / this.iUnitMillis;
    }

    public int hashCode() {
        long j11 = this.iUnitMillis;
        return ((int) (j11 ^ (j11 >>> 32))) + getType().hashCode();
    }

    public final boolean isPrecise() {
        return true;
    }

    public long getMillis(long j11, long j12) {
        return e.i(j11, this.iUnitMillis);
    }

    public long add(long j11, long j12) {
        return e.e(j11, e.i(j12, this.iUnitMillis));
    }
}
