package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() {
        public Month createFromParcel(Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        public Month[] newArray(int i11) {
            return new Month[i11];
        }
    };
    public final int daysInMonth;
    public final int daysInWeek;
    private final Calendar firstOfMonth;
    private String longName;
    public final int month;
    public final long timeInMillis;
    public final int year;

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar dayCopy = UtcDates.getDayCopy(calendar);
        this.firstOfMonth = dayCopy;
        this.month = dayCopy.get(2);
        this.year = dayCopy.get(1);
        this.daysInWeek = dayCopy.getMaximum(7);
        this.daysInMonth = dayCopy.getActualMaximum(5);
        this.timeInMillis = dayCopy.getTimeInMillis();
    }

    public static Month create(long j11) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j11);
        return new Month(utcCalendar);
    }

    public static Month current() {
        return new Month(UtcDates.getTodayCalendar());
    }

    public int daysFromStartOfWeekToFirstOfMonth() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.daysInWeek : firstDayOfWeek;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month2 = (Month) obj;
        if (this.month == month2.month && this.year == month2.year) {
            return true;
        }
        return false;
    }

    public long getDay(int i11) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.set(5, i11);
        return dayCopy.getTimeInMillis();
    }

    public int getDayOfMonth(long j11) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.setTimeInMillis(j11);
        return dayCopy.get(5);
    }

    public String getLongName(Context context) {
        if (this.longName == null) {
            this.longName = DateStrings.getYearMonth(context, this.firstOfMonth.getTimeInMillis());
        }
        return this.longName;
    }

    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    public Month monthsLater(int i11) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.add(2, i11);
        return new Month(dayCopy);
    }

    public int monthsUntil(Month month2) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month2.year - this.year) * 12) + (month2.month - this.month);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }

    public int compareTo(Month month2) {
        return this.firstOfMonth.compareTo(month2.firstOfMonth);
    }

    public static Month create(int i11, int i12) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.set(1, i11);
        utcCalendar.set(2, i12);
        return new Month(utcCalendar);
    }
}
