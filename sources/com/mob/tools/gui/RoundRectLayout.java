package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RoundRectLayout extends RelativeLayout {
    private Path path;
    private float[] rect;

    public RoundRectLayout(Context context) {
        super(context);
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.rect != null) {
            if (this.path == null) {
                int width = getWidth();
                int height = getHeight();
                this.path = new Path();
                this.path.addRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), this.rect, Path.Direction.CW);
            }
            canvas.clipPath(this.path);
        }
        super.dispatchDraw(canvas);
    }

    public void setRound(float f11) {
        setRound(f11, f11, f11, f11);
    }

    public RoundRectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setRound(float f11, float f12, float f13, float f14) {
        this.rect = new float[]{f11, f11, f12, f12, f13, f13, f14, f14};
    }

    public RoundRectLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
