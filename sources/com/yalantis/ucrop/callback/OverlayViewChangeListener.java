package com.yalantis.ucrop.callback;

import android.graphics.RectF;

public interface OverlayViewChangeListener {
    void onCropRectUpdated(RectF rectF);

    void postTranslate(float f11, float f12);
}
