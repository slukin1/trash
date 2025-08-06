package com.huobi.utils.glide;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.o;
import java.security.MessageDigest;
import n3.b;

public class LongImageFitStart extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f83745b = "com.bumptech.glide.load.resource.bitmap.LongImageFitStart".getBytes(b.f66506a);

    /* renamed from: c  reason: collision with root package name */
    public static final Paint f83746c = new Paint(6);

    public boolean equals(Object obj) {
        return obj instanceof LongImageFitStart;
    }

    public int hashCode() {
        return -2079272057;
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        float width = ((float) i11) / (((float) bitmap.getWidth()) * 1.0f);
        Matrix matrix = new Matrix();
        matrix.setScale(width, width);
        matrix.postTranslate(0.0f, 0.0f);
        Bitmap d11 = eVar.d(i11, i12, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        o.q(bitmap, d11);
        Canvas canvas = new Canvas(d11);
        canvas.drawBitmap(bitmap, matrix, f83746c);
        canvas.setBitmap((Bitmap) null);
        return d11;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f83745b);
    }
}
