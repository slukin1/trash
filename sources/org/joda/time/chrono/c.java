package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.a;
import org.joda.time.field.ImpreciseDateTimeField;
import org.joda.time.field.e;
import org.joda.time.h;

public class c extends ImpreciseDateTimeField {

    /* renamed from: d  reason: collision with root package name */
    public final BasicChronology f23081d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23082e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23083f;

    public c(BasicChronology basicChronology, int i11) {
        super(DateTimeFieldType.monthOfYear(), basicChronology.getAverageMillisPerMonth());
        this.f23081d = basicChronology;
        this.f23082e = basicChronology.getMaxMonth();
        this.f23083f = i11;
    }

    public long add(long j11, int i11) {
        int i12;
        int i13;
        if (i11 == 0) {
            return j11;
        }
        long millisOfDay = (long) this.f23081d.getMillisOfDay(j11);
        int year = this.f23081d.getYear(j11);
        int monthOfYear = this.f23081d.getMonthOfYear(j11, year);
        int i14 = (monthOfYear - 1) + i11;
        if (i14 >= 0) {
            int i15 = this.f23082e;
            i12 = (i14 / i15) + year;
            i13 = (i14 % i15) + 1;
        } else {
            i12 = ((i14 / this.f23082e) + year) - 1;
            int abs = Math.abs(i14);
            int i16 = this.f23082e;
            int i17 = abs % i16;
            if (i17 == 0) {
                i17 = i16;
            }
            i13 = (i16 - i17) + 1;
            if (i13 == 1) {
                i12++;
            }
        }
        int dayOfMonth = this.f23081d.getDayOfMonth(j11, year, monthOfYear);
        int daysInYearMonth = this.f23081d.getDaysInYearMonth(i12, i13);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.f23081d.getYearMonthDayMillis(i12, i13, dayOfMonth) + millisOfDay;
    }

    public long addWrapField(long j11, int i11) {
        return set(j11, e.c(get(j11), i11, 1, this.f23082e));
    }

    public int get(long j11) {
        return this.f23081d.getMonthOfYear(j11);
    }

    public long getDifferenceAsLong(long j11, long j12) {
        if (j11 < j12) {
            return (long) (-getDifference(j12, j11));
        }
        int year = this.f23081d.getYear(j11);
        int monthOfYear = this.f23081d.getMonthOfYear(j11, year);
        int year2 = this.f23081d.getYear(j12);
        int monthOfYear2 = this.f23081d.getMonthOfYear(j12, year2);
        long j13 = ((((long) (year - year2)) * ((long) this.f23082e)) + ((long) monthOfYear)) - ((long) monthOfYear2);
        int dayOfMonth = this.f23081d.getDayOfMonth(j11, year, monthOfYear);
        if (dayOfMonth == this.f23081d.getDaysInYearMonth(year, monthOfYear) && this.f23081d.getDayOfMonth(j12, year2, monthOfYear2) > dayOfMonth) {
            j12 = this.f23081d.dayOfMonth().set(j12, dayOfMonth);
        }
        return j11 - this.f23081d.getYearMonthMillis(year, monthOfYear) < j12 - this.f23081d.getYearMonthMillis(year2, monthOfYear2) ? j13 - 1 : j13;
    }

    public int getLeapAmount(long j11) {
        return isLeap(j11) ? 1 : 0;
    }

    public DurationField getLeapDurationField() {
        return this.f23081d.days();
    }

    public int getMaximumValue() {
        return this.f23082e;
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.f23081d.years();
    }

    public boolean isLeap(long j11) {
        int year = this.f23081d.getYear(j11);
        if (!this.f23081d.isLeapYear(year) || this.f23081d.getMonthOfYear(j11, year) != this.f23083f) {
            return false;
        }
        return true;
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j11) {
        return j11 - roundFloor(j11);
    }

    public long roundFloor(long j11) {
        int year = this.f23081d.getYear(j11);
        return this.f23081d.getYearMonthMillis(year, this.f23081d.getMonthOfYear(j11, year));
    }

    public long set(long j11, int i11) {
        e.m(this, i11, 1, this.f23082e);
        int year = this.f23081d.getYear(j11);
        int dayOfMonth = this.f23081d.getDayOfMonth(j11, year);
        int daysInYearMonth = this.f23081d.getDaysInYearMonth(year, i11);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.f23081d.getYearMonthDayMillis(year, i11, dayOfMonth) + ((long) this.f23081d.getMillisOfDay(j11));
    }

    public long add(long j11, long j12) {
        long j13;
        long j14;
        long j15 = j11;
        long j16 = j12;
        int i11 = (int) j16;
        if (((long) i11) == j16) {
            return add(j15, i11);
        }
        long millisOfDay = (long) this.f23081d.getMillisOfDay(j15);
        int year = this.f23081d.getYear(j15);
        int monthOfYear = this.f23081d.getMonthOfYear(j15, year);
        long j17 = ((long) (monthOfYear - 1)) + j16;
        if (j17 >= 0) {
            int i12 = this.f23082e;
            j13 = ((long) year) + (j17 / ((long) i12));
            j14 = (j17 % ((long) i12)) + 1;
        } else {
            j13 = (((long) year) + (j17 / ((long) this.f23082e))) - 1;
            long abs = Math.abs(j17);
            int i13 = this.f23082e;
            int i14 = (int) (abs % ((long) i13));
            if (i14 == 0) {
                i14 = i13;
            }
            j14 = (long) ((i13 - i14) + 1);
            if (j14 == 1) {
                j13++;
            }
        }
        if (j13 < ((long) this.f23081d.getMinYear()) || j13 > ((long) this.f23081d.getMaxYear())) {
            throw new IllegalArgumentException("Magnitude of add amount is too large: " + j16);
        }
        int i15 = (int) j13;
        int i16 = (int) j14;
        int dayOfMonth = this.f23081d.getDayOfMonth(j15, year, monthOfYear);
        int daysInYearMonth = this.f23081d.getDaysInYearMonth(i15, i16);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.f23081d.getYearMonthDayMillis(i15, i16, dayOfMonth) + millisOfDay;
    }

    public int[] add(h hVar, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            return iArr;
        }
        if (hVar.size() > 0 && hVar.getFieldType(0).equals(DateTimeFieldType.monthOfYear()) && i11 == 0) {
            return set(hVar, 0, iArr, ((((hVar.getValue(0) - 1) + (i12 % 12)) + 12) % 12) + 1);
        }
        if (!a.n(hVar)) {
            return super.add(hVar, i11, iArr, i12);
        }
        long j11 = 0;
        int size = hVar.size();
        for (int i13 = 0; i13 < size; i13++) {
            j11 = hVar.getFieldType(i13).getField(this.f23081d).set(j11, iArr[i13]);
        }
        return this.f23081d.get(hVar, add(j11, i12));
    }
}
