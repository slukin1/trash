package com.google.android.material.shape;

public class CutCornerTreatment extends CornerTreatment {
    public float size = -1.0f;

    public CutCornerTreatment() {
    }

    public void getCornerPath(ShapePath shapePath, float f11, float f12, float f13) {
        shapePath.reset(0.0f, f13 * f12, 180.0f, 180.0f - f11);
        double d11 = (double) f13;
        double d12 = (double) f12;
        shapePath.lineTo((float) (Math.sin(Math.toRadians((double) f11)) * d11 * d12), (float) (Math.sin(Math.toRadians((double) (90.0f - f11))) * d11 * d12));
    }

    @Deprecated
    public CutCornerTreatment(float f11) {
        this.size = f11;
    }
}
