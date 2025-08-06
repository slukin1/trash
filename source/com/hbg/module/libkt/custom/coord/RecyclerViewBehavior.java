package com.hbg.module.libkt.custom.coord;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

public final class RecyclerViewBehavior extends AppBarLayout.ScrollingViewBehavior {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f24774a;

    public RecyclerViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final RecyclerView b(View view) {
        RecyclerView b11;
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
                if (viewGroup2 != null && (b11 = b(viewGroup2)) != null) {
                    return b11;
                }
            }
        }
        return null;
    }

    public final boolean c(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return motionEvent.getRawY() > ((float) iArr[1]);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && !c(view, motionEvent)) {
            RecyclerView recyclerView = this.f24774a;
            if (recyclerView == null) {
                recyclerView = b(view);
            }
            if (recyclerView != null) {
                recyclerView.stopNestedScroll();
                recyclerView.stopScroll();
                this.f24774a = recyclerView;
            }
        }
        return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
