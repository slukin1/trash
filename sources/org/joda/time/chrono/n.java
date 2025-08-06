package org.joda.time.chrono;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.c;
import org.joda.time.field.e;
import org.joda.time.h;

public class n extends c {

    /* renamed from: c  reason: collision with root package name */
    public static final DateTimeField f23110c = new n();

    public n() {
        super(GregorianChronology.getInstanceUTC().year(), DateTimeFieldType.yearOfEra());
    }

    public long add(long j11, int i11) {
        return getWrappedField().add(j11, i11);
    }

    public long addWrapField(long j11, int i11) {
        return getWrappedField().addWrapField(j11, i11);
    }

    public int get(long j11) {
        int i11 = getWrappedField().get(j11);
        return i11 < 0 ? -i11 : i11;
    }

    public int getDifference(long j11, long j12) {
        return getWrappedField().getDifference(j11, j12);
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return getWrappedField().getDifferenceAsLong(j11, j12);
    }

    public int getMaximumValue() {
        return getWrappedField().getMaximumValue();
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return GregorianChronology.getInstanceUTC().eras();
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

    public long set(long j11, int i11) {
        e.m(this, i11, 0, getMaximumValue());
        if (getWrappedField().get(j11) < 0) {
            i11 = -i11;
        }
        return super.set(j11, i11);
    }

    public long add(long j11, long j12) {
        return getWrappedField().add(j11, j12);
    }

    public int[] addWrapField(h hVar, int i11, int[] iArr, int i12) {
        return getWrappedField().addWrapField(hVar, i11, iArr, i12);
    }
}
