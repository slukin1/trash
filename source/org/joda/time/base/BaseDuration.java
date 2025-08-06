package org.joda.time.base;

import java.io.Serializable;
import m20.b;
import n20.d;
import org.joda.time.Chronology;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.a;
import org.joda.time.e;
import org.joda.time.f;

public abstract class BaseDuration extends b implements Serializable {
    private static final long serialVersionUID = 2581698638990L;
    private volatile long iMillis;

    public BaseDuration(long j11) {
        this.iMillis = j11;
    }

    public long getMillis() {
        return this.iMillis;
    }

    public void setMillis(long j11) {
        this.iMillis = j11;
    }

    public Interval toIntervalFrom(f fVar) {
        return new Interval(fVar, (e) this);
    }

    public Interval toIntervalTo(f fVar) {
        return new Interval((e) this, fVar);
    }

    public Period toPeriod(PeriodType periodType) {
        return new Period(getMillis(), periodType);
    }

    public Period toPeriodFrom(f fVar) {
        return new Period(fVar, (e) this);
    }

    public Period toPeriodTo(f fVar) {
        return new Period((e) this, fVar);
    }

    public Period toPeriod(Chronology chronology) {
        return new Period(getMillis(), chronology);
    }

    public Period toPeriodFrom(f fVar, PeriodType periodType) {
        return new Period(fVar, (e) this, periodType);
    }

    public Period toPeriodTo(f fVar, PeriodType periodType) {
        return new Period((e) this, fVar, periodType);
    }

    public BaseDuration(long j11, long j12) {
        this.iMillis = org.joda.time.field.e.k(j12, j11);
    }

    public Period toPeriod(PeriodType periodType, Chronology chronology) {
        return new Period(getMillis(), periodType, chronology);
    }

    public BaseDuration(f fVar, f fVar2) {
        if (fVar == fVar2) {
            this.iMillis = 0;
            return;
        }
        this.iMillis = org.joda.time.field.e.k(a.h(fVar2), a.h(fVar));
    }

    public BaseDuration(Object obj) {
        this.iMillis = d.b().a(obj).g(obj);
    }
}
