package com.tencent.ugc.videobase.utils;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.videobase.frame.PixelFrame;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingFrameQueue implements PixelFrameQueue {
    private static final String TAG = "BlockingFrameQueue";
    private final BlockingDeque<PixelFrame> mPixelFrameList;

    public BlockingFrameQueue(int i11) {
        this.mPixelFrameList = new LinkedBlockingDeque(i11);
    }

    public void evictAll() {
        ArrayList arrayList = new ArrayList();
        this.mPixelFrameList.drainTo(arrayList);
        PixelFrame.releasePixelFrames(arrayList);
    }

    public PixelFrame peek() {
        return this.mPixelFrameList.peek();
    }

    public PixelFrame poll() {
        return this.mPixelFrameList.poll();
    }

    public void push(PixelFrame pixelFrame) {
        pixelFrame.retain();
        try {
            this.mPixelFrameList.put(pixelFrame);
        } catch (InterruptedException e11) {
            LiteavLog.e(TAG, "push frame failed with exception", (Throwable) e11);
        }
    }

    public boolean remove(PixelFrame pixelFrame) {
        if (!this.mPixelFrameList.removeFirstOccurrence(pixelFrame)) {
            return false;
        }
        pixelFrame.release();
        return true;
    }

    public int size() {
        return this.mPixelFrameList.size();
    }
}
