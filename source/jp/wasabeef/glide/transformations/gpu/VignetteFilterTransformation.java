package jp.wasabeef.glide.transformations.gpu;

import android.graphics.PointF;
import java.security.MessageDigest;
import java.util.Arrays;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageVignetteFilter;
import n3.b;
import r00.a;

public class VignetteFilterTransformation extends a {

    /* renamed from: d  reason: collision with root package name */
    public final PointF f56084d;

    /* renamed from: e  reason: collision with root package name */
    public final float[] f56085e;

    /* renamed from: f  reason: collision with root package name */
    public final float f56086f;

    /* renamed from: g  reason: collision with root package name */
    public final float f56087g;

    public VignetteFilterTransformation() {
        this(new PointF(0.5f, 0.5f), new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 0.75f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof VignetteFilterTransformation) {
            VignetteFilterTransformation vignetteFilterTransformation = (VignetteFilterTransformation) obj;
            PointF pointF = vignetteFilterTransformation.f56084d;
            PointF pointF2 = this.f56084d;
            return pointF.equals(pointF2.x, pointF2.y) && Arrays.equals(vignetteFilterTransformation.f56085e, this.f56085e) && vignetteFilterTransformation.f56086f == this.f56086f && vignetteFilterTransformation.f56087g == this.f56087g;
        }
    }

    public int hashCode() {
        return 1874002103 + this.f56084d.hashCode() + Arrays.hashCode(this.f56085e) + ((int) (this.f56086f * 100.0f)) + ((int) (this.f56087g * 10.0f));
    }

    public String toString() {
        return "VignetteFilterTransformation(center=" + this.f56084d.toString() + ",color=" + Arrays.toString(this.f56085e) + ",start=" + this.f56086f + ",end=" + this.f56087g + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation.1" + this.f56084d + Arrays.hashCode(this.f56085e) + this.f56086f + this.f56087g).getBytes(b.f66506a));
    }

    public VignetteFilterTransformation(PointF pointF, float[] fArr, float f11, float f12) {
        super(new GPUImageVignetteFilter());
        this.f56084d = pointF;
        this.f56085e = fArr;
        this.f56086f = f11;
        this.f56087g = f12;
        GPUImageVignetteFilter gPUImageVignetteFilter = (GPUImageVignetteFilter) c();
        gPUImageVignetteFilter.setVignetteCenter(pointF);
        gPUImageVignetteFilter.setVignetteColor(fArr);
        gPUImageVignetteFilter.setVignetteStart(f11);
        gPUImageVignetteFilter.setVignetteEnd(f12);
    }
}
