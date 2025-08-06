package androidx.camera.core.streamsharing;

import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

class StreamSharingBuilder implements UseCaseConfig.Builder<StreamSharing, StreamSharingConfig, StreamSharingBuilder> {
    private static final String UNSUPPORTED_MESSAGE = "Operation not supported by StreamSharingBuilder.";
    private final MutableOptionsBundle mMutableConfig;

    public StreamSharingBuilder() {
        this(MutableOptionsBundle.create());
    }

    public MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    public StreamSharingBuilder(MutableOptionsBundle mutableOptionsBundle) {
        Class<StreamSharing> cls = StreamSharing.class;
        this.mMutableConfig = mutableOptionsBundle;
        Class cls2 = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
        if (cls2 == null || cls2.equals(cls)) {
            setTargetClass(cls);
            return;
        }
        throw new IllegalArgumentException("Invalid target class configuration for " + this + l.f34627b + cls2);
    }

    public StreamSharing build() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public StreamSharingConfig getUseCaseConfig() {
        return new StreamSharingConfig(OptionsBundle.from(this.mMutableConfig));
    }

    public StreamSharingBuilder setCameraSelector(CameraSelector cameraSelector) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public StreamSharingBuilder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public StreamSharingBuilder setCaptureType(UseCaseConfigFactory.CaptureType captureType) {
        getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, captureType);
        return this;
    }

    public StreamSharingBuilder setDefaultCaptureConfig(CaptureConfig captureConfig) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public StreamSharingBuilder setDefaultSessionConfig(SessionConfig sessionConfig) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public StreamSharingBuilder setHighResolutionDisabled(boolean z11) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public StreamSharingBuilder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public StreamSharingBuilder setSurfaceOccupancyPriority(int i11) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public StreamSharingBuilder setTargetClass(Class<StreamSharing> cls) {
        getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
        if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
            setTargetName(cls.getCanonicalName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID());
        }
        return this;
    }

    public StreamSharingBuilder setTargetName(String str) {
        getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
        return this;
    }

    public StreamSharingBuilder setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public StreamSharingBuilder setZslDisabled(boolean z11) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }
}
