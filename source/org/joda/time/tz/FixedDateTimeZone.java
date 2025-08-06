package org.joda.time.tz;

import com.xiaomi.mipush.sdk.Constants;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.joda.time.DateTimeZone;

public final class FixedDateTimeZone extends DateTimeZone {
    private static final long serialVersionUID = -3513011772763289092L;
    private final String iNameKey;
    private final int iStandardOffset;
    private final int iWallOffset;

    public FixedDateTimeZone(String str, String str2, int i11, int i12) {
        super(str);
        this.iNameKey = str2;
        this.iWallOffset = i11;
        this.iStandardOffset = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDateTimeZone)) {
            return false;
        }
        FixedDateTimeZone fixedDateTimeZone = (FixedDateTimeZone) obj;
        if (getID().equals(fixedDateTimeZone.getID()) && this.iStandardOffset == fixedDateTimeZone.iStandardOffset && this.iWallOffset == fixedDateTimeZone.iWallOffset) {
            return true;
        }
        return false;
    }

    public String getNameKey(long j11) {
        return this.iNameKey;
    }

    public int getOffset(long j11) {
        return this.iWallOffset;
    }

    public int getOffsetFromLocal(long j11) {
        return this.iWallOffset;
    }

    public int getStandardOffset(long j11) {
        return this.iStandardOffset;
    }

    public int hashCode() {
        return getID().hashCode() + (this.iStandardOffset * 37) + (this.iWallOffset * 31);
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
        String id2 = getID();
        if (id2.length() != 6 || (!id2.startsWith("+") && !id2.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER))) {
            return new SimpleTimeZone(this.iWallOffset, getID());
        }
        return TimeZone.getTimeZone("GMT" + getID());
    }
}
