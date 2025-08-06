package com.huochat.community.util.glideformation;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;
import n3.b;

public class LongImageFitStart extends BitmapTransformation {
    private static final String ID = "glideformation.LongImageFitStart.1";
    private static final byte[] ID_BYTES = ID.getBytes(b.f66506a);
    private static final int VERSION = 1;
    private float mCutScale;
    private int mRadius;

    public LongImageFitStart(int i11, float f11) {
        this.mRadius = i11;
        this.mCutScale = f11;
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float f11, float f12) {
        RectF rectF = new RectF(0.0f, 0.0f, f11, f12);
        int i11 = this.mRadius;
        canvas.drawRoundRect(rectF, (float) i11, (float) i11, paint);
    }

    public boolean equals(Object obj) {
        return obj instanceof LongImageFitStart;
    }

    public int hashCode() {
        return -1844435055;
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        float f11 = (float) width;
        int i13 = (int) (this.mCutScale * f11);
        if (i13 == 0) {
            i13 = bitmap.getHeight();
        }
        Bitmap d11 = eVar.d(width, i13, Bitmap.Config.ARGB_8888);
        d11.setHasAlpha(true);
        Canvas canvas = new Canvas(d11);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        drawRoundRect(canvas, paint, f11, (float) i13);
        return d11;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
