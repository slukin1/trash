package com.sumsub.sns.internal.camera.photo.presentation.document;

import android.graphics.Rect;
import android.graphics.RectF;

public final class c {
    public static final Rect a(Rect rect, float f11, float f12) {
        RectF rectF = new RectF(rect);
        return new Rect((int) (rectF.left * f11), (int) (rectF.top * f12), (int) (rectF.right * f11), (int) (rectF.bottom * f12));
    }
}
