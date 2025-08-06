package org.opencv.core;

import a.a;

public class Point3 {

    /* renamed from: x  reason: collision with root package name */
    public double f25589x;

    /* renamed from: y  reason: collision with root package name */
    public double f25590y;

    /* renamed from: z  reason: collision with root package name */
    public double f25591z;

    public Point3(double d11, double d12, double d13) {
        this.f25589x = d11;
        this.f25590y = d12;
        this.f25591z = d13;
    }

    public Point3 cross(Point3 point3) {
        Point3 point32 = point3;
        double d11 = this.f25590y;
        double d12 = point32.f25591z;
        double d13 = this.f25591z;
        double d14 = point32.f25590y;
        double d15 = point32.f25589x;
        double d16 = (d11 * d12) - (d13 * d14);
        double d17 = this.f25589x;
        double d18 = (d17 * d14) - (d11 * d15);
        return new Point3(d16, (d13 * d15) - (d12 * d17), d18);
    }

    public double dot(Point3 point3) {
        return (this.f25591z * point3.f25591z) + (this.f25590y * point3.f25590y) + (this.f25589x * point3.f25589x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point3)) {
            return false;
        }
        Point3 point3 = (Point3) obj;
        if (this.f25589x == point3.f25589x && this.f25590y == point3.f25590y && this.f25591z == point3.f25591z) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f25589x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f25590y);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f25591z);
        return ((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3));
    }

    public void set(double[] dArr) {
        double d11 = 0.0d;
        if (dArr != null) {
            this.f25589x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f25590y = dArr.length > 1 ? dArr[1] : 0.0d;
            if (dArr.length > 2) {
                d11 = dArr[2];
            }
            this.f25591z = d11;
            return;
        }
        this.f25589x = 0.0d;
        this.f25590y = 0.0d;
        this.f25591z = 0.0d;
    }

    public String toString() {
        StringBuilder c11 = a.c("{");
        c11.append(this.f25589x);
        c11.append(", ");
        c11.append(this.f25590y);
        c11.append(", ");
        c11.append(this.f25591z);
        c11.append("}");
        return c11.toString();
    }

    public Point3 clone() {
        return new Point3(this.f25589x, this.f25590y, this.f25591z);
    }

    public Point3() {
        this(0.0d, 0.0d, 0.0d);
    }

    public Point3(Point point) {
        this.f25589x = point.f25587x;
        this.f25590y = point.f25588y;
        this.f25591z = 0.0d;
    }

    public Point3(double[] dArr) {
        this();
        set(dArr);
    }
}
