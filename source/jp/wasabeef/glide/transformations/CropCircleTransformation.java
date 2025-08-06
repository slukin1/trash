package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.o;
import java.security.MessageDigest;
import n3.b;

@Deprecated
public class CropCircleTransformation extends BitmapTransformation {
    public Bitmap b(Context context, e eVar, Bitmap bitmap, int i11, int i12) {
        return o.d(eVar, bitmap, i11, i12);
    }

    public boolean equals(Object obj) {
        return obj instanceof CropCircleTransformation;
    }

    public int hashCode() {
        return 1288474723;
    }

    public String toString() {
        return "CropCircleTransformation()";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update("jp.wasabeef.glide.transformations.CropCircleTransformation.1".getBytes(b.f66506a));
    }
}
