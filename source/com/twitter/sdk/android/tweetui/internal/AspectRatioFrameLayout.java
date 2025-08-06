package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.twitter.sdk.android.tweetui.R;

public class AspectRatioFrameLayout extends FrameLayout {
    public static final int ADJUST_DIMENSION_HEIGHT = 0;
    public static final int ADJUST_DIMENSION_WIDTH = 1;
    private static final int DEFAULT_ADJUST_DIMENSION = 0;
    private static final float DEFAULT_ASPECT_RATIO = 1.0f;
    public double aspectRatio;
    private int dimensionToAdjust;

    public AspectRatioFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initAttributes(int i11) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(i11, R.styleable.AspectRatioFrameLayout);
        try {
            this.aspectRatio = (double) obtainStyledAttributes.getFloat(R.styleable.AspectRatioFrameLayout_tw__frame_layout_aspect_ratio, 1.0f);
            this.dimensionToAdjust = obtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_tw__frame_layout_dimension_to_adjust, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.dimensionToAdjust == 0) {
            if (View.MeasureSpec.getMode(i11) == 1073741824) {
                i16 = View.MeasureSpec.getSize(i11);
            } else {
                super.onMeasure(i11, i12);
                i16 = getMeasuredWidth();
            }
            i14 = i16 - paddingLeft;
            i13 = (int) (((double) i14) / this.aspectRatio);
        } else {
            if (View.MeasureSpec.getMode(i12) == 1073741824) {
                i15 = View.MeasureSpec.getSize(i12);
            } else {
                super.onMeasure(i11, i12);
                i15 = getMeasuredHeight();
            }
            i13 = i15 - paddingBottom;
            i14 = (int) (((double) i13) * this.aspectRatio);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i14 + paddingLeft, 1073741824), View.MeasureSpec.makeMeasureSpec(i13 + paddingBottom, 1073741824));
    }

    public void setAspectRatio(double d11) {
        this.aspectRatio = d11;
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initAttributes(i11);
    }
}
