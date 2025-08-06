package com.google.android.exoplayer2.extractor.mp3;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.Util;

final class MlltSeeker implements Seeker {
    private final long durationUs;
    private final long[] referencePositions;
    private final long[] referenceTimesMs;

    private MlltSeeker(long[] jArr, long[] jArr2, long j11) {
        this.referencePositions = jArr;
        this.referenceTimesMs = jArr2;
        this.durationUs = j11 == -9223372036854775807L ? C.msToUs(jArr2[jArr2.length - 1]) : j11;
    }

    public static MlltSeeker create(long j11, MlltFrame mlltFrame, long j12) {
        int length = mlltFrame.bytesDeviations.length;
        int i11 = length + 1;
        long[] jArr = new long[i11];
        long[] jArr2 = new long[i11];
        jArr[0] = j11;
        long j13 = 0;
        jArr2[0] = 0;
        for (int i12 = 1; i12 <= length; i12++) {
            int i13 = i12 - 1;
            j11 += (long) (mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i13]);
            j13 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i13]);
            jArr[i12] = j11;
            jArr2[i12] = j13;
        }
        return new MlltSeeker(jArr, jArr2, j12);
    }

    private static Pair<Long, Long> linearlyInterpolate(long j11, long[] jArr, long[] jArr2) {
        int binarySearchFloor = Util.binarySearchFloor(jArr, j11, true, true);
        long j12 = jArr[binarySearchFloor];
        long j13 = jArr2[binarySearchFloor];
        int i11 = binarySearchFloor + 1;
        if (i11 == jArr.length) {
            return Pair.create(Long.valueOf(j12), Long.valueOf(j13));
        }
        long j14 = jArr[i11];
        return Pair.create(Long.valueOf(j11), Long.valueOf(((long) ((j14 == j12 ? 0.0d : (((double) j11) - ((double) j12)) / ((double) (j14 - j12))) * ((double) (jArr2[i11] - j13)))) + j13));
    }

    public long getDataEndPosition() {
        return -1;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        Pair<Long, Long> linearlyInterpolate = linearlyInterpolate(C.usToMs(Util.constrainValue(j11, 0, this.durationUs)), this.referenceTimesMs, this.referencePositions);
        return new SeekMap.SeekPoints(new SeekPoint(C.msToUs(((Long) linearlyInterpolate.first).longValue()), ((Long) linearlyInterpolate.second).longValue()));
    }

    public long getTimeUs(long j11) {
        return C.msToUs(((Long) linearlyInterpolate(j11, this.referencePositions, this.referenceTimesMs).second).longValue());
    }

    public boolean isSeekable() {
        return true;
    }
}
