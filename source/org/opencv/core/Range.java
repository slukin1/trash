package org.opencv.core;

import a.a;

public class Range {
    public int end;
    public int start;

    public Range(int i11, int i12) {
        this.start = i11;
        this.end = i12;
    }

    public static Range all() {
        return new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean empty() {
        return this.end <= this.start;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (this.start == range.start && this.end == range.end) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits((double) this.start);
        long doubleToLongBits2 = Double.doubleToLongBits((double) this.end);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public Range intersection(Range range) {
        Range range2 = new Range(Math.max(range.start, this.start), Math.min(range.end, this.end));
        range2.end = Math.max(range2.end, range2.start);
        return range2;
    }

    public void set(double[] dArr) {
        int i11 = 0;
        if (dArr != null) {
            this.start = dArr.length > 0 ? (int) dArr[0] : 0;
            if (dArr.length > 1) {
                i11 = (int) dArr[1];
            }
            this.end = i11;
            return;
        }
        this.start = 0;
        this.end = 0;
    }

    public Range shift(int i11) {
        return new Range(this.start + i11, this.end + i11);
    }

    public int size() {
        if (empty()) {
            return 0;
        }
        return this.end - this.start;
    }

    public String toString() {
        StringBuilder c11 = a.c("[");
        c11.append(this.start);
        c11.append(", ");
        c11.append(this.end);
        c11.append(")");
        return c11.toString();
    }

    public Range clone() {
        return new Range(this.start, this.end);
    }

    public Range() {
        this(0, 0);
    }

    public Range(double[] dArr) {
        set(dArr);
    }
}
