package org.joda.time.chrono;

import com.hbg.lib.network.pro.core.util.Period;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.ImpreciseDateTimeField;
import org.joda.time.field.e;

public final class f extends ImpreciseDateTimeField {

    /* renamed from: d  reason: collision with root package name */
    public final BasicChronology f23086d;

    public f(BasicChronology basicChronology) {
        super(DateTimeFieldType.weekyear(), basicChronology.getAverageMillisPerYear());
        this.f23086d = basicChronology;
    }

    public long add(long j11, int i11) {
        return i11 == 0 ? j11 : set(j11, get(j11) + i11);
    }

    public long addWrapField(long j11, int i11) {
        return add(j11, i11);
    }

    public int get(long j11) {
        return this.f23086d.getWeekyear(j11);
    }

    public long getDifferenceAsLong(long j11, long j12) {
        if (j11 < j12) {
            return (long) (-getDifference(j12, j11));
        }
        int i11 = get(j11);
        int i12 = get(j12);
        long remainder = remainder(j11);
        long remainder2 = remainder(j12);
        if (remainder2 >= 31449600000L && this.f23086d.getWeeksInYear(i11) <= 52) {
            remainder2 -= Period.WEEK_MILLS;
        }
        int i13 = i11 - i12;
        if (remainder < remainder2) {
            i13--;
        }
        return (long) i13;
    }

    public int getLeapAmount(long j11) {
        BasicChronology basicChronology = this.f23086d;
        return basicChronology.getWeeksInYear(basicChronology.getWeekyear(j11)) - 52;
    }

    public DurationField getLeapDurationField() {
        return this.f23086d.weeks();
    }

    public int getMaximumValue() {
        return this.f23086d.getMaxYear();
    }

    public int getMinimumValue() {
        return this.f23086d.getMinYear();
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLeap(long j11) {
        BasicChronology basicChronology = this.f23086d;
        return basicChronology.getWeeksInYear(basicChronology.getWeekyear(j11)) > 52;
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j11) {
        return j11 - roundFloor(j11);
    }

    public long roundFloor(long j11) {
        long roundFloor = this.f23086d.weekOfWeekyear().roundFloor(j11);
        int weekOfWeekyear = this.f23086d.getWeekOfWeekyear(roundFloor);
        return weekOfWeekyear > 1 ? roundFloor - (((long) (weekOfWeekyear - 1)) * Period.WEEK_MILLS) : roundFloor;
    }

    public long set(long j11, int i11) {
        e.m(this, Math.abs(i11), this.f23086d.getMinYear(), this.f23086d.getMaxYear());
        int i12 = get(j11);
        if (i12 == i11) {
            return j11;
        }
        int dayOfWeek = this.f23086d.getDayOfWeek(j11);
        int weeksInYear = this.f23086d.getWeeksInYear(i12);
        int weeksInYear2 = this.f23086d.getWeeksInYear(i11);
        if (weeksInYear2 < weeksInYear) {
            weeksInYear = weeksInYear2;
        }
        int weekOfWeekyear = this.f23086d.getWeekOfWeekyear(j11);
        if (weekOfWeekyear <= weeksInYear) {
            weeksInYear = weekOfWeekyear;
        }
        long year = this.f23086d.setYear(j11, i11);
        int i13 = get(year);
        if (i13 < i11) {
            year += Period.WEEK_MILLS;
        } else if (i13 > i11) {
            year -= Period.WEEK_MILLS;
        }
        return this.f23086d.dayOfWeek().set(year + (((long) (weeksInYear - this.f23086d.getWeekOfWeekyear(year))) * Period.WEEK_MILLS), dayOfWeek);
    }

    public long add(long j11, long j12) {
        return add(j11, e.l(j12));
    }
}
