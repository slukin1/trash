package org.joda.time.chrono;

import org.joda.time.Chronology;

abstract class BasicFixedMonthChronology extends BasicChronology {
    public static final long MILLIS_PER_MONTH = 2592000000L;
    public static final long MILLIS_PER_YEAR = 31557600000L;
    public static final int MONTH_LENGTH = 30;
    private static final long serialVersionUID = 261387371998L;

    public BasicFixedMonthChronology(Chronology chronology, Object obj, int i11) {
        super(chronology, obj, i11);
    }

    public long getAverageMillisPerMonth() {
        return 2592000000L;
    }

    public long getAverageMillisPerYear() {
        return MILLIS_PER_YEAR;
    }

    public long getAverageMillisPerYearDividedByTwo() {
        return 15778800000L;
    }

    public int getDayOfMonth(long j11) {
        return ((getDayOfYear(j11) - 1) % 30) + 1;
    }

    public int getDaysInMonthMax() {
        return 30;
    }

    public int getDaysInMonthMax(int i11) {
        return i11 != 13 ? 30 : 6;
    }

    public int getDaysInYearMonth(int i11, int i12) {
        if (i12 != 13) {
            return 30;
        }
        return isLeapYear(i11) ? 6 : 5;
    }

    public int getMaxMonth() {
        return 13;
    }

    public int getMonthOfYear(long j11) {
        return ((getDayOfYear(j11) - 1) / 30) + 1;
    }

    public long getTotalMillisByYearMonth(int i11, int i12) {
        return ((long) (i12 - 1)) * 2592000000L;
    }

    public long getYearDifference(long j11, long j12) {
        int year = getYear(j11);
        int year2 = getYear(j12);
        int i11 = year - year2;
        if (j11 - getYearMillis(year) < j12 - getYearMillis(year2)) {
            i11--;
        }
        return (long) i11;
    }

    public boolean isLeapYear(int i11) {
        return (i11 & 3) == 3;
    }

    public long setYear(long j11, int i11) {
        int dayOfYear = getDayOfYear(j11, getYear(j11));
        int millisOfDay = getMillisOfDay(j11);
        if (dayOfYear > 365 && !isLeapYear(i11)) {
            dayOfYear--;
        }
        return getYearMonthDayMillis(i11, 1, dayOfYear) + ((long) millisOfDay);
    }

    public int getMonthOfYear(long j11, int i11) {
        return ((int) ((j11 - getYearMillis(i11)) / 2592000000L)) + 1;
    }
}
