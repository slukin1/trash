package androidx.constraintlayout.core.motion.utils;

public class VelocityMatrix {

    /* renamed from: a  reason: collision with root package name */
    public float f6956a;

    /* renamed from: b  reason: collision with root package name */
    public float f6957b;

    /* renamed from: c  reason: collision with root package name */
    public float f6958c;

    /* renamed from: d  reason: collision with root package name */
    public float f6959d;

    /* renamed from: e  reason: collision with root package name */
    public float f6960e;

    /* renamed from: f  reason: collision with root package name */
    public float f6961f;

    public void a(float f11, float f12, int i11, int i12, float[] fArr) {
        int i13 = i11;
        float f13 = fArr[0];
        float f14 = fArr[1];
        float f15 = (f11 - 0.5f) * 2.0f;
        float f16 = (f12 - 0.5f) * 2.0f;
        float f17 = f13 + this.f6958c;
        float f18 = f14 + this.f6959d;
        float f19 = f17 + (this.f6956a * f15);
        float f21 = f18 + (this.f6957b * f16);
        float radians = (float) Math.toRadians((double) this.f6960e);
        double radians2 = (double) ((float) Math.toRadians((double) this.f6961f));
        double d11 = (double) (((float) i12) * f16);
        fArr[0] = f19 + (((float) ((((double) (((float) (-i13)) * f15)) * Math.sin(radians2)) - (Math.cos(radians2) * d11))) * radians);
        fArr[1] = f21 + (radians * ((float) ((((double) (((float) i13) * f15)) * Math.cos(radians2)) - (d11 * Math.sin(radians2)))));
    }

    public void b() {
        this.f6960e = 0.0f;
        this.f6959d = 0.0f;
        this.f6958c = 0.0f;
        this.f6957b = 0.0f;
        this.f6956a = 0.0f;
    }

    public void c(KeyCycleOscillator keyCycleOscillator, float f11) {
        if (keyCycleOscillator != null) {
            this.f6960e = keyCycleOscillator.b(f11);
        }
    }

    public void d(SplineSet splineSet, float f11) {
        if (splineSet != null) {
            this.f6960e = splineSet.b(f11);
            this.f6961f = splineSet.a(f11);
        }
    }

    public void e(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f11) {
        if (keyCycleOscillator != null) {
            this.f6956a = keyCycleOscillator.b(f11);
        }
        if (keyCycleOscillator2 != null) {
            this.f6957b = keyCycleOscillator2.b(f11);
        }
    }

    public void f(SplineSet splineSet, SplineSet splineSet2, float f11) {
        if (splineSet != null) {
            this.f6956a = splineSet.b(f11);
        }
        if (splineSet2 != null) {
            this.f6957b = splineSet2.b(f11);
        }
    }

    public void g(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f11) {
        if (keyCycleOscillator != null) {
            this.f6958c = keyCycleOscillator.b(f11);
        }
        if (keyCycleOscillator2 != null) {
            this.f6959d = keyCycleOscillator2.b(f11);
        }
    }

    public void h(SplineSet splineSet, SplineSet splineSet2, float f11) {
        if (splineSet != null) {
            this.f6958c = splineSet.b(f11);
        }
        if (splineSet2 != null) {
            this.f6959d = splineSet2.b(f11);
        }
    }
}
