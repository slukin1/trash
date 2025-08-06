package x;

import android.util.Range;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.g0;
import androidx.camera.core.impl.n0;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.d;
import androidx.camera.core.internal.e;
import androidx.camera.core.internal.f;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.internal.encoder.i1;
import androidx.camera.video.internal.encoder.k1;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

public final class a<T extends VideoOutput> implements UseCaseConfig<VideoCapture<T>>, ImageOutputConfig, ThreadConfig {

    /* renamed from: b  reason: collision with root package name */
    public static final Config.Option<VideoOutput> f16762b = Config.Option.create("camerax.video.VideoCapture.videoOutput", VideoOutput.class);

    /* renamed from: c  reason: collision with root package name */
    public static final Config.Option<Function<i1, k1>> f16763c = Config.Option.create("camerax.video.VideoCapture.videoEncoderInfoFinder", Function.class);

    /* renamed from: a  reason: collision with root package name */
    public final OptionsBundle f16764a;

    public a(OptionsBundle optionsBundle) {
        this.f16764a = optionsBundle;
    }

    public Function<i1, k1> a() {
        Function<i1, k1> function = (Function) retrieveOption(f16763c);
        Objects.requireNonNull(function);
        return function;
    }

    public T b() {
        return (VideoOutput) retrieveOption(f16762b);
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
        return this.f16764a;
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

    public int getInputFormat() {
        return 34;
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

    public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
        return g0.c(this, option);
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
}
