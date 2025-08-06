package com.google.android.material.shape;

public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f11, float f12, ShapePath shapePath) {
        getEdgePath(f11, f11 / 2.0f, f12, shapePath);
    }

    public void getEdgePath(float f11, float f12, float f13, ShapePath shapePath) {
        shapePath.lineTo(f11, 0.0f);
    }
}
