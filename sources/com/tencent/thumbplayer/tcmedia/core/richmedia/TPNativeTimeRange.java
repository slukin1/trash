package com.tencent.thumbplayer.tcmedia.core.richmedia;

public class TPNativeTimeRange {
    private long mEndTimeMs;
    private long mStartTimeMs;

    public TPNativeTimeRange(long j11, long j12) {
        this.mStartTimeMs = j11;
        this.mEndTimeMs = j12;
    }

    public long getEndTimeMs() {
        return this.mEndTimeMs;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public void setEndTimeMs(long j11) {
        this.mEndTimeMs = j11;
    }

    public void setStartTimeMs(long j11) {
        this.mStartTimeMs = j11;
    }
}
