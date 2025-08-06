package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.b;

public final class SpringForce {

    /* renamed from: a  reason: collision with root package name */
    public double f9314a = Math.sqrt(1500.0d);

    /* renamed from: b  reason: collision with root package name */
    public double f9315b = 0.5d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9316c = false;

    /* renamed from: d  reason: collision with root package name */
    public double f9317d;

    /* renamed from: e  reason: collision with root package name */
    public double f9318e;

    /* renamed from: f  reason: collision with root package name */
    public double f9319f;

    /* renamed from: g  reason: collision with root package name */
    public double f9320g;

    /* renamed from: h  reason: collision with root package name */
    public double f9321h;

    /* renamed from: i  reason: collision with root package name */
    public double f9322i = Double.MAX_VALUE;

    /* renamed from: j  reason: collision with root package name */
    public final b.o f9323j = new b.o();

    public SpringForce() {
    }

    public float a() {
        return (float) this.f9322i;
    }

    public final void b() {
        if (!this.f9316c) {
            if (this.f9322i != Double.MAX_VALUE) {
                double d11 = this.f9315b;
                if (d11 > 1.0d) {
                    double d12 = this.f9314a;
                    this.f9319f = ((-d11) * d12) + (d12 * Math.sqrt((d11 * d11) - 1.0d));
                    double d13 = this.f9315b;
                    double d14 = this.f9314a;
                    this.f9320g = ((-d13) * d14) - (d14 * Math.sqrt((d13 * d13) - 1.0d));
                } else if (d11 >= 0.0d && d11 < 1.0d) {
                    this.f9321h = this.f9314a * Math.sqrt(1.0d - (d11 * d11));
                }
                this.f9316c = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    public boolean c(float f11, float f12) {
        return ((double) Math.abs(f12)) < this.f9318e && ((double) Math.abs(f11 - a())) < this.f9317d;
    }

    public SpringForce d(float f11) {
        if (f11 >= 0.0f) {
            this.f9315b = (double) f11;
            this.f9316c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce e(float f11) {
        this.f9322i = (double) f11;
        return this;
    }

    public SpringForce f(float f11) {
        if (f11 > 0.0f) {
            this.f9314a = Math.sqrt((double) f11);
            this.f9316c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void g(double d11) {
        double abs = Math.abs(d11);
        this.f9317d = abs;
        this.f9318e = abs * 62.5d;
    }

    public b.o h(double d11, double d12, long j11) {
        double d13;
        double d14;
        b();
        double d15 = ((double) j11) / 1000.0d;
        double d16 = d11 - this.f9322i;
        double d17 = this.f9315b;
        if (d17 > 1.0d) {
            double d18 = this.f9320g;
            double d19 = this.f9319f;
            double d21 = d16 - (((d18 * d16) - d12) / (d18 - d19));
            double d22 = ((d16 * d18) - d12) / (d18 - d19);
            d14 = (Math.pow(2.718281828459045d, d18 * d15) * d21) + (Math.pow(2.718281828459045d, this.f9319f * d15) * d22);
            double d23 = this.f9320g;
            double pow = d21 * d23 * Math.pow(2.718281828459045d, d23 * d15);
            double d24 = this.f9319f;
            d13 = pow + (d22 * d24 * Math.pow(2.718281828459045d, d24 * d15));
        } else if (d17 == 1.0d) {
            double d25 = this.f9314a;
            double d26 = d12 + (d25 * d16);
            double d27 = d16 + (d26 * d15);
            d14 = Math.pow(2.718281828459045d, (-d25) * d15) * d27;
            double pow2 = d27 * Math.pow(2.718281828459045d, (-this.f9314a) * d15);
            double d28 = this.f9314a;
            d13 = (d26 * Math.pow(2.718281828459045d, (-d28) * d15)) + (pow2 * (-d28));
        } else {
            double d29 = 1.0d / this.f9321h;
            double d31 = this.f9314a;
            double d32 = d29 * ((d17 * d31 * d16) + d12);
            double pow3 = Math.pow(2.718281828459045d, (-d17) * d31 * d15) * ((Math.cos(this.f9321h * d15) * d16) + (Math.sin(this.f9321h * d15) * d32));
            double d33 = this.f9314a;
            double d34 = this.f9315b;
            double pow4 = Math.pow(2.718281828459045d, (-d34) * d33 * d15);
            double d35 = this.f9321h;
            double d36 = pow3;
            double sin = (-d35) * d16 * Math.sin(d35 * d15);
            double d37 = this.f9321h;
            d13 = ((-d33) * pow3 * d34) + (pow4 * (sin + (d32 * d37 * Math.cos(d37 * d15))));
            d14 = d36;
        }
        b.o oVar = this.f9323j;
        oVar.f9366a = (float) (d14 + this.f9322i);
        oVar.f9367b = (float) d13;
        return oVar;
    }

    public SpringForce(float f11) {
        this.f9322i = (double) f11;
    }
}
