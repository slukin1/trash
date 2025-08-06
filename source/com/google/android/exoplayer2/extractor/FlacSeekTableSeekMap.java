package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class FlacSeekTableSeekMap implements SeekMap {
    private final long firstFrameOffset;
    private final FlacStreamMetadata flacStreamMetadata;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata2, long j11) {
        this.flacStreamMetadata = flacStreamMetadata2;
        this.firstFrameOffset = j11;
    }

    private SeekPoint getSeekPoint(long j11, long j12) {
        return new SeekPoint((j11 * 1000000) / ((long) this.flacStreamMetadata.sampleRate), this.firstFrameOffset + j12);
    }

    public long getDurationUs() {
        return this.flacStreamMetadata.getDurationUs();
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        long j12;
        Assertions.checkStateNotNull(this.flacStreamMetadata.seekTable);
        FlacStreamMetadata flacStreamMetadata2 = this.flacStreamMetadata;
        FlacStreamMetadata.SeekTable seekTable = flacStreamMetadata2.seekTable;
        long[] jArr = seekTable.pointSampleNumbers;
        long[] jArr2 = seekTable.pointOffsets;
        int binarySearchFloor = Util.binarySearchFloor(jArr, flacStreamMetadata2.getSampleNumber(j11), true, false);
        long j13 = 0;
        if (binarySearchFloor == -1) {
            j12 = 0;
        } else {
            j12 = jArr[binarySearchFloor];
        }
        if (binarySearchFloor != -1) {
            j13 = jArr2[binarySearchFloor];
        }
        SeekPoint seekPoint = getSeekPoint(j12, j13);
        if (seekPoint.timeUs == j11 || binarySearchFloor == jArr.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i11 = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, getSeekPoint(jArr[i11], jArr2[i11]));
    }

    public boolean isSeekable() {
        return true;
    }
}
