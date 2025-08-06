package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;

public final class MaterialArcMotion extends PathMotion {
    private static PointF getControlPoint(float f11, float f12, float f13, float f14) {
        if (f12 > f14) {
            return new PointF(f13, f12);
        }
        return new PointF(f11, f14);
    }

    public Path getPath(float f11, float f12, float f13, float f14) {
        Path path = new Path();
        path.moveTo(f11, f12);
        PointF controlPoint = getControlPoint(f11, f12, f13, f14);
        path.quadTo(controlPoint.x, controlPoint.y, f13, f14);
        return path;
    }
}
