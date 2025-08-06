package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "SurfaceProcessorNode";
    public final CameraInternal mCameraInternal;
    private In mInput;
    private Out mOutput;
    public final SurfaceProcessorInternal mSurfaceProcessor;

    @AutoValue
    public static abstract class In {
        public static In of(SurfaceEdge surfaceEdge, List<OutConfig> list) {
            return new AutoValue_SurfaceProcessorNode_In(surfaceEdge, list);
        }

        public abstract List<OutConfig> getOutConfigs();

        public abstract SurfaceEdge getSurfaceEdge();
    }

    public static class Out extends HashMap<OutConfig, SurfaceEdge> {
    }

    public SurfaceProcessorNode(CameraInternal cameraInternal, SurfaceProcessorInternal surfaceProcessorInternal) {
        this.mCameraInternal = cameraInternal;
        this.mSurfaceProcessor = surfaceProcessorInternal;
    }

    /* access modifiers changed from: private */
    /* renamed from: createAndSendSurfaceOutput */
    public void lambda$sendSurfaceOutputs$0(SurfaceEdge surfaceEdge, Map.Entry<OutConfig, SurfaceEdge> entry) {
        Futures.addCallback(entry.getValue().createSurfaceOutputFuture(surfaceEdge.getStreamSpec().getResolution(), entry.getKey().getFormat(), entry.getKey().getCropRect(), entry.getKey().getRotationDegrees(), entry.getKey().getMirroring(), surfaceEdge.hasCameraTransform() ? this.mCameraInternal : null), new FutureCallback<SurfaceOutput>() {
            public void onFailure(Throwable th2) {
                Logger.w(SurfaceProcessorNode.TAG, "Downstream node failed to provide Surface.", th2);
            }

            public void onSuccess(SurfaceOutput surfaceOutput) {
                h.g(surfaceOutput);
                try {
                    SurfaceProcessorNode.this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
                } catch (ProcessingException e11) {
                    Logger.e(SurfaceProcessorNode.TAG, "Failed to send SurfaceOutput to SurfaceProcessor.", e11);
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2() {
        Out out = this.mOutput;
        if (out != null) {
            for (SurfaceEdge close : out.values()) {
                close.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUpRotationUpdates$1(Map map, SurfaceRequest.TransformationInfo transformationInfo) {
        for (Map.Entry entry : map.entrySet()) {
            int rotationDegrees = transformationInfo.getRotationDegrees() - ((OutConfig) entry.getKey()).getRotationDegrees();
            if (((OutConfig) entry.getKey()).getMirroring()) {
                rotationDegrees = -rotationDegrees;
            }
            ((SurfaceEdge) entry.getValue()).updateTransformation(TransformUtils.within360(rotationDegrees), -1);
        }
    }

    private void sendSurfaceOutputs(SurfaceEdge surfaceEdge, Map<OutConfig, SurfaceEdge> map) {
        for (Map.Entry next : map.entrySet()) {
            lambda$sendSurfaceOutputs$0(surfaceEdge, next);
            ((SurfaceEdge) next.getValue()).addOnInvalidatedListener(new g0(this, surfaceEdge, next));
        }
    }

    private void sendSurfaceRequest(SurfaceEdge surfaceEdge, Map<OutConfig, SurfaceEdge> map) {
        SurfaceRequest createSurfaceRequest = surfaceEdge.createSurfaceRequest(this.mCameraInternal);
        setUpRotationUpdates(createSurfaceRequest, map);
        try {
            this.mSurfaceProcessor.onInputSurface(createSurfaceRequest);
        } catch (ProcessingException e11) {
            Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e11);
        }
    }

    private SurfaceEdge transformSingleOutput(SurfaceEdge surfaceEdge, OutConfig outConfig) {
        Rect cropRect = outConfig.getCropRect();
        int rotationDegrees = outConfig.getRotationDegrees();
        boolean mirroring = outConfig.getMirroring();
        Matrix matrix = new Matrix(surfaceEdge.getSensorToBufferTransform());
        matrix.postConcat(TransformUtils.getRectToRect(new RectF(cropRect), TransformUtils.sizeToRectF(outConfig.getSize()), rotationDegrees, mirroring));
        h.a(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(cropRect, rotationDegrees), outConfig.getSize()));
        return new SurfaceEdge(outConfig.getTargets(), outConfig.getFormat(), surfaceEdge.getStreamSpec().toBuilder().setResolution(outConfig.getSize()).build(), matrix, false, TransformUtils.sizeToRect(outConfig.getSize()), surfaceEdge.getRotationDegrees() - rotationDegrees, -1, surfaceEdge.getMirroring() != mirroring);
    }

    public SurfaceProcessorInternal getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public void release() {
        this.mSurfaceProcessor.release();
        CameraXExecutors.mainThreadExecutor().execute(new f0(this));
    }

    public void setUpRotationUpdates(SurfaceRequest surfaceRequest, Map<OutConfig, SurfaceEdge> map) {
        surfaceRequest.setTransformationInfoListener(CameraXExecutors.mainThreadExecutor(), new e0(map));
    }

    public Out transform(In in2) {
        Threads.checkMainThread();
        this.mInput = in2;
        this.mOutput = new Out();
        SurfaceEdge surfaceEdge = in2.getSurfaceEdge();
        for (OutConfig next : in2.getOutConfigs()) {
            this.mOutput.put(next, transformSingleOutput(surfaceEdge, next));
        }
        sendSurfaceRequest(surfaceEdge, this.mOutput);
        sendSurfaceOutputs(surfaceEdge, this.mOutput);
        return this.mOutput;
    }

    @AutoValue
    public static abstract class OutConfig {
        public static OutConfig of(SurfaceEdge surfaceEdge) {
            return of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), surfaceEdge.getRotationDegrees()), surfaceEdge.getRotationDegrees(), surfaceEdge.getMirroring());
        }

        public abstract Rect getCropRect();

        public abstract int getFormat();

        public abstract boolean getMirroring();

        public abstract int getRotationDegrees();

        public abstract Size getSize();

        public abstract int getTargets();

        public abstract UUID getUuid();

        public static OutConfig of(int i11, int i12, Rect rect, Size size, int i13, boolean z11) {
            return new AutoValue_SurfaceProcessorNode_OutConfig(UUID.randomUUID(), i11, i12, rect, size, i13, z11);
        }
    }
}
