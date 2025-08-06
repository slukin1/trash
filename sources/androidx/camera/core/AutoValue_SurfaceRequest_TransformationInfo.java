package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.SurfaceRequest;
import java.util.Objects;

final class AutoValue_SurfaceRequest_TransformationInfo extends SurfaceRequest.TransformationInfo {
    private final Rect getCropRect;
    private final boolean getMirroring;
    private final int getRotationDegrees;
    private final Matrix getSensorToBufferTransform;
    private final int getTargetRotation;
    private final boolean hasCameraTransform;

    public AutoValue_SurfaceRequest_TransformationInfo(Rect rect, int i11, int i12, boolean z11, Matrix matrix, boolean z12) {
        Objects.requireNonNull(rect, "Null getCropRect");
        this.getCropRect = rect;
        this.getRotationDegrees = i11;
        this.getTargetRotation = i12;
        this.hasCameraTransform = z11;
        Objects.requireNonNull(matrix, "Null getSensorToBufferTransform");
        this.getSensorToBufferTransform = matrix;
        this.getMirroring = z12;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceRequest.TransformationInfo)) {
            return false;
        }
        SurfaceRequest.TransformationInfo transformationInfo = (SurfaceRequest.TransformationInfo) obj;
        if (this.getCropRect.equals(transformationInfo.getCropRect()) && this.getRotationDegrees == transformationInfo.getRotationDegrees() && this.getTargetRotation == transformationInfo.getTargetRotation() && this.hasCameraTransform == transformationInfo.hasCameraTransform() && this.getSensorToBufferTransform.equals(transformationInfo.getSensorToBufferTransform()) && this.getMirroring == transformationInfo.getMirroring()) {
            return true;
        }
        return false;
    }

    public Rect getCropRect() {
        return this.getCropRect;
    }

    public boolean getMirroring() {
        return this.getMirroring;
    }

    public int getRotationDegrees() {
        return this.getRotationDegrees;
    }

    public Matrix getSensorToBufferTransform() {
        return this.getSensorToBufferTransform;
    }

    public int getTargetRotation() {
        return this.getTargetRotation;
    }

    public boolean hasCameraTransform() {
        return this.hasCameraTransform;
    }

    public int hashCode() {
        int i11 = 1231;
        int hashCode = (((((((((this.getCropRect.hashCode() ^ 1000003) * 1000003) ^ this.getRotationDegrees) * 1000003) ^ this.getTargetRotation) * 1000003) ^ (this.hasCameraTransform ? 1231 : 1237)) * 1000003) ^ this.getSensorToBufferTransform.hashCode()) * 1000003;
        if (!this.getMirroring) {
            i11 = 1237;
        }
        return hashCode ^ i11;
    }

    public String toString() {
        return "TransformationInfo{getCropRect=" + this.getCropRect + ", getRotationDegrees=" + this.getRotationDegrees + ", getTargetRotation=" + this.getTargetRotation + ", hasCameraTransform=" + this.hasCameraTransform + ", getSensorToBufferTransform=" + this.getSensorToBufferTransform + ", getMirroring=" + this.getMirroring + "}";
    }
}
