package com.jumio.commons.camera;

public interface CameraCallbackInterface {
    void onCameraAvailable(boolean z11);

    void onCameraError(Throwable th2);

    void onPreviewAvailable(PreviewProperties previewProperties);

    void onPreviewFrame(Frame frame);

    void onStopPreview();
}
