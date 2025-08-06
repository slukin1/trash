package org.joda.time.chrono;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.UnsupportedDateTimeField;
import org.joda.time.field.UnsupportedDurationField;
import org.joda.time.field.e;
import org.joda.time.h;
import org.joda.time.i;

public abstract class BaseChronology extends Chronology implements Serializable {
    private static final long serialVersionUID = -7310865996721419676L;

    public long add(i iVar, long j11, int i11) {
        if (!(i11 == 0 || iVar == null)) {
            int size = iVar.size();
            for (int i12 = 0; i12 < size; i12++) {
                long value = (long) iVar.getValue(i12);
                if (value != 0) {
                    j11 = iVar.getFieldType(i12).getField(this).add(j11, value * ((long) i11));
                }
            }
        }
        return j11;
    }

    public DurationField centuries() {
        return UnsupportedDurationField.getInstance(DurationFieldType.centuries());
    }

    public DateTimeField centuryOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.centuryOfEra(), centuries());
    }

    public DateTimeField clockhourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfDay(), hours());
    }

    public DateTimeField clockhourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfHalfday(), hours());
    }

    public DateTimeField dayOfMonth() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfMonth(), days());
    }

    public DateTimeField dayOfWeek() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfWeek(), days());
    }

    public DateTimeField dayOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfYear(), days());
    }

    public DurationField days() {
        return UnsupportedDurationField.getInstance(DurationFieldType.days());
    }

    public DateTimeField era() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.era(), eras());
    }

    public DurationField eras() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    public int[] get(h hVar, long j11) {
        int size = hVar.size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = hVar.getFieldType(i11).getField(this).get(j11);
        }
        return iArr;
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        return millisOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0, i11), i12), i13), i14);
    }

    public abstract DateTimeZone getZone();

    public DateTimeField halfdayOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.halfdayOfDay(), halfdays());
    }

    public DurationField halfdays() {
        return UnsupportedDurationField.getInstance(DurationFieldType.halfdays());
    }

    public DateTimeField hourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfDay(), hours());
    }

    public DateTimeField hourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfHalfday(), hours());
    }

    public DurationField hours() {
        return UnsupportedDurationField.getInstance(DurationFieldType.hours());
    }

    public DurationField millis() {
        return UnsupportedDurationField.getInstance(DurationFieldType.millis());
    }

    public DateTimeField millisOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfDay(), millis());
    }

    public DateTimeField millisOfSecond() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfSecond(), millis());
    }

    public DateTimeField minuteOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfDay(), minutes());
    }

    public DateTimeField minuteOfHour() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfHour(), minutes());
    }

    public DurationField minutes() {
        return UnsupportedDurationField.getInstance(DurationFieldType.minutes());
    }

    public DateTimeField monthOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.monthOfYear(), months());
    }

    public DurationField months() {
        return UnsupportedDurationField.getInstance(DurationFieldType.months());
    }

    public DateTimeField secondOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfDay(), seconds());
    }

    public DateTimeField secondOfMinute() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfMinute(), seconds());
    }

    public DurationField seconds() {
        return UnsupportedDurationField.getInstance(DurationFieldType.seconds());
    }

    public long set(h hVar, long j11) {
        int size = hVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            j11 = hVar.getFieldType(i11).getField(this).set(j11, hVar.getValue(i11));
        }
        return j11;
    }

    public abstract String toString();

    public void validate(h hVar, int[] iArr) {
        int size = hVar.size();
        int i11 = 0;
        int i12 = 0;
        while (i12 < size) {
            int i13 = iArr[i12];
            DateTimeField field = hVar.getField(i12);
            if (i13 < field.getMinimumValue()) {
                throw new IllegalFieldValueException(field.getType(), (Number) Integer.valueOf(i13), (Number) Integer.valueOf(field.getMinimumValue()), (Number) null);
            } else if (i13 <= field.getMaximumValue()) {
                i12++;
            } else {
                throw new IllegalFieldValueException(field.getType(), (Number) Integer.valueOf(i13), (Number) null, (Number) Integer.valueOf(field.getMaximumValue()));
            }
        }
        while (i11 < size) {
            int i14 = iArr[i11];
            DateTimeField field2 = hVar.getField(i11);
            if (i14 < field2.getMinimumValue(hVar, iArr)) {
                throw new IllegalFieldValueException(field2.getType(), (Number) Integer.valueOf(i14), (Number) Integer.valueOf(field2.getMinimumValue(hVar, iArr)), (Number) null);
            } else if (i14 <= field2.getMaximumValue(hVar, iArr)) {
                i11++;
            } else {
                throw new IllegalFieldValueException(field2.getType(), (Number) Integer.valueOf(i14), (Number) null, (Number) Integer.valueOf(field2.getMaximumValue(hVar, iArr)));
            }
        }
    }

    public DateTimeField weekOfWeekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekOfWeekyear(), weeks());
    }

    public DurationField weeks() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weeks());
    }

    public DateTimeField weekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyear(), weekyears());
    }

    public DateTimeField weekyearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyearOfCentury(), weekyears());
    }

    public DurationField weekyears() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weekyears());
    }

    public abstract Chronology withUTC();

    public abstract Chronology withZone(DateTimeZone dateTimeZone);

    public DateTimeField year() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.year(), years());
    }

    public DateTimeField yearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfCentury(), years());
    }

    public DateTimeField yearOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfEra(), years());
    }

    public DurationField years() {
        return UnsupportedDurationField.getInstance(DurationFieldType.years());
    }

    public long add(long j11, long j12, int i11) {
        return (j12 == 0 || i11 == 0) ? j11 : e.e(j11, e.h(j12, i11));
    }

    public int[] get(i iVar, long j11, long j12) {
        int size = iVar.size();
        int[] iArr = new int[size];
        if (j11 != j12) {
            for (int i11 = 0; i11 < size; i11++) {
                DurationField field = iVar.getFieldType(i11).getField(this);
                int difference = field.getDifference(j12, j11);
                if (difference != 0) {
                    j11 = field.add(j11, difference);
                }
                iArr[i11] = difference;
            }
        }
        return iArr;
    }

    public long getDateTimeMillis(int i11, int i12, int i13, int i14, int i15, int i16, int i17) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0, i11), i12), i13), i14), i15), i16), i17);
    }

    public int[] get(i iVar, long j11) {
        int size = iVar.size();
        int[] iArr = new int[size];
        long j12 = 0;
        if (j11 != 0) {
            for (int i11 = 0; i11 < size; i11++) {
                DurationField field = iVar.getFieldType(i11).getField(this);
                if (field.isPrecise()) {
                    int difference = field.getDifference(j11, j12);
                    j12 = field.add(j12, difference);
                    iArr[i11] = difference;
                }
            }
        }
        return iArr;
    }

    public long getDateTimeMillis(long j11, int i11, int i12, int i13, int i14) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(j11, i11), i12), i13), i14);
    }
}
