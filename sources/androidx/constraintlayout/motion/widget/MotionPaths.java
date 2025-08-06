package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

class MotionPaths implements Comparable<MotionPaths> {

    /* renamed from: u  reason: collision with root package name */
    public static String[] f7613u = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: b  reason: collision with root package name */
    public Easing f7614b;

    /* renamed from: c  reason: collision with root package name */
    public int f7615c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f7616d;

    /* renamed from: e  reason: collision with root package name */
    public float f7617e;

    /* renamed from: f  reason: collision with root package name */
    public float f7618f;

    /* renamed from: g  reason: collision with root package name */
    public float f7619g;

    /* renamed from: h  reason: collision with root package name */
    public float f7620h;

    /* renamed from: i  reason: collision with root package name */
    public float f7621i;

    /* renamed from: j  reason: collision with root package name */
    public float f7622j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f7623k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public int f7624l;

    /* renamed from: m  reason: collision with root package name */
    public int f7625m;

    /* renamed from: n  reason: collision with root package name */
    public float f7626n;

    /* renamed from: o  reason: collision with root package name */
    public d f7627o;

    /* renamed from: p  reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f7628p;

    /* renamed from: q  reason: collision with root package name */
    public int f7629q;

    /* renamed from: r  reason: collision with root package name */
    public int f7630r;

    /* renamed from: s  reason: collision with root package name */
    public double[] f7631s;

    /* renamed from: t  reason: collision with root package name */
    public double[] f7632t;

    public MotionPaths() {
        int i11 = Key.f7390f;
        this.f7624l = i11;
        this.f7625m = i11;
        this.f7626n = Float.NaN;
        this.f7627o = null;
        this.f7628p = new LinkedHashMap<>();
        this.f7629q = 0;
        this.f7631s = new double[18];
        this.f7632t = new double[18];
    }

    public void a(ConstraintSet.Constraint constraint) {
        this.f7614b = Easing.c(constraint.f7999d.f8063d);
        ConstraintSet.Motion motion = constraint.f7999d;
        this.f7624l = motion.f8064e;
        this.f7625m = motion.f8061b;
        this.f7622j = motion.f8068i;
        this.f7615c = motion.f8065f;
        this.f7630r = motion.f8062c;
        this.f7623k = constraint.f7998c.f8078e;
        this.f7626n = constraint.f8000e.C;
        for (String next : constraint.f8002g.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.f8002g.get(next);
            if (constraintAttribute != null && constraintAttribute.g()) {
                this.f7628p.put(next, constraintAttribute);
            }
        }
    }

    /* renamed from: b */
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.f7617e, motionPaths.f7617e);
    }

    public final boolean c(float f11, float f12) {
        if (Float.isNaN(f11) || Float.isNaN(f12)) {
            if (Float.isNaN(f11) != Float.isNaN(f12)) {
                return true;
            }
            return false;
        } else if (Math.abs(f11 - f12) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    public void e(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z11) {
        boolean c11 = c(this.f7618f, motionPaths.f7618f);
        boolean c12 = c(this.f7619g, motionPaths.f7619g);
        zArr[0] = zArr[0] | c(this.f7617e, motionPaths.f7617e);
        boolean z12 = c11 | c12 | z11;
        zArr[1] = zArr[1] | z12;
        zArr[2] = z12 | zArr[2];
        zArr[3] = zArr[3] | c(this.f7620h, motionPaths.f7620h);
        zArr[4] = c(this.f7621i, motionPaths.f7621i) | zArr[4];
    }

    public void f(double[] dArr, int[] iArr) {
        float[] fArr = {this.f7617e, this.f7618f, this.f7619g, this.f7620h, this.f7621i, this.f7622j};
        int i11 = 0;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            if (iArr[i12] < 6) {
                dArr[i11] = (double) fArr[iArr[i12]];
                i11++;
            }
        }
    }

    public void g(double d11, int[] iArr, double[] dArr, float[] fArr, int i11) {
        int[] iArr2 = iArr;
        float f11 = this.f7618f;
        float f12 = this.f7619g;
        float f13 = this.f7620h;
        float f14 = this.f7621i;
        for (int i12 = 0; i12 < iArr2.length; i12++) {
            float f15 = (float) dArr[i12];
            int i13 = iArr2[i12];
            if (i13 == 1) {
                f11 = f15;
            } else if (i13 == 2) {
                f12 = f15;
            } else if (i13 == 3) {
                f13 = f15;
            } else if (i13 == 4) {
                f14 = f15;
            }
        }
        d dVar = this.f7627o;
        if (dVar != null) {
            float[] fArr2 = new float[2];
            dVar.i(d11, fArr2, new float[2]);
            float f16 = fArr2[0];
            float f17 = fArr2[1];
            double d12 = (double) f16;
            double d13 = (double) f11;
            double d14 = (double) f12;
            f11 = (float) ((d12 + (Math.sin(d14) * d13)) - ((double) (f13 / 2.0f)));
            f12 = (float) ((((double) f17) - (d13 * Math.cos(d14))) - ((double) (f14 / 2.0f)));
        }
        fArr[i11] = f11 + (f13 / 2.0f) + 0.0f;
        fArr[i11 + 1] = f12 + (f14 / 2.0f) + 0.0f;
    }

    public void h(double d11, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f11;
        int[] iArr2 = iArr;
        float f12 = this.f7618f;
        float f13 = this.f7619g;
        float f14 = this.f7620h;
        float f15 = this.f7621i;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            float f21 = (float) dArr[i11];
            float f22 = (float) dArr2[i11];
            int i12 = iArr2[i11];
            if (i12 == 1) {
                f12 = f21;
                f16 = f22;
            } else if (i12 == 2) {
                f13 = f21;
                f18 = f22;
            } else if (i12 == 3) {
                f14 = f21;
                f17 = f22;
            } else if (i12 == 4) {
                f15 = f21;
                f19 = f22;
            }
        }
        float f23 = 2.0f;
        float f24 = (f17 / 2.0f) + f16;
        float f25 = (f19 / 2.0f) + f18;
        d dVar = this.f7627o;
        if (dVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            dVar.i(d11, fArr3, fArr4);
            float f26 = fArr3[0];
            float f27 = fArr3[1];
            float f28 = fArr4[0];
            double d12 = (double) f12;
            float f29 = fArr4[1];
            double d13 = (double) f13;
            f11 = f14;
            double d14 = (double) f16;
            double d15 = (double) f18;
            float sin = (float) (((double) f28) + (Math.sin(d13) * d14) + (Math.cos(d13) * d15));
            f25 = (float) ((((double) f29) - (d14 * Math.cos(d13))) + (Math.sin(d13) * d15));
            f24 = sin;
            f12 = (float) ((((double) f26) + (Math.sin(d13) * d12)) - ((double) (f14 / 2.0f)));
            f13 = (float) ((((double) f27) - (d12 * Math.cos(d13))) - ((double) (f15 / 2.0f)));
            f23 = 2.0f;
        } else {
            f11 = f14;
        }
        fArr[0] = f12 + (f11 / f23) + 0.0f;
        fArr[1] = f13 + (f15 / f23) + 0.0f;
        fArr2[0] = f24;
        fArr2[1] = f25;
    }

    public int i(String str, double[] dArr, int i11) {
        ConstraintAttribute constraintAttribute = this.f7628p.get(str);
        int i12 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.h() == 1) {
            dArr[i11] = (double) constraintAttribute.e();
            return 1;
        }
        int h11 = constraintAttribute.h();
        float[] fArr = new float[h11];
        constraintAttribute.f(fArr);
        while (i12 < h11) {
            dArr[i11] = (double) fArr[i12];
            i12++;
            i11++;
        }
        return h11;
    }

    public int j(String str) {
        ConstraintAttribute constraintAttribute = this.f7628p.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.h();
    }

    public void k(int[] iArr, double[] dArr, float[] fArr, int i11) {
        float f11 = this.f7618f;
        float f12 = this.f7619g;
        float f13 = this.f7620h;
        float f14 = this.f7621i;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            float f15 = (float) dArr[i12];
            int i13 = iArr[i12];
            if (i13 == 1) {
                f11 = f15;
            } else if (i13 == 2) {
                f12 = f15;
            } else if (i13 == 3) {
                f13 = f15;
            } else if (i13 == 4) {
                f14 = f15;
            }
        }
        d dVar = this.f7627o;
        if (dVar != null) {
            float j11 = dVar.j();
            double d11 = (double) f11;
            double d12 = (double) f12;
            f12 = (float) ((((double) this.f7627o.k()) - (d11 * Math.cos(d12))) - ((double) (f14 / 2.0f)));
            f11 = (float) ((((double) j11) + (Math.sin(d12) * d11)) - ((double) (f13 / 2.0f)));
        }
        float f16 = f13 + f11;
        float f17 = f14 + f12;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i14 = i11 + 1;
        fArr[i11] = f11 + 0.0f;
        int i15 = i14 + 1;
        fArr[i14] = f12 + 0.0f;
        int i16 = i15 + 1;
        fArr[i15] = f16 + 0.0f;
        int i17 = i16 + 1;
        fArr[i16] = f12 + 0.0f;
        int i18 = i17 + 1;
        fArr[i17] = f16 + 0.0f;
        int i19 = i18 + 1;
        fArr[i18] = f17 + 0.0f;
        fArr[i19] = f11 + 0.0f;
        fArr[i19 + 1] = f17 + 0.0f;
    }

    public boolean l(String str) {
        return this.f7628p.containsKey(str);
    }

    public void m(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f11 = ((float) keyPosition2.f7391a) / 100.0f;
        this.f7616d = f11;
        this.f7615c = keyPosition2.f7439j;
        float f12 = Float.isNaN(keyPosition2.f7440k) ? f11 : keyPosition2.f7440k;
        float f13 = Float.isNaN(keyPosition2.f7441l) ? f11 : keyPosition2.f7441l;
        float f14 = motionPaths4.f7620h;
        float f15 = motionPaths3.f7620h;
        float f16 = motionPaths4.f7621i;
        float f17 = motionPaths3.f7621i;
        this.f7617e = this.f7616d;
        float f18 = motionPaths3.f7618f;
        float f19 = motionPaths3.f7619g;
        float f21 = (motionPaths4.f7618f + (f14 / 2.0f)) - ((f15 / 2.0f) + f18);
        float f22 = (motionPaths4.f7619g + (f16 / 2.0f)) - (f19 + (f17 / 2.0f));
        float f23 = (f14 - f15) * f12;
        float f24 = f23 / 2.0f;
        this.f7618f = (float) ((int) ((f18 + (f21 * f11)) - f24));
        float f25 = (f16 - f17) * f13;
        float f26 = f25 / 2.0f;
        this.f7619g = (float) ((int) ((f19 + (f22 * f11)) - f26));
        this.f7620h = (float) ((int) (f15 + f23));
        this.f7621i = (float) ((int) (f17 + f25));
        KeyPosition keyPosition3 = keyPosition;
        float f27 = Float.isNaN(keyPosition3.f7442m) ? f11 : keyPosition3.f7442m;
        float f28 = 0.0f;
        float f29 = Float.isNaN(keyPosition3.f7445p) ? 0.0f : keyPosition3.f7445p;
        if (!Float.isNaN(keyPosition3.f7443n)) {
            f11 = keyPosition3.f7443n;
        }
        if (!Float.isNaN(keyPosition3.f7444o)) {
            f28 = keyPosition3.f7444o;
        }
        this.f7629q = 0;
        MotionPaths motionPaths5 = motionPaths;
        this.f7618f = (float) ((int) (((motionPaths5.f7618f + (f27 * f21)) + (f28 * f22)) - f24));
        this.f7619g = (float) ((int) (((motionPaths5.f7619g + (f21 * f29)) + (f22 * f11)) - f26));
        this.f7614b = Easing.c(keyPosition3.f7437h);
        this.f7624l = keyPosition3.f7438i;
    }

    public void n(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f11 = ((float) keyPosition2.f7391a) / 100.0f;
        this.f7616d = f11;
        this.f7615c = keyPosition2.f7439j;
        float f12 = Float.isNaN(keyPosition2.f7440k) ? f11 : keyPosition2.f7440k;
        float f13 = Float.isNaN(keyPosition2.f7441l) ? f11 : keyPosition2.f7441l;
        float f14 = motionPaths4.f7620h - motionPaths3.f7620h;
        float f15 = motionPaths4.f7621i - motionPaths3.f7621i;
        this.f7617e = this.f7616d;
        if (!Float.isNaN(keyPosition2.f7442m)) {
            f11 = keyPosition2.f7442m;
        }
        float f16 = motionPaths3.f7618f;
        float f17 = motionPaths3.f7620h;
        float f18 = motionPaths3.f7619g;
        float f19 = motionPaths3.f7621i;
        float f21 = (motionPaths4.f7618f + (motionPaths4.f7620h / 2.0f)) - ((f17 / 2.0f) + f16);
        float f22 = (motionPaths4.f7619g + (motionPaths4.f7621i / 2.0f)) - ((f19 / 2.0f) + f18);
        float f23 = f21 * f11;
        float f24 = f14 * f12;
        float f25 = f24 / 2.0f;
        this.f7618f = (float) ((int) ((f16 + f23) - f25));
        float f26 = f11 * f22;
        float f27 = f15 * f13;
        float f28 = f27 / 2.0f;
        this.f7619g = (float) ((int) ((f18 + f26) - f28));
        this.f7620h = (float) ((int) (f17 + f24));
        this.f7621i = (float) ((int) (f19 + f27));
        KeyPosition keyPosition3 = keyPosition;
        float f29 = Float.isNaN(keyPosition3.f7443n) ? 0.0f : keyPosition3.f7443n;
        float f31 = (-f22) * f29;
        float f32 = f21 * f29;
        this.f7629q = 1;
        MotionPaths motionPaths5 = motionPaths;
        float f33 = (float) ((int) ((motionPaths5.f7618f + f23) - f25));
        this.f7618f = f33;
        float f34 = (float) ((int) ((motionPaths5.f7619g + f26) - f28));
        this.f7619g = f34;
        this.f7618f = f33 + f31;
        this.f7619g = f34 + f32;
        this.f7625m = this.f7625m;
        this.f7614b = Easing.c(keyPosition3.f7437h);
        this.f7624l = keyPosition3.f7438i;
    }

    public void o(int i11, int i12, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f11;
        float f12;
        float f13 = ((float) keyPosition.f7391a) / 100.0f;
        this.f7616d = f13;
        this.f7615c = keyPosition.f7439j;
        this.f7629q = keyPosition.f7446q;
        float f14 = Float.isNaN(keyPosition.f7440k) ? f13 : keyPosition.f7440k;
        float f15 = Float.isNaN(keyPosition.f7441l) ? f13 : keyPosition.f7441l;
        float f16 = motionPaths2.f7620h;
        float f17 = motionPaths.f7620h;
        float f18 = motionPaths2.f7621i;
        float f19 = motionPaths.f7621i;
        this.f7617e = this.f7616d;
        this.f7620h = (float) ((int) (f17 + ((f16 - f17) * f14)));
        this.f7621i = (float) ((int) (f19 + ((f18 - f19) * f15)));
        int i13 = keyPosition.f7446q;
        if (i13 == 1) {
            float f21 = Float.isNaN(keyPosition.f7442m) ? f13 : keyPosition.f7442m;
            float f22 = motionPaths2.f7618f;
            float f23 = motionPaths.f7618f;
            this.f7618f = (f21 * (f22 - f23)) + f23;
            if (!Float.isNaN(keyPosition.f7443n)) {
                f13 = keyPosition.f7443n;
            }
            float f24 = motionPaths2.f7619g;
            float f25 = motionPaths.f7619g;
            this.f7619g = (f13 * (f24 - f25)) + f25;
        } else if (i13 != 2) {
            float f26 = Float.isNaN(keyPosition.f7442m) ? f13 : keyPosition.f7442m;
            float f27 = motionPaths2.f7618f;
            float f28 = motionPaths.f7618f;
            this.f7618f = (f26 * (f27 - f28)) + f28;
            if (!Float.isNaN(keyPosition.f7443n)) {
                f13 = keyPosition.f7443n;
            }
            float f29 = motionPaths2.f7619g;
            float f31 = motionPaths.f7619g;
            this.f7619g = (f13 * (f29 - f31)) + f31;
        } else {
            if (Float.isNaN(keyPosition.f7442m)) {
                float f32 = motionPaths2.f7618f;
                float f33 = motionPaths.f7618f;
                f11 = ((f32 - f33) * f13) + f33;
            } else {
                f11 = Math.min(f15, f14) * keyPosition.f7442m;
            }
            this.f7618f = f11;
            if (Float.isNaN(keyPosition.f7443n)) {
                float f34 = motionPaths2.f7619g;
                float f35 = motionPaths.f7619g;
                f12 = (f13 * (f34 - f35)) + f35;
            } else {
                f12 = keyPosition.f7443n;
            }
            this.f7619g = f12;
        }
        this.f7625m = motionPaths.f7625m;
        this.f7614b = Easing.c(keyPosition.f7437h);
        this.f7624l = keyPosition.f7438i;
    }

    public void p(int i11, int i12, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        KeyPosition keyPosition2 = keyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f11 = ((float) keyPosition2.f7391a) / 100.0f;
        this.f7616d = f11;
        this.f7615c = keyPosition2.f7439j;
        float f12 = Float.isNaN(keyPosition2.f7440k) ? f11 : keyPosition2.f7440k;
        float f13 = Float.isNaN(keyPosition2.f7441l) ? f11 : keyPosition2.f7441l;
        float f14 = motionPaths4.f7620h;
        float f15 = motionPaths3.f7620h;
        float f16 = motionPaths4.f7621i;
        float f17 = motionPaths3.f7621i;
        this.f7617e = this.f7616d;
        float f18 = motionPaths3.f7618f;
        float f19 = motionPaths3.f7619g;
        float f21 = motionPaths4.f7618f + (f14 / 2.0f);
        float f22 = motionPaths4.f7619g + (f16 / 2.0f);
        float f23 = (f14 - f15) * f12;
        this.f7618f = (float) ((int) ((f18 + ((f21 - ((f15 / 2.0f) + f18)) * f11)) - (f23 / 2.0f)));
        float f24 = (f16 - f17) * f13;
        this.f7619g = (float) ((int) ((f19 + ((f22 - (f19 + (f17 / 2.0f))) * f11)) - (f24 / 2.0f)));
        this.f7620h = (float) ((int) (f15 + f23));
        this.f7621i = (float) ((int) (f17 + f24));
        this.f7629q = 2;
        KeyPosition keyPosition3 = keyPosition;
        if (!Float.isNaN(keyPosition3.f7442m)) {
            this.f7618f = (float) ((int) (keyPosition3.f7442m * ((float) ((int) (((float) i11) - this.f7620h)))));
        }
        if (!Float.isNaN(keyPosition3.f7443n)) {
            this.f7619g = (float) ((int) (keyPosition3.f7443n * ((float) ((int) (((float) i12) - this.f7621i)))));
        }
        this.f7625m = this.f7625m;
        this.f7614b = Easing.c(keyPosition3.f7437h);
        this.f7624l = keyPosition3.f7438i;
    }

    public void q(float f11, float f12, float f13, float f14) {
        this.f7618f = f11;
        this.f7619g = f12;
        this.f7620h = f13;
        this.f7621i = f14;
    }

    public void r(float f11, float f12, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            float f17 = (float) dArr[i11];
            double d11 = dArr2[i11];
            int i12 = iArr2[i11];
            if (i12 == 1) {
                f13 = f17;
            } else if (i12 == 2) {
                f15 = f17;
            } else if (i12 == 3) {
                f14 = f17;
            } else if (i12 == 4) {
                f16 = f17;
            }
        }
        float f18 = f13 - ((0.0f * f14) / 2.0f);
        float f19 = f15 - ((0.0f * f16) / 2.0f);
        fArr[0] = (f18 * (1.0f - f11)) + (((f14 * 1.0f) + f18) * f11) + 0.0f;
        fArr[1] = (f19 * (1.0f - f12)) + (((f16 * 1.0f) + f19) * f12) + 0.0f;
    }

    public void s(float f11, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f12;
        boolean z11;
        boolean z12;
        float f13;
        View view2 = view;
        int[] iArr2 = iArr;
        double[] dArr4 = dArr2;
        float f14 = this.f7618f;
        float f15 = this.f7619g;
        float f16 = this.f7620h;
        float f17 = this.f7621i;
        if (iArr2.length != 0 && this.f7631s.length <= iArr2[iArr2.length - 1]) {
            int i11 = iArr2[iArr2.length - 1] + 1;
            this.f7631s = new double[i11];
            this.f7632t = new double[i11];
        }
        Arrays.fill(this.f7631s, Double.NaN);
        for (int i12 = 0; i12 < iArr2.length; i12++) {
            this.f7631s[iArr2[i12]] = dArr[i12];
            this.f7632t[iArr2[i12]] = dArr4[i12];
        }
        float f18 = Float.NaN;
        int i13 = 0;
        float f19 = 0.0f;
        float f21 = 0.0f;
        float f22 = 0.0f;
        float f23 = 0.0f;
        while (true) {
            double[] dArr5 = this.f7631s;
            if (i13 >= dArr5.length) {
                break;
            }
            double d11 = 0.0d;
            if (!Double.isNaN(dArr5[i13]) || !(dArr3 == null || dArr3[i13] == 0.0d)) {
                if (dArr3 != null) {
                    d11 = dArr3[i13];
                }
                if (!Double.isNaN(this.f7631s[i13])) {
                    d11 = this.f7631s[i13] + d11;
                }
                f13 = f18;
                float f24 = (float) d11;
                float f25 = (float) this.f7632t[i13];
                if (i13 == 1) {
                    f18 = f13;
                    f19 = f25;
                    f14 = f24;
                } else if (i13 == 2) {
                    f18 = f13;
                    f21 = f25;
                    f15 = f24;
                } else if (i13 == 3) {
                    f18 = f13;
                    f22 = f25;
                    f16 = f24;
                } else if (i13 == 4) {
                    f18 = f13;
                    f23 = f25;
                    f17 = f24;
                } else if (i13 == 5) {
                    f18 = f24;
                }
                i13++;
                double[] dArr6 = dArr2;
            } else {
                f13 = f18;
            }
            f18 = f13;
            i13++;
            double[] dArr62 = dArr2;
        }
        float f26 = f18;
        d dVar = this.f7627o;
        if (dVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            dVar.i((double) f11, fArr, fArr2);
            float f27 = fArr[0];
            float f28 = fArr[1];
            float f29 = fArr2[0];
            float f31 = fArr2[1];
            double d12 = (double) f14;
            double d13 = (double) f15;
            double sin = ((double) f27) + (Math.sin(d13) * d12);
            f12 = f17;
            float f32 = (float) (sin - ((double) (f16 / 2.0f)));
            float cos = (float) ((((double) f28) - (Math.cos(d13) * d12)) - ((double) (f17 / 2.0f)));
            double d14 = (double) f19;
            double d15 = (double) f21;
            float sin2 = (float) (((double) f29) + (Math.sin(d13) * d14) + (Math.cos(d13) * d12 * d15));
            float f33 = f32;
            float cos2 = (float) ((((double) f31) - (d14 * Math.cos(d13))) + (d12 * Math.sin(d13) * d15));
            double[] dArr7 = dArr2;
            if (dArr7.length >= 2) {
                z12 = false;
                dArr7[0] = (double) sin2;
                z11 = true;
                dArr7[1] = (double) cos2;
            } else {
                z12 = false;
                z11 = true;
            }
            if (!Float.isNaN(f26)) {
                view2.setRotation((float) (((double) f26) + Math.toDegrees(Math.atan2((double) cos2, (double) sin2))));
            }
            f14 = f33;
            f15 = cos;
        } else {
            float f34 = f26;
            f12 = f17;
            z12 = false;
            z11 = true;
            if (!Float.isNaN(f34)) {
                view2.setRotation((float) (((double) 0.0f) + ((double) f34) + Math.toDegrees(Math.atan2((double) (f21 + (f23 / 2.0f)), (double) (f19 + (f22 / 2.0f))))));
            }
        }
        if (view2 instanceof b) {
            ((b) view2).a(f14, f15, f16 + f14, f15 + f12);
            return;
        }
        float f35 = f14 + 0.5f;
        int i14 = (int) f35;
        float f36 = f15 + 0.5f;
        int i15 = (int) f36;
        int i16 = (int) (f35 + f16);
        int i17 = (int) (f36 + f12);
        int i18 = i16 - i14;
        int i19 = i17 - i15;
        if (!(i18 == view.getMeasuredWidth() && i19 == view.getMeasuredHeight())) {
            z12 = z11;
        }
        if (z12) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
        }
        view2.layout(i14, i15, i16, i17);
    }

    public void t(d dVar, MotionPaths motionPaths) {
        double d11 = (double) (((this.f7618f + (this.f7620h / 2.0f)) - motionPaths.f7618f) - (motionPaths.f7620h / 2.0f));
        double d12 = (double) (((this.f7619g + (this.f7621i / 2.0f)) - motionPaths.f7619g) - (motionPaths.f7621i / 2.0f));
        this.f7627o = dVar;
        this.f7618f = (float) Math.hypot(d12, d11);
        if (Float.isNaN(this.f7626n)) {
            this.f7619g = (float) (Math.atan2(d12, d11) + 1.5707963267948966d);
        } else {
            this.f7619g = (float) Math.toRadians((double) this.f7626n);
        }
    }

    public MotionPaths(int i11, int i12, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i13 = Key.f7390f;
        this.f7624l = i13;
        this.f7625m = i13;
        this.f7626n = Float.NaN;
        this.f7627o = null;
        this.f7628p = new LinkedHashMap<>();
        this.f7629q = 0;
        this.f7631s = new double[18];
        this.f7632t = new double[18];
        if (motionPaths.f7625m != Key.f7390f) {
            o(i11, i12, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i14 = keyPosition.f7446q;
        if (i14 == 1) {
            n(keyPosition, motionPaths, motionPaths2);
        } else if (i14 != 2) {
            m(keyPosition, motionPaths, motionPaths2);
        } else {
            p(i11, i12, keyPosition, motionPaths, motionPaths2);
        }
    }
}
