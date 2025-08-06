package s0;

import t0.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final float f16457a;

    /* renamed from: b  reason: collision with root package name */
    public final float f16458b;

    /* renamed from: c  reason: collision with root package name */
    public final float f16459c;

    /* renamed from: d  reason: collision with root package name */
    public final float f16460d;

    /* renamed from: e  reason: collision with root package name */
    public final float f16461e;

    /* renamed from: f  reason: collision with root package name */
    public final float f16462f;

    /* renamed from: g  reason: collision with root package name */
    public final float f16463g;

    /* renamed from: h  reason: collision with root package name */
    public final float f16464h;

    /* renamed from: i  reason: collision with root package name */
    public final float f16465i;

    public a(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.f16457a = f11;
        this.f16458b = f12;
        this.f16459c = f13;
        this.f16460d = f14;
        this.f16461e = f15;
        this.f16462f = f16;
        this.f16463g = f17;
        this.f16464h = f18;
        this.f16465i = f19;
    }

    public static a b(float f11, float f12, float f13) {
        float f14 = 1000.0f;
        float f15 = 0.0f;
        a aVar = null;
        float f16 = 100.0f;
        float f17 = 1000.0f;
        while (Math.abs(f15 - f16) > 0.01f) {
            float f18 = ((f16 - f15) / 2.0f) + f15;
            int p11 = e(f18, f12, f11).p();
            float b11 = b.b(p11);
            float abs = Math.abs(f13 - b11);
            if (abs < 0.2f) {
                a c11 = c(p11);
                float a11 = c11.a(e(c11.k(), c11.i(), f11));
                if (a11 <= 1.0f) {
                    aVar = c11;
                    f14 = abs;
                    f17 = a11;
                }
            }
            if (f14 == 0.0f && f17 == 0.0f) {
                break;
            } else if (b11 < f13) {
                f15 = f18;
            } else {
                f16 = f18;
            }
        }
        return aVar;
    }

    public static a c(int i11) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i11, j.f16476k, fArr, fArr2);
        return new a(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void d(int i11, j jVar, float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr2;
        b.f(i11, fArr3);
        float[][] fArr4 = b.f16466a;
        float f11 = (fArr3[0] * fArr4[0][0]) + (fArr3[1] * fArr4[0][1]) + (fArr3[2] * fArr4[0][2]);
        float f12 = (fArr3[0] * fArr4[1][0]) + (fArr3[1] * fArr4[1][1]) + (fArr3[2] * fArr4[1][2]);
        float f13 = jVar.i()[0] * f11;
        float f14 = jVar.i()[1] * f12;
        float f15 = jVar.i()[2] * ((fArr3[0] * fArr4[2][0]) + (fArr3[1] * fArr4[2][1]) + (fArr3[2] * fArr4[2][2]));
        float pow = (float) Math.pow(((double) (jVar.c() * Math.abs(f13))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (jVar.c() * Math.abs(f14))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (jVar.c() * Math.abs(f15))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f13) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f14) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f15) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d11 = (double) signum3;
        float f16 = ((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d11)) / 11.0f;
        float f17 = ((float) (((double) (signum + signum2)) - (d11 * 2.0d))) / 9.0f;
        float f18 = signum2 * 20.0f;
        float f19 = (((signum * 20.0f) + f18) + (21.0f * signum3)) / 20.0f;
        float f21 = (((signum * 40.0f) + f18) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f17, (double) f16)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f22 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((double) ((f21 * jVar.f()) / jVar.a()), (double) (jVar.b() * jVar.j()))) * 100.0f;
        float f23 = f19;
        float b11 = (4.0f / jVar.b()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (jVar.a() + 4.0f) * jVar.d();
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) jVar.e()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) (((double) atan2) < 20.14d ? 360.0f + atan2 : atan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * jVar.g()) * jVar.h()) * ((float) Math.sqrt((double) ((f16 * f16) + (f17 * f17))))) / (f23 + 0.305f)), 0.9d));
        float sqrt = ((float) Math.sqrt(((double) pow4) / 100.0d)) * pow5;
        float d12 = jVar.d() * sqrt;
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * jVar.b()) / (jVar.a() + 4.0f)))) * 50.0f;
        float f24 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((0.0228f * d12) + 1.0f))) * 43.85965f;
        double d13 = (double) f22;
        float cos = ((float) Math.cos(d13)) * log;
        float sin = log * ((float) Math.sin(d13));
        fArr3[0] = atan2;
        fArr3[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = b11;
            fArr[2] = d12;
            fArr[3] = sqrt2;
            fArr[4] = f24;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    public static a e(float f11, float f12, float f13) {
        return f(f11, f12, f13, j.f16476k);
    }

    public static a f(float f11, float f12, float f13, j jVar) {
        float f14 = f11;
        double d11 = ((double) f14) / 100.0d;
        float b11 = (4.0f / jVar.b()) * ((float) Math.sqrt(d11)) * (jVar.a() + 4.0f) * jVar.d();
        float d12 = f12 * jVar.d();
        float sqrt = ((float) Math.sqrt((double) (((f12 / ((float) Math.sqrt(d11))) * jVar.b()) / (jVar.a() + 4.0f)))) * 50.0f;
        float f15 = (1.7f * f14) / ((0.007f * f14) + 1.0f);
        float log = ((float) Math.log((((double) d12) * 0.0228d) + 1.0d)) * 43.85965f;
        double d13 = (double) ((3.1415927f * f13) / 180.0f);
        return new a(f13, f12, f14, b11, d12, sqrt, f15, log * ((float) Math.cos(d13)), log * ((float) Math.sin(d13)));
    }

    public static int m(float f11, float f12, float f13) {
        return n(f11, f12, f13, j.f16476k);
    }

    public static int n(float f11, float f12, float f13, j jVar) {
        float f14;
        if (((double) f12) < 1.0d || ((double) Math.round(f13)) <= 0.0d || ((double) Math.round(f13)) >= 100.0d) {
            return b.a(f13);
        }
        if (f11 < 0.0f) {
            f14 = 0.0f;
        } else {
            f14 = Math.min(360.0f, f11);
        }
        a aVar = null;
        boolean z11 = true;
        float f15 = 0.0f;
        float f16 = f12;
        while (Math.abs(f15 - f12) >= 0.4f) {
            a b11 = b(f14, f16, f13);
            if (z11) {
                if (b11 != null) {
                    return b11.o(jVar);
                }
                z11 = false;
            } else if (b11 == null) {
                f12 = f16;
            } else {
                f15 = f16;
                aVar = b11;
            }
            f16 = ((f12 - f15) / 2.0f) + f15;
        }
        if (aVar == null) {
            return b.a(f13);
        }
        return aVar.o(jVar);
    }

    public float a(a aVar) {
        float l11 = l() - aVar.l();
        float g11 = g() - aVar.g();
        float h11 = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((double) ((l11 * l11) + (g11 * g11) + (h11 * h11))), 0.63d) * 1.41d);
    }

    public float g() {
        return this.f16464h;
    }

    public float h() {
        return this.f16465i;
    }

    public float i() {
        return this.f16458b;
    }

    public float j() {
        return this.f16457a;
    }

    public float k() {
        return this.f16459c;
    }

    public float l() {
        return this.f16463g;
    }

    public int o(j jVar) {
        float pow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, (double) jVar.e()), 0.73d), 1.1111111111111112d);
        double j11 = (double) ((j() * 3.1415927f) / 180.0f);
        float a11 = jVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) jVar.b())) / ((double) jVar.j())));
        float cos = ((float) (Math.cos(2.0d + j11) + 3.8d)) * 0.25f * 3846.1538f * jVar.g() * jVar.h();
        float f11 = a11 / jVar.f();
        float sin = (float) Math.sin(j11);
        float cos2 = (float) Math.cos(j11);
        float f12 = (((0.305f + f11) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f13 = cos2 * f12;
        float f14 = f12 * sin;
        float f15 = f11 * 460.0f;
        float f16 = (((451.0f * f13) + f15) + (288.0f * f14)) / 1403.0f;
        float f17 = ((f15 - (891.0f * f13)) - (261.0f * f14)) / 1403.0f;
        float f18 = ((f15 - (f13 * 220.0f)) - (f14 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f16) * (100.0f / jVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16))))), 2.380952380952381d));
        float signum2 = Math.signum(f17) * (100.0f / jVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f17)) * 27.13d) / (400.0d - ((double) Math.abs(f17))))), 2.380952380952381d));
        float signum3 = Math.signum(f18) * (100.0f / jVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f18)) * 27.13d) / (400.0d - ((double) Math.abs(f18))))), 2.380952380952381d));
        float f19 = signum / jVar.i()[0];
        float f21 = signum2 / jVar.i()[1];
        float f22 = signum3 / jVar.i()[2];
        float[][] fArr = b.f16467b;
        return c.b((double) ((fArr[0][0] * f19) + (fArr[0][1] * f21) + (fArr[0][2] * f22)), (double) ((fArr[1][0] * f19) + (fArr[1][1] * f21) + (fArr[1][2] * f22)), (double) ((f19 * fArr[2][0]) + (f21 * fArr[2][1]) + (f22 * fArr[2][2])));
    }

    public int p() {
        return o(j.f16476k);
    }
}
