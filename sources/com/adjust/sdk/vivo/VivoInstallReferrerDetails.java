package com.adjust.sdk.vivo;

import com.adjust.sdk.ReferrerDetails;
import com.adjust.sdk.Util;

public class VivoInstallReferrerDetails {
    public long installBeginTimestampSeconds;
    public String installReferrer;
    public String installVersion;
    public long referrerClickTimestampSeconds;

    public VivoInstallReferrerDetails(String str, long j11, long j12, String str2) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j11;
        this.installBeginTimestampSeconds = j12;
        this.installVersion = str2;
    }

    public String toString() {
        return Util.formatString(" installReferrer : %s referrerClickTimestampSeconds : %d installBeginTimestampSeconds : %d installVersion : %s", this.installReferrer, Long.valueOf(this.referrerClickTimestampSeconds), Long.valueOf(this.installBeginTimestampSeconds), this.installVersion);
    }

    public VivoInstallReferrerDetails(ReferrerDetails referrerDetails) {
        if (referrerDetails != null) {
            this.installReferrer = referrerDetails.installReferrer;
            this.referrerClickTimestampSeconds = referrerDetails.referrerClickTimestampSeconds;
            this.installBeginTimestampSeconds = referrerDetails.installBeginTimestampSeconds;
            this.installVersion = referrerDetails.installVersion;
        }
    }
}
