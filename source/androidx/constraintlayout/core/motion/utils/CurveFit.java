package androidx.constraintlayout.core.motion.utils;

public abstract class CurveFit {

    public static class a extends CurveFit {

        /* renamed from: a  reason: collision with root package name */
        public double f6844a;

        /* renamed from: b  reason: collision with root package name */
        public double[] f6845b;

        public a(double d11, double[] dArr) {
            this.f6844a = d11;
            this.f6845b = dArr;
        }

        public double c(double d11, int i11) {
            return this.f6845b[i11];
        }

        public void d(double d11, double[] dArr) {
            double[] dArr2 = this.f6845b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public void e(double d11, float[] fArr) {
            int i11 = 0;
            while (true) {
                double[] dArr = this.f6845b;
                if (i11 < dArr.length) {
                    fArr[i11] = (float) dArr[i11];
                    i11++;
                } else {
                    return;
                }
            }
        }

        public double f(double d11, int i11) {
            return 0.0d;
        }

        public void g(double d11, double[] dArr) {
            for (int i11 = 0; i11 < this.f6845b.length; i11++) {
                dArr[i11] = 0.0d;
            }
        }

        public double[] h() {
            return new double[]{this.f6844a};
        }
    }

    public static CurveFit a(int i11, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i11 = 2;
        }
        if (i11 == 0) {
            return new d(dArr, dArr2);
        }
        if (i11 != 2) {
            return new c(dArr, dArr2);
        }
        return new a(dArr[0], dArr2[0]);
    }

    public static CurveFit b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new a(iArr, dArr, dArr2);
    }

    public abstract double c(double d11, int i11);

    public abstract void d(double d11, double[] dArr);

    public abstract void e(double d11, float[] fArr);

    public abstract double f(double d11, int i11);

    public abstract void g(double d11, double[] dArr);

    public abstract double[] h();
}
