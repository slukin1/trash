package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class CircleIndicator extends BaseIndicator {
    private int mNormalRadius;
    private int mSelectedRadius;
    private int maxRadius;

    public CircleIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            float f11 = 0.0f;
            int i11 = 0;
            while (i11 < indicatorSize) {
                this.mPaint.setColor(this.config.getCurrentPosition() == i11 ? this.config.getSelectedColor() : this.config.getNormalColor());
                int selectedWidth = this.config.getCurrentPosition() == i11 ? this.config.getSelectedWidth() : this.config.getNormalWidth();
                float f12 = (float) (this.config.getCurrentPosition() == i11 ? this.mSelectedRadius : this.mNormalRadius);
                canvas.drawCircle(f11 + f12, (float) this.maxRadius, f12, this.mPaint);
                f11 += (float) (selectedWidth + this.config.getIndicatorSpace());
                i11++;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            this.mNormalRadius = this.config.getNormalWidth() / 2;
            int selectedWidth = this.config.getSelectedWidth() / 2;
            this.mSelectedRadius = selectedWidth;
            this.maxRadius = Math.max(selectedWidth, this.mNormalRadius);
            int i13 = indicatorSize - 1;
            setMeasuredDimension((this.config.getIndicatorSpace() * i13) + this.config.getSelectedWidth() + (this.config.getNormalWidth() * i13), Math.max(this.config.getNormalWidth(), this.config.getSelectedWidth()));
        }
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mNormalRadius = this.config.getNormalWidth() / 2;
        this.mSelectedRadius = this.config.getSelectedWidth() / 2;
    }
}
