package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.ConstantBitrateSeekMap;

final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {
    public ConstantBitrateSeeker(long j11, long j12, MpegAudioUtil.Header header) {
        super(j11, j12, header.bitrate, header.frameSize);
    }

    public long getDataEndPosition() {
        return -1;
    }

    public long getTimeUs(long j11) {
        return getTimeUsAtPosition(j11);
    }
}
