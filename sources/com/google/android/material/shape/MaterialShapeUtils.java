package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.ViewUtils;

public class MaterialShapeUtils {
    private MaterialShapeUtils() {
    }

    public static CornerTreatment createCornerTreatment(int i11) {
        if (i11 == 0) {
            return new RoundedCornerTreatment();
        }
        if (i11 != 1) {
            return createDefaultCornerTreatment();
        }
        return new CutCornerTreatment();
    }

    public static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment();
    }

    public static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }

    public static void setElevation(View view, float f11) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).setElevation(f11);
        }
    }

    public static void setParentAbsoluteElevation(View view) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            setParentAbsoluteElevation(view, (MaterialShapeDrawable) background);
        }
    }

    public static void setParentAbsoluteElevation(View view, MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.isElevationOverlayEnabled()) {
            materialShapeDrawable.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(view));
        }
    }
}
