package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.h;

public final class i extends h {

    /* renamed from: d  reason: collision with root package name */
    public final BasicChronology f23091d;

    public i(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.dayOfWeek(), durationField);
        this.f23091d = basicChronology;
    }

    public int a(String str, Locale locale) {
        return k.h(locale).c(str);
    }

    public int get(long j11) {
        return this.f23091d.getDayOfWeek(j11);
    }

    public String getAsShortText(int i11, Locale locale) {
        return k.h(locale).d(i11);
    }

    public String getAsText(int i11, Locale locale) {
        return k.h(locale).e(i11);
    }

    public int getMaximumShortTextLength(Locale locale) {
        return k.h(locale).i();
    }

    public int getMaximumTextLength(Locale locale) {
        return k.h(locale).j();
    }

    public int getMaximumValue() {
        return 7;
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.f23091d.weeks();
    }
}
