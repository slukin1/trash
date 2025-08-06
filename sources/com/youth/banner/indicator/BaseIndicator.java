package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.youth.banner.config.IndicatorConfig;

public class BaseIndicator extends View implements Indicator {
    public IndicatorConfig config;
    public Paint mPaint;
    public float offset;

    public BaseIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public IndicatorConfig getIndicatorConfig() {
        return this.config;
    }

    public View getIndicatorView() {
        if (this.config.isAttachToBanner()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int gravity = this.config.getGravity();
            if (gravity == 0) {
                layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            } else if (gravity == 1) {
                layoutParams.gravity = 81;
            } else if (gravity == 2) {
                layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            }
            layoutParams.leftMargin = this.config.getMargins().leftMargin;
            layoutParams.rightMargin = this.config.getMargins().rightMargin;
            layoutParams.topMargin = this.config.getMargins().topMargin;
            layoutParams.bottomMargin = this.config.getMargins().bottomMargin;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    public void onPageChanged(int i11, int i12) {
        this.config.setIndicatorSize(i11);
        this.config.setCurrentPosition(i12);
        requestLayout();
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        this.offset = f11;
        invalidate();
    }

    public void onPageSelected(int i11) {
        this.config.setCurrentPosition(i11);
        invalidate();
    }

    public BaseIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.config = new IndicatorConfig();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(0);
        this.mPaint.setColor(this.config.getNormalColor());
    }
}
