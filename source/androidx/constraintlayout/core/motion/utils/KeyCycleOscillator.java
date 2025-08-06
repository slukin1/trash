package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class KeyCycleOscillator {

    /* renamed from: a  reason: collision with root package name */
    public CurveFit f6856a;

    /* renamed from: b  reason: collision with root package name */
    public b f6857b;

    /* renamed from: c  reason: collision with root package name */
    public String f6858c;

    /* renamed from: d  reason: collision with root package name */
    public int f6859d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f6860e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f6861f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c> f6862g = new ArrayList<>();

    public class a implements Comparator<c> {
        public a() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return Integer.compare(cVar.f6880a, cVar2.f6880a);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f6864a;

        /* renamed from: b  reason: collision with root package name */
        public Oscillator f6865b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6866c = 0;

        /* renamed from: d  reason: collision with root package name */
        public final int f6867d = 1;

        /* renamed from: e  reason: collision with root package name */
        public final int f6868e = 2;

        /* renamed from: f  reason: collision with root package name */
        public float[] f6869f;

        /* renamed from: g  reason: collision with root package name */
        public double[] f6870g;

        /* renamed from: h  reason: collision with root package name */
        public float[] f6871h;

        /* renamed from: i  reason: collision with root package name */
        public float[] f6872i;

        /* renamed from: j  reason: collision with root package name */
        public float[] f6873j;

        /* renamed from: k  reason: collision with root package name */
        public float[] f6874k;

        /* renamed from: l  reason: collision with root package name */
        public int f6875l;

        /* renamed from: m  reason: collision with root package name */
        public CurveFit f6876m;

        /* renamed from: n  reason: collision with root package name */
        public double[] f6877n;

        /* renamed from: o  reason: collision with root package name */
        public double[] f6878o;

        /* renamed from: p  reason: collision with root package name */
        public float f6879p;

        public b(int i11, String str, int i12, int i13) {
            Oscillator oscillator = new Oscillator();
            this.f6865b = oscillator;
            this.f6875l = i11;
            this.f6864a = i12;
            oscillator.g(i11, str);
            this.f6869f = new float[i13];
            this.f6870g = new double[i13];
            this.f6871h = new float[i13];
            this.f6872i = new float[i13];
            this.f6873j = new float[i13];
            this.f6874k = new float[i13];
        }

        public double a(float f11) {
            CurveFit curveFit = this.f6876m;
            if (curveFit != null) {
                double d11 = (double) f11;
                curveFit.g(d11, this.f6878o);
                this.f6876m.d(d11, this.f6877n);
            } else {
                double[] dArr = this.f6878o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d12 = (double) f11;
            double e11 = this.f6865b.e(d12, this.f6877n[1]);
            double d13 = this.f6865b.d(d12, this.f6877n[1], this.f6878o[1]);
            double[] dArr2 = this.f6878o;
            return dArr2[0] + (e11 * dArr2[2]) + (d13 * this.f6877n[2]);
        }

        public double b(float f11) {
            CurveFit curveFit = this.f6876m;
            if (curveFit != null) {
                curveFit.d((double) f11, this.f6877n);
            } else {
                double[] dArr = this.f6877n;
                dArr[0] = (double) this.f6872i[0];
                dArr[1] = (double) this.f6873j[0];
                dArr[2] = (double) this.f6869f[0];
            }
            double[] dArr2 = this.f6877n;
            return dArr2[0] + (this.f6865b.e((double) f11, dArr2[1]) * this.f6877n[2]);
        }

        public void c(int i11, int i12, float f11, float f12, float f13, float f14) {
            this.f6870g[i11] = ((double) i12) / 100.0d;
            this.f6871h[i11] = f11;
            this.f6872i[i11] = f12;
            this.f6873j[i11] = f13;
            this.f6869f[i11] = f14;
        }

        public void d(float f11) {
            this.f6879p = f11;
            int length = this.f6870g.length;
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = length;
            double[][] dArr = (double[][]) Array.newInstance(double.class, iArr);
            float[] fArr = this.f6869f;
            this.f6877n = new double[(fArr.length + 2)];
            this.f6878o = new double[(fArr.length + 2)];
            if (this.f6870g[0] > 0.0d) {
                this.f6865b.a(0.0d, this.f6871h[0]);
            }
            double[] dArr2 = this.f6870g;
            int length2 = dArr2.length - 1;
            if (dArr2[length2] < 1.0d) {
                this.f6865b.a(1.0d, this.f6871h[length2]);
            }
            for (int i11 = 0; i11 < dArr.length; i11++) {
                dArr[i11][0] = (double) this.f6872i[i11];
                dArr[i11][1] = (double) this.f6873j[i11];
                dArr[i11][2] = (double) this.f6869f[i11];
                this.f6865b.a(this.f6870g[i11], this.f6871h[i11]);
            }
            this.f6865b.f();
            double[] dArr3 = this.f6870g;
            if (dArr3.length > 1) {
                this.f6876m = CurveFit.a(0, dArr3, dArr);
            } else {
                this.f6876m = null;
            }
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f6880a;

        /* renamed from: b  reason: collision with root package name */
        public float f6881b;

        /* renamed from: c  reason: collision with root package name */
        public float f6882c;

        /* renamed from: d  reason: collision with root package name */
        public float f6883d;

        /* renamed from: e  reason: collision with root package name */
        public float f6884e;

        public c(int i11, float f11, float f12, float f13, float f14) {
            this.f6880a = i11;
            this.f6881b = f14;
            this.f6882c = f12;
            this.f6883d = f11;
            this.f6884e = f13;
        }
    }

    public float a(float f11) {
        return (float) this.f6857b.b(f11);
    }

    public float b(float f11) {
        return (float) this.f6857b.a(f11);
    }

    public void c(Object obj) {
    }

    public void d(int i11, int i12, String str, int i13, float f11, float f12, float f13, float f14) {
        int i14 = i13;
        this.f6862g.add(new c(i11, f11, f12, f13, f14));
        if (i14 != -1) {
            this.f6861f = i14;
        }
        this.f6859d = i12;
        this.f6860e = str;
    }

    public void e(int i11, int i12, String str, int i13, float f11, float f12, float f13, float f14, Object obj) {
        int i14 = i13;
        this.f6862g.add(new c(i11, f11, f12, f13, f14));
        if (i14 != -1) {
            this.f6861f = i14;
        }
        this.f6859d = i12;
        c(obj);
        this.f6860e = str;
    }

    public void f(String str) {
        this.f6858c = str;
    }

    public void g(float f11) {
        int size = this.f6862g.size();
        if (size != 0) {
            Collections.sort(this.f6862g, new a());
            double[] dArr = new double[size];
            int[] iArr = new int[2];
            iArr[1] = 3;
            char c11 = 0;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
            this.f6857b = new b(this.f6859d, this.f6860e, this.f6861f, size);
            Iterator<c> it2 = this.f6862g.iterator();
            int i11 = 0;
            while (it2.hasNext()) {
                c next = it2.next();
                float f12 = next.f6883d;
                dArr[i11] = ((double) f12) * 0.01d;
                double[] dArr3 = dArr2[i11];
                float f13 = next.f6881b;
                dArr3[c11] = (double) f13;
                double[] dArr4 = dArr2[i11];
                float f14 = next.f6882c;
                dArr4[1] = (double) f14;
                double[] dArr5 = dArr2[i11];
                float f15 = next.f6884e;
                dArr5[2] = (double) f15;
                this.f6857b.c(i11, next.f6880a, f12, f14, f15, f13);
                i11++;
                c11 = 0;
            }
            this.f6857b.d(f11);
            this.f6856a = CurveFit.a(0, dArr, dArr2);
        }
    }

    public boolean h() {
        return this.f6861f == 1;
    }

    public String toString() {
        String str = this.f6858c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<c> it2 = this.f6862g.iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            str = str + "[" + next.f6880a + " , " + decimalFormat.format((double) next.f6881b) + "] ";
        }
        return str;
    }
}
