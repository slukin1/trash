package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public final class MillisDurationField extends DurationField implements Serializable {
    public static final DurationField INSTANCE = new MillisDurationField();
    private static final long serialVersionUID = 2656707858124633367L;

    private MillisDurationField() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public long add(long j11, int i11) {
        return e.e(j11, (long) i11);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MillisDurationField) || getUnitMillis() != ((MillisDurationField) obj).getUnitMillis()) {
            return false;
        }
        return true;
    }

    public int getDifference(long j11, long j12) {
        return e.l(e.k(j11, j12));
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return e.k(j11, j12);
    }

    public long getMillis(int i11) {
        return (long) i11;
    }

    public long getMillis(int i11, long j11) {
        return (long) i11;
    }

    public long getMillis(long j11) {
        return j11;
    }

    public long getMillis(long j11, long j12) {
        return j11;
    }

    public String getName() {
        return "millis";
    }

    public DurationFieldType getType() {
        return DurationFieldType.millis();
    }

    public final long getUnitMillis() {
        return 1;
    }

    public int getValue(long j11) {
        return e.l(j11);
    }

    public long getValueAsLong(long j11) {
        return j11;
    }

    public long getValueAsLong(long j11, long j12) {
        return j11;
    }

    public int hashCode() {
        return (int) getUnitMillis();
    }

    public final boolean isPrecise() {
        return true;
    }

    public boolean isSupported() {
        return true;
    }

    public String toString() {
        return "DurationField[millis]";
    }

    public long add(long j11, long j12) {
        return e.e(j11, j12);
    }

    public int compareTo(DurationField durationField) {
        int i11 = (getUnitMillis() > durationField.getUnitMillis() ? 1 : (getUnitMillis() == durationField.getUnitMillis() ? 0 : -1));
        if (i11 == 0) {
            return 0;
        }
        return i11 < 0 ? -1 : 1;
    }

    public int getValue(long j11, long j12) {
        return e.l(j11);
    }
}
