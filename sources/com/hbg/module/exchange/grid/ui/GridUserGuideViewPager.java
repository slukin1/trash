package com.hbg.module.exchange.grid.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.hbg.lib.common.utils.ViewPager;
import java.lang.reflect.Field;

public class GridUserGuideViewPager extends ViewPager {

    public class a extends Scroller {
        public a(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public void startScroll(int i11, int i12, int i13, int i14, int i15) {
            super.startScroll(i11, i12, i13, i14, 400);
        }

        public void startScroll(int i11, int i12, int i13, int i14) {
            super.startScroll(i11, i12, i13, i14, 400);
        }
    }

    public static class b implements ViewPager.h {
        public b() {
        }

        public void transformPage(View view, float f11) {
            if (f11 < -1.0f) {
                view.setAlpha(0.0f);
            } else if (f11 < 0.0f) {
                view.setAlpha(1.0f - Math.abs(f11));
            } else if (f11 <= 1.0f) {
                view.setAlpha(1.0f - f11);
            } else {
                view.setAlpha(0.0f);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public GridUserGuideViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        R(context);
    }

    private void setCustomScroller(Context context) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("k");
            declaredField.setAccessible(true);
            declaredField.set(this, new a(context, new DecelerateInterpolator()));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void L(int i11, boolean z11) {
        super.L(i11, z11);
    }

    public final void R(Context context) {
        O(true, new b((a) null));
        setCustomScroller(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onMeasure(int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            childAt.measure(i11, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i13) {
                i13 = measuredHeight;
            }
        }
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
