package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.Interval;
import org.joda.time.a;
import org.joda.time.f;
import org.joda.time.h;

public abstract class AbstractReadableInstantFieldProperty implements Serializable {
    private static final long serialVersionUID = 1971226328211649661L;

    public int compareTo(f fVar) {
        if (fVar != null) {
            int i11 = get();
            int i12 = fVar.get(getFieldType());
            if (i11 < i12) {
                return -1;
            }
            return i11 > i12 ? 1 : 0;
        }
        throw new IllegalArgumentException("The instant must not be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractReadableInstantFieldProperty)) {
            return false;
        }
        AbstractReadableInstantFieldProperty abstractReadableInstantFieldProperty = (AbstractReadableInstantFieldProperty) obj;
        if (get() != abstractReadableInstantFieldProperty.get() || !getFieldType().equals(abstractReadableInstantFieldProperty.getFieldType()) || !e.a(getChronology(), abstractReadableInstantFieldProperty.getChronology())) {
            return false;
        }
        return true;
    }

    public int get() {
        return getField().get(getMillis());
    }

    public String getAsShortText() {
        return getAsShortText((Locale) null);
    }

    public String getAsString() {
        return Integer.toString(get());
    }

    public String getAsText() {
        return getAsText((Locale) null);
    }

    public Chronology getChronology() {
        throw new UnsupportedOperationException("The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty");
    }

    public int getDifference(f fVar) {
        if (fVar == null) {
            return getField().getDifference(getMillis(), a.b());
        }
        return getField().getDifference(getMillis(), fVar.getMillis());
    }

    public long getDifferenceAsLong(f fVar) {
        if (fVar == null) {
            return getField().getDifferenceAsLong(getMillis(), a.b());
        }
        return getField().getDifferenceAsLong(getMillis(), fVar.getMillis());
    }

    public DurationField getDurationField() {
        return getField().getDurationField();
    }

    public abstract DateTimeField getField();

    public DateTimeFieldType getFieldType() {
        return getField().getType();
    }

    public int getLeapAmount() {
        return getField().getLeapAmount(getMillis());
    }

    public DurationField getLeapDurationField() {
        return getField().getLeapDurationField();
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getField().getMaximumShortTextLength(locale);
    }

    public int getMaximumTextLength(Locale locale) {
        return getField().getMaximumTextLength(locale);
    }

    public int getMaximumValue() {
        return getField().getMaximumValue(getMillis());
    }

    public int getMaximumValueOverall() {
        return getField().getMaximumValue();
    }

    public abstract long getMillis();

    public int getMinimumValue() {
        return getField().getMinimumValue(getMillis());
    }

    public int getMinimumValueOverall() {
        return getField().getMinimumValue();
    }

    public String getName() {
        return getField().getName();
    }

    public DurationField getRangeDurationField() {
        return getField().getRangeDurationField();
    }

    public int hashCode() {
        return (get() * 17) + getFieldType().hashCode() + getChronology().hashCode();
    }

    public boolean isLeap() {
        return getField().isLeap(getMillis());
    }

    public long remainder() {
        return getField().remainder(getMillis());
    }

    public Interval toInterval() {
        DateTimeField field = getField();
        long roundFloor = field.roundFloor(getMillis());
        return new Interval(roundFloor, field.add(roundFloor, 1));
    }

    public String toString() {
        return "Property[" + getName() + "]";
    }

    public String getAsShortText(Locale locale) {
        return getField().getAsShortText(getMillis(), locale);
    }

    public String getAsText(Locale locale) {
        return getField().getAsText(getMillis(), locale);
    }

    public int compareTo(h hVar) {
        if (hVar != null) {
            int i11 = get();
            int i12 = hVar.get(getFieldType());
            if (i11 < i12) {
                return -1;
            }
            return i11 > i12 ? 1 : 0;
        }
        throw new IllegalArgumentException("The partial must not be null");
    }
}
