package androidx.camera.camera2.internal;

import android.content.Context;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

public final class p1 implements UseCaseConfigFactory {

    /* renamed from: a  reason: collision with root package name */
    public final g2 f5250a;

    public p1(Context context) {
        this.f5250a = g2.c(context);
    }

    public Config getConfig(UseCaseConfigFactory.CaptureType captureType, int i11) {
        Object obj;
        MutableOptionsBundle create = MutableOptionsBundle.create();
        SessionConfig.Builder builder = new SessionConfig.Builder();
        builder.setTemplateType(d4.b(captureType, i11));
        create.insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, builder.build());
        create.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, o1.f5239a);
        CaptureConfig.Builder builder2 = new CaptureConfig.Builder();
        builder2.setTemplateType(d4.a(captureType, i11));
        create.insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, builder2.build());
        Config.Option<CaptureConfig.OptionUnpacker> option = UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER;
        if (captureType == UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE) {
            obj = a3.f5005c;
        } else {
            obj = u0.f5360a;
        }
        create.insertOption(option, obj);
        if (captureType == UseCaseConfigFactory.CaptureType.PREVIEW) {
            create.insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, this.f5250a.f());
        }
        create.insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(this.f5250a.d(true).getRotation()));
        if (captureType == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE || captureType == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            create.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
        }
        return OptionsBundle.from(create);
    }
}
