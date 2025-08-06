package com.google.firebase.heartbeatinfo;

import java.util.Objects;

final class AutoValue_SdkHeartBeatResult extends SdkHeartBeatResult {
    private final long millis;
    private final String sdkName;

    public AutoValue_SdkHeartBeatResult(String str, long j11) {
        Objects.requireNonNull(str, "Null sdkName");
        this.sdkName = str;
        this.millis = j11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SdkHeartBeatResult)) {
            return false;
        }
        SdkHeartBeatResult sdkHeartBeatResult = (SdkHeartBeatResult) obj;
        if (!this.sdkName.equals(sdkHeartBeatResult.getSdkName()) || this.millis != sdkHeartBeatResult.getMillis()) {
            return false;
        }
        return true;
    }

    public long getMillis() {
        return this.millis;
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public int hashCode() {
        long j11 = this.millis;
        return ((this.sdkName.hashCode() ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "SdkHeartBeatResult{sdkName=" + this.sdkName + ", millis=" + this.millis + "}";
    }
}
