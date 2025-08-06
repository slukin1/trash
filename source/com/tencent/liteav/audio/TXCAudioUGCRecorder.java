package com.tencent.liteav.audio;

import android.content.Context;

public class TXCAudioUGCRecorder {
    private static final TXCAudioUGCRecorder INSTANCE = new TXCAudioUGCRecorder();

    private TXCAudioUGCRecorder() {
    }

    public static TXCAudioUGCRecorder getInstance() {
        return INSTANCE;
    }

    public synchronized boolean getIsMute() {
        return false;
    }

    public void setAECType(int i11, Context context) {
    }
}
