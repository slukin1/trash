package com.google.android.material.shape;

public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float offset;
    private final EdgeTreatment other;

    public OffsetEdgeTreatment(EdgeTreatment edgeTreatment, float f11) {
        this.other = edgeTreatment;
        this.offset = f11;
    }

    public boolean forceIntersection() {
        return this.other.forceIntersection();
    }

    public void getEdgePath(float f11, float f12, float f13, ShapePath shapePath) {
        this.other.getEdgePath(f11, f12 - this.offset, f13, shapePath);
    }
}
