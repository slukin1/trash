package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.util.Log;

public final class BaseMediaChunkOutput implements ChunkExtractor.TrackOutputProvider {
    private static final String TAG = "BaseMediaChunkOutput";
    private final SampleQueue[] sampleQueues;
    private final int[] trackTypes;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.trackTypes = iArr;
        this.sampleQueues = sampleQueueArr;
    }

    public int[] getWriteIndices() {
        int[] iArr = new int[this.sampleQueues.length];
        int i11 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            if (i11 >= sampleQueueArr.length) {
                return iArr;
            }
            iArr[i11] = sampleQueueArr[i11].getWriteIndex();
            i11++;
        }
    }

    public void setSampleOffsetUs(long j11) {
        for (SampleQueue sampleOffsetUs : this.sampleQueues) {
            sampleOffsetUs.setSampleOffsetUs(j11);
        }
    }

    public TrackOutput track(int i11, int i12) {
        int i13 = 0;
        while (true) {
            int[] iArr = this.trackTypes;
            if (i13 >= iArr.length) {
                StringBuilder sb2 = new StringBuilder(36);
                sb2.append("Unmatched track of type: ");
                sb2.append(i12);
                Log.e(TAG, sb2.toString());
                return new DummyTrackOutput();
            } else if (i12 == iArr[i13]) {
                return this.sampleQueues[i13];
            } else {
                i13++;
            }
        }
    }
}
