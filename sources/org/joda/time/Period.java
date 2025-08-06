package org.joda.time;

import com.huobi.framework.im.common.GenerateUserSig;
import org.joda.convert.FromString;
import org.joda.time.base.BasePeriod;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.e;
import org.joda.time.format.j;
import org.joda.time.format.n;

public final class Period extends BasePeriod {
    public static final Period ZERO = new Period();
    private static final long serialVersionUID = 741052353876488155L;

    public Period() {
        super(0, (PeriodType) null, (Chronology) null);
    }

    private void checkYearsAndMonths(String str) {
        if (getMonths() != 0) {
            throw new UnsupportedOperationException("Cannot convert to " + str + " as this period contains months and months vary in length");
        } else if (getYears() != 0) {
            throw new UnsupportedOperationException("Cannot convert to " + str + " as this period contains years and years vary in length");
        }
    }

    public static Period days(int i11) {
        return new Period(new int[]{0, 0, 0, i11, 0, 0, 0, 0}, PeriodType.standard());
    }

    public static Period fieldDifference(h hVar, h hVar2) {
        if (hVar == null || hVar2 == null) {
            throw new IllegalArgumentException("ReadablePartial objects must not be null");
        } else if (hVar.size() == hVar2.size()) {
            DurationFieldType[] durationFieldTypeArr = new DurationFieldType[hVar.size()];
            int[] iArr = new int[hVar.size()];
            int i11 = 0;
            int size = hVar.size();
            while (i11 < size) {
                if (hVar.getFieldType(i11) == hVar2.getFieldType(i11)) {
                    durationFieldTypeArr[i11] = hVar.getFieldType(i11).getDurationType();
                    if (i11 <= 0 || durationFieldTypeArr[i11 - 1] != durationFieldTypeArr[i11]) {
                        iArr[i11] = hVar2.getValue(i11) - hVar.getValue(i11);
                        i11++;
                    } else {
                        throw new IllegalArgumentException("ReadablePartial objects must not have overlapping fields");
                    }
                } else {
                    throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                }
            }
            return new Period(iArr, PeriodType.forFields(durationFieldTypeArr));
        } else {
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
    }

    public static Period hours(int i11) {
        return new Period(new int[]{0, 0, 0, 0, i11, 0, 0, 0}, PeriodType.standard());
    }

    public static Period millis(int i11) {
        return new Period(new int[]{0, 0, 0, 0, 0, 0, 0, i11}, PeriodType.standard());
    }

    public static Period minutes(int i11) {
        return new Period(new int[]{0, 0, 0, 0, 0, i11, 0, 0}, PeriodType.standard());
    }

    public static Period months(int i11) {
        return new Period(new int[]{0, i11, 0, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    @FromString
    public static Period parse(String str) {
        return parse(str, j.a());
    }

    public static Period seconds(int i11) {
        return new Period(new int[]{0, 0, 0, 0, 0, 0, i11, 0}, PeriodType.standard());
    }

    public static Period weeks(int i11) {
        return new Period(new int[]{0, 0, i11, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    public static Period years(int i11) {
        return new Period(new int[]{i11, 0, 0, 0, 0, 0, 0, 0, 0}, PeriodType.standard());
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

    public Period minus(i iVar) {
        if (iVar == null) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, -iVar.get(DurationFieldType.YEARS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, -iVar.get(DurationFieldType.MONTHS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, -iVar.get(DurationFieldType.WEEKS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, -iVar.get(DurationFieldType.DAYS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, -iVar.get(DurationFieldType.HOURS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, -iVar.get(DurationFieldType.MINUTES_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, -iVar.get(DurationFieldType.SECONDS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, -iVar.get(DurationFieldType.MILLIS_TYPE));
        return new Period(values, getPeriodType());
    }

    public Period minusDays(int i11) {
        return plusDays(-i11);
    }

    public Period minusHours(int i11) {
        return plusHours(-i11);
    }

    public Period minusMillis(int i11) {
        return plusMillis(-i11);
    }

    public Period minusMinutes(int i11) {
        return plusMinutes(-i11);
    }

    public Period minusMonths(int i11) {
        return plusMonths(-i11);
    }

    public Period minusSeconds(int i11) {
        return plusSeconds(-i11);
    }

    public Period minusWeeks(int i11) {
        return plusWeeks(-i11);
    }

    public Period minusYears(int i11) {
        return plusYears(-i11);
    }

    public Period multipliedBy(int i11) {
        if (this == ZERO || i11 == 1) {
            return this;
        }
        int[] values = getValues();
        for (int i12 = 0; i12 < values.length; i12++) {
            values[i12] = e.g(values[i12], i11);
        }
        return new Period(values, getPeriodType());
    }

    public Period negated() {
        return multipliedBy(-1);
    }

    public Period normalizedStandard() {
        return normalizedStandard(PeriodType.standard());
    }

    public Period plus(i iVar) {
        if (iVar == null) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, iVar.get(DurationFieldType.YEARS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, iVar.get(DurationFieldType.MONTHS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, iVar.get(DurationFieldType.WEEKS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, iVar.get(DurationFieldType.DAYS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, iVar.get(DurationFieldType.HOURS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, iVar.get(DurationFieldType.MINUTES_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, iVar.get(DurationFieldType.SECONDS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, iVar.get(DurationFieldType.MILLIS_TYPE));
        return new Period(values, getPeriodType());
    }

    public Period plusDays(int i11) {
        if (i11 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period plusHours(int i11) {
        if (i11 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period plusMillis(int i11) {
        if (i11 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period plusMinutes(int i11) {
        if (i11 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period plusMonths(int i11) {
        if (i11 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period plusSeconds(int i11) {
        if (i11 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period plusWeeks(int i11) {
        if (i11 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period plusYears(int i11) {
        if (i11 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period toPeriod() {
        return this;
    }

    public Days toStandardDays() {
        checkYearsAndMonths("Days");
        return Days.days(e.l(e.e(e.e((((((long) getMillis()) + (((long) getSeconds()) * 1000)) + (((long) getMinutes()) * 60000)) + (((long) getHours()) * com.hbg.lib.network.pro.core.util.Period.MIN60_MILLS)) / com.hbg.lib.network.pro.core.util.Period.DAY_MILLS, (long) getDays()), ((long) getWeeks()) * 7)));
    }

    public Duration toStandardDuration() {
        checkYearsAndMonths("Duration");
        return new Duration(((long) getMillis()) + (((long) getSeconds()) * 1000) + (((long) getMinutes()) * 60000) + (((long) getHours()) * com.hbg.lib.network.pro.core.util.Period.MIN60_MILLS) + (((long) getDays()) * com.hbg.lib.network.pro.core.util.Period.DAY_MILLS) + (((long) getWeeks()) * com.hbg.lib.network.pro.core.util.Period.WEEK_MILLS));
    }

    public Hours toStandardHours() {
        checkYearsAndMonths("Hours");
        return Hours.hours(e.l(e.e(e.e(e.e(((((long) getMillis()) + (((long) getSeconds()) * 1000)) + (((long) getMinutes()) * 60000)) / com.hbg.lib.network.pro.core.util.Period.MIN60_MILLS, (long) getHours()), ((long) getDays()) * 24), ((long) getWeeks()) * 168)));
    }

    public Minutes toStandardMinutes() {
        checkYearsAndMonths("Minutes");
        return Minutes.minutes(e.l(e.e(e.e(e.e(e.e((((long) getMillis()) + (((long) getSeconds()) * 1000)) / 60000, (long) getMinutes()), ((long) getHours()) * 60), ((long) getDays()) * 1440), ((long) getWeeks()) * 10080)));
    }

    public Seconds toStandardSeconds() {
        checkYearsAndMonths("Seconds");
        return Seconds.seconds(e.l(e.e(e.e(e.e(e.e(e.e((long) (getMillis() / 1000), (long) getSeconds()), ((long) getMinutes()) * 60), ((long) getHours()) * 3600), ((long) getDays()) * 86400), ((long) getWeeks()) * GenerateUserSig.EXPIRETIME)));
    }

    public Weeks toStandardWeeks() {
        checkYearsAndMonths("Weeks");
        return Weeks.weeks(e.l(((long) getWeeks()) + (((((((long) getMillis()) + (((long) getSeconds()) * 1000)) + (((long) getMinutes()) * 60000)) + (((long) getHours()) * com.hbg.lib.network.pro.core.util.Period.MIN60_MILLS)) + (((long) getDays()) * com.hbg.lib.network.pro.core.util.Period.DAY_MILLS)) / com.hbg.lib.network.pro.core.util.Period.WEEK_MILLS)));
    }

    public Period withDays(int i11) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.DAY_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period withField(DurationFieldType durationFieldType, int i11) {
        if (durationFieldType != null) {
            int[] values = getValues();
            super.setFieldInto(values, durationFieldType, i11);
            return new Period(values, getPeriodType());
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public Period withFieldAdded(DurationFieldType durationFieldType, int i11) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (i11 == 0) {
            return this;
        } else {
            int[] values = getValues();
            super.addFieldInto(values, durationFieldType, i11);
            return new Period(values, getPeriodType());
        }
    }

    public Period withFields(i iVar) {
        if (iVar == null) {
            return this;
        }
        return new Period(super.mergePeriodInto(getValues(), iVar), getPeriodType());
    }

    public Period withHours(int i11) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.HOUR_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period withMillis(int i11) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MILLI_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period withMinutes(int i11) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MINUTE_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period withMonths(int i11) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MONTH_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period withPeriodType(PeriodType periodType) {
        PeriodType k11 = a.k(periodType);
        if (k11.equals(getPeriodType())) {
            return this;
        }
        return new Period((Object) this, k11);
    }

    public Period withSeconds(int i11) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.SECOND_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period withWeeks(int i11) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.WEEK_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period withYears(int i11) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.YEAR_INDEX, values, i11);
        return new Period(values, getPeriodType());
    }

    public Period(int i11, int i12, int i13, int i14) {
        super(0, 0, 0, 0, i11, i12, i13, i14, PeriodType.standard());
    }

    public static Period parse(String str, n nVar) {
        return nVar.h(str);
    }

    public Period normalizedStandard(PeriodType periodType) {
        PeriodType k11 = a.k(periodType);
        Period period = new Period(((long) getMillis()) + (((long) getSeconds()) * 1000) + (((long) getMinutes()) * 60000) + (((long) getHours()) * com.hbg.lib.network.pro.core.util.Period.MIN60_MILLS) + (((long) getDays()) * com.hbg.lib.network.pro.core.util.Period.DAY_MILLS) + (((long) getWeeks()) * com.hbg.lib.network.pro.core.util.Period.WEEK_MILLS), k11, (Chronology) ISOChronology.getInstanceUTC());
        int years = getYears();
        int months = getMonths();
        if (!(years == 0 && months == 0)) {
            long j11 = (((long) years) * 12) + ((long) months);
            if (k11.isSupported(DurationFieldType.YEARS_TYPE)) {
                int l11 = e.l(j11 / 12);
                period = period.withYears(l11);
                j11 -= (long) (l11 * 12);
            }
            if (k11.isSupported(DurationFieldType.MONTHS_TYPE)) {
                int l12 = e.l(j11);
                j11 -= (long) l12;
                period = period.withMonths(l12);
            }
            if (j11 != 0) {
                throw new UnsupportedOperationException("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + toString());
            }
        }
        return period;
    }

    public Period(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        super(i11, i12, i13, i14, i15, i16, i17, i18, PeriodType.standard());
    }

    public Period(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, PeriodType periodType) {
        super(i11, i12, i13, i14, i15, i16, i17, i18, periodType);
    }

    public Period(long j11) {
        super(j11);
    }

    public Period(long j11, PeriodType periodType) {
        super(j11, periodType, (Chronology) null);
    }

    public Period(long j11, Chronology chronology) {
        super(j11, (PeriodType) null, chronology);
    }

    public Period(long j11, PeriodType periodType, Chronology chronology) {
        super(j11, periodType, chronology);
    }

    public Period(long j11, long j12) {
        super(j11, j12, (PeriodType) null, (Chronology) null);
    }

    public Period(long j11, long j12, PeriodType periodType) {
        super(j11, j12, periodType, (Chronology) null);
    }

    public Period(long j11, long j12, Chronology chronology) {
        super(j11, j12, (PeriodType) null, chronology);
    }

    public Period(long j11, long j12, PeriodType periodType, Chronology chronology) {
        super(j11, j12, periodType, chronology);
    }

    public Period(f fVar, f fVar2) {
        super(fVar, fVar2, (PeriodType) null);
    }

    public Period(f fVar, f fVar2, PeriodType periodType) {
        super(fVar, fVar2, periodType);
    }

    public Period(h hVar, h hVar2) {
        super(hVar, hVar2, (PeriodType) null);
    }

    public Period(h hVar, h hVar2, PeriodType periodType) {
        super(hVar, hVar2, periodType);
    }

    public Period(f fVar, e eVar) {
        super(fVar, eVar, (PeriodType) null);
    }

    public Period(f fVar, e eVar, PeriodType periodType) {
        super(fVar, eVar, periodType);
    }

    public Period(e eVar, f fVar) {
        super(eVar, fVar, (PeriodType) null);
    }

    public Period(e eVar, f fVar, PeriodType periodType) {
        super(eVar, fVar, periodType);
    }

    public Period(Object obj) {
        super(obj, (PeriodType) null, (Chronology) null);
    }

    public Period(Object obj, PeriodType periodType) {
        super(obj, periodType, (Chronology) null);
    }

    public Period(Object obj, Chronology chronology) {
        super(obj, (PeriodType) null, chronology);
    }

    public Period(Object obj, PeriodType periodType, Chronology chronology) {
        super(obj, periodType, chronology);
    }

    private Period(int[] iArr, PeriodType periodType) {
        super(iArr, periodType);
    }
}
