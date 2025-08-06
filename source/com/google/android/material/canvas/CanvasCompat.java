package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;

public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(Canvas canvas, RectF rectF, int i11) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(rectF, i11);
        }
        return canvas.saveLayerAlpha(rectF, i11, 31);
    }

    public static int saveLayerAlpha(Canvas canvas, float f11, float f12, float f13, float f14, int i11) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f11, f12, f13, f14, i11);
        }
        return canvas.saveLayerAlpha(f11, f12, f13, f14, i11, 31);
    }
}
