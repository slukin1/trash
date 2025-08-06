package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSketchFilter;
import n3.b;
import r00.a;

public class SketchFilterTransformation extends a {
    public SketchFilterTransformation() {
        super(new GPUImageSketchFilter());
    }

    public boolean equals(Object obj) {
        return obj instanceof SketchFilterTransformation;
    }

    public int hashCode() {
        return -1790215191;
    }

    public String toString() {
        return "SketchFilterTransformation()";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update("jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation.1".getBytes(b.f66506a));
    }
}
