package com.youth.banner.transformer;

import android.view.View;

public class DepthPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.75f;
    private float mMinScale = 0.75f;

    public DepthPageTransformer() {
    }

    public void transformPage(View view, float f11) {
        int width = view.getWidth();
        if (f11 < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f11 <= 0.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f11 <= 1.0f) {
            view.setVisibility(0);
            view.setAlpha(1.0f - f11);
            view.setTranslationX(((float) width) * (-f11));
            float f12 = this.mMinScale;
            float abs = f12 + ((1.0f - f12) * (1.0f - Math.abs(f11)));
            view.setScaleX(abs);
            view.setScaleY(abs);
            if (f11 == 1.0f) {
                view.setVisibility(4);
            }
        } else {
            view.setAlpha(0.0f);
        }
    }

    public DepthPageTransformer(float f11) {
        this.mMinScale = f11;
    }
}
