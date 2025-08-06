package org.joda.time;

import com.hbg.lib.network.pro.core.util.Period;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.e;
import org.joda.time.format.j;
import org.joda.time.format.n;

public final class Hours extends BaseSingleFieldPeriod {
    public static final Hours EIGHT = new Hours(8);
    public static final Hours FIVE = new Hours(5);
    public static final Hours FOUR = new Hours(4);
    public static final Hours MAX_VALUE = new Hours(Integer.MAX_VALUE);
    public static final Hours MIN_VALUE = new Hours(Integer.MIN_VALUE);
    public static final Hours ONE = new Hours(1);
    private static final n PARSER = j.a().j(PeriodType.hours());
    public static final Hours SEVEN = new Hours(7);
    public static final Hours SIX = new Hours(6);
    public static final Hours THREE = new Hours(3);
    public static final Hours TWO = new Hours(2);
    public static final Hours ZERO = new Hours(0);
    private static final long serialVersionUID = 87525275727380864L;

    private Hours(int i11) {
        super(i11);
    }

    public static Hours hours(int i11) {
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
            case 8:
                return EIGHT;
            default:
                return new Hours(i11);
        }
    }

    public static Hours hoursBetween(f fVar, f fVar2) {
        return hours(BaseSingleFieldPeriod.between(fVar, fVar2, DurationFieldType.hours()));
    }

    public static Hours hoursIn(g gVar) {
        if (gVar == null) {
            return ZERO;
        }
        return hours(BaseSingleFieldPeriod.between((f) gVar.getStart(), (f) gVar.getEnd(), DurationFieldType.hours()));
    }

    @FromString
    public static Hours parseHours(String str) {
        if (str == null) {
            return ZERO;
        }
        return hours(PARSER.h(str).getHours());
    }

    private Object readResolve() {
        return hours(getValue());
    }

    public static Hours standardHoursIn(i iVar) {
        return hours(BaseSingleFieldPeriod.standardPeriodIn(iVar, Period.MIN60_MILLS));
    }

    public Hours dividedBy(int i11) {
        return i11 == 1 ? this : hours(getValue() / i11);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.hours();
    }

    public int getHours() {
        return getValue();
    }

    public PeriodType getPeriodType() {
        return PeriodType.hours();
    }

    public boolean isGreaterThan(Hours hours) {
        if (hours == null) {
            return getValue() > 0;
        }
        if (getValue() > hours.getValue()) {
            return true;
        }
        return false;
    }

    public boolean isLessThan(Hours hours) {
        if (hours == null) {
            return getValue() < 0;
        }
        if (getValue() < hours.getValue()) {
            return true;
        }
        return false;
    }

    public Hours minus(int i11) {
        return plus(e.j(i11));
    }

    public Hours multipliedBy(int i11) {
        return hours(e.g(getValue(), i11));
    }

    public Hours negated() {
        return hours(e.j(getValue()));
    }

    public Hours plus(int i11) {
        return i11 == 0 ? this : hours(e.d(getValue(), i11));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / 24);
    }

    public Duration toStandardDuration() {
        return new Duration(((long) getValue()) * Period.MIN60_MILLS);
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(e.g(getValue(), 60));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(e.g(getValue(), 3600));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + "H";
    }

    public Hours minus(Hours hours) {
        return hours == null ? this : minus(hours.getValue());
    }

    public Hours plus(Hours hours) {
        return hours == null ? this : plus(hours.getValue());
    }

    public static Hours hoursBetween(h hVar, h hVar2) {
        if (!(hVar instanceof LocalTime) || !(hVar2 instanceof LocalTime)) {
            return hours(BaseSingleFieldPeriod.between(hVar, hVar2, (i) ZERO));
        }
        return hours(a.c(hVar.getChronology()).hours().getDifference(((LocalTime) hVar2).getLocalMillis(), ((LocalTime) hVar).getLocalMillis()));
    }
}
