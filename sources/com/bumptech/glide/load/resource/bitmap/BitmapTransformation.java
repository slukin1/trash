package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.a;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.r;
import f4.i;
import n3.g;

public abstract class BitmapTransformation implements g<Bitmap> {
    public abstract Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12);

    public final r<Bitmap> transform(Context context, r<Bitmap> rVar, int i11, int i12) {
        if (i.t(i11, i12)) {
            e g11 = a.d(context).g();
            Bitmap bitmap = rVar.get();
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getWidth();
            }
            if (i12 == Integer.MIN_VALUE) {
                i12 = bitmap.getHeight();
            }
            Bitmap transform = transform(g11, bitmap, i11, i12);
            return bitmap.equals(transform) ? rVar : c.c(transform, g11);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i11 + " or height: " + i12 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
