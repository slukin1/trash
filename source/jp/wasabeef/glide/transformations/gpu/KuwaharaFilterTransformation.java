package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageKuwaharaFilter;
import n3.b;
import r00.a;

public class KuwaharaFilterTransformation extends a {

    /* renamed from: d  reason: collision with root package name */
    public final int f56076d;

    public KuwaharaFilterTransformation() {
        this(25);
    }

    public boolean equals(Object obj) {
        return obj instanceof KuwaharaFilterTransformation;
    }

    public int hashCode() {
        return -1859800423 + (this.f56076d * 10);
    }

    public String toString() {
        return "KuwaharaFilterTransformation(radius=" + this.f56076d + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation.1" + this.f56076d).getBytes(b.f66506a));
    }

    public KuwaharaFilterTransformation(int i11) {
        super(new GPUImageKuwaharaFilter());
        this.f56076d = i11;
        ((GPUImageKuwaharaFilter) c()).setRadius(i11);
    }
}
