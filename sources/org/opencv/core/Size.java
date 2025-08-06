package org.opencv.core;

public class Size {
    public double height;
    public double width;

    public Size(double d11, double d12) {
        this.width = d11;
        this.height = d12;
    }

    public double area() {
        return this.width * this.height;
    }

    public boolean empty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.width == size.width && this.height == size.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public void set(double[] dArr) {
        double d11 = 0.0d;
        if (dArr != null) {
            this.width = dArr.length > 0 ? dArr[0] : 0.0d;
            if (dArr.length > 1) {
                d11 = dArr[1];
            }
            this.height = d11;
            return;
        }
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public String toString() {
        return ((int) this.width) + "x" + ((int) this.height);
    }

    public Size clone() {
        return new Size(this.width, this.height);
    }

    public Size() {
        this(0.0d, 0.0d);
    }

    public Size(Point point) {
        this.width = point.f25587x;
        this.height = point.f25588y;
    }

    public Size(double[] dArr) {
        set(dArr);
    }
}
