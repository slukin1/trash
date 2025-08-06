package com.tencent.ugc.videoprocessor.watermark.data;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

public class TailWaterMark extends WaterMark {
    public float mBlurLevel = 0.0f;
    private int mDuration;
    public float mMarkAlphaLevel = 1.0f;
    private long mStartTime;

    public TailWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j11, int i11) {
        super(bitmap, tXRect);
        this.mStartTime = j11;
        this.mDuration = i11;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public void release() {
        super.release();
    }
}
