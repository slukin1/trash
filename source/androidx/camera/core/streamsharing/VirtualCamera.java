package androidx.camera.core.streamsharing;

import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.c;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class VirtualCamera implements CameraInternal {
    private static final String UNSUPPORTED_MESSAGE = "Operation not supported by VirtualCamera.";
    public final Set<UseCase> mChildren;
    public final Map<UseCase, Boolean> mChildrenActiveState = new HashMap();
    public final Map<UseCase, SurfaceEdge> mChildrenEdges = new HashMap();
    private final CameraInternal mParentCamera;
    private final CameraCaptureCallback mParentMetadataCallback = createCameraCaptureCallback();
    private final UseCaseConfigFactory mUseCaseConfigFactory;
    private final VirtualCameraControl mVirtualCameraControl;

    public VirtualCamera(CameraInternal cameraInternal, Set<UseCase> set, UseCaseConfigFactory useCaseConfigFactory, StreamSharing.Control control) {
        this.mParentCamera = cameraInternal;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        this.mChildren = set;
        this.mVirtualCameraControl = new VirtualCameraControl(cameraInternal.getCameraControlInternal(), control);
        for (UseCase put : set) {
            this.mChildrenActiveState.put(put, Boolean.FALSE);
        }
    }

    private void forceSetProvider(SurfaceEdge surfaceEdge, DeferrableSurface deferrableSurface, SessionConfig sessionConfig) {
        surfaceEdge.invalidate();
        try {
            surfaceEdge.setProvider(deferrableSurface);
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            for (SessionConfig.ErrorListener onError : sessionConfig.getErrorListeners()) {
                onError.onError(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        }
    }

    private static int getChildFormat(UseCase useCase) {
        return useCase instanceof ImageCapture ? 256 : 34;
    }

    private int getChildRotationDegrees(UseCase useCase) {
        if (useCase instanceof Preview) {
            return this.mParentCamera.getCameraInfo().getSensorRotationDegrees(((Preview) useCase).getTargetRotation());
        }
        return 0;
    }

    public static DeferrableSurface getChildSurface(UseCase useCase) {
        List<DeferrableSurface> list;
        if (useCase instanceof ImageCapture) {
            list = useCase.getSessionConfig().getSurfaces();
        } else {
            list = useCase.getSessionConfig().getRepeatingCaptureConfig().getSurfaces();
        }
        h.i(list.size() <= 1);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    private static int getChildTargetType(UseCase useCase) {
        if (useCase instanceof Preview) {
            return 1;
        }
        return useCase instanceof ImageCapture ? 4 : 2;
    }

    private static int getHighestSurfacePriority(Set<UseCaseConfig<?>> set) {
        int i11 = 0;
        for (UseCaseConfig<?> surfaceOccupancyPriority : set) {
            i11 = Math.max(i11, surfaceOccupancyPriority.getSurfaceOccupancyPriority());
        }
        return i11;
    }

    private SurfaceEdge getUseCaseEdge(UseCase useCase) {
        SurfaceEdge surfaceEdge = this.mChildrenEdges.get(useCase);
        Objects.requireNonNull(surfaceEdge);
        return surfaceEdge;
    }

    private boolean isUseCaseActive(UseCase useCase) {
        Boolean bool = this.mChildrenActiveState.get(useCase);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public static void sendCameraCaptureResultToChild(CameraCaptureResult cameraCaptureResult, SessionConfig sessionConfig) {
        for (CameraCaptureCallback onCaptureCompleted : sessionConfig.getRepeatingCameraCaptureCallbacks()) {
            onCaptureCompleted.onCaptureCompleted(new VirtualCameraCaptureResult(sessionConfig.getRepeatingCaptureConfig().getTagBundle(), cameraCaptureResult));
        }
    }

    public void attachUseCases(Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void bindChildren() {
        for (UseCase next : this.mChildren) {
            next.bindToCamera(this, (UseCaseConfig<?>) null, next.getDefaultConfig(true, this.mUseCaseConfigFactory));
        }
    }

    public void close() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public CameraCaptureCallback createCameraCaptureCallback() {
        return new CameraCaptureCallback() {
            public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
                super.onCaptureCompleted(cameraCaptureResult);
                for (UseCase sessionConfig : VirtualCamera.this.mChildren) {
                    VirtualCamera.sendCameraCaptureResultToChild(cameraCaptureResult, sessionConfig.getSessionConfig());
                }
            }
        };
    }

    public void detachUseCases(Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public /* synthetic */ CameraControl getCameraControl() {
        return j.a(this);
    }

    public CameraControlInternal getCameraControlInternal() {
        return this.mVirtualCameraControl;
    }

    public /* synthetic */ CameraInfo getCameraInfo() {
        return j.b(this);
    }

    public CameraInfoInternal getCameraInfoInternal() {
        return this.mParentCamera.getCameraInfoInternal();
    }

    public /* synthetic */ LinkedHashSet getCameraInternals() {
        return j.c(this);
    }

    public Observable<CameraInternal.State> getCameraState() {
        return this.mParentCamera.getCameraState();
    }

    public Set<UseCase> getChildren() {
        return this.mChildren;
    }

    public Map<UseCase, SurfaceProcessorNode.OutConfig> getChildrenOutConfigs(SurfaceEdge surfaceEdge) {
        HashMap hashMap = new HashMap();
        for (UseCase next : this.mChildren) {
            int childRotationDegrees = getChildRotationDegrees(next);
            hashMap.put(next, SurfaceProcessorNode.OutConfig.of(getChildTargetType(next), getChildFormat(next), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), childRotationDegrees), childRotationDegrees, next.isMirroringRequired(this)));
        }
        return hashMap;
    }

    public /* synthetic */ CameraConfig getExtendedConfig() {
        return j.d(this);
    }

    public boolean getHasTransform() {
        return false;
    }

    public CameraCaptureCallback getParentMetadataCallback() {
        return this.mParentMetadataCallback;
    }

    public /* synthetic */ boolean isFrontFacing() {
        return j.f(this);
    }

    public /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return c.a(this, useCaseArr);
    }

    public void mergeChildrenConfigs(MutableConfig mutableConfig) {
        HashSet hashSet = new HashSet();
        for (UseCase next : this.mChildren) {
            hashSet.add(next.mergeConfigs(this.mParentCamera.getCameraInfoInternal(), (UseCaseConfig<?>) null, next.getDefaultConfig(true, this.mUseCaseConfigFactory)));
        }
        mutableConfig.insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, ResolutionUtils.getMergedResolutions(new ArrayList(this.mParentCamera.getCameraInfoInternal().getSupportedResolutions(34)), TransformUtils.rectToSize(this.mParentCamera.getCameraControlInternal().getSensorRect()), hashSet));
        mutableConfig.insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(getHighestSurfacePriority(hashSet)));
    }

    public void notifyStateAttached() {
        for (UseCase onStateAttached : this.mChildren) {
            onStateAttached.onStateAttached();
        }
    }

    public void notifyStateDetached() {
        for (UseCase onStateDetached : this.mChildren) {
            onStateDetached.onStateDetached();
        }
    }

    public void onUseCaseActive(UseCase useCase) {
        Threads.checkMainThread();
        if (!isUseCaseActive(useCase)) {
            this.mChildrenActiveState.put(useCase, Boolean.TRUE);
            DeferrableSurface childSurface = getChildSurface(useCase);
            if (childSurface != null) {
                forceSetProvider(getUseCaseEdge(useCase), childSurface, useCase.getSessionConfig());
            }
        }
    }

    public void onUseCaseInactive(UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            this.mChildrenActiveState.put(useCase, Boolean.FALSE);
            getUseCaseEdge(useCase).disconnect();
        }
    }

    public void onUseCaseReset(UseCase useCase) {
        DeferrableSurface childSurface;
        Threads.checkMainThread();
        SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
        useCaseEdge.invalidate();
        if (isUseCaseActive(useCase) && (childSurface = getChildSurface(useCase)) != null) {
            forceSetProvider(useCaseEdge, childSurface, useCase.getSessionConfig());
        }
    }

    public void onUseCaseUpdated(UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
            DeferrableSurface childSurface = getChildSurface(useCase);
            if (childSurface != null) {
                forceSetProvider(useCaseEdge, childSurface, useCase.getSessionConfig());
            } else {
                useCaseEdge.disconnect();
            }
        }
    }

    public void open() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public ListenableFuture<Void> release() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void resetChildren() {
        Threads.checkMainThread();
        for (UseCase onUseCaseReset : this.mChildren) {
            onUseCaseReset(onUseCaseReset);
        }
    }

    public /* synthetic */ void setActiveResumingMode(boolean z11) {
        j.g(this, z11);
    }

    public void setChildrenEdges(Map<UseCase, SurfaceEdge> map) {
        this.mChildrenEdges.clear();
        this.mChildrenEdges.putAll(map);
        for (Map.Entry next : this.mChildrenEdges.entrySet()) {
            UseCase useCase = (UseCase) next.getKey();
            SurfaceEdge surfaceEdge = (SurfaceEdge) next.getValue();
            useCase.setViewPortCropRect(surfaceEdge.getCropRect());
            useCase.setSensorToBufferTransformMatrix(surfaceEdge.getSensorToBufferTransform());
            useCase.updateSuggestedStreamSpec(surfaceEdge.getStreamSpec());
            useCase.notifyState();
        }
    }

    public /* synthetic */ void setExtendedConfig(CameraConfig cameraConfig) {
        j.h(this, cameraConfig);
    }

    public void unbindChildren() {
        for (UseCase unbindFromCamera : this.mChildren) {
            unbindFromCamera.unbindFromCamera(this);
        }
    }
}
