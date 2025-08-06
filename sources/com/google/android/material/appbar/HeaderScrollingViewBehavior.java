package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.f;
import androidx.core.view.h0;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;
import x0.a;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private int overlayTop;
    public final Rect tempRect1 = new Rect();
    public final Rect tempRect2 = new Rect();
    private int verticalLayoutGap = 0;

    public HeaderScrollingViewBehavior() {
    }

    private static int resolveGravity(int i11) {
        return i11 == 0 ? BadgeDrawable.TOP_START : i11;
    }

    public abstract View findFirstDependency(List<View> list);

    public final int getOverlapPixelsForOffset(View view) {
        if (this.overlayTop == 0) {
            return 0;
        }
        float overlapRatioForOffset = getOverlapRatioForOffset(view);
        int i11 = this.overlayTop;
        return a.c((int) (overlapRatioForOffset * ((float) i11)), 0, i11);
    }

    public float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }

    public int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i11) {
        View findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        if (findFirstDependency != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.tempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, findFirstDependency.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((coordinatorLayout.getHeight() + findFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && h0.C(coordinatorLayout) && !h0.C(view)) {
                rect.left += lastWindowInsets.k();
                rect.right -= lastWindowInsets.l();
            }
            Rect rect2 = this.tempRect2;
            f.a(resolveGravity(layoutParams.f8114c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i11);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(findFirstDependency);
            view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            this.verticalLayoutGap = rect2.top - findFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i11);
        this.verticalLayoutGap = 0;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i11, int i12, int i13, int i14) {
        View findFirstDependency;
        WindowInsetsCompat lastWindowInsets;
        int i15 = view.getLayoutParams().height;
        if ((i15 != -1 && i15 != -2) || (findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i13);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (h0.C(findFirstDependency) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.m() + lastWindowInsets.j();
        }
        int scrollRange = size + getScrollRange(findFirstDependency);
        int measuredHeight = findFirstDependency.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild()) {
            view.setTranslationY((float) (-measuredHeight));
        } else {
            scrollRange -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i11, i12, View.MeasureSpec.makeMeasureSpec(scrollRange, i15 == -1 ? 1073741824 : Integer.MIN_VALUE), i14);
        return true;
    }

    public final void setOverlayTop(int i11) {
        this.overlayTop = i11;
    }

    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
