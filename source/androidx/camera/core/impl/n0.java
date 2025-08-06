package androidx.camera.core.impl;

import android.util.Range;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

public final /* synthetic */ class n0<T extends UseCase> {
    public static CameraSelector a(UseCaseConfig useCaseConfig) {
        return (CameraSelector) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR);
    }

    public static CameraSelector b(UseCaseConfig useCaseConfig, CameraSelector cameraSelector) {
        return (CameraSelector) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
    }

    public static CaptureConfig.OptionUnpacker c(UseCaseConfig useCaseConfig) {
        return (CaptureConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
    }

    public static CaptureConfig.OptionUnpacker d(UseCaseConfig useCaseConfig, CaptureConfig.OptionUnpacker optionUnpacker) {
        return (CaptureConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
    }

    public static UseCaseConfigFactory.CaptureType e(UseCaseConfig useCaseConfig) {
        return (UseCaseConfigFactory.CaptureType) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_TYPE);
    }

    public static CaptureConfig f(UseCaseConfig useCaseConfig) {
        return (CaptureConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG);
    }

    public static CaptureConfig g(UseCaseConfig useCaseConfig, CaptureConfig captureConfig) {
        return (CaptureConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
    }

    public static SessionConfig h(UseCaseConfig useCaseConfig) {
        return (SessionConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
    }

    public static SessionConfig i(UseCaseConfig useCaseConfig, SessionConfig sessionConfig) {
        return (SessionConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
    }

    public static SessionConfig.OptionUnpacker j(UseCaseConfig useCaseConfig) {
        return (SessionConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER);
    }

    public static SessionConfig.OptionUnpacker k(UseCaseConfig useCaseConfig, SessionConfig.OptionUnpacker optionUnpacker) {
        return (SessionConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
    }

    public static int l(UseCaseConfig useCaseConfig) {
        return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
    }

    public static int m(UseCaseConfig useCaseConfig, int i11) {
        return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i11))).intValue();
    }

    public static Range n(UseCaseConfig useCaseConfig) {
        return (Range) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE);
    }

    public static Range o(UseCaseConfig useCaseConfig, Range range) {
        return (Range) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, range);
    }

    public static boolean p(UseCaseConfig useCaseConfig, boolean z11) {
        return ((Boolean) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z11))).booleanValue();
    }

    public static boolean q(UseCaseConfig useCaseConfig, boolean z11) {
        return ((Boolean) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z11))).booleanValue();
    }
}
