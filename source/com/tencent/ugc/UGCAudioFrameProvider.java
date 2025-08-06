package com.tencent.ugc;

import java.util.LinkedList;
import java.util.List;

public interface UGCAudioFrameProvider {
    public static final List<AudioFrame> END_OF_STREAM = new LinkedList();

    UGCFrameQueue<List<AudioFrame>> getFrameQueue();

    void initialize();

    void seekTo(long j11);

    void setPlayEndPts(long j11);

    void start();

    void stop();

    void uninitialize();
}
