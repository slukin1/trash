package com.tencent.thumbplayer.tcmedia.api;

import android.graphics.Bitmap;

public interface TPCaptureCallBack {
    void onCaptureVideoFailed(int i11);

    void onCaptureVideoSuccess(Bitmap bitmap);
}
