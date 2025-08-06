package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.d0;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationRailView extends NavigationBarView {
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    public static final int DEFAULT_MENU_GRAVITY = 49;
    public static final int MAX_ITEM_COUNT = 7;
    private View headerView;
    private final int topMargin;

    public NavigationRailView(Context context) {
        this(context, (AttributeSet) null);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private boolean isHeaderViewVisible() {
        View view = this.headerView;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int makeMinWidthSpec(int i11) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i11) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i11;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i11), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    public void addHeaderView(int i11) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i11, this, false));
    }

    public View getHeaderView() {
        return this.headerView;
    }

    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i15 = 0;
        if (isHeaderViewVisible()) {
            int bottom = this.headerView.getBottom() + this.topMargin;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i15 = bottom - top;
            }
        } else if (navigationRailMenuView.isTopGravity()) {
            i15 = this.topMargin;
        }
        if (i15 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i15, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i15);
        }
    }

    public void onMeasure(int i11, int i12) {
        int makeMinWidthSpec = makeMinWidthSpec(i11);
        super.onMeasure(makeMinWidthSpec, i12);
        if (isHeaderViewVisible()) {
            measureChild(getNavigationRailMenuView(), makeMinWidthSpec, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.headerView.getMeasuredHeight()) - this.topMargin, Integer.MIN_VALUE));
        }
    }

    public void removeHeaderView() {
        View view = this.headerView;
        if (view != null) {
            removeView(view);
            this.headerView = null;
        }
    }

    public void setMenuGravity(int i11) {
        getNavigationRailMenuView().setMenuGravity(i11);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public void addHeaderView(View view) {
        removeHeaderView();
        this.headerView = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.topMargin;
        addView(view, 0, layoutParams);
    }

    public NavigationRailMenuView createNavigationBarMenuView(Context context) {
        return new NavigationRailMenuView(context);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.topMargin = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        d0 obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(getContext(), attributeSet, R.styleable.NavigationRailView, i11, i12, new int[0]);
        int n11 = obtainTintedStyledAttributes.n(R.styleable.NavigationRailView_headerLayout, 0);
        if (n11 != 0) {
            addHeaderView(n11);
        }
        setMenuGravity(obtainTintedStyledAttributes.k(R.styleable.NavigationRailView_menuGravity, 49));
        obtainTintedStyledAttributes.w();
    }
}
