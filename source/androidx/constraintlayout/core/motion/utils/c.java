package androidx.constraintlayout.core.motion.utils;

public class c extends CurveFit {

    /* renamed from: a  reason: collision with root package name */
    public double[] f6984a;

    /* renamed from: b  reason: collision with root package name */
    public double[][] f6985b;

    /* renamed from: c  reason: collision with root package name */
    public double f6986c = Double.NaN;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6987d = true;

    /* renamed from: e  reason: collision with root package name */
    public double[] f6988e;

    public c(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f6988e = new double[length2];
        this.f6984a = dArr;
        this.f6985b = dArr2;
        if (length2 > 2) {
            int i11 = 0;
            double d11 = 0.0d;
            double d12 = 0.0d;
            while (i11 < dArr.length) {
                double d13 = dArr2[i11][0];
                double d14 = dArr2[i11][0];
                if (i11 > 0) {
                    Math.hypot(d13 - d11, d14 - d12);
                }
                i11++;
                d11 = d13;
                d12 = d14;
            }
            this.f6986c = 0.0d;
        }
    }

    public double c(double d11, int i11) {
        double[] dArr = this.f6984a;
        int length = dArr.length;
        int i12 = 0;
        if (this.f6987d) {
            if (d11 <= dArr[0]) {
                return this.f6985b[0][i11] + ((d11 - dArr[0]) * f(dArr[0], i11));
            }
            int i13 = length - 1;
            if (d11 >= dArr[i13]) {
                return this.f6985b[i13][i11] + ((d11 - dArr[i13]) * f(dArr[i13], i11));
            }
        } else if (d11 <= dArr[0]) {
            return this.f6985b[0][i11];
        } else {
            int i14 = length - 1;
            if (d11 >= dArr[i14]) {
                return this.f6985b[i14][i11];
            }
        }
        while (i12 < length - 1) {
            double[] dArr2 = this.f6984a;
            if (d11 == dArr2[i12]) {
                return this.f6985b[i12][i11];
            }
            int i15 = i12 + 1;
            if (d11 < dArr2[i15]) {
                double d12 = (d11 - dArr2[i12]) / (dArr2[i15] - dArr2[i12]);
                double[][] dArr3 = this.f6985b;
                return (dArr3[i12][i11] * (1.0d - d12)) + (dArr3[i15][i11] * d12);
            }
            i12 = i15;
        }
        return 0.0d;
    }

    public void d(double d11, double[] dArr) {
        double[] dArr2 = this.f6984a;
        int length = dArr2.length;
        int i11 = 0;
        int length2 = this.f6985b[0].length;
        if (this.f6987d) {
            if (d11 <= dArr2[0]) {
                g(dArr2[0], this.f6988e);
                for (int i12 = 0; i12 < length2; i12++) {
                    dArr[i12] = this.f6985b[0][i12] + ((d11 - this.f6984a[0]) * this.f6988e[i12]);
                }
                return;
            }
            int i13 = length - 1;
            if (d11 >= dArr2[i13]) {
                g(dArr2[i13], this.f6988e);
                while (i11 < length2) {
                    dArr[i11] = this.f6985b[i13][i11] + ((d11 - this.f6984a[i13]) * this.f6988e[i11]);
                    i11++;
                }
                return;
            }
        } else if (d11 <= dArr2[0]) {
            for (int i14 = 0; i14 < length2; i14++) {
                dArr[i14] = this.f6985b[0][i14];
            }
            return;
        } else {
            int i15 = length - 1;
            if (d11 >= dArr2[i15]) {
                while (i11 < length2) {
                    dArr[i11] = this.f6985b[i15][i11];
                    i11++;
                }
                return;
            }
        }
        int i16 = 0;
        while (i16 < length - 1) {
            if (d11 == this.f6984a[i16]) {
                for (int i17 = 0; i17 < length2; i17++) {
                    dArr[i17] = this.f6985b[i16][i17];
                }
            }
            double[] dArr3 = this.f6984a;
            int i18 = i16 + 1;
            if (d11 < dArr3[i18]) {
                double d12 = (d11 - dArr3[i16]) / (dArr3[i18] - dArr3[i16]);
                while (i11 < length2) {
                    double[][] dArr4 = this.f6985b;
                    dArr[i11] = (dArr4[i16][i11] * (1.0d - d12)) + (dArr4[i18][i11] * d12);
                    i11++;
                }
                return;
            }
            i16 = i18;
        }
    }

    public void e(double d11, float[] fArr) {
        double[] dArr = this.f6984a;
        int length = dArr.length;
        int i11 = 0;
        int length2 = this.f6985b[0].length;
        if (this.f6987d) {
            if (d11 <= dArr[0]) {
                g(dArr[0], this.f6988e);
                for (int i12 = 0; i12 < length2; i12++) {
                    fArr[i12] = (float) (this.f6985b[0][i12] + ((d11 - this.f6984a[0]) * this.f6988e[i12]));
                }
                return;
            }
            int i13 = length - 1;
            if (d11 >= dArr[i13]) {
                g(dArr[i13], this.f6988e);
                while (i11 < length2) {
                    fArr[i11] = (float) (this.f6985b[i13][i11] + ((d11 - this.f6984a[i13]) * this.f6988e[i11]));
                    i11++;
                }
                return;
            }
        } else if (d11 <= dArr[0]) {
            for (int i14 = 0; i14 < length2; i14++) {
                fArr[i14] = (float) this.f6985b[0][i14];
            }
            return;
        } else {
            int i15 = length - 1;
            if (d11 >= dArr[i15]) {
                while (i11 < length2) {
                    fArr[i11] = (float) this.f6985b[i15][i11];
                    i11++;
                }
                return;
            }
        }
        int i16 = 0;
        while (i16 < length - 1) {
            if (d11 == this.f6984a[i16]) {
                for (int i17 = 0; i17 < length2; i17++) {
                    fArr[i17] = (float) this.f6985b[i16][i17];
                }
            }
            double[] dArr2 = this.f6984a;
            int i18 = i16 + 1;
            if (d11 < dArr2[i18]) {
                double d12 = (d11 - dArr2[i16]) / (dArr2[i18] - dArr2[i16]);
                while (i11 < length2) {
                    double[][] dArr3 = this.f6985b;
                    fArr[i11] = (float) ((dArr3[i16][i11] * (1.0d - d12)) + (dArr3[i18][i11] * d12));
                    i11++;
                }
                return;
            }
            i16 = i18;
        }
    }

    public double f(double d11, int i11) {
        double[] dArr = this.f6984a;
        int length = dArr.length;
        int i12 = 0;
        if (d11 < dArr[0]) {
            d11 = dArr[0];
        } else {
            int i13 = length - 1;
            if (d11 >= dArr[i13]) {
                d11 = dArr[i13];
            }
        }
        while (i12 < length - 1) {
            double[] dArr2 = this.f6984a;
            int i14 = i12 + 1;
            if (d11 <= dArr2[i14]) {
                double d12 = dArr2[i14] - dArr2[i12];
                double d13 = dArr2[i12];
                double[][] dArr3 = this.f6985b;
                return (dArr3[i14][i11] - dArr3[i12][i11]) / d12;
            }
            i12 = i14;
        }
        return 0.0d;
    }

    public void g(double d11, double[] dArr) {
        double[] dArr2 = this.f6984a;
        int length = dArr2.length;
        int length2 = this.f6985b[0].length;
        if (d11 <= dArr2[0]) {
            d11 = dArr2[0];
        } else {
            int i11 = length - 1;
            if (d11 >= dArr2[i11]) {
                d11 = dArr2[i11];
            }
        }
        int i12 = 0;
        while (i12 < length - 1) {
            double[] dArr3 = this.f6984a;
            int i13 = i12 + 1;
            if (d11 <= dArr3[i13]) {
                double d12 = dArr3[i13] - dArr3[i12];
                double d13 = dArr3[i12];
                for (int i14 = 0; i14 < length2; i14++) {
                    double[][] dArr4 = this.f6985b;
                    dArr[i14] = (dArr4[i13][i14] - dArr4[i12][i14]) / d12;
                }
                return;
            }
            i12 = i13;
        }
    }

    public double[] h() {
        return this.f6984a;
    }
}
