package androidx.camera.camera2.internal;

import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.workaround.ImageCapturePixelHDRPlus;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;

public final class a3 extends u0 {

    /* renamed from: c  reason: collision with root package name */
    public static final a3 f5005c = new a3(new ImageCapturePixelHDRPlus());

    /* renamed from: b  reason: collision with root package name */
    public final ImageCapturePixelHDRPlus f5006b;

    public a3(ImageCapturePixelHDRPlus imageCapturePixelHDRPlus) {
        this.f5006b = imageCapturePixelHDRPlus;
    }

    public void unpack(UseCaseConfig<?> useCaseConfig, CaptureConfig.Builder builder) {
        super.unpack(useCaseConfig, builder);
        if (useCaseConfig instanceof ImageCaptureConfig) {
            ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) useCaseConfig;
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            if (imageCaptureConfig.hasCaptureMode()) {
                this.f5006b.a(imageCaptureConfig.getCaptureMode(), builder2);
            }
            builder.addImplementationOptions(builder2.build());
            return;
        }
        throw new IllegalArgumentException("config is not ImageCaptureConfig");
    }
}
