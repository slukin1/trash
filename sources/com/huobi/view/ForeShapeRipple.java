package com.huobi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.rodolfonavalon.shaperipplelibrary.ShapeRipple;

public class ForeShapeRipple extends ShapeRipple {
    private static final float DEFAULT_SIZE = 10.0f;
    private static final int HALF = 2;
    private static final int ZERO = 0;
    private Integer foreColor;
    private Paint framePaint;
    private float pointSize;

    public ForeShapeRipple(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.framePaint == null) {
            this.framePaint = new Paint();
        }
        this.framePaint.setAntiAlias(true);
        this.framePaint.setDither(true);
        this.framePaint.setStyle(Paint.Style.FILL);
        Paint paint = this.framePaint;
        Integer num = this.foreColor;
        paint.setColor(num == null ? getRippleFromColor() : num.intValue());
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.pointSize, this.framePaint);
    }

    public void setForeColor(int i11) {
        this.foreColor = Integer.valueOf(i11);
    }

    public void setForePointSize(float f11) {
        if (Float.compare(f11, 0.0f) <= 0) {
            f11 = 10.0f;
        }
        this.pointSize = f11;
    }

    public ForeShapeRipple(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ForeShapeRipple(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
