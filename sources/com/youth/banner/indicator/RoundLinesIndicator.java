package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RoundLinesIndicator extends BaseIndicator {
    public RoundLinesIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.config.getIndicatorSize() > 1) {
            this.mPaint.setColor(this.config.getNormalColor());
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) this.config.getHeight()), (float) this.config.getRadius(), (float) this.config.getRadius(), this.mPaint);
            this.mPaint.setColor(this.config.getSelectedColor());
            int currentPosition = this.config.getCurrentPosition() * this.config.getSelectedWidth();
            canvas.drawRoundRect(new RectF((float) currentPosition, 0.0f, (float) (currentPosition + this.config.getSelectedWidth()), (float) this.config.getHeight()), (float) this.config.getRadius(), (float) this.config.getRadius(), this.mPaint);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            setMeasuredDimension(this.config.getSelectedWidth() * indicatorSize, this.config.getHeight());
        }
    }

    public RoundLinesIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundLinesIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mPaint.setStyle(Paint.Style.FILL);
    }
}
