package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.h;

public final class b extends h {

    /* renamed from: d  reason: collision with root package name */
    public final BasicChronology f23080d;

    public b(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.dayOfYear(), durationField);
        this.f23080d = basicChronology;
    }

    public int b(long j11, int i11) {
        int daysInYearMax = this.f23080d.getDaysInYearMax() - 1;
        return (i11 > daysInYearMax || i11 < 1) ? getMaximumValue(j11) : daysInYearMax;
    }

    public int get(long j11) {
        return this.f23080d.getDayOfYear(j11);
    }

    public int getMaximumValue() {
        return this.f23080d.getDaysInYearMax();
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.f23080d.years();
    }

    public boolean isLeap(long j11) {
        return this.f23080d.isLeapDay(j11);
    }

    public int getMaximumValue(long j11) {
        return this.f23080d.getDaysInYear(this.f23080d.getYear(j11));
    }

    public int getMaximumValue(org.joda.time.h hVar) {
        if (!hVar.isSupported(DateTimeFieldType.year())) {
            return this.f23080d.getDaysInYearMax();
        }
        return this.f23080d.getDaysInYear(hVar.get(DateTimeFieldType.year()));
    }

    public int getMaximumValue(org.joda.time.h hVar, int[] iArr) {
        int size = hVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (hVar.getFieldType(i11) == DateTimeFieldType.year()) {
                return this.f23080d.getDaysInYear(iArr[i11]);
            }
        }
        return this.f23080d.getDaysInYearMax();
    }
}
