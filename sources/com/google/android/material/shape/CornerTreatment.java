package com.google.android.material.shape;

import android.graphics.RectF;

public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f11, float f12, ShapePath shapePath) {
    }

    public void getCornerPath(ShapePath shapePath, float f11, float f12, float f13) {
        getCornerPath(f11, f12, shapePath);
    }

    public void getCornerPath(ShapePath shapePath, float f11, float f12, RectF rectF, CornerSize cornerSize) {
        getCornerPath(shapePath, f11, f12, cornerSize.getCornerSize(rectF));
    }
}
