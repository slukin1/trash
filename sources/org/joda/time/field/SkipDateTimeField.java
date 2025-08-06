package org.joda.time.field;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

public final class SkipDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = -8869148464118507846L;
    private final Chronology iChronology;
    private transient int iMinValue;
    private final int iSkip;

    public SkipDateTimeField(Chronology chronology, DateTimeField dateTimeField) {
        this(chronology, dateTimeField, 0);
    }

    private Object readResolve() {
        return getType().getField(this.iChronology);
    }

    public int get(long j11) {
        int i11 = super.get(j11);
        return i11 <= this.iSkip ? i11 - 1 : i11;
    }

    public int getMinimumValue() {
        return this.iMinValue;
    }

    public long set(long j11, int i11) {
        e.m(this, i11, this.iMinValue, getMaximumValue());
        int i12 = this.iSkip;
        if (i11 <= i12) {
            if (i11 != i12) {
                i11++;
            } else {
                throw new IllegalFieldValueException(DateTimeFieldType.year(), (Number) Integer.valueOf(i11), (Number) null, (Number) null);
            }
        }
        return super.set(j11, i11);
    }

    public SkipDateTimeField(Chronology chronology, DateTimeField dateTimeField, int i11) {
        super(dateTimeField);
        this.iChronology = chronology;
        int minimumValue = super.getMinimumValue();
        if (minimumValue < i11) {
            this.iMinValue = minimumValue - 1;
        } else if (minimumValue == i11) {
            this.iMinValue = i11 + 1;
        } else {
            this.iMinValue = minimumValue;
        }
        this.iSkip = i11;
    }
}
