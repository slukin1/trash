package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class ScaledDurationField extends DecoratedDurationField {
    private static final long serialVersionUID = -3205227092378684157L;
    private final int iScalar;

    public ScaledDurationField(DurationField durationField, DurationFieldType durationFieldType, int i11) {
        super(durationField, durationFieldType);
        if (i11 == 0 || i11 == 1) {
            throw new IllegalArgumentException("The scalar must not be 0 or 1");
        }
        this.iScalar = i11;
    }

    public long add(long j11, int i11) {
        return getWrappedField().add(j11, ((long) i11) * ((long) this.iScalar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaledDurationField)) {
            return false;
        }
        ScaledDurationField scaledDurationField = (ScaledDurationField) obj;
        if (getWrappedField().equals(scaledDurationField.getWrappedField()) && getType() == scaledDurationField.getType() && this.iScalar == scaledDurationField.iScalar) {
            return true;
        }
        return false;
    }

    public int getDifference(long j11, long j12) {
        return getWrappedField().getDifference(j11, j12) / this.iScalar;
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return getWrappedField().getDifferenceAsLong(j11, j12) / ((long) this.iScalar);
    }

    public long getMillis(int i11) {
        return getWrappedField().getMillis(((long) i11) * ((long) this.iScalar));
    }

    public int getScalar() {
        return this.iScalar;
    }

    public long getUnitMillis() {
        return getWrappedField().getUnitMillis() * ((long) this.iScalar);
    }

    public int getValue(long j11) {
        return getWrappedField().getValue(j11) / this.iScalar;
    }

    public long getValueAsLong(long j11) {
        return getWrappedField().getValueAsLong(j11) / ((long) this.iScalar);
    }

    public int hashCode() {
        long j11 = (long) this.iScalar;
        return ((int) (j11 ^ (j11 >>> 32))) + getType().hashCode() + getWrappedField().hashCode();
    }

    public int getValue(long j11, long j12) {
        return getWrappedField().getValue(j11, j12) / this.iScalar;
    }

    public long getValueAsLong(long j11, long j12) {
        return getWrappedField().getValueAsLong(j11, j12) / ((long) this.iScalar);
    }

    public long add(long j11, long j12) {
        return getWrappedField().add(j11, e.h(j12, this.iScalar));
    }

    public long getMillis(long j11) {
        return getWrappedField().getMillis(e.h(j11, this.iScalar));
    }

    public long getMillis(int i11, long j11) {
        return getWrappedField().getMillis(((long) i11) * ((long) this.iScalar), j11);
    }

    public long getMillis(long j11, long j12) {
        return getWrappedField().getMillis(e.h(j11, this.iScalar), j12);
    }
}
