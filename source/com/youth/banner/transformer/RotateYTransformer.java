package com.youth.banner.transformer;

import android.view.View;

public class RotateYTransformer extends BasePageTransformer {
    private static final float DEFAULT_MAX_ROTATE = 35.0f;
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    public RotateYTransformer() {
    }

    public void transformPage(View view, float f11) {
        view.setPivotY((float) (view.getHeight() / 2));
        if (f11 < -1.0f) {
            view.setRotationY(this.mMaxRotate * -1.0f);
            view.setPivotX((float) view.getWidth());
        } else if (f11 <= 1.0f) {
            view.setRotationY(this.mMaxRotate * f11);
            if (f11 < 0.0f) {
                view.setPivotX(((float) view.getWidth()) * (((-f11) * 0.5f) + 0.5f));
                view.setPivotX((float) view.getWidth());
                return;
            }
            view.setPivotX(((float) view.getWidth()) * 0.5f * (1.0f - f11));
            view.setPivotX(0.0f);
        } else {
            view.setRotationY(this.mMaxRotate * 1.0f);
            view.setPivotX(0.0f);
        }
    }

    public RotateYTransformer(float f11) {
        this.mMaxRotate = f11;
    }
}
