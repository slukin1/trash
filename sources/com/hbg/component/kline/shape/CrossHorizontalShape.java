package com.hbg.component.kline.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.PaintUtils;

public class CrossHorizontalShape extends BaseShape {

    /* renamed from: g  reason: collision with root package name */
    public boolean f67350g;

    /* renamed from: h  reason: collision with root package name */
    public String f67351h;

    /* renamed from: i  reason: collision with root package name */
    public int f67352i;

    /* renamed from: j  reason: collision with root package name */
    public int f67353j;

    /* renamed from: k  reason: collision with root package name */
    public int f67354k;

    /* renamed from: l  reason: collision with root package name */
    public float f67355l;

    /* renamed from: m  reason: collision with root package name */
    public int f67356m;

    /* renamed from: n  reason: collision with root package name */
    public int f67357n;

    /* renamed from: o  reason: collision with root package name */
    public int f67358o;

    /* renamed from: p  reason: collision with root package name */
    public RectF f67359p = new RectF();

    /* renamed from: q  reason: collision with root package name */
    public int f67360q = DimenUtils.a(2.0f);

    /* renamed from: r  reason: collision with root package name */
    public float f67361r = ((float) DimenUtils.a(1.0f));

    public void A(int i11) {
        this.f67356m = i11;
    }

    public void B(float f11) {
        this.f67355l = f11;
    }

    public void C(int i11) {
        this.f67354k = i11;
    }

    public void D(int i11) {
        this.f67353j = i11;
    }

    public void E(int i11) {
        this.f67352i = i11;
    }

    public void F(int i11) {
        this.f67357n = i11;
    }

    public boolean a(Object obj) {
        return obj instanceof CrossHorizontalShape;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrossHorizontalShape)) {
            return false;
        }
        CrossHorizontalShape crossHorizontalShape = (CrossHorizontalShape) obj;
        if (!crossHorizontalShape.a(this) || !super.equals(obj) || x() != crossHorizontalShape.x()) {
            return false;
        }
        String o11 = o();
        String o12 = crossHorizontalShape.o();
        if (o11 != null ? !o11.equals(o12) : o12 != null) {
            return false;
        }
        if (v() != crossHorizontalShape.v() || u() != crossHorizontalShape.u() || s() != crossHorizontalShape.s() || Float.compare(r(), crossHorizontalShape.r()) != 0 || q() != crossHorizontalShape.q() || w() != crossHorizontalShape.w() || p() != crossHorizontalShape.p()) {
            return false;
        }
        RectF t11 = t();
        RectF t12 = crossHorizontalShape.t();
        if (t11 != null ? t11.equals(t12) : t12 == null) {
            return n() == crossHorizontalShape.n() && Float.compare(m(), crossHorizontalShape.m()) == 0;
        }
        return false;
    }

    public void h() {
        super.h();
        if (!TextUtils.isEmpty(this.f67351h)) {
            PaintUtils.h(this.f67335a, Paint.Align.LEFT, this.f67353j, (float) this.f67352i);
            Paint paint = this.f67335a;
            String str = this.f67351h;
            paint.getTextBounds(str, 0, str.length(), this.f67336b);
            this.f67358o = 0 - this.f67336b.centerY();
            RectF rectF = this.f67359p;
            rectF.left = 0.0f;
            rectF.right = ((float) this.f67336b.width()) + 0.0f + (this.f67361r * 4.0f);
            RectF rectF2 = this.f67359p;
            rectF2.top = 0.0f;
            rectF2.bottom = FloatPriceShape.f67368y;
            rectF2.offset(this.f67350g ? (float) this.f67360q : ((float) (this.f67357n - this.f67360q)) - rectF2.width(), -this.f67359p.centerY());
        }
    }

    public int hashCode() {
        int hashCode = (super.hashCode() * 59) + (x() ? 79 : 97);
        String o11 = o();
        int i11 = 43;
        int hashCode2 = (((((((((((((((hashCode * 59) + (o11 == null ? 43 : o11.hashCode())) * 59) + v()) * 59) + u()) * 59) + s()) * 59) + Float.floatToIntBits(r())) * 59) + q()) * 59) + w()) * 59) + p();
        RectF t11 = t();
        int i12 = hashCode2 * 59;
        if (t11 != null) {
            i11 = t11.hashCode();
        }
        return ((((i12 + i11) * 59) + n()) * 59) + Float.floatToIntBits(m());
    }

    public void l(Canvas canvas) {
        if (!TextUtils.isEmpty(this.f67351h)) {
            canvas.save();
            canvas.translate(0.0f, this.f67339e);
            PaintUtils.c(this.f67335a, this.f67356m);
            RectF rectF = this.f67359p;
            float f11 = this.f67361r;
            canvas.drawRoundRect(rectF, f11 * 2.0f, f11 * 2.0f, this.f67335a);
            PaintUtils.h(this.f67335a, Paint.Align.CENTER, this.f67353j, (float) this.f67352i);
            canvas.drawText(this.f67351h, this.f67359p.centerX(), (float) this.f67358o, this.f67335a);
            PaintUtils.b(this.f67335a, this.f67354k, this.f67355l);
            if (this.f67350g) {
                canvas.drawLine(this.f67359p.right, 0.0f, (float) this.f67357n, 0.0f, this.f67335a);
            } else {
                canvas.drawLine(0.0f, 0.0f, this.f67359p.left, 0.0f, this.f67335a);
            }
            canvas.restore();
        }
    }

    public float m() {
        return this.f67361r;
    }

    public int n() {
        return this.f67360q;
    }

    public String o() {
        return this.f67351h;
    }

    public int p() {
        return this.f67358o;
    }

    public int q() {
        return this.f67356m;
    }

    public float r() {
        return this.f67355l;
    }

    public int s() {
        return this.f67354k;
    }

    public RectF t() {
        return this.f67359p;
    }

    public String toString() {
        return "CrossHorizontalShape(showLeft=" + x() + ", tag=" + o() + ", tagTextSize=" + v() + ", tagTextColor=" + u() + ", tagPathColor=" + s() + ", tagPathBorder=" + r() + ", tagBgColor=" + q() + ", width=" + w() + ", tagBaseLine=" + p() + ", tagRect=" + t() + ", lrMargin=" + n() + ", dp1=" + m() + ")";
    }

    public int u() {
        return this.f67353j;
    }

    public int v() {
        return this.f67352i;
    }

    public int w() {
        return this.f67357n;
    }

    public boolean x() {
        return this.f67350g;
    }

    public void y(boolean z11) {
        this.f67350g = z11;
    }

    public void z(String str) {
        this.f67351h = str;
    }
}
