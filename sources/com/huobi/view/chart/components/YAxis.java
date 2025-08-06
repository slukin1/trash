package com.huobi.view.chart.components;

import android.graphics.Paint;
import com.huobi.view.chart.utils.Utils;

public class YAxis extends AxisBase {
    private AxisDependency mAxisDependency;
    private boolean mDrawBottomYLabelEntry;
    private boolean mDrawTopYLabelEntry;
    public boolean mDrawZeroLine;
    public boolean mInverted;
    public float mMaxWidth;
    public float mMinWidth;
    private YAxisLabelPosition mPosition;
    public float mSpacePercentBottom;
    public float mSpacePercentTop;
    private boolean mUseAutoScaleRestrictionMax;
    private boolean mUseAutoScaleRestrictionMin;
    public int mZeroLineColor;
    public float mZeroLineWidth;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mMinWidth = 0.0f;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.mDrawBottomYLabelEntry = true;
        this.mDrawTopYLabelEntry = true;
        this.mUseAutoScaleRestrictionMin = false;
        this.mUseAutoScaleRestrictionMax = false;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mAxisDependency = AxisDependency.LEFT;
        this.mYOffset = 0.0f;
    }

    public void calculate(float f11, float f12) {
        if (Math.abs(f12 - f11) == 0.0f) {
            f12 += 1.0f;
            f11 -= 1.0f;
        }
        float abs = Math.abs(f12 - f11);
        this.mAxisMinimum = this.mCustomAxisMin ? this.mAxisMinimum : f11 - ((abs / 100.0f) * getSpaceBottom());
        float spaceTop = this.mCustomAxisMax ? this.mAxisMaximum : f12 + ((abs / 100.0f) * getSpaceTop());
        this.mAxisMaximum = spaceTop;
        this.mAxisRange = Math.abs(this.mAxisMinimum - spaceTop);
    }

    public AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public YAxisLabelPosition getLabelPosition() {
        return this.mPosition;
    }

    public float getMaxWidth() {
        return this.mMaxWidth;
    }

    public float getMinWidth() {
        return this.mMinWidth;
    }

    public float getRequiredHeightSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        return ((float) Utils.calcTextHeight(paint, getLongestLabel())) + (getYOffset() * 2.0f);
    }

    public float getRequiredWidthSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        float calcTextWidth = ((float) Utils.calcTextWidth(paint, getLongestLabel())) + (getXOffset() * 2.0f);
        float minWidth = getMinWidth();
        float maxWidth = getMaxWidth();
        if (minWidth > 0.0f) {
            minWidth = Utils.convertDpToPixel(minWidth);
        }
        if (maxWidth > 0.0f && maxWidth != Float.POSITIVE_INFINITY) {
            maxWidth = Utils.convertDpToPixel(maxWidth);
        }
        if (((double) maxWidth) <= 0.0d) {
            maxWidth = calcTextWidth;
        }
        return Math.max(minWidth, Math.min(calcTextWidth, maxWidth));
    }

    public float getSpaceBottom() {
        return this.mSpacePercentBottom;
    }

    public float getSpaceTop() {
        return this.mSpacePercentTop;
    }

    public int getZeroLineColor() {
        return this.mZeroLineColor;
    }

    public float getZeroLineWidth() {
        return this.mZeroLineWidth;
    }

    public boolean isDrawBottomYLabelEntryEnabled() {
        return this.mDrawBottomYLabelEntry;
    }

    public boolean isDrawTopYLabelEntryEnabled() {
        return this.mDrawTopYLabelEntry;
    }

    public boolean isDrawZeroLineEnabled() {
        return this.mDrawZeroLine;
    }

    public boolean isInverted() {
        return this.mInverted;
    }

    @Deprecated
    public boolean isUseAutoScaleMaxRestriction() {
        return this.mUseAutoScaleRestrictionMax;
    }

    @Deprecated
    public boolean isUseAutoScaleMinRestriction() {
        return this.mUseAutoScaleRestrictionMin;
    }

    public boolean needsOffset() {
        return isEnabled() && isDrawLabelsEnabled() && getLabelPosition() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public void setDrawTopYLabelEntry(boolean z11) {
        this.mDrawTopYLabelEntry = z11;
    }

    public void setDrawZeroLine(boolean z11) {
        this.mDrawZeroLine = z11;
    }

    public void setInverted(boolean z11) {
        this.mInverted = z11;
    }

    public void setMaxWidth(float f11) {
        this.mMaxWidth = f11;
    }

    public void setMinWidth(float f11) {
        this.mMinWidth = f11;
    }

    public void setPosition(YAxisLabelPosition yAxisLabelPosition) {
        this.mPosition = yAxisLabelPosition;
    }

    public void setSpaceBottom(float f11) {
        this.mSpacePercentBottom = f11;
    }

    public void setSpaceTop(float f11) {
        this.mSpacePercentTop = f11;
    }

    @Deprecated
    public void setStartAtZero(boolean z11) {
        if (z11) {
            setAxisMinimum(0.0f);
        } else {
            resetAxisMinimum();
        }
    }

    @Deprecated
    public void setUseAutoScaleMaxRestriction(boolean z11) {
        this.mUseAutoScaleRestrictionMax = z11;
    }

    @Deprecated
    public void setUseAutoScaleMinRestriction(boolean z11) {
        this.mUseAutoScaleRestrictionMin = z11;
    }

    public void setZeroLineColor(int i11) {
        this.mZeroLineColor = i11;
    }

    public void setZeroLineWidth(float f11) {
        this.mZeroLineWidth = Utils.convertDpToPixel(f11);
    }

    public YAxis(AxisDependency axisDependency) {
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mMinWidth = 0.0f;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.mDrawBottomYLabelEntry = true;
        this.mDrawTopYLabelEntry = true;
        this.mUseAutoScaleRestrictionMin = false;
        this.mUseAutoScaleRestrictionMax = false;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mAxisDependency = axisDependency;
        this.mYOffset = 0.0f;
    }
}
