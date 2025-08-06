package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;

public class NullLayer extends BaseLayer {
    public NullLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i11) {
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z11) {
        super.getBounds(rectF, matrix, z11);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
