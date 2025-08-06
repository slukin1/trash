package com.adjust.sdk;

public class ReferrerDetails {
    public Boolean googlePlayInstant;
    public long installBeginTimestampSeconds;
    public long installBeginTimestampServerSeconds;
    public String installReferrer;
    public String installVersion;
    public Boolean isClick;
    public long referrerClickTimestampSeconds;
    public long referrerClickTimestampServerSeconds;

    public ReferrerDetails(String str, long j11, long j12) {
        this(str, j11, j12, -1, -1, (String) null, (Boolean) null, (Boolean) null);
    }

    public String toString() {
        return Util.formatString(" installReferrer : %s referrerClickTimestampSeconds : %d installBeginTimestampSeconds : %d referrerClickTimestampServerSeconds : %d installBeginTimestampServerSeconds : %d installVersion : %s googlePlayInstant : %s isClick: %s", this.installReferrer, Long.valueOf(this.referrerClickTimestampSeconds), Long.valueOf(this.installBeginTimestampSeconds), Long.valueOf(this.referrerClickTimestampServerSeconds), Long.valueOf(this.installBeginTimestampServerSeconds), this.installVersion, this.googlePlayInstant, this.isClick);
    }

    public ReferrerDetails(String str, long j11, long j12, long j13, long j14, String str2, Boolean bool, Boolean bool2) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j11;
        this.installBeginTimestampSeconds = j12;
        this.referrerClickTimestampServerSeconds = j13;
        this.installBeginTimestampServerSeconds = j14;
        this.installVersion = str2;
        this.googlePlayInstant = bool;
        this.isClick = bool2;
    }

    public ReferrerDetails(String str, long j11, Boolean bool) {
        this(str, j11, -1, -1, -1, (String) null, (Boolean) null, bool);
    }
}
