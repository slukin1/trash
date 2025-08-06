package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.TagBundle;
import java.util.Objects;

final class AutoValue_ImmutableImageInfo extends ImmutableImageInfo {
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransformMatrix;
    private final TagBundle tagBundle;
    private final long timestamp;

    public AutoValue_ImmutableImageInfo(TagBundle tagBundle2, long j11, int i11, Matrix matrix) {
        Objects.requireNonNull(tagBundle2, "Null tagBundle");
        this.tagBundle = tagBundle2;
        this.timestamp = j11;
        this.rotationDegrees = i11;
        Objects.requireNonNull(matrix, "Null sensorToBufferTransformMatrix");
        this.sensorToBufferTransformMatrix = matrix;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableImageInfo)) {
            return false;
        }
        ImmutableImageInfo immutableImageInfo = (ImmutableImageInfo) obj;
        if (!this.tagBundle.equals(immutableImageInfo.getTagBundle()) || this.timestamp != immutableImageInfo.getTimestamp() || this.rotationDegrees != immutableImageInfo.getRotationDegrees() || !this.sensorToBufferTransformMatrix.equals(immutableImageInfo.getSensorToBufferTransformMatrix())) {
            return false;
        }
        return true;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public Matrix getSensorToBufferTransformMatrix() {
        return this.sensorToBufferTransformMatrix;
    }

    public TagBundle getTagBundle() {
        return this.tagBundle;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        long j11 = this.timestamp;
        return ((((((this.tagBundle.hashCode() ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.sensorToBufferTransformMatrix.hashCode();
    }

    public String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.tagBundle + ", timestamp=" + this.timestamp + ", rotationDegrees=" + this.rotationDegrees + ", sensorToBufferTransformMatrix=" + this.sensorToBufferTransformMatrix + "}";
    }
}
