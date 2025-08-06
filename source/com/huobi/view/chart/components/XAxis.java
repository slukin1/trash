package com.huobi.view.chart.components;

import com.huobi.view.chart.utils.Utils;

public class XAxis extends AxisBase {
    private boolean mAvoidFirstLastClipping = false;
    public int mLabelHeight = 1;
    public int mLabelRotatedHeight = 1;
    public int mLabelRotatedWidth = 1;
    public float mLabelRotationAngle = 0.0f;
    public int mLabelWidth = 1;
    private XAxisPosition mPosition = XAxisPosition.TOP;

    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.mYOffset = Utils.convertDpToPixel(4.0f);
    }

    public float getLabelRotationAngle() {
        return this.mLabelRotationAngle;
    }

    public XAxisPosition getPosition() {
        return this.mPosition;
    }

    public boolean isAvoidFirstLastClippingEnabled() {
        return this.mAvoidFirstLastClipping;
    }

    public void setAvoidFirstLastClipping(boolean z11) {
        this.mAvoidFirstLastClipping = z11;
    }

    public void setLabelRotationAngle(float f11) {
        this.mLabelRotationAngle = f11;
    }

    public void setPosition(XAxisPosition xAxisPosition) {
        this.mPosition = xAxisPosition;
    }
}
