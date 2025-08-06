package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;

public class WrapContentHeightViewPager extends ViewPager {
    private int current;
    private int height = 0;
    private boolean scrollble = true;

    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public boolean isScrollble() {
        return this.scrollble;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.scrollble && super.onInterceptTouchEvent(motionEvent);
    }

    public void onMeasure(int i11, int i12) {
        int childCount = getChildCount();
        int i13 = this.current;
        if (childCount > i13) {
            View childAt = getChildAt(i13);
            childAt.measure(i11, View.MeasureSpec.makeMeasureSpec(0, 0));
            this.height = childAt.getMeasuredHeight();
        }
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.scrollble) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void resetHeight(int i11) {
        this.current = i11;
        if (getChildCount() > i11) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, this.height);
            } else {
                layoutParams.height = this.height;
            }
            setLayoutParams(layoutParams);
        }
    }

    public void setScrollble(boolean z11) {
        this.scrollble = z11;
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
