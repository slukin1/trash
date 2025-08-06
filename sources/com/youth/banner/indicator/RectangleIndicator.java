package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RectangleIndicator extends BaseIndicator {
    public RectF rectF;

    public RectangleIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            int i11 = 0;
            float f11 = 0.0f;
            while (i11 < indicatorSize) {
                this.mPaint.setColor(this.config.getCurrentPosition() == i11 ? this.config.getSelectedColor() : this.config.getNormalColor());
                int selectedWidth = this.config.getCurrentPosition() == i11 ? this.config.getSelectedWidth() : this.config.getNormalWidth();
                this.rectF.set(f11, 0.0f, ((float) selectedWidth) + f11, (float) this.config.getHeight());
                f11 += (float) (selectedWidth + this.config.getIndicatorSpace());
                canvas.drawRoundRect(this.rectF, (float) this.config.getRadius(), (float) this.config.getRadius(), this.mPaint);
                i11++;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            int i13 = indicatorSize - 1;
            setMeasuredDimension((this.config.getIndicatorSpace() * i13) + (this.config.getNormalWidth() * i13) + this.config.getSelectedWidth(), this.config.getHeight());
        }
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RectangleIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.rectF = new RectF();
    }
}
