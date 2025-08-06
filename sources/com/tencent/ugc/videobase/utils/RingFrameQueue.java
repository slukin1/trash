package com.tencent.ugc.videobase.utils;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.videobase.frame.PixelFrame;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class RingFrameQueue implements PixelFrameQueue {
    private static final String TAG = "RingFrameQueue";
    private int mCapability;
    private final Deque<PixelFrame> mPixelFrameList = new LinkedList();

    public RingFrameQueue(int i11) {
        this.mCapability = i11;
    }

    public void evictAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.mPixelFrameList);
            this.mPixelFrameList.clear();
        }
        LiteavLog.i(TAG, "evictAll pixelFrame.");
        PixelFrame.releasePixelFrames(arrayList);
    }

    public PixelFrame peek() {
        PixelFrame peek;
        synchronized (this) {
            peek = this.mPixelFrameList.peek();
        }
        return peek;
    }

    public PixelFrame poll() {
        PixelFrame pollFirst;
        synchronized (this) {
            pollFirst = this.mPixelFrameList.pollFirst();
        }
        return pollFirst;
    }

    public void push(PixelFrame pixelFrame) {
        PixelFrame removeFirst;
        pixelFrame.retain();
        synchronized (this) {
            removeFirst = this.mPixelFrameList.size() >= this.mCapability ? this.mPixelFrameList.removeFirst() : null;
            this.mPixelFrameList.addLast(pixelFrame);
        }
        if (removeFirst != null) {
            removeFirst.release();
        }
    }

    public boolean remove(PixelFrame pixelFrame) {
        boolean z11 = false;
        if (pixelFrame == null) {
            return false;
        }
        synchronized (this) {
            if (this.mPixelFrameList.size() > 0) {
                z11 = this.mPixelFrameList.removeFirstOccurrence(pixelFrame);
            }
        }
        if (z11) {
            pixelFrame.release();
        }
        return z11;
    }

    public int size() {
        int size;
        synchronized (this) {
            size = this.mPixelFrameList.size();
        }
        return size;
    }
}
