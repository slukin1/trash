package com.huochat.community.util.glideformation;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;
import n3.b;

public class GlideTransformCircle extends BitmapTransformation {
    private static final String ID = "com.huochat.community.util.glideformation.GlideTransformCircle";
    private static final byte[] ID_BYTES = GlideTransformCircle.class.getName().getBytes(b.f66506a);

    private static Bitmap circleCrop(e eVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
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
        return d11;
    }

    public boolean equals(Object obj) {
        return obj instanceof GlideTransformCircle;
    }

    public int hashCode() {
        return ID.hashCode();
    }

    public Bitmap transform(e eVar, Bitmap bitmap, int i11, int i12) {
        return circleCrop(eVar, bitmap);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
