package r00;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter;
import jp.wasabeef.glide.transformations.BitmapTransformation;
import n3.b;

public class a extends BitmapTransformation {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f60117c = "jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation.1".getBytes(b.f66506a);

    /* renamed from: b  reason: collision with root package name */
    public final GPUImageFilter f60118b;

    public a(GPUImageFilter gPUImageFilter) {
        this.f60118b = gPUImageFilter;
    }

    public Bitmap b(Context context, e eVar, Bitmap bitmap, int i11, int i12) {
        GPUImage gPUImage = new GPUImage(context);
        gPUImage.setImage(bitmap);
        gPUImage.setFilter(this.f60118b);
        return gPUImage.getBitmapWithFilterApplied();
    }

    public <T> T c() {
        return this.f60118b;
    }
}
