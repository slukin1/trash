package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ResolutionInfo;
import java.util.Objects;

final class AutoValue_ResolutionInfo_ResolutionInfoInternal extends ResolutionInfo.ResolutionInfoInternal {
    private final Rect cropRect;
    private final Size resolution;
    private final int rotationDegrees;

    public static final class Builder extends ResolutionInfo.ResolutionInfoInternal.Builder {
        private Rect cropRect;
        private Size resolution;
        private Integer rotationDegrees;

        public ResolutionInfo.ResolutionInfoInternal build() {
            String str = "";
            if (this.resolution == null) {
                str = str + " resolution";
            }
            if (this.cropRect == null) {
                str = str + " cropRect";
            }
            if (this.rotationDegrees == null) {
                str = str + " rotationDegrees";
            }
            if (str.isEmpty()) {
                return new AutoValue_ResolutionInfo_ResolutionInfoInternal(this.resolution, this.cropRect, this.rotationDegrees.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public ResolutionInfo.ResolutionInfoInternal.Builder setCropRect(Rect rect) {
            Objects.requireNonNull(rect, "Null cropRect");
            this.cropRect = rect;
            return this;
        }

        public ResolutionInfo.ResolutionInfoInternal.Builder setResolution(Size size) {
            Objects.requireNonNull(size, "Null resolution");
            this.resolution = size;
            return this;
        }

        public ResolutionInfo.ResolutionInfoInternal.Builder setRotationDegrees(int i11) {
            this.rotationDegrees = Integer.valueOf(i11);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResolutionInfo.ResolutionInfoInternal)) {
            return false;
        }
        ResolutionInfo.ResolutionInfoInternal resolutionInfoInternal = (ResolutionInfo.ResolutionInfoInternal) obj;
        if (!this.resolution.equals(resolutionInfoInternal.getResolution()) || !this.cropRect.equals(resolutionInfoInternal.getCropRect()) || this.rotationDegrees != resolutionInfoInternal.getRotationDegrees()) {
            return false;
        }
        return true;
    }

    public Rect getCropRect() {
        return this.cropRect;
    }

    public Size getResolution() {
        return this.resolution;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public int hashCode() {
        return ((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.rotationDegrees;
    }

    public String toString() {
        return "ResolutionInfoInternal{resolution=" + this.resolution + ", cropRect=" + this.cropRect + ", rotationDegrees=" + this.rotationDegrees + "}";
    }

    private AutoValue_ResolutionInfo_ResolutionInfoInternal(Size size, Rect rect, int i11) {
        this.resolution = size;
        this.cropRect = rect;
        this.rotationDegrees = i11;
    }
}
