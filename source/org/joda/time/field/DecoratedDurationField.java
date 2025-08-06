package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class DecoratedDurationField extends BaseDurationField {
    private static final long serialVersionUID = 8019982251647420015L;
    private final DurationField iField;

    public DecoratedDurationField(DurationField durationField, DurationFieldType durationFieldType) {
        super(durationFieldType);
        if (durationField == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (durationField.isSupported()) {
            this.iField = durationField;
        } else {
            throw new IllegalArgumentException("The field must be supported");
        }
    }

    public long add(long j11, int i11) {
        return this.iField.add(j11, i11);
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return this.iField.getDifferenceAsLong(j11, j12);
    }

    public long getMillis(int i11, long j11) {
        return this.iField.getMillis(i11, j11);
    }

    public long getUnitMillis() {
        return this.iField.getUnitMillis();
    }

    public long getValueAsLong(long j11, long j12) {
        return this.iField.getValueAsLong(j11, j12);
    }

    public final DurationField getWrappedField() {
        return this.iField;
    }

    public boolean isPrecise() {
        return this.iField.isPrecise();
    }

    public long add(long j11, long j12) {
        return this.iField.add(j11, j12);
    }

    public long getMillis(long j11, long j12) {
        return this.iField.getMillis(j11, j12);
    }
}
