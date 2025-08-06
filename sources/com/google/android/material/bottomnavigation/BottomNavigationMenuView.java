package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.core.view.h0;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;
    private int[] tempChildWidths = new int[5];

    public BottomNavigationMenuView(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    }

    public NavigationBarItemView createNavigationBarItemView(Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int childCount = getChildCount();
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                if (h0.F(this) == 1) {
                    int i19 = i15 - i17;
                    childAt.layout(i19 - childAt.getMeasuredWidth(), 0, i19, i16);
                } else {
                    childAt.layout(i17, 0, childAt.getMeasuredWidth() + i17, i16);
                }
                i17 += childAt.getMeasuredWidth();
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        e menu = getMenu();
        int size = View.MeasureSpec.getSize(i11);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
        if (!isShifting(getLabelVisibilityMode(), size2) || !isItemHorizontalTranslationEnabled()) {
            int min = Math.min(size / (size2 == 0 ? 1 : size2), this.activeItemMaxWidth);
            int i13 = size - (size2 * min);
            for (int i14 = 0; i14 < childCount; i14++) {
                if (getChildAt(i14).getVisibility() != 8) {
                    int[] iArr = this.tempChildWidths;
                    iArr[i14] = min;
                    if (i13 > 0) {
                        iArr[i14] = iArr[i14] + 1;
                        i13--;
                    }
                } else {
                    this.tempChildWidths[i14] = 0;
                }
            }
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            int i15 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                i15 = Math.max(i15, childAt.getMeasuredWidth());
            }
            int i16 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.inactiveItemMinWidth * i16), Math.min(i15, this.activeItemMaxWidth));
            int i17 = size - min2;
            int min3 = Math.min(i17 / (i16 == 0 ? 1 : i16), this.inactiveItemMaxWidth);
            int i18 = i17 - (i16 * min3);
            int i19 = 0;
            while (i19 < childCount) {
                if (getChildAt(i19).getVisibility() != 8) {
                    this.tempChildWidths[i19] = i19 == getSelectedItemPosition() ? min2 : min3;
                    if (i18 > 0) {
                        int[] iArr2 = this.tempChildWidths;
                        iArr2[i19] = iArr2[i19] + 1;
                        i18--;
                    }
                } else {
                    this.tempChildWidths[i19] = 0;
                }
                i19++;
            }
        }
        int i21 = 0;
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt2 = getChildAt(i22);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[i22], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i21 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i21, View.MeasureSpec.makeMeasureSpec(i21, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, makeMeasureSpec, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z11) {
        this.itemHorizontalTranslationEnabled = z11;
    }
}
