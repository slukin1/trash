package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;

public class MaxHeightScrollView extends NestedScrollView {

    /* renamed from: b  reason: collision with root package name */
    public int f71534b;

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(this.f71534b, Integer.MIN_VALUE));
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaxHeightScrollView);
        this.f71534b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaxHeightScrollView_max_height, (int) getResources().getDimension(R$dimen.dimen_300));
        obtainStyledAttributes.recycle();
    }
}
