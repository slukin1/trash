package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImagePixelationFilter;
import n3.b;
import r00.a;

public class PixelationFilterTransformation extends a {

    /* renamed from: d  reason: collision with root package name */
    public final float f56077d;

    public PixelationFilterTransformation() {
        this(10.0f);
    }

    public boolean equals(Object obj) {
        return obj instanceof PixelationFilterTransformation;
    }

    public int hashCode() {
        return 1525023660 + ((int) (this.f56077d * 10.0f));
    }

    public String toString() {
        return "PixelationFilterTransformation(pixel=" + this.f56077d + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation.1" + this.f56077d).getBytes(b.f66506a));
    }

    public PixelationFilterTransformation(float f11) {
        super(new GPUImagePixelationFilter());
        this.f56077d = f11;
        ((GPUImagePixelationFilter) c()).setPixel(f11);
    }
}
