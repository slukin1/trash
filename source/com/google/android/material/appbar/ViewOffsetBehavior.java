package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int tempLeftRightOffset = 0;
    private int tempTopBottomOffset = 0;
    private ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
    }

    public int getLeftAndRightOffset() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.getLeftAndRightOffset();
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.getTopAndBottomOffset();
        }
        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        return viewOffsetHelper2 != null && viewOffsetHelper2.isHorizontalOffsetEnabled();
    }

    public boolean isVerticalOffsetEnabled() {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        return viewOffsetHelper2 != null && viewOffsetHelper2.isVerticalOffsetEnabled();
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, V v11, int i11) {
        coordinatorLayout.onLayoutChild(v11, i11);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v11, int i11) {
        layoutChild(coordinatorLayout, v11, i11);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new ViewOffsetHelper(v11);
        }
        this.viewOffsetHelper.onViewLayout();
        this.viewOffsetHelper.applyOffsets();
        int i12 = this.tempTopBottomOffset;
        if (i12 != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(i12);
            this.tempTopBottomOffset = 0;
        }
        int i13 = this.tempLeftRightOffset;
        if (i13 == 0) {
            return true;
        }
        this.viewOffsetHelper.setLeftAndRightOffset(i13);
        this.tempLeftRightOffset = 0;
        return true;
    }

    public void setHorizontalOffsetEnabled(boolean z11) {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            viewOffsetHelper2.setHorizontalOffsetEnabled(z11);
        }
    }

    public boolean setLeftAndRightOffset(int i11) {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.setLeftAndRightOffset(i11);
        }
        this.tempLeftRightOffset = i11;
        return false;
    }

    public boolean setTopAndBottomOffset(int i11) {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            return viewOffsetHelper2.setTopAndBottomOffset(i11);
        }
        this.tempTopBottomOffset = i11;
        return false;
    }

    public void setVerticalOffsetEnabled(boolean z11) {
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        if (viewOffsetHelper2 != null) {
            viewOffsetHelper2.setVerticalOffsetEnabled(z11);
        }
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
