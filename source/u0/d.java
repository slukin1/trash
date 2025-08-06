package u0;

import android.content.res.Resources;
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

public abstract class d extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f16576a;

    /* renamed from: b  reason: collision with root package name */
    public int f16577b = 160;

    /* renamed from: c  reason: collision with root package name */
    public int f16578c = 119;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f16579d = new Paint(3);

    /* renamed from: e  reason: collision with root package name */
    public final BitmapShader f16580e;

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f16581f = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    public float f16582g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f16583h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    public final RectF f16584i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    public boolean f16585j = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16586k;

    /* renamed from: l  reason: collision with root package name */
    public int f16587l;

    /* renamed from: m  reason: collision with root package name */
    public int f16588m;

    public d(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.f16577b = resources.getDisplayMetrics().densityDpi;
        }
        this.f16576a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f16580e = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.f16588m = -1;
        this.f16587l = -1;
        this.f16580e = null;
    }

    public static boolean d(float f11) {
        return f11 > 0.05f;
    }

    public final void a() {
        this.f16587l = this.f16576a.getScaledWidth(this.f16577b);
        this.f16588m = this.f16576a.getScaledHeight(this.f16577b);
    }

    public float b() {
        return this.f16582g;
    }

    public abstract void c(int i11, int i12, int i13, Rect rect, Rect rect2);

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f16576a;
        if (bitmap != null) {
            h();
            if (this.f16579d.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f16583h, this.f16579d);
                return;
            }
            RectF rectF = this.f16584i;
            float f11 = this.f16582g;
            canvas.drawRoundRect(rectF, f11, f11, this.f16579d);
        }
    }

    public void e(boolean z11) {
        this.f16579d.setAntiAlias(z11);
        invalidateSelf();
    }

    public void f(float f11) {
        if (this.f16582g != f11) {
            this.f16586k = false;
            if (d(f11)) {
                this.f16579d.setShader(this.f16580e);
            } else {
                this.f16579d.setShader((Shader) null);
            }
            this.f16582g = f11;
            invalidateSelf();
        }
    }

    public final void g() {
        this.f16582g = (float) (Math.min(this.f16588m, this.f16587l) / 2);
    }

    public int getAlpha() {
        return this.f16579d.getAlpha();
    }

    public ColorFilter getColorFilter() {
        return this.f16579d.getColorFilter();
    }

    public int getIntrinsicHeight() {
        return this.f16588m;
    }

    public int getIntrinsicWidth() {
        return this.f16587l;
    }

    public int getOpacity() {
        Bitmap bitmap;
        if (this.f16578c != 119 || this.f16586k || (bitmap = this.f16576a) == null || bitmap.hasAlpha() || this.f16579d.getAlpha() < 255 || d(this.f16582g)) {
            return -3;
        }
        return -1;
    }

    public void h() {
        if (this.f16585j) {
            if (this.f16586k) {
                int min = Math.min(this.f16587l, this.f16588m);
                c(this.f16578c, min, min, getBounds(), this.f16583h);
                int min2 = Math.min(this.f16583h.width(), this.f16583h.height());
                this.f16583h.inset(Math.max(0, (this.f16583h.width() - min2) / 2), Math.max(0, (this.f16583h.height() - min2) / 2));
                this.f16582g = ((float) min2) * 0.5f;
            } else {
                c(this.f16578c, this.f16587l, this.f16588m, getBounds(), this.f16583h);
            }
            this.f16584i.set(this.f16583h);
            if (this.f16580e != null) {
                Matrix matrix = this.f16581f;
                RectF rectF = this.f16584i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f16581f.preScale(this.f16584i.width() / ((float) this.f16576a.getWidth()), this.f16584i.height() / ((float) this.f16576a.getHeight()));
                this.f16580e.setLocalMatrix(this.f16581f);
                this.f16579d.setShader(this.f16580e);
            }
            this.f16585j = false;
        }
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f16586k) {
            g();
        }
        this.f16585j = true;
    }

    public void setAlpha(int i11) {
        if (i11 != this.f16579d.getAlpha()) {
            this.f16579d.setAlpha(i11);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f16579d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDither(boolean z11) {
        this.f16579d.setDither(z11);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z11) {
        this.f16579d.setFilterBitmap(z11);
        invalidateSelf();
    }
}
