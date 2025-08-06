package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class NoAnimationViewPager extends ViewPager {
    private boolean scrollable = false;

    public NoAnimationViewPager(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.scrollable;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.scrollable;
    }

    public void setCurrentItem(int i11, boolean z11) {
        super.setCurrentItem(i11, z11);
    }

    public void setCurrentItem(int i11) {
        super.setCurrentItem(i11, false);
    }

    public NoAnimationViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
