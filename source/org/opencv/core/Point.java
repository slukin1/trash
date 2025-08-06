package org.opencv.core;

import a.a;

public class Point {

    /* renamed from: x  reason: collision with root package name */
    public double f25587x;

    /* renamed from: y  reason: collision with root package name */
    public double f25588y;

    public Point(double d11, double d12) {
        this.f25587x = d11;
        this.f25588y = d12;
    }

    public double dot(Point point) {
        return (this.f25588y * point.f25588y) + (this.f25587x * point.f25587x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.f25587x == point.f25587x && this.f25588y == point.f25588y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f25587x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f25588y);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public boolean inside(Rect rect) {
        return rect.contains(this);
    }

    public void set(double[] dArr) {
        double d11 = 0.0d;
        if (dArr != null) {
            this.f25587x = dArr.length > 0 ? dArr[0] : 0.0d;
            if (dArr.length > 1) {
                d11 = dArr[1];
            }
            this.f25588y = d11;
            return;
        }
        this.f25587x = 0.0d;
        this.f25588y = 0.0d;
    }

    public String toString() {
        StringBuilder c11 = a.c("{");
        c11.append(this.f25587x);
        c11.append(", ");
        c11.append(this.f25588y);
        c11.append("}");
        return c11.toString();
    }

    public Point clone() {
        return new Point(this.f25587x, this.f25588y);
    }

    public Point() {
        this(0.0d, 0.0d);
    }

    public Point(double[] dArr) {
        this();
        set(dArr);
    }
}
