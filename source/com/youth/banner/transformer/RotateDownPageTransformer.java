package com.youth.banner.transformer;

import android.view.View;

public class RotateDownPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    public RotateDownPageTransformer() {
    }

    public void transformPage(View view, float f11) {
        if (f11 < -1.0f) {
            view.setRotation(this.mMaxRotate * -1.0f);
            view.setPivotX((float) view.getWidth());
            view.setPivotY((float) view.getHeight());
        } else if (f11 > 1.0f) {
            view.setRotation(this.mMaxRotate);
            view.setPivotX((float) (view.getWidth() * 0));
            view.setPivotY((float) view.getHeight());
        } else if (f11 < 0.0f) {
            view.setPivotX(((float) view.getWidth()) * (((-f11) * 0.5f) + 0.5f));
            view.setPivotY((float) view.getHeight());
            view.setRotation(this.mMaxRotate * f11);
        } else {
            view.setPivotX(((float) view.getWidth()) * 0.5f * (1.0f - f11));
            view.setPivotY((float) view.getHeight());
            view.setRotation(this.mMaxRotate * f11);
        }
    }

    public RotateDownPageTransformer(float f11) {
        this.mMaxRotate = f11;
    }
}
