package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.field.UnsupportedDurationField;
import org.joda.time.field.b;
import org.joda.time.field.e;

public final class j extends b {

    /* renamed from: b  reason: collision with root package name */
    public final BasicChronology f23092b;

    public j(BasicChronology basicChronology) {
        super(DateTimeFieldType.era());
        this.f23092b = basicChronology;
    }

    public int get(long j11) {
        return this.f23092b.getYear(j11) <= 0 ? 0 : 1;
    }

    public String getAsText(int i11, Locale locale) {
        return k.h(locale).g(i11);
    }

    public DurationField getDurationField() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    public int getMaximumTextLength(Locale locale) {
        return k.h(locale).k();
    }

    public int getMaximumValue() {
        return 1;
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLenient() {
        return false;
    }

    public long roundCeiling(long j11) {
        if (get(j11) == 0) {
            return this.f23092b.setYear(0, 1);
        }
        return Long.MAX_VALUE;
    }

    public long roundFloor(long j11) {
        if (get(j11) == 1) {
            return this.f23092b.setYear(0, 1);
        }
        return Long.MIN_VALUE;
    }

    public long roundHalfCeiling(long j11) {
        return roundFloor(j11);
    }

    public long roundHalfEven(long j11) {
        return roundFloor(j11);
    }

    public long roundHalfFloor(long j11) {
        return roundFloor(j11);
    }

    public long set(long j11, int i11) {
        e.m(this, i11, 0, 1);
        if (get(j11) == i11) {
            return j11;
        }
        return this.f23092b.setYear(j11, -this.f23092b.getYear(j11));
    }

    public long set(long j11, String str, Locale locale) {
        return set(j11, k.h(locale).f(str));
    }
}
