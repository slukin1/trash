package com.huochat.community.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class NoSwipeViewPager extends ViewPager {
    public NoSwipeViewPager(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public NoSwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
