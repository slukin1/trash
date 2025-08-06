package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import n.b;
import r.k;

public final class o1 implements SessionConfig.OptionUnpacker {

    /* renamed from: a  reason: collision with root package name */
    public static final o1 f5239a = new o1();

    public void unpack(Size size, UseCaseConfig<?> useCaseConfig, SessionConfig.Builder builder) {
        SessionConfig defaultSessionConfig = useCaseConfig.getDefaultSessionConfig((SessionConfig) null);
        Config emptyBundle = OptionsBundle.emptyBundle();
        int templateType = SessionConfig.defaultEmptySessionConfig().getTemplateType();
        if (defaultSessionConfig != null) {
            templateType = defaultSessionConfig.getTemplateType();
            builder.addAllDeviceStateCallbacks(defaultSessionConfig.getDeviceStateCallbacks());
            builder.addAllSessionStateCallbacks(defaultSessionConfig.getSessionStateCallbacks());
            builder.addAllRepeatingCameraCaptureCallbacks(defaultSessionConfig.getRepeatingCameraCaptureCallbacks());
            emptyBundle = defaultSessionConfig.getImplementationOptions();
        }
        builder.setImplementationOptions(emptyBundle);
        if (useCaseConfig instanceof PreviewConfig) {
            k.b(size, builder);
        }
        Camera2ImplConfig camera2ImplConfig = new Camera2ImplConfig(useCaseConfig);
        builder.setTemplateType(camera2ImplConfig.e(templateType));
        builder.addDeviceStateCallback(camera2ImplConfig.f(s1.b()));
        builder.addSessionStateCallback(camera2ImplConfig.i(r1.b()));
        builder.addCameraCaptureCallback(x1.a(camera2ImplConfig.h(t0.c())));
        MutableOptionsBundle create = MutableOptionsBundle.create();
        create.insertOption(Camera2ImplConfig.f4895g, camera2ImplConfig.b(b.b()));
        create.insertOption(Camera2ImplConfig.f4897i, camera2ImplConfig.g((String) null));
        create.insertOption(Camera2ImplConfig.f4891c, Long.valueOf(camera2ImplConfig.j(-1)));
        builder.addImplementationOptions(create);
        builder.addImplementationOptions(camera2ImplConfig.c());
    }
}
