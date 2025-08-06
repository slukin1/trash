package com.tencent.thumbplayer.tcmedia.core.richmedia.async;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.core.common.TPGeneralError;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;
import com.tencent.thumbplayer.tcmedia.core.richmedia.TPNativeRichMediaFeature;
import com.tencent.thumbplayer.tcmedia.core.richmedia.TPNativeTimeRange;

public class TPNativeRichMediaAsyncRequester implements ITPNativeRichMediaAsyncRequester {
    private static final int REQUEST_ID_NATIVE_EXCEPTION_THROW = -100;
    private long mNativeContext = 0;

    public TPNativeRichMediaAsyncRequester(Context context) {
        TPNativeLibraryLoader.loadLibIfNeeded(context);
        try {
            if (_nativeSetup() != 0) {
                throw new UnsupportedOperationException("failed to setup rich media");
            }
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, "Failed to create native rich media:" + th2.getMessage());
            throw new UnsupportedOperationException("failed to create rich media");
        }
    }

    private native void _cancelRequest(int i11);

    private native TPNativeRichMediaFeature[] _getFeatures();

    private native int _nativeSetup();

    private native int _prepareAsync();

    private native void _release();

    private native int _requestFeatureDataAsyncAtTimeMs(int i11, long j11);

    private native int _requestFeatureDataAsyncAtTimeMsArray(int i11, long[] jArr);

    private native int _requestFeatureDataAsyncAtTimeRange(int i11, TPNativeTimeRange tPNativeTimeRange);

    private native int _requestFeatureDataAsyncAtTimeRanges(int i11, TPNativeTimeRange[] tPNativeTimeRangeArr);

    private native void _setRequesterListener(ITPNativeRichMediaAsyncRequesterListener iTPNativeRichMediaAsyncRequesterListener);

    private native int _setRichMediaSource(String str);

    public void cancelRequest(int i11) {
        try {
            _cancelRequest(i11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public TPNativeRichMediaFeature[] getFeatures() {
        try {
            return _getFeatures();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return new TPNativeRichMediaFeature[0];
        }
    }

    public void prepareAsync() {
        int i11;
        try {
            i11 = _prepareAsync();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            i11 = TPGeneralError.FAILED;
        }
        if (i11 != 0) {
            throw new IllegalStateException("prepareAsync, ret=".concat(String.valueOf(i11)));
        }
    }

    public void release() {
        try {
            _release();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public int requestFeatureDataAsyncAtTimeMs(int i11, long j11) {
        try {
            return _requestFeatureDataAsyncAtTimeMs(i11, j11);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return -100;
        }
    }

    public int requestFeatureDataAsyncAtTimeMsArray(int i11, long[] jArr) {
        try {
            return _requestFeatureDataAsyncAtTimeMsArray(i11, jArr);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return -100;
        }
    }

    public int requestFeatureDataAsyncAtTimeRange(int i11, TPNativeTimeRange tPNativeTimeRange) {
        try {
            return _requestFeatureDataAsyncAtTimeRange(i11, tPNativeTimeRange);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return -100;
        }
    }

    public int requestFeatureDataAsyncAtTimeRanges(int i11, TPNativeTimeRange[] tPNativeTimeRangeArr) {
        try {
            return _requestFeatureDataAsyncAtTimeRanges(i11, tPNativeTimeRangeArr);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return -100;
        }
    }

    public void setRequesterListener(ITPNativeRichMediaAsyncRequesterListener iTPNativeRichMediaAsyncRequesterListener) {
        try {
            _setRequesterListener(iTPNativeRichMediaAsyncRequesterListener);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void setRichMediaSource(String str) {
        int i11;
        try {
            i11 = _setRichMediaSource(str);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            i11 = TPGeneralError.FAILED;
        }
        if (i11 != 0) {
            if (i11 == 1000012) {
                throw new IllegalArgumentException("setRichMediaSource，invalid argument, url=".concat(String.valueOf(str)));
            }
            throw new IllegalStateException("setRichMediaSource:".concat(String.valueOf(i11)));
        }
    }
}
