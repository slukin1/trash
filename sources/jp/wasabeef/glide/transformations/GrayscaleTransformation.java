package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import java.security.MessageDigest;
import n3.b;

public class GrayscaleTransformation extends BitmapTransformation {
    public Bitmap b(Context context, e eVar, Bitmap bitmap, int i11, int i12) {
        Bitmap d11 = eVar.d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        a(bitmap, d11);
        Canvas canvas = new Canvas(d11);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return d11;
    }

    public boolean equals(Object obj) {
        return obj instanceof GrayscaleTransformation;
    }

    public int hashCode() {
        return -1580689316;
    }

    public String toString() {
        return "GrayscaleTransformation()";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update("jp.wasabeef.glide.transformations.GrayscaleTransformation.1".getBytes(b.f66506a));
    }
}
