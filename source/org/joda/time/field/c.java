package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class c extends b {

    /* renamed from: b  reason: collision with root package name */
    public final DateTimeField f23114b;

    public c(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeFieldType);
        if (dateTimeField == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (dateTimeField.isSupported()) {
            this.f23114b = dateTimeField;
        } else {
            throw new IllegalArgumentException("The field must be supported");
        }
    }

    public int get(long j11) {
        return this.f23114b.get(j11);
    }

    public DurationField getDurationField() {
        return this.f23114b.getDurationField();
    }

    public int getMaximumValue() {
        return this.f23114b.getMaximumValue();
    }

    public int getMinimumValue() {
        return this.f23114b.getMinimumValue();
    }

    public DurationField getRangeDurationField() {
        return this.f23114b.getRangeDurationField();
    }

    public final DateTimeField getWrappedField() {
        return this.f23114b;
    }

    public boolean isLenient() {
        return this.f23114b.isLenient();
    }

    public long set(long j11, int i11) {
        return this.f23114b.set(j11, i11);
    }
}
