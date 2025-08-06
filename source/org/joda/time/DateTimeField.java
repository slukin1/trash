package org.joda.time;

import java.util.Locale;

public abstract class DateTimeField {
    public abstract long add(long j11, int i11);

    public abstract long add(long j11, long j12);

    public abstract int[] add(h hVar, int i11, int[] iArr, int i12);

    public abstract long addWrapField(long j11, int i11);

    public abstract int[] addWrapField(h hVar, int i11, int[] iArr, int i12);

    public abstract int[] addWrapPartial(h hVar, int i11, int[] iArr, int i12);

    public abstract int get(long j11);

    public abstract String getAsShortText(int i11, Locale locale);

    public abstract String getAsShortText(long j11);

    public abstract String getAsShortText(long j11, Locale locale);

    public abstract String getAsShortText(h hVar, int i11, Locale locale);

    public abstract String getAsShortText(h hVar, Locale locale);

    public abstract String getAsText(int i11, Locale locale);

    public abstract String getAsText(long j11);

    public abstract String getAsText(long j11, Locale locale);

    public abstract String getAsText(h hVar, int i11, Locale locale);

    public abstract String getAsText(h hVar, Locale locale);

    public abstract int getDifference(long j11, long j12);

    public abstract long getDifferenceAsLong(long j11, long j12);

    public abstract DurationField getDurationField();

    public abstract int getLeapAmount(long j11);

    public abstract DurationField getLeapDurationField();

    public abstract int getMaximumShortTextLength(Locale locale);

    public abstract int getMaximumTextLength(Locale locale);

    public abstract int getMaximumValue();

    public abstract int getMaximumValue(long j11);

    public abstract int getMaximumValue(h hVar);

    public abstract int getMaximumValue(h hVar, int[] iArr);

    public abstract int getMinimumValue();

    public abstract int getMinimumValue(long j11);

    public abstract int getMinimumValue(h hVar);

    public abstract int getMinimumValue(h hVar, int[] iArr);

    public abstract String getName();

    public abstract DurationField getRangeDurationField();

    public abstract DateTimeFieldType getType();

    public abstract boolean isLeap(long j11);

    public abstract boolean isLenient();

    public abstract boolean isSupported();

    public abstract long remainder(long j11);

    public abstract long roundCeiling(long j11);

    public abstract long roundFloor(long j11);

    public abstract long roundHalfCeiling(long j11);

    public abstract long roundHalfEven(long j11);

    public abstract long roundHalfFloor(long j11);

    public abstract long set(long j11, int i11);

    public abstract long set(long j11, String str);

    public abstract long set(long j11, String str, Locale locale);

    public abstract int[] set(h hVar, int i11, int[] iArr, int i12);

    public abstract int[] set(h hVar, int i11, int[] iArr, String str, Locale locale);

    public abstract String toString();
}
