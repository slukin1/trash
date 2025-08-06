package jp.wasabeef.glide.transformations.gpu;

import android.graphics.PointF;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSwirlFilter;
import n3.b;
import r00.a;

public class SwirlFilterTransformation extends a {

    /* renamed from: d  reason: collision with root package name */
    public final float f56079d;

    /* renamed from: e  reason: collision with root package name */
    public final float f56080e;

    /* renamed from: f  reason: collision with root package name */
    public final PointF f56081f;

    public SwirlFilterTransformation() {
        this(0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    public boolean equals(Object obj) {
        if (obj instanceof SwirlFilterTransformation) {
            SwirlFilterTransformation swirlFilterTransformation = (SwirlFilterTransformation) obj;
            float f11 = swirlFilterTransformation.f56079d;
            float f12 = this.f56079d;
            if (f11 == f12 && swirlFilterTransformation.f56080e == f12) {
                PointF pointF = swirlFilterTransformation.f56081f;
                PointF pointF2 = this.f56081f;
                if (pointF.equals(pointF2.x, pointF2.y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return -981084566 + ((int) (this.f56079d * 1000.0f)) + ((int) (this.f56080e * 10.0f)) + this.f56081f.hashCode();
    }

    public String toString() {
        return "SwirlFilterTransformation(radius=" + this.f56079d + ",angle=" + this.f56080e + ",center=" + this.f56081f.toString() + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation.1" + this.f56079d + this.f56080e + this.f56081f.hashCode()).getBytes(b.f66506a));
    }

    public SwirlFilterTransformation(float f11, float f12, PointF pointF) {
        super(new GPUImageSwirlFilter());
        this.f56079d = f11;
        this.f56080e = f12;
        this.f56081f = pointF;
        GPUImageSwirlFilter gPUImageSwirlFilter = (GPUImageSwirlFilter) c();
        gPUImageSwirlFilter.setRadius(f11);
        gPUImageSwirlFilter.setAngle(f12);
        gPUImageSwirlFilter.setCenter(pointF);
    }
}
