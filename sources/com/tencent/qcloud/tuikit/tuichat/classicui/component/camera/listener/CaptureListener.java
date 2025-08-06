package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener;

public interface CaptureListener {
    void recordEnd(long j11);

    void recordError();

    void recordShort(long j11);

    void recordStart();

    void recordZoom(float f11);

    void takePictures();
}
