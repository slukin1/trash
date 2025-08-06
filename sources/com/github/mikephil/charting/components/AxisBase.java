package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.utils.Utils;
import d5.a;
import d5.c;
import java.util.ArrayList;
import java.util.List;

public abstract class AxisBase extends ComponentBase {
    public boolean A = false;
    public float B = 0.0f;
    public float C = 0.0f;
    public boolean D = false;
    public boolean E = false;
    public float F = 0.0f;
    public float G = 0.0f;
    public float H = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public c f65392g;

    /* renamed from: h  reason: collision with root package name */
    public int f65393h = -7829368;

    /* renamed from: i  reason: collision with root package name */
    public float f65394i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    public int f65395j = -7829368;

    /* renamed from: k  reason: collision with root package name */
    public float f65396k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    public float[] f65397l = new float[0];

    /* renamed from: m  reason: collision with root package name */
    public float[] f65398m = new float[0];

    /* renamed from: n  reason: collision with root package name */
    public int f65399n;

    /* renamed from: o  reason: collision with root package name */
    public int f65400o;

    /* renamed from: p  reason: collision with root package name */
    public int f65401p = 6;

    /* renamed from: q  reason: collision with root package name */
    public float f65402q = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    public boolean f65403r = false;

    /* renamed from: s  reason: collision with root package name */
    public boolean f65404s = false;

    /* renamed from: t  reason: collision with root package name */
    public boolean f65405t = true;

    /* renamed from: u  reason: collision with root package name */
    public boolean f65406u = true;

    /* renamed from: v  reason: collision with root package name */
    public boolean f65407v = true;

    /* renamed from: w  reason: collision with root package name */
    public boolean f65408w = false;

    /* renamed from: x  reason: collision with root package name */
    public DashPathEffect f65409x = null;

    /* renamed from: y  reason: collision with root package name */
    public DashPathEffect f65410y = null;

    /* renamed from: z  reason: collision with root package name */
    public List<LimitLine> f65411z;

    public AxisBase() {
        this.f65416e = Utils.e(10.0f);
        this.f65413b = Utils.e(5.0f);
        this.f65414c = Utils.e(5.0f);
        this.f65411z = new ArrayList();
    }

    public boolean A() {
        return this.f65407v;
    }

    public boolean B() {
        return this.A;
    }

    public boolean C() {
        return this.f65404s;
    }

    public boolean D() {
        return this.f65403r;
    }

    public void E(boolean z11) {
        this.f65408w = z11;
    }

    public void F(boolean z11) {
        this.f65406u = z11;
    }

    public void G(boolean z11) {
        this.f65405t = z11;
    }

    public void H(boolean z11) {
        this.f65407v = z11;
    }

    public void I(float f11) {
        this.f65402q = f11;
        this.f65403r = true;
    }

    public void J(int i11) {
        if (i11 > 25) {
            i11 = 25;
        }
        if (i11 < 2) {
            i11 = 2;
        }
        this.f65401p = i11;
        this.f65404s = false;
    }

    public void K(int i11, boolean z11) {
        J(i11);
        this.f65404s = z11;
    }

    public void L(float f11) {
        this.C = f11;
    }

    public void M(float f11) {
        this.B = f11;
    }

    public void N(c cVar) {
        if (cVar == null) {
            this.f65392g = new a(this.f65400o);
        } else {
            this.f65392g = cVar;
        }
    }

    public void j(float f11, float f12) {
        float f13 = this.D ? this.G : f11 - this.B;
        float f14 = this.E ? this.F : f12 + this.C;
        if (Math.abs(f14 - f13) == 0.0f) {
            f14 += 1.0f;
            f13 -= 1.0f;
        }
        this.G = f13;
        this.F = f14;
        this.H = Math.abs(f14 - f13);
    }

    public void k(float f11, float f12, float f13) {
        this.f65410y = new DashPathEffect(new float[]{f11, f12}, f13);
    }

    public int l() {
        return this.f65395j;
    }

    public DashPathEffect m() {
        return this.f65409x;
    }

    public float n() {
        return this.f65396k;
    }

    public String o(int i11) {
        return (i11 < 0 || i11 >= this.f65397l.length) ? "" : w().a(this.f65397l[i11], this);
    }

    public float p() {
        return this.f65402q;
    }

    public int q() {
        return this.f65393h;
    }

    public DashPathEffect r() {
        return this.f65410y;
    }

    public float s() {
        return this.f65394i;
    }

    public int t() {
        return this.f65401p;
    }

    public List<LimitLine> u() {
        return this.f65411z;
    }

    public String v() {
        String str = "";
        for (int i11 = 0; i11 < this.f65397l.length; i11++) {
            String o11 = o(i11);
            if (o11 != null && str.length() < o11.length()) {
                str = o11;
            }
        }
        return str;
    }

    public c w() {
        c cVar = this.f65392g;
        if (cVar == null || ((cVar instanceof a) && ((a) cVar).b() != this.f65400o)) {
            this.f65392g = new a(this.f65400o);
        }
        return this.f65392g;
    }

    public boolean x() {
        return this.f65408w && this.f65399n > 0;
    }

    public boolean y() {
        return this.f65406u;
    }

    public boolean z() {
        return this.f65405t;
    }
}
