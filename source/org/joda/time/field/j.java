package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.h;

public final class j extends c {
    public j(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeField, dateTimeFieldType);
        if (dateTimeField.getMinimumValue() != 0) {
            throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
        }
    }

    public long add(long j11, int i11) {
        return getWrappedField().add(j11, i11);
    }

    public long addWrapField(long j11, int i11) {
        return getWrappedField().addWrapField(j11, i11);
    }

    public int get(long j11) {
        int i11 = getWrappedField().get(j11);
        return i11 == 0 ? getMaximumValue() : i11;
    }

    public int getDifference(long j11, long j12) {
        return getWrappedField().getDifference(j11, j12);
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return getWrappedField().getDifferenceAsLong(j11, j12);
    }

    public int getLeapAmount(long j11) {
        return getWrappedField().getLeapAmount(j11);
    }

    public DurationField getLeapDurationField() {
        return getWrappedField().getLeapDurationField();
    }

    public int getMaximumValue() {
        return getWrappedField().getMaximumValue() + 1;
    }

    public int getMinimumValue() {
        return 1;
    }

    public int getMinimumValue(long j11) {
        return 1;
    }

    public int getMinimumValue(h hVar) {
        return 1;
    }

    public int getMinimumValue(h hVar, int[] iArr) {
        return 1;
    }

    public boolean isLeap(long j11) {
        return getWrappedField().isLeap(j11);
    }

    public long remainder(long j11) {
        return getWrappedField().remainder(j11);
    }

    public long roundCeiling(long j11) {
        return getWrappedField().roundCeiling(j11);
    }

    public long roundFloor(long j11) {
        return getWrappedField().roundFloor(j11);
    }

    public long roundHalfCeiling(long j11) {
        return getWrappedField().roundHalfCeiling(j11);
    }

    public long roundHalfEven(long j11) {
        return getWrappedField().roundHalfEven(j11);
    }

    public long roundHalfFloor(long j11) {
        return getWrappedField().roundHalfFloor(j11);
    }

    public long set(long j11, int i11) {
        int maximumValue = getMaximumValue();
        e.m(this, i11, 1, maximumValue);
        if (i11 == maximumValue) {
            i11 = 0;
        }
        return getWrappedField().set(j11, i11);
    }

    public long add(long j11, long j12) {
        return getWrappedField().add(j11, j12);
    }

    public int[] addWrapField(h hVar, int i11, int[] iArr, int i12) {
        return getWrappedField().addWrapField(hVar, i11, iArr, i12);
    }

    public int getMaximumValue(long j11) {
        return getWrappedField().getMaximumValue(j11) + 1;
    }

    public int getMaximumValue(h hVar) {
        return getWrappedField().getMaximumValue(hVar) + 1;
    }

    public int getMaximumValue(h hVar, int[] iArr) {
        return getWrappedField().getMaximumValue(hVar, iArr) + 1;
    }
}
