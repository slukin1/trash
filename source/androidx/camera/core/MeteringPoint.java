package androidx.camera.core;

import android.util.Rational;

public class MeteringPoint {
    private float mNormalizedX;
    private float mNormalizedY;
    private float mSize;
    private Rational mSurfaceAspectRatio;

    public MeteringPoint(float f11, float f12, float f13, Rational rational) {
        this.mNormalizedX = f11;
        this.mNormalizedY = f12;
        this.mSize = f13;
        this.mSurfaceAspectRatio = rational;
    }

    public float getSize() {
        return this.mSize;
    }

    public Rational getSurfaceAspectRatio() {
        return this.mSurfaceAspectRatio;
    }

    public float getX() {
        return this.mNormalizedX;
    }

    public float getY() {
        return this.mNormalizedY;
    }
}
