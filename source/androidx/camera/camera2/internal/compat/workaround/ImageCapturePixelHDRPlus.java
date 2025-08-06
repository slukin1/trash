package androidx.camera.camera2.internal.compat.workaround;

import android.annotation.SuppressLint;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import q.d;

public class ImageCapturePixelHDRPlus {
    @SuppressLint({"NewApi"})
    public void a(int i11, Camera2ImplConfig.Builder builder) {
        if (((ImageCapturePixelHDRPlusQuirk) d.a(ImageCapturePixelHDRPlusQuirk.class)) != null) {
            if (i11 == 0) {
                builder.c(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.TRUE);
            } else if (i11 == 1) {
                builder.c(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.FALSE);
            }
        }
    }
}
