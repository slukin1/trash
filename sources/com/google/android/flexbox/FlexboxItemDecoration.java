package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    private static final int[] LIST_DIVIDER_ATTRS = {16843284};
    public static final int VERTICAL = 2;
    private Drawable mDrawable;
    private int mOrientation;

    public FlexboxItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(LIST_DIVIDER_ATTRS);
        this.mDrawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    private void drawHorizontalDecorations(Canvas canvas, RecyclerView recyclerView) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (needsHorizontalDecoration()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int right = recyclerView.getRight() + recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt = recyclerView.getChildAt(i18);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    i12 = childAt.getBottom() + layoutParams.bottomMargin;
                    i11 = this.mDrawable.getIntrinsicHeight() + i12;
                } else {
                    i11 = childAt.getTop() - layoutParams.topMargin;
                    i12 = i11 - this.mDrawable.getIntrinsicHeight();
                }
                if (!flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    i15 = childAt.getLeft() - layoutParams.leftMargin;
                    i17 = childAt.getRight();
                    i16 = layoutParams.rightMargin;
                } else if (flexboxLayoutManager.isLayoutRtl()) {
                    i13 = Math.min(childAt.getRight() + layoutParams.rightMargin + this.mDrawable.getIntrinsicWidth(), right);
                    i14 = childAt.getLeft() - layoutParams.leftMargin;
                    this.mDrawable.setBounds(i14, i12, i13, i11);
                    this.mDrawable.draw(canvas);
                } else {
                    i15 = Math.max((childAt.getLeft() - layoutParams.leftMargin) - this.mDrawable.getIntrinsicWidth(), left);
                    i17 = childAt.getRight();
                    i16 = layoutParams.rightMargin;
                }
                int i19 = i15;
                i13 = i17 + i16;
                i14 = i19;
                this.mDrawable.setBounds(i14, i12, i13, i11);
                this.mDrawable.draw(canvas);
            }
        }
    }

    private void drawVerticalDecorations(Canvas canvas, RecyclerView recyclerView) {
        int i11;
        int i12;
        int i13;
        int i14;
        int bottom;
        int i15;
        if (needsVerticalDecoration()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom() + recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = recyclerView.getChildAt(i16);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.isLayoutRtl()) {
                    i12 = childAt.getRight() + layoutParams.rightMargin;
                    i11 = this.mDrawable.getIntrinsicWidth() + i12;
                } else {
                    i11 = childAt.getLeft() - layoutParams.leftMargin;
                    i12 = i11 - this.mDrawable.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    i13 = childAt.getTop() - layoutParams.topMargin;
                    bottom = childAt.getBottom();
                    i15 = layoutParams.bottomMargin;
                } else if (flexDirection == 3) {
                    int min = Math.min(childAt.getBottom() + layoutParams.bottomMargin + this.mDrawable.getIntrinsicHeight(), bottom2);
                    i13 = childAt.getTop() - layoutParams.topMargin;
                    i14 = min;
                    this.mDrawable.setBounds(i12, i13, i11, i14);
                    this.mDrawable.draw(canvas);
                } else {
                    i13 = Math.max((childAt.getTop() - layoutParams.topMargin) - this.mDrawable.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i15 = layoutParams.bottomMargin;
                }
                i14 = bottom + i15;
                this.mDrawable.setBounds(i12, i13, i11, i14);
                this.mDrawable.draw(canvas);
            }
        }
    }

    private boolean isFirstItemInLine(int i11, List<FlexLine> list, FlexboxLayoutManager flexboxLayoutManager) {
        int positionToFlexLineIndex = flexboxLayoutManager.getPositionToFlexLineIndex(i11);
        if ((positionToFlexLineIndex != -1 && positionToFlexLineIndex < flexboxLayoutManager.getFlexLinesInternal().size() && flexboxLayoutManager.getFlexLinesInternal().get(positionToFlexLineIndex).mFirstIndex == i11) || i11 == 0) {
            return true;
        }
        if (list.size() == 0) {
            return false;
        }
        if (list.get(list.size() - 1).mLastIndex == i11 - 1) {
            return true;
        }
        return false;
    }

    private boolean needsHorizontalDecoration() {
        return (this.mOrientation & 1) > 0;
    }

    private boolean needsVerticalDecoration() {
        return (this.mOrientation & 2) > 0;
    }

    private void setOffsetAlongCrossAxis(Rect rect, int i11, FlexboxLayoutManager flexboxLayoutManager, List<FlexLine> list) {
        if (list.size() != 0 && flexboxLayoutManager.getPositionToFlexLineIndex(i11) != 0) {
            if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                if (!needsHorizontalDecoration()) {
                    rect.top = 0;
                    rect.bottom = 0;
                    return;
                }
                rect.top = this.mDrawable.getIntrinsicHeight();
                rect.bottom = 0;
            } else if (needsVerticalDecoration()) {
                if (flexboxLayoutManager.isLayoutRtl()) {
                    rect.right = this.mDrawable.getIntrinsicWidth();
                    rect.left = 0;
                    return;
                }
                rect.left = this.mDrawable.getIntrinsicWidth();
                rect.right = 0;
            }
        }
    }

    private void setOffsetAlongMainAxis(Rect rect, int i11, FlexboxLayoutManager flexboxLayoutManager, List<FlexLine> list, int i12) {
        if (!isFirstItemInLine(i11, list, flexboxLayoutManager)) {
            if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                if (!needsVerticalDecoration()) {
                    rect.left = 0;
                    rect.right = 0;
                } else if (flexboxLayoutManager.isLayoutRtl()) {
                    rect.right = this.mDrawable.getIntrinsicWidth();
                    rect.left = 0;
                } else {
                    rect.left = this.mDrawable.getIntrinsicWidth();
                    rect.right = 0;
                }
            } else if (!needsHorizontalDecoration()) {
                rect.top = 0;
                rect.bottom = 0;
            } else if (i12 == 3) {
                rect.bottom = this.mDrawable.getIntrinsicHeight();
                rect.top = 0;
            } else {
                rect.top = this.mDrawable.getIntrinsicHeight();
                rect.bottom = 0;
            }
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != 0) {
            if (needsHorizontalDecoration() || needsVerticalDecoration()) {
                FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
                List<FlexLine> flexLines = flexboxLayoutManager.getFlexLines();
                setOffsetAlongMainAxis(rect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
                setOffsetAlongCrossAxis(rect, childAdapterPosition, flexboxLayoutManager, flexLines);
                return;
            }
            rect.set(0, 0, 0, 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        drawHorizontalDecorations(canvas, recyclerView);
        drawVerticalDecorations(canvas, recyclerView);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mDrawable = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int i11) {
        this.mOrientation = i11;
    }
}
