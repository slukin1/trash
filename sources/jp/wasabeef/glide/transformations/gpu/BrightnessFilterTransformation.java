package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBrightnessFilter;
import n3.b;
import r00.a;

public class BrightnessFilterTransformation extends a {

    /* renamed from: d  reason: collision with root package name */
    public final float f56074d;

    public BrightnessFilterTransformation() {
        this(0.0f);
    }

    public boolean equals(Object obj) {
        return (obj instanceof BrightnessFilterTransformation) && ((BrightnessFilterTransformation) obj).f56074d == this.f56074d;
    }

    public int hashCode() {
        return -1311211954 + ((int) ((this.f56074d + 1.0f) * 10.0f));
    }

    public String toString() {
        return "BrightnessFilterTransformation(brightness=" + this.f56074d + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation.1" + this.f56074d).getBytes(b.f66506a));
    }

    public BrightnessFilterTransformation(float f11) {
        super(new GPUImageBrightnessFilter());
        this.f56074d = f11;
        ((GPUImageBrightnessFilter) c()).setBrightness(f11);
    }
}
