package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public class ViewPortHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f65570a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public RectF f65571b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    public float f65572c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f65573d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f65574e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f65575f = Float.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public float f65576g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f65577h = Float.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public float f65578i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f65579j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f65580k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f65581l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f65582m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    public float f65583n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    public float[] f65584o = new float[9];

    /* renamed from: p  reason: collision with root package name */
    public Matrix f65585p = new Matrix();

    /* renamed from: q  reason: collision with root package name */
    public final float[] f65586q = new float[9];

    public boolean A(float f11) {
        return this.f65571b.right >= (((float) ((int) (f11 * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean B(float f11) {
        return this.f65571b.top <= f11;
    }

    public boolean C(float f11) {
        return z(f11) && A(f11);
    }

    public boolean D(float f11) {
        return B(f11) && y(f11);
    }

    public void E(Matrix matrix, RectF rectF) {
        float f11;
        matrix.getValues(this.f65586q);
        float[] fArr = this.f65586q;
        float f12 = fArr[2];
        float f13 = fArr[0];
        float f14 = fArr[5];
        float f15 = fArr[4];
        this.f65578i = Math.min(Math.max(this.f65576g, f13), this.f65577h);
        this.f65579j = Math.min(Math.max(this.f65574e, f15), this.f65575f);
        float f16 = 0.0f;
        if (rectF != null) {
            f16 = rectF.width();
            f11 = rectF.height();
        } else {
            f11 = 0.0f;
        }
        this.f65580k = Math.min(Math.max(f12, ((-f16) * (this.f65578i - 1.0f)) - this.f65582m), this.f65582m);
        float max = Math.max(Math.min(f14, (f11 * (this.f65579j - 1.0f)) + this.f65583n), -this.f65583n);
        this.f65581l = max;
        float[] fArr2 = this.f65586q;
        fArr2[2] = this.f65580k;
        fArr2[0] = this.f65578i;
        fArr2[5] = max;
        fArr2[4] = this.f65579j;
        matrix.setValues(fArr2);
    }

    public float F() {
        return this.f65573d - this.f65571b.bottom;
    }

    public float G() {
        return this.f65571b.left;
    }

    public float H() {
        return this.f65572c - this.f65571b.right;
    }

    public float I() {
        return this.f65571b.top;
    }

    public Matrix J(Matrix matrix, View view, boolean z11) {
        this.f65570a.set(matrix);
        E(this.f65570a, this.f65571b);
        if (z11) {
            view.invalidate();
        }
        matrix.set(this.f65570a);
        return matrix;
    }

    public void K(float f11, float f12, float f13, float f14) {
        this.f65571b.set(f11, f12, this.f65572c - f13, this.f65573d - f14);
    }

    public void L(float f11, float f12) {
        float G = G();
        float I = I();
        float H = H();
        float F = F();
        this.f65573d = f12;
        this.f65572c = f11;
        K(G, I, H, F);
    }

    public void M(float f11) {
        this.f65582m = Utils.e(f11);
    }

    public void N(float f11) {
        this.f65583n = Utils.e(f11);
    }

    public void O(float f11) {
        if (f11 == 0.0f) {
            f11 = Float.MAX_VALUE;
        }
        this.f65577h = f11;
        E(this.f65570a, this.f65571b);
    }

    public void P(float f11) {
        if (f11 == 0.0f) {
            f11 = Float.MAX_VALUE;
        }
        this.f65575f = f11;
        E(this.f65570a, this.f65571b);
    }

    public void Q(float f11) {
        if (f11 < 1.0f) {
            f11 = 1.0f;
        }
        this.f65576g = f11;
        E(this.f65570a, this.f65571b);
    }

    public void R(float f11) {
        if (f11 < 1.0f) {
            f11 = 1.0f;
        }
        this.f65574e = f11;
        E(this.f65570a, this.f65571b);
    }

    public void S(float f11, float f12, float f13, float f14, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f65570a);
        matrix.postScale(f11, f12, f13, f14);
    }

    public boolean a() {
        return this.f65578i < this.f65577h;
    }

    public boolean b() {
        return this.f65579j < this.f65575f;
    }

    public boolean c() {
        return this.f65578i > this.f65576g;
    }

    public boolean d() {
        return this.f65579j > this.f65574e;
    }

    public void e(float[] fArr, View view) {
        Matrix matrix = this.f65585p;
        matrix.reset();
        matrix.set(this.f65570a);
        matrix.postTranslate(-(fArr[0] - G()), -(fArr[1] - I()));
        J(matrix, view, true);
    }

    public float f() {
        return this.f65571b.bottom;
    }

    public float g() {
        return this.f65571b.height();
    }

    public float h() {
        return this.f65571b.left;
    }

    public float i() {
        return this.f65571b.right;
    }

    public float j() {
        return this.f65571b.top;
    }

    public float k() {
        return this.f65571b.width();
    }

    public float l() {
        return this.f65573d;
    }

    public float m() {
        return this.f65572c;
    }

    public MPPointF n() {
        return MPPointF.c(this.f65571b.centerX(), this.f65571b.centerY());
    }

    public RectF o() {
        return this.f65571b;
    }

    public Matrix p() {
        return this.f65570a;
    }

    public float q() {
        return this.f65578i;
    }

    public float r() {
        return this.f65579j;
    }

    public float s() {
        return Math.min(this.f65571b.width(), this.f65571b.height());
    }

    public boolean t() {
        return this.f65582m <= 0.0f && this.f65583n <= 0.0f;
    }

    public boolean u() {
        return v() && w();
    }

    public boolean v() {
        float f11 = this.f65578i;
        float f12 = this.f65576g;
        return f11 <= f12 && f12 <= 1.0f;
    }

    public boolean w() {
        float f11 = this.f65579j;
        float f12 = this.f65574e;
        return f11 <= f12 && f12 <= 1.0f;
    }

    public boolean x(float f11, float f12) {
        return C(f11) && D(f12);
    }

    public boolean y(float f11) {
        return this.f65571b.bottom >= ((float) ((int) (f11 * 100.0f))) / 100.0f;
    }

    public boolean z(float f11) {
        return this.f65571b.left <= f11 + 1.0f;
    }
}
