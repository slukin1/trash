package com.adjust.sdk.huawei;

import com.adjust.sdk.Util;

public class HuaweiInstallReferrerDetails {
    public long installBeginTimestampSeconds;
    public String installReferrer;
    public long referrerClickTimestampSeconds;

    public HuaweiInstallReferrerDetails(String str, long j11, long j12) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j11;
        this.installBeginTimestampSeconds = j12;
    }

    public String toString() {
        return Util.formatString(" installReferrer : %s referrerClickTimestampSeconds : %d installBeginTimestampSeconds : %d", this.installReferrer, Long.valueOf(this.referrerClickTimestampSeconds), Long.valueOf(this.installBeginTimestampSeconds));
    }
}
