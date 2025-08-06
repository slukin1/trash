package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.e;
import org.joda.time.format.j;
import org.joda.time.format.n;

public final class Seconds extends BaseSingleFieldPeriod {
    public static final Seconds MAX_VALUE = new Seconds(Integer.MAX_VALUE);
    public static final Seconds MIN_VALUE = new Seconds(Integer.MIN_VALUE);
    public static final Seconds ONE = new Seconds(1);
    private static final n PARSER = j.a().j(PeriodType.seconds());
    public static final Seconds THREE = new Seconds(3);
    public static final Seconds TWO = new Seconds(2);
    public static final Seconds ZERO = new Seconds(0);
    private static final long serialVersionUID = 87525275727380862L;

    private Seconds(int i11) {
        super(i11);
    }

    @FromString
    public static Seconds parseSeconds(String str) {
        if (str == null) {
            return ZERO;
        }
        return seconds(PARSER.h(str).getSeconds());
    }

    private Object readResolve() {
        return seconds(getValue());
    }

    public static Seconds seconds(int i11) {
        if (i11 == Integer.MIN_VALUE) {
            return MIN_VALUE;
        }
        if (i11 == Integer.MAX_VALUE) {
            return MAX_VALUE;
        }
        if (i11 == 0) {
            return ZERO;
        }
        if (i11 == 1) {
            return ONE;
        }
        if (i11 == 2) {
            return TWO;
        }
        if (i11 != 3) {
            return new Seconds(i11);
        }
        return THREE;
    }

    public static Seconds secondsBetween(f fVar, f fVar2) {
        return seconds(BaseSingleFieldPeriod.between(fVar, fVar2, DurationFieldType.seconds()));
    }

    public static Seconds secondsIn(g gVar) {
        if (gVar == null) {
            return ZERO;
        }
        return seconds(BaseSingleFieldPeriod.between((f) gVar.getStart(), (f) gVar.getEnd(), DurationFieldType.seconds()));
    }

    public static Seconds standardSecondsIn(i iVar) {
        return seconds(BaseSingleFieldPeriod.standardPeriodIn(iVar, 1000));
    }

    public Seconds dividedBy(int i11) {
        return i11 == 1 ? this : seconds(getValue() / i11);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.seconds();
    }

    public PeriodType getPeriodType() {
        return PeriodType.seconds();
    }

    public int getSeconds() {
        return getValue();
    }

    public boolean isGreaterThan(Seconds seconds) {
        if (seconds == null) {
            return getValue() > 0;
        }
        if (getValue() > seconds.getValue()) {
            return true;
        }
        return false;
    }

    public boolean isLessThan(Seconds seconds) {
        if (seconds == null) {
            return getValue() < 0;
        }
        if (getValue() < seconds.getValue()) {
            return true;
        }
        return false;
    }

    public Seconds minus(int i11) {
        return plus(e.j(i11));
    }

    public Seconds multipliedBy(int i11) {
        return seconds(e.g(getValue(), i11));
    }

    public Seconds negated() {
        return seconds(e.j(getValue()));
    }

    public Seconds plus(int i11) {
        return i11 == 0 ? this : seconds(e.d(getValue(), i11));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / 86400);
    }

    public Duration toStandardDuration() {
        return new Duration(((long) getValue()) * 1000);
    }

    public Hours toStandardHours() {
        return Hours.hours(getValue() / 3600);
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(getValue() / 60);
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 604800);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + "S";
    }

    public Seconds minus(Seconds seconds) {
        return seconds == null ? this : minus(seconds.getValue());
    }

    public Seconds plus(Seconds seconds) {
        return seconds == null ? this : plus(seconds.getValue());
    }

    public static Seconds secondsBetween(h hVar, h hVar2) {
        if (!(hVar instanceof LocalTime) || !(hVar2 instanceof LocalTime)) {
            return seconds(BaseSingleFieldPeriod.between(hVar, hVar2, (i) ZERO));
        }
        return seconds(a.c(hVar.getChronology()).seconds().getDifference(((LocalTime) hVar2).getLocalMillis(), ((LocalTime) hVar).getLocalMillis()));
    }
}
