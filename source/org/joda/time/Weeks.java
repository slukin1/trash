package org.joda.time;

import com.hbg.lib.network.pro.core.util.Period;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.e;
import org.joda.time.format.j;
import org.joda.time.format.n;

public final class Weeks extends BaseSingleFieldPeriod {
    public static final Weeks MAX_VALUE = new Weeks(Integer.MAX_VALUE);
    public static final Weeks MIN_VALUE = new Weeks(Integer.MIN_VALUE);
    public static final Weeks ONE = new Weeks(1);
    private static final n PARSER = j.a().j(PeriodType.weeks());
    public static final Weeks THREE = new Weeks(3);
    public static final Weeks TWO = new Weeks(2);
    public static final Weeks ZERO = new Weeks(0);
    private static final long serialVersionUID = 87525275727380866L;

    private Weeks(int i11) {
        super(i11);
    }

    @FromString
    public static Weeks parseWeeks(String str) {
        if (str == null) {
            return ZERO;
        }
        return weeks(PARSER.h(str).getWeeks());
    }

    private Object readResolve() {
        return weeks(getValue());
    }

    public static Weeks standardWeeksIn(i iVar) {
        return weeks(BaseSingleFieldPeriod.standardPeriodIn(iVar, Period.WEEK_MILLS));
    }

    public static Weeks weeks(int i11) {
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
            return new Weeks(i11);
        }
        return THREE;
    }

    public static Weeks weeksBetween(f fVar, f fVar2) {
        return weeks(BaseSingleFieldPeriod.between(fVar, fVar2, DurationFieldType.weeks()));
    }

    public static Weeks weeksIn(g gVar) {
        if (gVar == null) {
            return ZERO;
        }
        return weeks(BaseSingleFieldPeriod.between((f) gVar.getStart(), (f) gVar.getEnd(), DurationFieldType.weeks()));
    }

    public Weeks dividedBy(int i11) {
        return i11 == 1 ? this : weeks(getValue() / i11);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.weeks();
    }

    public PeriodType getPeriodType() {
        return PeriodType.weeks();
    }

    public int getWeeks() {
        return getValue();
    }

    public boolean isGreaterThan(Weeks weeks) {
        if (weeks == null) {
            return getValue() > 0;
        }
        if (getValue() > weeks.getValue()) {
            return true;
        }
        return false;
    }

    public boolean isLessThan(Weeks weeks) {
        if (weeks == null) {
            return getValue() < 0;
        }
        if (getValue() < weeks.getValue()) {
            return true;
        }
        return false;
    }

    public Weeks minus(int i11) {
        return plus(e.j(i11));
    }

    public Weeks multipliedBy(int i11) {
        return weeks(e.g(getValue(), i11));
    }

    public Weeks negated() {
        return weeks(e.j(getValue()));
    }

    public Weeks plus(int i11) {
        return i11 == 0 ? this : weeks(e.d(getValue(), i11));
    }

    public Days toStandardDays() {
        return Days.days(e.g(getValue(), 7));
    }

    public Duration toStandardDuration() {
        return new Duration(((long) getValue()) * Period.WEEK_MILLS);
    }

    public Hours toStandardHours() {
        return Hours.hours(e.g(getValue(), HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(e.g(getValue(), 10080));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(e.g(getValue(), 604800));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "W";
    }

    public Weeks minus(Weeks weeks) {
        return weeks == null ? this : minus(weeks.getValue());
    }

    public Weeks plus(Weeks weeks) {
        return weeks == null ? this : plus(weeks.getValue());
    }

    public static Weeks weeksBetween(h hVar, h hVar2) {
        if (!(hVar instanceof LocalDate) || !(hVar2 instanceof LocalDate)) {
            return weeks(BaseSingleFieldPeriod.between(hVar, hVar2, (i) ZERO));
        }
        return weeks(a.c(hVar.getChronology()).weeks().getDifference(((LocalDate) hVar2).getLocalMillis(), ((LocalDate) hVar).getLocalMillis()));
    }
}
