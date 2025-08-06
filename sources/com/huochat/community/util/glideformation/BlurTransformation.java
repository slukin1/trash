package com.huochat.community.util.glideformation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;
import n3.b;

public class BlurTransformation extends BitmapTransformation {
    private static int DEFAULT_DOWN_SAMPLING = 1;
    private static final String ID = "glideformation.BlurTransformation.1";
    private static int MAX_RADIUS = 25;
    private static final int VERSION = 1;
    private int radius;
    private int sampling;

    public BlurTransformation() {
        this(MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public boolean equals(Object obj) {
        if (obj instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) obj;
            return blurTransformation.radius == this.radius && blurTransformation.sampling == this.sampling;
        }
    }

    public int hashCode() {
        return 1665206069 + (this.radius * 1000) + (this.sampling * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.radius + ", sampling=" + this.sampling + ")";
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i13 = this.sampling;
        Bitmap d11 = eVar.d(width / i13, height / i13, Bitmap.Config.ARGB_8888);
        d11.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(d11);
        int i14 = this.sampling;
        canvas.scale(1.0f / ((float) i14), 1.0f / ((float) i14));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return FastBlur.blur(d11, this.radius, true);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.sampling).getBytes(b.f66506a));
    }

    public BlurTransformation(int i11) {
        this(i11, DEFAULT_DOWN_SAMPLING);
    }

    public BlurTransformation(int i11, int i12) {
        this.radius = i11;
        this.sampling = i12;
    }
}
