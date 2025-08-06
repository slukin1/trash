package androidx.camera.camera2.internal;

import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;

public class u0 implements CaptureConfig.OptionUnpacker {

    /* renamed from: a  reason: collision with root package name */
    public static final u0 f5360a = new u0();

    public void unpack(UseCaseConfig<?> useCaseConfig, CaptureConfig.Builder builder) {
        CaptureConfig defaultCaptureConfig = useCaseConfig.getDefaultCaptureConfig((CaptureConfig) null);
        Config emptyBundle = OptionsBundle.emptyBundle();
        int templateType = CaptureConfig.defaultEmptyCaptureConfig().getTemplateType();
        if (defaultCaptureConfig != null) {
            templateType = defaultCaptureConfig.getTemplateType();
            builder.addAllCameraCaptureCallbacks(defaultCaptureConfig.getCameraCaptureCallbacks());
            emptyBundle = defaultCaptureConfig.getImplementationOptions();
        }
        builder.setImplementationOptions(emptyBundle);
        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(useCaseConfig);
        builder.setTemplateType(camera2ImplConfig.e(templateType));
        builder.addCameraCaptureCallback(x1.a(camera2ImplConfig.h(t0.c())));
        builder.addImplementationOptions(camera2ImplConfig.c());
    }
}
