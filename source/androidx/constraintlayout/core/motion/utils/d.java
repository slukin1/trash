package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class d extends CurveFit {

    /* renamed from: a  reason: collision with root package name */
    public double[] f6989a;

    /* renamed from: b  reason: collision with root package name */
    public double[][] f6990b;

    /* renamed from: c  reason: collision with root package name */
    public double[][] f6991c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6992d = true;

    /* renamed from: e  reason: collision with root package name */
    public double[] f6993e;

    public d(double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        double[][] dArr4 = dArr2;
        Class<double> cls = double.class;
        int length = dArr3.length;
        int length2 = dArr4[0].length;
        this.f6993e = new double[length2];
        int i11 = length - 1;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = i11;
        double[][] dArr5 = (double[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = length2;
        iArr2[0] = length;
        double[][] dArr6 = (double[][]) Array.newInstance(cls, iArr2);
        for (int i12 = 0; i12 < length2; i12++) {
            int i13 = 0;
            while (i13 < i11) {
                int i14 = i13 + 1;
                dArr5[i13][i12] = (dArr4[i14][i12] - dArr4[i13][i12]) / (dArr3[i14] - dArr3[i13]);
                if (i13 == 0) {
                    dArr6[i13][i12] = dArr5[i13][i12];
                } else {
                    dArr6[i13][i12] = (dArr5[i13 - 1][i12] + dArr5[i13][i12]) * 0.5d;
                }
                i13 = i14;
            }
            dArr6[i11][i12] = dArr5[length - 2][i12];
        }
        for (int i15 = 0; i15 < i11; i15++) {
            for (int i16 = 0; i16 < length2; i16++) {
                if (dArr5[i15][i16] == 0.0d) {
                    dArr6[i15][i16] = 0.0d;
                    dArr6[i15 + 1][i16] = 0.0d;
                } else {
                    double d11 = dArr6[i15][i16] / dArr5[i15][i16];
                    int i17 = i15 + 1;
                    double d12 = dArr6[i17][i16] / dArr5[i15][i16];
                    double hypot = Math.hypot(d11, d12);
                    if (hypot > 9.0d) {
                        double d13 = 3.0d / hypot;
                        dArr6[i15][i16] = d11 * d13 * dArr5[i15][i16];
                        dArr6[i17][i16] = d13 * d12 * dArr5[i15][i16];
                    }
                }
            }
        }
        this.f6989a = dArr3;
        this.f6990b = dArr4;
        this.f6991c = dArr6;
    }

    public static d i(String str) {
        double[] dArr = new double[(str.length() / 2)];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i11 = 0;
        while (indexOf2 != -1) {
            dArr[i11] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i11++;
        }
        dArr[i11] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        return j(Arrays.copyOf(dArr, i11 + 1));
    }

    public static d j(double[] dArr) {
        double[] dArr2 = dArr;
        int length = (dArr2.length * 3) - 2;
        int length2 = dArr2.length - 1;
        double d11 = 1.0d / ((double) length2);
        int[] iArr = new int[2];
        iArr[1] = 1;
        iArr[0] = length;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, iArr);
        double[] dArr4 = new double[length];
        for (int i11 = 0; i11 < dArr2.length; i11++) {
            double d12 = dArr2[i11];
            int i12 = i11 + length2;
            dArr3[i12][0] = d12;
            double d13 = ((double) i11) * d11;
            dArr4[i12] = d13;
            if (i11 > 0) {
                int i13 = (length2 * 2) + i11;
                dArr3[i13][0] = d12 + 1.0d;
                dArr4[i13] = d13 + 1.0d;
                int i14 = i11 - 1;
                dArr3[i14][0] = (d12 - 1.0d) - d11;
                dArr4[i14] = (d13 - 4.0d) - d11;
            }
        }
        return new d(dArr4, dArr3);
    }

    public static double k(double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = d12 * d12;
        double d18 = d12 * 6.0d;
        double d19 = 3.0d * d11;
        return (((((((((-6.0d * d17) * d14) + (d18 * d14)) + ((6.0d * d17) * d13)) - (d18 * d13)) + ((d19 * d16) * d17)) + ((d19 * d15) * d17)) - (((2.0d * d11) * d16) * d12)) - (((4.0d * d11) * d15) * d12)) + (d11 * d15);
    }

    public static double l(double d11, double d12, double d13, double d14, double d15, double d16) {
        double d17 = d12 * d12;
        double d18 = d17 * d12;
        double d19 = 3.0d * d17;
        double d21 = d11 * d16;
        double d22 = d11 * d15;
        return ((((((((((-2.0d * d18) * d14) + (d19 * d14)) + ((d18 * 2.0d) * d13)) - (d19 * d13)) + d13) + (d21 * d18)) + (d18 * d22)) - (d21 * d17)) - (((d11 * 2.0d) * d15) * d17)) + (d22 * d12);
    }

    public double c(double d11, int i11) {
        int i12 = i11;
        double[] dArr = this.f6989a;
        int length = dArr.length;
        int i13 = 0;
        if (this.f6992d) {
            if (d11 <= dArr[0]) {
                return this.f6990b[0][i12] + ((d11 - dArr[0]) * f(dArr[0], i12));
            }
            int i14 = length - 1;
            if (d11 >= dArr[i14]) {
                return this.f6990b[i14][i12] + ((d11 - dArr[i14]) * f(dArr[i14], i12));
            }
        } else if (d11 <= dArr[0]) {
            return this.f6990b[0][i12];
        } else {
            int i15 = length - 1;
            if (d11 >= dArr[i15]) {
                return this.f6990b[i15][i12];
            }
        }
        while (i13 < length - 1) {
            double[] dArr2 = this.f6989a;
            if (d11 == dArr2[i13]) {
                return this.f6990b[i13][i12];
            }
            int i16 = i13 + 1;
            if (d11 < dArr2[i16]) {
                double d12 = dArr2[i16] - dArr2[i13];
                double d13 = (d11 - dArr2[i13]) / d12;
                double[][] dArr3 = this.f6990b;
                double d14 = dArr3[i13][i12];
                double d15 = dArr3[i16][i12];
                double[][] dArr4 = this.f6991c;
                return l(d12, d13, d14, d15, dArr4[i13][i12], dArr4[i16][i12]);
            }
            i13 = i16;
        }
        return 0.0d;
    }

    public void d(double d11, double[] dArr) {
        double[] dArr2 = this.f6989a;
        int length = dArr2.length;
        int i11 = 0;
        int length2 = this.f6990b[0].length;
        if (this.f6992d) {
            if (d11 <= dArr2[0]) {
                g(dArr2[0], this.f6993e);
                for (int i12 = 0; i12 < length2; i12++) {
                    dArr[i12] = this.f6990b[0][i12] + ((d11 - this.f6989a[0]) * this.f6993e[i12]);
                }
                return;
            }
            int i13 = length - 1;
            if (d11 >= dArr2[i13]) {
                g(dArr2[i13], this.f6993e);
                while (i11 < length2) {
                    dArr[i11] = this.f6990b[i13][i11] + ((d11 - this.f6989a[i13]) * this.f6993e[i11]);
                    i11++;
                }
                return;
            }
        } else if (d11 <= dArr2[0]) {
            for (int i14 = 0; i14 < length2; i14++) {
                dArr[i14] = this.f6990b[0][i14];
            }
            return;
        } else {
            int i15 = length - 1;
            if (d11 >= dArr2[i15]) {
                while (i11 < length2) {
                    dArr[i11] = this.f6990b[i15][i11];
                    i11++;
                }
                return;
            }
        }
        int i16 = 0;
        while (i16 < length - 1) {
            if (d11 == this.f6989a[i16]) {
                for (int i17 = 0; i17 < length2; i17++) {
                    dArr[i17] = this.f6990b[i16][i17];
                }
            }
            double[] dArr3 = this.f6989a;
            int i18 = i16 + 1;
            if (d11 < dArr3[i18]) {
                double d12 = dArr3[i18] - dArr3[i16];
                double d13 = (d11 - dArr3[i16]) / d12;
                while (i11 < length2) {
                    double[][] dArr4 = this.f6990b;
                    double d14 = dArr4[i16][i11];
                    double d15 = dArr4[i18][i11];
                    double[][] dArr5 = this.f6991c;
                    dArr[i11] = l(d12, d13, d14, d15, dArr5[i16][i11], dArr5[i18][i11]);
                    i11++;
                }
                return;
            }
            i16 = i18;
        }
    }

    public void e(double d11, float[] fArr) {
        double[] dArr = this.f6989a;
        int length = dArr.length;
        int i11 = 0;
        int length2 = this.f6990b[0].length;
        if (this.f6992d) {
            if (d11 <= dArr[0]) {
                g(dArr[0], this.f6993e);
                for (int i12 = 0; i12 < length2; i12++) {
                    fArr[i12] = (float) (this.f6990b[0][i12] + ((d11 - this.f6989a[0]) * this.f6993e[i12]));
                }
                return;
            }
            int i13 = length - 1;
            if (d11 >= dArr[i13]) {
                g(dArr[i13], this.f6993e);
                while (i11 < length2) {
                    fArr[i11] = (float) (this.f6990b[i13][i11] + ((d11 - this.f6989a[i13]) * this.f6993e[i11]));
                    i11++;
                }
                return;
            }
        } else if (d11 <= dArr[0]) {
            for (int i14 = 0; i14 < length2; i14++) {
                fArr[i14] = (float) this.f6990b[0][i14];
            }
            return;
        } else {
            int i15 = length - 1;
            if (d11 >= dArr[i15]) {
                while (i11 < length2) {
                    fArr[i11] = (float) this.f6990b[i15][i11];
                    i11++;
                }
                return;
            }
        }
        int i16 = 0;
        while (i16 < length - 1) {
            if (d11 == this.f6989a[i16]) {
                for (int i17 = 0; i17 < length2; i17++) {
                    fArr[i17] = (float) this.f6990b[i16][i17];
                }
            }
            double[] dArr2 = this.f6989a;
            int i18 = i16 + 1;
            if (d11 < dArr2[i18]) {
                double d12 = dArr2[i18] - dArr2[i16];
                double d13 = (d11 - dArr2[i16]) / d12;
                while (i11 < length2) {
                    double[][] dArr3 = this.f6990b;
                    double d14 = dArr3[i16][i11];
                    double d15 = dArr3[i18][i11];
                    double[][] dArr4 = this.f6991c;
                    fArr[i11] = (float) l(d12, d13, d14, d15, dArr4[i16][i11], dArr4[i18][i11]);
                    i11++;
                }
                return;
            }
            i16 = i18;
        }
    }

    public double f(double d11, int i11) {
        double d12;
        double[] dArr = this.f6989a;
        int length = dArr.length;
        int i12 = 0;
        if (d11 < dArr[0]) {
            d12 = dArr[0];
        } else {
            int i13 = length - 1;
            d12 = d11 >= dArr[i13] ? dArr[i13] : d11;
        }
        while (i12 < length - 1) {
            double[] dArr2 = this.f6989a;
            int i14 = i12 + 1;
            if (d12 <= dArr2[i14]) {
                double d13 = dArr2[i14] - dArr2[i12];
                double[][] dArr3 = this.f6990b;
                double d14 = dArr3[i12][i11];
                double d15 = dArr3[i14][i11];
                double[][] dArr4 = this.f6991c;
                return k(d13, (d12 - dArr2[i12]) / d13, d14, d15, dArr4[i12][i11], dArr4[i14][i11]) / d13;
            }
            i12 = i14;
        }
        return 0.0d;
    }

    public void g(double d11, double[] dArr) {
        double d12;
        double[] dArr2 = this.f6989a;
        int length = dArr2.length;
        int length2 = this.f6990b[0].length;
        if (d11 <= dArr2[0]) {
            d12 = dArr2[0];
        } else {
            int i11 = length - 1;
            d12 = d11 >= dArr2[i11] ? dArr2[i11] : d11;
        }
        int i12 = 0;
        while (i12 < length - 1) {
            double[] dArr3 = this.f6989a;
            int i13 = i12 + 1;
            if (d12 <= dArr3[i13]) {
                double d13 = dArr3[i13] - dArr3[i12];
                double d14 = (d12 - dArr3[i12]) / d13;
                for (int i14 = 0; i14 < length2; i14++) {
                    double[][] dArr4 = this.f6990b;
                    double d15 = dArr4[i12][i14];
                    double d16 = dArr4[i13][i14];
                    double[][] dArr5 = this.f6991c;
                    dArr[i14] = k(d13, d14, d15, d16, dArr5[i12][i14], dArr5[i13][i14]) / d13;
                }
                return;
            }
            i12 = i13;
        }
    }

    public double[] h() {
        return this.f6989a;
    }
}
