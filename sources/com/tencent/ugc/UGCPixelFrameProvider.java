package com.tencent.ugc;

import com.tencent.ugc.videobase.frame.PixelFrame;
import java.util.LinkedList;
import java.util.List;

public interface UGCPixelFrameProvider {
    public static final List<PixelFrame> END_OF_STREAM = new LinkedList();

    UGCFrameQueue<List<PixelFrame>> getFrameQueue();

    void initialize();

    void seekTo(long j11, boolean z11);

    void setMaxBufferFrameCount(int i11);

    void setPlayEndPts(long j11);

    void setReverse(boolean z11);

    void start();

    void stop();

    void uninitialize();
}
