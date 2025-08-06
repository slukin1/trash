package androidx.constraintlayout.core.motion.utils;

public class StopLogicEngine implements g {

    /* renamed from: a  reason: collision with root package name */
    public float f6918a;

    /* renamed from: b  reason: collision with root package name */
    public float f6919b;

    /* renamed from: c  reason: collision with root package name */
    public float f6920c;

    /* renamed from: d  reason: collision with root package name */
    public float f6921d;

    /* renamed from: e  reason: collision with root package name */
    public float f6922e;

    /* renamed from: f  reason: collision with root package name */
    public float f6923f;

    /* renamed from: g  reason: collision with root package name */
    public float f6924g;

    /* renamed from: h  reason: collision with root package name */
    public float f6925h;

    /* renamed from: i  reason: collision with root package name */
    public float f6926i;

    /* renamed from: j  reason: collision with root package name */
    public int f6927j;

    /* renamed from: k  reason: collision with root package name */
    public String f6928k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f6929l = false;

    /* renamed from: m  reason: collision with root package name */
    public float f6930m;

    /* renamed from: n  reason: collision with root package name */
    public float f6931n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6932o = false;

    public float a() {
        return this.f6929l ? -e(this.f6931n) : e(this.f6931n);
    }

    public boolean b() {
        return a() < 1.0E-5f && Math.abs(this.f6926i - this.f6931n) < 1.0E-5f;
    }

    public final float c(float f11) {
        this.f6932o = false;
        float f12 = this.f6921d;
        if (f11 <= f12) {
            float f13 = this.f6918a;
            return (f13 * f11) + ((((this.f6919b - f13) * f11) * f11) / (f12 * 2.0f));
        }
        int i11 = this.f6927j;
        if (i11 == 1) {
            return this.f6924g;
        }
        float f14 = f11 - f12;
        float f15 = this.f6922e;
        if (f14 < f15) {
            float f16 = this.f6924g;
            float f17 = this.f6919b;
            return f16 + (f17 * f14) + ((((this.f6920c - f17) * f14) * f14) / (f15 * 2.0f));
        } else if (i11 == 2) {
            return this.f6925h;
        } else {
            float f18 = f14 - f15;
            float f19 = this.f6923f;
            if (f18 <= f19) {
                float f21 = this.f6925h;
                float f22 = this.f6920c;
                return (f21 + (f22 * f18)) - (((f22 * f18) * f18) / (f19 * 2.0f));
            }
            this.f6932o = true;
            return this.f6926i;
        }
    }

    public void d(float f11, float f12, float f13, float f14, float f15, float f16) {
        boolean z11 = false;
        this.f6932o = false;
        this.f6930m = f11;
        if (f11 > f12) {
            z11 = true;
        }
        this.f6929l = z11;
        if (z11) {
            f(-f13, f11 - f12, f15, f16, f14);
            return;
        }
        f(f13, f12 - f11, f15, f16, f14);
    }

    public float e(float f11) {
        float f12 = this.f6921d;
        if (f11 <= f12) {
            float f13 = this.f6918a;
            return f13 + (((this.f6919b - f13) * f11) / f12);
        }
        int i11 = this.f6927j;
        if (i11 == 1) {
            return 0.0f;
        }
        float f14 = f11 - f12;
        float f15 = this.f6922e;
        if (f14 < f15) {
            float f16 = this.f6919b;
            return f16 + (((this.f6920c - f16) * f14) / f15);
        } else if (i11 == 2) {
            return this.f6925h;
        } else {
            float f17 = f14 - f15;
            float f18 = this.f6923f;
            if (f17 >= f18) {
                return this.f6926i;
            }
            float f19 = this.f6920c;
            return f19 - ((f17 * f19) / f18);
        }
    }

    public final void f(float f11, float f12, float f13, float f14, float f15) {
        this.f6932o = false;
        if (f11 == 0.0f) {
            f11 = 1.0E-4f;
        }
        this.f6918a = f11;
        float f16 = f11 / f13;
        float f17 = (f16 * f11) / 2.0f;
        if (f11 < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f12 - ((((-f11) / f13) * f11) / 2.0f)) * f13));
            if (sqrt < f14) {
                this.f6928k = "backward accelerate, decelerate";
                this.f6927j = 2;
                this.f6918a = f11;
                this.f6919b = sqrt;
                this.f6920c = 0.0f;
                float f18 = (sqrt - f11) / f13;
                this.f6921d = f18;
                this.f6922e = sqrt / f13;
                this.f6924g = ((f11 + sqrt) * f18) / 2.0f;
                this.f6925h = f12;
                this.f6926i = f12;
                return;
            }
            this.f6928k = "backward accelerate cruse decelerate";
            this.f6927j = 3;
            this.f6918a = f11;
            this.f6919b = f14;
            this.f6920c = f14;
            float f19 = (f14 - f11) / f13;
            this.f6921d = f19;
            float f21 = f14 / f13;
            this.f6923f = f21;
            float f22 = ((f11 + f14) * f19) / 2.0f;
            float f23 = (f21 * f14) / 2.0f;
            this.f6922e = ((f12 - f22) - f23) / f14;
            this.f6924g = f22;
            this.f6925h = f12 - f23;
            this.f6926i = f12;
        } else if (f17 >= f12) {
            this.f6928k = "hard stop";
            this.f6927j = 1;
            this.f6918a = f11;
            this.f6919b = 0.0f;
            this.f6924g = f12;
            this.f6921d = (2.0f * f12) / f11;
        } else {
            float f24 = f12 - f17;
            float f25 = f24 / f11;
            if (f25 + f16 < f15) {
                this.f6928k = "cruse decelerate";
                this.f6927j = 2;
                this.f6918a = f11;
                this.f6919b = f11;
                this.f6920c = 0.0f;
                this.f6924g = f24;
                this.f6925h = f12;
                this.f6921d = f25;
                this.f6922e = f16;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) ((f13 * f12) + ((f11 * f11) / 2.0f)));
            float f26 = (sqrt2 - f11) / f13;
            this.f6921d = f26;
            float f27 = sqrt2 / f13;
            this.f6922e = f27;
            if (sqrt2 < f14) {
                this.f6928k = "accelerate decelerate";
                this.f6927j = 2;
                this.f6918a = f11;
                this.f6919b = sqrt2;
                this.f6920c = 0.0f;
                this.f6921d = f26;
                this.f6922e = f27;
                this.f6924g = ((f11 + sqrt2) * f26) / 2.0f;
                this.f6925h = f12;
                return;
            }
            this.f6928k = "accelerate cruse decelerate";
            this.f6927j = 3;
            this.f6918a = f11;
            this.f6919b = f14;
            this.f6920c = f14;
            float f28 = (f14 - f11) / f13;
            this.f6921d = f28;
            float f29 = f14 / f13;
            this.f6923f = f29;
            float f31 = ((f11 + f14) * f28) / 2.0f;
            float f32 = (f29 * f14) / 2.0f;
            this.f6922e = ((f12 - f31) - f32) / f14;
            this.f6924g = f31;
            this.f6925h = f12 - f32;
            this.f6926i = f12;
        }
    }

    public float getInterpolation(float f11) {
        float c11 = c(f11);
        this.f6931n = f11;
        return this.f6929l ? this.f6930m - c11 : this.f6930m + c11;
    }
}
