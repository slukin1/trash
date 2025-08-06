package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

final class HlsSampleStream implements SampleStream {
    private int sampleQueueIndex = -1;
    private final HlsSampleStreamWrapper sampleStreamWrapper;
    private final int trackGroupIndex;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i11) {
        this.sampleStreamWrapper = hlsSampleStreamWrapper;
        this.trackGroupIndex = i11;
    }

    private boolean hasValidSampleQueueIndex() {
        int i11 = this.sampleQueueIndex;
        return (i11 == -1 || i11 == -3 || i11 == -2) ? false : true;
    }

    public void bindSampleQueue() {
        Assertions.checkArgument(this.sampleQueueIndex == -1);
        this.sampleQueueIndex = this.sampleStreamWrapper.bindSampleQueueToSampleStream(this.trackGroupIndex);
    }

    public boolean isReady() {
        return this.sampleQueueIndex == -3 || (hasValidSampleQueueIndex() && this.sampleStreamWrapper.isReady(this.sampleQueueIndex));
    }

    public void maybeThrowError() throws IOException {
        int i11 = this.sampleQueueIndex;
        if (i11 == -2) {
            throw new SampleQueueMappingException(this.sampleStreamWrapper.getTrackGroups().get(this.trackGroupIndex).getFormat(0).sampleMimeType);
        } else if (i11 == -1) {
            this.sampleStreamWrapper.maybeThrowError();
        } else if (i11 != -3) {
            this.sampleStreamWrapper.maybeThrowError(i11);
        }
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (this.sampleQueueIndex == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        } else if (hasValidSampleQueueIndex()) {
            return this.sampleStreamWrapper.readData(this.sampleQueueIndex, formatHolder, decoderInputBuffer, i11);
        } else {
            return -3;
        }
    }

    public int skipData(long j11) {
        if (hasValidSampleQueueIndex()) {
            return this.sampleStreamWrapper.skipData(this.sampleQueueIndex, j11);
        }
        return 0;
    }

    public void unbindSampleQueue() {
        if (this.sampleQueueIndex != -1) {
            this.sampleStreamWrapper.unbindSampleQueue(this.trackGroupIndex);
            this.sampleQueueIndex = -1;
        }
    }
}
