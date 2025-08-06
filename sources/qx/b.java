package qx;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final int f29182a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29183b;

    public static class a extends Drawable {

        /* renamed from: a  reason: collision with root package name */
        public final float f29184a;

        /* renamed from: b  reason: collision with root package name */
        public final int f29185b;

        /* renamed from: c  reason: collision with root package name */
        public final RectF f29186c = new RectF();

        /* renamed from: d  reason: collision with root package name */
        public final RectF f29187d;

        /* renamed from: e  reason: collision with root package name */
        public final BitmapShader f29188e;

        /* renamed from: f  reason: collision with root package name */
        public final Paint f29189f;

        public a(Bitmap bitmap, int i11, int i12) {
            this.f29184a = (float) i11;
            this.f29185b = i12;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.f29188e = bitmapShader;
            float f11 = (float) i12;
            this.f29187d = new RectF(f11, f11, (float) (bitmap.getWidth() - i12), (float) (bitmap.getHeight() - i12));
            Paint paint = new Paint();
            this.f29189f = paint;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            paint.setFilterBitmap(true);
            paint.setDither(true);
        }

        public void draw(Canvas canvas) {
            RectF rectF = this.f29186c;
            float f11 = this.f29184a;
            canvas.drawRoundRect(rectF, f11, f11, this.f29189f);
        }

        public int getOpacity() {
            return -3;
        }

        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.f29186c;
            int i11 = this.f29185b;
            rectF.set((float) i11, (float) i11, (float) (rect.width() - this.f29185b), (float) (rect.height() - this.f29185b));
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.f29187d, this.f29186c, Matrix.ScaleToFit.FILL);
            this.f29188e.setLocalMatrix(matrix);
        }

        public void setAlpha(int i11) {
            this.f29189f.setAlpha(i11);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.f29189f.setColorFilter(colorFilter);
        }
    }

    public b(int i11) {
        this(i11, 0);
    }

    public void a(Bitmap bitmap, sx.a aVar, LoadedFrom loadedFrom) {
        if (aVar instanceof sx.b) {
            aVar.d(new a(bitmap, this.f29182a, this.f29183b));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }

    public b(int i11, int i12) {
        this.f29182a = i11;
        this.f29183b = i12;
    }
}
