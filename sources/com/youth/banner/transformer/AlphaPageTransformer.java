package com.youth.banner.transformer;

import android.view.View;

public class AlphaPageTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    private float mMinAlpha = 0.5f;

    public AlphaPageTransformer() {
    }

    public void transformPage(View view, float f11) {
        view.setScaleX(0.999f);
        if (f11 < -1.0f) {
            view.setAlpha(this.mMinAlpha);
        } else if (f11 > 1.0f) {
            view.setAlpha(this.mMinAlpha);
        } else if (f11 < 0.0f) {
            float f12 = this.mMinAlpha;
            view.setAlpha(f12 + ((1.0f - f12) * (f11 + 1.0f)));
        } else {
            float f13 = this.mMinAlpha;
            view.setAlpha(f13 + ((1.0f - f13) * (1.0f - f11)));
        }
    }

    public AlphaPageTransformer(float f11) {
        this.mMinAlpha = f11;
    }
}
