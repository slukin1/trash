package com.hbg.component.kline.shape;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public abstract class BaseShape {

    /* renamed from: a  reason: collision with root package name */
    public Paint f67335a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f67336b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public RectF f67337c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    public float f67338d;

    /* renamed from: e  reason: collision with root package name */
    public float f67339e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67340f = true;

    public boolean a(Object obj) {
        return obj instanceof BaseShape;
    }

    public RectF b() {
        return this.f67337c;
    }

    public Paint c() {
        return this.f67335a;
    }

    public Rect d() {
        return this.f67336b;
    }

    public float e() {
        return this.f67338d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseShape)) {
            return false;
        }
        BaseShape baseShape = (BaseShape) obj;
        if (!baseShape.a(this)) {
            return false;
        }
        Paint c11 = c();
        Paint c12 = baseShape.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        Rect d11 = d();
        Rect d12 = baseShape.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        RectF b11 = b();
        RectF b12 = baseShape.b();
        if (b11 != null ? b11.equals(b12) : b12 == null) {
            return Float.compare(e(), baseShape.e()) == 0 && Float.compare(f(), baseShape.f()) == 0 && g() == baseShape.g();
        }
        return false;
    }

    public float f() {
        return this.f67339e;
    }

    public boolean g() {
        return this.f67340f;
    }

    public void h() {
    }

    public int hashCode() {
        Paint c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        Rect d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        RectF b11 = b();
        int i12 = hashCode2 * 59;
        if (b11 != null) {
            i11 = b11.hashCode();
        }
        return ((((((i12 + i11) * 59) + Float.floatToIntBits(e())) * 59) + Float.floatToIntBits(f())) * 59) + (g() ? 79 : 97);
    }

    public void i(Paint paint) {
        this.f67335a = paint;
    }

    public void j(boolean z11) {
        this.f67340f = z11;
    }

    public void k(float f11) {
        this.f67339e = f11;
    }

    public String toString() {
        return "BaseShape(paint=" + c() + ", tempRect=" + d() + ", bound=" + b() + ", x=" + e() + ", y=" + f() + ", visible=" + g() + ")";
    }
}
