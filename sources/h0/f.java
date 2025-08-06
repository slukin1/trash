package h0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public float f15870a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f15871b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f15872c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f15873d;

    /* renamed from: e  reason: collision with root package name */
    public float f15874e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15875f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15876g = true;

    /* renamed from: h  reason: collision with root package name */
    public ColorStateList f15877h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuffColorFilter f15878i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f15879j;

    /* renamed from: k  reason: collision with root package name */
    public PorterDuff.Mode f15880k = PorterDuff.Mode.SRC_IN;

    public f(ColorStateList colorStateList, float f11) {
        this.f15870a = f11;
        this.f15871b = new Paint(5);
        e(colorStateList);
        this.f15872c = new RectF();
        this.f15873d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f15877h;
    }

    public float c() {
        return this.f15874e;
    }

    public float d() {
        return this.f15870a;
    }

    public void draw(Canvas canvas) {
        boolean z11;
        Paint paint = this.f15871b;
        if (this.f15878i == null || paint.getColorFilter() != null) {
            z11 = false;
        } else {
            paint.setColorFilter(this.f15878i);
            z11 = true;
        }
        RectF rectF = this.f15872c;
        float f11 = this.f15870a;
        canvas.drawRoundRect(rectF, f11, f11, paint);
        if (z11) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f15877h = colorStateList;
        this.f15871b.setColor(colorStateList.getColorForState(getState(), this.f15877h.getDefaultColor()));
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f11, boolean z11, boolean z12) {
        if (f11 != this.f15874e || this.f15875f != z11 || this.f15876g != z12) {
            this.f15874e = f11;
            this.f15875f = z11;
            this.f15876g = z12;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f15873d, this.f15870a);
    }

    public void h(float f11) {
        if (f11 != this.f15870a) {
            this.f15870a = f11;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f15872c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f15873d.set(rect);
        if (this.f15875f) {
            float d11 = g.d(this.f15874e, this.f15870a, this.f15876g);
            this.f15873d.inset((int) Math.ceil((double) g.c(this.f15874e, this.f15870a, this.f15876g)), (int) Math.ceil((double) d11));
            this.f15872c.set(this.f15873d);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f15877h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f15879j
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f15877h
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x0014:
            boolean r0 = super.isStateful()
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.f.isStateful():boolean");
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f15877h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z11 = colorForState != this.f15871b.getColor();
        if (z11) {
            this.f15871b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f15879j;
        if (colorStateList2 == null || (mode = this.f15880k) == null) {
            return z11;
        }
        this.f15878i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i11) {
        this.f15871b.setAlpha(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f15871b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f15879j = colorStateList;
        this.f15878i = a(colorStateList, this.f15880k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f15880k = mode;
        this.f15878i = a(this.f15879j, mode);
        invalidateSelf();
    }
}
