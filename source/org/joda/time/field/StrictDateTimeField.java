package org.joda.time.field;

import org.joda.time.DateTimeField;

public class StrictDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = 3154803964207950910L;

    public StrictDateTimeField(DateTimeField dateTimeField) {
        super(dateTimeField);
    }

    public static DateTimeField getInstance(DateTimeField dateTimeField) {
        if (dateTimeField == null) {
            return null;
        }
        if (dateTimeField instanceof LenientDateTimeField) {
            dateTimeField = ((LenientDateTimeField) dateTimeField).getWrappedField();
        }
        if (!dateTimeField.isLenient()) {
            return dateTimeField;
        }
        return new StrictDateTimeField(dateTimeField);
    }

    public final boolean isLenient() {
        return false;
    }

    public long set(long j11, int i11) {
        e.m(this, i11, getMinimumValue(j11), getMaximumValue(j11));
        return super.set(j11, i11);
    }
}
