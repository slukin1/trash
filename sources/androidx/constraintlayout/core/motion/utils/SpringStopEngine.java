package androidx.constraintlayout.core.motion.utils;

public class SpringStopEngine implements g {

    /* renamed from: a  reason: collision with root package name */
    public double f6907a = 0.5d;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6908b = false;

    /* renamed from: c  reason: collision with root package name */
    public double f6909c;

    /* renamed from: d  reason: collision with root package name */
    public double f6910d;

    /* renamed from: e  reason: collision with root package name */
    public double f6911e;

    /* renamed from: f  reason: collision with root package name */
    public float f6912f;

    /* renamed from: g  reason: collision with root package name */
    public float f6913g;

    /* renamed from: h  reason: collision with root package name */
    public float f6914h;

    /* renamed from: i  reason: collision with root package name */
    public float f6915i;

    /* renamed from: j  reason: collision with root package name */
    public float f6916j;

    /* renamed from: k  reason: collision with root package name */
    public int f6917k = 0;

    public float a() {
        return 0.0f;
    }

    public boolean b() {
        double d11 = ((double) this.f6913g) - this.f6910d;
        double d12 = this.f6909c;
        double d13 = (double) this.f6914h;
        return Math.sqrt((((d13 * d13) * ((double) this.f6915i)) + ((d12 * d11) * d11)) / d12) <= ((double) this.f6916j);
    }

    public final void c(double d11) {
        double d12 = this.f6909c;
        double d13 = this.f6907a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d12 / ((double) this.f6915i)) * d11) * 4.0d)) + 1.0d);
        double d14 = d11 / ((double) sqrt);
        int i11 = 0;
        while (i11 < sqrt) {
            float f11 = this.f6913g;
            double d15 = this.f6910d;
            float f12 = this.f6914h;
            double d16 = d12;
            float f13 = this.f6915i;
            double d17 = d13;
            double d18 = ((double) f12) + ((((((-d12) * (((double) f11) - d15)) - (((double) f12) * d13)) / ((double) f13)) * d14) / 2.0d);
            double d19 = ((((-((((double) f11) + ((d14 * d18) / 2.0d)) - d15)) * d16) - (d18 * d17)) / ((double) f13)) * d14;
            float f14 = (float) (((double) f12) + d19);
            this.f6914h = f14;
            float f15 = (float) (((double) f11) + ((((double) f12) + (d19 / 2.0d)) * d14));
            this.f6913g = f15;
            int i12 = this.f6917k;
            if (i12 > 0) {
                if (f15 < 0.0f && (i12 & 1) == 1) {
                    this.f6913g = -f15;
                    this.f6914h = -f14;
                }
                float f16 = this.f6913g;
                if (f16 > 1.0f && (i12 & 2) == 2) {
                    this.f6913g = 2.0f - f16;
                    this.f6914h = -this.f6914h;
                }
            }
            i11++;
            d12 = d16;
            d13 = d17;
        }
    }

    public void d(float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i11) {
        this.f6910d = (double) f12;
        this.f6907a = (double) f16;
        this.f6908b = false;
        this.f6913g = f11;
        this.f6911e = (double) f13;
        this.f6909c = (double) f15;
        this.f6915i = f14;
        this.f6916j = f17;
        this.f6917k = i11;
        this.f6912f = 0.0f;
    }

    public float getInterpolation(float f11) {
        c((double) (f11 - this.f6912f));
        this.f6912f = f11;
        return this.f6913g;
    }
}
