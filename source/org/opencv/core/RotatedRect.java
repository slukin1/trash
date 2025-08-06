package org.opencv.core;

import a.a;

public class RotatedRect {
    public double angle;
    public Point center;
    public Size size;

    public RotatedRect() {
        this.center = new Point();
        this.size = new Size();
        this.angle = 0.0d;
    }

    public Rect boundingRect() {
        Point[] pointArr = new Point[4];
        points(pointArr);
        Rect rect = new Rect((int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f25587x, pointArr[1].f25587x), pointArr[2].f25587x), pointArr[3].f25587x)), (int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f25588y, pointArr[1].f25588y), pointArr[2].f25588y), pointArr[3].f25588y)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f25587x, pointArr[1].f25587x), pointArr[2].f25587x), pointArr[3].f25587x)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f25588y, pointArr[1].f25588y), pointArr[2].f25588y), pointArr[3].f25588y)));
        rect.width -= rect.f25592x - 1;
        rect.height -= rect.f25593y - 1;
        return rect;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotatedRect)) {
            return false;
        }
        RotatedRect rotatedRect = (RotatedRect) obj;
        if (!this.center.equals(rotatedRect.center) || !this.size.equals(rotatedRect.size) || this.angle != rotatedRect.angle) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.center.f25587x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.center.f25588y);
        int i11 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.size.width);
        int i12 = (i11 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.size.height);
        long doubleToLongBits5 = Double.doubleToLongBits(this.angle);
        return (((i12 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) ((doubleToLongBits5 >>> 32) ^ doubleToLongBits5));
    }

    public void points(Point[] pointArr) {
        double d11 = (this.angle * 3.141592653589793d) / 180.0d;
        double cos = Math.cos(d11) * 0.5d;
        double sin = Math.sin(d11) * 0.5d;
        Point point = this.center;
        double d12 = point.f25587x;
        Size size2 = this.size;
        double d13 = size2.height;
        double d14 = size2.width;
        pointArr[0] = new Point((d12 - (sin * d13)) - (cos * d14), ((d13 * cos) + point.f25588y) - (d14 * sin));
        Point point2 = this.center;
        double d15 = point2.f25587x;
        Size size3 = this.size;
        double d16 = size3.height;
        double d17 = (sin * d16) + d15;
        double d18 = size3.width;
        pointArr[1] = new Point(d17 - (cos * d18), (point2.f25588y - (cos * d16)) - (sin * d18));
        Point point3 = this.center;
        pointArr[2] = new Point((point3.f25587x * 2.0d) - pointArr[0].f25587x, (point3.f25588y * 2.0d) - pointArr[0].f25588y);
        Point point4 = this.center;
        pointArr[3] = new Point((point4.f25587x * 2.0d) - pointArr[1].f25587x, (point4.f25588y * 2.0d) - pointArr[1].f25588y);
    }

    public void set(double[] dArr) {
        double d11 = 0.0d;
        if (dArr != null) {
            Point point = this.center;
            point.f25587x = dArr.length > 0 ? dArr[0] : 0.0d;
            point.f25588y = dArr.length > 1 ? dArr[1] : 0.0d;
            Size size2 = this.size;
            size2.width = dArr.length > 2 ? dArr[2] : 0.0d;
            size2.height = dArr.length > 3 ? dArr[3] : 0.0d;
            if (dArr.length > 4) {
                d11 = dArr[4];
            }
            this.angle = d11;
            return;
        }
        Point point2 = this.center;
        point2.f25587x = 0.0d;
        point2.f25588y = 0.0d;
        Size size3 = this.size;
        size3.width = 0.0d;
        size3.height = 0.0d;
        this.angle = 0.0d;
    }

    public String toString() {
        StringBuilder c11 = a.c("{ ");
        c11.append(this.center);
        c11.append(" ");
        c11.append(this.size);
        c11.append(" * ");
        c11.append(this.angle);
        c11.append(" }");
        return c11.toString();
    }

    public RotatedRect clone() {
        return new RotatedRect(this.center, this.size, this.angle);
    }

    public RotatedRect(Point point, Size size2, double d11) {
        this.center = point.clone();
        this.size = size2.clone();
        this.angle = d11;
    }

    public RotatedRect(double[] dArr) {
        this();
        set(dArr);
    }
}
