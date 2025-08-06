package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
public class NativeCapturerParamCreator {
    public static Boolean createBooleanWithValue(boolean z11) {
        return Boolean.valueOf(z11);
    }

    public static CameraCaptureParams createCameraParams(Boolean bool, int i11, int i12, int i13) {
        CameraCaptureParams cameraCaptureParams = new CameraCaptureParams();
        cameraCaptureParams.f22518a = bool;
        cameraCaptureParams.f22524b = i11;
        cameraCaptureParams.f22525c = i12;
        cameraCaptureParams.f22526d = i13;
        return cameraCaptureParams;
    }
}
