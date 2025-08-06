package org.joda.time;

import com.huobi.login.usercenter.data.source.bean.KvStore;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.e;
import org.joda.time.format.j;
import org.joda.time.format.n;

public final class Years extends BaseSingleFieldPeriod {
    public static final Years MAX_VALUE = new Years(Integer.MAX_VALUE);
    public static final Years MIN_VALUE = new Years(Integer.MIN_VALUE);
    public static final Years ONE = new Years(1);
    private static final n PARSER = j.a().j(PeriodType.years());
    public static final Years THREE = new Years(3);
    public static final Years TWO = new Years(2);
    public static final Years ZERO = new Years(0);
    private static final long serialVersionUID = 87525275727380868L;

    private Years(int i11) {
        super(i11);
    }

    @FromString
    public static Years parseYears(String str) {
        if (str == null) {
            return ZERO;
        }
        return years(PARSER.h(str).getYears());
    }

    private Object readResolve() {
        return years(getValue());
    }

    public static Years years(int i11) {
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
            return new Years(i11);
        }
        return THREE;
    }

    public static Years yearsBetween(f fVar, f fVar2) {
        return years(BaseSingleFieldPeriod.between(fVar, fVar2, DurationFieldType.years()));
    }

    public static Years yearsIn(g gVar) {
        if (gVar == null) {
            return ZERO;
        }
        return years(BaseSingleFieldPeriod.between((f) gVar.getStart(), (f) gVar.getEnd(), DurationFieldType.years()));
    }

    public Years dividedBy(int i11) {
        return i11 == 1 ? this : years(getValue() / i11);
    }

    public DurationFieldType getFieldType() {
        return DurationFieldType.years();
    }

    public PeriodType getPeriodType() {
        return PeriodType.years();
    }

    public int getYears() {
        return getValue();
    }

    public boolean isGreaterThan(Years years) {
        if (years == null) {
            return getValue() > 0;
        }
        if (getValue() > years.getValue()) {
            return true;
        }
        return false;
    }

    public boolean isLessThan(Years years) {
        if (years == null) {
            return getValue() < 0;
        }
        if (getValue() < years.getValue()) {
            return true;
        }
        return false;
    }

    public Years minus(int i11) {
        return plus(e.j(i11));
    }

    public Years multipliedBy(int i11) {
        return years(e.g(getValue(), i11));
    }

    public Years negated() {
        return years(e.j(getValue()));
    }

    public Years plus(int i11) {
        return i11 == 0 ? this : years(e.d(getValue(), i11));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + KvStore.Y;
    }

    public Years minus(Years years) {
        return years == null ? this : minus(years.getValue());
    }

    public Years plus(Years years) {
        return years == null ? this : plus(years.getValue());
    }

    public static Years yearsBetween(h hVar, h hVar2) {
        if (!(hVar instanceof LocalDate) || !(hVar2 instanceof LocalDate)) {
            return years(BaseSingleFieldPeriod.between(hVar, hVar2, (i) ZERO));
        }
        return years(a.c(hVar.getChronology()).years().getDifference(((LocalDate) hVar2).getLocalMillis(), ((LocalDate) hVar).getLocalMillis()));
    }
}
