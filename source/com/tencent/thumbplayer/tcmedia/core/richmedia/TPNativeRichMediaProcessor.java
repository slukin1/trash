package com.tencent.thumbplayer.tcmedia.core.richmedia;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;

public class TPNativeRichMediaProcessor implements ITPNativeRichMediaProcessor {
    private long mNativeContext = 0;

    public TPNativeRichMediaProcessor(Context context) {
        TPNativeLibraryLoader.loadLibIfNeeded(context.getApplicationContext());
        try {
            _nativeSetup();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, "Failed to create native rich media:" + th2.getMessage());
            throw new UnsupportedOperationException("Failed to create rich media");
        }
    }

    private native int _deselectFeatureAsync(int i11);

    private native int _getCurrentPositionMsFeatureData(long j11, int[] iArr, TPNativeRichMediaFeatureData tPNativeRichMediaFeatureData);

    private native TPNativeRichMediaFeature[] _getFeatures();

    private native void _nativeSetup();

    private native int _prepareAsync();

    private native void _release();

    private native int _reset();

    private native int _seek(long j11);

    private native int _selectFeatureAsync(int i11, TPNativeRichMediaRequestExtraInfo tPNativeRichMediaRequestExtraInfo);

    private native void _setInnerProcessorCallback(ITPNativeRichMediaInnerProcessorCallback iTPNativeRichMediaInnerProcessorCallback);

    private native int _setPlaybackRate(float f11);

    private native void _setProcessorCallback(ITPNativeRichMediaProcessorCallback iTPNativeRichMediaProcessorCallback);

    private native int _setRichMediaSource(String str);

    public void deselectFeatureAsync(int i11) {
        try {
            int _deselectFeatureAsync = _deselectFeatureAsync(i11);
            if (_deselectFeatureAsync != 0) {
                if (_deselectFeatureAsync == 1000012) {
                    throw new IllegalArgumentException();
                }
                throw new IllegalStateException("deSelectAsync:".concat(String.valueOf(_deselectFeatureAsync)));
            }
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public TPNativeRichMediaFeatureData getCurrentPositionMsFeatureData(long j11, int[] iArr) {
        TPNativeRichMediaFeatureData tPNativeRichMediaFeatureData = new TPNativeRichMediaFeatureData();
        try {
            int _getCurrentPositionMsFeatureData = _getCurrentPositionMsFeatureData(j11, iArr, tPNativeRichMediaFeatureData);
            if (_getCurrentPositionMsFeatureData == 0) {
                return tPNativeRichMediaFeatureData;
            }
            if (_getCurrentPositionMsFeatureData == 1000012) {
                throw new IllegalArgumentException();
            }
            throw new IllegalStateException("getCurrentTimeContent:".concat(String.valueOf(_getCurrentPositionMsFeatureData)));
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return null;
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
        try {
            int _prepareAsync = _prepareAsync();
            if (_prepareAsync != 0) {
                throw new IllegalStateException("prepareAsync:".concat(String.valueOf(_prepareAsync)));
            }
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void release() {
        try {
            _release();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void reset() {
        try {
            int _reset = _reset();
            if (_reset != 0) {
                throw new IllegalStateException("reset:".concat(String.valueOf(_reset)));
            }
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void seek(long j11) {
        try {
            int _seek = _seek(j11);
            if (_seek != 0) {
                if (_seek == 1000012) {
                    throw new IllegalArgumentException();
                }
                throw new IllegalStateException("seek:".concat(String.valueOf(_seek)));
            }
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void selectFeatureAsync(int i11, TPNativeRichMediaRequestExtraInfo tPNativeRichMediaRequestExtraInfo) {
        try {
            int _selectFeatureAsync = _selectFeatureAsync(i11, tPNativeRichMediaRequestExtraInfo);
            if (_selectFeatureAsync != 0) {
                if (_selectFeatureAsync == 1000012) {
                    throw new IllegalArgumentException();
                }
                throw new IllegalStateException("selectAsync:".concat(String.valueOf(_selectFeatureAsync)));
            }
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void setInnerProcessorCallback(ITPNativeRichMediaInnerProcessorCallback iTPNativeRichMediaInnerProcessorCallback) {
        try {
            _setInnerProcessorCallback(iTPNativeRichMediaInnerProcessorCallback);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void setPlaybackRate(float f11) {
        try {
            int _setPlaybackRate = _setPlaybackRate(f11);
            if (_setPlaybackRate != 0) {
                if (_setPlaybackRate == 1000012) {
                    throw new IllegalArgumentException();
                }
                throw new IllegalStateException("setPlaybackRate:".concat(String.valueOf(_setPlaybackRate)));
            }
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void setProcessorCallback(ITPNativeRichMediaProcessorCallback iTPNativeRichMediaProcessorCallback) {
        try {
            _setProcessorCallback(iTPNativeRichMediaProcessorCallback);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }

    public void setRichMediaSource(String str) {
        try {
            int _setRichMediaSource = _setRichMediaSource(str);
            if (_setRichMediaSource != 0) {
                if (_setRichMediaSource == 1000012) {
                    throw new IllegalArgumentException();
                }
                throw new IllegalStateException("setRichMediaSource:".concat(String.valueOf(_setRichMediaSource)));
            }
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
        }
    }
}
