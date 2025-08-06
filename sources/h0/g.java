package h0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R$color;
import androidx.cardview.R$dimen;

public class g extends Drawable {

    /* renamed from: q  reason: collision with root package name */
    public static final double f15881q = Math.cos(Math.toRadians(45.0d));

    /* renamed from: r  reason: collision with root package name */
    public static a f15882r;

    /* renamed from: a  reason: collision with root package name */
    public final int f15883a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f15884b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f15885c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f15886d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f15887e;

    /* renamed from: f  reason: collision with root package name */
    public float f15888f;

    /* renamed from: g  reason: collision with root package name */
    public Path f15889g;

    /* renamed from: h  reason: collision with root package name */
    public float f15890h;

    /* renamed from: i  reason: collision with root package name */
    public float f15891i;

    /* renamed from: j  reason: collision with root package name */
    public float f15892j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f15893k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f15894l = true;

    /* renamed from: m  reason: collision with root package name */
    public final int f15895m;

    /* renamed from: n  reason: collision with root package name */
    public final int f15896n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f15897o = true;

    /* renamed from: p  reason: collision with root package name */
    public boolean f15898p = false;

    public interface a {
        void a(Canvas canvas, RectF rectF, float f11, Paint paint);
    }

    public g(Resources resources, ColorStateList colorStateList, float f11, float f12, float f13) {
        this.f15895m = resources.getColor(R$color.cardview_shadow_start_color);
        this.f15896n = resources.getColor(R$color.cardview_shadow_end_color);
        this.f15883a = resources.getDimensionPixelSize(R$dimen.cardview_compat_inset_shadow);
        this.f15884b = new Paint(5);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f15885c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f15888f = (float) ((int) (f11 + 0.5f));
        this.f15887e = new RectF();
        Paint paint2 = new Paint(this.f15885c);
        this.f15886d = paint2;
        paint2.setAntiAlias(false);
        s(f12, f13);
    }

    public static float c(float f11, float f12, boolean z11) {
        return z11 ? (float) (((double) f11) + ((1.0d - f15881q) * ((double) f12))) : f11;
    }

    public static float d(float f11, float f12, boolean z11) {
        return z11 ? (float) (((double) (f11 * 1.5f)) + ((1.0d - f15881q) * ((double) f12))) : f11 * 1.5f;
    }

    public final void a(Rect rect) {
        float f11 = this.f15890h;
        float f12 = 1.5f * f11;
        this.f15887e.set(((float) rect.left) + f11, ((float) rect.top) + f12, ((float) rect.right) - f11, ((float) rect.bottom) - f12);
        b();
    }

    public final void b() {
        float f11 = this.f15888f;
        RectF rectF = new RectF(-f11, -f11, f11, f11);
        RectF rectF2 = new RectF(rectF);
        float f12 = this.f15891i;
        rectF2.inset(-f12, -f12);
        Path path = this.f15889g;
        if (path == null) {
            this.f15889g = new Path();
        } else {
            path.reset();
        }
        this.f15889g.setFillType(Path.FillType.EVEN_ODD);
        this.f15889g.moveTo(-this.f15888f, 0.0f);
        this.f15889g.rLineTo(-this.f15891i, 0.0f);
        this.f15889g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f15889g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f15889g.close();
        float f13 = this.f15888f;
        float f14 = f13 / (this.f15891i + f13);
        Paint paint = this.f15885c;
        float f15 = this.f15888f + this.f15891i;
        int i11 = this.f15895m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f15, new int[]{i11, i11, this.f15896n}, new float[]{0.0f, f14, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f15886d;
        float f16 = this.f15888f;
        float f17 = this.f15891i;
        int i12 = this.f15895m;
        paint2.setShader(new LinearGradient(0.0f, (-f16) + f17, 0.0f, (-f16) - f17, new int[]{i12, i12, this.f15896n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f15886d.setAntiAlias(false);
    }

    public void draw(Canvas canvas) {
        if (this.f15894l) {
            a(getBounds());
            this.f15894l = false;
        }
        canvas.translate(0.0f, this.f15892j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f15892j) / 2.0f);
        f15882r.a(canvas, this.f15887e, this.f15888f, this.f15884b);
    }

    public final void e(Canvas canvas) {
        float f11 = this.f15888f;
        float f12 = (-f11) - this.f15891i;
        float f13 = f11 + ((float) this.f15883a) + (this.f15892j / 2.0f);
        float f14 = f13 * 2.0f;
        boolean z11 = this.f15887e.width() - f14 > 0.0f;
        boolean z12 = this.f15887e.height() - f14 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f15887e;
        canvas.translate(rectF.left + f13, rectF.top + f13);
        canvas.drawPath(this.f15889g, this.f15885c);
        if (z11) {
            canvas.drawRect(0.0f, f12, this.f15887e.width() - f14, -this.f15888f, this.f15886d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f15887e;
        canvas.translate(rectF2.right - f13, rectF2.bottom - f13);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f15889g, this.f15885c);
        if (z11) {
            canvas.drawRect(0.0f, f12, this.f15887e.width() - f14, (-this.f15888f) + this.f15891i, this.f15886d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f15887e;
        canvas.translate(rectF3.left + f13, rectF3.bottom - f13);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f15889g, this.f15885c);
        if (z12) {
            canvas.drawRect(0.0f, f12, this.f15887e.height() - f14, -this.f15888f, this.f15886d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f15887e;
        canvas.translate(rectF4.right - f13, rectF4.top + f13);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f15889g, this.f15885c);
        if (z12) {
            canvas.drawRect(0.0f, f12, this.f15887e.height() - f14, -this.f15888f, this.f15886d);
        }
        canvas.restoreToCount(save4);
    }

    public ColorStateList f() {
        return this.f15893k;
    }

    public float g() {
        return this.f15888f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) d(this.f15890h, this.f15888f, this.f15897o));
        int ceil2 = (int) Math.ceil((double) c(this.f15890h, this.f15888f, this.f15897o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public void h(Rect rect) {
        getPadding(rect);
    }

    public float i() {
        return this.f15890h;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f15893k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public float j() {
        float f11 = this.f15890h;
        return (Math.max(f11, this.f15888f + ((float) this.f15883a) + ((f11 * 1.5f) / 2.0f)) * 2.0f) + (((this.f15890h * 1.5f) + ((float) this.f15883a)) * 2.0f);
    }

    public float k() {
        float f11 = this.f15890h;
        return (Math.max(f11, this.f15888f + ((float) this.f15883a) + (f11 / 2.0f)) * 2.0f) + ((this.f15890h + ((float) this.f15883a)) * 2.0f);
    }

    public float l() {
        return this.f15892j;
    }

    public void m(boolean z11) {
        this.f15897o = z11;
        invalidateSelf();
    }

    public final void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f15893k = colorStateList;
        this.f15884b.setColor(colorStateList.getColorForState(getState(), this.f15893k.getDefaultColor()));
    }

    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f15894l = true;
    }

    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f15893k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f15884b.getColor() == colorForState) {
            return false;
        }
        this.f15884b.setColor(colorForState);
        this.f15894l = true;
        invalidateSelf();
        return true;
    }

    public void p(float f11) {
        if (f11 >= 0.0f) {
            float f12 = (float) ((int) (f11 + 0.5f));
            if (this.f15888f != f12) {
                this.f15888f = f12;
                this.f15894l = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f11 + ". Must be >= 0");
    }

    public void q(float f11) {
        s(this.f15892j, f11);
    }

    public void r(float f11) {
        s(f11, this.f15890h);
    }

    public final void s(float f11, float f12) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f11 + ". Must be >= 0");
        } else if (f12 >= 0.0f) {
            float t11 = (float) t(f11);
            float t12 = (float) t(f12);
            if (t11 > t12) {
                if (!this.f15898p) {
                    this.f15898p = true;
                }
                t11 = t12;
            }
            if (this.f15892j != t11 || this.f15890h != t12) {
                this.f15892j = t11;
                this.f15890h = t12;
                this.f15891i = (float) ((int) ((t11 * 1.5f) + ((float) this.f15883a) + 0.5f));
                this.f15894l = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f12 + ". Must be >= 0");
        }
    }

    public void setAlpha(int i11) {
        this.f15884b.setAlpha(i11);
        this.f15885c.setAlpha(i11);
        this.f15886d.setAlpha(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f15884b.setColorFilter(colorFilter);
    }

    public final int t(float f11) {
        int i11 = (int) (f11 + 0.5f);
        return i11 % 2 == 1 ? i11 - 1 : i11;
    }
}
