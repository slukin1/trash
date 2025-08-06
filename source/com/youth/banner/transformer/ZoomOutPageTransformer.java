package com.youth.banner.transformer;

import android.view.View;

public class ZoomOutPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinAlpha = 0.5f;
    private float mMinScale = DEFAULT_MIN_SCALE;

    public ZoomOutPageTransformer() {
    }

    public void transformPage(View view, float f11) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f11 < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f11 <= 1.0f) {
            float max = Math.max(this.mMinScale, 1.0f - Math.abs(f11));
            float f12 = 1.0f - max;
            float f13 = (((float) height) * f12) / 2.0f;
            float f14 = (((float) width) * f12) / 2.0f;
            if (f11 < 0.0f) {
                view.setTranslationX(f14 - (f13 / 2.0f));
            } else {
                view.setTranslationX((-f14) + (f13 / 2.0f));
            }
            view.setScaleX(max);
            view.setScaleY(max);
            float f15 = this.mMinAlpha;
            float f16 = this.mMinScale;
            view.setAlpha(f15 + (((max - f16) / (1.0f - f16)) * (1.0f - f15)));
        } else {
            view.setAlpha(0.0f);
        }
    }

    public ZoomOutPageTransformer(float f11, float f12) {
        this.mMinScale = f11;
        this.mMinAlpha = f12;
    }
}
