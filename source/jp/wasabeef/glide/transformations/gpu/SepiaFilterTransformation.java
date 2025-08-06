package jp.wasabeef.glide.transformations.gpu;

import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSepiaToneFilter;
import n3.b;
import r00.a;

public class SepiaFilterTransformation extends a {

    /* renamed from: d  reason: collision with root package name */
    public final float f56078d;

    public SepiaFilterTransformation() {
        this(1.0f);
    }

    public boolean equals(Object obj) {
        return obj instanceof SepiaFilterTransformation;
    }

    public int hashCode() {
        return 895516065 + ((int) (this.f56078d * 10.0f));
    }

    public String toString() {
        return "SepiaFilterTransformation(intensity=" + this.f56078d + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation.1" + this.f56078d).getBytes(b.f66506a));
    }

    public SepiaFilterTransformation(float f11) {
        super(new GPUImageSepiaToneFilter());
        this.f56078d = f11;
        ((GPUImageSepiaToneFilter) c()).setIntensity(f11);
    }
}
