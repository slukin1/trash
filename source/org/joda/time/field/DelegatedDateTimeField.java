package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.h;

public class DelegatedDateTimeField extends DateTimeField implements Serializable {
    private static final long serialVersionUID = -4730164440214502503L;
    private final DateTimeField iField;
    private final DurationField iRangeDurationField;
    private final DateTimeFieldType iType;

    public DelegatedDateTimeField(DateTimeField dateTimeField) {
        this(dateTimeField, (DateTimeFieldType) null);
    }

    public long add(long j11, int i11) {
        return this.iField.add(j11, i11);
    }

    public long addWrapField(long j11, int i11) {
        return this.iField.addWrapField(j11, i11);
    }

    public int[] addWrapPartial(h hVar, int i11, int[] iArr, int i12) {
        return this.iField.addWrapPartial(hVar, i11, iArr, i12);
    }

    public int get(long j11) {
        return this.iField.get(j11);
    }

    public String getAsShortText(long j11, Locale locale) {
        return this.iField.getAsShortText(j11, locale);
    }

    public String getAsText(long j11, Locale locale) {
        return this.iField.getAsText(j11, locale);
    }

    public int getDifference(long j11, long j12) {
        return this.iField.getDifference(j11, j12);
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return this.iField.getDifferenceAsLong(j11, j12);
    }

    public DurationField getDurationField() {
        return this.iField.getDurationField();
    }

    public int getLeapAmount(long j11) {
        return this.iField.getLeapAmount(j11);
    }

    public DurationField getLeapDurationField() {
        return this.iField.getLeapDurationField();
    }

    public int getMaximumShortTextLength(Locale locale) {
        return this.iField.getMaximumShortTextLength(locale);
    }

    public int getMaximumTextLength(Locale locale) {
        return this.iField.getMaximumTextLength(locale);
    }

    public int getMaximumValue() {
        return this.iField.getMaximumValue();
    }

    public int getMinimumValue() {
        return this.iField.getMinimumValue();
    }

    public String getName() {
        return this.iType.getName();
    }

    public DurationField getRangeDurationField() {
        DurationField durationField = this.iRangeDurationField;
        if (durationField != null) {
            return durationField;
        }
        return this.iField.getRangeDurationField();
    }

    public DateTimeFieldType getType() {
        return this.iType;
    }

    public final DateTimeField getWrappedField() {
        return this.iField;
    }

    public boolean isLeap(long j11) {
        return this.iField.isLeap(j11);
    }

    public boolean isLenient() {
        return this.iField.isLenient();
    }

    public boolean isSupported() {
        return this.iField.isSupported();
    }

    public long remainder(long j11) {
        return this.iField.remainder(j11);
    }

    public long roundCeiling(long j11) {
        return this.iField.roundCeiling(j11);
    }

    public long roundFloor(long j11) {
        return this.iField.roundFloor(j11);
    }

    public long roundHalfCeiling(long j11) {
        return this.iField.roundHalfCeiling(j11);
    }

    public long roundHalfEven(long j11) {
        return this.iField.roundHalfEven(j11);
    }

    public long roundHalfFloor(long j11) {
        return this.iField.roundHalfFloor(j11);
    }

    public long set(long j11, int i11) {
        return this.iField.set(j11, i11);
    }

    public String toString() {
        return "DateTimeField[" + getName() + ']';
    }

    public DelegatedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        this(dateTimeField, (DurationField) null, dateTimeFieldType);
    }

    public long add(long j11, long j12) {
        return this.iField.add(j11, j12);
    }

    public int[] addWrapField(h hVar, int i11, int[] iArr, int i12) {
        return this.iField.addWrapField(hVar, i11, iArr, i12);
    }

    public String getAsShortText(long j11) {
        return this.iField.getAsShortText(j11);
    }

    public String getAsText(long j11) {
        return this.iField.getAsText(j11);
    }

    public int getMaximumValue(long j11) {
        return this.iField.getMaximumValue(j11);
    }

    public int getMinimumValue(long j11) {
        return this.iField.getMinimumValue(j11);
    }

    public long set(long j11, String str, Locale locale) {
        return this.iField.set(j11, str, locale);
    }

    public DelegatedDateTimeField(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType) {
        if (dateTimeField != null) {
            this.iField = dateTimeField;
            this.iRangeDurationField = durationField;
            this.iType = dateTimeFieldType == null ? dateTimeField.getType() : dateTimeFieldType;
            return;
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public int[] add(h hVar, int i11, int[] iArr, int i12) {
        return this.iField.add(hVar, i11, iArr, i12);
    }

    public String getAsShortText(h hVar, int i11, Locale locale) {
        return this.iField.getAsShortText(hVar, i11, locale);
    }

    public String getAsText(h hVar, int i11, Locale locale) {
        return this.iField.getAsText(hVar, i11, locale);
    }

    public int getMaximumValue(h hVar) {
        return this.iField.getMaximumValue(hVar);
    }

    public int getMinimumValue(h hVar) {
        return this.iField.getMinimumValue(hVar);
    }

    public long set(long j11, String str) {
        return this.iField.set(j11, str);
    }

    public String getAsShortText(h hVar, Locale locale) {
        return this.iField.getAsShortText(hVar, locale);
    }

    public String getAsText(h hVar, Locale locale) {
        return this.iField.getAsText(hVar, locale);
    }

    public int getMaximumValue(h hVar, int[] iArr) {
        return this.iField.getMaximumValue(hVar, iArr);
    }

    public int getMinimumValue(h hVar, int[] iArr) {
        return this.iField.getMinimumValue(hVar, iArr);
    }

    public int[] set(h hVar, int i11, int[] iArr, int i12) {
        return this.iField.set(hVar, i11, iArr, i12);
    }

    public String getAsShortText(int i11, Locale locale) {
        return this.iField.getAsShortText(i11, locale);
    }

    public String getAsText(int i11, Locale locale) {
        return this.iField.getAsText(i11, locale);
    }

    public int[] set(h hVar, int i11, int[] iArr, String str, Locale locale) {
        return this.iField.set(hVar, i11, iArr, str, locale);
    }
}
