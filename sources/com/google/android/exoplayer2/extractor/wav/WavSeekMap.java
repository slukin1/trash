package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

final class WavSeekMap implements SeekMap {
    private final long blockCount;
    private final long durationUs;
    private final long firstBlockPosition;
    private final int framesPerBlock;
    private final WavHeader wavHeader;

    public WavSeekMap(WavHeader wavHeader2, int i11, long j11, long j12) {
        this.wavHeader = wavHeader2;
        this.framesPerBlock = i11;
        this.firstBlockPosition = j11;
        long j13 = (j12 - j11) / ((long) wavHeader2.blockSize);
        this.blockCount = j13;
        this.durationUs = blockIndexToTimeUs(j13);
    }

    private long blockIndexToTimeUs(long j11) {
        return Util.scaleLargeTimestamp(j11 * ((long) this.framesPerBlock), 1000000, (long) this.wavHeader.frameRateHz);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        long constrainValue = Util.constrainValue((((long) this.wavHeader.frameRateHz) * j11) / (((long) this.framesPerBlock) * 1000000), 0, this.blockCount - 1);
        long j12 = this.firstBlockPosition + (((long) this.wavHeader.blockSize) * constrainValue);
        long blockIndexToTimeUs = blockIndexToTimeUs(constrainValue);
        SeekPoint seekPoint = new SeekPoint(blockIndexToTimeUs, j12);
        if (blockIndexToTimeUs >= j11 || constrainValue == this.blockCount - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        long j13 = constrainValue + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(blockIndexToTimeUs(j13), this.firstBlockPosition + (((long) this.wavHeader.blockSize) * j13)));
    }

    public boolean isSeekable() {
        return true;
    }
}
