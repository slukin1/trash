package com.airbnb.lottie.value;

public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY(float f11, float f12) {
        this.scaleX = f11;
        this.scaleY = f12;
    }

    public boolean equals(float f11, float f12) {
        return this.scaleX == f11 && this.scaleY == f12;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void set(float f11, float f12) {
        this.scaleX = f11;
        this.scaleY = f12;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
