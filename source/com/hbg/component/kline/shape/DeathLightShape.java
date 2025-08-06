package com.hbg.component.kline.shape;

import android.graphics.Canvas;
import com.hbg.component.kline.utils.PaintUtils;

public class DeathLightShape extends BaseShape {

    /* renamed from: g  reason: collision with root package name */
    public float f67362g;

    /* renamed from: h  reason: collision with root package name */
    public float f67363h;

    /* renamed from: i  reason: collision with root package name */
    public int f67364i;

    /* renamed from: j  reason: collision with root package name */
    public int f67365j;

    /* renamed from: k  reason: collision with root package name */
    public float f67366k;

    /* renamed from: l  reason: collision with root package name */
    public float f67367l;

    public boolean a(Object obj) {
        return obj instanceof DeathLightShape;
    }

    public float e() {
        return this.f67362g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeathLightShape)) {
            return false;
        }
        DeathLightShape deathLightShape = (DeathLightShape) obj;
        return deathLightShape.a(this) && super.equals(obj) && Float.compare(e(), deathLightShape.e()) == 0 && Float.compare(f(), deathLightShape.f()) == 0 && m() == deathLightShape.m() && o() == deathLightShape.o() && Float.compare(n(), deathLightShape.n()) == 0 && Float.compare(p(), deathLightShape.p()) == 0;
    }

    public float f() {
        return this.f67363h;
    }

    public int hashCode() {
        return (((((((((((super.hashCode() * 59) + Float.floatToIntBits(e())) * 59) + Float.floatToIntBits(f())) * 59) + m()) * 59) + o()) * 59) + Float.floatToIntBits(n())) * 59) + Float.floatToIntBits(p());
    }

    public void k(float f11) {
        this.f67363h = f11;
    }

    public void l(Canvas canvas) {
        canvas.save();
        canvas.translate(this.f67362g, this.f67363h);
        PaintUtils.c(this.f67335a, this.f67365j);
        canvas.drawCircle(0.0f, 0.0f, this.f67367l, this.f67335a);
        PaintUtils.c(this.f67335a, this.f67364i);
        canvas.drawCircle(0.0f, 0.0f, this.f67366k, this.f67335a);
        canvas.restore();
    }

    public int m() {
        return this.f67364i;
    }

    public float n() {
        return this.f67366k;
    }

    public int o() {
        return this.f67365j;
    }

    public float p() {
        return this.f67367l;
    }

    public void q(int i11) {
        this.f67364i = i11;
    }

    public void r(float f11) {
        this.f67366k = f11;
    }

    public void s(int i11) {
        this.f67365j = i11;
    }

    public void t(float f11) {
        this.f67367l = f11;
    }

    public String toString() {
        return "DeathLightShape(x=" + e() + ", y=" + f() + ", interCircleColor=" + m() + ", outerCircleColor=" + o() + ", interCircleRadius=" + n() + ", outerCircleRadius=" + p() + ")";
    }

    public void u(float f11) {
        this.f67362g = f11;
    }
}
