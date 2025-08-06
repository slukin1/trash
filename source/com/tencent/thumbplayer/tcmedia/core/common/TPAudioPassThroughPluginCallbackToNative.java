package com.tencent.thumbplayer.tcmedia.core.common;

import com.tencent.thumbplayer.tcmedia.core.common.TPAudioPassThroughPluginDetector;

public class TPAudioPassThroughPluginCallbackToNative implements TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener {
    private static final String TAG = "TPAudioPassThroughPluginCallback";
    private long mNativeContext;

    private TPAudioPassThroughPluginCallbackToNative(long j11) {
        this.mNativeContext = j11;
    }

    private native void _onAudioPassThroughStateChanged(boolean z11);

    private long getNativeContext() {
        return this.mNativeContext;
    }

    private void registerCallback() {
        TPAudioPassThroughPluginDetector.addListener(this);
    }

    private void unregisterCallback() {
        TPAudioPassThroughPluginDetector.removeListener(this);
    }

    public void onAudioPassThroughPlugin(boolean z11) {
        TPNativeLog.printLog(2, TAG, "onAudioPassThroughPlugin bPlugin:".concat(String.valueOf(z11)));
        _onAudioPassThroughStateChanged(z11);
    }
}
