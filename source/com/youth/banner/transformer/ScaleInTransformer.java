package com.youth.banner.transformer;

import android.view.View;

public class ScaleInTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinScale = DEFAULT_MIN_SCALE;

    public ScaleInTransformer() {
    }

    public void transformPage(View view, float f11) {
        int width = view.getWidth();
        view.setPivotY((float) (view.getHeight() / 2));
        view.setPivotX((float) (width / 2));
        if (f11 < -1.0f) {
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            view.setPivotX((float) width);
        } else if (f11 > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
        } else if (f11 < 0.0f) {
            float f12 = this.mMinScale;
            float f13 = ((f11 + 1.0f) * (1.0f - f12)) + f12;
            view.setScaleX(f13);
            view.setScaleY(f13);
            view.setPivotX(((float) width) * (((-f11) * 0.5f) + 0.5f));
        } else {
            float f14 = 1.0f - f11;
            float f15 = this.mMinScale;
            float f16 = ((1.0f - f15) * f14) + f15;
            view.setScaleX(f16);
            view.setScaleY(f16);
            view.setPivotX(((float) width) * f14 * 0.5f);
        }
    }

    public ScaleInTransformer(float f11) {
        this.mMinScale = f11;
    }
}
