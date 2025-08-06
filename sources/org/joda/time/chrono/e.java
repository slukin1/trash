package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.h;

public final class e extends h {

    /* renamed from: d  reason: collision with root package name */
    public final BasicChronology f23085d;

    public e(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.weekOfWeekyear(), durationField);
        this.f23085d = basicChronology;
    }

    public int b(long j11, int i11) {
        if (i11 > 52) {
            return getMaximumValue(j11);
        }
        return 52;
    }

    public int get(long j11) {
        return this.f23085d.getWeekOfWeekyear(j11);
    }

    public int getMaximumValue() {
        return 53;
    }

    public int getMaximumValue(long j11) {
        return this.f23085d.getWeeksInYear(this.f23085d.getWeekyear(j11));
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.f23085d.weekyears();
    }

    public long remainder(long j11) {
        return super.remainder(j11 + 259200000);
    }

    public long roundCeiling(long j11) {
        return super.roundCeiling(j11 + 259200000) - 259200000;
    }

    public long roundFloor(long j11) {
        return super.roundFloor(j11 + 259200000) - 259200000;
    }

    public int getMaximumValue(org.joda.time.h hVar) {
        if (!hVar.isSupported(DateTimeFieldType.weekyear())) {
            return 53;
        }
        return this.f23085d.getWeeksInYear(hVar.get(DateTimeFieldType.weekyear()));
    }

    public int getMaximumValue(org.joda.time.h hVar, int[] iArr) {
        int size = hVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (hVar.getFieldType(i11) == DateTimeFieldType.weekyear()) {
                return this.f23085d.getWeeksInYear(iArr[i11]);
            }
        }
        return 53;
    }
}
