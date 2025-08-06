package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OrderAutoWrapViewGroup extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public int f79912b;

    /* renamed from: c  reason: collision with root package name */
    public int f79913c;

    public OrderAutoWrapViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final int a(int i11, View view) {
        if (view instanceof TextView) {
            ((TextView) view).setMaxWidth(i11);
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredWidth();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int paddingRight = (i13 - i11) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i15 = 1;
        int i16 = paddingRight;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i18 = paddingLeft + measuredWidth;
            if (i15 > 1) {
                i16 = paddingRight;
            }
            if (i18 > i16) {
                i18 = getPaddingLeft() + measuredWidth;
                i15++;
            }
            int paddingTop = (i15 * measuredHeight) + ((i15 - 1) * this.f79913c) + getPaddingTop();
            childAt.layout(i18 - measuredWidth, paddingTop - measuredHeight, i18, paddingTop);
            paddingLeft = i18 + this.f79912b;
        }
    }

    public void onMeasure(int i11, int i12) {
        int size = View.MeasureSpec.getSize(i11);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i13 = paddingLeft;
        int i14 = 0;
        int i15 = 1;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            int a11 = a(i13, childAt);
            int measuredHeight = childAt.getMeasuredHeight();
            int i18 = i14 + a11;
            if (i18 > i13) {
                i18 = getPaddingLeft() + a(paddingLeft, childAt);
                i15++;
                i13 = paddingLeft;
            }
            i14 = i18 + this.f79912b;
            i16 = getPaddingBottom() + (measuredHeight * i15) + ((i15 - 1) * this.f79913c) + getPaddingTop();
        }
        setMeasuredDimension(size, i16);
    }

    public void setSpacingHorizontal(int i11) {
        this.f79912b = i11;
    }

    public void setSpacingVertical(int i11) {
        this.f79913c = i11;
    }
}
