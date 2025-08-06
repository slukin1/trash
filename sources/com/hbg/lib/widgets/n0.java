package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;
import n3.b;

public class n0 extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    public Paint f72083b;

    /* renamed from: c  reason: collision with root package name */
    public float f72084c;

    public n0(Context context, int i11, int i12) {
        this.f72084c = (float) i11;
        Paint paint = new Paint();
        this.f72083b = paint;
        paint.setDither(true);
        this.f72083b.setAntiAlias(true);
        this.f72083b.setColor(i12);
        this.f72083b.setStyle(Paint.Style.STROKE);
        this.f72083b.setStrokeWidth(this.f72084c);
    }

    public final Bitmap circleCrop(e eVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) - (this.f72084c / 2.0f));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        Bitmap d11 = eVar.d(min, min, Bitmap.Config.ARGB_8888);
        if (d11 == null) {
            d11 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(d11);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f11 = ((float) min) / 2.0f;
        canvas.drawCircle(f11, f11, f11, paint);
        Paint paint2 = this.f72083b;
        if (paint2 != null) {
            canvas.drawCircle(f11, f11, f11 - (this.f72084c / 2.0f), paint2);
        }
        return d11;
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        return circleCrop(eVar, bitmap);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((Build.ID + this.f72084c).getBytes(b.f66506a));
    }
}
