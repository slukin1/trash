package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.a;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.resource.bitmap.c;
import f4.i;
import n3.g;

public abstract class BitmapTransformation implements g<Bitmap> {
    public void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
    }

    public abstract Bitmap b(Context context, e eVar, Bitmap bitmap, int i11, int i12);

    public final r<Bitmap> transform(Context context, r<Bitmap> rVar, int i11, int i12) {
        if (i.t(i11, i12)) {
            e g11 = a.d(context).g();
            Bitmap bitmap = rVar.get();
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getWidth();
            }
            int i13 = i11;
            if (i12 == Integer.MIN_VALUE) {
                i12 = bitmap.getHeight();
            }
            Bitmap b11 = b(context.getApplicationContext(), g11, bitmap, i13, i12);
            return bitmap.equals(b11) ? rVar : c.c(b11, g11);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i11 + " or height: " + i12 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
