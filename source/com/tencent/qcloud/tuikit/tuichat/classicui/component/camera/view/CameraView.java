package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view;

import android.graphics.Bitmap;

public interface CameraView {
    void confirmState(int i11);

    boolean handlerFoucs(float f11, float f12);

    void playVideo(Bitmap bitmap, String str);

    void resetState(int i11);

    void setTip(String str);

    void showPicture(Bitmap bitmap, boolean z11);

    void startPreviewCallback();

    void stopVideo();
}
