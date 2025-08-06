package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class DelegatedDurationField extends DurationField implements Serializable {
    private static final long serialVersionUID = -5576443481242007829L;
    private final DurationField iField;
    private final DurationFieldType iType;

    public DelegatedDurationField(DurationField durationField) {
        this(durationField, (DurationFieldType) null);
    }

    public long add(long j11, int i11) {
        return this.iField.add(j11, i11);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DelegatedDurationField) {
            return this.iField.equals(((DelegatedDurationField) obj).iField);
        }
        return false;
    }

    public int getDifference(long j11, long j12) {
        return this.iField.getDifference(j11, j12);
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return this.iField.getDifferenceAsLong(j11, j12);
    }

    public long getMillis(int i11) {
        return this.iField.getMillis(i11);
    }

    public String getName() {
        return this.iType.getName();
    }

    public DurationFieldType getType() {
        return this.iType;
    }

    public long getUnitMillis() {
        return this.iField.getUnitMillis();
    }

    public int getValue(long j11) {
        return this.iField.getValue(j11);
    }

    public long getValueAsLong(long j11) {
        return this.iField.getValueAsLong(j11);
    }

    public final DurationField getWrappedField() {
        return this.iField;
    }

    public int hashCode() {
        return this.iField.hashCode() ^ this.iType.hashCode();
    }

    public boolean isPrecise() {
        return this.iField.isPrecise();
    }

    public boolean isSupported() {
        return this.iField.isSupported();
    }

    public String toString() {
        if (this.iType == null) {
            return this.iField.toString();
        }
        return "DurationField[" + this.iType + ']';
    }

    public DelegatedDurationField(DurationField durationField, DurationFieldType durationFieldType) {
        if (durationField != null) {
            this.iField = durationField;
            this.iType = durationFieldType == null ? durationField.getType() : durationFieldType;
            return;
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public long add(long j11, long j12) {
        return this.iField.add(j11, j12);
    }

    public int compareTo(DurationField durationField) {
        return this.iField.compareTo(durationField);
    }

    public long getMillis(long j11) {
        return this.iField.getMillis(j11);
    }

    public int getValue(long j11, long j12) {
        return this.iField.getValue(j11, j12);
    }

    public long getValueAsLong(long j11, long j12) {
        return this.iField.getValueAsLong(j11, j12);
    }

    public long getMillis(int i11, long j11) {
        return this.iField.getMillis(i11, j11);
    }

    public long getMillis(long j11, long j12) {
        return this.iField.getMillis(j11, j12);
    }
}
