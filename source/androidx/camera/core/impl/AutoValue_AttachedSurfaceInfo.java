package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.List;
import java.util.Objects;

final class AutoValue_AttachedSurfaceInfo extends AttachedSurfaceInfo {
    private final List<UseCaseConfigFactory.CaptureType> captureTypes;
    private final DynamicRange dynamicRange;
    private final int imageFormat;
    private final Config implementationOptions;
    private final Size size;
    private final SurfaceConfig surfaceConfig;
    private final Range<Integer> targetFrameRate;

    public AutoValue_AttachedSurfaceInfo(SurfaceConfig surfaceConfig2, int i11, Size size2, DynamicRange dynamicRange2, List<UseCaseConfigFactory.CaptureType> list, Config config, Range<Integer> range) {
        Objects.requireNonNull(surfaceConfig2, "Null surfaceConfig");
        this.surfaceConfig = surfaceConfig2;
        this.imageFormat = i11;
        Objects.requireNonNull(size2, "Null size");
        this.size = size2;
        Objects.requireNonNull(dynamicRange2, "Null dynamicRange");
        this.dynamicRange = dynamicRange2;
        Objects.requireNonNull(list, "Null captureTypes");
        this.captureTypes = list;
        this.implementationOptions = config;
        this.targetFrameRate = range;
    }

    public boolean equals(Object obj) {
        Config config;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttachedSurfaceInfo)) {
            return false;
        }
        AttachedSurfaceInfo attachedSurfaceInfo = (AttachedSurfaceInfo) obj;
        if (this.surfaceConfig.equals(attachedSurfaceInfo.getSurfaceConfig()) && this.imageFormat == attachedSurfaceInfo.getImageFormat() && this.size.equals(attachedSurfaceInfo.getSize()) && this.dynamicRange.equals(attachedSurfaceInfo.getDynamicRange()) && this.captureTypes.equals(attachedSurfaceInfo.getCaptureTypes()) && ((config = this.implementationOptions) != null ? config.equals(attachedSurfaceInfo.getImplementationOptions()) : attachedSurfaceInfo.getImplementationOptions() == null)) {
            Range<Integer> range = this.targetFrameRate;
            if (range == null) {
                if (attachedSurfaceInfo.getTargetFrameRate() == null) {
                    return true;
                }
            } else if (range.equals(attachedSurfaceInfo.getTargetFrameRate())) {
                return true;
            }
        }
        return false;
    }

    public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
        return this.captureTypes;
    }

    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public Config getImplementationOptions() {
        return this.implementationOptions;
    }

    public Size getSize() {
        return this.size;
    }

    public SurfaceConfig getSurfaceConfig() {
        return this.surfaceConfig;
    }

    public Range<Integer> getTargetFrameRate() {
        return this.targetFrameRate;
    }

    public int hashCode() {
        int hashCode = (((((((((this.surfaceConfig.hashCode() ^ 1000003) * 1000003) ^ this.imageFormat) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.captureTypes.hashCode()) * 1000003;
        Config config = this.implementationOptions;
        int i11 = 0;
        int hashCode2 = (hashCode ^ (config == null ? 0 : config.hashCode())) * 1000003;
        Range<Integer> range = this.targetFrameRate;
        if (range != null) {
            i11 = range.hashCode();
        }
        return hashCode2 ^ i11;
    }

    public String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.surfaceConfig + ", imageFormat=" + this.imageFormat + ", size=" + this.size + ", dynamicRange=" + this.dynamicRange + ", captureTypes=" + this.captureTypes + ", implementationOptions=" + this.implementationOptions + ", targetFrameRate=" + this.targetFrameRate + "}";
    }
}
