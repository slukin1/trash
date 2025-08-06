package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.resource.bitmap.o;
import com.huobi.view.roundimg.RoundedDrawable;
import java.security.MessageDigest;
import n3.b;
import s00.a;

public class CropCircleWithBorderTransformation extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    public final int f56071b = a.a(4);

    /* renamed from: c  reason: collision with root package name */
    public final int f56072c = RoundedDrawable.DEFAULT_BORDER_COLOR;

    public Bitmap b(Context context, e eVar, Bitmap bitmap, int i11, int i12) {
        Bitmap d11 = o.d(eVar, bitmap, i11, i12);
        a(bitmap, d11);
        Paint paint = new Paint();
        paint.setColor(this.f56072c);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) this.f56071b);
        paint.setAntiAlias(true);
        new Canvas(d11).drawCircle(((float) i11) / 2.0f, ((float) i12) / 2.0f, (((float) Math.max(i11, i12)) / 2.0f) - (((float) this.f56071b) / 2.0f), paint);
        return d11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CropCircleWithBorderTransformation) {
            CropCircleWithBorderTransformation cropCircleWithBorderTransformation = (CropCircleWithBorderTransformation) obj;
            return cropCircleWithBorderTransformation.f56071b == this.f56071b && cropCircleWithBorderTransformation.f56072c == this.f56072c;
        }
    }

    public int hashCode() {
        return 882652245 + (this.f56071b * 100) + this.f56072c + 10;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation.1" + this.f56071b + this.f56072c).getBytes(b.f66506a));
    }
}
