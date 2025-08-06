package com.hbg.component.kline.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.hbg.component.kline.utils.PaintUtils;

public class LabelShape extends BaseShape {

    /* renamed from: g  reason: collision with root package name */
    public Paint.Align f67387g = Paint.Align.LEFT;

    /* renamed from: h  reason: collision with root package name */
    public String f67388h;

    /* renamed from: i  reason: collision with root package name */
    public int f67389i;

    /* renamed from: j  reason: collision with root package name */
    public int f67390j;

    /* renamed from: k  reason: collision with root package name */
    public float f67391k;

    /* renamed from: l  reason: collision with root package name */
    public float f67392l;

    public boolean a(Object obj) {
        return obj instanceof LabelShape;
    }

    public float e() {
        return this.f67391k;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LabelShape)) {
            return false;
        }
        LabelShape labelShape = (LabelShape) obj;
        if (!labelShape.a(this) || !super.equals(obj)) {
            return false;
        }
        Paint.Align m11 = m();
        Paint.Align m12 = labelShape.m();
        if (m11 != null ? !m11.equals(m12) : m12 != null) {
            return false;
        }
        String n11 = n();
        String n12 = labelShape.n();
        if (n11 != null ? n11.equals(n12) : n12 == null) {
            return o() == labelShape.o() && p() == labelShape.p() && Float.compare(e(), labelShape.e()) == 0 && Float.compare(f(), labelShape.f()) == 0;
        }
        return false;
    }

    public float f() {
        return this.f67392l;
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        Paint.Align m11 = m();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (m11 == null ? 43 : m11.hashCode());
        String n11 = n();
        int i12 = hashCode2 * 59;
        if (n11 != null) {
            i11 = n11.hashCode();
        }
        return ((((((((i12 + i11) * 59) + o()) * 59) + p()) * 59) + Float.floatToIntBits(e())) * 59) + Float.floatToIntBits(f());
    }

    public void k(float f11) {
        this.f67392l = f11;
    }

    public void l(Canvas canvas) {
        Paint paint;
        if (this.f67388h != null && (paint = this.f67335a) != null) {
            PaintUtils.h(paint, this.f67387g, this.f67389i, (float) this.f67390j);
            canvas.drawText(this.f67388h, this.f67391k, this.f67392l, this.f67335a);
        }
    }

    public Paint.Align m() {
        return this.f67387g;
    }

    public String n() {
        return this.f67388h;
    }

    public int o() {
        return this.f67389i;
    }

    public int p() {
        return this.f67390j;
    }

    public void q(Paint.Align align) {
        this.f67387g = align;
    }

    public void r(String str) {
        this.f67388h = str;
    }

    public void s(int i11) {
        this.f67389i = i11;
    }

    public void t(int i11) {
        this.f67390j = i11;
    }

    public String toString() {
        return "LabelShape(align=" + m() + ", text=" + n() + ", textColor=" + o() + ", textSize=" + p() + ", x=" + e() + ", y=" + f() + ")";
    }

    public void u(float f11) {
        this.f67391k = f11;
    }
}
