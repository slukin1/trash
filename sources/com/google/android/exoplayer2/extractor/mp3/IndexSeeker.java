package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.Util;

final class IndexSeeker implements Seeker {
    public static final long MIN_TIME_BETWEEN_POINTS_US = 100000;
    private final long dataEndPosition;
    private long durationUs;
    private final LongArray positions;
    private final LongArray timesUs;

    public IndexSeeker(long j11, long j12, long j13) {
        this.durationUs = j11;
        this.dataEndPosition = j13;
        LongArray longArray = new LongArray();
        this.timesUs = longArray;
        LongArray longArray2 = new LongArray();
        this.positions = longArray2;
        longArray.add(0);
        longArray2.add(j12);
    }

    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j11, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs.get(binarySearchFloor), this.positions.get(binarySearchFloor));
        if (seekPoint.timeUs == j11 || binarySearchFloor == this.timesUs.size() - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i11 = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs.get(i11), this.positions.get(i11)));
    }

    public long getTimeUs(long j11) {
        return this.timesUs.get(Util.binarySearchFloor(this.positions, j11, true, true));
    }

    public boolean isSeekable() {
        return true;
    }

    public boolean isTimeUsInIndex(long j11) {
        LongArray longArray = this.timesUs;
        return j11 - longArray.get(longArray.size() - 1) < MIN_TIME_BETWEEN_POINTS_US;
    }

    public void maybeAddSeekPoint(long j11, long j12) {
        if (!isTimeUsInIndex(j11)) {
            this.timesUs.add(j11);
            this.positions.add(j12);
        }
    }

    public void setDurationUs(long j11) {
        this.durationUs = j11;
    }
}
