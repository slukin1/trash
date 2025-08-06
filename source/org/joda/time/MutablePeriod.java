package org.joda.time;

import org.joda.convert.FromString;
import org.joda.time.base.BasePeriod;
import org.joda.time.field.e;
import org.joda.time.format.j;
import org.joda.time.format.n;

public class MutablePeriod extends BasePeriod implements c, Cloneable {
    private static final long serialVersionUID = 3436451121567212165L;

    public MutablePeriod() {
        super(0, (PeriodType) null, (Chronology) null);
    }

    @FromString
    public static MutablePeriod parse(String str) {
        return parse(str, j.a());
    }

    public void add(DurationFieldType durationFieldType, int i11) {
        super.addField(durationFieldType, i11);
    }

    public void addDays(int i11) {
        super.addField(DurationFieldType.days(), i11);
    }

    public void addHours(int i11) {
        super.addField(DurationFieldType.hours(), i11);
    }

    public void addMillis(int i11) {
        super.addField(DurationFieldType.millis(), i11);
    }

    public void addMinutes(int i11) {
        super.addField(DurationFieldType.minutes(), i11);
    }

    public void addMonths(int i11) {
        super.addField(DurationFieldType.months(), i11);
    }

    public void addSeconds(int i11) {
        super.addField(DurationFieldType.seconds(), i11);
    }

    public void addWeeks(int i11) {
        super.addField(DurationFieldType.weeks(), i11);
    }

    public void addYears(int i11) {
        super.addField(DurationFieldType.years(), i11);
    }

    public void clear() {
        super.setValues(new int[size()]);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutablePeriod copy() {
        return (MutablePeriod) clone();
    }

    public int getDays() {
        return getPeriodType().getIndexedField(this, PeriodType.DAY_INDEX);
    }

    public int getHours() {
        return getPeriodType().getIndexedField(this, PeriodType.HOUR_INDEX);
    }

    public int getMillis() {
        return getPeriodType().getIndexedField(this, PeriodType.MILLI_INDEX);
    }

    public int getMinutes() {
        return getPeriodType().getIndexedField(this, PeriodType.MINUTE_INDEX);
    }

    public int getMonths() {
        return getPeriodType().getIndexedField(this, PeriodType.MONTH_INDEX);
    }

    public int getSeconds() {
        return getPeriodType().getIndexedField(this, PeriodType.SECOND_INDEX);
    }

    public int getWeeks() {
        return getPeriodType().getIndexedField(this, PeriodType.WEEK_INDEX);
    }

    public int getYears() {
        return getPeriodType().getIndexedField(this, PeriodType.YEAR_INDEX);
    }

    public void mergePeriod(i iVar) {
        super.mergePeriod(iVar);
    }

    public void set(DurationFieldType durationFieldType, int i11) {
        super.setField(durationFieldType, i11);
    }

    public void setDays(int i11) {
        super.setField(DurationFieldType.days(), i11);
    }

    public void setHours(int i11) {
        super.setField(DurationFieldType.hours(), i11);
    }

    public void setMillis(int i11) {
        super.setField(DurationFieldType.millis(), i11);
    }

    public void setMinutes(int i11) {
        super.setField(DurationFieldType.minutes(), i11);
    }

    public void setMonths(int i11) {
        super.setField(DurationFieldType.months(), i11);
    }

    public void setPeriod(i iVar) {
        super.setPeriod(iVar);
    }

    public void setSeconds(int i11) {
        super.setField(DurationFieldType.seconds(), i11);
    }

    public void setValue(int i11, int i12) {
        super.setValue(i11, i12);
    }

    public void setWeeks(int i11) {
        super.setField(DurationFieldType.weeks(), i11);
    }

    public void setYears(int i11) {
        super.setField(DurationFieldType.years(), i11);
    }

    public MutablePeriod(PeriodType periodType) {
        super(0, periodType, (Chronology) null);
    }

    public static MutablePeriod parse(String str, n nVar) {
        return nVar.h(str).toMutablePeriod();
    }

    public void add(i iVar) {
        super.addPeriod(iVar);
    }

    public void setPeriod(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        super.setPeriod(i11, i12, i13, i14, i15, i16, i17, i18);
    }

    public MutablePeriod(int i11, int i12, int i13, int i14) {
        super(0, 0, 0, 0, i11, i12, i13, i14, PeriodType.standard());
    }

    public void add(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19 = i11;
        int i21 = i12;
        int i22 = i13;
        int i23 = i14;
        int i24 = i15;
        setPeriod(e.d(getYears(), i11), e.d(getMonths(), i12), e.d(getWeeks(), i13), e.d(getDays(), i14), e.d(getHours(), i15), e.d(getMinutes(), i16), e.d(getSeconds(), i17), e.d(getMillis(), i18));
    }

    public void setPeriod(g gVar) {
        if (gVar == null) {
            setPeriod(0);
            return;
        }
        setPeriod(gVar.getStartMillis(), gVar.getEndMillis(), a.c(gVar.getChronology()));
    }

    public MutablePeriod(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        super(i11, i12, i13, i14, i15, i16, i17, i18, PeriodType.standard());
    }

    public void add(g gVar) {
        if (gVar != null) {
            add((i) gVar.toPeriod(getPeriodType()));
        }
    }

    public MutablePeriod(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, PeriodType periodType) {
        super(i11, i12, i13, i14, i15, i16, i17, i18, periodType);
    }

    public void add(e eVar) {
        if (eVar != null) {
            add((i) new Period(eVar.getMillis(), getPeriodType()));
        }
    }

    public MutablePeriod(long j11) {
        super(j11);
    }

    public void add(long j11) {
        add((i) new Period(j11, getPeriodType()));
    }

    public void setPeriod(f fVar, f fVar2) {
        if (fVar == fVar2) {
            setPeriod(0);
            return;
        }
        setPeriod(a.h(fVar), a.h(fVar2), a.i(fVar, fVar2));
    }

    public MutablePeriod(long j11, PeriodType periodType) {
        super(j11, periodType, (Chronology) null);
    }

    public void add(long j11, Chronology chronology) {
        add((i) new Period(j11, getPeriodType(), chronology));
    }

    public MutablePeriod(long j11, Chronology chronology) {
        super(j11, (PeriodType) null, chronology);
    }

    public MutablePeriod(long j11, PeriodType periodType, Chronology chronology) {
        super(j11, periodType, chronology);
    }

    public MutablePeriod(long j11, long j12) {
        super(j11, j12, (PeriodType) null, (Chronology) null);
    }

    public MutablePeriod(long j11, long j12, PeriodType periodType) {
        super(j11, j12, periodType, (Chronology) null);
    }

    public void setPeriod(long j11, long j12) {
        setPeriod(j11, j12, (Chronology) null);
    }

    public MutablePeriod(long j11, long j12, Chronology chronology) {
        super(j11, j12, (PeriodType) null, chronology);
    }

    public void setPeriod(long j11, long j12, Chronology chronology) {
        setValues(a.c(chronology).get(this, j11, j12));
    }

    public MutablePeriod(long j11, long j12, PeriodType periodType, Chronology chronology) {
        super(j11, j12, periodType, chronology);
    }

    public MutablePeriod(f fVar, f fVar2) {
        super(fVar, fVar2, (PeriodType) null);
    }

    public void setPeriod(e eVar) {
        setPeriod(eVar, (Chronology) null);
    }

    public MutablePeriod(f fVar, f fVar2, PeriodType periodType) {
        super(fVar, fVar2, periodType);
    }

    public void setPeriod(e eVar, Chronology chronology) {
        setPeriod(a.f(eVar), chronology);
    }

    public MutablePeriod(f fVar, e eVar) {
        super(fVar, eVar, (PeriodType) null);
    }

    public MutablePeriod(f fVar, e eVar, PeriodType periodType) {
        super(fVar, eVar, periodType);
    }

    public void setPeriod(long j11) {
        setPeriod(j11, (Chronology) null);
    }

    public MutablePeriod(e eVar, f fVar) {
        super(eVar, fVar, (PeriodType) null);
    }

    public void setPeriod(long j11, Chronology chronology) {
        setValues(a.c(chronology).get((i) this, j11));
    }

    public MutablePeriod(e eVar, f fVar, PeriodType periodType) {
        super(eVar, fVar, periodType);
    }

    public MutablePeriod(Object obj) {
        super(obj, (PeriodType) null, (Chronology) null);
    }

    public MutablePeriod(Object obj, PeriodType periodType) {
        super(obj, periodType, (Chronology) null);
    }

    public MutablePeriod(Object obj, Chronology chronology) {
        super(obj, (PeriodType) null, chronology);
    }

    public MutablePeriod(Object obj, PeriodType periodType, Chronology chronology) {
        super(obj, periodType, chronology);
    }
}
