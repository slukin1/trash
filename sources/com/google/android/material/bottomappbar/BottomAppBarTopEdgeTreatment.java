package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f11, float f12, float f13) {
        this.fabMargin = f11;
        this.roundedCornerRadius = f12;
        setCradleVerticalOffset(f13);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    public void getEdgePath(float f11, float f12, float f13, ShapePath shapePath) {
        float f14;
        float f15;
        float f16 = f11;
        ShapePath shapePath2 = shapePath;
        float f17 = this.fabDiameter;
        if (f17 == 0.0f) {
            shapePath2.lineTo(f16, 0.0f);
            return;
        }
        float f18 = ((this.fabMargin * 2.0f) + f17) / 2.0f;
        float f19 = f13 * this.roundedCornerRadius;
        float f21 = f12 + this.horizontalOffset;
        float f22 = (this.cradleVerticalOffset * f13) + ((1.0f - f13) * f18);
        if (f22 / f18 >= 1.0f) {
            shapePath2.lineTo(f16, 0.0f);
            return;
        }
        float f23 = this.fabCornerSize;
        float f24 = f23 * f13;
        boolean z11 = f23 == -1.0f || Math.abs((f23 * 2.0f) - f17) < 0.1f;
        if (!z11) {
            f15 = ROUNDED_CORNER_FAB_OFFSET;
            f14 = 0.0f;
        } else {
            f14 = f22;
            f15 = 0.0f;
        }
        float f25 = f18 + f19;
        float f26 = f14 + f19;
        float sqrt = (float) Math.sqrt((double) ((f25 * f25) - (f26 * f26)));
        float f27 = f21 - sqrt;
        float f28 = f21 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f26)));
        float f29 = (90.0f - degrees) + f15;
        shapePath2.lineTo(f27, 0.0f);
        float f31 = f19 * 2.0f;
        float f32 = degrees;
        shapePath.addArc(f27 - f19, 0.0f, f27 + f19, f31, 270.0f, degrees);
        if (z11) {
            shapePath.addArc(f21 - f18, (-f18) - f14, f21 + f18, f18 - f14, 180.0f - f29, (f29 * 2.0f) - 180.0f);
        } else {
            float f33 = this.fabMargin;
            float f34 = f24 * 2.0f;
            float f35 = f21 - f18;
            shapePath.addArc(f35, -(f24 + f33), f35 + f33 + f34, f33 + f24, 180.0f - f29, ((f29 * 2.0f) - 180.0f) / 2.0f);
            float f36 = f21 + f18;
            float f37 = this.fabMargin;
            shapePath2.lineTo(f36 - ((f37 / 2.0f) + f24), f37 + f24);
            float f38 = this.fabMargin;
            shapePath.addArc(f36 - (f34 + f38), -(f24 + f38), f36, f38 + f24, 90.0f, f29 - 0.049804688f);
        }
        shapePath.addArc(f28 - f19, 0.0f, f28 + f19, f31, 270.0f - f32, f32);
        shapePath2.lineTo(f16, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(float f11) {
        if (f11 >= 0.0f) {
            this.cradleVerticalOffset = f11;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCornerSize(float f11) {
        this.fabCornerSize = f11;
    }

    public void setFabCradleMargin(float f11) {
        this.fabMargin = f11;
    }

    public void setFabCradleRoundedCornerRadius(float f11) {
        this.roundedCornerRadius = f11;
    }

    public void setFabDiameter(float f11) {
        this.fabDiameter = f11;
    }

    public void setHorizontalOffset(float f11) {
        this.horizontalOffset = f11;
    }
}
