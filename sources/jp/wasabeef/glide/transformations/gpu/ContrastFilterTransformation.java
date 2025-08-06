package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageContrastFilter;
import n3.b;
import r00.a;

public class ContrastFilterTransformation extends a {

    /* renamed from: d  reason: collision with root package name */
    public final float f56075d;

    public ContrastFilterTransformation() {
        this(1.0f);
    }

    public boolean equals(Object obj) {
        return obj instanceof ContrastFilterTransformation;
    }

    public int hashCode() {
        return -306633601 + ((int) (this.f56075d * 10.0f));
    }

    public String toString() {
        return "ContrastFilterTransformation(contrast=" + this.f56075d + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation.1" + this.f56075d).getBytes(b.f66506a));
    }

    public ContrastFilterTransformation(float f11) {
        super(new GPUImageContrastFilter());
        this.f56075d = f11;
        ((GPUImageContrastFilter) c()).setContrast(f11);
    }
}
