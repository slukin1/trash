package com.huobi.view.collapsingtoolbarlayout;

import android.view.View;
import androidx.core.view.h0;

class ViewOffsetHelper {
    private int mLayoutLeft;
    private int mLayoutTop;
    private int mOffsetLeft;
    private int mOffsetTop;
    private final View mView;

    public ViewOffsetHelper(View view) {
        this.mView = view;
    }

    private void updateOffsets() {
        View view = this.mView;
        h0.h0(view, this.mOffsetTop - (view.getTop() - this.mLayoutTop));
        View view2 = this.mView;
        h0.g0(view2, this.mOffsetLeft - (view2.getLeft() - this.mLayoutLeft));
    }

    public int getLayoutLeft() {
        return this.mLayoutLeft;
    }

    public int getLayoutTop() {
        return this.mLayoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.mOffsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.mOffsetTop;
    }

    public void onViewLayout() {
        this.mLayoutTop = this.mView.getTop();
        this.mLayoutLeft = this.mView.getLeft();
        updateOffsets();
    }

    public boolean setLeftAndRightOffset(int i11) {
        if (this.mOffsetLeft == i11) {
            return false;
        }
        this.mOffsetLeft = i11;
        updateOffsets();
        return true;
    }

    public boolean setTopAndBottomOffset(int i11) {
        if (this.mOffsetTop == i11) {
            return false;
        }
        this.mOffsetTop = i11;
        updateOffsets();
        return true;
    }
}
