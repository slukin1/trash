package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class NoScrollViewPager extends ViewPager {
    private boolean noScroll = true;

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.noScroll) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
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

    public NoScrollViewPager(Context context) {
        super(context);
    }
}
