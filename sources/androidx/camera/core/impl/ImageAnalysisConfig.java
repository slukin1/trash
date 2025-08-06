package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.d;
import androidx.camera.core.internal.e;
import androidx.camera.core.internal.f;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class ImageAnalysisConfig implements UseCaseConfig<ImageAnalysis>, ImageOutputConfig, ThreadConfig {
    public static final Config.Option<Integer> OPTION_BACKPRESSURE_STRATEGY = Config.Option.create("camerax.core.imageAnalysis.backpressureStrategy", ImageAnalysis.BackpressureStrategy.class);
    public static final Config.Option<Integer> OPTION_IMAGE_QUEUE_DEPTH = Config.Option.create("camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE);
    public static final Config.Option<ImageReaderProxyProvider> OPTION_IMAGE_READER_PROXY_PROVIDER = Config.Option.create("camerax.core.imageAnalysis.imageReaderProxyProvider", ImageReaderProxyProvider.class);
    public static final Config.Option<Boolean> OPTION_ONE_PIXEL_SHIFT_ENABLED;
    public static final Config.Option<Integer> OPTION_OUTPUT_IMAGE_FORMAT = Config.Option.create("camerax.core.imageAnalysis.outputImageFormat", ImageAnalysis.OutputImageFormat.class);
    public static final Config.Option<Boolean> OPTION_OUTPUT_IMAGE_ROTATION_ENABLED;
    private final OptionsBundle mConfig;

    static {
        Class<Boolean> cls = Boolean.class;
        OPTION_ONE_PIXEL_SHIFT_ENABLED = Config.Option.create("camerax.core.imageAnalysis.onePixelShiftEnabled", cls);
        OPTION_OUTPUT_IMAGE_ROTATION_ENABLED = Config.Option.create("camerax.core.imageAnalysis.outputImageRotationEnabled", cls);
    }

    public ImageAnalysisConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public /* synthetic */ boolean containsOption(Config.Option option) {
        return g0.a(this, option);
    }

    public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        g0.b(this, str, optionMatcher);
    }

    public /* synthetic */ int getAppTargetRotation(int i11) {
        return z.a(this, i11);
    }

    public /* synthetic */ Executor getBackgroundExecutor() {
        return e.a(this);
    }

    public /* synthetic */ Executor getBackgroundExecutor(Executor executor) {
        return e.b(this, executor);
    }

    public int getBackpressureStrategy(int i11) {
        return ((Integer) retrieveOption(OPTION_BACKPRESSURE_STRATEGY, Integer.valueOf(i11))).intValue();
    }

    public /* synthetic */ CameraSelector getCameraSelector() {
        return n0.a(this);
    }

    public /* synthetic */ CameraSelector getCameraSelector(CameraSelector cameraSelector) {
        return n0.b(this, cameraSelector);
    }

    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return n0.c(this);
    }

    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        return n0.d(this, optionUnpacker);
    }

    public /* synthetic */ UseCaseConfigFactory.CaptureType getCaptureType() {
        return n0.e(this);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public /* synthetic */ List getCustomOrderedResolutions() {
        return z.b(this);
    }

    public /* synthetic */ List getCustomOrderedResolutions(List list) {
        return z.c(this, list);
    }

    public /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
        return n0.f(this);
    }

    public /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
        return n0.g(this, captureConfig);
    }

    public /* synthetic */ Size getDefaultResolution() {
        return z.d(this);
    }

    public /* synthetic */ Size getDefaultResolution(Size size) {
        return z.e(this, size);
    }

    public /* synthetic */ SessionConfig getDefaultSessionConfig() {
        return n0.h(this);
    }

    public /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
        return n0.i(this, sessionConfig);
    }

    public /* synthetic */ DynamicRange getDynamicRange() {
        return y.a(this);
    }

    public int getImageQueueDepth(int i11) {
        return ((Integer) retrieveOption(OPTION_IMAGE_QUEUE_DEPTH, Integer.valueOf(i11))).intValue();
    }

    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return (ImageReaderProxyProvider) retrieveOption(OPTION_IMAGE_READER_PROXY_PROVIDER, (Object) null);
    }

    public int getInputFormat() {
        return 35;
    }

    public /* synthetic */ Size getMaxResolution() {
        return z.f(this);
    }

    public /* synthetic */ Size getMaxResolution(Size size) {
        return z.g(this, size);
    }

    public /* synthetic */ int getMirrorMode(int i11) {
        return z.h(this, i11);
    }

    public Boolean getOnePixelShiftEnabled(Boolean bool) {
        return (Boolean) retrieveOption(OPTION_ONE_PIXEL_SHIFT_ENABLED, bool);
    }

    public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
        return g0.c(this, option);
    }

    public int getOutputImageFormat(int i11) {
        return ((Integer) retrieveOption(OPTION_OUTPUT_IMAGE_FORMAT, Integer.valueOf(i11))).intValue();
    }

    public /* synthetic */ Set getPriorities(Config.Option option) {
        return g0.d(this, option);
    }

    public /* synthetic */ ResolutionSelector getResolutionSelector() {
        return z.i(this);
    }

    public /* synthetic */ ResolutionSelector getResolutionSelector(ResolutionSelector resolutionSelector) {
        return z.j(this, resolutionSelector);
    }

    public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
        return n0.j(this);
    }

    public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        return n0.k(this, optionUnpacker);
    }

    public /* synthetic */ List getSupportedResolutions() {
        return z.k(this);
    }

    public /* synthetic */ List getSupportedResolutions(List list) {
        return z.l(this, list);
    }

    public /* synthetic */ int getSurfaceOccupancyPriority() {
        return n0.l(this);
    }

    public /* synthetic */ int getSurfaceOccupancyPriority(int i11) {
        return n0.m(this, i11);
    }

    public /* synthetic */ int getTargetAspectRatio() {
        return z.m(this);
    }

    public /* synthetic */ Class getTargetClass() {
        return d.a(this);
    }

    public /* synthetic */ Class getTargetClass(Class cls) {
        return d.b(this, cls);
    }

    public /* synthetic */ Range getTargetFrameRate() {
        return n0.n(this);
    }

    public /* synthetic */ Range getTargetFrameRate(Range range) {
        return n0.o(this, range);
    }

    public /* synthetic */ String getTargetName() {
        return d.c(this);
    }

    public /* synthetic */ String getTargetName(String str) {
        return d.d(this, str);
    }

    public /* synthetic */ Size getTargetResolution() {
        return z.n(this);
    }

    public /* synthetic */ Size getTargetResolution(Size size) {
        return z.o(this, size);
    }

    public /* synthetic */ int getTargetRotation() {
        return z.p(this);
    }

    public /* synthetic */ int getTargetRotation(int i11) {
        return z.q(this, i11);
    }

    public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback() {
        return f.a(this);
    }

    public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback eventCallback) {
        return f.b(this, eventCallback);
    }

    public /* synthetic */ boolean hasDynamicRange() {
        return y.c(this);
    }

    public /* synthetic */ boolean hasTargetAspectRatio() {
        return z.r(this);
    }

    public /* synthetic */ boolean isHigResolutionDisabled(boolean z11) {
        return n0.p(this, z11);
    }

    public Boolean isOutputImageRotationEnabled(Boolean bool) {
        return (Boolean) retrieveOption(OPTION_OUTPUT_IMAGE_ROTATION_ENABLED, bool);
    }

    public /* synthetic */ boolean isZslDisabled(boolean z11) {
        return n0.q(this, z11);
    }

    public /* synthetic */ Set listOptions() {
        return g0.e(this);
    }

    public /* synthetic */ Object retrieveOption(Config.Option option) {
        return g0.f(this, option);
    }

    public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
        return g0.g(this, option, obj);
    }

    public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
        return g0.h(this, option, optionPriority);
    }

    public int getBackpressureStrategy() {
        return ((Integer) retrieveOption(OPTION_BACKPRESSURE_STRATEGY)).intValue();
    }

    public int getImageQueueDepth() {
        return ((Integer) retrieveOption(OPTION_IMAGE_QUEUE_DEPTH)).intValue();
    }
}
