package com.google.android.material.shape;

public class RoundedCornerTreatment extends CornerTreatment {
    public float radius = -1.0f;

    public RoundedCornerTreatment() {
    }

    public void getCornerPath(ShapePath shapePath, float f11, float f12, float f13) {
        shapePath.reset(0.0f, f13 * f12, 180.0f, 180.0f - f11);
        float f14 = f13 * 2.0f * f12;
        shapePath.addArc(0.0f, 0.0f, f14, f14, 180.0f, f11);
    }

    @Deprecated
    public RoundedCornerTreatment(float f11) {
        this.radius = f11;
    }
}
