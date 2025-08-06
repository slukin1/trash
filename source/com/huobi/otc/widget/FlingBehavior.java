package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.h0;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;

public class FlingBehavior extends AppBarLayout.Behavior {
    public FlingBehavior() {
    }

    public final Field getScrollerField() throws Exception {
        try {
            return getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("scroller");
        } catch (NoSuchFieldException unused) {
            return getClass().getSuperclass().getSuperclass().getDeclaredField("mScroller");
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view, motionEvent);
    }

    public void stopScrollerAnimation() {
        try {
            Field scrollerField = getScrollerField();
            scrollerField.setAccessible(true);
            Object obj = scrollerField.get(this);
            if (obj instanceof OverScroller) {
                ((OverScroller) obj).abortAnimation();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public FlingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            stopScrollerAnimation();
        }
        return super.onInterceptTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 == 1 && getTopAndBottomOffset() == 0) {
            h0.Z0(view, i13);
        }
        super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i11, i12, iArr, i13);
    }
}
