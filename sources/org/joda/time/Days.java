package org.joda.time;

import com.hbg.lib.network.pro.core.util.Period;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.e;
import org.joda.time.format.j;
import org.joda.time.format.n;

public final class Days extends BaseSingleFieldPeriod {
    public static final Days FIVE = new Days(5);
    public static final Days FOUR = new Days(4);
    public static final Days MAX_VALUE = new Days(Integer.MAX_VALUE);
    public static final Days MIN_VALUE = new Days(Integer.MIN_VALUE);
    public static final Days ONE = new Days(1);
    private static final n PARSER = j.a().j(PeriodType.days());
    public static final Days SEVEN = new Days(7);
    public static final Days SIX = new Days(6);
    public static final Days THREE = new Days(3);
    public static final Days TWO = new Days(2);
    public static final Days ZERO = new Days(0);
    private static final long serialVersionUID = 87525275727380865L;

    private Days(int i11) {
        super(i11);
    }

    public static Days days(int i11) {
        if (i11 == Integer.MIN_VALUE) {
            return MIN_VALUE;
        }
        if (i11 == Integer.MAX_VALUE) {
            return MAX_VALUE;
        }
        switch (i11) {
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            default:
                return new Days(i11);
        }
    }

    public static Days daysBetween(f fVar, f fVar2) {
        return days(BaseSingleFieldPeriod.between(fVar, fVar2, DurationFieldType.days()));
    }

    public static Days daysIn(g gVar) {
        if (gVar == null) {
            return ZERO;
        }
        return days(BaseSingleFieldPeriod.between((f) gVar.getStart(), (f) gVar.getEnd(), DurationFieldType.days()));
    }

    @FromString
    public static Days parseDays(String str) {
        if (str == null) {
            return ZERO;
        }
        return days(PARSER.h(str).getDays());
    }

    private Object readResolve() {
        return days(getValue());
    }

    public static Days standardDaysIn(i iVar) {
        return days(BaseSingleFieldPeriod.standardPeriodIn(iVar, Period.DAY_MILLS));
    }

    public Days dividedBy(int i11) {
        return i11 == 1 ? this : days(getValue() / i11);
    }

    public int getDays() {
        return getValue();
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.days();
    }

    public PeriodType getPeriodType() {
        return PeriodType.days();
    }

    public boolean isGreaterThan(Days days) {
        if (days == null) {
            return getValue() > 0;
        }
        if (getValue() > days.getValue()) {
            return true;
        }
        return false;
    }

    public boolean isLessThan(Days days) {
        if (days == null) {
            return getValue() < 0;
        }
        if (getValue() < days.getValue()) {
            return true;
        }
        return false;
    }

    public Days minus(int i11) {
        return plus(e.j(i11));
    }

    public Days multipliedBy(int i11) {
        return days(e.g(getValue(), i11));
    }

    public Days negated() {
        return days(e.j(getValue()));
    }

    public Days plus(int i11) {
        return i11 == 0 ? this : days(e.d(getValue(), i11));
    }

    public Duration toStandardDuration() {
        return new Duration(((long) getValue()) * Period.DAY_MILLS);
    }

    public Hours toStandardHours() {
        return Hours.hours(e.g(getValue(), 24));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(e.g(getValue(), 1440));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(e.g(getValue(), 86400));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 7);
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "D";
    }

    public Days minus(Days days) {
        return days == null ? this : minus(days.getValue());
    }

    public Days plus(Days days) {
        return days == null ? this : plus(days.getValue());
    }

    public static Days daysBetween(h hVar, h hVar2) {
        if (!(hVar instanceof LocalDate) || !(hVar2 instanceof LocalDate)) {
            return days(BaseSingleFieldPeriod.between(hVar, hVar2, (i) ZERO));
        }
        return days(a.c(hVar.getChronology()).days().getDifference(((LocalDate) hVar2).getLocalMillis(), ((LocalDate) hVar).getLocalMillis()));
    }
}
