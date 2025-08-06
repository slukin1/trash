package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.h;

public final class a extends h {

    /* renamed from: d  reason: collision with root package name */
    public final BasicChronology f23079d;

    public a(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.dayOfMonth(), durationField);
        this.f23079d = basicChronology;
    }

    public int b(long j11, int i11) {
        return this.f23079d.getDaysInMonthMaxForSet(j11, i11);
    }

    public int get(long j11) {
        return this.f23079d.getDayOfMonth(j11);
    }

    public int getMaximumValue() {
        return this.f23079d.getDaysInMonthMax();
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.f23079d.months();
    }

    public boolean isLeap(long j11) {
        return this.f23079d.isLeapDay(j11);
    }

    public int getMaximumValue(long j11) {
        return this.f23079d.getDaysInMonthMax(j11);
    }

    public int getMaximumValue(org.joda.time.h hVar) {
        if (!hVar.isSupported(DateTimeFieldType.monthOfYear())) {
            return getMaximumValue();
        }
        int i11 = hVar.get(DateTimeFieldType.monthOfYear());
        if (!hVar.isSupported(DateTimeFieldType.year())) {
            return this.f23079d.getDaysInMonthMax(i11);
        }
        return this.f23079d.getDaysInYearMonth(hVar.get(DateTimeFieldType.year()), i11);
    }

    public int getMaximumValue(org.joda.time.h hVar, int[] iArr) {
        int size = hVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (hVar.getFieldType(i11) == DateTimeFieldType.monthOfYear()) {
                int i12 = iArr[i11];
                for (int i13 = 0; i13 < size; i13++) {
                    if (hVar.getFieldType(i13) == DateTimeFieldType.year()) {
                        return this.f23079d.getDaysInYearMonth(iArr[i13], i12);
                    }
                }
                return this.f23079d.getDaysInMonthMax(i12);
            }
        }
        return getMaximumValue();
    }
}
