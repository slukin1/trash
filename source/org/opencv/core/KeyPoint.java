package org.opencv.core;

import a.a;

public class KeyPoint {
    public float angle;
    public int class_id;
    public int octave;

    /* renamed from: pt  reason: collision with root package name */
    public Point f25586pt;
    public float response;
    public float size;

    public KeyPoint(float f11, float f12, float f13, float f14, float f15, int i11, int i12) {
        this.f25586pt = new Point((double) f11, (double) f12);
        this.size = f13;
        this.angle = f14;
        this.response = f15;
        this.octave = i11;
        this.class_id = i12;
    }

    public String toString() {
        StringBuilder c11 = a.c("KeyPoint [pt=");
        c11.append(this.f25586pt);
        c11.append(", size=");
        c11.append(this.size);
        c11.append(", angle=");
        c11.append(this.angle);
        c11.append(", response=");
        c11.append(this.response);
        c11.append(", octave=");
        c11.append(this.octave);
        c11.append(", class_id=");
        c11.append(this.class_id);
        c11.append("]");
        return c11.toString();
    }

    public KeyPoint() {
        this(0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0, -1);
    }

    public KeyPoint(float f11, float f12, float f13, float f14, float f15, int i11) {
        this(f11, f12, f13, f14, f15, i11, -1);
    }

    public KeyPoint(float f11, float f12, float f13, float f14, float f15) {
        this(f11, f12, f13, f14, f15, 0, -1);
    }

    public KeyPoint(float f11, float f12, float f13, float f14) {
        this(f11, f12, f13, f14, 0.0f, 0, -1);
    }

    public KeyPoint(float f11, float f12, float f13) {
        this(f11, f12, f13, -1.0f, 0.0f, 0, -1);
    }
}
