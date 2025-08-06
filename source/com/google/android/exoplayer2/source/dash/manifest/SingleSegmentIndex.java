package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.DashSegmentIndex;

final class SingleSegmentIndex implements DashSegmentIndex {
    private final RangedUri uri;

    public SingleSegmentIndex(RangedUri rangedUri) {
        this.uri = rangedUri;
    }

    public long getAvailableSegmentCount(long j11, long j12) {
        return 1;
    }

    public long getDurationUs(long j11, long j12) {
        return j12;
    }

    public long getFirstAvailableSegmentNum(long j11, long j12) {
        return 0;
    }

    public long getFirstSegmentNum() {
        return 0;
    }

    public long getNextSegmentAvailableTimeUs(long j11, long j12) {
        return -9223372036854775807L;
    }

    public long getSegmentCount(long j11) {
        return 1;
    }

    public long getSegmentNum(long j11, long j12) {
        return 0;
    }

    public RangedUri getSegmentUrl(long j11) {
        return this.uri;
    }

    public long getTimeUs(long j11) {
        return 0;
    }

    public boolean isExplicit() {
        return true;
    }
}
