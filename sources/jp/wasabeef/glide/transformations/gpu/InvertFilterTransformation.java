package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageColorInvertFilter;
import n3.b;
import r00.a;

public class InvertFilterTransformation extends a {
    public InvertFilterTransformation() {
        super(new GPUImageColorInvertFilter());
    }

    public boolean equals(Object obj) {
        return obj instanceof InvertFilterTransformation;
    }

    public int hashCode() {
        return 2014901395;
    }

    public String toString() {
        return "InvertFilterTransformation()";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update("jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation.1".getBytes(b.f66506a));
    }
}
