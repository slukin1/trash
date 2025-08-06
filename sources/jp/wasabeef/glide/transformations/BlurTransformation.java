package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.internal.FastBlur;
import jp.wasabeef.glide.transformations.internal.RSBlur;
import n3.b;

public class BlurTransformation extends BitmapTransformation {

    /* renamed from: b  reason: collision with root package name */
    public final int f56069b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56070c;

    public BlurTransformation() {
        this(25, 1);
    }

    public Bitmap b(Context context, e eVar, Bitmap bitmap, int i11, int i12) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i13 = this.f56070c;
        Bitmap d11 = eVar.d(width / i13, height / i13, Bitmap.Config.ARGB_8888);
        a(bitmap, d11);
        Canvas canvas = new Canvas(d11);
        int i14 = this.f56070c;
        canvas.scale(1.0f / ((float) i14), 1.0f / ((float) i14));
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            return RSBlur.a(context, d11, this.f56069b);
        } catch (RSRuntimeException unused) {
            return FastBlur.a(d11, this.f56069b, true);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) obj;
            return blurTransformation.f56069b == this.f56069b && blurTransformation.f56070c == this.f56070c;
        }
    }

    public int hashCode() {
        return 737513610 + (this.f56069b * 1000) + (this.f56070c * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.f56069b + ", sampling=" + this.f56070c + ")";
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(("jp.wasabeef.glide.transformations.BlurTransformation.1" + this.f56069b + this.f56070c).getBytes(b.f66506a));
    }

    public BlurTransformation(int i11, int i12) {
        this.f56069b = i11;
        this.f56070c = i12;
    }
}
