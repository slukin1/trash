package com.tencent.ugc.videobase.utils;

import com.tencent.ugc.videobase.frame.PixelFrame;

public interface PixelFrameQueue {
    void evictAll();

    PixelFrame peek();

    PixelFrame poll();

    void push(PixelFrame pixelFrame);

    boolean remove(PixelFrame pixelFrame);

    int size();
}
