package org.joda.time;

import java.util.SimpleTimeZone;
import java.util.TimeZone;

final class UTCDateTimeZone extends DateTimeZone {
    public static final DateTimeZone INSTANCE = new UTCDateTimeZone();
    private static final long serialVersionUID = -3513011772763289092L;

    public UTCDateTimeZone() {
        super(UtcDates.UTC);
    }

    public boolean equals(Object obj) {
        return obj instanceof UTCDateTimeZone;
    }

    public String getNameKey(long j11) {
        return UtcDates.UTC;
    }

    public int getOffset(long j11) {
        return 0;
    }

    public int getOffsetFromLocal(long j11) {
        return 0;
    }

    public int getStandardOffset(long j11) {
        return 0;
    }

    public int hashCode() {
        return getID().hashCode();
    }

    public boolean isFixed() {
        return true;
    }

    public long nextTransition(long j11) {
        return j11;
    }

    public long previousTransition(long j11) {
        return j11;
    }

    public TimeZone toTimeZone() {
        return new SimpleTimeZone(0, getID());
    }
}
