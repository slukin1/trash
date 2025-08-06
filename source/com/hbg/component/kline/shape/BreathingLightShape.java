package com.hbg.component.kline.shape;

import android.graphics.Canvas;
import android.graphics.RadialGradient;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.PaintUtils;

public class BreathingLightShape extends BaseShape {

    /* renamed from: g  reason: collision with root package name */
    public float f67341g = ((float) DimenUtils.a(1.0f));

    /* renamed from: h  reason: collision with root package name */
    public float f67342h;

    /* renamed from: i  reason: collision with root package name */
    public float f67343i;

    /* renamed from: j  reason: collision with root package name */
    public int f67344j;

    /* renamed from: k  reason: collision with root package name */
    public int f67345k;

    /* renamed from: l  reason: collision with root package name */
    public float f67346l;

    /* renamed from: m  reason: collision with root package name */
    public float f67347m;

    /* renamed from: n  reason: collision with root package name */
    public RadialGradient f67348n;

    /* renamed from: o  reason: collision with root package name */
    public float f67349o;

    public boolean a(Object obj) {
        return obj instanceof BreathingLightShape;
    }

    public float e() {
        return this.f67342h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BreathingLightShape)) {
            return false;
        }
        BreathingLightShape breathingLightShape = (BreathingLightShape) obj;
        if (!breathingLightShape.a(this) || !super.equals(obj) || Float.compare(m(), breathingLightShape.m()) != 0 || Float.compare(e(), breathingLightShape.e()) != 0 || Float.compare(f(), breathingLightShape.f()) != 0 || n() != breathingLightShape.n() || p() != breathingLightShape.p() || Float.compare(o(), breathingLightShape.o()) != 0 || Float.compare(q(), breathingLightShape.q()) != 0) {
            return false;
        }
        RadialGradient s11 = s();
        RadialGradient s12 = breathingLightShape.s();
        if (s11 != null ? s11.equals(s12) : s12 == null) {
            return Float.compare(r(), breathingLightShape.r()) == 0;
        }
        return false;
    }

    public float f() {
        return this.f67343i;
    }

    public int hashCode() {
        int hashCode = (((((((((((((super.hashCode() * 59) + Float.floatToIntBits(m())) * 59) + Float.floatToIntBits(e())) * 59) + Float.floatToIntBits(f())) * 59) + n()) * 59) + p()) * 59) + Float.floatToIntBits(o())) * 59) + Float.floatToIntBits(q());
        RadialGradient s11 = s();
        return (((hashCode * 59) + (s11 == null ? 43 : s11.hashCode())) * 59) + Float.floatToIntBits(r());
    }

    public void k(float f11) {
        this.f67343i = f11;
    }

    public void l(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f67342h, this.f67343i);
        PaintUtils.g(this.f67335a, this.f67348n);
        this.f67335a.setAlpha((int) (this.f67349o * 255.0f));
        canvas.drawCircle(0.0f, 0.0f, this.f67347m, this.f67335a);
        PaintUtils.c(this.f67335a, this.f67344j);
        canvas.drawCircle(0.0f, 0.0f, this.f67346l, this.f67335a);
        PaintUtils.d(this.f67335a, this.f67345k, this.f67341g);
        canvas.drawCircle(0.0f, 0.0f, this.f67346l, this.f67335a);
        canvas.restore();
    }

    public float m() {
        return this.f67341g;
    }

    public int n() {
        return this.f67344j;
    }

    public float o() {
        return this.f67346l;
    }

    public int p() {
        return this.f67345k;
    }

    public float q() {
        return this.f67347m;
    }

    public float r() {
        return this.f67349o;
    }

    public RadialGradient s() {
        return this.f67348n;
    }

    public void t(int i11) {
        this.f67344j = i11;
    }

    public String toString() {
        return "BreathingLightShape(edgeWidth=" + m() + ", x=" + e() + ", y=" + f() + ", interCenterColor=" + n() + ", interEdgeColor=" + p() + ", interCircleRadius=" + o() + ", outerCircleRadius=" + q() + ", rg=" + s() + ", phase=" + r() + ")";
    }

    public void u(float f11) {
        this.f67346l = f11;
    }

    public void v(int i11) {
        this.f67345k = i11;
    }

    public void w(float f11) {
        this.f67347m = f11;
    }

    public void x(float f11) {
        this.f67349o = f11;
    }

    public void y(RadialGradient radialGradient) {
        this.f67348n = radialGradient;
    }

    public void z(float f11) {
        this.f67342h = f11;
    }
}
