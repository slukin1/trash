package com.tencent.qcloud.tuikit.timcommon.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qcloud.tuikit.timcommon.R;

public class MaxWidthFrameLayout extends FrameLayout {
    public int maxWidthPx;

    public MaxWidthFrameLayout(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.max_width_style);
        this.maxWidthPx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.max_width_style_maxWidth, 0);
        obtainStyledAttributes.recycle();
    }

    public void onMeasure(int i11, int i12) {
        int size = View.MeasureSpec.getSize(i11);
        int i13 = this.maxWidthPx;
        if (i13 > 0 && i13 < size) {
            i11 = View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
        }
        super.onMeasure(i11, i12);
    }

    public MaxWidthFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MaxWidthFrameLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
