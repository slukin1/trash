package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.e;
import org.joda.time.format.j;
import org.joda.time.format.n;

public final class Minutes extends BaseSingleFieldPeriod {
    public static final Minutes MAX_VALUE = new Minutes(Integer.MAX_VALUE);
    public static final Minutes MIN_VALUE = new Minutes(Integer.MIN_VALUE);
    public static final Minutes ONE = new Minutes(1);
    private static final n PARSER = j.a().j(PeriodType.minutes());
    public static final Minutes THREE = new Minutes(3);
    public static final Minutes TWO = new Minutes(2);
    public static final Minutes ZERO = new Minutes(0);
    private static final long serialVersionUID = 87525275727380863L;

    private Minutes(int i11) {
        super(i11);
    }

    public static Minutes minutes(int i11) {
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
            return new Minutes(i11);
        }
        return THREE;
    }

    public static Minutes minutesBetween(f fVar, f fVar2) {
        return minutes(BaseSingleFieldPeriod.between(fVar, fVar2, DurationFieldType.minutes()));
    }

    public static Minutes minutesIn(g gVar) {
        if (gVar == null) {
            return ZERO;
        }
        return minutes(BaseSingleFieldPeriod.between((f) gVar.getStart(), (f) gVar.getEnd(), DurationFieldType.minutes()));
    }

    @FromString
    public static Minutes parseMinutes(String str) {
        if (str == null) {
            return ZERO;
        }
        return minutes(PARSER.h(str).getMinutes());
    }

    private Object readResolve() {
        return minutes(getValue());
    }

    public static Minutes standardMinutesIn(i iVar) {
        return minutes(BaseSingleFieldPeriod.standardPeriodIn(iVar, 60000));
    }

    public Minutes dividedBy(int i11) {
        return i11 == 1 ? this : minutes(getValue() / i11);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.minutes();
    }

    public int getMinutes() {
        return getValue();
    }

    public PeriodType getPeriodType() {
        return PeriodType.minutes();
    }

    public boolean isGreaterThan(Minutes minutes) {
        if (minutes == null) {
            return getValue() > 0;
        }
        if (getValue() > minutes.getValue()) {
            return true;
        }
        return false;
    }

    public boolean isLessThan(Minutes minutes) {
        if (minutes == null) {
            return getValue() < 0;
        }
        if (getValue() < minutes.getValue()) {
            return true;
        }
        return false;
    }

    public Minutes minus(int i11) {
        return plus(e.j(i11));
    }

    public Minutes multipliedBy(int i11) {
        return minutes(e.g(getValue(), i11));
    }

    public Minutes negated() {
        return minutes(e.j(getValue()));
    }

    public Minutes plus(int i11) {
        return i11 == 0 ? this : minutes(e.d(getValue(), i11));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / 1440);
    }

    public Duration toStandardDuration() {
        return new Duration(((long) getValue()) * 60000);
    }

    public Hours toStandardHours() {
        return Hours.hours(getValue() / 60);
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(e.g(getValue(), 60));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 10080);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + "M";
    }

    public Minutes minus(Minutes minutes) {
        return minutes == null ? this : minus(minutes.getValue());
    }

    public Minutes plus(Minutes minutes) {
        return minutes == null ? this : plus(minutes.getValue());
    }

    public static Minutes minutesBetween(h hVar, h hVar2) {
        if (!(hVar instanceof LocalTime) || !(hVar2 instanceof LocalTime)) {
            return minutes(BaseSingleFieldPeriod.between(hVar, hVar2, (i) ZERO));
        }
        return minutes(a.c(hVar.getChronology()).minutes().getDifference(((LocalTime) hVar2).getLocalMillis(), ((LocalTime) hVar).getLocalMillis()));
    }
}
