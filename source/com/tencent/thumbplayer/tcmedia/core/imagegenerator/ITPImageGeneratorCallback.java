package com.tencent.thumbplayer.tcmedia.core.imagegenerator;

import com.tencent.thumbplayer.tcmedia.core.common.TPVideoFrame;

public interface ITPImageGeneratorCallback {
    void onImageGenerationCompleted(int i11, long j11, long j12, long j13, TPVideoFrame tPVideoFrame);
}
