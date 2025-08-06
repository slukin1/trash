package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

public class NavigationRailMenuView extends NavigationBarMenuView {
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams2;
        layoutParams2.gravity = 49;
        setLayoutParams(layoutParams2);
    }

    private int makeSharedHeightSpec(int i11, int i12, int i13) {
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), i12 / Math.max(1, i13)), 0);
    }

    private int measureChildHeight(View view, int i11, int i12) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i11, i12);
        return view.getMeasuredHeight();
    }

    private int measureSharedChildHeights(int i11, int i12, int i13, View view) {
        int i14;
        makeSharedHeightSpec(i11, i12, i13);
        if (view == null) {
            i14 = makeSharedHeightSpec(i11, i12, i13);
        } else {
            i14 = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt != view) {
                i15 += measureChildHeight(childAt, i11, i14);
            }
        }
        return i15;
    }

    private int measureShiftingChildHeights(int i11, int i12, int i13) {
        int i14;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i14 = measureChildHeight(childAt, i11, makeSharedHeightSpec(i11, i12, i13));
            i12 -= i14;
            i13--;
        } else {
            i14 = 0;
        }
        return i14 + measureSharedChildHeights(i11, i12, i13, childAt);
    }

    public NavigationBarItemView createNavigationBarItemView(Context context) {
        return new NavigationRailItemView(context);
    }

    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    public boolean isTopGravity() {
        return (this.layoutParams.gravity & 112) == 48;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int i15 = i13 - i11;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i16;
                childAt.layout(0, i16, i15, measuredHeight);
                i16 = measuredHeight;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int size = View.MeasureSpec.getSize(i12);
        int size2 = getMenu().getVisibleItems().size();
        if (size2 <= 1 || !isShifting(getLabelVisibilityMode(), size2)) {
            i13 = measureSharedChildHeights(i11, size, size2, (View) null);
        } else {
            i13 = measureShiftingChildHeights(i11, size, size2);
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i11), i11, 0), View.resolveSizeAndState(i13, i12, 0));
    }

    public void setMenuGravity(int i11) {
        FrameLayout.LayoutParams layoutParams2 = this.layoutParams;
        if (layoutParams2.gravity != i11) {
            layoutParams2.gravity = i11;
            setLayoutParams(layoutParams2);
        }
    }
}
