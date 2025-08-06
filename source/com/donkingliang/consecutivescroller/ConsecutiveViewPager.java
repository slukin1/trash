package com.donkingliang.consecutivescroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.h0;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;
import n4.a;

public class ConsecutiveViewPager extends ViewPager implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f64930b;

    public ConsecutiveViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        view.setOverScrollMode(2);
        h0.N0(view, false);
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i11, layoutParams);
        if (ScrollUtils.q(this)) {
            a(view);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipToPadding(false);
            }
        }
    }

    public final boolean b() {
        ViewParent parent = getParent();
        if (!(parent instanceof ConsecutiveScrollerLayout)) {
            return false;
        }
        ConsecutiveScrollerLayout consecutiveScrollerLayout = (ConsecutiveScrollerLayout) parent;
        if (consecutiveScrollerLayout.indexOfChild(this) == consecutiveScrollerLayout.getChildCount() - 1) {
            return true;
        }
        return false;
    }

    public int getAdjustHeight() {
        return this.f64930b;
    }

    public View getCurrentScrollerView() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getX() == ((float) (getScrollX() + getPaddingLeft()))) {
                return childAt;
            }
        }
        return this;
    }

    public List<View> getScrolledViews() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i11 = 0; i11 < childCount; i11++) {
                arrayList.add(getChildAt(i11));
            }
        }
        return arrayList;
    }

    public void onMeasure(int i11, int i12) {
        if (!b() || this.f64930b <= 0) {
            super.onMeasure(i11, i12);
        } else {
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(ViewGroup.getDefaultSize(0, i12) - this.f64930b, View.MeasureSpec.getMode(i12)));
        }
    }

    public void setAdjustHeight(int i11) {
        if (this.f64930b != i11) {
            this.f64930b = i11;
            requestLayout();
        }
    }
}
