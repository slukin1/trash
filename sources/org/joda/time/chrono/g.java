package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.ImpreciseDateTimeField;
import org.joda.time.field.e;

public class g extends ImpreciseDateTimeField {

    /* renamed from: d  reason: collision with root package name */
    public final BasicChronology f23087d;

    public g(BasicChronology basicChronology) {
        super(DateTimeFieldType.year(), basicChronology.getAverageMillisPerYear());
        this.f23087d = basicChronology;
    }

    public long add(long j11, int i11) {
        if (i11 == 0) {
            return j11;
        }
        return set(j11, e.d(get(j11), i11));
    }

    public long addWrapField(long j11, int i11) {
        if (i11 == 0) {
            return j11;
        }
        return set(j11, e.c(this.f23087d.getYear(j11), i11, this.f23087d.getMinYear(), this.f23087d.getMaxYear()));
    }

    public int get(long j11) {
        return this.f23087d.getYear(j11);
    }

    public long getDifferenceAsLong(long j11, long j12) {
        if (j11 < j12) {
            return -this.f23087d.getYearDifference(j12, j11);
        }
        return this.f23087d.getYearDifference(j11, j12);
    }

    public int getLeapAmount(long j11) {
        return this.f23087d.isLeapYear(get(j11)) ? 1 : 0;
    }

    public DurationField getLeapDurationField() {
        return this.f23087d.days();
    }

    public int getMaximumValue() {
        return this.f23087d.getMaxYear();
    }

    public int getMinimumValue() {
        return this.f23087d.getMinYear();
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLeap(long j11) {
        return this.f23087d.isLeapYear(get(j11));
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j11) {
        return j11 - roundFloor(j11);
    }

    public long roundCeiling(long j11) {
        int i11 = get(j11);
        return j11 != this.f23087d.getYearMillis(i11) ? this.f23087d.getYearMillis(i11 + 1) : j11;
    }

    public long roundFloor(long j11) {
        return this.f23087d.getYearMillis(get(j11));
    }

    public long set(long j11, int i11) {
        e.m(this, i11, this.f23087d.getMinYear(), this.f23087d.getMaxYear());
        return this.f23087d.setYear(j11, i11);
    }

    public long add(long j11, long j12) {
        return add(j11, e.l(j12));
    }
}
