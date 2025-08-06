package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.core.util.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class UseCase {
    private SessionConfig mAttachedSessionConfig = SessionConfig.defaultEmptySessionConfig();
    private StreamSpec mAttachedStreamSpec;
    private CameraInternal mCamera;
    private UseCaseConfig<?> mCameraConfig;
    private final Object mCameraLock = new Object();
    private UseCaseConfig<?> mCurrentConfig;
    private CameraEffect mEffect;
    private UseCaseConfig<?> mExtendedConfig;
    private Matrix mSensorToBufferTransformMatrix = new Matrix();
    private State mState = State.INACTIVE;
    private final Set<StateChangeCallback> mStateChangeCallbacks = new HashSet();
    private UseCaseConfig<?> mUseCaseConfig;
    private Rect mViewPortCropRect;

    /* renamed from: androidx.camera.core.UseCase$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$UseCase$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.core.UseCase$State[] r0 = androidx.camera.core.UseCase.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$camera$core$UseCase$State = r0
                androidx.camera.core.UseCase$State r1 = androidx.camera.core.UseCase.State.INACTIVE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$camera$core$UseCase$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.UseCase$State r1 = androidx.camera.core.UseCase.State.ACTIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.UseCase.AnonymousClass1.<clinit>():void");
        }
    }

    public interface EventCallback {
        void onBind(CameraInfo cameraInfo);

        void onUnbind();
    }

    public enum State {
        ACTIVE,
        INACTIVE
    }

    public interface StateChangeCallback {
        void onUseCaseActive(UseCase useCase);

        void onUseCaseInactive(UseCase useCase);

        void onUseCaseReset(UseCase useCase);

        void onUseCaseUpdated(UseCase useCase);
    }

    public UseCase(UseCaseConfig<?> useCaseConfig) {
        this.mUseCaseConfig = useCaseConfig;
        this.mCurrentConfig = useCaseConfig;
    }

    private void addStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.add(stateChangeCallback);
    }

    private void removeStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.remove(stateChangeCallback);
    }

    public static int snapToSurfaceRotation(int i11) {
        h.c(i11, 0, 359, "orientation");
        if (i11 >= 315 || i11 < 45) {
            return 0;
        }
        if (i11 >= 225) {
            return 1;
        }
        return i11 >= 135 ? 2 : 3;
    }

    @SuppressLint({"WrongConstant"})
    public final void bindToCamera(CameraInternal cameraInternal, UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
        synchronized (this.mCameraLock) {
            this.mCamera = cameraInternal;
            addStateChangeCallback(cameraInternal);
        }
        this.mExtendedConfig = useCaseConfig;
        this.mCameraConfig = useCaseConfig2;
        UseCaseConfig<?> mergeConfigs = mergeConfigs(cameraInternal.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        this.mCurrentConfig = mergeConfigs;
        EventCallback useCaseEventCallback = mergeConfigs.getUseCaseEventCallback((EventCallback) null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onBind(cameraInternal.getCameraInfoInternal());
        }
        onBind();
    }

    public int getAppTargetRotation() {
        return ((ImageOutputConfig) this.mCurrentConfig).getAppTargetRotation(-1);
    }

    public StreamSpec getAttachedStreamSpec() {
        return this.mAttachedStreamSpec;
    }

    public Size getAttachedSurfaceResolution() {
        StreamSpec streamSpec = this.mAttachedStreamSpec;
        if (streamSpec != null) {
            return streamSpec.getResolution();
        }
        return null;
    }

    public CameraInternal getCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mCameraLock) {
            cameraInternal = this.mCamera;
        }
        return cameraInternal;
    }

    public CameraControlInternal getCameraControl() {
        synchronized (this.mCameraLock) {
            CameraInternal cameraInternal = this.mCamera;
            if (cameraInternal == null) {
                CameraControlInternal cameraControlInternal = CameraControlInternal.DEFAULT_EMPTY_INSTANCE;
                return cameraControlInternal;
            }
            CameraControlInternal cameraControlInternal2 = cameraInternal.getCameraControlInternal();
            return cameraControlInternal2;
        }
    }

    public String getCameraId() {
        CameraInternal camera = getCamera();
        return ((CameraInternal) h.h(camera, "No camera attached to use case: " + this)).getCameraInfoInternal().getCameraId();
    }

    public UseCaseConfig<?> getCurrentConfig() {
        return this.mCurrentConfig;
    }

    public abstract UseCaseConfig<?> getDefaultConfig(boolean z11, UseCaseConfigFactory useCaseConfigFactory);

    public CameraEffect getEffect() {
        return this.mEffect;
    }

    public int getImageFormat() {
        return this.mCurrentConfig.getInputFormat();
    }

    public int getMirrorModeInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getMirrorMode(0);
    }

    public String getName() {
        UseCaseConfig<?> useCaseConfig = this.mCurrentConfig;
        String targetName = useCaseConfig.getTargetName("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(targetName);
        return targetName;
    }

    public int getRelativeRotation(CameraInternal cameraInternal) {
        return getRelativeRotation(cameraInternal, false);
    }

    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal camera = getCamera();
        Size attachedSurfaceResolution = getAttachedSurfaceResolution();
        if (camera == null || attachedSurfaceResolution == null) {
            return null;
        }
        Rect viewPortCropRect = getViewPortCropRect();
        if (viewPortCropRect == null) {
            viewPortCropRect = new Rect(0, 0, attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
        }
        return new ResolutionInfo(attachedSurfaceResolution, viewPortCropRect, getRelativeRotation(camera));
    }

    public Matrix getSensorToBufferTransformMatrix() {
        return this.mSensorToBufferTransformMatrix;
    }

    public SessionConfig getSessionConfig() {
        return this.mAttachedSessionConfig;
    }

    public Set<Integer> getSupportedEffectTargets() {
        return Collections.emptySet();
    }

    public Range<Integer> getTargetFrameRateInternal() {
        return this.mCurrentConfig.getTargetFrameRate(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
    }

    @SuppressLint({"WrongConstant"})
    public int getTargetRotationInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getTargetRotation(0);
    }

    public abstract UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config);

    public Rect getViewPortCropRect() {
        return this.mViewPortCropRect;
    }

    public boolean isCurrentCamera(String str) {
        if (getCamera() == null) {
            return false;
        }
        return Objects.equals(str, getCameraId());
    }

    public boolean isEffectTargetsSupported(int i11) {
        for (Integer intValue : getSupportedEffectTargets()) {
            if (TargetUtils.isSuperset(i11, intValue.intValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean isMirroringRequired(CameraInternal cameraInternal) {
        int mirrorModeInternal = getMirrorModeInternal();
        if (mirrorModeInternal == 0) {
            return false;
        }
        if (mirrorModeInternal == 1) {
            return true;
        }
        if (mirrorModeInternal == 2) {
            return cameraInternal.isFrontFacing();
        }
        throw new AssertionError("Unknown mirrorMode: " + mirrorModeInternal);
    }

    public UseCaseConfig<?> mergeConfigs(CameraInfoInternal cameraInfoInternal, UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
        MutableOptionsBundle mutableOptionsBundle;
        if (useCaseConfig2 != null) {
            mutableOptionsBundle = MutableOptionsBundle.from(useCaseConfig2);
            mutableOptionsBundle.removeOption(TargetConfig.OPTION_TARGET_NAME);
        } else {
            mutableOptionsBundle = MutableOptionsBundle.create();
        }
        if (this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO) || this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) {
            Config.Option<ResolutionSelector> option = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
            if (mutableOptionsBundle.containsOption(option)) {
                mutableOptionsBundle.removeOption(option);
            }
        }
        UseCaseConfig<?> useCaseConfig3 = this.mUseCaseConfig;
        Config.Option<ResolutionSelector> option2 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (useCaseConfig3.containsOption(option2)) {
            Config.Option<Size> option3 = ImageOutputConfig.OPTION_MAX_RESOLUTION;
            if (mutableOptionsBundle.containsOption(option3) && ((ResolutionSelector) this.mUseCaseConfig.retrieveOption(option2)).getResolutionStrategy() != null) {
                mutableOptionsBundle.removeOption(option3);
            }
        }
        for (Config.Option<?> c11 : this.mUseCaseConfig.listOptions()) {
            o.c(mutableOptionsBundle, mutableOptionsBundle, this.mUseCaseConfig, c11);
        }
        if (useCaseConfig != null) {
            for (Config.Option next : useCaseConfig.listOptions()) {
                if (!next.getId().equals(TargetConfig.OPTION_TARGET_NAME.getId())) {
                    o.c(mutableOptionsBundle, mutableOptionsBundle, useCaseConfig, next);
                }
            }
        }
        if (mutableOptionsBundle.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) {
            Config.Option<Integer> option4 = ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO;
            if (mutableOptionsBundle.containsOption(option4)) {
                mutableOptionsBundle.removeOption(option4);
            }
        }
        Config.Option<ResolutionSelector> option5 = ImageOutputConfig.OPTION_RESOLUTION_SELECTOR;
        if (mutableOptionsBundle.containsOption(option5) && ((ResolutionSelector) mutableOptionsBundle.retrieveOption(option5)).getAllowedResolutionMode() != 0) {
            mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
        }
        return onMergeConfig(cameraInfoInternal, getUseCaseConfigBuilder(mutableOptionsBundle));
    }

    public final void notifyActive() {
        this.mState = State.ACTIVE;
        notifyState();
    }

    public final void notifyInactive() {
        this.mState = State.INACTIVE;
        notifyState();
    }

    public final void notifyReset() {
        for (StateChangeCallback onUseCaseReset : this.mStateChangeCallbacks) {
            onUseCaseReset.onUseCaseReset(this);
        }
    }

    public final void notifyState() {
        int i11 = AnonymousClass1.$SwitchMap$androidx$camera$core$UseCase$State[this.mState.ordinal()];
        if (i11 == 1) {
            for (StateChangeCallback onUseCaseInactive : this.mStateChangeCallbacks) {
                onUseCaseInactive.onUseCaseInactive(this);
            }
        } else if (i11 == 2) {
            for (StateChangeCallback onUseCaseActive : this.mStateChangeCallbacks) {
                onUseCaseActive.onUseCaseActive(this);
            }
        }
    }

    public final void notifyUpdated() {
        for (StateChangeCallback onUseCaseUpdated : this.mStateChangeCallbacks) {
            onUseCaseUpdated.onUseCaseUpdated(this);
        }
    }

    public void onBind() {
    }

    public void onCameraControlReady() {
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [androidx.camera.core.impl.UseCaseConfig$Builder, androidx.camera.core.impl.UseCaseConfig$Builder<?, ?, ?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.UseCaseConfig<?> onMergeConfig(androidx.camera.core.impl.CameraInfoInternal r1, androidx.camera.core.impl.UseCaseConfig.Builder<?, ?, ?> r2) {
        /*
            r0 = this;
            androidx.camera.core.impl.UseCaseConfig r1 = r2.getUseCaseConfig()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.UseCase.onMergeConfig(androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.impl.UseCaseConfig$Builder):androidx.camera.core.impl.UseCaseConfig");
    }

    public void onStateAttached() {
    }

    public void onStateDetached() {
    }

    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        StreamSpec streamSpec = this.mAttachedStreamSpec;
        if (streamSpec != null) {
            return streamSpec.toBuilder().setImplementationOptions(config).build();
        }
        throw new UnsupportedOperationException("Attempt to update the implementation options for a use case without attached stream specifications.");
    }

    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec) {
        return streamSpec;
    }

    public void onUnbind() {
    }

    public void setEffect(CameraEffect cameraEffect) {
        h.a(cameraEffect == null || isEffectTargetsSupported(cameraEffect.getTargets()));
        this.mEffect = cameraEffect;
    }

    public void setSensorToBufferTransformMatrix(Matrix matrix) {
        this.mSensorToBufferTransformMatrix = new Matrix(matrix);
    }

    public boolean setTargetRotationInternal(int i11) {
        int targetRotation = ((ImageOutputConfig) getCurrentConfig()).getTargetRotation(-1);
        if (targetRotation != -1 && targetRotation == i11) {
            return false;
        }
        UseCaseConfig.Builder useCaseConfigBuilder = getUseCaseConfigBuilder(this.mUseCaseConfig);
        UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(useCaseConfigBuilder, i11);
        this.mUseCaseConfig = useCaseConfigBuilder.getUseCaseConfig();
        CameraInternal camera = getCamera();
        if (camera == null) {
            this.mCurrentConfig = this.mUseCaseConfig;
            return true;
        }
        this.mCurrentConfig = mergeConfigs(camera.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        return true;
    }

    public void setViewPortCropRect(Rect rect) {
        this.mViewPortCropRect = rect;
    }

    public final void unbindFromCamera(CameraInternal cameraInternal) {
        onUnbind();
        EventCallback useCaseEventCallback = this.mCurrentConfig.getUseCaseEventCallback((EventCallback) null);
        if (useCaseEventCallback != null) {
            useCaseEventCallback.onUnbind();
        }
        synchronized (this.mCameraLock) {
            h.a(cameraInternal == this.mCamera);
            removeStateChangeCallback(this.mCamera);
            this.mCamera = null;
        }
        this.mAttachedStreamSpec = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
    }

    public void updateSessionConfig(SessionConfig sessionConfig) {
        this.mAttachedSessionConfig = sessionConfig;
        for (DeferrableSurface next : sessionConfig.getSurfaces()) {
            if (next.getContainerClass() == null) {
                next.setContainerClass(getClass());
            }
        }
    }

    public void updateSuggestedStreamSpec(StreamSpec streamSpec) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecUpdated(streamSpec);
    }

    public void updateSuggestedStreamSpecImplementationOptions(Config config) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecImplementationOptionsUpdated(config);
    }

    public int getRelativeRotation(CameraInternal cameraInternal, boolean z11) {
        int sensorRotationDegrees = cameraInternal.getCameraInfoInternal().getSensorRotationDegrees(getTargetRotationInternal());
        return !cameraInternal.getHasTransform() && z11 ? TransformUtils.within360(-sensorRotationDegrees) : sensorRotationDegrees;
    }
}
