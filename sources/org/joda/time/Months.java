package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.e;
import org.joda.time.format.j;
import org.joda.time.format.n;

public final class Months extends BaseSingleFieldPeriod {
    public static final Months EIGHT = new Months(8);
    public static final Months ELEVEN = new Months(11);
    public static final Months FIVE = new Months(5);
    public static final Months FOUR = new Months(4);
    public static final Months MAX_VALUE = new Months(Integer.MAX_VALUE);
    public static final Months MIN_VALUE = new Months(Integer.MIN_VALUE);
    public static final Months NINE = new Months(9);
    public static final Months ONE = new Months(1);
    private static final n PARSER = j.a().j(PeriodType.months());
    public static final Months SEVEN = new Months(7);
    public static final Months SIX = new Months(6);
    public static final Months TEN = new Months(10);
    public static final Months THREE = new Months(3);
    public static final Months TWELVE = new Months(12);
    public static final Months TWO = new Months(2);
    public static final Months ZERO = new Months(0);
    private static final long serialVersionUID = 87525275727380867L;

    private Months(int i11) {
        super(i11);
    }

    public static Months months(int i11) {
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
            case 9:
                return NINE;
            case 10:
                return TEN;
            case 11:
                return ELEVEN;
            case 12:
                return TWELVE;
            default:
                return new Months(i11);
        }
    }

    public static Months monthsBetween(f fVar, f fVar2) {
        return months(BaseSingleFieldPeriod.between(fVar, fVar2, DurationFieldType.months()));
    }

    public static Months monthsIn(g gVar) {
        if (gVar == null) {
            return ZERO;
        }
        return months(BaseSingleFieldPeriod.between((f) gVar.getStart(), (f) gVar.getEnd(), DurationFieldType.months()));
    }

    @FromString
    public static Months parseMonths(String str) {
        if (str == null) {
            return ZERO;
        }
        return months(PARSER.h(str).getMonths());
    }

    private Object readResolve() {
        return months(getValue());
    }

    public Months dividedBy(int i11) {
        return i11 == 1 ? this : months(getValue() / i11);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.months();
    }

    public int getMonths() {
        return getValue();
    }

    public PeriodType getPeriodType() {
        return PeriodType.months();
    }

    public boolean isGreaterThan(Months months) {
        if (months == null) {
            return getValue() > 0;
        }
        if (getValue() > months.getValue()) {
            return true;
        }
        return false;
    }

    public boolean isLessThan(Months months) {
        if (months == null) {
            return getValue() < 0;
        }
        if (getValue() < months.getValue()) {
            return true;
        }
        return false;
    }

    public Months minus(int i11) {
        return plus(e.j(i11));
    }

    public Months multipliedBy(int i11) {
        return months(e.g(getValue(), i11));
    }

    public Months negated() {
        return months(e.j(getValue()));
    }

    public Months plus(int i11) {
        return i11 == 0 ? this : months(e.d(getValue(), i11));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "M";
    }

    public Months minus(Months months) {
        return months == null ? this : minus(months.getValue());
    }

    public Months plus(Months months) {
        return months == null ? this : plus(months.getValue());
    }

    public static Months monthsBetween(h hVar, h hVar2) {
        if (!(hVar instanceof LocalDate) || !(hVar2 instanceof LocalDate)) {
            return months(BaseSingleFieldPeriod.between(hVar, hVar2, (i) ZERO));
        }
        return months(a.c(hVar.getChronology()).months().getDifference(((LocalDate) hVar2).getLocalMillis(), ((LocalDate) hVar).getLocalMillis()));
    }
}
