package org.opencv.core;

import a.a;
import java.util.Arrays;

public class Scalar {
    public double[] val;

    public Scalar(double d11, double d12, double d13, double d14) {
        this.val = new double[]{d11, d12, d13, d14};
    }

    public static Scalar all(double d11) {
        return new Scalar(d11, d11, d11, d11);
    }

    public Scalar conj() {
        double[] dArr = this.val;
        return new Scalar(dArr[0], -dArr[1], -dArr[2], -dArr[3]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Scalar) && Arrays.equals(this.val, ((Scalar) obj).val);
    }

    public int hashCode() {
        return Arrays.hashCode(this.val) + 31;
    }

    public boolean isReal() {
        double[] dArr = this.val;
        return dArr[1] == 0.0d && dArr[2] == 0.0d && dArr[3] == 0.0d;
    }

    public Scalar mul(Scalar scalar, double d11) {
        double[] dArr = this.val;
        double d12 = dArr[0];
        double[] dArr2 = scalar.val;
        return new Scalar(d12 * dArr2[0] * d11, dArr[1] * dArr2[1] * d11, dArr[2] * dArr2[2] * d11, dArr[3] * dArr2[3] * d11);
    }

    public void set(double[] dArr) {
        double d11 = 0.0d;
        if (dArr != null) {
            double[] dArr2 = this.val;
            dArr2[0] = dArr.length > 0 ? dArr[0] : 0.0d;
            dArr2[1] = dArr.length > 1 ? dArr[1] : 0.0d;
            dArr2[2] = dArr.length > 2 ? dArr[2] : 0.0d;
            if (dArr.length > 3) {
                d11 = dArr[3];
            }
            dArr2[3] = d11;
            return;
        }
        double[] dArr3 = this.val;
        dArr3[3] = 0.0d;
        dArr3[2] = 0.0d;
        dArr3[1] = 0.0d;
        dArr3[0] = 0.0d;
    }

    public String toString() {
        StringBuilder c11 = a.c("[");
        c11.append(this.val[0]);
        c11.append(", ");
        c11.append(this.val[1]);
        c11.append(", ");
        c11.append(this.val[2]);
        c11.append(", ");
        c11.append(this.val[3]);
        c11.append("]");
        return c11.toString();
    }

    public Scalar clone() {
        return new Scalar(this.val);
    }

    public Scalar mul(Scalar scalar) {
        return mul(scalar, 1.0d);
    }

    public Scalar(double d11, double d12, double d13) {
        this.val = new double[]{d11, d12, d13, 0.0d};
    }

    public Scalar(double d11, double d12) {
        this.val = new double[]{d11, d12, 0.0d, 0.0d};
    }

    public Scalar(double d11) {
        this.val = new double[]{d11, 0.0d, 0.0d, 0.0d};
    }

    public Scalar(double[] dArr) {
        if (dArr == null || dArr.length != 4) {
            this.val = new double[4];
            set(dArr);
            return;
        }
        this.val = (double[]) dArr.clone();
    }
}
