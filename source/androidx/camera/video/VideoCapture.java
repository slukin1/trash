package androidx.camera.video;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.StreamInfo;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.compat.quirk.ExtraSupportedResolutionQuirk;
import androidx.camera.video.internal.compat.quirk.ImageCaptureFailedWhenVideoCaptureIsBoundQuirk;
import androidx.camera.video.internal.compat.quirk.PreviewDelayWhenVideoCaptureIsBoundQuirk;
import androidx.camera.video.internal.compat.quirk.PreviewStretchWhenVideoCaptureIsBoundQuirk;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.i1;
import androidx.camera.video.internal.encoder.k1;
import androidx.camera.video.internal.encoder.l1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class VideoCapture<T extends VideoOutput> extends UseCase {

    /* renamed from: n  reason: collision with root package name */
    public static final Defaults f5856n = new Defaults();

    /* renamed from: o  reason: collision with root package name */
    public static boolean f5857o;

    /* renamed from: p  reason: collision with root package name */
    public static final boolean f5858p;

    /* renamed from: a  reason: collision with root package name */
    public DeferrableSurface f5859a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceEdge f5860b;

    /* renamed from: c  reason: collision with root package name */
    public StreamInfo f5861c = StreamInfo.f5853a;

    /* renamed from: d  reason: collision with root package name */
    public SessionConfig.Builder f5862d = new SessionConfig.Builder();

    /* renamed from: e  reason: collision with root package name */
    public ListenableFuture<Void> f5863e = null;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceRequest f5864f;

    /* renamed from: g  reason: collision with root package name */
    public VideoOutput.SourceState f5865g = VideoOutput.SourceState.INACTIVE;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceProcessorNode f5866h;

    /* renamed from: i  reason: collision with root package name */
    public k1 f5867i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f5868j;

    /* renamed from: k  reason: collision with root package name */
    public int f5869k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f5870l = false;

    /* renamed from: m  reason: collision with root package name */
    public final Observable.Observer<StreamInfo> f5871m = new a();

    public static final class Defaults implements ConfigProvider<x.a<?>> {

        /* renamed from: a  reason: collision with root package name */
        public static final VideoOutput f5872a;

        /* renamed from: b  reason: collision with root package name */
        public static final x.a<?> f5873b;

        /* renamed from: c  reason: collision with root package name */
        public static final Function<i1, k1> f5874c;

        /* renamed from: d  reason: collision with root package name */
        public static final Range<Integer> f5875d = new Range<>(30, 30);

        /* renamed from: e  reason: collision with root package name */
        public static final DynamicRange f5876e;

        static {
            m1 m1Var = m1.f6318a;
            f5872a = m1Var;
            Function<i1, k1> b11 = b();
            f5874c = b11;
            DynamicRange dynamicRange = DynamicRange.SDR;
            f5876e = dynamicRange;
            f5873b = new d(m1Var).setSurfaceOccupancyPriority(5).A(b11).setDynamicRange(dynamicRange).setCaptureType(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE).getUseCaseConfig();
        }

        public static Function<i1, k1> b() {
            return l1.f6313a;
        }

        public static /* synthetic */ k1 d(i1 i1Var) {
            try {
                return l1.j(i1Var);
            } catch (InvalidConfigException e11) {
                Logger.w("VideoCapture", "Unable to find VideoEncoderInfo", e11);
                return null;
            }
        }

        /* renamed from: c */
        public x.a<?> getConfig() {
            return f5873b;
        }
    }

    public class a implements Observable.Observer<StreamInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNewData(StreamInfo streamInfo) {
            if (streamInfo == null) {
                throw new IllegalArgumentException("StreamInfo can't be null");
            } else if (VideoCapture.this.f5865g != VideoOutput.SourceState.INACTIVE) {
                Logger.d("VideoCapture", "Stream info update: old: " + VideoCapture.this.f5861c + " new: " + streamInfo);
                VideoCapture videoCapture = VideoCapture.this;
                StreamInfo streamInfo2 = videoCapture.f5861c;
                videoCapture.f5861c = streamInfo;
                StreamSpec streamSpec = (StreamSpec) h.g(videoCapture.getAttachedStreamSpec());
                if (VideoCapture.this.F(streamInfo2.a(), streamInfo.a()) || VideoCapture.this.V(streamInfo2, streamInfo)) {
                    VideoCapture videoCapture2 = VideoCapture.this;
                    videoCapture2.O(videoCapture2.getCameraId(), (x.a) VideoCapture.this.getCurrentConfig(), (StreamSpec) h.g(VideoCapture.this.getAttachedStreamSpec()));
                } else if ((streamInfo2.a() != -1 && streamInfo.a() == -1) || (streamInfo2.a() == -1 && streamInfo.a() != -1)) {
                    VideoCapture videoCapture3 = VideoCapture.this;
                    videoCapture3.u(videoCapture3.f5862d, streamInfo, streamSpec);
                    VideoCapture videoCapture4 = VideoCapture.this;
                    videoCapture4.updateSessionConfig(videoCapture4.f5862d.build());
                    VideoCapture.this.notifyReset();
                } else if (streamInfo2.c() != streamInfo.c()) {
                    VideoCapture videoCapture5 = VideoCapture.this;
                    videoCapture5.u(videoCapture5.f5862d, streamInfo, streamSpec);
                    VideoCapture videoCapture6 = VideoCapture.this;
                    videoCapture6.updateSessionConfig(videoCapture6.f5862d.build());
                    VideoCapture.this.notifyUpdated();
                }
            }
        }

        public void onError(Throwable th2) {
            Logger.w("VideoCapture", "Receive onError from StreamState observer", th2);
        }
    }

    public class b extends CameraCaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5878a = true;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f5879b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f5880c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SessionConfig.Builder f5881d;

        public b(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.a aVar, SessionConfig.Builder builder) {
            this.f5879b = atomicBoolean;
            this.f5880c = aVar;
            this.f5881d = builder;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(SessionConfig.Builder builder) {
            builder.removeCameraCaptureCallback(this);
        }

        public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
            Object tag;
            super.onCaptureCompleted(cameraCaptureResult);
            if (this.f5878a) {
                this.f5878a = false;
                Logger.d("VideoCapture", "cameraCaptureResult timestampNs = " + cameraCaptureResult.getTimestamp() + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
            }
            if (!this.f5879b.get() && (tag = cameraCaptureResult.getTagBundle().getTag("androidx.camera.video.VideoCapture.streamUpdate")) != null && ((Integer) tag).intValue() == this.f5880c.hashCode() && this.f5880c.c(null) && !this.f5879b.getAndSet(true)) {
                CameraXExecutors.mainThreadExecutor().execute(new k1(this, this.f5881d));
            }
        }
    }

    public class c implements FutureCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f5883a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5884b;

        public c(ListenableFuture listenableFuture, boolean z11) {
            this.f5883a = listenableFuture;
            this.f5884b = z11;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            VideoOutput.SourceState sourceState;
            ListenableFuture<Void> listenableFuture = this.f5883a;
            VideoCapture videoCapture = VideoCapture.this;
            if (listenableFuture == videoCapture.f5863e && videoCapture.f5865g != VideoOutput.SourceState.INACTIVE) {
                if (this.f5884b) {
                    sourceState = VideoOutput.SourceState.ACTIVE_STREAMING;
                } else {
                    sourceState = VideoOutput.SourceState.ACTIVE_NON_STREAMING;
                }
                videoCapture.Q(sourceState);
            }
        }

        public void onFailure(Throwable th2) {
            if (!(th2 instanceof CancellationException)) {
                Logger.e("VideoCapture", "Surface update completed with unexpected exception", th2);
            }
        }
    }

    public static final class d<T extends VideoOutput> implements UseCaseConfig.Builder<VideoCapture<T>, x.a<T>, d<T>>, ImageOutputConfig.Builder<d<T>>, ImageInputConfig.Builder<d<T>>, ThreadConfig.Builder<d<T>> {

        /* renamed from: a  reason: collision with root package name */
        public final MutableOptionsBundle f5886a;

        public d(T t11) {
            this(b(t11));
        }

        public static <T extends VideoOutput> MutableOptionsBundle b(T t11) {
            MutableOptionsBundle create = MutableOptionsBundle.create();
            create.insertOption(x.a.f16762b, t11);
            return create;
        }

        public static d<? extends VideoOutput> c(Config config) {
            return new d<>(MutableOptionsBundle.from(config));
        }

        public d<T> A(Function<i1, k1> function) {
            getMutableConfig().insertOption(x.a.f16763c, function);
            return this;
        }

        /* renamed from: B */
        public d<T> setZslDisabled(boolean z11) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z11));
            return this;
        }

        /* renamed from: a */
        public VideoCapture<T> build() {
            return new VideoCapture<>(getUseCaseConfig());
        }

        /* renamed from: d */
        public x.a<T> getUseCaseConfig() {
            return new x.a<>(OptionsBundle.from(this.f5886a));
        }

        /* renamed from: e */
        public d<T> setBackgroundExecutor(Executor executor) {
            getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
            return this;
        }

        /* renamed from: f */
        public d<T> setCameraSelector(CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        /* renamed from: g */
        public d<T> setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public MutableConfig getMutableConfig() {
            return this.f5886a;
        }

        /* renamed from: h */
        public d<T> setCaptureType(UseCaseConfigFactory.CaptureType captureType) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, captureType);
            return this;
        }

        /* renamed from: i */
        public d<T> setCustomOrderedResolutions(List<Size> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, list);
            return this;
        }

        /* renamed from: j */
        public d<T> setDefaultCaptureConfig(CaptureConfig captureConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        /* renamed from: k */
        public d<T> setDefaultResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        /* renamed from: l */
        public d<T> setDefaultSessionConfig(SessionConfig sessionConfig) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        /* renamed from: m */
        public d<T> setDynamicRange(DynamicRange dynamicRange) {
            getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, dynamicRange);
            return this;
        }

        /* renamed from: n */
        public d<T> setHighResolutionDisabled(boolean z11) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z11));
            return this;
        }

        /* renamed from: o */
        public d<T> setMaxResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        /* renamed from: p */
        public d<T> setMirrorMode(int i11) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(i11));
            return this;
        }

        /* renamed from: q */
        public d<T> setResolutionSelector(ResolutionSelector resolutionSelector) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
            return this;
        }

        /* renamed from: r */
        public d<T> setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        /* renamed from: s */
        public d<T> setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        /* renamed from: t */
        public d<T> setSurfaceOccupancyPriority(int i11) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i11));
            return this;
        }

        /* renamed from: u */
        public d<T> setTargetAspectRatio(int i11) {
            throw new UnsupportedOperationException("setTargetAspectRatio is not supported.");
        }

        /* renamed from: v */
        public d<T> setTargetClass(Class<VideoCapture<T>> cls) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID());
            }
            return this;
        }

        /* renamed from: w */
        public d<T> setTargetName(String str) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        /* renamed from: x */
        public d<T> setTargetResolution(Size size) {
            throw new UnsupportedOperationException("setTargetResolution is not supported.");
        }

        /* renamed from: y */
        public d<T> setTargetRotation(int i11) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i11));
            return this;
        }

        /* renamed from: z */
        public d<T> setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }

        public d(MutableOptionsBundle mutableOptionsBundle) {
            Class<VideoCapture> cls = VideoCapture.class;
            this.f5886a = mutableOptionsBundle;
            if (mutableOptionsBundle.containsOption(x.a.f16762b)) {
                Class cls2 = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
                if (cls2 == null || cls2.equals(cls)) {
                    setTargetClass(cls);
                    return;
                }
                throw new IllegalArgumentException("Invalid target class configuration for " + this + l.f34627b + cls2);
            }
            throw new IllegalArgumentException("VideoOutput is required");
        }
    }

    static {
        boolean z11 = true;
        boolean z12 = a0.a.a(PreviewStretchWhenVideoCaptureIsBoundQuirk.class) != null;
        boolean z13 = a0.a.a(PreviewDelayWhenVideoCaptureIsBoundQuirk.class) != null;
        boolean z14 = a0.a.a(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class) != null;
        boolean E = E();
        boolean z15 = a0.a.a(ExtraSupportedResolutionQuirk.class) != null;
        f5858p = z12 || z13 || z14;
        if (!z13 && !z14 && !E && !z15) {
            z11 = false;
        }
        f5857o = z11;
    }

    public VideoCapture(x.a<T> aVar) {
        super(aVar);
    }

    public static boolean E() {
        for (a0.d a11 : a0.a.c(a0.d.class)) {
            if (a11.a()) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ int G(Rect rect, Size size, Size size2) {
        return (Math.abs(size.getWidth() - rect.width()) + Math.abs(size.getHeight() - rect.height())) - (Math.abs(size2.getWidth() - rect.width()) + Math.abs(size2.getHeight() - rect.height()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(DeferrableSurface deferrableSurface) {
        if (deferrableSurface == this.f5859a) {
            clearPipeline();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(String str, x.a aVar, StreamSpec streamSpec, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        O(str, aVar, streamSpec);
    }

    public static /* synthetic */ void L(AtomicBoolean atomicBoolean, SessionConfig.Builder builder, CameraCaptureCallback cameraCaptureCallback) {
        h.j(Threads.isMainThread(), "Surface update cancellation should only occur on main thread.");
        atomicBoolean.set(true);
        builder.removeCameraCaptureCallback(cameraCaptureCallback);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object M(SessionConfig.Builder builder, CallbackToFutureAdapter.a aVar) throws Exception {
        builder.addTag("androidx.camera.video.VideoCapture.streamUpdate", Integer.valueOf(aVar.hashCode()));
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        b bVar = new b(atomicBoolean, aVar, builder);
        aVar.a(new i1(atomicBoolean, builder, bVar), CameraXExecutors.directExecutor());
        builder.addRepeatingCameraCaptureCallback(bVar);
        return String.format("%s[0x%x]", new Object[]{"androidx.camera.video.VideoCapture.streamUpdate", Integer.valueOf(aVar.hashCode())});
    }

    public static k1 P(Function<i1, k1> function, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, r rVar, Size size, DynamicRange dynamicRange, Range<Integer> range) {
        return function.apply(androidx.camera.video.internal.config.d.c(androidx.camera.video.internal.config.d.d(rVar, dynamicRange, videoValidatedEncoderProfilesProxy), Timebase.UPTIME, rVar.d(), size, dynamicRange, range));
    }

    public static boolean T(Rect rect, Size size) {
        return (size.getWidth() == rect.width() && size.getHeight() == rect.height()) ? false : true;
    }

    public static boolean U(CameraInternal cameraInternal) {
        return cameraInternal.getHasTransform() && f5857o;
    }

    public static <T extends VideoOutput> VideoCapture<T> X(T t11) {
        return new d((VideoOutput) h.g(t11)).setCaptureType(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE).build();
    }

    public static void m(Set<Size> set, int i11, int i12, Size size, k1 k1Var) {
        if (i11 <= size.getWidth() && i12 <= size.getHeight()) {
            try {
                set.add(new Size(i11, k1Var.c(i11).clamp(Integer.valueOf(i12)).intValue()));
            } catch (IllegalArgumentException e11) {
                Logger.w("VideoCapture", "No supportedHeights for width: " + i11, e11);
            }
            try {
                set.add(new Size(k1Var.a(i12).clamp(Integer.valueOf(i11)).intValue(), i12));
            } catch (IllegalArgumentException e12) {
                Logger.w("VideoCapture", "No supportedWidths for height: " + i12, e12);
            }
        }
    }

    public static Rect n(Rect rect, Size size, k1 k1Var) {
        Logger.d("VideoCapture", String.format("Adjust cropRect %s by width/height alignment %d/%d and supported widths %s / supported heights %s", new Object[]{TransformUtils.rectToString(rect), Integer.valueOf(k1Var.h()), Integer.valueOf(k1Var.f()), k1Var.d(), k1Var.e()}));
        int h11 = k1Var.h();
        int f11 = k1Var.f();
        Range<Integer> d11 = k1Var.d();
        Range<Integer> e11 = k1Var.e();
        int s11 = s(rect.width(), h11, d11);
        int t11 = t(rect.width(), h11, d11);
        int s12 = s(rect.height(), f11, e11);
        int t12 = t(rect.height(), f11, e11);
        HashSet hashSet = new HashSet();
        m(hashSet, s11, s12, size, k1Var);
        m(hashSet, s11, t12, size, k1Var);
        m(hashSet, t11, s12, size, k1Var);
        m(hashSet, t11, t12, size, k1Var);
        if (hashSet.isEmpty()) {
            Logger.w("VideoCapture", "Can't find valid cropped size");
            return rect;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Logger.d("VideoCapture", "candidatesList = " + arrayList);
        Collections.sort(arrayList, new j1(rect));
        Logger.d("VideoCapture", "sorted candidatesList = " + arrayList);
        Size size2 = (Size) arrayList.get(0);
        int width = size2.getWidth();
        int height = size2.getHeight();
        if (width == rect.width() && height == rect.height()) {
            Logger.d("VideoCapture", "No need to adjust cropRect because crop size is valid.");
            return rect;
        }
        h.i(width % 2 == 0 && height % 2 == 0 && width <= size.getWidth() && height <= size.getHeight());
        Rect rect2 = new Rect(rect);
        if (width != rect.width()) {
            int max = Math.max(0, rect.centerX() - (width / 2));
            rect2.left = max;
            int i11 = max + width;
            rect2.right = i11;
            if (i11 > size.getWidth()) {
                int width2 = size.getWidth();
                rect2.right = width2;
                rect2.left = width2 - width;
            }
        }
        if (height != rect.height()) {
            int max2 = Math.max(0, rect.centerY() - (height / 2));
            rect2.top = max2;
            int i12 = max2 + height;
            rect2.bottom = i12;
            if (i12 > size.getHeight()) {
                int height2 = size.getHeight();
                rect2.bottom = height2;
                rect2.top = height2 - height;
            }
        }
        Logger.d("VideoCapture", String.format("Adjust cropRect from %s to %s", new Object[]{TransformUtils.rectToString(rect), TransformUtils.rectToString(rect2)}));
        return rect2;
    }

    public static int r(boolean z11, int i11, int i12, Range<Integer> range) {
        int i13 = i11 % i12;
        if (i13 != 0) {
            i11 = z11 ? i11 - i13 : i11 + (i12 - i13);
        }
        return range.clamp(Integer.valueOf(i11)).intValue();
    }

    public static int s(int i11, int i12, Range<Integer> range) {
        return r(true, i11, i12, range);
    }

    public static int t(int i11, int i12, Range<Integer> range) {
        return r(false, i11, i12, range);
    }

    public static <T> T y(Observable<T> observable, T t11) {
        ListenableFuture<T> fetchData = observable.fetchData();
        if (!fetchData.isDone()) {
            return t11;
        }
        try {
            return fetchData.get();
        } catch (InterruptedException | ExecutionException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public final r A() {
        return (r) y(B().b(), (Object) null);
    }

    public T B() {
        return ((x.a) getCurrentConfig()).b();
    }

    public final c1 C(CameraInfo cameraInfo) {
        return B().e(cameraInfo);
    }

    public final k1 D(Function<i1, k1> function, c1 c1Var, DynamicRange dynamicRange, r rVar, Size size, Range<Integer> range) {
        k1 k1Var = this.f5867i;
        if (k1Var != null) {
            return k1Var;
        }
        VideoValidatedEncoderProfilesProxy b11 = c1Var.b(size, dynamicRange);
        k1 P = P(function, b11, rVar, size, dynamicRange, range);
        Size size2 = null;
        if (P == null) {
            Logger.w("VideoCapture", "Can't find videoEncoderInfo");
            return null;
        }
        if (b11 != null) {
            size2 = new Size(b11.d().getWidth(), b11.d().getHeight());
        }
        k1 i11 = d0.c.i(P, size2);
        this.f5867i = i11;
        return i11;
    }

    public boolean F(int i11, int i12) {
        Set<Integer> set = StreamInfo.f5854b;
        return !set.contains(Integer.valueOf(i11)) && !set.contains(Integer.valueOf(i12)) && i11 != i12;
    }

    /* renamed from: N */
    public final void I(SurfaceEdge surfaceEdge, CameraInternal cameraInternal, x.a<T> aVar, Timebase timebase) {
        if (cameraInternal == getCamera()) {
            this.f5864f = surfaceEdge.createSurfaceRequest(cameraInternal);
            aVar.b().a(this.f5864f, timebase);
            sendTransformationInfoIfReady();
        }
    }

    public void O(String str, x.a<T> aVar, StreamSpec streamSpec) {
        clearPipeline();
        if (isCurrentCamera(str)) {
            SessionConfig.Builder x11 = x(str, aVar, streamSpec);
            this.f5862d = x11;
            u(x11, this.f5861c, streamSpec);
            updateSessionConfig(this.f5862d.build());
            notifyReset();
        }
    }

    public void Q(VideoOutput.SourceState sourceState) {
        if (sourceState != this.f5865g) {
            this.f5865g = sourceState;
            B().d(sourceState);
        }
    }

    public final void R(SessionConfig.Builder builder, boolean z11) {
        ListenableFuture<Void> listenableFuture = this.f5863e;
        if (listenableFuture != null && listenableFuture.cancel(false)) {
            Logger.d("VideoCapture", "A newer surface update is requested. Previous surface update cancelled.");
        }
        ListenableFuture<Void> a11 = CallbackToFutureAdapter.a(new e1(this, builder));
        this.f5863e = a11;
        Futures.addCallback(a11, new c(a11, z11), CameraXExecutors.mainThreadExecutor());
    }

    public final boolean S() {
        return this.f5861c.b() != null;
    }

    public boolean V(StreamInfo streamInfo, StreamInfo streamInfo2) {
        return this.f5870l && streamInfo.b() != null && streamInfo2.b() == null;
    }

    public final void W(CameraInfoInternal cameraInfoInternal, UseCaseConfig.Builder<?, ?, ?> builder) throws IllegalArgumentException {
        r A = A();
        h.b(A != null, "Unable to update target resolution by null MediaSpec.");
        DynamicRange z11 = z();
        c1 C = C(cameraInfoInternal);
        List<v> c11 = C.c(z11);
        if (c11.isEmpty()) {
            Logger.w("VideoCapture", "Can't find any supported quality on the device.");
            return;
        }
        w1 d11 = A.d();
        y e11 = d11.e();
        List<v> f11 = e11.f(c11);
        Logger.d("VideoCapture", "Found selectedQualities " + f11 + " by " + e11);
        if (!f11.isEmpty()) {
            int b11 = d11.b();
            x xVar = new x(cameraInfoInternal.getSupportedResolutions(getImageFormat()), y.h(C, z11));
            ArrayList arrayList = new ArrayList();
            for (v g11 : f11) {
                arrayList.addAll(xVar.g(g11, b11));
            }
            Logger.d("VideoCapture", "Set custom ordered resolutions = " + arrayList);
            builder.getMutableConfig().insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, arrayList);
            return;
        }
        throw new IllegalArgumentException("Unable to find supported quality by QualitySelector");
    }

    public final void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.f5859a;
        if (deferrableSurface != null) {
            deferrableSurface.close();
            this.f5859a = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.f5866h;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.f5866h = null;
        }
        SurfaceEdge surfaceEdge = this.f5860b;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.f5860b = null;
        }
        this.f5867i = null;
        this.f5868j = null;
        this.f5864f = null;
        this.f5861c = StreamInfo.f5853a;
        this.f5869k = 0;
        this.f5870l = false;
    }

    public UseCaseConfig<?> getDefaultConfig(boolean z11, UseCaseConfigFactory useCaseConfigFactory) {
        Defaults defaults = f5856n;
        Config config = useCaseConfigFactory.getConfig(defaults.getConfig().getCaptureType(), 1);
        if (z11) {
            config = o.b(config, defaults.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        return hashSet;
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return d.c(config);
    }

    public final Rect o(Rect rect, int i11) {
        return S() ? TransformUtils.sizeToRect(TransformUtils.getRotatedSize(((SurfaceRequest.TransformationInfo) h.g(this.f5861c.b())).getCropRect(), i11)) : rect;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [androidx.camera.core.impl.UseCaseConfig$Builder, androidx.camera.core.impl.UseCaseConfig$Builder<?, ?, ?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.UseCaseConfig<?> onMergeConfig(androidx.camera.core.impl.CameraInfoInternal r1, androidx.camera.core.impl.UseCaseConfig.Builder<?, ?, ?> r2) {
        /*
            r0 = this;
            r0.W(r1, r2)
            androidx.camera.core.impl.UseCaseConfig r1 = r2.getUseCaseConfig()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.VideoCapture.onMergeConfig(androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.impl.UseCaseConfig$Builder):androidx.camera.core.impl.UseCaseConfig");
    }

    public void onStateAttached() {
        super.onStateAttached();
        h.h(getAttachedStreamSpec(), "The suggested stream specification should be already updated and shouldn't be null.");
        h.j(this.f5864f == null, "The surface request should be null when VideoCapture is attached.");
        StreamSpec streamSpec = (StreamSpec) h.g(getAttachedStreamSpec());
        this.f5861c = (StreamInfo) y(B().c(), StreamInfo.f5853a);
        SessionConfig.Builder x11 = x(getCameraId(), (x.a) getCurrentConfig(), streamSpec);
        this.f5862d = x11;
        u(x11, this.f5861c, streamSpec);
        updateSessionConfig(this.f5862d.build());
        notifyActive();
        B().c().addObserver(CameraXExecutors.mainThreadExecutor(), this.f5871m);
        Q(VideoOutput.SourceState.ACTIVE_NON_STREAMING);
    }

    public void onStateDetached() {
        h.j(Threads.isMainThread(), "VideoCapture can only be detached on the main thread.");
        Q(VideoOutput.SourceState.INACTIVE);
        B().c().removeObserver(this.f5871m);
        ListenableFuture<Void> listenableFuture = this.f5863e;
        if (listenableFuture != null && listenableFuture.cancel(false)) {
            Logger.d("VideoCapture", "VideoCapture is detached from the camera. Surface update cancelled.");
        }
        clearPipeline();
    }

    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        this.f5862d.addImplementationOptions(config);
        updateSessionConfig(this.f5862d.build());
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec) {
        Logger.d("VideoCapture", "onSuggestedStreamSpecUpdated: " + streamSpec);
        List customOrderedResolutions = ((x.a) getCurrentConfig()).getCustomOrderedResolutions((List) null);
        if (customOrderedResolutions != null && !customOrderedResolutions.contains(streamSpec.getResolution())) {
            Logger.w("VideoCapture", "suggested resolution " + streamSpec.getResolution() + " is not in custom ordered resolutions " + customOrderedResolutions);
        }
        return streamSpec;
    }

    public final Size p(Size size, Rect rect, Rect rect2) {
        if (!S() || rect2.equals(rect)) {
            return size;
        }
        float height = ((float) rect2.height()) / ((float) rect.height());
        return new Size((int) Math.ceil((double) (((float) size.getWidth()) * height)), (int) Math.ceil((double) (((float) size.getHeight()) * height)));
    }

    public final int q(int i11) {
        return S() ? TransformUtils.within360(i11 - this.f5861c.b().getRotationDegrees()) : i11;
    }

    public final void sendTransformationInfoIfReady() {
        CameraInternal camera = getCamera();
        SurfaceEdge surfaceEdge = this.f5860b;
        if (camera != null && surfaceEdge != null) {
            int q11 = q(getRelativeRotation(camera, isMirroringRequired(camera)));
            this.f5869k = q11;
            surfaceEdge.updateTransformation(q11, getAppTargetRotation());
        }
    }

    public void setViewPortCropRect(Rect rect) {
        super.setViewPortCropRect(rect);
        sendTransformationInfoIfReady();
    }

    public final boolean shouldMirror(CameraInternal cameraInternal) {
        return cameraInternal.getHasTransform() && isMirroringRequired(cameraInternal);
    }

    public String toString() {
        return "VideoCapture:" + getName();
    }

    public void u(SessionConfig.Builder builder, StreamInfo streamInfo, StreamSpec streamSpec) {
        boolean z11 = true;
        boolean z12 = streamInfo.a() == -1;
        if (streamInfo.c() != StreamInfo.StreamState.ACTIVE) {
            z11 = false;
        }
        if (!z12 || !z11) {
            builder.clearSurfaces();
            DynamicRange dynamicRange = streamSpec.getDynamicRange();
            if (!z12) {
                if (z11) {
                    builder.addSurface(this.f5859a, dynamicRange);
                } else {
                    builder.addNonRepeatingSurface(this.f5859a, dynamicRange);
                }
            }
            R(builder, z11);
            return;
        }
        throw new IllegalStateException("Unexpected stream state, stream is error but active");
    }

    public final Rect v(Size size, k1 k1Var) {
        Rect rect;
        if (getViewPortCropRect() != null) {
            rect = getViewPortCropRect();
        } else {
            rect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return (k1Var == null || k1Var.g(rect.width(), rect.height())) ? rect : n(rect, size, k1Var);
    }

    public final SurfaceProcessorNode w(CameraInternal cameraInternal, Rect rect, Size size, DynamicRange dynamicRange) {
        SurfaceProcessorInternal surfaceProcessorInternal;
        if (getEffect() == null && !U(cameraInternal) && !T(rect, size) && !shouldMirror(cameraInternal) && !S()) {
            return null;
        }
        Logger.d("VideoCapture", "Surface processing is enabled.");
        CameraInternal camera = getCamera();
        Objects.requireNonNull(camera);
        CameraInternal cameraInternal2 = camera;
        if (getEffect() != null) {
            surfaceProcessorInternal = getEffect().createSurfaceProcessorInternal();
        } else {
            surfaceProcessorInternal = DefaultSurfaceProcessor.Factory.newInstance(dynamicRange);
        }
        return new SurfaceProcessorNode(cameraInternal2, surfaceProcessorInternal);
    }

    @SuppressLint({"WrongConstant"})
    public final SessionConfig.Builder x(String str, x.a<T> aVar, StreamSpec streamSpec) {
        Timebase timebase;
        x.a<T> aVar2 = aVar;
        Threads.checkMainThread();
        CameraInternal cameraInternal = (CameraInternal) h.g(getCamera());
        Size resolution = streamSpec.getResolution();
        f1 f1Var = new f1(this);
        Range<Integer> expectedFrameRateRange = streamSpec.getExpectedFrameRateRange();
        if (Objects.equals(expectedFrameRateRange, StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
            expectedFrameRateRange = Defaults.f5875d;
        }
        Range<Integer> range = expectedFrameRateRange;
        r A = A();
        Objects.requireNonNull(A);
        c1 C = C(cameraInternal.getCameraInfo());
        DynamicRange dynamicRange = streamSpec.getDynamicRange();
        k1 D = D(aVar.a(), C, dynamicRange, A, resolution, range);
        this.f5869k = q(getRelativeRotation(cameraInternal, isMirroringRequired(cameraInternal)));
        Rect v11 = v(resolution, D);
        Rect o11 = o(v11, this.f5869k);
        this.f5868j = o11;
        Size p11 = p(resolution, v11, o11);
        if (S()) {
            this.f5870l = true;
        }
        SurfaceProcessorNode w11 = w(cameraInternal, this.f5868j, resolution, dynamicRange);
        this.f5866h = w11;
        if (w11 != null || !cameraInternal.getHasTransform()) {
            timebase = cameraInternal.getCameraInfoInternal().getTimebase();
        } else {
            timebase = Timebase.UPTIME;
        }
        Timebase timebase2 = timebase;
        Logger.d("VideoCapture", "camera timebase = " + cameraInternal.getCameraInfoInternal().getTimebase() + ", processing timebase = " + timebase2);
        StreamSpec build = streamSpec.toBuilder().setResolution(p11).setExpectedFrameRateRange(range).build();
        h.i(this.f5860b == null);
        SurfaceEdge surfaceEdge = new SurfaceEdge(2, 34, build, getSensorToBufferTransformMatrix(), cameraInternal.getHasTransform(), this.f5868j, this.f5869k, getAppTargetRotation(), shouldMirror(cameraInternal));
        this.f5860b = surfaceEdge;
        surfaceEdge.addOnInvalidatedListener(f1Var);
        if (this.f5866h != null) {
            SurfaceProcessorNode.OutConfig of2 = SurfaceProcessorNode.OutConfig.of(this.f5860b);
            SurfaceEdge surfaceEdge2 = (SurfaceEdge) this.f5866h.transform(SurfaceProcessorNode.In.of(this.f5860b, Collections.singletonList(of2))).get(of2);
            Objects.requireNonNull(surfaceEdge2);
            surfaceEdge2.addOnInvalidatedListener(new h1(this, surfaceEdge2, cameraInternal, aVar, timebase2));
            this.f5864f = surfaceEdge2.createSurfaceRequest(cameraInternal);
            DeferrableSurface deferrableSurface = this.f5860b.getDeferrableSurface();
            this.f5859a = deferrableSurface;
            deferrableSurface.getTerminationFuture().addListener(new g1(this, deferrableSurface), CameraXExecutors.mainThreadExecutor());
        } else {
            SurfaceRequest createSurfaceRequest = this.f5860b.createSurfaceRequest(cameraInternal);
            this.f5864f = createSurfaceRequest;
            this.f5859a = createSurfaceRequest.getDeferrableSurface();
        }
        aVar.b().a(this.f5864f, timebase2);
        sendTransformationInfoIfReady();
        this.f5859a.setContainerClass(MediaCodec.class);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(aVar2, streamSpec.getResolution());
        createFrom.setExpectedFrameRateRange(streamSpec.getExpectedFrameRateRange());
        createFrom.addErrorListener(new d1(this, str, aVar2, streamSpec));
        if (f5858p) {
            createFrom.setTemplateType(1);
        }
        if (streamSpec.getImplementationOptions() != null) {
            createFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        return createFrom;
    }

    public DynamicRange z() {
        if (getCurrentConfig().hasDynamicRange()) {
            return getCurrentConfig().getDynamicRange();
        }
        return Defaults.f5876e;
    }
}
