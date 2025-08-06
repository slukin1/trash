package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.ExifData;

public final /* synthetic */ class a {
    public static CaptureResult a(CameraCaptureResult cameraCaptureResult) {
        return CameraCaptureResult.EmptyCameraCaptureResult.create().getCaptureResult();
    }

    public static void b(CameraCaptureResult cameraCaptureResult, ExifData.Builder builder) {
        builder.setFlashState(cameraCaptureResult.getFlashState());
    }
}
