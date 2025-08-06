package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;
import java.util.Objects;

final class AutoValue_SessionConfig_OutputConfig extends SessionConfig.OutputConfig {
    private final DynamicRange dynamicRange;
    private final String physicalCameraId;
    private final List<DeferrableSurface> sharedSurfaces;
    private final DeferrableSurface surface;
    private final int surfaceGroupId;

    public static final class Builder extends SessionConfig.OutputConfig.Builder {
        private DynamicRange dynamicRange;
        private String physicalCameraId;
        private List<DeferrableSurface> sharedSurfaces;
        private DeferrableSurface surface;
        private Integer surfaceGroupId;

        public SessionConfig.OutputConfig build() {
            String str = "";
            if (this.surface == null) {
                str = str + " surface";
            }
            if (this.sharedSurfaces == null) {
                str = str + " sharedSurfaces";
            }
            if (this.surfaceGroupId == null) {
                str = str + " surfaceGroupId";
            }
            if (this.dynamicRange == null) {
                str = str + " dynamicRange";
            }
            if (str.isEmpty()) {
                return new AutoValue_SessionConfig_OutputConfig(this.surface, this.sharedSurfaces, this.physicalCameraId, this.surfaceGroupId.intValue(), this.dynamicRange);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public SessionConfig.OutputConfig.Builder setDynamicRange(DynamicRange dynamicRange2) {
            Objects.requireNonNull(dynamicRange2, "Null dynamicRange");
            this.dynamicRange = dynamicRange2;
            return this;
        }

        public SessionConfig.OutputConfig.Builder setPhysicalCameraId(String str) {
            this.physicalCameraId = str;
            return this;
        }

        public SessionConfig.OutputConfig.Builder setSharedSurfaces(List<DeferrableSurface> list) {
            Objects.requireNonNull(list, "Null sharedSurfaces");
            this.sharedSurfaces = list;
            return this;
        }

        public SessionConfig.OutputConfig.Builder setSurface(DeferrableSurface deferrableSurface) {
            Objects.requireNonNull(deferrableSurface, "Null surface");
            this.surface = deferrableSurface;
            return this;
        }

        public SessionConfig.OutputConfig.Builder setSurfaceGroupId(int i11) {
            this.surfaceGroupId = Integer.valueOf(i11);
            return this;
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SessionConfig.OutputConfig)) {
            return false;
        }
        SessionConfig.OutputConfig outputConfig = (SessionConfig.OutputConfig) obj;
        if (!this.surface.equals(outputConfig.getSurface()) || !this.sharedSurfaces.equals(outputConfig.getSharedSurfaces()) || ((str = this.physicalCameraId) != null ? !str.equals(outputConfig.getPhysicalCameraId()) : outputConfig.getPhysicalCameraId() != null) || this.surfaceGroupId != outputConfig.getSurfaceGroupId() || !this.dynamicRange.equals(outputConfig.getDynamicRange())) {
            return false;
        }
        return true;
    }

    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    public String getPhysicalCameraId() {
        return this.physicalCameraId;
    }

    public List<DeferrableSurface> getSharedSurfaces() {
        return this.sharedSurfaces;
    }

    public DeferrableSurface getSurface() {
        return this.surface;
    }

    public int getSurfaceGroupId() {
        return this.surfaceGroupId;
    }

    public int hashCode() {
        int hashCode = (((this.surface.hashCode() ^ 1000003) * 1000003) ^ this.sharedSurfaces.hashCode()) * 1000003;
        String str = this.physicalCameraId;
        return ((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.surfaceGroupId) * 1000003) ^ this.dynamicRange.hashCode();
    }

    public String toString() {
        return "OutputConfig{surface=" + this.surface + ", sharedSurfaces=" + this.sharedSurfaces + ", physicalCameraId=" + this.physicalCameraId + ", surfaceGroupId=" + this.surfaceGroupId + ", dynamicRange=" + this.dynamicRange + "}";
    }

    private AutoValue_SessionConfig_OutputConfig(DeferrableSurface deferrableSurface, List<DeferrableSurface> list, String str, int i11, DynamicRange dynamicRange2) {
        this.surface = deferrableSurface;
        this.sharedSurfaces = list;
        this.physicalCameraId = str;
        this.surfaceGroupId = i11;
        this.dynamicRange = dynamicRange2;
    }
}
