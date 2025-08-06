package com.nostra13.universalimageloader.core.display;

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
import sx.b;

public class CircleBitmapDisplayer implements qx.a {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f28440a;

    /* renamed from: b  reason: collision with root package name */
    public final float f28441b;

    public static class a extends Drawable {

        /* renamed from: a  reason: collision with root package name */
        public float f28442a;

        /* renamed from: b  reason: collision with root package name */
        public final RectF f28443b = new RectF();

        /* renamed from: c  reason: collision with root package name */
        public final RectF f28444c;

        /* renamed from: d  reason: collision with root package name */
        public final BitmapShader f28445d;

        /* renamed from: e  reason: collision with root package name */
        public final Paint f28446e;

        /* renamed from: f  reason: collision with root package name */
        public final Paint f28447f;

        /* renamed from: g  reason: collision with root package name */
        public final float f28448g;

        /* renamed from: h  reason: collision with root package name */
        public float f28449h;

        public a(Bitmap bitmap, Integer num, float f11) {
            this.f28442a = (float) (Math.min(bitmap.getWidth(), bitmap.getHeight()) / 2);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.f28445d = bitmapShader;
            this.f28444c = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            Paint paint = new Paint();
            this.f28446e = paint;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            if (num == null) {
                this.f28447f = null;
            } else {
                Paint paint2 = new Paint();
                this.f28447f = paint2;
                paint2.setStyle(Paint.Style.STROKE);
                paint2.setColor(num.intValue());
                paint2.setStrokeWidth(f11);
                paint2.setAntiAlias(true);
            }
            this.f28448g = f11;
            this.f28449h = this.f28442a - (f11 / 2.0f);
        }

        public void draw(Canvas canvas) {
            float f11 = this.f28442a;
            canvas.drawCircle(f11, f11, f11, this.f28446e);
            Paint paint = this.f28447f;
            if (paint != null) {
                float f12 = this.f28442a;
                canvas.drawCircle(f12, f12, this.f28449h, paint);
            }
        }

        public int getOpacity() {
            return -3;
        }

        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.f28443b.set(0.0f, 0.0f, (float) rect.width(), (float) rect.height());
            float min = (float) (Math.min(rect.width(), rect.height()) / 2);
            this.f28442a = min;
            this.f28449h = min - (this.f28448g / 2.0f);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.f28444c, this.f28443b, Matrix.ScaleToFit.FILL);
            this.f28445d.setLocalMatrix(matrix);
        }

        public void setAlpha(int i11) {
            this.f28446e.setAlpha(i11);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.f28446e.setColorFilter(colorFilter);
        }
    }

    public CircleBitmapDisplayer() {
        this((Integer) null);
    }

    public void a(Bitmap bitmap, sx.a aVar, LoadedFrom loadedFrom) {
        if (aVar instanceof b) {
            aVar.d(new a(bitmap, this.f28440a, this.f28441b));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }

    public CircleBitmapDisplayer(Integer num) {
        this(num, 0.0f);
    }

    public CircleBitmapDisplayer(Integer num, float f11) {
        this.f28440a = num;
        this.f28441b = f11;
    }
}
