package com.huobi.view.roundview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

public class RoundConstraintLayout extends ConstraintLayout {
    private RoundViewDelegate delegate;

    public RoundConstraintLayout(Context context) {
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
        if (!this.delegate.isWidthHeightEqual() || getWidth() <= 0 || getHeight() <= 0) {
            super.onMeasure(i11, i12);
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), 1073741824);
        int minWidth = getMinWidth();
        int size = View.MeasureSpec.getSize(i11);
        if (minWidth > 0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(size, minWidth), Integer.MIN_VALUE), makeMeasureSpec);
        } else {
            super.onMeasure(makeMeasureSpec, makeMeasureSpec);
        }
    }

    public RoundConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundConstraintLayout(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public RoundConstraintLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.delegate = new RoundViewDelegate(this, context, attributeSet);
    }
}
