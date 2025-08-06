package org.joda.time;

public abstract class Chronology {
    public abstract long add(long j11, long j12, int i11);

    public abstract long add(i iVar, long j11, int i11);

    public abstract DurationField centuries();

    public abstract DateTimeField centuryOfEra();

    public abstract DateTimeField clockhourOfDay();

    public abstract DateTimeField clockhourOfHalfday();

    public abstract DateTimeField dayOfMonth();

    public abstract DateTimeField dayOfWeek();

    public abstract DateTimeField dayOfYear();

    public abstract DurationField days();

    public abstract DateTimeField era();

    public abstract DurationField eras();

    public abstract int[] get(h hVar, long j11);

    public abstract int[] get(i iVar, long j11);

    public abstract int[] get(i iVar, long j11, long j12);

    public abstract long getDateTimeMillis(int i11, int i12, int i13, int i14);

    public abstract long getDateTimeMillis(int i11, int i12, int i13, int i14, int i15, int i16, int i17);

    public abstract long getDateTimeMillis(long j11, int i11, int i12, int i13, int i14);

    public abstract DateTimeZone getZone();

    public abstract DateTimeField halfdayOfDay();

    public abstract DurationField halfdays();

    public abstract DateTimeField hourOfDay();

    public abstract DateTimeField hourOfHalfday();

    public abstract DurationField hours();

    public abstract DurationField millis();

    public abstract DateTimeField millisOfDay();

    public abstract DateTimeField millisOfSecond();

    public abstract DateTimeField minuteOfDay();

    public abstract DateTimeField minuteOfHour();

    public abstract DurationField minutes();

    public abstract DateTimeField monthOfYear();

    public abstract DurationField months();

    public abstract DateTimeField secondOfDay();

    public abstract DateTimeField secondOfMinute();

    public abstract DurationField seconds();

    public abstract long set(h hVar, long j11);

    public abstract String toString();

    public abstract void validate(h hVar, int[] iArr);

    public abstract DateTimeField weekOfWeekyear();

    public abstract DurationField weeks();

    public abstract DateTimeField weekyear();

    public abstract DateTimeField weekyearOfCentury();

    public abstract DurationField weekyears();

    public abstract Chronology withUTC();

    public abstract Chronology withZone(DateTimeZone dateTimeZone);

    public abstract DateTimeField year();

    public abstract DateTimeField yearOfCentury();

    public abstract DateTimeField yearOfEra();

    public abstract DurationField years();
}
