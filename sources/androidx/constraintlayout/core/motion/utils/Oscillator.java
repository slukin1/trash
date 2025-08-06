package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class Oscillator {

    /* renamed from: a  reason: collision with root package name */
    public float[] f6894a = new float[0];

    /* renamed from: b  reason: collision with root package name */
    public double[] f6895b = new double[0];

    /* renamed from: c  reason: collision with root package name */
    public double[] f6896c;

    /* renamed from: d  reason: collision with root package name */
    public String f6897d;

    /* renamed from: e  reason: collision with root package name */
    public d f6898e;

    /* renamed from: f  reason: collision with root package name */
    public int f6899f;

    /* renamed from: g  reason: collision with root package name */
    public double f6900g = 6.283185307179586d;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6901h = false;

    public void a(double d11, float f11) {
        int length = this.f6894a.length + 1;
        int binarySearch = Arrays.binarySearch(this.f6895b, d11);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.f6895b = Arrays.copyOf(this.f6895b, length);
        this.f6894a = Arrays.copyOf(this.f6894a, length);
        this.f6896c = new double[length];
        double[] dArr = this.f6895b;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.f6895b[binarySearch] = d11;
        this.f6894a[binarySearch] = f11;
        this.f6901h = false;
    }

    public double b(double d11) {
        if (d11 <= 0.0d) {
            d11 = 1.0E-5d;
        } else if (d11 >= 1.0d) {
            d11 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.f6895b, d11);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i11 = (-binarySearch) - 1;
        float[] fArr = this.f6894a;
        int i12 = i11 - 1;
        double d12 = (double) (fArr[i11] - fArr[i12]);
        double[] dArr = this.f6895b;
        double d13 = d12 / (dArr[i11] - dArr[i12]);
        return (((double) fArr[i12]) - (d13 * dArr[i12])) + (d11 * d13);
    }

    public double c(double d11) {
        if (d11 < 0.0d) {
            d11 = 0.0d;
        } else if (d11 > 1.0d) {
            d11 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.f6895b, d11);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i11 = (-binarySearch) - 1;
        float[] fArr = this.f6894a;
        int i12 = i11 - 1;
        double d12 = (double) (fArr[i11] - fArr[i12]);
        double[] dArr = this.f6895b;
        double d13 = d12 / (dArr[i11] - dArr[i12]);
        return this.f6896c[i12] + ((((double) fArr[i12]) - (dArr[i12] * d13)) * (d11 - dArr[i12])) + ((d13 * ((d11 * d11) - (dArr[i12] * dArr[i12]))) / 2.0d);
    }

    public double d(double d11, double d12, double d13) {
        double c11 = d12 + c(d11);
        double b11 = b(d11) + d13;
        switch (this.f6899f) {
            case 1:
                return 0.0d;
            case 2:
                return b11 * 4.0d * Math.signum((((c11 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return b11 * 2.0d;
            case 4:
                return (-b11) * 2.0d;
            case 5:
                double d14 = this.f6900g;
                return (-d14) * b11 * Math.sin(d14 * c11);
            case 6:
                return b11 * 4.0d * ((((c11 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.f6898e.f(c11 % 1.0d, 0);
            default:
                double d15 = this.f6900g;
                return b11 * d15 * Math.cos(d15 * c11);
        }
    }

    public double e(double d11, double d12) {
        double abs;
        double c11 = c(d11) + d12;
        switch (this.f6899f) {
            case 1:
                return Math.signum(0.5d - (c11 % 1.0d));
            case 2:
                abs = Math.abs((((c11 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((c11 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((c11 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f6900g * (d12 + c11));
            case 6:
                double abs2 = 1.0d - Math.abs(((c11 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.f6898e.c(c11 % 1.0d, 0);
            default:
                return Math.sin(this.f6900g * c11);
        }
        return 1.0d - abs;
    }

    public void f() {
        int i11 = 0;
        double d11 = 0.0d;
        while (true) {
            float[] fArr = this.f6894a;
            if (i11 >= fArr.length) {
                break;
            }
            d11 += (double) fArr[i11];
            i11++;
        }
        double d12 = 0.0d;
        int i12 = 1;
        while (true) {
            float[] fArr2 = this.f6894a;
            if (i12 >= fArr2.length) {
                break;
            }
            int i13 = i12 - 1;
            double[] dArr = this.f6895b;
            d12 += (dArr[i12] - dArr[i13]) * ((double) ((fArr2[i13] + fArr2[i12]) / 2.0f));
            i12++;
        }
        int i14 = 0;
        while (true) {
            float[] fArr3 = this.f6894a;
            if (i14 >= fArr3.length) {
                break;
            }
            fArr3[i14] = (float) (((double) fArr3[i14]) * (d11 / d12));
            i14++;
        }
        this.f6896c[0] = 0.0d;
        int i15 = 1;
        while (true) {
            float[] fArr4 = this.f6894a;
            if (i15 < fArr4.length) {
                int i16 = i15 - 1;
                double[] dArr2 = this.f6895b;
                double d13 = dArr2[i15] - dArr2[i16];
                double[] dArr3 = this.f6896c;
                dArr3[i15] = dArr3[i16] + (d13 * ((double) ((fArr4[i16] + fArr4[i15]) / 2.0f)));
                i15++;
            } else {
                this.f6901h = true;
                return;
            }
        }
    }

    public void g(int i11, String str) {
        this.f6899f = i11;
        this.f6897d = str;
        if (str != null) {
            this.f6898e = d.i(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f6895b) + " period=" + Arrays.toString(this.f6894a);
    }
}
