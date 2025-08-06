package s0;

public final class j {

    /* renamed from: k  reason: collision with root package name */
    public static final j f16476k = k(b.f16468c, (float) ((((double) b.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    public final float f16477a;

    /* renamed from: b  reason: collision with root package name */
    public final float f16478b;

    /* renamed from: c  reason: collision with root package name */
    public final float f16479c;

    /* renamed from: d  reason: collision with root package name */
    public final float f16480d;

    /* renamed from: e  reason: collision with root package name */
    public final float f16481e;

    /* renamed from: f  reason: collision with root package name */
    public final float f16482f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f16483g;

    /* renamed from: h  reason: collision with root package name */
    public final float f16484h;

    /* renamed from: i  reason: collision with root package name */
    public final float f16485i;

    /* renamed from: j  reason: collision with root package name */
    public final float f16486j;

    public j(float f11, float f12, float f13, float f14, float f15, float f16, float[] fArr, float f17, float f18, float f19) {
        this.f16482f = f11;
        this.f16477a = f12;
        this.f16478b = f13;
        this.f16479c = f14;
        this.f16480d = f15;
        this.f16481e = f16;
        this.f16483g = fArr;
        this.f16484h = f17;
        this.f16485i = f18;
        this.f16486j = f19;
    }

    public static j k(float[] fArr, float f11, float f12, float f13, boolean z11) {
        float f14;
        float f15 = f11;
        float[][] fArr2 = b.f16466a;
        float f16 = (fArr[0] * fArr2[0][0]) + (fArr[1] * fArr2[0][1]) + (fArr[2] * fArr2[0][2]);
        float f17 = (fArr[0] * fArr2[1][0]) + (fArr[1] * fArr2[1][1]) + (fArr[2] * fArr2[1][2]);
        float f18 = (fArr[0] * fArr2[2][0]) + (fArr[1] * fArr2[2][1]) + (fArr[2] * fArr2[2][2]);
        float f19 = (f13 / 10.0f) + 0.8f;
        float d11 = ((double) f19) >= 0.9d ? b.d(0.59f, 0.69f, (f19 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f19 - 0.8f) * 10.0f);
        if (z11) {
            f14 = 1.0f;
        } else {
            f14 = (1.0f - (((float) Math.exp((double) (((-f15) - 42.0f) / 92.0f))) * 0.2777778f)) * f19;
        }
        double d12 = (double) f14;
        if (d12 > 1.0d) {
            f14 = 1.0f;
        } else if (d12 < 0.0d) {
            f14 = 0.0f;
        }
        float[] fArr3 = {(((100.0f / f16) * f14) + 1.0f) - f14, (((100.0f / f17) * f14) + 1.0f) - f14, (((100.0f / f18) * f14) + 1.0f) - f14};
        float f21 = 1.0f / ((5.0f * f15) + 1.0f);
        float f22 = f21 * f21 * f21 * f21;
        float f23 = 1.0f - f22;
        float cbrt = (f22 * f15) + (0.1f * f23 * f23 * ((float) Math.cbrt(((double) f15) * 5.0d)));
        float h11 = b.h(f12) / fArr[1];
        double d13 = (double) h11;
        float sqrt = ((float) Math.sqrt(d13)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d13, 0.2d));
        float[] fArr4 = {(float) Math.pow(((double) ((fArr3[0] * cbrt) * f16)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr3[1] * cbrt) * f17)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr3[2] * cbrt) * f18)) / 100.0d, 0.42d)};
        float[] fArr5 = {(fArr4[0] * 400.0f) / (fArr4[0] + 27.13f), (fArr4[1] * 400.0f) / (fArr4[1] + 27.13f), (fArr4[2] * 400.0f) / (fArr4[2] + 27.13f)};
        return new j(h11, ((fArr5[0] * 2.0f) + fArr5[1] + (fArr5[2] * 0.05f)) * pow, pow, pow, d11, f19, fArr3, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    public float a() {
        return this.f16477a;
    }

    public float b() {
        return this.f16480d;
    }

    public float c() {
        return this.f16484h;
    }

    public float d() {
        return this.f16485i;
    }

    public float e() {
        return this.f16482f;
    }

    public float f() {
        return this.f16478b;
    }

    public float g() {
        return this.f16481e;
    }

    public float h() {
        return this.f16479c;
    }

    public float[] i() {
        return this.f16483g;
    }

    public float j() {
        return this.f16486j;
    }
}
