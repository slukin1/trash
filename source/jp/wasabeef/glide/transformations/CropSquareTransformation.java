package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.o;
import java.security.MessageDigest;
import n3.b;

public class CropSquareTransformation extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    public int f56073b;

    public Bitmap b(Context context, e eVar, Bitmap bitmap, int i11, int i12) {
        int max = Math.max(i11, i12);
        this.f56073b = max;
        return o.b(eVar, bitmap, max, max);
    }

    public boolean equals(Object obj) {
        return (obj instanceof CropSquareTransformation) && ((CropSquareTransformation) obj).f56073b == this.f56073b;
    }

    public int hashCode() {
        return -789843280 + (this.f56073b * 10);
    }

    public String toString() {
        return "CropSquareTransformation(size=" + this.f56073b + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.CropSquareTransformation.1" + this.f56073b).getBytes(b.f66506a));
    }
}
