package org.joda.time.field;

import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.h;

public abstract class b extends DateTimeField {

    /* renamed from: a  reason: collision with root package name */
    public final DateTimeFieldType f23113a;

    public b(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            this.f23113a = dateTimeFieldType;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public int a(String str, Locale locale) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new IllegalFieldValueException(getType(), str);
        }
    }

    public long add(long j11, int i11) {
        return getDurationField().add(j11, i11);
    }

    public long addWrapField(long j11, int i11) {
        return set(j11, e.c(get(j11), i11, getMinimumValue(j11), getMaximumValue(j11)));
    }

    public int[] addWrapPartial(h hVar, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            return iArr;
        }
        DateTimeField dateTimeField = null;
        while (true) {
            if (i12 <= 0) {
                break;
            }
            int maximumValue = getMaximumValue(hVar, iArr);
            long j11 = (long) (iArr[i11] + i12);
            if (j11 <= ((long) maximumValue)) {
                iArr[i11] = (int) j11;
                break;
            }
            if (dateTimeField == null) {
                if (i11 == 0) {
                    i12 -= (maximumValue + 1) - iArr[i11];
                    iArr[i11] = getMinimumValue(hVar, iArr);
                } else {
                    dateTimeField = hVar.getField(i11 - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                }
            }
            i12 -= (maximumValue + 1) - iArr[i11];
            iArr = dateTimeField.addWrapPartial(hVar, i11 - 1, iArr, 1);
            iArr[i11] = getMinimumValue(hVar, iArr);
        }
        while (true) {
            if (i12 >= 0) {
                break;
            }
            int minimumValue = getMinimumValue(hVar, iArr);
            long j12 = (long) (iArr[i11] + i12);
            if (j12 >= ((long) minimumValue)) {
                iArr[i11] = (int) j12;
                break;
            }
            if (dateTimeField == null) {
                if (i11 == 0) {
                    r11 = i12 - ((minimumValue - 1) - iArr[i11]);
                    iArr[i11] = getMaximumValue(hVar, iArr);
                } else {
                    dateTimeField = hVar.getField(i11 - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                }
            }
            r11 = i12 - ((minimumValue - 1) - iArr[i11]);
            iArr = dateTimeField.addWrapPartial(hVar, i11 - 1, iArr, -1);
            iArr[i11] = getMaximumValue(hVar, iArr);
        }
        return set(hVar, i11, iArr, iArr[i11]);
    }

    public abstract int get(long j11);

    public String getAsShortText(long j11, Locale locale) {
        return getAsShortText(get(j11), locale);
    }

    public String getAsText(long j11, Locale locale) {
        return getAsText(get(j11), locale);
    }

    public int getDifference(long j11, long j12) {
        return getDurationField().getDifference(j11, j12);
    }

    public long getDifferenceAsLong(long j11, long j12) {
        return getDurationField().getDifferenceAsLong(j11, j12);
    }

    public abstract DurationField getDurationField();

    public int getLeapAmount(long j11) {
        return 0;
    }

    public DurationField getLeapDurationField() {
        return null;
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getMaximumTextLength(locale);
    }

    public int getMaximumTextLength(Locale locale) {
        int maximumValue = getMaximumValue();
        if (maximumValue >= 0) {
            if (maximumValue < 10) {
                return 1;
            }
            if (maximumValue < 100) {
                return 2;
            }
            if (maximumValue < 1000) {
                return 3;
            }
        }
        return Integer.toString(maximumValue).length();
    }

    public abstract int getMaximumValue();

    public int getMaximumValue(long j11) {
        return getMaximumValue();
    }

    public abstract int getMinimumValue();

    public int getMinimumValue(long j11) {
        return getMinimumValue();
    }

    public final String getName() {
        return this.f23113a.getName();
    }

    public abstract DurationField getRangeDurationField();

    public final DateTimeFieldType getType() {
        return this.f23113a;
    }

    public boolean isLeap(long j11) {
        return false;
    }

    public final boolean isSupported() {
        return true;
    }

    public long remainder(long j11) {
        return j11 - roundFloor(j11);
    }

    public long roundCeiling(long j11) {
        long roundFloor = roundFloor(j11);
        return roundFloor != j11 ? add(roundFloor, 1) : j11;
    }

    public abstract long roundFloor(long j11);

    public long roundHalfCeiling(long j11) {
        long roundFloor = roundFloor(j11);
        long roundCeiling = roundCeiling(j11);
        return roundCeiling - j11 <= j11 - roundFloor ? roundCeiling : roundFloor;
    }

    public long roundHalfEven(long j11) {
        long roundFloor = roundFloor(j11);
        long roundCeiling = roundCeiling(j11);
        long j12 = j11 - roundFloor;
        long j13 = roundCeiling - j11;
        if (j12 < j13) {
            return roundFloor;
        }
        return (j13 >= j12 && (get(roundCeiling) & 1) != 0) ? roundFloor : roundCeiling;
    }

    public long roundHalfFloor(long j11) {
        long roundFloor = roundFloor(j11);
        long roundCeiling = roundCeiling(j11);
        return j11 - roundFloor <= roundCeiling - j11 ? roundFloor : roundCeiling;
    }

    public abstract long set(long j11, int i11);

    public int[] set(h hVar, int i11, int[] iArr, int i12) {
        e.m(this, i12, getMinimumValue(hVar, iArr), getMaximumValue(hVar, iArr));
        iArr[i11] = i12;
        while (true) {
            i11++;
            if (i11 >= hVar.size()) {
                return iArr;
            }
            DateTimeField field = hVar.getField(i11);
            if (iArr[i11] > field.getMaximumValue(hVar, iArr)) {
                iArr[i11] = field.getMaximumValue(hVar, iArr);
            }
            if (iArr[i11] < field.getMinimumValue(hVar, iArr)) {
                iArr[i11] = field.getMinimumValue(hVar, iArr);
            }
        }
    }

    public String toString() {
        return "DateTimeField[" + getName() + ']';
    }

    public long add(long j11, long j12) {
        return getDurationField().add(j11, j12);
    }

    public final String getAsShortText(long j11) {
        return getAsShortText(j11, (Locale) null);
    }

    public final String getAsText(long j11) {
        return getAsText(j11, (Locale) null);
    }

    public int getMaximumValue(h hVar) {
        return getMaximumValue();
    }

    public int getMinimumValue(h hVar) {
        return getMinimumValue();
    }

    public int[] add(h hVar, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            return iArr;
        }
        DateTimeField dateTimeField = null;
        while (true) {
            if (i12 <= 0) {
                break;
            }
            int maximumValue = getMaximumValue(hVar, iArr);
            long j11 = (long) (iArr[i11] + i12);
            if (j11 <= ((long) maximumValue)) {
                iArr[i11] = (int) j11;
                break;
            }
            if (dateTimeField == null) {
                if (i11 != 0) {
                    dateTimeField = hVar.getField(i11 - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                } else {
                    throw new IllegalArgumentException("Maximum value exceeded for add");
                }
            }
            i12 -= (maximumValue + 1) - iArr[i11];
            iArr = dateTimeField.add(hVar, i11 - 1, iArr, 1);
            iArr[i11] = getMinimumValue(hVar, iArr);
        }
        while (true) {
            if (i12 >= 0) {
                break;
            }
            int minimumValue = getMinimumValue(hVar, iArr);
            long j12 = (long) (iArr[i11] + i12);
            if (j12 >= ((long) minimumValue)) {
                iArr[i11] = (int) j12;
                break;
            }
            if (dateTimeField == null) {
                if (i11 != 0) {
                    dateTimeField = hVar.getField(i11 - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                } else {
                    throw new IllegalArgumentException("Maximum value exceeded for add");
                }
            }
            i12 -= (minimumValue - 1) - iArr[i11];
            iArr = dateTimeField.add(hVar, i11 - 1, iArr, -1);
            iArr[i11] = getMaximumValue(hVar, iArr);
        }
        return set(hVar, i11, iArr, iArr[i11]);
    }

    public String getAsShortText(h hVar, int i11, Locale locale) {
        return getAsShortText(i11, locale);
    }

    public String getAsText(h hVar, int i11, Locale locale) {
        return getAsText(i11, locale);
    }

    public int getMaximumValue(h hVar, int[] iArr) {
        return getMaximumValue(hVar);
    }

    public int getMinimumValue(h hVar, int[] iArr) {
        return getMinimumValue(hVar);
    }

    public int[] addWrapField(h hVar, int i11, int[] iArr, int i12) {
        return set(hVar, i11, iArr, e.c(iArr[i11], i12, getMinimumValue(hVar), getMaximumValue(hVar)));
    }

    public final String getAsShortText(h hVar, Locale locale) {
        return getAsShortText(hVar, hVar.get(getType()), locale);
    }

    public final String getAsText(h hVar, Locale locale) {
        return getAsText(hVar, hVar.get(getType()), locale);
    }

    public String getAsShortText(int i11, Locale locale) {
        return getAsText(i11, locale);
    }

    public String getAsText(int i11, Locale locale) {
        return Integer.toString(i11);
    }

    public long set(long j11, String str, Locale locale) {
        return set(j11, a(str, locale));
    }

    public final long set(long j11, String str) {
        return set(j11, str, (Locale) null);
    }

    public int[] set(h hVar, int i11, int[] iArr, String str, Locale locale) {
        return set(hVar, i11, iArr, a(str, locale));
    }
}
