package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FlexLine {
    public boolean mAnyItemsHaveFlexGrow;
    public boolean mAnyItemsHaveFlexShrink;
    public int mBottom = Integer.MIN_VALUE;
    public int mCrossSize;
    public int mDividerLengthInMainSize;
    public int mFirstIndex;
    public int mGoneItemCount;
    public List<Integer> mIndicesAlignSelfStretch = new ArrayList();
    public int mItemCount;
    public int mLastIndex;
    public int mLeft = Integer.MAX_VALUE;
    public int mMainSize;
    public int mMaxBaseline;
    public int mRight = Integer.MIN_VALUE;
    public int mSumCrossSizeBefore;
    public int mTop = Integer.MAX_VALUE;
    public float mTotalFlexGrow;
    public float mTotalFlexShrink;

    public int getCrossSize() {
        return this.mCrossSize;
    }

    public int getFirstIndex() {
        return this.mFirstIndex;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int getItemCountNotGone() {
        return this.mItemCount - this.mGoneItemCount;
    }

    public int getMainSize() {
        return this.mMainSize;
    }

    public float getTotalFlexGrow() {
        return this.mTotalFlexGrow;
    }

    public float getTotalFlexShrink() {
        return this.mTotalFlexShrink;
    }

    public void updatePositionFromView(View view, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.mLeft = Math.min(this.mLeft, (view.getLeft() - flexItem.getMarginLeft()) - i11);
        this.mTop = Math.min(this.mTop, (view.getTop() - flexItem.getMarginTop()) - i12);
        this.mRight = Math.max(this.mRight, view.getRight() + flexItem.getMarginRight() + i13);
        this.mBottom = Math.max(this.mBottom, view.getBottom() + flexItem.getMarginBottom() + i14);
    }
}
