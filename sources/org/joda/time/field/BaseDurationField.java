package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public abstract class BaseDurationField extends DurationField implements Serializable {
    private static final long serialVersionUID = -2554245107589433218L;
    private final DurationFieldType iType;

    public BaseDurationField(DurationFieldType durationFieldType) {
        if (durationFieldType != null) {
            this.iType = durationFieldType;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public int getDifference(long j11, long j12) {
        return e.l(getDifferenceAsLong(j11, j12));
    }

    public long getMillis(int i11) {
        return ((long) i11) * getUnitMillis();
    }

    public final String getName() {
        return this.iType.getName();
    }

    public final DurationFieldType getType() {
        return this.iType;
    }

    public int getValue(long j11) {
        return e.l(getValueAsLong(j11));
    }

    public long getValueAsLong(long j11) {
        return j11 / getUnitMillis();
    }

    public final boolean isSupported() {
        return true;
    }

    public String toString() {
        return "DurationField[" + getName() + ']';
    }

    public int compareTo(DurationField durationField) {
        int i11 = (getUnitMillis() > durationField.getUnitMillis() ? 1 : (getUnitMillis() == durationField.getUnitMillis() ? 0 : -1));
        if (i11 == 0) {
            return 0;
        }
        return i11 < 0 ? -1 : 1;
    }

    public long getMillis(long j11) {
        return e.i(j11, getUnitMillis());
    }

    public int getValue(long j11, long j12) {
        return e.l(getValueAsLong(j11, j12));
    }
}
