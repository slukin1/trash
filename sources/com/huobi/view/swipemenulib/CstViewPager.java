package com.huobi.view.swipemenulib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class CstViewPager extends ViewPager {
    private static final String TAG = "zxt/CstViewPager";
    private int mLastX;
    private int mLastY;

    public CstViewPager(Context context) {
        super(context);
    }

    private boolean isHorizontalScroll(int i11, int i12) {
        return Math.abs(i12 - this.mLastY) < Math.abs(i11 - this.mLastX);
    }

    private boolean isReachLastPage() {
        PagerAdapter adapter = getAdapter();
        return adapter != null && adapter.getCount() - 1 == getCurrentItem();
    }

    private boolean isReactFirstPage() {
        return getCurrentItem() == 0;
    }

    private boolean isScrollLeft(int i11) {
        return i11 - this.mLastX < 0;
    }

    private boolean isScrollRight(int i11) {
        return i11 - this.mLastX > 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int x11 = (int) motionEvent.getX();
        int y11 = (int) motionEvent.getY();
        boolean z11 = motionEvent.getAction() == 2 && isHorizontalScroll(x11, y11) && (!isReactFirstPage() || !isScrollRight(x11)) && (!isReachLastPage() || !isScrollLeft(x11));
        this.mLastX = x11;
        this.mLastY = y11;
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (z11 || onInterceptTouchEvent) {
            return true;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public CstViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
