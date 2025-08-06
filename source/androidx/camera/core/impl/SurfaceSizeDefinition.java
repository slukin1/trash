package androidx.camera.core.impl;

import android.util.Size;
import com.google.auto.value.AutoValue;
import java.util.Map;

@AutoValue
public abstract class SurfaceSizeDefinition {
    public static SurfaceSizeDefinition create(Size size, Map<Integer, Size> map, Size size2, Map<Integer, Size> map2, Size size3, Map<Integer, Size> map3, Map<Integer, Size> map4) {
        return new AutoValue_SurfaceSizeDefinition(size, map, size2, map2, size3, map3, map4);
    }

    public abstract Size getAnalysisSize();

    public Size getMaximumSize(int i11) {
        return getMaximumSizeMap().get(Integer.valueOf(i11));
    }

    public abstract Map<Integer, Size> getMaximumSizeMap();

    public abstract Size getPreviewSize();

    public abstract Size getRecordSize();

    public Size getS1440pSize(int i11) {
        return getS1440pSizeMap().get(Integer.valueOf(i11));
    }

    public abstract Map<Integer, Size> getS1440pSizeMap();

    public Size getS720pSize(int i11) {
        return getS720pSizeMap().get(Integer.valueOf(i11));
    }

    public abstract Map<Integer, Size> getS720pSizeMap();

    public Size getUltraMaximumSize(int i11) {
        return getUltraMaximumSizeMap().get(Integer.valueOf(i11));
    }

    public abstract Map<Integer, Size> getUltraMaximumSizeMap();
}
