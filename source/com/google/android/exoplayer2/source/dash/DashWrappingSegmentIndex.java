package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;

public final class DashWrappingSegmentIndex implements DashSegmentIndex {
    private final ChunkIndex chunkIndex;
    private final long timeOffsetUs;

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex2, long j11) {
        this.chunkIndex = chunkIndex2;
        this.timeOffsetUs = j11;
    }

    public long getAvailableSegmentCount(long j11, long j12) {
        return (long) this.chunkIndex.length;
    }

    public long getDurationUs(long j11, long j12) {
        return this.chunkIndex.durationsUs[(int) j11];
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
        return (long) this.chunkIndex.length;
    }

    public long getSegmentNum(long j11, long j12) {
        return (long) this.chunkIndex.getChunkIndex(j11 + this.timeOffsetUs);
    }

    public RangedUri getSegmentUrl(long j11) {
        ChunkIndex chunkIndex2 = this.chunkIndex;
        int i11 = (int) j11;
        return new RangedUri((String) null, chunkIndex2.offsets[i11], (long) chunkIndex2.sizes[i11]);
    }

    public long getTimeUs(long j11) {
        return this.chunkIndex.timesUs[(int) j11] - this.timeOffsetUs;
    }

    public boolean isExplicit() {
        return true;
    }
}
