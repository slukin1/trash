package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener;

import android.graphics.Bitmap;

public interface JCameraListener {
    void captureSuccess(Bitmap bitmap);

    void recordSuccess(String str, Bitmap bitmap, long j11);
}
