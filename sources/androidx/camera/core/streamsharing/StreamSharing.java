package androidx.camera.core.streamsharing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class StreamSharing extends UseCase {
    private static final String TAG = "StreamSharing";
    private SurfaceEdge mCameraEdge;
    private final StreamSharingConfig mDefaultConfig;
    private SurfaceProcessorNode mEffectNode;
    public SessionConfig.Builder mSessionConfigBuilder;
    private SurfaceEdge mSharingInputEdge;
    private SurfaceProcessorNode mSharingNode;
    private final VirtualCamera mVirtualCamera;

    public interface Control {
        ListenableFuture<Void> jpegSnapshot(int i11, int i12);
    }

    public StreamSharing(CameraInternal cameraInternal, Set<UseCase> set, UseCaseConfigFactory useCaseConfigFactory) {
        super(getDefaultConfig(set));
        this.mDefaultConfig = getDefaultConfig(set);
        this.mVirtualCamera = new VirtualCamera(cameraInternal, set, useCaseConfigFactory, new b(this));
    }

    private void addCameraErrorListener(SessionConfig.Builder builder, String str, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec) {
        builder.addErrorListener(new a(this, str, useCaseConfig, streamSpec));
    }

    private void clearPipeline() {
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        SurfaceEdge surfaceEdge2 = this.mSharingInputEdge;
        if (surfaceEdge2 != null) {
            surfaceEdge2.close();
            this.mSharingInputEdge = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.mSharingNode;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.mSharingNode = null;
        }
        SurfaceProcessorNode surfaceProcessorNode2 = this.mEffectNode;
        if (surfaceProcessorNode2 != null) {
            surfaceProcessorNode2.release();
            this.mEffectNode = null;
        }
    }

    private SessionConfig createPipelineAndUpdateChildrenSpecs(String str, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec) {
        Threads.checkMainThread();
        CameraInternal cameraInternal = (CameraInternal) h.g(getCamera());
        Matrix sensorToBufferTransformMatrix = getSensorToBufferTransformMatrix();
        boolean hasTransform = cameraInternal.getHasTransform();
        Rect cropRect = getCropRect(streamSpec.getResolution());
        Objects.requireNonNull(cropRect);
        Rect rect = cropRect;
        SurfaceEdge surfaceEdge = new SurfaceEdge(3, 34, streamSpec, sensorToBufferTransformMatrix, hasTransform, cropRect, getRelativeRotation(cameraInternal), -1, isMirroringRequired(cameraInternal));
        this.mCameraEdge = surfaceEdge;
        this.mSharingInputEdge = getSharingInputEdge(surfaceEdge, cameraInternal);
        this.mSharingNode = new SurfaceProcessorNode(cameraInternal, DefaultSurfaceProcessor.Factory.newInstance(streamSpec.getDynamicRange()));
        Map<UseCase, SurfaceProcessorNode.OutConfig> childrenOutConfigs = this.mVirtualCamera.getChildrenOutConfigs(this.mSharingInputEdge);
        SurfaceProcessorNode.Out transform = this.mSharingNode.transform(SurfaceProcessorNode.In.of(this.mSharingInputEdge, new ArrayList(childrenOutConfigs.values())));
        HashMap hashMap = new HashMap();
        for (Map.Entry next : childrenOutConfigs.entrySet()) {
            hashMap.put((UseCase) next.getKey(), (SurfaceEdge) transform.get(next.getValue()));
        }
        this.mVirtualCamera.setChildrenEdges(hashMap);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(useCaseConfig, streamSpec.getResolution());
        createFrom.addSurface(this.mCameraEdge.getDeferrableSurface());
        createFrom.addRepeatingCameraCaptureCallback(this.mVirtualCamera.getParentMetadataCallback());
        if (streamSpec.getImplementationOptions() != null) {
            createFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        addCameraErrorListener(createFrom, str, useCaseConfig, streamSpec);
        this.mSessionConfigBuilder = createFrom;
        return createFrom.build();
    }

    private Rect getCropRect(Size size) {
        if (getViewPortCropRect() != null) {
            return getViewPortCropRect();
        }
        return new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    private static StreamSharingConfig getDefaultConfig(Set<UseCase> set) {
        MutableConfig mutableConfig = new StreamSharingBuilder().getMutableConfig();
        mutableConfig.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        mutableConfig.insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, UseCaseConfigFactory.CaptureType.STREAM_SHARING);
        ArrayList arrayList = new ArrayList();
        for (UseCase next : set) {
            if (next.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                arrayList.add(next.getCurrentConfig().getCaptureType());
            } else {
                Log.e(TAG, "A child does not have capture type.");
            }
        }
        mutableConfig.insertOption(StreamSharingConfig.OPTION_CAPTURE_TYPES, arrayList);
        mutableConfig.insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, 2);
        return new StreamSharingConfig(OptionsBundle.from(mutableConfig));
    }

    private SurfaceEdge getSharingInputEdge(SurfaceEdge surfaceEdge, CameraInternal cameraInternal) {
        if (getEffect() == null) {
            return surfaceEdge;
        }
        this.mEffectNode = new SurfaceProcessorNode(cameraInternal, getEffect().createSurfaceProcessorInternal());
        SurfaceProcessorNode.OutConfig of2 = SurfaceProcessorNode.OutConfig.of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), 0), 0, false);
        SurfaceEdge surfaceEdge2 = (SurfaceEdge) this.mEffectNode.transform(SurfaceProcessorNode.In.of(surfaceEdge, Collections.singletonList(of2))).get(of2);
        Objects.requireNonNull(surfaceEdge2);
        return surfaceEdge2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addCameraErrorListener$1(String str, UseCaseConfig useCaseConfig, StreamSpec streamSpec, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        clearPipeline();
        if (isCurrentCamera(str)) {
            updateSessionConfig(createPipelineAndUpdateChildrenSpecs(str, useCaseConfig, streamSpec));
            notifyReset();
            this.mVirtualCamera.resetChildren();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ListenableFuture lambda$new$0(int i11, int i12) {
        SurfaceProcessorNode surfaceProcessorNode = this.mSharingNode;
        if (surfaceProcessorNode != null) {
            return surfaceProcessorNode.getSurfaceProcessor().snapshot(i11, i12);
        }
        return Futures.immediateFailedFuture(new Exception("Failed to take picture: pipeline is not ready."));
    }

    public SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    public Set<UseCase> getChildren() {
        return this.mVirtualCamera.getChildren();
    }

    public SurfaceProcessorNode getSharingNode() {
        return this.mSharingNode;
    }

    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return new StreamSharingBuilder(MutableOptionsBundle.from(config));
    }

    public VirtualCamera getVirtualCamera() {
        return this.mVirtualCamera;
    }

    public void onBind() {
        super.onBind();
        this.mVirtualCamera.bindChildren();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [androidx.camera.core.impl.UseCaseConfig$Builder, androidx.camera.core.ExtendableBuilder, androidx.camera.core.impl.UseCaseConfig$Builder<?, ?, ?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.UseCaseConfig<?> onMergeConfig(androidx.camera.core.impl.CameraInfoInternal r2, androidx.camera.core.impl.UseCaseConfig.Builder<?, ?, ?> r3) {
        /*
            r1 = this;
            androidx.camera.core.streamsharing.VirtualCamera r2 = r1.mVirtualCamera
            androidx.camera.core.impl.MutableConfig r0 = r3.getMutableConfig()
            r2.mergeChildrenConfigs(r0)
            androidx.camera.core.impl.UseCaseConfig r2 = r3.getUseCaseConfig()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.streamsharing.StreamSharing.onMergeConfig(androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.impl.UseCaseConfig$Builder):androidx.camera.core.impl.UseCaseConfig");
    }

    public void onStateAttached() {
        super.onStateAttached();
        this.mVirtualCamera.notifyStateAttached();
    }

    public void onStateDetached() {
        super.onStateDetached();
        this.mVirtualCamera.notifyStateDetached();
    }

    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec) {
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(getCameraId(), getCurrentConfig(), streamSpec));
        notifyActive();
        return streamSpec;
    }

    public void onUnbind() {
        super.onUnbind();
        clearPipeline();
        this.mVirtualCamera.unbindChildren();
    }

    public UseCaseConfig<?> getDefaultConfig(boolean z11, UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(this.mDefaultConfig.getCaptureType(), 1);
        if (z11) {
            config = o.b(config, this.mDefaultConfig.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }
}
