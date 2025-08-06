package org.opencv.core;

import a.a;

public class Rect2d {
    public double height;
    public double width;

    /* renamed from: x  reason: collision with root package name */
    public double f25594x;

    /* renamed from: y  reason: collision with root package name */
    public double f25595y;

    public Rect2d(double d11, double d12, double d13, double d14) {
        this.f25594x = d11;
        this.f25595y = d12;
        this.width = d13;
        this.height = d14;
    }

    public double area() {
        return this.width * this.height;
    }

    public Point br() {
        return new Point(this.f25594x + this.width, this.f25595y + this.height);
    }

    public boolean contains(Point point) {
        double d11 = this.f25594x;
        double d12 = point.f25587x;
        if (d11 <= d12 && d12 < d11 + this.width) {
            double d13 = this.f25595y;
            double d14 = point.f25588y;
            return d13 <= d14 && d14 < d13 + this.height;
        }
    }

    public boolean empty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect2d)) {
            return false;
        }
        Rect2d rect2d = (Rect2d) obj;
        if (this.f25594x == rect2d.f25594x && this.f25595y == rect2d.f25595y && this.width == rect2d.width && this.height == rect2d.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f25594x);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f25595y);
        return ((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public void set(double[] dArr) {
        double d11 = 0.0d;
        if (dArr != null) {
            this.f25594x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f25595y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.width = dArr.length > 2 ? dArr[2] : 0.0d;
            if (dArr.length > 3) {
                d11 = dArr[3];
            }
            this.height = d11;
            return;
        }
        this.f25594x = 0.0d;
        this.f25595y = 0.0d;
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    public Point tl() {
        return new Point(this.f25594x, this.f25595y);
    }

    public String toString() {
        StringBuilder c11 = a.c("{");
        c11.append(this.f25594x);
        c11.append(", ");
        c11.append(this.f25595y);
        c11.append(", ");
        c11.append(this.width);
        c11.append("x");
        c11.append(this.height);
        c11.append("}");
        return c11.toString();
    }

    public Rect2d clone() {
        return new Rect2d(this.f25594x, this.f25595y, this.width, this.height);
    }

    public Rect2d() {
        this(0.0d, 0.0d, 0.0d, 0.0d);
    }

    public Rect2d(Point point, Point point2) {
        double d11 = point.f25587x;
        double d12 = point2.f25587x;
        double d13 = d11 < d12 ? d11 : d12;
        this.f25594x = d13;
        double d14 = point.f25588y;
        double d15 = point2.f25588y;
        double d16 = d14 < d15 ? d14 : d15;
        this.f25595y = d16;
        this.width = (d11 <= d12 ? d12 : d11) - d13;
        this.height = (d14 <= d15 ? d15 : d14) - d16;
    }

    public Rect2d(Point point, Size size) {
        this(point.f25587x, point.f25588y, size.width, size.height);
    }

    public Rect2d(double[] dArr) {
        set(dArr);
    }
}
