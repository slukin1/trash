package com.huobi.view.roundview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class RoundRelativeLayout extends RelativeLayout {
    private RoundViewDelegate delegate;

    public RoundRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundViewDelegate getDelegate() {
        return this.delegate;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.delegate.isRadiusHalfHeight()) {
            this.delegate.setCornerRadius(getHeight() / 2);
        } else {
            this.delegate.setBgSelector();
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (!this.delegate.isWidthHeightEqual() || getWidth() <= 0 || getHeight() <= 0) {
            super.onMeasure(i11, i12);
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public void setFillBackgroundColor(int i11) {
        this.delegate.setBackgroundColor(i11);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.delegate = new RoundViewDelegate(this, context, attributeSet);
    }
}
