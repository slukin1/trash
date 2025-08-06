package com.tencent.thumbplayer.tcmedia.api;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.thumbplayer.tcmedia.a.a;
import com.tencent.thumbplayer.tcmedia.core.common.TPVideoFrame;
import com.tencent.thumbplayer.tcmedia.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.tcmedia.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.tcmedia.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

public class TPVideoCapture implements ITPImageGeneratorCallback {
    private static final String TAG = "TPThumbPlayer[TPVideoCapture.java]";
    private Map<String, TPVideoCaptureCallBack> mCallBackMap;
    private int mHeight = 0;
    private long mOpaque = 0;
    private long mRequestedTimeMsToleranceAfter = 0;
    private long mRequestedTimeMsToleranceBefore = 0;
    private TPImageGenerator mTpImageGenerator;
    private int mWidth = 0;

    public interface TPVideoCaptureCallBack {
        void onCaptureError(int i11);

        void onCaptureSuccess(Bitmap[] bitmapArr);
    }

    public TPVideoCapture(String str) {
        this.mTpImageGenerator = new TPImageGenerator(str, this);
        this.mCallBackMap = new HashMap();
        try {
            this.mTpImageGenerator.init();
        } catch (Exception e11) {
            TPLogUtil.e(TAG, "init: " + Log.getStackTraceString(e11));
        }
    }

    private String generateOpaqueKey(long j11, long j12) {
        return "opaque_" + j11 + "time_" + j12;
    }

    private TPImageGeneratorParams getParameters() {
        TPImageGeneratorParams tPImageGeneratorParams = new TPImageGeneratorParams();
        tPImageGeneratorParams.format = 37;
        tPImageGeneratorParams.width = this.mWidth;
        tPImageGeneratorParams.height = this.mHeight;
        tPImageGeneratorParams.requestedTimeMsToleranceAfter = this.mRequestedTimeMsToleranceAfter;
        tPImageGeneratorParams.requestedTimeMsToleranceBefore = this.mRequestedTimeMsToleranceBefore;
        return tPImageGeneratorParams;
    }

    public void generateImageAsyncAtTime(long j11, TPVideoCaptureCallBack tPVideoCaptureCallBack) {
        long j12 = this.mOpaque + 1;
        this.mOpaque = j12;
        this.mCallBackMap.put(generateOpaqueKey(j12, j11), tPVideoCaptureCallBack);
        try {
            this.mTpImageGenerator.generateImageAsyncAtTime(j11, this.mOpaque, getParameters());
        } catch (Exception e11) {
            TPLogUtil.e(TAG, "generateImageAsyncAtTime: " + Log.getStackTraceString(e11));
        }
    }

    public void generateImagesAsyncForTimes(long[] jArr, TPVideoCaptureCallBack tPVideoCaptureCallBack) {
        this.mOpaque++;
        for (long generateOpaqueKey : jArr) {
            this.mCallBackMap.put(generateOpaqueKey(this.mOpaque, generateOpaqueKey), tPVideoCaptureCallBack);
        }
        try {
            this.mTpImageGenerator.generateImagesAsyncForTimes(jArr, this.mOpaque, getParameters());
        } catch (Exception e11) {
            TPLogUtil.e(TAG, "generateImagesAsyncForTimes: " + Log.getStackTraceString(e11));
        }
    }

    public void onImageGenerationCompleted(int i11, long j11, long j12, long j13, TPVideoFrame tPVideoFrame) {
        TPVideoCaptureCallBack tPVideoCaptureCallBack = this.mCallBackMap.get(generateOpaqueKey(j13, j11));
        if (tPVideoCaptureCallBack != null) {
            if (i11 != 0 || tPVideoFrame == null) {
                tPVideoCaptureCallBack.onCaptureError(i11);
            } else {
                tPVideoCaptureCallBack.onCaptureSuccess(a.b(tPVideoFrame));
            }
        }
        this.mCallBackMap.remove(generateOpaqueKey(j13, j11));
    }

    public void release() {
        try {
            this.mTpImageGenerator.cancelAllImageGenerations();
            this.mTpImageGenerator.unInit();
        } catch (Exception e11) {
            TPLogUtil.e(TAG, "release: " + Log.getStackTraceString(e11));
        }
        this.mCallBackMap.clear();
        this.mTpImageGenerator = null;
    }

    public void setSize(int i11, int i12) {
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Size is illegal");
        }
        this.mWidth = i11;
        this.mHeight = i12;
    }

    public void setTimeMsTolerance(long j11, long j12) {
        if (j11 <= j12) {
            this.mRequestedTimeMsToleranceBefore = j11;
            this.mRequestedTimeMsToleranceAfter = j12;
            return;
        }
        throw new IllegalArgumentException("Tolerance is illegal");
    }
}
