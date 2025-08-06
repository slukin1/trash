package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class WrapContentNoScrollViewPager extends ViewPager {
    private boolean noScroll = true;

    public WrapContentNoScrollViewPager(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.noScroll) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        if (getLayoutParams() == null || getLayoutParams().height <= 0) {
            int i15 = 0;
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                View childAt = getChildAt(i16);
                if (childAt.getLayoutParams() == null || childAt.getLayoutParams().height <= 0) {
                    childAt.measure(i11, View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 0));
                    i14 = childAt.getMeasuredHeight();
                } else {
                    i14 = childAt.getLayoutParams().height;
                }
                if (i14 > i15) {
                    i15 = i14;
                }
            }
            i13 = i15;
        } else {
            i13 = getLayoutParams().height;
        }
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.noScroll) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollTo(int i11, int i12) {
        super.scrollTo(i11, i12);
    }

    public void setCurrentItem(int i11, boolean z11) {
        super.setCurrentItem(i11, z11);
    }

    public void setNoScroll(boolean z11) {
        this.noScroll = z11;
    }

    public void setCurrentItem(int i11) {
        super.setCurrentItem(i11);
    }

    public WrapContentNoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
