package org.opencv.core;

import a.a;

public class Rect {
    public int height;
    public int width;

    /* renamed from: x  reason: collision with root package name */
    public int f25592x;

    /* renamed from: y  reason: collision with root package name */
    public int f25593y;

    public Rect(int i11, int i12, int i13, int i14) {
        this.f25592x = i11;
        this.f25593y = i12;
        this.width = i13;
        this.height = i14;
    }

    public double area() {
        return (double) (this.width * this.height);
    }

    public Point br() {
        return new Point((double) (this.f25592x + this.width), (double) (this.f25593y + this.height));
    }

    public boolean contains(Point point) {
        int i11 = this.f25592x;
        double d11 = point.f25587x;
        if (((double) i11) <= d11 && d11 < ((double) (i11 + this.width))) {
            int i12 = this.f25593y;
            double d12 = point.f25588y;
            return ((double) i12) <= d12 && d12 < ((double) (i12 + this.height));
        }
    }

    public boolean empty() {
        return this.width <= 0 || this.height <= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        if (this.f25592x == rect.f25592x && this.f25593y == rect.f25593y && this.width == rect.width && this.height == rect.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits((double) this.height);
        long doubleToLongBits2 = Double.doubleToLongBits((double) this.width);
        int i11 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits((double) this.f25592x);
        int i12 = (i11 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits((double) this.f25593y);
        return (i12 * 31) + ((int) ((doubleToLongBits4 >>> 32) ^ doubleToLongBits4));
    }

    public void set(double[] dArr) {
        int i11 = 0;
        if (dArr != null) {
            this.f25592x = dArr.length > 0 ? (int) dArr[0] : 0;
            this.f25593y = dArr.length > 1 ? (int) dArr[1] : 0;
            this.width = dArr.length > 2 ? (int) dArr[2] : 0;
            if (dArr.length > 3) {
                i11 = (int) dArr[3];
            }
            this.height = i11;
            return;
        }
        this.f25592x = 0;
        this.f25593y = 0;
        this.width = 0;
        this.height = 0;
    }

    public Size size() {
        return new Size((double) this.width, (double) this.height);
    }

    public Point tl() {
        return new Point((double) this.f25592x, (double) this.f25593y);
    }

    public String toString() {
        StringBuilder c11 = a.c("{");
        c11.append(this.f25592x);
        c11.append(", ");
        c11.append(this.f25593y);
        c11.append(", ");
        c11.append(this.width);
        c11.append("x");
        c11.append(this.height);
        c11.append("}");
        return c11.toString();
    }

    public Rect clone() {
        return new Rect(this.f25592x, this.f25593y, this.width, this.height);
    }

    public Rect() {
        this(0, 0, 0, 0);
    }

    public Rect(Point point, Point point2) {
        double d11 = point.f25587x;
        double d12 = point2.f25587x;
        int i11 = (int) (d11 < d12 ? d11 : d12);
        this.f25592x = i11;
        double d13 = point.f25588y;
        double d14 = point2.f25588y;
        int i12 = (int) (d13 < d14 ? d13 : d14);
        this.f25593y = i12;
        this.width = ((int) (d11 <= d12 ? d12 : d11)) - i11;
        this.height = ((int) (d13 <= d14 ? d14 : d13)) - i12;
    }

    public Rect(Point point, Size size) {
        this((int) point.f25587x, (int) point.f25588y, (int) size.width, (int) size.height);
    }

    public Rect(double[] dArr) {
        set(dArr);
    }
}
