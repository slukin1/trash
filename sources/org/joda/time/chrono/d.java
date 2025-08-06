package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.UnsupportedDurationField;
import org.joda.time.field.b;
import org.joda.time.field.e;

public final class d extends b {

    /* renamed from: b  reason: collision with root package name */
    public final String f23084b;

    public d(String str) {
        super(DateTimeFieldType.era());
        this.f23084b = str;
    }

    public int get(long j11) {
        return 1;
    }

    public String getAsText(int i11, Locale locale) {
        return this.f23084b;
    }

    public DurationField getDurationField() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    public int getMaximumTextLength(Locale locale) {
        return this.f23084b.length();
    }

    public int getMaximumValue() {
        return 1;
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLenient() {
        return false;
    }

    public long roundCeiling(long j11) {
        return Long.MAX_VALUE;
    }

    public long roundFloor(long j11) {
        return Long.MIN_VALUE;
    }

    public long roundHalfCeiling(long j11) {
        return Long.MIN_VALUE;
    }

    public long roundHalfEven(long j11) {
        return Long.MIN_VALUE;
    }

    public long roundHalfFloor(long j11) {
        return Long.MIN_VALUE;
    }

    public long set(long j11, int i11) {
        e.m(this, i11, 1, 1);
        return j11;
    }

    public long set(long j11, String str, Locale locale) {
        if (this.f23084b.equals(str) || "1".equals(str)) {
            return j11;
        }
        throw new IllegalFieldValueException(DateTimeFieldType.era(), str);
    }
}
