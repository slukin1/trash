package com.huobi.view.chart.components;

import android.graphics.Typeface;
import com.huobi.view.chart.utils.Utils;
import com.huobi.view.roundimg.RoundedDrawable;

public abstract class ComponentBase {
    public boolean mEnabled = true;
    public int mTextColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
    public float mTextSize = Utils.convertDpToPixel(10.0f);
    public Typeface mTypeface = null;
    public float mXOffset = 5.0f;
    public float mYOffset = 5.0f;

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public float getXOffset() {
        return this.mXOffset;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z11) {
        this.mEnabled = z11;
    }

    public void setTextColor(int i11) {
        this.mTextColor = i11;
    }

    public void setTextSize(float f11) {
        if (f11 > 24.0f) {
            f11 = 24.0f;
        }
        if (f11 < 6.0f) {
            f11 = 6.0f;
        }
        this.mTextSize = Utils.convertDpToPixel(f11);
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
    }

    public void setXOffset(float f11) {
        this.mXOffset = Utils.convertDpToPixel(f11);
    }

    public void setYOffset(float f11) {
        this.mYOffset = Utils.convertDpToPixel(f11);
    }
}
