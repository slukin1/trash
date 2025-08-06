package com.huobi.view.chart.matrix;

public final class Vector3 {
    public static final Vector3 UNIT_X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 UNIT_Z = new Vector3(0.0f, 0.0f, 1.0f);
    public static final Vector3 ZERO = new Vector3(0.0f, 0.0f, 0.0f);

    /* renamed from: x  reason: collision with root package name */
    public float f19011x;

    /* renamed from: y  reason: collision with root package name */
    public float f19012y;

    /* renamed from: z  reason: collision with root package name */
    public float f19013z;

    public Vector3() {
    }

    public final void add(Vector3 vector3) {
        this.f19011x += vector3.f19011x;
        this.f19012y += vector3.f19012y;
        this.f19013z += vector3.f19013z;
    }

    public final Vector3 cross(Vector3 vector3) {
        float f11 = this.f19012y;
        float f12 = vector3.f19013z;
        float f13 = this.f19013z;
        float f14 = vector3.f19012y;
        float f15 = (f11 * f12) - (f13 * f14);
        float f16 = vector3.f19011x;
        float f17 = this.f19011x;
        return new Vector3(f15, (f13 * f16) - (f12 * f17), (f17 * f14) - (f11 * f16));
    }

    public final float distance2(Vector3 vector3) {
        float f11 = this.f19011x - vector3.f19011x;
        float f12 = this.f19012y - vector3.f19012y;
        float f13 = this.f19013z - vector3.f19013z;
        return (f11 * f11) + (f12 * f12) + (f13 * f13);
    }

    public final void divide(float f11) {
        if (f11 != 0.0f) {
            this.f19011x /= f11;
            this.f19012y /= f11;
            this.f19013z /= f11;
        }
    }

    public final float dot(Vector3 vector3) {
        return (this.f19011x * vector3.f19011x) + (this.f19012y * vector3.f19012y) + (this.f19013z * vector3.f19013z);
    }

    public final float length() {
        return (float) Math.sqrt((double) length2());
    }

    public final float length2() {
        float f11 = this.f19011x;
        float f12 = this.f19012y;
        float f13 = (f11 * f11) + (f12 * f12);
        float f14 = this.f19013z;
        return f13 + (f14 * f14);
    }

    public final void multiply(float f11) {
        this.f19011x *= f11;
        this.f19012y *= f11;
        this.f19013z *= f11;
    }

    public final float normalize() {
        float length = length();
        if (length != 0.0f) {
            this.f19011x /= length;
            this.f19012y /= length;
            this.f19013z /= length;
        }
        return length;
    }

    public final boolean pointsInSameDirection(Vector3 vector3) {
        return dot(vector3) > 0.0f;
    }

    public final void set(Vector3 vector3) {
        this.f19011x = vector3.f19011x;
        this.f19012y = vector3.f19012y;
        this.f19013z = vector3.f19013z;
    }

    public final void subtract(Vector3 vector3) {
        this.f19011x -= vector3.f19011x;
        this.f19012y -= vector3.f19012y;
        this.f19013z -= vector3.f19013z;
    }

    public final void subtractMultiple(Vector3 vector3, float f11) {
        this.f19011x -= vector3.f19011x * f11;
        this.f19012y -= vector3.f19012y * f11;
        this.f19013z -= vector3.f19013z * f11;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public Vector3(float f11, float f12, float f13) {
        set(f11, f12, f13);
    }

    public final void add(float f11, float f12, float f13) {
        this.f19011x += f11;
        this.f19012y += f12;
        this.f19013z += f13;
    }

    public final void multiply(Vector3 vector3) {
        this.f19011x *= vector3.f19011x;
        this.f19012y *= vector3.f19012y;
        this.f19013z *= vector3.f19013z;
    }

    public final void set(float f11, float f12, float f13) {
        this.f19011x = f11;
        this.f19012y = f12;
        this.f19013z = f13;
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }
}
