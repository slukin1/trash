package org.joda.time.field;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;

public final class SkipUndoDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = -5875876968979L;
    private final Chronology iChronology;
    private transient int iMinValue;
    private final int iSkip;

    public SkipUndoDateTimeField(Chronology chronology, DateTimeField dateTimeField) {
        this(chronology, dateTimeField, 0);
    }

    private Object readResolve() {
        return getType().getField(this.iChronology);
    }

    public int get(long j11) {
        int i11 = super.get(j11);
        return i11 < this.iSkip ? i11 + 1 : i11;
    }

    public int getMinimumValue() {
        return this.iMinValue;
    }

    public long set(long j11, int i11) {
        e.m(this, i11, this.iMinValue, getMaximumValue());
        if (i11 <= this.iSkip) {
            i11--;
        }
        return super.set(j11, i11);
    }

    public SkipUndoDateTimeField(Chronology chronology, DateTimeField dateTimeField, int i11) {
        super(dateTimeField);
        this.iChronology = chronology;
        int minimumValue = super.getMinimumValue();
        if (minimumValue < i11) {
            this.iMinValue = minimumValue + 1;
        } else if (minimumValue == i11 + 1) {
            this.iMinValue = i11;
        } else {
            this.iMinValue = minimumValue;
        }
        this.iSkip = i11;
    }
}
