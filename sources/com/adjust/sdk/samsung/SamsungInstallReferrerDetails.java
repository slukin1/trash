package com.adjust.sdk.samsung;

import com.adjust.sdk.Util;

public class SamsungInstallReferrerDetails {
    public long installBeginTimestampSeconds;
    public String installReferrer;
    public long referrerClickTimestampSeconds;

    public SamsungInstallReferrerDetails(String str, long j11, long j12) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j11;
        this.installBeginTimestampSeconds = j12;
    }

    public String toString() {
        return Util.formatString(" installReferrer : %s referrerClickTimestampSeconds : %d installBeginTimestampSeconds : %d", this.installReferrer, Long.valueOf(this.referrerClickTimestampSeconds), Long.valueOf(this.installBeginTimestampSeconds));
    }
}
