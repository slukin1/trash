package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageToonFilter;
import n3.b;
import r00.a;

public class ToonFilterTransformation extends a {

    /* renamed from: d  reason: collision with root package name */
    public final float f56082d;

    /* renamed from: e  reason: collision with root package name */
    public final float f56083e;

    public ToonFilterTransformation() {
        this(0.2f, 10.0f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ToonFilterTransformation) {
            ToonFilterTransformation toonFilterTransformation = (ToonFilterTransformation) obj;
            return toonFilterTransformation.f56082d == this.f56082d && toonFilterTransformation.f56083e == this.f56083e;
        }
    }

    public int hashCode() {
        return 1209810327 + ((int) (this.f56082d * 1000.0f)) + ((int) (this.f56083e * 10.0f));
    }

    public String toString() {
        return "ToonFilterTransformation(threshold=" + this.f56082d + ",quantizationLevels=" + this.f56083e + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation.1" + this.f56082d + this.f56083e).getBytes(b.f66506a));
    }

    public ToonFilterTransformation(float f11, float f12) {
        super(new GPUImageToonFilter());
        this.f56082d = f11;
        this.f56083e = f12;
        GPUImageToonFilter gPUImageToonFilter = (GPUImageToonFilter) c();
        gPUImageToonFilter.setThreshold(f11);
        gPUImageToonFilter.setQuantizationLevels(f12);
    }
}
