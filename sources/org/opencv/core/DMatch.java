package org.opencv.core;

import a.a;

public class DMatch {
    public float distance;
    public int imgIdx;
    public int queryIdx;
    public int trainIdx;

    public DMatch() {
        this(-1, -1, Float.MAX_VALUE);
    }

    public boolean lessThan(DMatch dMatch) {
        return this.distance < dMatch.distance;
    }

    public String toString() {
        StringBuilder c11 = a.c("DMatch [queryIdx=");
        c11.append(this.queryIdx);
        c11.append(", trainIdx=");
        c11.append(this.trainIdx);
        c11.append(", imgIdx=");
        c11.append(this.imgIdx);
        c11.append(", distance=");
        c11.append(this.distance);
        c11.append("]");
        return c11.toString();
    }

    public DMatch(int i11, int i12, float f11) {
        this.queryIdx = i11;
        this.trainIdx = i12;
        this.imgIdx = -1;
        this.distance = f11;
    }

    public DMatch(int i11, int i12, int i13, float f11) {
        this.queryIdx = i11;
        this.trainIdx = i12;
        this.imgIdx = i13;
        this.distance = f11;
    }
}
