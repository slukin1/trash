package com.youth.banner.transformer;

import android.view.View;

public class RotateUpPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    public RotateUpPageTransformer() {
    }

    public void transformPage(View view, float f11) {
        if (f11 < -1.0f) {
            view.setRotation(this.mMaxRotate);
            view.setPivotX((float) view.getWidth());
            view.setPivotY(0.0f);
        } else if (f11 > 1.0f) {
            view.setRotation(-this.mMaxRotate);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
        } else if (f11 < 0.0f) {
            view.setPivotX(((float) view.getWidth()) * (((-f11) * 0.5f) + 0.5f));
            view.setPivotY(0.0f);
            view.setRotation((-this.mMaxRotate) * f11);
        } else {
            view.setPivotX(((float) view.getWidth()) * 0.5f * (1.0f - f11));
            view.setPivotY(0.0f);
            view.setRotation((-this.mMaxRotate) * f11);
        }
    }

    public RotateUpPageTransformer(float f11) {
        this.mMaxRotate = f11;
    }
}
