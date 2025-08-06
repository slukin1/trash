package org.joda.time;

import com.adjust.sdk.Constants;
import com.hbg.lib.network.pro.core.util.Period;
import org.joda.convert.FromString;
import org.joda.time.base.BaseDuration;
import org.joda.time.field.e;

public final class Duration extends BaseDuration {
    public static final Duration ZERO = new Duration(0);
    private static final long serialVersionUID = 2471658376918L;

    public Duration(long j11) {
        super(j11);
    }

    public static Duration millis(long j11) {
        if (j11 == 0) {
            return ZERO;
        }
        return new Duration(j11);
    }

    @FromString
    public static Duration parse(String str) {
        return new Duration((Object) str);
    }

    public static Duration standardDays(long j11) {
        if (j11 == 0) {
            return ZERO;
        }
        return new Duration(e.h(j11, 86400000));
    }

    public static Duration standardHours(long j11) {
        if (j11 == 0) {
            return ZERO;
        }
        return new Duration(e.h(j11, Constants.ONE_HOUR));
    }

    public static Duration standardMinutes(long j11) {
        if (j11 == 0) {
            return ZERO;
        }
        return new Duration(e.h(j11, 60000));
    }

    public static Duration standardSeconds(long j11) {
        if (j11 == 0) {
            return ZERO;
        }
        return new Duration(e.h(j11, 1000));
    }

    public Duration dividedBy(long j11) {
        return j11 == 1 ? this : new Duration(e.f(getMillis(), j11));
    }

    public long getStandardDays() {
        return getMillis() / Period.DAY_MILLS;
    }

    public long getStandardHours() {
        return getMillis() / Period.MIN60_MILLS;
    }

    public long getStandardMinutes() {
        return getMillis() / 60000;
    }

    public long getStandardSeconds() {
        return getMillis() / 1000;
    }

    public Duration minus(long j11) {
        return withDurationAdded(j11, -1);
    }

    public Duration multipliedBy(long j11) {
        return j11 == 1 ? this : new Duration(e.i(getMillis(), j11));
    }

    public Duration negated() {
        if (getMillis() != Long.MIN_VALUE) {
            return new Duration(-getMillis());
        }
        throw new ArithmeticException("Negation of this duration would overflow");
    }

    public Duration plus(long j11) {
        return withDurationAdded(j11, 1);
    }

    public Duration toDuration() {
        return this;
    }

    public Days toStandardDays() {
        return Days.days(e.l(getStandardDays()));
    }

    public Hours toStandardHours() {
        return Hours.hours(e.l(getStandardHours()));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(e.l(getStandardMinutes()));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(e.l(getStandardSeconds()));
    }

    public Duration withDurationAdded(long j11, int i11) {
        if (j11 == 0 || i11 == 0) {
            return this;
        }
        return new Duration(e.e(getMillis(), e.h(j11, i11)));
    }

    public Duration withMillis(long j11) {
        if (j11 == getMillis()) {
            return this;
        }
        return new Duration(j11);
    }

    public Duration(long j11, long j12) {
        super(j11, j12);
    }

    public Duration minus(e eVar) {
        return eVar == null ? this : withDurationAdded(eVar.getMillis(), -1);
    }

    public Duration plus(e eVar) {
        return eVar == null ? this : withDurationAdded(eVar.getMillis(), 1);
    }

    public Duration(f fVar, f fVar2) {
        super(fVar, fVar2);
    }

    public Duration(Object obj) {
        super(obj);
    }

    public Duration withDurationAdded(e eVar, int i11) {
        return (eVar == null || i11 == 0) ? this : withDurationAdded(eVar.getMillis(), i11);
    }
}
