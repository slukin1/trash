package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.h0;
import androidx.core.view.i;
import com.google.android.material.R;

public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int getMeasuredDimension(int i11, int i12, int i13) {
        if (i12 != Integer.MIN_VALUE) {
            return i12 != 1073741824 ? i13 : i11;
        }
        return Math.min(i13, i11);
    }

    private void loadFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        this.rowCount = 1;
        boolean z12 = h0.F(this) == 1;
        int paddingRight = z12 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z12 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i17 = (i13 - i11) - paddingLeft;
        int i18 = paddingRight;
        int i19 = paddingTop;
        for (int i21 = 0; i21 < getChildCount(); i21++) {
            View childAt = getChildAt(i21);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i15 = i.b(marginLayoutParams);
                    i16 = i.a(marginLayoutParams);
                } else {
                    i16 = 0;
                    i15 = 0;
                }
                int measuredWidth = i18 + i15 + childAt.getMeasuredWidth();
                if (!this.singleLine && measuredWidth > i17) {
                    i19 = this.lineSpacing + paddingTop;
                    this.rowCount++;
                    i18 = paddingRight;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
                int i22 = i18 + i15;
                int measuredWidth2 = childAt.getMeasuredWidth() + i22;
                int measuredHeight = childAt.getMeasuredHeight() + i19;
                if (z12) {
                    childAt.layout(i17 - measuredWidth2, i19, (i17 - i18) - i15, measuredHeight);
                } else {
                    childAt.layout(i22, i19, measuredWidth2, measuredHeight);
                }
                i18 += i15 + i16 + childAt.getMeasuredWidth() + this.itemSpacing;
                paddingTop = measuredHeight;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int size = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i12);
        int i16 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i16 - getPaddingRight();
        int i17 = paddingTop;
        int i18 = 0;
        for (int i19 = 0; i19 < getChildCount(); i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() == 8) {
                int i21 = i11;
                int i22 = i12;
            } else {
                measureChild(childAt, i11, i12);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i14 = marginLayoutParams.leftMargin + 0;
                    i13 = marginLayoutParams.rightMargin + 0;
                } else {
                    i14 = 0;
                    i13 = 0;
                }
                int i23 = paddingLeft;
                if (paddingLeft + i14 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                    i15 = i23;
                } else {
                    i15 = getPaddingLeft();
                    i17 = this.lineSpacing + paddingTop;
                }
                int measuredWidth = i15 + i14 + childAt.getMeasuredWidth();
                int measuredHeight = i17 + childAt.getMeasuredHeight();
                if (measuredWidth > i18) {
                    i18 = measuredWidth;
                }
                paddingLeft = i15 + i14 + i13 + childAt.getMeasuredWidth() + this.itemSpacing;
                if (i19 == getChildCount() - 1) {
                    i18 += i13;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i18 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i11) {
        this.itemSpacing = i11;
    }

    public void setLineSpacing(int i11) {
        this.lineSpacing = i11;
    }

    public void setSingleLine(boolean z11) {
        this.singleLine = z11;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }
}
