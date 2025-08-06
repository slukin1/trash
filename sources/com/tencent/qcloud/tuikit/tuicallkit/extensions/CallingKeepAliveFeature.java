package com.tencent.qcloud.tuikit.tuicallkit.extensions;

import android.content.Context;

public class CallingKeepAliveFeature {
    private Context mContext;
    private boolean mEnableKeepAlive = true;

    public CallingKeepAliveFeature(Context context) {
        this.mContext = context;
    }

    public void enableKeepAlive(boolean z11) {
        this.mEnableKeepAlive = z11;
    }

    public void startKeepAlive() {
    }

    public void stopKeepAlive() {
    }
}
